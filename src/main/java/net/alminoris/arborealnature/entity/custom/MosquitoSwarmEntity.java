package net.alminoris.arborealnature.entity.custom;

import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.sound.ModSounds;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;

public class MosquitoSwarmEntity extends PathAwareEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private int biteCooldown = 0; // cooldown ticks between bites

    public MosquitoSwarmEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 20, true);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0D) // half a heart per bite
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0D);
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        BirdNavigation nav = new BirdNavigation(this, world);
        nav.setCanSwim(true);
        nav.setCanEnterOpenDoors(false);
        return nav;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(3, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    // --- Sounds ---
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.SOUND_MOSQUITO_SWARM_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.SOUND_MOSQUITO_SWARM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.SOUND_MOSQUITO_SWARM_DEATH;
    }

    // --- GeckoLib Animation ---
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, state ->
                state.setAndContinue(RawAnimation.begin().then("idle", Animation.LoopType.LOOP))));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    // --- Custom flying + attack logic ---
    @Override
    public void tickMovement() {
        super.tickMovement();

        if (this.getTarget() != null) {
            LivingEntity target = this.getTarget();
            this.getNavigation().startMovingTo(target, 1.0D);

            // hover near head
            double targetY = target.getY() + target.getStandingEyeHeight();
            if (this.getY() < targetY - 0.3) {
                this.setVelocity(this.getVelocity().add(0, 0.05, 0));
            } else if (this.getY() > targetY + 0.3) {
                this.setVelocity(this.getVelocity().add(0, -0.05, 0));
            }

            // try to bite
            if (this.distanceTo(target) < 1.3F && biteCooldown <= 0) {
                this.tryAttack(target);
                biteCooldown = 20; // 1 second
            }
        } else {
            // idle hover a bit above ground
            BlockPos below = this.getBlockPos();
            double groundY = this.getWorld().getTopY(Heightmap.Type.MOTION_BLOCKING, below.getX(), below.getZ());
            double desiredY = groundY + 2.5;

            if (this.getY() < desiredY) {
                this.setVelocity(this.getVelocity().add(0, 0.03, 0));
            } else if (this.getY() > desiredY + 1.0) {
                this.setVelocity(this.getVelocity().add(0, -0.03, 0));
            }
        }

        if (biteCooldown > 0) {
            biteCooldown--;
        }
    }

    @Override
    public boolean tryAttack(Entity target) {
        if (target instanceof LivingEntity living) {
            living.damage(this.getDamageSources().magic(), 1.0F); // bypass armor flavor
            return true;
        }
        return false;
    }
}
