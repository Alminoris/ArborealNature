package net.alminoris.arborealnature.item.custom;

import net.alminoris.arborealnature.entity.custom.projectile.SilentArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SilentArrowItem extends ArrowItem
{
    public SilentArrowItem(Item.Settings settings)
    {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new SilentArrowEntity(world, shooter);
    }
}