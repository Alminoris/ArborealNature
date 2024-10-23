package net.alminoris.arborealnature.world.gen.feature.custom;

import com.mojang.serialization.Codec;
import net.alminoris.arborealnature.ArborealNature;
import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.HugeMushroomFeature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;

public class HugeWhiteMushroomFeature extends HugeMushroomFeature
{
    public HugeWhiteMushroomFeature(Codec<HugeMushroomFeatureConfig> codec)
    {
        super(codec);
    }

    @Override
    protected void generateStem(WorldAccess world, Random random, BlockPos pos, HugeMushroomFeatureConfig config, int height, BlockPos.Mutable mutablePos)
    {
        // Define a base radius, the stem will get wider towards the bottom
        int baseRadius = 2;  // Starting thickness of the stem (set as appropriate)
        int topRadius = 1;   // Thinner stem at the top

        height = Math.max(height, 7);

        height = Math.min(height, 9);

        // Loop through each height level of the stem
        for (int y = 0; y < height; y++)
        {
            int currentRadius = Math.max(baseRadius - (y / 2), topRadius);  // Gradually reduce the radius as the height increases

            // Create a wider stem at lower levels
            for (int xOffset = -currentRadius; xOffset <= currentRadius; xOffset++)
            {
                for (int zOffset = -currentRadius; zOffset <= currentRadius; zOffset++)
                {
                    // Ensure it forms a circular stem shape
                    if (xOffset * xOffset + zOffset * zOffset <= currentRadius * currentRadius)
                    {
                        mutablePos.set(pos, xOffset, y, zOffset);  // Set position for this block in the stem

                        // Only place the stem block if the space is not already filled
                        if (!world.getBlockState(mutablePos).isOpaqueFullCube(world, mutablePos))
                        {
                            BlockState stemState = config.stemProvider.get(random, pos);
                            this.setBlockState(world, mutablePos, stemState);
                        }
                    }
                }
            }
        }
    }


    @Override
    protected void generateCap(WorldAccess world, Random random, BlockPos start, int y, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config)
    {
        int baseRadius = config.foliageRadius; // Initial cap radius

        y = Math.max(y, 6);

        for (int currentHeight = 0; currentHeight <= 2; currentHeight++)
        {
            int currentRadius = (currentHeight == 2) ? (baseRadius + currentHeight-1) : (baseRadius + currentHeight); // Shrink radius as you go up

            for (int xOffset = -currentRadius; xOffset <= currentRadius; xOffset++)
            {
                for (int zOffset = -currentRadius; zOffset <= currentRadius; zOffset++)
                {
                    boolean isEdgeX = xOffset == -currentRadius || xOffset == currentRadius;
                    boolean isEdgeZ = zOffset == -currentRadius || zOffset == currentRadius;

                    // Skip the corners to create the rounded shape
                    if (!isEdgeX || !isEdgeZ)
                    {
                        mutable.set(start, xOffset, Math.abs(y - currentHeight), zOffset);

                        if (!world.getBlockState(mutable).isOpaqueFullCube(world, mutable))
                        {
                            BlockState blockState = config.capProvider.get(random, start);
                            // Set the directional states for the mushroom block
                            blockState = blockState.with(MushroomBlock.WEST, xOffset < 0)
                                    .with(MushroomBlock.EAST, xOffset > 0)
                                    .with(MushroomBlock.NORTH, zOffset < 0)
                                    .with(MushroomBlock.SOUTH, zOffset > 0);

                            this.setBlockState(world, mutable, blockState);
                        }
                    }
                }
            }
        }
    }

    /*@Override
    protected void generateCap(WorldAccess world, Random random, BlockPos start, int y, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config)
    {
        int totalLayers = 3;  // Number of layers for the cap
        int baseRadius = config.foliageRadius;  // Base radius of the bottom layer

        // Loop through the layers from bottom to top
        for (int layer = 0; layer < totalLayers; layer++)
        {
            int radius = baseRadius + layer;  // Decrease the radius as we go up the layers

            // Place blocks for the current layer
            for (int j = -radius; j <= radius; j++)
            {
                for (int k = -radius; k <= radius; k++)
                {
                    // Skip corners to create a rounder shape
                    if (j * j + k * k <= radius * radius)
                    {
                        mutable.set(start, j, y - layer, k);  // Adjust y for each layer

                        // Only place cap blocks where there's space
                        if (!world.getBlockState(mutable).isOpaqueFullCube(world, mutable))
                        {
                            BlockState capState = config.capProvider.get(random, start);

                            // Ensure the blockstate updates properly for the mushroom's cap
                            if (capState.contains(MushroomBlock.WEST)
                                    && capState.contains(MushroomBlock.EAST)
                                    && capState.contains(MushroomBlock.NORTH)
                                    && capState.contains(MushroomBlock.SOUTH))
                            {
                                capState = capState.with(MushroomBlock.WEST, j == -radius)
                                        .with(MushroomBlock.EAST, j == radius)
                                        .with(MushroomBlock.NORTH, k == -radius)
                                        .with(MushroomBlock.SOUTH, k == radius);
                            }

                            this.setBlockState(world, mutable, capState);
                        }
                    }
                }
            }
        }
    }*/


    @Override
    protected int getCapSize(int i, int j, int capSize, int y)
    {
        // Modify this if needed to fit the size behavior of your mushroom
        return Math.max(0, capSize - y);
    }
}
