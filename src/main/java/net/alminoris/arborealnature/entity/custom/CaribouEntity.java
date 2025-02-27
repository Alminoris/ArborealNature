package net.alminoris.arborealnature.entity.custom;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.sound.ModSounds;
import net.alminoris.arborealnature.util.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;

import java.util.function.Predicate;

public class CaribouEntity extends AbstractHorseEntity implements GeoEntity
{
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final EntityDimensions BABY_BASE_DIMENSIONS = ModEntities.CARIBOU
            .getDimensions()
            .withAttachments(EntityAttachments.builder().add(EntityAttachmentType.PASSENGER, 0.0F, ModEntities.CARIBOU.getHeight() + 0.125F, 0.0F))
            .scaled(0.5F);

    public static final Predicate<LivingEntity> BABY_CARIBOU_FILTER = LivingEntity::isBaby;

    public CaribouEntity(EntityType<? extends AbstractHorseEntity> entityType, World world)
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

        if (this.random.nextFloat() < 0.2F)
        {
            this.dropStack(new ItemStack(Items.LEATHER, random.nextInt(2)));
        }
    }

    public static DefaultAttributeContainer.Builder setAttributes()
    {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.25D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D)
                .add(EntityAttributes.GENERIC_JUMP_STRENGTH, 0.5D)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0D);
    }

    @Override
    protected void initGoals()
    {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 0.85D));
        this.goalSelector.add(2, new TemptGoal(this, 0.8, stack -> stack.isIn(ModTags.Items.CARIBOU_FOOD), false));
        this.goalSelector.add(3, new FollowParentGoal(this, 0.75D));
        this.goalSelector.add(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(5, new EscapeDangerGoal(this, 1.0D));
        this.goalSelector.add(6, new WanderAroundGoal(this, 0.75D));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 7.0F));

        this.targetSelector.add(1, (new RevengeGoal(this)));
        super.initGoals();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return ModSounds.SOUND_CARIBOU_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return ModSounds.SOUND_CARIBOU_HURT;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return ModSounds.SOUND_CARIBOU_DEATH;
    }

    @Override
    protected SoundEvent getAngrySound() {
        return ModSounds.SOUND_CARIBOU_ANGRY;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return stack.isIn(ModTags.Items.CARIBOU_FOOD);
    }

    @Override
    public @Nullable CaribouEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        return ModEntities.CARIBOU.create(world);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand)
    {
        boolean bl = !this.isBaby() && this.isTame() && player.shouldCancelInteraction();
        if (!this.hasPassengers() && !bl)
        {
            ItemStack itemStack = player.getStackInHand(hand);
            if (!itemStack.isEmpty())
            {
                if (this.isBreedingItem(itemStack))
                {
                    return this.interactHorse(player, itemStack);
                }

                if (!this.isTame())
                {

                    this.playAngrySound();
                    return ActionResult.success(this.getWorld().isClient);
                }
            }

            return super.interactMob(player, hand);
        }
        else
        {
            return super.interactMob(player, hand);
        }
    }

    public static boolean isValidNaturalSpawn(EntityType<? extends AnimalEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
        boolean bl = SpawnReason.isTrialSpawner(spawnReason) || isLightLevelValidForNaturalSpawn(world, pos);
        boolean isSpawnableBlock = world.getBlockState(pos.down()).isIn(ModTags.Blocks.CARIBOU_SPAWNABLE_ON);
        return isSpawnableBlock && bl;
    }

    @Override
    public EntityDimensions getBaseDimensions(EntityPose pose)
    {
        return this.isBaby() ? BABY_BASE_DIMENSIONS : super.getBaseDimensions(pose);
    }

    @Override
    protected Vec3d getPassengerAttachmentPos(Entity passenger, EntityDimensions dimensions, float scaleFactor)
    {
        return super.getPassengerAttachmentPos(passenger, dimensions, scaleFactor).add(new Vec3d(0.0, -0.30  * (double)scaleFactor, -0.15 * (double)scaleFactor)
                                .rotateY(-this.getYaw() * (float) (Math.PI / 180.0)));
    }

    @Override
    protected boolean receiveFood(PlayerEntity player, ItemStack item)
    {
        boolean bl = false;
        float f = 0.0F;
        int i = 0;
        int j = 0;
        if (item.isOf(ModBlocks.REINDEER_LICHEN_CARPET.asItem()))
        {
            f = 2.0F;
            i = 20;
            j = 3;
        }
        else if (item.isOf(Items.FERN))
        {
            f = 1.0F;
            i = 30;
            j = 3;
        }
        else if (item.isOf(Items.LARGE_FERN))
        {
            f = 20.0F;
            i = 120;
        }
        else if (item.isOf(ModBlocks.REINDEER_LICHEN.asItem()))
        {
            f = 4.0F;
            i = 60;
            j = 5;
            if (!this.getWorld().isClient && this.isTame() && this.getBreedingAge() == 0 && !this.isInLove())
            {
                bl = true;
                this.lovePlayer(player);
            }
        }

        if (this.getHealth() < this.getMaxHealth() && f > 0.0F)
        {
            this.heal(f);
            bl = true;
        }

        if (this.isBaby() && i > 0)
        {
            this.getWorld().addParticle(ParticleTypes.HAPPY_VILLAGER, this.getParticleX(1.0), this.getRandomBodyY() + 0.5, this.getParticleZ(1.0), 0.0, 0.0, 0.0);
            if (!this.getWorld().isClient)
            {
                this.growUp(i);
                bl = true;
            }
        }

        if (j > 0 && (bl || !this.isTame()) && this.getTemper() < this.getMaxTemper() && !this.getWorld().isClient)
        {
            this.addTemper(j);
            bl = true;
        }

        if (bl)
        {
            this.emitGameEvent(GameEvent.EAT);
        }

        return bl;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar)
    {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, state ->
        {
            if (this.isAngry())
                return state.setAndContinue(RawAnimation.begin().then("angry", Animation.LoopType.PLAY_ONCE));

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
        return 12;
    }
}