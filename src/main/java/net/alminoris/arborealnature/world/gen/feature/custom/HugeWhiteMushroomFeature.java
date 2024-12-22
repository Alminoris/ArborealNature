package net.alminoris.arborealnature.world.gen.feature.custom;

import com.mojang.serialization.Codec;
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
        for (int y = -5; y < height; y++)
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

        y = Math.max(y-1, 6);

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

    @Override
    protected int getCapSize(int i, int j, int capSize, int y)
    {
        // Modify this if needed to fit the size behavior of your mushroom
        return Math.max(0, capSize - y);
    }
}