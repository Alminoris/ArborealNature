package net.alminoris.arborealnature.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Random;

public class TransformableItem extends Item
{
    private Item dropResult;
    private Item targetItem;
    private Item antiDropResult;
    private float dropChance;

    public TransformableItem(Item dropResult, Item antiDropResult, Item targetItem, float dropChance, Settings settings)
    {
        super(settings);
        this.dropResult = dropResult;
        this.dropChance = dropChance;
        this.targetItem = targetItem;
        this.antiDropResult = antiDropResult;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        ItemStack stack = user.getStackInHand(hand);
        ItemStack offHandStack = user.getOffHandStack();

        if (offHandStack.getItem() == targetItem)
        {
            if (offHandStack.getDamage() < offHandStack.getMaxDamage() - 1)
                offHandStack.setDamage(offHandStack.getDamage() + 1);
            else
                offHandStack.decrement(1);

            stack.decrement(1);

            Random random = new Random();
            if (random.nextFloat() < dropChance)
            {
                ItemStack newItemStack = new ItemStack(dropResult);
                if (!user.getInventory().insertStack(newItemStack))
                    user.dropItem(newItemStack, false);
                return TypedActionResult.success(stack);
            }
            else
            {
                ItemStack newItemStack = new ItemStack(antiDropResult);
                if (!user.getInventory().insertStack(newItemStack))
                    user.dropItem(newItemStack, false);
                return TypedActionResult.success(stack);
            }
        }

        return TypedActionResult.pass(stack);
    }
}
