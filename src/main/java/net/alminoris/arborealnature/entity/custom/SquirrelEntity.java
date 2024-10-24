package net.alminoris.arborealnature.entity.custom;

import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.entity.custom.ai.goal.EatHeldItemGoal;
import net.alminoris.arborealnature.entity.custom.ai.goal.PickUpItemGoal;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.sound.ModSounds;
import net.alminoris.arborealnature.util.ModTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

public class SquirrelEntity extends AnimalEntity implements GeoEntity
{
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private boolean isPickUp = false;

    public SquirrelEntity(EntityType<? extends AnimalEntity> entityType, World world)
    {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes()
    {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 4.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.75D);
    }

    @Override
    protected void initGoals()
    {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new PickUpItemGoal(this, 1.3D, ModItems.HAZELNUT_PEELED, ModItems.HAZELNUT_CRACKED, ModItems.HAZELNUT));
        this.goalSelector.add(2, new EatHeldItemGoal(this,  ModItems.HAZELNUT_PEELED, ModItems.HAZELNUT_CRACKED));
        this.goalSelector.add(3, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(4, new TemptGoal(this, 1.2, stack -> stack.isIn(ModTags.Items.SQUIRREL_FOOD), false));
        this.goalSelector.add(5, new FollowParentGoal(this, 1.0D));
        this.goalSelector.add(5, new EscapeDangerGoal(this, 1.5D));
        this.goalSelector.add(6, new WanderAroundGoal(this, 1.0D));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));

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
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        return ModEntities.SQUIRREL.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar)
    {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, state ->
        {
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

    // After attack, reset the attack state
    public void resetPickUpAnimation()
    {
        this.isPickUp = false;
    }
}