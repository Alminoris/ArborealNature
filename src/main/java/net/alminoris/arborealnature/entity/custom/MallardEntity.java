package net.alminoris.arborealnature.entity.custom;

import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.sound.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;

public class MallardEntity extends AnimalEntity implements GeoEntity
{
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public MallardEntity(EntityType<? extends AnimalEntity> entityType, World world)
    {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
    }

    @Override
    public @Nullable ItemEntity dropStack(ItemStack stack)
    {
        return super.dropStack(stack);
    }

    @Override
    protected void dropLoot(DamageSource source, boolean causedByPlayer)
    {
        super.dropLoot(source, causedByPlayer);

        // Always drop 1 raw duck (or cooked if killed by fire)
        if (this.isOnFire())
        {
            this.dropStack(new ItemStack(ModItems.COOKED_DUCK, 1));
        }
        else
        {
            this.dropStack(new ItemStack(ModItems.DUCK, 1));
        }

        // 40% chance for 1–2 feathers
        if (this.random.nextFloat() < 0.40F)
        {
            this.dropStack(new ItemStack(Items.FEATHER, this.random.nextBetween(1, 2)));
        }

        // 10% chance for duck fat (optional rare item)
        /*if (this.random.nextFloat() < 0.10F) {
            this.dropStack(new ItemStack(ModItems.DUCK_FAT, 1));
        }*/
    }


    public static DefaultAttributeContainer.Builder setAttributes()
    {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D);
    }

    @Override
    protected void initGoals()
    {
        this.goalSelector.add(0, new MallardSwimInWaterGoal(this, 1.0D));
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(3, new TemptGoal(this, 1.0, stack -> stack.isIn(ItemTags.CHICKEN_FOOD), true));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.0D));
        this.goalSelector.add(5, new EscapeDangerGoal(this, 1.25D));
        this.goalSelector.add(6, new WanderAroundGoal(this, 1.0D));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 5.0F));

        super.initGoals();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return ModSounds.SOUND_MALLARD_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return ModSounds.SOUND_MALLARD_HURT;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return ModSounds.SOUND_MALLARD_DEATH;
    }

    @Override
    public void tickMovement()
    {
        super.tickMovement();

        if (this.isTouchingWater())
        {
            this.setVelocity(this.getVelocity().multiply(0.8, 1.0, 0.8));
        }
    }


    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return stack.isIn(ItemTags.CHICKEN_FOOD);
    }

    @Override
    public @Nullable MallardEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        return ModEntities.MALLARD.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar)
    {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, state ->
        {
            if (this.isTouchingWater() && !this.isOnGround())
            {
                if(state.isMoving())
                    return state.setAndContinue(RawAnimation.begin().then("swim", Animation.LoopType.LOOP));

                return state.setAndContinue(RawAnimation.begin().then("swim_idle", Animation.LoopType.LOOP));
            }

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

    static class MallardSwimInWaterGoal extends Goal
    {
        private final MobEntity mallard;
        private final double speed;
        private BlockPos targetWaterPos;

        public MallardSwimInWaterGoal(MobEntity mallard, double speed) {
            this.mallard = mallard;
            this.speed = speed;
        }

        @Override
        public boolean canStart()
        {
            // Already in water? Then continue
            if (mallard.isTouchingWater()) {
                return true;
            }

            // Try to find nearby water block
            BlockPos mobPos = mallard.getBlockPos();
            for (int i = 0; i < 10; i++) {
                BlockPos checkPos = mobPos.add(
                        mallard.getRandom().nextBetween(-6, 6),
                        mallard.getRandom().nextBetween(-2, 2),
                        mallard.getRandom().nextBetween(-6, 6)
                );
                if (mallard.getWorld().getBlockState(checkPos).getFluidState().isIn(FluidTags.WATER))
                {
                    targetWaterPos = checkPos;
                    return true;
                }
            }
            return false;
        }

        @Override
        public void start() {
            if (targetWaterPos != null) {
                mallard.getNavigation().startMovingTo(
                        targetWaterPos.getX() + 0.5,
                        targetWaterPos.getY() + 1.0, // move slightly above the water block
                        targetWaterPos.getZ() + 0.5,
                        speed
                );
            }
        }

        @Override
        public boolean shouldContinue() {
            return mallard.isTouchingWater();
        }
    }

}