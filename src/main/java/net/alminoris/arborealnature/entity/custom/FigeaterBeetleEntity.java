package net.alminoris.arborealnature.entity.custom;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.sound.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Flutterer;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.AboveGroundTargeting;
import net.minecraft.entity.ai.NoPenaltySolidTargeting;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;

import java.util.EnumSet;
import java.util.Random;

public class FigeaterBeetleEntity extends AnimalEntity implements GeoEntity, Flutterer
{
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private boolean isFlying = false;

    public FigeaterBeetleEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 10, true); // Control for flying movement
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
            this.dropStack(new ItemStack(ModItems.FIGS, 1));
        }

        if (this.random.nextFloat() < 0.15F)
        {
            this.dropStack(new ItemStack(ModItems.FIGEATER_BEETLE_SHELL, 1));
        }
    }

    public static DefaultAttributeContainer.Builder setAttributes()
    {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.7D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2D);
    }

    @Override
    protected void initGoals()
    {
        this.goalSelector.add(0, new ToggleFlyGoal(this, 100)); // Switches between flying and walking
        this.goalSelector.add(1, new FlyAroundGoal(this, 1.0)); // Flying goal
        this.goalSelector.add(2, new WanderAroundGoal(this, 1.0)); // Walking goal
        this.goalSelector.add(3, new AnimalMateGoal(this, 0.5D));
        this.goalSelector.add(4, new TemptGoal(this, 0.55D, stack -> stack.isOf(ModItems.FIGS), true));
        this.goalSelector.add(5, new FollowParentGoal(this, 0.5D));
        this.goalSelector.add(6, new EscapeDangerGoal(this, 0.6D));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 5.0F));

        super.initGoals();
    }

    @Override
    public boolean damage(DamageSource source, float amount)
    {
        boolean damaged = super.damage(source, amount);
        if (damaged && this.isOnGround())
        {
            startFlying(); // Take off and fly if damaged while on the ground
        }
        return damaged;
    }

    private void startFlying()
    {
        this.isFlying = true;
        this.moveControl = new FlightMoveControl(this, 10, true);
    }

    private void stopFlying()
    {
        this.isFlying = false;
        this.moveControl = new MoveControl(this); // Reset to normal ground movement
    }

    public boolean isFlying()
    {
        return this.isFlying;
    }

    @Override
    public boolean isInAir()
    {
        return !this.isOnGround();
    }

    @Override
    public boolean isFallFlying()
    {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return ModSounds.SOUND_FIGEATER_BEETLE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return ModSounds.SOUND_FIGEATER_BEETLE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return ModSounds.SOUND_FIGEATER_BEETLE_DEATH;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return stack.isOf(ModItems.FIGS);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        return ModEntities.FIGEATER_BEETLE.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar)
    {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, state ->
        {
            if (this.isInAir()) //Check if beetle is in Air
                return state.setAndContinue(RawAnimation.begin().then("fly", Animation.LoopType.LOOP));

            if(state.isMoving() && isOnGround())
            {
                return state.setAndContinue(RawAnimation.begin().then("run", Animation.LoopType.LOOP));
            }

            return state.setAndContinue(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache()
    {
        return cache;
    }

    private static class ToggleFlyGoal extends Goal {
        private final FigeaterBeetleEntity beetle;
        private final int interval;
        private int timer;

        public ToggleFlyGoal(FigeaterBeetleEntity beetle, int interval) {
            this.beetle = beetle;
            this.interval = interval;
            this.timer = interval;
        }

        @Override
        public boolean canStart() {
            return true;
        }

        @Override
        public void tick() {
            if (--timer <= 0) {
                if (beetle.isFlying()) {
                    beetle.stopFlying(); // Stop flying and switch to walking
                } else {
                    beetle.startFlying(); // Start flying
                }
                timer = interval;
            }
        }
    }

    // Custom goal to handle flying movement
    private static class FlyAroundGoal extends Goal {
        private final FigeaterBeetleEntity beetle;
        private final double speed;

        public FlyAroundGoal(FigeaterBeetleEntity beetle, double speed) {
            this.beetle = beetle;
            this.speed = speed;
            this.setControls(EnumSet.of(Control.MOVE));
        }

        @Override
        public boolean canStart() {
            return beetle.isFlying();
        }

        @Override
        public void start() {
            Vec3d targetPos = NoPenaltySolidTargeting.find(beetle, 10, 7, 3, 0, 0, Math.PI / 2);
            if (targetPos != null) {
                beetle.getNavigation().startMovingTo(targetPos.x, targetPos.y, targetPos.z, speed);
            }
        }

        @Override
        public boolean shouldContinue() {
            return beetle.isFlying() && !beetle.getNavigation().isIdle();
        }
    }
}
