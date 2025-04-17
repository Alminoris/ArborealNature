package net.alminoris.arborealnature.world.tree.custom;

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

public class AraucariaTrunkPlacer extends TrunkPlacer
{
    public static final MapCodec<AraucariaTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> fillTrunkPlacerFields(instance).apply(instance, AraucariaTrunkPlacer::new)
    );

    public AraucariaTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType()
    {
        return ModTrunkPlacerTypes.ARAUCARIA_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(
            TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height,
            BlockPos pos, TreeFeatureConfig config
    ) {
        setToDirt(world, replacer, random, pos.down(), config);

        for (int y = 0; y < height; y++) {
            getAndSetState(world, replacer, random, pos.up(y), config);
        }

        return List.of(new FoliagePlacer.TreeNode(pos.up(height - 1), 0, false));
    }
}