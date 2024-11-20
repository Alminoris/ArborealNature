package net.alminoris.arborealnature.item.custom;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.util.ModTags;
import net.alminoris.arborealnature.util.helper.ModBlockSetsHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ChiselTool extends ToolItem
{
    public ChiselTool(ToolMaterials material, Settings settings)
    {
        super(material, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context)
    {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        ItemStack itemStack = context.getStack();

        if (!world.isClient)
        {
            Block currentBlock = world.getBlockState(pos).getBlock();

            Block newBlock = getNewBlock(currentBlock);
            if (newBlock != null)
            {
                world.setBlockState(pos, newBlock.getDefaultState());

                if (itemStack.getDamage() < itemStack.getMaxDamage() - 1)
                    itemStack.setDamage(itemStack.getDamage() + 1);
                else
                    itemStack.decrement(1);

                if (itemStack.isEmpty())
                {

                }

                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.FAIL;
    }

    private Block getNewBlock(Block currentBlock)
    {
        if (currentBlock.getRegistryEntry().isIn(ModTags.Blocks.CHISELABLE_BLOCKS))
        {
            String isThisBlock = currentBlock.getName().toString().split("_")[1];
            switch (isThisBlock)
            {
                case "oak":
                    return ModBlocks.OAK_CHISELED;
                case "birch":
                    return ModBlocks.BIRCH_CHISELED;
                case "spruce":
                    return ModBlocks.SPRUCE_CHISELED;
                case "jungle":
                    return ModBlocks.JUNGLE_CHISELED;
                case "acacia":
                    return ModBlocks.ACACIA_CHISELED;
                case "dark_oak":
                    return ModBlocks.DARK_OAK_CHISELED;
                case "crimson":
                    return ModBlocks.CRIMSON_CHISELED;
                case "warped":
                    return ModBlocks.WARPED_CHISELED;
                case "mangrove":
                    return ModBlocks.MANGROVE_CHISELED;
                case "cherry":
                    return ModBlocks.CHERRY_CHISELED;
                case "bamboo":
                    return Blocks.BAMBOO_MOSAIC;
                default:
                    for(String name : ModBlockSetsHelper.WOOD_NAMES)
                        if (isThisBlock.equals(name)) return ModBlockSetsHelper.WOODEN_CHISELED.get(name);
            }
        }
        return null;
    }
}
