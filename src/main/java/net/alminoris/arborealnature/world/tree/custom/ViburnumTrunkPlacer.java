package net.alminoris.arborealnature.world.tree.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.arborealnature.world.tree.ModTrunkPlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class ViburnumTrunkPlacer extends TrunkPlacer
{
    public static final MapCodec<ViburnumTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> fillTrunkPlacerFields(instance).apply(instance, ViburnumTrunkPlacer::new)
    );

    public ViburnumTrunkPlacer(int baseHeight, int heightRandA, int heightRandB)
    {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> getType()
    {
        return ModTrunkPlacerTypes.VIBURNUM_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer,
            Random random, int height, BlockPos startPos, TreeFeatureConfig config)
    {
        List<FoliagePlacer.TreeNode> foliageNodes = new ArrayList<>();

        // Start with the main trunk
        BlockPos.Mutable mutablePos = startPos.mutableCopy();

        // Create the main stem and branch out from the base with small variations
        for (int y = 0; y < height; y++)
        {
            if (TreeFeature.canReplace(world, mutablePos))
            {
                replacer.accept(mutablePos, config.trunkProvider.get(random, mutablePos));
            }

            mutablePos.move(Direction.UP);

            // Randomly branch at certain heights for a bushier look
            if (y > 1 && random.nextFloat() < 0.3) {
                Direction branchDirection = Direction.Type.HORIZONTAL.random(random);
                BlockPos branchPos = mutablePos.offset(branchDirection);

                if (TreeFeature.canReplace(world, mutablePos))
                {
                    replacer.accept(mutablePos, config.trunkProvider.get(random, mutablePos));
                }

                // Add foliage node at the top of each branch
                foliageNodes.add(new FoliagePlacer.TreeNode(branchPos.up(), 0, false));
            }
        }

        // Add foliage node at the top of the main trunk
        foliageNodes.add(new FoliagePlacer.TreeNode(mutablePos, 0, false));
        return foliageNodes;
    }
}

