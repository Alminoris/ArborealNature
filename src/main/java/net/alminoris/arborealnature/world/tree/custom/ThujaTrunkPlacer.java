package net.alminoris.arborealnature.world.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.arborealnature.world.tree.ModTrunkPlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class ThujaTrunkPlacer extends TrunkPlacer
{
    public static final Codec<ThujaTrunkPlacer> CODEC = RecordCodecBuilder.create(
            instance -> fillTrunkPlacerFields(instance).apply(instance, ThujaTrunkPlacer::new)
    );

    private int trunkHeight;

    public ThujaTrunkPlacer(int minTrunkHeight)
    {
        this(minTrunkHeight, 0, 0);
    }

    private ThujaTrunkPlacer(int minTrunkHeight, int j, int k)
    {
        super(minTrunkHeight, j, k);
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(
            TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config
    )
    {
        setToDirt(world, replacer, random, startPos.down(), config);

        for (int i = 0; i < this.trunkHeight; i++)
        {
            this.getAndSetState(world, replacer, random, startPos.up(i), config);
        }

        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(height), 0, false));
    }

    @Override
    public int getHeight(Random random)
    {
        trunkHeight = 6;
        return trunkHeight;
    }

    @Override
    protected TrunkPlacerType<?> getType()
    {
        return ModTrunkPlacerTypes.THUJA_TRUNK_PLACER;
    }
}