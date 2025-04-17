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

public class JuniperFoliagePlacer extends FoliagePlacer
{
    public static final MapCodec<JuniperFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> fillFoliagePlacerFields(instance)
                    .apply(instance, JuniperFoliagePlacer::new));

    public JuniperFoliagePlacer(IntProvider radius, IntProvider offset)
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
        int height = 2 + random.nextInt(2); // 2-3 layers
        for (int i = 0; i < height; i++)
        {
            int layerRadius = radius - i + 1;
            generateSquare(world, placer, random, config, center.down(i), layerRadius, -i, treeNode.isGiantTrunk());
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 2;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }

    @Override
    protected FoliagePlacerType<?> getType()
    {
        return ModFoliagePlacerTypes.JUNIPER_FOLIAGE_PLACER;
    }
}