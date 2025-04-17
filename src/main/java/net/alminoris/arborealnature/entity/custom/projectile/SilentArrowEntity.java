package net.alminoris.arborealnature.entity.custom.projectile;

import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;

public class SilentArrowEntity extends PersistentProjectileEntity
{
    private int duration = 100;

    public SilentArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world)
    {
        super(entityType, world);
    }

    public SilentArrowEntity(World world, LivingEntity owner)
    {
        super(ModEntities.SILENT_ARROW, owner, world);
    }

    @Override
    public void tick()
    {
        super.tick();
        if (this.getWorld().isClient && !this.inGround)
        {
            this.getWorld().addParticle(ParticleTypes.INSTANT_EFFECT,
                    this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        }
    }

    @Override
    protected void onHit(LivingEntity target)
    {
        super.onHit(target);

        if (this.getOwner() instanceof LivingEntity shooter)
        {
            StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.INVISIBILITY, this.duration, 0);
            shooter.addStatusEffect(statusEffectInstance);
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt)
    {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("Duration")) {
            this.duration = nbt.getInt("Duration");
        }
    }

    @Override
    protected ItemStack asItemStack()
    {
        return new ItemStack(ModItems.SILENT_ARROW);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Duration", this.duration);
    }
}