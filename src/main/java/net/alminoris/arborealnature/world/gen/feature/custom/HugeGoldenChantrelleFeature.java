package net.alminoris.arborealnature.world.gen.feature.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.HugeMushroomFeature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;

public class HugeGoldenChantrelleFeature extends HugeMushroomFeature
{
    public HugeGoldenChantrelleFeature(Codec<HugeMushroomFeatureConfig> codec)
    {
        super(codec);
    }

    @Override
    protected void generateStem(WorldAccess world, Random random, BlockPos pos, HugeMushroomFeatureConfig config, int height, BlockPos.Mutable m)
    {
        height = Math.max(6, Math.min(height, 8));
        int thinH = 2 + random.nextInt(2);
        for (int y = -5; y < height; y++)
        {
            int r = (y < thinH) ? 1 : 2;
            if (y == height - 1)
                r = 3;
            for (int x = -r; x <= r; x++)
            {
                for (int z = -r; z <= r; z++)
                {
                    if (x * x + z * z <= r * r)
                    {
                        m.set(pos, x, y, z);
                        if (!world.getBlockState(m).isOpaqueFullCube(world, m))
                            this.setBlockState(world, m, config.stemProvider.get(random, pos));
                    }
                }
            }
        }
    }

    @Override
    protected void generateCap(WorldAccess world, Random random, BlockPos pos, int stemHeight, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config)
    {
        stemHeight = Math.max(6, Math.min(stemHeight, 8));

        int capY = pos.getY() + stemHeight;
        int radius = Math.max(4, config.foliageRadius + 1); // 4–5 blocks

        for (int x = -radius; x <= radius; x++)
        {
            for (int z = -radius; z <= radius; z++)
            {
                if (Math.abs(x) == radius && Math.abs(z) == radius)
                    continue;

                mutable.set(pos.getX() + x, capY, pos.getZ() + z);

                BlockState blockState = config.capProvider.get(random, pos)
                        .with(MushroomBlock.WEST, x < 0)
                        .with(MushroomBlock.EAST, x > 0)
                        .with(MushroomBlock.NORTH, z < 0)
                        .with(MushroomBlock.SOUTH, z > 0);

                this.setBlockState(world, mutable, blockState);
            }
        }
    }

    @Override
    protected int getCapSize(int trunkHeight, int foliageRadius, int capSize, int y)
    {
        return Math.max(1, foliageRadius);
    }
}