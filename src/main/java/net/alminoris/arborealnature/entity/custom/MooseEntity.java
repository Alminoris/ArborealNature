package net.alminoris.arborealnature.entity.custom;

import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.sound.ModSounds;
import net.alminoris.arborealnature.util.ModTags;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

public class MooseEntity extends AnimalEntity implements GeoEntity
{
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private static final int SIT_DURATION = 600;

    private static int sitInterval = 3600;
    private int sittingTimer = sitInterval;

    private static final TrackedData<Boolean> IS_SITTING = DataTracker.registerData(MooseEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public MooseEntity(EntityType<? extends AnimalEntity> entityType, World world)
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

        if (this.random.nextFloat() < 0.05F)
        {
            this.dropStack(new ItemStack(ModItems.MOOSE_HORN, random.nextInt(2)));
        }

        if (this.random.nextFloat() < 0.5F)
        {
            this.dropStack(new ItemStack(ModItems.MOOSE_VENISON, random.nextInt(5)));
        }

        if (this.random.nextFloat() < 0.25F)
        {
            this.dropStack(new ItemStack(Items.LEATHER, random.nextInt(3)));
        }
    }

    public static DefaultAttributeContainer.Builder setAttributes()
    {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D)
                .add(EntityAttributes.GENERIC_ARMOR, 5.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0D);
    }

    @Override
    protected void initGoals()
    {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 0.85D));
        this.goalSelector.add(2, new TemptGoal(this, 0.8, stack -> stack.isIn(ModTags.Items.MOOSE_FOOD), false));
        this.goalSelector.add(3, new FollowParentGoal(this, 0.75D));
        this.goalSelector.add(4, new MeleeAttackGoal(this, 1.0D, true)
        {
            @Override
            public boolean canStart()
            {
                return !MooseEntity.this.isSitting() && super.canStart();
            }
        });
        this.goalSelector.add(5, new EscapeDangerGoal(this, 1.0D));
        this.goalSelector.add(6, new WanderAroundGoal(this, 0.75D));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 7.0F));

        this.targetSelector.add(1, (new RevengeGoal(this)));
        super.initGoals();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return ModSounds.SOUND_MOOSE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return ModSounds.SOUND_MOOSE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return ModSounds.SOUND_MOOSE_DEATH;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return stack.isIn(ModTags.Items.MOOSE_FOOD);
    }

    @Override
    public @Nullable MooseEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        return ModEntities.MOOSE.create(world);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder)
    {
        super.initDataTracker(builder);
        builder.add(IS_SITTING, false);
    }

    public boolean isSitting()
    {
        return this.dataTracker.get(IS_SITTING);
    }

    public void setSitting(boolean sitting)
    {
        this.dataTracker.set(IS_SITTING, sitting);
        this.setPose(sitting ? EntityPose.SITTING : EntityPose.STANDING);

        if (sitting)
            this.getNavigation().stop();
    }


    @Override
    public void travel(Vec3d movementInput)
    {
        if (this.isSitting())
        {
            this.setVelocity(Vec3d.ZERO);
            return;
        }
        super.travel(movementInput);
    }

    @Override
    public void tickMovement()
    {
        if (this.isSitting())
        {
            this.bodyYaw = this.prevBodyYaw;
            return;
        }
        super.tickMovement();
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.getWorld().isClient)
        {
            sitInterval = 3600 + this.random.nextInt( 2401);

            if (!this.isSitting() && sittingTimer > 0)
            {
                sittingTimer--;
            }
            else if (!this.isSitting() && sittingTimer <= 0)
            {
                this.setSitting(true);
                sittingTimer = SIT_DURATION;
            }

            if (this.isSitting() && sittingTimer > 0)
            {
                sittingTimer--;
            }
            else if (this.isSitting() && sittingTimer <= 0)
            {
                this.setSitting(false);
                sittingTimer = sitInterval;
            }

            if (this.isSitting() && this.isTouchingWater())
            {
                this.setSitting(false);
                sittingTimer = sitInterval;
            }
        }
    }

    public static boolean isValidNaturalSpawn(EntityType<? extends AnimalEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
        boolean bl = SpawnReason.isTrialSpawner(spawnReason) || isLightLevelValidForNaturalSpawn(world, pos);
        boolean isSpawnableBlock = world.getBlockState(pos.down()).isIn(ModTags.Blocks.MOOSE_SPAWNABLE_ON);
        return isSpawnableBlock && bl;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar)
    {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, state ->
        {
            if (this.isSitting())
                return state.setAndContinue(RawAnimation.begin().then("sit", Animation.LoopType.PLAY_ONCE));

            if (this.isAttacking())
                return state.setAndContinue(RawAnimation.begin().then("attack", Animation.LoopType.PLAY_ONCE));

            if (state.isMoving())
                return state.setAndContinue(RawAnimation.begin().then("run", Animation.LoopType.LOOP));

            return state.setAndContinue(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        }));
    }

    @Override
    public EntityDimensions getBaseDimensions(EntityPose pose)
    {
        if (pose == EntityPose.SITTING)
            return EntityDimensions.changing(this.getType().getWidth(), this.getType().getHeight() - 0.5F);

        return super.getBaseDimensions(pose);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache()
    {
        return cache;
    }

    @Override
    public int getLimitPerChunk()
    {
        return 7;
    }
}