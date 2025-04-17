package net.alminoris.arborealnature.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

public class StatusEffectArmorItem extends ArmorItem
{
    private static int durabilityDamageTime = 185;

    private final StatusEffect effect;
    public StatusEffectArmorItem(ArmorMaterial material, Type type, StatusEffect effect, Settings settings)
    {
        super(material, type, settings);
        this.effect = effect;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (entity instanceof PlayerEntity player && !world.isClient)
        {
            if (player.getEquippedStack(EquipmentSlot.CHEST).getItem() == this)
            {
                player.addStatusEffect(new StatusEffectInstance(effect, 10, 0, true, false, true));

                if (world.getTime() % durabilityDamageTime == 0)
                {
                    durabilityDamageTime = 1200;
                    ItemStack chestStack = player.getEquippedStack(EquipmentSlot.CHEST);

                    if (chestStack.getDamage() < chestStack.getMaxDamage() - 1)
                        chestStack.setDamage(chestStack.getDamage() + 1);
                    else
                        chestStack.decrement(1);
                } else durabilityDamageTime--;
            }
        }
    }
}