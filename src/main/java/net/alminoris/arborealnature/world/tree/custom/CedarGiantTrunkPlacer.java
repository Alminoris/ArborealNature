package net.alminoris.arborealnature.world.tree.custom;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.arborealnature.world.tree.ModTrunkPlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class CedarGiantTrunkPlacer extends GiantTrunkPlacer
{
    public static final Codec<CedarGiantTrunkPlacer> CODEC = RecordCodecBuilder.create(
            instance -> fillTrunkPlacerFields(instance).apply(instance, CedarGiantTrunkPlacer::new)
    );

    public CedarGiantTrunkPlacer(int i, int j, int k)
    {
        super(i, j, k);
    }

    @Override
    protected TrunkPlacerType<?> getType()
    {
        return ModTrunkPlacerTypes.CEDAR_GIANT_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random,
                                                 int height, BlockPos startPos, TreeFeatureConfig config)
    {
        List<FoliagePlacer.TreeNode> list = Lists.<FoliagePlacer.TreeNode>newArrayList();
        list.addAll(super.generate(world, replacer, random, height, startPos, config));

        BlockPos blockPos = startPos.down();
        setToDirt(world, replacer, random, blockPos, config);
        setToDirt(world, replacer, random, blockPos.east(), config);
        setToDirt(world, replacer, random, blockPos.south(), config);
        setToDirt(world, replacer, random, blockPos.south().east(), config);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        BlockPos pos;
        int prev = -1;
        for (int i = 0; i < height; i++)
        {
            //this.setLog(world, replacer, random, mutable, config, startPos, 0, i, 0);
            //this.setLog(world, replacer, random, mutable, config, startPos, 1, i, 0);
            //this.setLog(world, replacer, random, mutable, config, startPos, 1, i, 1);
            //this.setLog(world, replacer, random, mutable, config, startPos, 0, i, 1);
            if ((i+1) % 3 == 0 && i > 2)
            {

                int r = random.nextBetween(2,5);
                if (prev != r)
                {
                    Direction direction = Direction.byId(r);
                    switch (direction)
                    {
                        case NORTH:
                            this.setLog(world, replacer, random, mutable, config, startPos, -1, i, 1);
                            this.setLog(world, replacer, random, mutable, config, startPos, -2, i+1, 1);
                            pos = new BlockPos(startPos.getX()-2, startPos.getY()+(i+1), startPos.getZ()+1);
                            break;
                        case SOUTH:
                            this.setLog(world, replacer, random, mutable, config, startPos, 2, i, 0);
                            this.setLog(world, replacer, random, mutable, config, startPos, 3, i+1, 0);
                            pos = new BlockPos(startPos.getX()+3, startPos.getY()+(i+1), startPos.getZ());
                            break;
                        case WEST:
                            this.setLog(world, replacer, random, mutable, config, startPos, 0, i, -1);
                            this.setLog(world, replacer, random, mutable, config, startPos, 0, i+1, -2);
                            pos = new BlockPos(startPos.getX(), startPos.getY()+(i+1), startPos.getZ()-2);
                            break;
                        default:
                            this.setLog(world, replacer, random, mutable, config, startPos, 1, i, 2);
                            this.setLog(world, replacer, random, mutable, config, startPos, 1, i+1, 3);
                            pos = new BlockPos(startPos.getX()+1, startPos.getY()+(i+1), startPos.getZ()+3);
                            break;
                    }

                    list.add(new FoliagePlacer.TreeNode(pos.up(), -2, false));
                }
                prev = r;
            }
        }
        return list;
    }

    private void setLog(
            TestableWorld world,
            BiConsumer<BlockPos, BlockState> replacer,
            Random random,
            BlockPos.Mutable tmpPos,
            TreeFeatureConfig config,
            BlockPos startPos,
            int dx,
            int dy,
            int dz
    )
    {
        tmpPos.set(startPos, dx, dy, dz);
        this.trySetState(world, replacer, random, tmpPos, config);
    }
}