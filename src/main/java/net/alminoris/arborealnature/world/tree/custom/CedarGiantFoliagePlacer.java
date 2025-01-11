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

public class CedarGiantFoliagePlacer extends FoliagePlacer
{
    public static final MapCodec<CedarGiantFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> fillFoliagePlacerFields(instance).apply(instance, CedarGiantFoliagePlacer::new)
    );

    public CedarGiantFoliagePlacer(IntProvider radius, IntProvider offset)
    {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType()
    {
        return ModFoliagePlacerTypes.CEDAR_GIANT_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, FoliagePlacer.BlockPlacer placer, Random random, TreeFeatureConfig config,
            int trunkHeight, FoliagePlacer.TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        BlockPos blockPos = treeNode.getCenter().up(offset);
        boolean bl = treeNode.isGiantTrunk();
        if (bl)
        {
            this.generateSquare(world, placer, random, config, blockPos, radius + 1, -1, bl);
            this.generateSquare(world, placer, random, config, blockPos, radius + 2, 0, bl);
            this.generateSquare(world, placer, random, config, blockPos, radius + 1, 1, bl);
            if (random.nextBoolean())
            {
                this.generateSquare(world, placer, random, config, blockPos, radius, 1, bl);
            }
        }
        else
        {
            this.generateSquare(world, placer, random, config, blockPos, radius + 1, -1, bl);
            this.generateSquare(world, placer, random, config, blockPos, radius, 0, bl);
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 3;
    }

    @Override
    protected boolean isPositionInvalid(Random random, int dx, int y, int dz, int radius, boolean giantTrunk)
    {
        return y == 0 && giantTrunk && (dx == -radius || dx >= radius) && (dz == -radius || dz >= radius) ||
                super.isPositionInvalid(random, dx, y, dz, radius, giantTrunk);
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk)
    {
        if (y == -1 && !giantTrunk)
            return dx == radius && dz == radius;
        else
            return y == 1 && dx + dz > radius * 2 - 2;
    }
}