package net.alminoris.arborealnature.world.tree.custom;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.arborealnature.world.tree.ModTrunkPlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.minecraft.world.gen.trunk.TrunkPlacer;

import java.util.List;
import java.util.function.BiConsumer;

public class CedarTrunkPlacer extends TrunkPlacer {
    public static final Codec<CedarTrunkPlacer> CODEC = RecordCodecBuilder.create(
            instance -> fillTrunkPlacerFields(instance).apply(instance, CedarTrunkPlacer::new)
    );

    public CedarTrunkPlacer(int i, int j, int k)
    {
        super(i, j, k);
    }

    @Override
    protected TrunkPlacerType<?> getType()
    {
        return ModTrunkPlacerTypes.CEDAR_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random,
                                                 int height, BlockPos startPos, TreeFeatureConfig config)
    {
        List<FoliagePlacer.TreeNode> treeNodes = Lists.newArrayList();
        BlockPos blockPos = startPos.down();

        setToDirt(world, replacer, random, blockPos, config);
        setToDirt(world, replacer, random, blockPos.east(), config);
        setToDirt(world, replacer, random, blockPos.south(), config);
        setToDirt(world, replacer, random, blockPos.south().east(), config);

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        boolean isEastWest = random.nextBoolean();
        Direction firstDirection, secondDirection;

        if (isEastWest)
        {
            firstDirection = Direction.EAST;
            secondDirection = Direction.WEST;
        }
        else
        {
            firstDirection = Direction.NORTH;
            secondDirection = Direction.SOUTH;
        }

        int branchCounter = 0;

        for (int i = 0; i < height; i++)
        {
            this.setLog(world, replacer, random, mutable, config, startPos, 0, i, 0);

            if (i % 3 == 0 && i > 5)
            {
                Direction direction = (branchCounter % 2 == 0) ? firstDirection : secondDirection;

                BlockPos nodePos = getBranchPosition(startPos, i, direction, world, replacer, random, mutable, config, i);
                treeNodes.add(new FoliagePlacer.TreeNode(nodePos, -2, false));

                branchCounter++;
            }
        }

        treeNodes.add(new FoliagePlacer.TreeNode(startPos.up(height), -2, false));

        return treeNodes;
    }

    private BlockPos getBranchPosition(BlockPos startPos, int height, Direction direction,
                                       TestableWorld world, BiConsumer<BlockPos, BlockState> replacer,
                                       Random random, BlockPos.Mutable mutable, TreeFeatureConfig config, int i)
    {
        return switch (direction)
        {
            case EAST ->
            {
                this.setLog(world, replacer, random, mutable, config, startPos, 1, i-3, 0);
                this.setLog(world, replacer, random, mutable, config, startPos, 2, i-2, 0);
                this.setLog(world, replacer, random, mutable, config, startPos, 3, i-2, 0);
                yield startPos.add(2, height, 0);
            }
            case WEST ->
            {
                this.setLog(world, replacer, random, mutable, config, startPos, -1, i-3, 0);
                this.setLog(world, replacer, random, mutable, config, startPos, -2, i-2, 0);
                this.setLog(world, replacer, random, mutable, config, startPos, -3, i-2, 0);
                yield startPos.add(-2, height, 0);
            }
            case NORTH ->
            {
                this.setLog(world, replacer, random, mutable, config, startPos, 0, i-3, -1);
                this.setLog(world, replacer, random, mutable, config, startPos, 0, i-2, -2);
                this.setLog(world, replacer, random, mutable, config, startPos, 0, i-2, -3);
                yield startPos.add(0, height, -2);
            }
            case SOUTH ->
            {
                this.setLog(world, replacer, random, mutable, config, startPos, 0, i-3, 1);
                this.setLog(world, replacer, random, mutable, config, startPos, 0, i-2, 2);
                this.setLog(world, replacer, random, mutable, config, startPos, 0, i-2, 3);
                yield startPos.add(0, height, 2);
            }
            default -> startPos.add(0, height, 0);
        };
    }

    private void setLog(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random,
                        BlockPos.Mutable tmpPos, TreeFeatureConfig config, BlockPos startPos, int dx, int dy, int dz)
    {
        tmpPos.set(startPos, dx, dy, dz);
        this.trySetState(world, replacer, random, tmpPos, config);
    }
}