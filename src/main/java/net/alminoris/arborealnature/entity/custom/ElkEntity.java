package net.alminoris.arborealnature.entity.custom;

import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ElkEntity extends MooseEntity
{
    public ElkEntity(EntityType<? extends AnimalEntity> entityType, World world)
    {
        super(entityType, world);
    }

    @Override
    public @Nullable MooseEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        return ModEntities.ELK.create(world);
    }

    @Override
    protected void dropLoot(DamageSource damageSource, boolean causedByPlayer)
    {
        super.dropLoot(damageSource, causedByPlayer);

        if (this.random.nextFloat() < 0.05F)
        {
            this.dropStack(new ItemStack(ModItems.ELK_HORN, random.nextInt(2)));
        }

        if (this.random.nextFloat() < 0.5F)
        {
            this.dropStack(new ItemStack(ModItems.ELK_VENISON, random.nextInt(4)));
        }

        if (this.random.nextFloat() < 0.25F)
        {
            this.dropStack(new ItemStack(Items.LEATHER, random.nextInt(3)));
        }
    }
}