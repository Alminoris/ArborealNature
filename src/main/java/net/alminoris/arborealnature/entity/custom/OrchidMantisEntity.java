package net.alminoris.arborealnature.entity.custom;

import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.sound.ModSounds;
import net.alminoris.arborealnature.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;

import java.util.EnumSet;

public class OrchidMantisEntity extends AnimalEntity implements GeoEntity
{
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public OrchidMantisEntity(EntityType<? extends AnimalEntity> entityType, World world)
    {
        super(entityType, world);
    }

    @Override
    public @Nullable ItemEntity dropStack(ItemStack stack)
    {
        return super.dropStack(stack);
    }

    @Override
    protected void dropLoot(DamageSource damageSource, boolean causedByPlayer)
    {
        super.dropLoot(damageSource, causedByPlayer);

        if (this.random.nextFloat() < 0.25F)
        {
            this.dropStack(new ItemStack(ModItems.ORCHID_MANTIS_INCISOR, (int) (Math.random() * 2)));
        }
    }

    public static boolean isValidNaturalSpawn(EntityType<? extends AnimalEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
        boolean bl = SpawnReason.isTrialSpawner(spawnReason) || isLightLevelValidForNaturalSpawn(world, pos);

        boolean isSpawnableBlock = world.getBlockState(pos.down()).isIn(BlockTags.ANIMALS_SPAWNABLE_ON);

        boolean hasFlowersNearby = false;
        BlockPos.Mutable mutablePos = new BlockPos.Mutable();

        for (int dx = -3; dx <= 3; dx++)
        {
            for (int dz = -3; dz <= 3; dz++)
            {
                mutablePos.set(pos.getX() + dx, pos.getY() - 1, pos.getZ() + dz);
                if (world.getBlockState(mutablePos.up()).isIn(ModTags.Blocks.ORCHID_MANTIS_FLOWERS))
                {
                    hasFlowersNearby = true;
                    break;
                }
            }
            if (hasFlowersNearby) break;
        }

        return isSpawnableBlock && hasFlowersNearby && bl;
    }


    public static DefaultAttributeContainer.Builder setAttributes()
    {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.5D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5D);
    }

    @Override
    protected void initGoals()
    {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new StayNearFlowersGoal(this, 1.0D));
        this.goalSelector.add(2, new OrchidMantisAttackGoal(this, 1.15D));
        this.goalSelector.add(3, new AnimalMateGoal(this, 1.1D));
        this.goalSelector.add(4, new TemptGoal(this, 1.0, stack -> stack.isOf(Items.RABBIT), false));
        this.goalSelector.add(5, new FollowParentGoal(this, 1.1));
        this.goalSelector.add(6, new WanderAroundGoal(this, 1.0D));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 5.0F));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return ModSounds.SOUND_ORCHID_MANTIS_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return ModSounds.SOUND_ORCHID_MANTIS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return ModSounds.SOUND_ORCHID_MANTIS_DEATH;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return stack.isOf(Items.RABBIT);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        return ModEntities.ORCHID_MANTIS.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar)
    {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, state ->
        {
            if (this.isAttacking())
                return state.setAndContinue(RawAnimation.begin().then("attack", Animation.LoopType.PLAY_ONCE));

            if(state.isMoving())
                return state.setAndContinue(RawAnimation.begin().then("run", Animation.LoopType.LOOP));

            return state.setAndContinue(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache()
    {
        return cache;
    }

    public static class StayNearFlowersGoal extends Goal
    {
        private final OrchidMantisEntity mantis;
        private final double speed;

        public StayNearFlowersGoal(OrchidMantisEntity mantis, double speed)
        {
            this.mantis = mantis;
            this.speed = speed;
            this.setControls(EnumSet.of(Control.MOVE));
        }

        @Override
        public boolean canStart()
        {
            return !isNearFlowers(this.mantis.getBlockPos(), this.mantis.getWorld());
        }

        @Override
        public void start()
        {
            BlockPos flowerPos = findNearestFlower(this.mantis.getBlockPos(), this.mantis.getWorld());
            if (flowerPos != null)
            {
                this.mantis.getNavigation().startMovingTo(
                        flowerPos.getX() + 0.5,
                        flowerPos.getY(),
                        flowerPos.getZ() + 0.5,
                        this.speed
                );
            }
        }

        @Override
        public boolean shouldContinue()
        {
            return !isNearFlowers(this.mantis.getBlockPos(), this.mantis.getWorld());
        }

        private boolean isNearFlowers(BlockPos pos, World world)
        {
            for (BlockPos checkPos : BlockPos.iterate(pos.add(-3, -1, -3), pos.add(3, 1, 3)))
            {
                BlockState state = world.getBlockState(checkPos);
                if (state.isIn(ModTags.Blocks.ORCHID_MANTIS_FLOWERS))
                {
                    return true;
                }
            }
            return false;
        }

        private BlockPos findNearestFlower(BlockPos pos, World world)
        {
            for (BlockPos checkPos : BlockPos.iterate(pos.add(-6, -1, -6), pos.add(6, 1, 6)))
            {
                BlockState state = world.getBlockState(checkPos);
                if (state.isIn(ModTags.Blocks.ORCHID_MANTIS_FLOWERS))
                {
                    return checkPos;
                }
            }
            return null;
        }
    }

    public static class OrchidMantisAttackGoal extends Goal
    {
        private final OrchidMantisEntity mantis;
        private final double runSpeed;
        private LivingEntity target;
        private int delayTicks;
        private boolean isInvisible;
        private boolean isRunning;

        public OrchidMantisAttackGoal(OrchidMantisEntity mantis, double runSpeed)
        {
            this.mantis = mantis;
            this.runSpeed = runSpeed;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.TARGET));
        }

        @Override
        public boolean canStart()
        {
            this.target = this.mantis.getTarget();
            return this.target != null && this.target.isAlive();
        }

        @Override
        public void start()
        {
            this.delayTicks = 100;
            this.isInvisible = false;
            this.isRunning = false;
        }

        @Override
        public void tick()
        {
            if (this.target == null) return;

            double distanceToTarget = this.mantis.squaredDistanceTo(this.target);

            this.mantis.getLookControl().lookAt(this.target, 30.0F, 30.0F);

            if (distanceToTarget > 25.0D)
            {
                this.mantis.getNavigation().stop();
                return;
            }

            if (!this.isRunning)
            {
                this.mantis.getNavigation().stop();

                if (this.delayTicks > 0)
                {
                    this.delayTicks--;

                    if (this.delayTicks <= 40 && !this.isInvisible)
                    {
                        this.mantis.setInvisible(true);
                        this.isInvisible = true;
                    }
                }
                else
                {
                    this.isRunning = true;
                    this.mantis.setInvisible(false);
                }
            }
            else
            {
                if (distanceToTarget > 2.0D)
                {
                    this.mantis.getNavigation().startMovingTo(this.target, this.runSpeed);
                }
                else
                {
                    this.mantis.tryAttack(this.target);
                }
            }
        }

        @Override
        public void stop()
        {
            this.mantis.setInvisible(false);
            this.target = null;
            this.isInvisible = false;
            this.isRunning = false;
            this.mantis.getNavigation().stop();
        }

        @Override
        public boolean shouldContinue()
        {
            return this.target != null && this.target.isAlive();
        }
    }
}


