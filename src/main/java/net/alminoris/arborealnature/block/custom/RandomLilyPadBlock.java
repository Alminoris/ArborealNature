package net.alminoris.arborealnature.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.random.Random;

public class RandomLilyPadBlock extends LilyPadBlock
{
    public static final IntProperty VARIANT = IntProperty.of("variant", 0, 4);
    private final int maxVariants;

    public RandomLilyPadBlock(Settings settings, int maxVariants)
    {
        super(settings);
        this.maxVariants = maxVariants;

        this.setDefaultState(this.stateManager.getDefaultState().with(VARIANT, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(VARIANT);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx)
    {
        BlockState state = super.getPlacementState(ctx);
        if (state == null)
        {
            state = this.getDefaultState();
        }
        Random random = ctx.getWorld().getRandom();
        return state.with(VARIANT, random.nextInt(maxVariants));
    }

    public int getMaxVariants()
    {
        return maxVariants;
    }
}