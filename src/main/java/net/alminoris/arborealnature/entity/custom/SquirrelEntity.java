package net.alminoris.arborealnature.entity.custom;

import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.entity.custom.ai.goal.EatHeldItemGoal;
import net.alminoris.arborealnature.entity.custom.ai.goal.PickUpItemGoal;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.sound.ModSounds;
import net.alminoris.arborealnature.util.ModTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;

public class SquirrelEntity extends AnimalEntity implements GeoEntity
{
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private boolean isPickUp = false;

    public SquirrelEntity(EntityType<? extends AnimalEntity> entityType, World world)
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

        if (this.random.nextFloat() < 0.2F)
        {
            this.dropStack(new ItemStack(ModItems.SQUIRREL_HIDE, 1));
        }

        if (this.random.nextFloat() < 0.05F)
        {
            this.dropStack(new ItemStack(ModItems.HAZELNUT, 1));
        }
    }

    public static DefaultAttributeContainer.Builder setAttributes()
    {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 4.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5D)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2);
    }

    @Override
    protected void initGoals()
    {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new PickUpItemGoal(this, 1.0D, ModItems.HAZELNUT_PEELED, ModItems.HAZELNUT_CRACKED, ModItems.HAZELNUT));
        this.goalSelector.add(2, new EatHeldItemGoal(this,  ModItems.HAZELNUT_PEELED, ModItems.HAZELNUT_CRACKED));
        this.goalSelector.add(3, new AnimalMateGoal(this, 0.85D));
        this.goalSelector.add(4, new TemptGoal(this, 0.8, Ingredient.fromTag(ModTags.Items.SQUIRREL_FOOD), false));
        this.goalSelector.add(5, new FollowParentGoal(this, 0.75));
        this.goalSelector.add(6, new PounceAtTargetGoal(this, 0.6f));
        this.goalSelector.add(7, new MeleeAttackGoal(this, 0.9D, true));
        this.goalSelector.add(8, new EscapeDangerGoal(this, 1.0D));
        this.goalSelector.add(9, new WanderAroundGoal(this, 0.75D));
        this.goalSelector.add(10, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));

        this.targetSelector.add(1, (new RevengeGoal(this)));
        super.initGoals();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return ModSounds.SOUND_SQUIRREL_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return ModSounds.SOUND_SQUIRREL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return ModSounds.SOUND_SQUIRREL_DEATH;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return stack.isIn(ModTags.Items.SQUIRREL_FOOD);
    }

    @Override
    public @Nullable SquirrelEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        return ModEntities.SQUIRREL.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar)
    {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, state ->
        {
            if (this.isAttacking())
            {
                return state.setAndContinue(RawAnimation.begin().then("attack", Animation.LoopType.PLAY_ONCE));
            }

            if (isPickUp)
            {
                resetPickUpAnimation();
                return state.setAndContinue(RawAnimation.begin().then("pickup", Animation.LoopType.PLAY_ONCE));
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

    public void triggerPickUpAnimation()
    {
        this.isPickUp = true;
    }

    public void resetPickUpAnimation()
    {
        this.isPickUp = false;
    }
}