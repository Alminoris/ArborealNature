package net.alminoris.arborealnature.world.gen.root.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.arborealnature.world.gen.root.ModRootPlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.root.AboveRootPlacement;
import net.minecraft.world.gen.root.MangroveRootPlacement;
import net.minecraft.world.gen.root.MangroveRootPlacer;
import net.minecraft.world.gen.root.RootPlacerType;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.Optional;
import java.util.function.BiConsumer;

public class FluidLevelAdaptiveMangroveRootPlacer extends MangroveRootPlacer {
    public static final MapCodec<FluidLevelAdaptiveMangroveRootPlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> method_43182(instance)
                    .and(MangroveRootPlacement.CODEC.fieldOf("mangrove_root_placement").forGetter(rootPlacer -> rootPlacer.mangroveRootPlacement))
                    .apply(instance, FluidLevelAdaptiveMangroveRootPlacer::new)
    );
    private final MangroveRootPlacement mangroveRootPlacement;

    public FluidLevelAdaptiveMangroveRootPlacer(IntProvider trunkOffsetY, BlockStateProvider rootProvider, Optional<AboveRootPlacement> aboveRootPlacement, MangroveRootPlacement mangroveRootPlacement) {
        super(trunkOffsetY, rootProvider, aboveRootPlacement, mangroveRootPlacement);
        this.mangroveRootPlacement = mangroveRootPlacement;
    }

    @Override
    public boolean generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos pos, BlockPos trunkPos, TreeFeatureConfig config) {
        int minY = -64;
        int maxY = 320;
        if (world instanceof WorldView view) {
            minY = view.getBottomY();
        }
        final int x = pos.getX();
        final int z = pos.getZ();
        final int startY = pos.getY();

        int foundWaterY = Integer.MIN_VALUE;
        for (int y = startY; y <= maxY; y++) {
            BlockPos p = new BlockPos(x, y, z);
            if (world.testFluidState(p, fs -> fs.isIn(FluidTags.WATER))) {
                foundWaterY = y;
                break;
            }
        }
        if (foundWaterY == Integer.MIN_VALUE) {
            for (int y = startY - 1; y >= minY; y--) {
                BlockPos p = new BlockPos(x, y, z);
                if (world.testFluidState(p, fs -> fs.isIn(FluidTags.WATER))) {
                    foundWaterY = y;
                    break;
                }
            }
        }
        if (foundWaterY == Integer.MIN_VALUE) {
            return super.generate(world, replacer, random, pos, trunkPos, config);
        }

        int topWaterY = foundWaterY;
        for (int y = foundWaterY + 1; y <= maxY; y++) {
            BlockPos p = new BlockPos(x, y, z);
            if (world.testFluidState(p, fs -> fs.isIn(FluidTags.WATER))) {
                topWaterY = y;
            } else {
                break;
            }
        }

        int waterDepth = 0;
        for (int y = topWaterY; y >= minY; y--) {
            BlockPos p = new BlockPos(x, y, z);
            if (world.testFluidState(p, fs -> fs.isIn(FluidTags.WATER))) {
                waterDepth++;
            } else {
                break;
            }
        }

        if (waterDepth == 0 || waterDepth > 5) return false;

        return super.generate(world, replacer, random, pos.up(waterDepth + 1), trunkPos.up(waterDepth), config);
    }

    @Override
    protected void placeRoots(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos pos, TreeFeatureConfig config) {
        BlockState stateToPlace = world.testBlockState(pos, s -> s.isIn(this.mangroveRootPlacement.muddyRootsIn()))
                ? this.mangroveRootPlacement.muddyRootsProvider().get(random, pos)
                : this.rootProvider.get(random, pos);
        replacer.accept(pos, this.applyWaterlogging(world, pos, stateToPlace));

        BlockPos.Mutable cur = pos.mutableCopy().move(Direction.DOWN);
        int limit = this.mangroveRootPlacement.maxRootLength();
        int n = 0;
        while (n < limit && world.testFluidState(cur, fs -> fs.isIn(FluidTags.WATER))) {
            replacer.accept(cur, this.applyWaterlogging(world, cur, stateToPlace));
            cur.move(Direction.DOWN);
            n++;
        }
    }

    @Override
    protected RootPlacerType<?> getType() {
        return ModRootPlacerTypes.FLUID_ADAPTIVE_MANGROVE_ROOT_PLACER;
    }
}