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
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;

public class WolverineEntity extends AnimalEntity implements GeoEntity
{
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private static final int RELAX_DURATION = 330;

    private static int relaxInterval = 4800;
    private int relaxingTimer = relaxInterval;

    private static final TrackedData<Boolean> IS_RELAXING = DataTracker.registerData(WolverineEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public WolverineEntity(EntityType<? extends AnimalEntity> entityType, World world)
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
            this.dropStack(new ItemStack(ModItems.WOLVERINE_PAW, random.nextInt(2)));
        }
    }

    public static DefaultAttributeContainer.Builder setAttributes()
    {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.5D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4D)
                .add(EntityAttributes.GENERIC_ARMOR, 1.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0D);
    }

    @Override
    protected void initGoals()
    {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 0.85D));
        this.goalSelector.add(2, new TemptGoal(this, 0.8, Ingredient.fromTag(ModTags.Items.WOLVERINE_FOOD), false));
        this.goalSelector.add(3, new FollowParentGoal(this, 0.75D));
        this.goalSelector.add(4, new MeleeAttackGoal(this, 1.0D, true)
        {
            @Override
            public boolean canStart()
            {
                return !WolverineEntity.this.isRelaxing() && super.canStart();
            }
        });
        this.goalSelector.add(5, new EscapeDangerGoal(this, 1.0D));
        this.goalSelector.add(6, new WanderAroundGoal(this, 0.75D));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 7.0F));

        this.targetSelector.add(1, (new RevengeGoal(this)));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, RabbitEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, CaribouEntity.class, false, CaribouEntity.BABY_CARIBOU_FILTER));
        super.initGoals();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return ModSounds.SOUND_WOLVERINE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return ModSounds.SOUND_WOLVERINE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return ModSounds.SOUND_WOLVERINE_DEATH;
    }

    @Override
    public void playAmbientSound()
    {
        if (this.random.nextInt(100) == 0) this.playSound(ModSounds.SOUND_WOLVERINE_AMBIENT_PLUS, 1.0f, 1.0f);
        else super.playAmbientSound();
    }

    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return stack.isIn(ModTags.Items.WOLVERINE_FOOD);
    }

    @Override
    public @Nullable WolverineEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        return ModEntities.WOLVERINE.create(world);
    }

    @Override
    protected void initDataTracker()
    {
        super.initDataTracker();
        this.dataTracker.startTracking(IS_RELAXING, false);
    }

    public boolean isRelaxing()
    {
        return this.dataTracker.get(IS_RELAXING);
    }

    public void setRelaxing(boolean sitting)
    {
        this.dataTracker.set(IS_RELAXING, sitting);
        this.setPose(sitting ? EntityPose.SITTING : EntityPose.STANDING);

        if (sitting)
            this.getNavigation().stop();
    }


    @Override
    public void travel(Vec3d movementInput)
    {
        if (this.isRelaxing())
        {
            this.setVelocity(Vec3d.ZERO);
            return;
        }
        super.travel(movementInput);
    }

    @Override
    public void tickMovement()
    {
        if (this.isRelaxing())
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
            relaxInterval = 4800 + this.random.nextInt( 1201);

            if (!this.isRelaxing() && relaxingTimer > 0)
            {
                relaxingTimer--;
            }
            else if (!this.isRelaxing() && relaxingTimer <= 0)
            {
                this.setRelaxing(true);
                relaxingTimer = RELAX_DURATION;
            }

            if (this.isRelaxing() && relaxingTimer > 0)
            {
                relaxingTimer--;
            }
            else if (this.isRelaxing() && relaxingTimer <= 0)
            {
                this.setRelaxing(false);
                relaxingTimer = relaxInterval;
            }

            if (this.isRelaxing() && this.isTouchingWater())
            {
                this.setRelaxing(false);
                relaxingTimer = relaxInterval;
            }
        }
    }

    public static boolean isValidNaturalSpawn(EntityType<? extends AnimalEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
        boolean bl = isLightLevelValidForNaturalSpawn(world, pos);
        boolean isSpawnableBlock = world.getBlockState(pos.down()).isIn(ModTags.Blocks.WOLVERINE_SPAWNABLE_ON);
        return isSpawnableBlock && bl;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar)
    {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, state ->
        {
            if (this.isRelaxing())
                return state.setAndContinue(RawAnimation.begin().then("relax", Animation.LoopType.PLAY_ONCE));

            if (this.isAttacking())
                return state.setAndContinue(RawAnimation.begin().then("attack", Animation.LoopType.PLAY_ONCE));

            if (state.isMoving())
                return state.setAndContinue(RawAnimation.begin().then("run", Animation.LoopType.LOOP));

            return state.setAndContinue(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        }));
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