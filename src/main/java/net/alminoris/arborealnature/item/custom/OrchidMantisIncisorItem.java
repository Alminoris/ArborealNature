package net.alminoris.arborealnature.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class OrchidMantisIncisorItem extends SwordItem
{
    private static final int COOLDOWN_SECONDS = 1800;
    private static final int INVISIBILITY_DURATION_SECONDS = 15;

    public OrchidMantisIncisorItem(ToolMaterial material, Settings settings)
    {
        super(material, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand)
    {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient)
        {
            if (!player.getItemCooldownManager().isCoolingDown(this))
            {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, INVISIBILITY_DURATION_SECONDS * 20, 0));
                player.getItemCooldownManager().set(this, COOLDOWN_SECONDS * 20);

                world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
            }
        }

        return TypedActionResult.success(stack, world.isClient());
    }
}