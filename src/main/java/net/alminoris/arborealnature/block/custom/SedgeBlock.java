package net.alminoris.arborealnature.block.custom;

import net.alminoris.arborealnature.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class SedgeBlock extends TallPlantBlock implements Waterloggable
{
    public static final EnumProperty<DoubleBlockHalf> HALF = TallPlantBlock.HALF;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);

    public SedgeBlock(AbstractBlock.Settings settings)
    {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(HALF, DoubleBlockHalf.LOWER)
                .with(WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(HALF, WATERLOGGED);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
    {
        return SHAPE;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos)
    {
        return floor.isSideSolidFullSquare(world, pos, Direction.UP) && !floor.isOf(Blocks.MAGMA_BLOCK);
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state)
    {
        return new ItemStack(ModBlocks.SEDGE);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx)
    {
        BlockState base = super.getPlacementState(ctx);
        if (base == null) return null;

        BlockPos pos = ctx.getBlockPos();
        World world = ctx.getWorld();

        FluidState here = world.getFluidState(pos);
        FluidState above = world.getFluidState(pos.up());

        if (!here.isIn(FluidTags.WATER) || !here.isStill() || above.isIn(FluidTags.WATER))
        {
            return null;
        }

        return base.with(WATERLOGGED, true);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (state.get(HALF) == DoubleBlockHalf.UPPER) {
            BlockState below = world.getBlockState(pos.down());
            if (!(below.isOf(this) && below.get(HALF) == DoubleBlockHalf.LOWER)) return false;
            return !world.getFluidState(pos).isIn(FluidTags.WATER);
        } else {
            FluidState here = world.getFluidState(pos);
            FluidState above = world.getFluidState(pos.up());
            if (!here.isIn(FluidTags.WATER) || !here.isStill()) return false;
            if (above.isIn(FluidTags.WATER)) return false;

            BlockPos north = pos.north();
            BlockPos south = pos.south();
            BlockPos east = pos.east();
            BlockPos west = pos.west();

            boolean isHasNearSolidBlock =
                    world.getBlockState(north).isSideSolidFullSquare(world, north, Direction.SOUTH) ||
                            world.getBlockState(south).isSideSolidFullSquare(world, south, Direction.NORTH) ||
                            world.getBlockState(east).isSideSolidFullSquare(world, east, Direction.WEST) ||
                            world.getBlockState(west).isSideSolidFullSquare(world, west, Direction.EAST);

            if (!isHasNearSolidBlock) return false;

            return super.canPlaceAt(state, world, pos);
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction dir, BlockState neighbor, WorldAccess world, BlockPos pos, BlockPos neighborPos)
    {
        if (state.get(WATERLOGGED))
        {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return !this.canPlaceAt(state, world, pos)
                ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, dir, neighbor, world, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state)
    {
        return (state.get(HALF) == DoubleBlockHalf.LOWER && state.get(WATERLOGGED))
                ? Fluids.WATER.getStill(false)
                : super.getFluidState(state);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack)
    {
        if (state.get(HALF) == DoubleBlockHalf.LOWER)
        {
            BlockPos abovePos = pos.up();
            BlockState aboveState = world.getBlockState(abovePos);
            if (aboveState.isOf(this) && aboveState.get(HALF) == DoubleBlockHalf.UPPER)
            {
                world.setBlockState(abovePos,
                        this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER).with(WATERLOGGED, false),
                        Block.NOTIFY_ALL);
            }
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    public boolean canFillWithFluid(BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        return false;
    }

    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState)
    {
        return false;
    }

    @Override
    public ItemStack tryDrainFluid(WorldAccess world, BlockPos pos, BlockState state)
    {
        return ItemStack.EMPTY;
    }
}