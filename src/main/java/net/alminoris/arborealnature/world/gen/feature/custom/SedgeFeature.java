package net.alminoris.arborealnature.world.gen.feature.custom;

import com.mojang.serialization.Codec;
import net.alminoris.arborealnature.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class SedgeFeature extends Feature<ProbabilityConfig>
{
    public SedgeFeature(Codec<ProbabilityConfig> codec)
    {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<ProbabilityConfig> context)
    {
        boolean bl = false;
        Random random = context.getRandom();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        int i = random.nextInt(8) - random.nextInt(8);
        int j = random.nextInt(8) - random.nextInt(8);
        int k = structureWorldAccess.getTopY(Heightmap.Type.OCEAN_FLOOR, blockPos.getX() + i, blockPos.getZ() + j);
        BlockPos blockPos2 = new BlockPos(blockPos.getX() + i, k, blockPos.getZ() + j);
        if (structureWorldAccess.getFluidState(blockPos2).isOf(Fluids.WATER)
                && structureWorldAccess.getFluidState(blockPos2).isStill()
                && !structureWorldAccess.getFluidState(blockPos2.up()).isIn(FluidTags.WATER))
        {
            boolean hasSolidNeighbor =
                    structureWorldAccess.getBlockState(blockPos2.north()).isSolidBlock(structureWorldAccess, blockPos2.north()) ||
                            structureWorldAccess.getBlockState(blockPos2.south()).isSolidBlock(structureWorldAccess, blockPos2.south()) ||
                            structureWorldAccess.getBlockState(blockPos2.east()).isSolidBlock(structureWorldAccess, blockPos2.east()) ||
                            structureWorldAccess.getBlockState(blockPos2.west()).isSolidBlock(structureWorldAccess, blockPos2.west());

            if (hasSolidNeighbor)
            {
                BlockState lower = ModBlocks.SEDGE.getDefaultState()
                        .with(TallPlantBlock.HALF, DoubleBlockHalf.LOWER)
                        .with(Properties.WATERLOGGED, true);

                BlockState upper = ModBlocks.SEDGE.getDefaultState()
                        .with(TallPlantBlock.HALF, DoubleBlockHalf.UPPER)
                        .with(Properties.WATERLOGGED, false);

                structureWorldAccess.setBlockState(blockPos2, lower, Block.NOTIFY_LISTENERS);
                structureWorldAccess.setBlockState(blockPos2.up(), upper, Block.NOTIFY_LISTENERS);
                bl = true;
            }
        }

        return bl;
    }
}