package net.alminoris.arborealnature.world.tree.custom;

import com.google.common.collect.Lists;
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
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.BiConsumer;

public class LargeHazelnutTrunkPlacer extends ForkingTrunkPlacer
{
    // Constructor
    public LargeHazelnutTrunkPlacer(int i, int j, int k)
    {
        super(i, j, k);
    }

    @Override
    protected TrunkPlacerType<?> getType()
    {
        return ModTrunkPlacerTypes.LARGE_HAZELNUT_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(
            TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config
    )
    {
        setToDirt(world, replacer, random, startPos.down(), config);
        List<FoliagePlacer.TreeNode> list = Lists.newArrayList();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        // Define the directions for the stems
        Direction[] directions = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};

        // Create the base trunk, 1-2 blocks high, with 4 stems at the base
        int baseHeight = 1 + random.nextInt(2); // Main trunk height is 1-2 blocks
        for (int y = 0; y < baseHeight; y++)
        {
            int currentY = startPos.getY() + y;
            for (Direction dir : directions)
            {
                BlockPos offsetPos = startPos.offset(dir);
                this.getAndSetState(world, replacer, random, mutable.set(offsetPos.getX(), currentY, offsetPos.getZ()), config);
            }
            this.getAndSetState(world, replacer, random, mutable.set(startPos.getX(), currentY, startPos.getZ()), config); // Main center block
        }

        // Generate stems in the 4 directions and grow them upwards
        for (Direction dir : directions)
        {
            int stemHeight = height - random.nextInt(3); // Randomized height for each stem
            int x = startPos.getX() + dir.getOffsetX();
            int z = startPos.getZ() + dir.getOffsetZ();

            for (int y = baseHeight; y < stemHeight; y++)
            {
                int currentY = startPos.getY() + y;
                if (this.getAndSetState(world, replacer, random, mutable.set(x, currentY, z), config))
                {
                    // Add foliage placement points as the stem grows
                    if (y == stemHeight - 1)
                    {
                        list.add(new FoliagePlacer.TreeNode(new BlockPos(x, currentY, z), 1, false));
                    }
                }
            }
        }

        // Grow a main cluster at the center (above the main trunk)
        int centerClusterHeight = height - random.nextInt(2);
        for (int y = baseHeight; y < centerClusterHeight; y++)
        {
            int currentY = startPos.getY() + y;
            if (this.getAndSetState(world, replacer, random, mutable.set(startPos.getX(), currentY, startPos.getZ()), config))
            {
                if (y == centerClusterHeight - 1)
                {
                    list.add(new FoliagePlacer.TreeNode(new BlockPos(startPos.getX(), currentY, startPos.getZ()), 1, true));
                }
            }
        }

        return list;
    }

}
