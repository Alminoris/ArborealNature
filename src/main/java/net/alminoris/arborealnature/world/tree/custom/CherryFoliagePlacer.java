package net.alminoris.arborealnature.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.arborealnature.world.tree.ModFoliagePlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.function.BiConsumer;

public class CherryFoliagePlacer extends FoliagePlacer
{
    public static final Codec<CherryFoliagePlacer> CODEC = RecordCodecBuilder.create(
            instance -> fillFoliagePlacerFields(instance)
                    .<IntProvider, Float, Float, Float, Float>and(
                            instance.group(
                                    IntProvider.createValidatingCodec(4, 16).fieldOf("height").forGetter(foliagePlacer -> foliagePlacer.height),
                                    Codec.floatRange(0.0F, 1.0F).fieldOf("wide_bottom_layer_hole_chance").forGetter(foliagePlacer -> foliagePlacer.wideBottomLayerHoleChance),
                                    Codec.floatRange(0.0F, 1.0F).fieldOf("corner_hole_chance").forGetter(foliagePlacer -> foliagePlacer.wideBottomLayerHoleChance),
                                    Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_leaves_chance").forGetter(foliagePlacer -> foliagePlacer.hangingLeavesChance),
                                    Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_leaves_extension_chance").forGetter(foliagePlacer -> foliagePlacer.hangingLeavesExtensionChance)
                            )
                    )
                    .apply(instance, CherryFoliagePlacer::new)
    );
    private final IntProvider height;
    private final float wideBottomLayerHoleChance;
    private final float cornerHoleChance;
    private final float hangingLeavesChance;
    private final float hangingLeavesExtensionChance;

    public CherryFoliagePlacer(
            IntProvider radius,
            IntProvider offset,
            IntProvider height,
            float wideBottomLayerHoleChance,
            float cornerHoleChance,
            float hangingLeavesChance,
            float hangingLeavesExtensionChance
    ) {
        super(radius, offset);
        this.height = height;
        this.wideBottomLayerHoleChance = wideBottomLayerHoleChance;
        this.cornerHoleChance = cornerHoleChance;
        this.hangingLeavesChance = hangingLeavesChance;
        this.hangingLeavesExtensionChance = hangingLeavesExtensionChance;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.CHERRY_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        boolean bl = treeNode.isGiantTrunk();
        BlockPos blockPos = treeNode.getCenter().up(offset);
        int i = radius + treeNode.getFoliageRadius() - 1;
        this.generateSquare(world, replacer, random, config, blockPos, i - 2, foliageHeight - 3, bl);
        this.generateSquare(world, replacer, random, config, blockPos, i - 1, foliageHeight - 4, bl);

        for (int j = foliageHeight - 5; j >= 0; j--) {
            this.generateSquare(world, replacer, random, config, blockPos, i, j, bl);
        }

        this.generateSquareWithHangingLeaves(world, replacer, random, config, blockPos, i, -1, bl, this.hangingLeavesChance, this.hangingLeavesExtensionChance);
        this.generateSquareWithHangingLeaves(world, replacer, random, config, blockPos, i - 1, -2, bl, this.hangingLeavesChance, this.hangingLeavesExtensionChance);
    }

    protected final void generateSquareWithHangingLeaves(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, TreeFeatureConfig config,
            BlockPos centerPos, int radius, int y, boolean giantTrunk, float hangingLeavesChance, float hangingLeavesExtensionChance)
    {
        this.generateSquare(world, replacer, random, config, centerPos, radius, y, giantTrunk);
        int i = giantTrunk ? 1 : 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (Direction direction : Direction.Type.HORIZONTAL)
        {
            Direction direction2 = direction.rotateYClockwise();
            int j = direction2.getDirection() == Direction.AxisDirection.POSITIVE ? radius + i : radius;
            mutable.set(centerPos, 0, y - 1, 0).move(direction2, j).move(direction, -radius);
            int k = -radius;

            while (k < radius + i)
            {
                boolean bl = !world.testBlockState(mutable, BlockState::isAir);
                mutable.move(Direction.DOWN);
                if (bl && !(random.nextFloat() > hangingLeavesChance) && placeCherryFoliageBlock(world, replacer, random, config, mutable)
                        && !(random.nextFloat() > hangingLeavesExtensionChance))
                {
                    placeCherryFoliageBlock(world, replacer, random, config, mutable.move(Direction.DOWN));
                    mutable.move(Direction.UP);
                }

                k++;
                mutable.move(direction);
            }
        }
    }

    protected static boolean placeCherryFoliageBlock(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, TreeFeatureConfig config, BlockPos pos) {
        if (!TreeFeature.canReplace(world, pos))
        {
            return false;
        }
        else
        {
            BlockState blockState = config.foliageProvider.getBlockState(random, pos);
            if (blockState.contains(Properties.WATERLOGGED))
            {
                blockState = blockState.with(Properties.WATERLOGGED, Boolean.valueOf(world.testFluidState(pos, fluidState -> fluidState.isEqualAndStill(Fluids.WATER))));
            }

            replacer.accept(pos, blockState);
            return true;
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height.get(random);
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        if (y == -1 && (dx == radius || dz == radius) && random.nextFloat() < this.wideBottomLayerHoleChance) {
            return true;
        } else {
            boolean bl = dx == radius && dz == radius;
            boolean bl2 = radius > 2;
            return bl2 ? bl || dx + dz > radius * 2 - 2 && random.nextFloat() < this.cornerHoleChance : bl && random.nextFloat() < this.cornerHoleChance;
        }
    }
}
