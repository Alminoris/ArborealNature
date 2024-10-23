package net.alminoris.arborealnature.world.tree.custom;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.arborealnature.world.tree.ModTrunkPlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class LargeHornbeamTrunkPlacer extends TrunkPlacer
{
    public static final MapCodec<LargeHornbeamTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> fillTrunkPlacerFields(instance).apply(instance, LargeHornbeamTrunkPlacer::new)
    );

    public LargeHornbeamTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight)
    {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }


    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.LARGE_HORNBEAM_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(
            TestableWorld world,
            BiConsumer<BlockPos, BlockState> replacer,
            Random random,
            int height,
            BlockPos startPos,
            TreeFeatureConfig config)
    {

        setToDirt(world, replacer, random, startPos.down(), config);
        List<FoliagePlacer.TreeNode> foliageNodes = Lists.newArrayList();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        // Generate a straight trunk
        for (int y = 0; y < height; y++) {
            BlockPos trunkPos = mutable.set(startPos).move(0, y, 0); // Move straight up
            this.getAndSetState(world, replacer, random, trunkPos, config); // Set block state for trunk
        }

        // Create a single foliage node at the top of the trunk
        foliageNodes.add(new FoliagePlacer.TreeNode(startPos.up(height), 0, false));

        return foliageNodes;
    }
}
