package net.alminoris.arborealnature.world.tree.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.arborealnature.world.tree.ModFoliagePlacerTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ViburnumFoliagePlacer extends FoliagePlacer
{
    public static final MapCodec<ViburnumFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> fillFoliagePlacerFields(instance).apply(instance, ViburnumFoliagePlacer::new)
    );

    public ViburnumFoliagePlacer(IntProvider radius, IntProvider offset)
    {
        super(radius, offset);
    }

    @Override
    protected void generate(
            TestableWorld world,
            FoliagePlacer.BlockPlacer placer,
            Random random,
            TreeFeatureConfig config,
            int trunkHeight,
            FoliagePlacer.TreeNode treeNode,
            int foliageHeight,
            int radius,
            int offset
    )
    {
        // Center position of the foliage
        BlockPos pos = treeNode.getCenter();

        for (int y = offset; y >= offset - foliageHeight; y--)
        {
            int currentRadius = Math.max(radius - (offset - y), 1);  // Decrease radius gradually to form a rounded canopy
            placeFoliageCircle(world, placer, random, config, pos.up(y), currentRadius);
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config)
    {
        int randomHeightVariation = random.nextInt(2 * 2 + 1) - 2;
        return trunkHeight + randomHeightVariation;
    }

    private void placeFoliageCircle(
            TestableWorld world, FoliagePlacer.BlockPlacer placer, Random random,
            TreeFeatureConfig config, BlockPos center, int radius)
    {
        for (int dx = -radius; dx <= radius; dx++)
        {
            for (int dz = -radius; dz <= radius; dz++)
            {
                if (dx * dx + dz * dz <= radius * radius)
                {
                    BlockPos foliagePos = center.add(dx, 0, dz);
                    if (TreeFeature.canReplace(world, foliagePos))
                    {
                        placer.placeBlock(foliagePos, config.foliageProvider.get(random, foliagePos));
                    }
                }
            }
        }
    }

    @Override
    protected FoliagePlacerType<?> getType()
    {
        return ModFoliagePlacerTypes.VIBURNUM_FOLIAGE_PLACER; // Register as custom if you have a custom type
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return dx * dx + dz * dz > radius * radius;  // Basic circular check for leaves
    }
}
