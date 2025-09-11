package net.alminoris.arborealnature.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.arborealnature.world.tree.ModFoliagePlacerTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ThujaFoliagePlacer extends FoliagePlacer
{
    private final IntProvider trunkHeight;

    public static final Codec<ThujaFoliagePlacer> CODEC = RecordCodecBuilder.create(
            instance -> fillFoliagePlacerFields(instance)
                    .and(IntProvider.createValidatingCodec(0, 24).fieldOf("trunk_height").forGetter(placer -> placer.trunkHeight))
                    .apply(instance, ThujaFoliagePlacer::new)
    );

    public ThujaFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider trunkHeight)
    {
        super(radius, offset);
        this.trunkHeight = trunkHeight;
    }

    @Override
    protected void generate(
            TestableWorld world,
            BlockPlacer placer,
            Random random,
            TreeFeatureConfig config,
            int trunkHeight,
            TreeNode treeNode,
            int foliageHeight,
            int radius,
            int offset)
    {
        BlockPos centerPos = treeNode.getCenter();
        int layerCount = trunkHeight / 2;
        int currentRadius = radius;

        for (int layer = 0; layer < layerCount+2; layer++)
        {
            this.generateLayer(world, placer, random, config, centerPos, currentRadius, offset, treeNode.isGiantTrunk());
            if (layer == 1 || layer == layerCount) currentRadius++;
            centerPos = centerPos.down();
        }
    }

    private void generateLayer(
            TestableWorld world,
            BlockPlacer placer,
            Random random,
            TreeFeatureConfig config,
            BlockPos centerPos,
            int radius,
            int y,
            boolean giantTrunk
    )
    {
        int extra = giantTrunk ? 1 : 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int dx = -radius; dx <= radius + extra; dx++)
        {
            for (int dz = -radius; dz <= radius + extra; dz++)
            {
                if (Math.abs(dx) + Math.abs(dz) > radius)
                    continue;

                mutable.set(centerPos, dx, y, dz);
                placeFoliageBlock(world, placer, random, config, mutable);
            }
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config)
    {
        return Math.max(6, trunkHeight - this.trunkHeight.get(random));
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk)
    {
        return dx == radius && dz == radius && radius > 0;
    }

    @Override
    protected FoliagePlacerType<?> getType()
    {
        return ModFoliagePlacerTypes.THUJA_FOLIAGE_PLACER;
    }
}