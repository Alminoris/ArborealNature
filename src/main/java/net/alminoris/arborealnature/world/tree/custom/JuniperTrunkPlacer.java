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

public class JuniperTrunkPlacer extends TrunkPlacer
{
    public static final MapCodec<JuniperTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> fillTrunkPlacerFields(instance).apply(instance, JuniperTrunkPlacer::new)
    );

    public JuniperTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight)
    {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType()
    {
        return ModTrunkPlacerTypes.JUNIPER_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(
            TestableWorld world, BiConsumer<BlockPos, BlockState> replacer,
            Random random, int height, BlockPos startPos, TreeFeatureConfig config
    ) {
        setToDirt(world, replacer, random, startPos.down(), config);

        for (int i = 0; i < height; ++i) {
            BlockPos pos = startPos.up(i);
            getAndSetState(world, replacer, random, pos, config);
        }

        return List.of(new FoliagePlacer.TreeNode(startPos.up(height), 0, false));
    }
}