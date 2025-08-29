package net.alminoris.arborealnature.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.arborealnature.world.tree.ModFoliagePlacerTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class SequoiaFoliagePlacer extends FoliagePlacer
{
    private final boolean isGiantFoliage;

    public static final MapCodec<SequoiaFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.BOOL.fieldOf("is_giant_foliage").forGetter(p -> p.isGiantFoliage)
            ).apply(instance, SequoiaFoliagePlacer::new)
    );

    public SequoiaFoliagePlacer(boolean isGiantFoliage)
    {
        super(ConstantIntProvider.create(0), ConstantIntProvider.create(0));
        this.isGiantFoliage = isGiantFoliage;
    }

    @Override
    protected FoliagePlacerType<?> getType()
    {
        return ModFoliagePlacerTypes.SEQUOIA_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config,
                            int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        BlockPos blockPos = treeNode.getCenter().up(offset);

        radius = isGiantFoliage ? radius : radius-1;

        boolean bl = treeNode.isGiantTrunk();
        if (bl)
        {
            this.generateSquare(world, placer, random, config, blockPos, radius + 3, -2, true);
            this.generateSquare(world, placer, random, config, blockPos, radius + 4, -1, true);
            this.generateSquare(world, placer, random, config, blockPos, radius + 3, 0, true);
            this.generateSquare(world, placer, random, config, blockPos, radius + 2, 1, true);
            if (random.nextBoolean())
                this.generateSquare(world, placer, random, config, blockPos, radius + 2, 2, true);
        }
        else
        {
            this.generateSquare(world, placer, random, config, blockPos, radius + 2, -2, false);
            this.generateSquare(world, placer, random, config, blockPos, radius + 3, -1, false);
            this.generateSquare(world, placer, random, config, blockPos, radius + 2, 0, false);
            this.generateSquare(world, placer, random, config, blockPos, radius + 1, 1, false);
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config)
    {
        return 3;
    }

    @Override
    protected boolean isPositionInvalid(Random random, int dx, int y, int dz, int radius, boolean giantTrunk)
    {
        if (giantTrunk)
        {
            return y == 0 && (dx == -radius || dx >= radius) && (dz == -radius || dz >= radius);
        }
        else
        {
            return super.isPositionInvalid(random, dx, y, dz, radius, false);
        }
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        if (giantTrunk)
        {
            return y == 1 && dx + dz > radius * 2 - 2;
        }
        else
        {
            return y == -1 && dx == radius && dz == radius;
        }
    }
}