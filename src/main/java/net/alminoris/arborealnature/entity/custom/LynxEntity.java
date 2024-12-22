package net.alminoris.arborealnature.entity.custom;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.sound.ModSounds;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
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

import java.util.UUID;
import java.util.function.Predicate;

public class LynxEntity extends TameableEntity implements GeoEntity, Angerable
{
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private static final int SLEEPING_DURATION = 1260;

    private static int sleepInterval = 18000;
    private int sleepingTimer = sleepInterval;

    private static final TrackedData<Boolean> IS_SLEEPING = DataTracker.registerData(LynxEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Integer> ANGER_TIME = DataTracker.registerData(LynxEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public static final Predicate<LivingEntity> FOLLOW_TAMED_PREDICATE = entity ->
    {
        EntityType<?> entityType = entity.getType();
        return entityType == EntityType.CHICKEN || entityType == EntityType.RABBIT || entityType == EntityType.FOX;
    };

    private static final UniformIntProvider ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);
    @Nullable
    private UUID angryAt;

    public LynxEntity(EntityType<? extends TameableEntity> entityType, World world)
    {
        super(entityType, world);
        this.setTamed(false, false);
        this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, -1.0F);
        this.setPathfindingPenalty(PathNodeType.DANGER_POWDER_SNOW, -1.0F);
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

        if (this.random.nextFloat() < 0.2F)
        {
            this.dropStack(new ItemStack(ModBlocks.LYNX_HIDE, 1));
        }
    }

