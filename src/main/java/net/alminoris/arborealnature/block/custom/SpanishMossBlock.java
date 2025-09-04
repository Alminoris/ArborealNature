package net.alminoris.arborealnature.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.WorldAccess;

public class SpanishMossBlock extends PlantBlock implements Fertilizable, Waterloggable
{
    public static final MapCodec<SpanishMossBlock> CODEC = createCodec(SpanishMossBlock::new);

    public static final BooleanProperty BOTTOM = BooleanProperty.of("bottom");
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);

    protected static final VoxelShape SHAPE1 = Block.createCuboidShape(4.0, 8.0, 4.0, 12.0, 16.0, 12.0);

    private static final int MAX_LENGTH = 7;

    public SpanishMossBlock(Settings settings)
    {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(BOTTOM, true)
                .with(WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(BOTTOM, WATERLOGGED);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
    {
        BlockPos below = pos.down();
        BlockState stateBelow = world.getBlockState(below);

        if ((stateBelow.isAir() || stateBelow.isOf(Blocks.WATER)) && random.nextInt(12) == 0)
        {
            int length = 1;
            BlockPos cursor = pos.up();
            while (world.getBlockState(cursor).getBlock() instanceof SpanishMossBlock)
            {
                length++;
                cursor = cursor.up();
            }
            if (length < MAX_LENGTH)
            {
                FluidState fluidState = world.getFluidState(below);
                world.setBlockState(below, this.getDefaultState()
                        .with(BOTTOM, true)
                        .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER));
                world.setBlockState(pos, state.with(BOTTOM, false));
            }
        }
        else
        {
            BlockState stateDown = world.getBlockState(pos.down());
            boolean shouldBeBottom = stateDown.isAir() || stateDown.isOf(Blocks.WATER);

            if (!(stateDown.getBlock() instanceof SpanishMossBlock) && !shouldBeBottom)
            {
                shouldBeBottom = true;
            }

            if (state.get(BOTTOM) != shouldBeBottom)
            {
                world.setBlockState(pos, state.with(BOTTOM, shouldBeBottom));
            }
        }
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
    {
        if (state.get(BOTTOM))
            return SHAPE1;
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec()
    {
        return CODEC;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos)
    {
        BlockState above = world.getBlockState(pos.up());
        Block blockAbove = above.getBlock();
        return blockAbove instanceof LeavesBlock
                || blockAbove instanceof PillarBlock
                || blockAbove instanceof SpanishMossBlock;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state)
    {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state)
    {
        BlockPos.Mutable cursor = pos.mutableCopy();
        int length = 1;
        while (world.getBlockState(cursor.up()).getBlock() instanceof SpanishMossBlock)
        {
            length++;
            cursor.move(Direction.UP);
        }

        BlockState below = world.getBlockState(pos.down());
        return length < MAX_LENGTH && (below.isAir() || below.isOf(Blocks.WATER));
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state)
    {
        if (canGrow(world, random, pos, state))
        {
            BlockPos below = pos.down();
            FluidState fluidState = world.getFluidState(below);
            world.setBlockState(below, this.getDefaultState()
                    .with(BOTTOM, true)
                    .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER));
            world.setBlockState(pos, state.with(BOTTOM, false));
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                WorldAccess world, BlockPos pos, BlockPos neighborPos)
    {
        if (direction == Direction.UP && !this.canPlaceAt(state, world, pos))
        {
            return Blocks.AIR.getDefaultState();
        }
        else
        {
            if (state.get(WATERLOGGED))
            {
                world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
            }
            return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx)
    {
        World world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();
        FluidState fluidState = world.getFluidState(pos);

        BlockState above = world.getBlockState(pos.up());
        BlockState below = world.getBlockState(pos.down());

        boolean bottom = below.isAir() || below.isOf(Blocks.WATER) || below.isSolid();

        if (above.getBlock() instanceof SpanishMossBlock)
        {
            world.setBlockState(pos.up(), above.with(BOTTOM, false));
        }

        return this.getDefaultState()
                .with(BOTTOM, bottom)
                .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state)
    {
        super.onBroken(world, pos, state);

        BlockPos above = pos.up();
        BlockState aboveState = world.getBlockState(above);

        if (aboveState.getBlock() instanceof SpanishMossBlock)
        {
            world.setBlockState(above, aboveState.with(BOTTOM, true), Block.NOTIFY_ALL);
        }
    }


    @Override
    public FluidState getFluidState(BlockState state)
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
}