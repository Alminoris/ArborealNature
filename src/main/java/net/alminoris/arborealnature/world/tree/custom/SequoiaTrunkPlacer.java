package net.alminoris.arborealnature.world.tree.custom;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.arborealnature.world.tree.ModTrunkPlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class SequoiaTrunkPlacer extends GiantTrunkPlacer
{
    private final boolean isGiant;

    public static final MapCodec<SequoiaTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.INT.fieldOf("base_height").forGetter(tp -> tp.baseHeight),
                    Codec.INT.fieldOf("first_random_height").forGetter(tp -> tp.firstRandomHeight),
                    Codec.INT.fieldOf("second_random_height").forGetter(tp -> tp.secondRandomHeight),
                    Codec.BOOL.fieldOf("is_giant").forGetter(tp -> tp.isGiant)
            ).apply(instance, SequoiaTrunkPlacer::new)
    );

    public SequoiaTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight, boolean isGiant) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
        this.isGiant = isGiant;
    }


    @Override
    protected TrunkPlacerType<?> getType()
    {
        return ModTrunkPlacerTypes.SEQUOIA_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random,
                                                 int height, BlockPos startPos, TreeFeatureConfig config)
    {
        List<FoliagePlacer.TreeNode> list = Lists.<FoliagePlacer.TreeNode>newArrayList();
        BlockPos blockPos = startPos.down();

        if (isGiant)
            setTrunkBaseToDirt(world, replacer, random, blockPos, config, 4);
        else
            setTrunkBaseToDirt(world, replacer, random, blockPos, config, 3);

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int i = 0; i < height; i++)
        {
            if (isGiant)
            {
                this.setLog(world, replacer, random, mutable, config, startPos, 1, i, 0);
                this.setLog(world, replacer, random, mutable, config, startPos, 1, i, 1);
                this.setLog(world, replacer, random, mutable, config, startPos, 0, i, 1);
            }
            if (!isGiant || i < height/3)
            {
                this.setLog(world, replacer, random, mutable, config, startPos, 0, i, 0);
            }
            if (i < height - 1)
            {
                if (!isGiant)
                {
                    this.setLog(world, replacer, random, mutable, config, startPos, 1, i, 0);
                    this.setLog(world, replacer, random, mutable, config, startPos, 1, i, 1);
                    this.setLog(world, replacer, random, mutable, config, startPos, 0, i, 1);
                }
                else
                {
                    this.setLog(world, replacer, random, mutable, config, startPos, 2, i, 3);
                    this.setLog(world, replacer, random, mutable, config, startPos, 3, i, 2);
                    this.setLog(world, replacer, random, mutable, config, startPos, 1, i, 3);
                    this.setLog(world, replacer, random, mutable, config, startPos, 3, i, 1);
                }
                this.setLog(world, replacer, random, mutable, config, startPos, 1, i, 2);
                this.setLog(world, replacer, random, mutable, config, startPos, 2, i, 1);
                this.setLog(world, replacer, random, mutable, config, startPos, 2, i, 0);
                this.setLog(world, replacer, random, mutable, config, startPos, 0, i, 2);
                this.setLog(world, replacer, random, mutable, config, startPos, 2, i, 2);
                if (isGiant && (i < height/3))
                {
                    this.setLog(world, replacer, random, mutable, config, startPos, 3, i, 3);
                    this.setLog(world, replacer, random, mutable, config, startPos, 0, i, 3);
                    this.setLog(world, replacer, random, mutable, config, startPos, 3, i, 0);
                }
            }
        }

        list.addAll(ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(height), 0, true)));

        int giantShift = isGiant ? 1 : 0;

        int nonGiantShift = isGiant ? 0 : 1;

        BlockPos pos;
        int prev = -1;
        for (int i = 0; i < height; i++)
        {
            boolean canPlaceBranches = isGiant ? ((i+1) % 5 == 0 && i > 6 && i < height-5) : ((i+1) % 4 == 0 && i > 4 && i < height-5);
            if (canPlaceBranches)
            {
                int r = random.nextBetween(2,5);
                if (prev != r)
                {
                    Direction direction = Direction.byId(r);
                    switch (direction)
                    {
                        case Direction.NORTH:
                            this.setLog(world, replacer, random, mutable, config, startPos, -1, i, giantShift);
                            this.setLog(world, replacer, random, mutable, config, startPos, -2, i+1, giantShift);
                            this.setLog(world, replacer, random, mutable, config, startPos, -3, i+1, giantShift);
                            this.setLog(world, replacer, random, mutable, config, startPos, -4, i+2, giantShift);
                            pos = new BlockPos(startPos.getX()-4-nonGiantShift, startPos.getY()+(i+2), startPos.getZ()+giantShift);
                            break;
                        case Direction.SOUTH:
                            this.setLog(world, replacer, random, mutable, config, startPos, 2, i, 0);
                            this.setLog(world, replacer, random, mutable, config, startPos, 3, i+1, 0);
                            this.setLog(world, replacer, random, mutable, config, startPos, 4, i+1, 0);
                            this.setLog(world, replacer, random, mutable, config, startPos, 5, i+2, 0);
                            pos = new BlockPos(startPos.getX()+5+nonGiantShift, startPos.getY()+(i+2), startPos.getZ());
                            break;
                        case Direction.WEST:
                            this.setLog(world, replacer, random, mutable, config, startPos, 0, i, -1);
                            this.setLog(world, replacer, random, mutable, config, startPos, 0, i+1, -2);
                            this.setLog(world, replacer, random, mutable, config, startPos, 0, i+1, -3);
                            this.setLog(world, replacer, random, mutable, config, startPos, 0, i+2, -4);
                            pos = new BlockPos(startPos.getX(), startPos.getY()+(i+2), startPos.getZ()-4-nonGiantShift);
                            break;
                        default:
                            this.setLog(world, replacer, random, mutable, config, startPos, giantShift, i, 2);
                            this.setLog(world, replacer, random, mutable, config, startPos, giantShift, i+1, 3);
                            this.setLog(world, replacer, random, mutable, config, startPos, giantShift, i+1, 4);
                            this.setLog(world, replacer, random, mutable, config, startPos, giantShift, i+2, 5);
                            pos = new BlockPos(startPos.getX()+giantShift, startPos.getY()+(i+2), startPos.getZ()+5+nonGiantShift);
                            break;
                    }

                    list.add(new FoliagePlacer.TreeNode(pos.up(), -2, false));
                }
                prev = r;
            }
        }
        return list;
    }

    private void setTrunkBaseToDirt(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer,
                                    Random random, BlockPos blockPos, TreeFeatureConfig config, int size)
    {
        for (int dx = 0; dx < size; dx++)
        {
            for (int dz = 0; dz < size; dz++)
            {
                setToDirt(world, replacer, random, blockPos.east(dx).south(dz), config);
            }
        }
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