    public static DefaultAttributeContainer.Builder setAttributes()
    {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 25.0D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.3D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0D);
    }

    @Override
    protected void initGoals()
    {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new TameableEntity.TameableEscapeDangerGoal(1.5, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(4, new PounceAtTargetGoal(this, 0.7F));
        this.goalSelector.add(5, new MeleeAttackGoal(this, 1.2D, true)
        {
            @Override
            public boolean canStart()
            {
                return !LynxEntity.this.isSleeping() && super.canStart();
            }
        });
        this.goalSelector.add(6, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F));
        this.goalSelector.add(7, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(9, new LookAtEntityGoal(this, PlayerEntity.class, 12.0F));
        this.goalSelector.add(10, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, new RevengeGoal(this).setGroupRevenge());
        this.targetSelector.add(4, new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAngerAt));
        this.targetSelector.add(5, new UntamedActiveTargetGoal<>(this, AnimalEntity.class, false, FOLLOW_TAMED_PREDICATE));
        this.targetSelector.add(6, new UntamedActiveTargetGoal<>(this, TurtleEntity.class, false, TurtleEntity.BABY_TURTLE_ON_LAND_FILTER));
        this.targetSelector.add(7, new ActiveTargetGoal<>(this, ZombieEntity.class, false));
        this.targetSelector.add(8, new UniversalAngerGoal<>(this, true));

        super.initGoals();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        if (this.hasAngerTime())
        {
            return ModSounds.SOUND_LYNX_GROWL;
        }
        else if (this.random.nextInt(3) == 0)
        {
            return this.isTamed() && this.getHealth() < 20.0F ? ModSounds.SOUND_LYNX_WHINE : ModSounds.SOUND_LYNX_AMBIENT;
        }
        else
        {
            return ModSounds.SOUND_LYNX_AMBIENT;
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return ModSounds.SOUND_LYNX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return ModSounds.SOUND_LYNX_DEATH;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return stack.isIn(ItemTags.MEAT);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder)
    {
        super.initDataTracker(builder);
        builder.add(ANGER_TIME, 0);
        builder.add(IS_SLEEPING, false);
    }

    public boolean isSleeping()
    {
        return this.dataTracker.get(IS_SLEEPING);
    }

    public void setSleeping(boolean sleeping)
    {
        this.dataTracker.set(IS_SLEEPING, sleeping);
        this.setPose(sleeping ? EntityPose.SLEEPING : EntityPose.STANDING);

        if (sleeping)
            this.getNavigation().stop();
    }

    @Override
    public void travel(Vec3d movementInput)
    {
        if (this.isSleeping())
        {
            this.setVelocity(Vec3d.ZERO);
            return;
        }
        super.travel(movementInput);
    }

    @Override
    public void tickMovement()
    {
        if (this.isSleeping())
        {
            this.bodyYaw = this.prevBodyYaw;
            return;
        }

        super.tickMovement();

        if (!this.getWorld().isClient)
        {
            this.tickAngerLogic((ServerWorld)this.getWorld(), true);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.getWorld().isClient)
        {
            sleepInterval = 18000 + this.random.nextInt( 6001);

            if (!this.isSleeping() && sleepingTimer > 0)
            {
                sleepingTimer--;
            }
            else if (!this.isSleeping() && sleepingTimer <= 0)
            {
                this.setSleeping(true);
                sleepingTimer = SLEEPING_DURATION;
            }

            if (this.isSleeping() && sleepingTimer > 0)
            {
                sleepingTimer--;
            }
            else if (this.isSleeping() && sleepingTimer <= 0)
            {
                this.setSleeping(false);
                sleepingTimer = sleepInterval;
            }

            if (this.isSleeping() && this.isTouchingWater())
            {
                this.setSleeping(false);
                sleepingTimer = sleepInterval;
            }
        }
    }

    public static boolean isValidNaturalSpawn(EntityType<? extends AnimalEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
        boolean bl = SpawnReason.isTrialSpawner(spawnReason) || isLightLevelValidForNaturalSpawn(world, pos);

        boolean isSpawnableBlock = world.getBlockState(pos.down()).isIn(BlockTags.ANIMALS_SPAWNABLE_ON);

        boolean hasPlantsNearby = false;
        BlockPos.Mutable mutablePos = new BlockPos.Mutable();

        for (int dx = -3; dx <= 3; dx++)
        {
            for (int dz = -3; dz <= 3; dz++)
            {
                mutablePos.set(pos.getX() + dx, pos.getY() - 1, pos.getZ() + dz);
                if (world.getBlockState(mutablePos.up()).isOf(Blocks.TALL_GRASS))
                {
                    hasPlantsNearby = true;
                    break;
                }
            }
            if (hasPlantsNearby) break;
        }

        return isSpawnableBlock && hasPlantsNearby && bl;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar)
    {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, state ->
        {
            if (this.isInSittingPose())
                return state.setAndContinue(RawAnimation.begin().then("sit", Animation.LoopType.HOLD_ON_LAST_FRAME));

            if (this.isSleeping())
                return state.setAndContinue(RawAnimation.begin().then("sleeping", Animation.LoopType.PLAY_ONCE));

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
        if (pose == EntityPose.SLEEPING)
            return EntityDimensions.changing(this.getType().getWidth(), this.getType().getHeight() - 0.5F);

        return super.getBaseDimensions(pose);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache()
    {
        return cache;
    }

    @Override
    public int getMaxLookPitchChange() {
        return this.isInSittingPose() ? 20 : super.getMaxLookPitchChange();
    }

    @Override
    public boolean damage(DamageSource source, float amount)
    {
        if (this.isInvulnerableTo(source))
        {
            return false;
        }
        else
        {
            if (!this.getWorld().isClient)
                this.setSitting(false);

            return super.damage(source, amount);
        }
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand)
    {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!this.getWorld().isClient || this.isBaby() && this.isBreedingItem(itemStack))
        {
            if (this.isTamed())
            {
                if (this.isBreedingItem(itemStack) && this.getHealth() < this.getMaxHealth())
                {
                    itemStack.decrementUnlessCreative(1, player);
                    FoodComponent foodComponent = itemStack.get(DataComponentTypes.FOOD);
                    float f = foodComponent != null ? (float)foodComponent.nutrition() : 1.0F;
                    this.heal(2.0F * f);
                    return ActionResult.success(this.getWorld().isClient());
                }
                else
                {
                    ActionResult actionResult = super.interactMob(player, hand);
                    if (!actionResult.isAccepted() && this.isOwner(player))
                    {
                        this.setSitting(!this.isSitting());
                        this.jumping = false;
                        this.navigation.stop();
                        this.setTarget(null);
                        return ActionResult.SUCCESS_NO_ITEM_USED;
                    }
                    else
                    {
                        return actionResult;
                    }
                }
            }
            else if (itemStack.isOf(ModItems.MOOSE_VENISON) && !this.hasAngerTime() && !this.isSleeping())
            {
                itemStack.decrementUnlessCreative(1, player);
                this.tryTame(player);
                return ActionResult.SUCCESS;
            }
            else
            {
                return super.interactMob(player, hand);
            }
        }
        else
        {
            boolean bl = this.isOwner(player) || this.isTamed() || itemStack.isOf(ModItems.MOOSE_VENISON) && !this.isTamed() && !this.hasAngerTime();
            return bl ? ActionResult.CONSUME : ActionResult.PASS;
        }
    }

    private void tryTame(PlayerEntity player)
    {
        if (this.random.nextInt(3) == 0)
        {
            this.setOwner(player);
            this.navigation.stop();
            this.setTarget(null);
            this.setSitting(true);
            this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES);
        }
        else
        {
            this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_NEGATIVE_PLAYER_REACTION_PARTICLES);
        }
    }

    @Override
    public int getLimitPerChunk()
    {
        return 3;
    }

    @Override
    public int getAngerTime()
    {
        return this.dataTracker.get(ANGER_TIME);
    }

    @Override
    public void setAngerTime(int angerTime)
    {
        this.dataTracker.set(ANGER_TIME, angerTime);
    }

    @Override
    public void chooseRandomAngerTime()
    {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }

    @Nullable
    @Override
    public UUID getAngryAt()
    {
        return this.angryAt;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt)
    {
        this.angryAt = angryAt;
    }

    @Nullable
    public LynxEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity)
    {
        LynxEntity lynxEntity = ModEntities.LYNX.create(serverWorld);
        if (lynxEntity != null && passiveEntity instanceof LynxEntity lynxEntity2)
        {
            if (this.isTamed())
            {
                lynxEntity.setOwnerUuid(this.getOwnerUuid());
                lynxEntity.setTamed(true, true);
            }
        }

        return lynxEntity;
    }

    @Override
    public boolean canBreedWith(AnimalEntity other)
    {
        if (other == this)
            return false;
        else if (!this.isTamed())
            return false;
        else if (!(other instanceof LynxEntity lynxEntity))
            return false;
        else if (!lynxEntity.isTamed())
            return false;
        else
            return !lynxEntity.isSleeping() && !lynxEntity.isInSittingPose() && this.isInLove() && lynxEntity.isInLove();
    }

    @Override
    public boolean canAttackWithOwner(LivingEntity target, LivingEntity owner)
    {
        if (target instanceof CreeperEntity || target instanceof GhastEntity || target instanceof ArmorStandEntity)
        {
            return false;
        }
        else if (target instanceof LynxEntity lynxEntity)
        {
            return !lynxEntity.isTamed() || lynxEntity.getOwner() != owner;
        }
        else
        {
            if (target instanceof PlayerEntity playerEntity && owner instanceof PlayerEntity playerEntity2 &&
                    !playerEntity2.shouldDamagePlayer(playerEntity))
                return false;

            if (target instanceof AbstractHorseEntity abstractHorseEntity && abstractHorseEntity.isTame())
                return false;

            return !(target instanceof TameableEntity tameableEntity) || !tameableEntity.isTamed();
        }
    }

    @Override
    public boolean canBeLeashed() {
        return !this.hasAngerTime();
    }

    @Override
    public Vec3d getLeashOffset()
    {
        return new Vec3d(0.0D, 0.6D * this.getStandingEyeHeight(), this.getWidth() * 0.4D);
    }

    @Override
    protected float getSoundVolume() {
        return 0.5F;
    }
}