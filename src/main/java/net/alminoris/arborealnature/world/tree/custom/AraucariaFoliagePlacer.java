package net.alminoris.arborealnature.world.tree.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.arborealnature.world.tree.ModFoliagePlacerTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class AraucariaFoliagePlacer extends FoliagePlacer
{
    public static final MapCodec<AraucariaFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> fillFoliagePlacerFields(instance)
                    .apply(instance, AraucariaFoliagePlacer::new));

    public AraucariaFoliagePlacer(IntProvider radius, IntProvider offset)
    {
        super(radius, offset);
    }

    @Override
    protected void generate(
            TestableWorld world, BlockPlacer placer, Random random,
            TreeFeatureConfig config, int trunkHeight,
            TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        BlockPos center = treeNode.getCenter();

        int layerCount = 2 + random.nextInt(2);
        generateSquare(world, placer, random, config, center, radius-1, 1, treeNode.isGiantTrunk());
        for (int i = 0; i < layerCount; i++)
        {
            int yOffset = -i;
            int currentRadius = Math.max(radius - i, 1);

            generateSquare(world, placer, random, config, center.down(i), currentRadius, yOffset, treeNode.isGiantTrunk());
        }
    }

    @Override
    protected void generateSquare(
            TestableWorld world, BlockPlacer placer, Random random,
            TreeFeatureConfig config, BlockPos center, int radius, int yOffset, boolean giantTrunk)
    {

        int extra = giantTrunk ? 1 : 0;
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int dx = -radius; dx <= radius + extra; dx++)
        {
            for (int dz = -radius; dz <= radius + extra; dz++)
            {
                if (Math.abs(dx) + Math.abs(dz) > radius + extra) continue;

                pos.set(center.getX() + dx, center.getY() + yOffset, center.getZ() + dz);
                placeFoliageBlock(world, placer, random, config, pos);
            }
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config)
    {
        return 2 + random.nextInt(2);
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk)
    {
        return false;
    }

    @Override
    protected FoliagePlacerType<?> getType()
    {
        return ModFoliagePlacerTypes.ARAUCARIA_FOLIAGE_PLACER;
    }
}