package net.alminoris.arborealnature.world.tree;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class ExtendedSaplingGenerator
{
    private static final Map<String, ExtendedSaplingGenerator> GENERATORS = new Object2ObjectArrayMap<>();
    public static final Codec<ExtendedSaplingGenerator> CODEC =
            Codec.stringResolver(generator -> generator.id, GENERATORS::get);

    private final String id;
    private final float rareChance;

    private final Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega2x2Variant;
    private final Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega3x3Variant;
    private final Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega4x4Variant;
    private final Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega5x5Variant;

    private final Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareMegaVariant;
    private final Optional<RegistryKey<ConfiguredFeature<?, ?>>> regularVariant;
    private final Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareRegularVariant;
    private final Optional<RegistryKey<ConfiguredFeature<?, ?>>> beesVariant;
    private final Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareBeesVariant;

    public ExtendedSaplingGenerator(
            String id,
            float rareChance,
            Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega2x2Variant,
            Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega3x3Variant,
            Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega4x4Variant,
            Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega5x5Variant,
            Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareMegaVariant,
            Optional<RegistryKey<ConfiguredFeature<?, ?>>> regularVariant,
            Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareRegularVariant,
            Optional<RegistryKey<ConfiguredFeature<?, ?>>> beesVariant,
            Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareBeesVariant
    ) {
        this.id = id;
        this.rareChance = rareChance;
        this.mega2x2Variant = mega2x2Variant;
        this.mega3x3Variant = mega3x3Variant;
        this.mega4x4Variant = mega4x4Variant;
        this.mega5x5Variant = mega5x5Variant;
        this.rareMegaVariant = rareMegaVariant;
        this.regularVariant = regularVariant;
        this.rareRegularVariant = rareRegularVariant;
        this.beesVariant = beesVariant;
        this.rareBeesVariant = rareBeesVariant;
        GENERATORS.put(id, this);
    }

    /* ===============================
       Large Tree (NxN) Generation
       =============================== */
    private static boolean canGenerateLargeTree(BlockState state, BlockView world, BlockPos pos, int size, int offsetX, int offsetZ) {
        Block block = state.getBlock();
        for (int x = 0; x < size; x++) {
            for (int z = 0; z < size; z++) {
                if (!world.getBlockState(pos.add(offsetX + x, 0, offsetZ + z)).isOf(block)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean tryGenerateLargeTree(ServerWorld world, ChunkGenerator chunkGenerator, BlockPos pos,
                                         BlockState state, Random random,
                                         RegistryEntry<ConfiguredFeature<?, ?>> feature,
                                         int size, int offsetX, int offsetZ) {
        BlockState air = Blocks.AIR.getDefaultState();

        // Clear NxN saplings
        for (int x = 0; x < size; x++) {
            for (int z = 0; z < size; z++) {
                world.setBlockState(pos.add(offsetX + x, 0, offsetZ + z), air, Block.NO_REDRAW);
            }
        }

        boolean success = feature.value().generate(world, chunkGenerator, random, pos.add(offsetX, 0, offsetZ));

        if (!success) {
            // Restore saplings if failed
            for (int x = 0; x < size; x++) {
                for (int z = 0; z < size; z++) {
                    world.setBlockState(pos.add(offsetX + x, 0, offsetZ + z), state, Block.NO_REDRAW);
                }
            }
        }
        return success;
    }

    @Nullable
    private RegistryKey<ConfiguredFeature<?, ?>> getMegaTreeFeature(int size, Random random) {
        switch (size) {
            case 5: return this.mega5x5Variant.orElse(null);
            case 4: return this.mega4x4Variant.orElse(null);
            case 3: return this.mega3x3Variant.orElse(null);
            case 2: return this.mega2x2Variant.orElse(null);
        }
        return null;
    }

    /* ===============================
       Main Generation
       =============================== */
    public boolean generate(ServerWorld world, ChunkGenerator chunkGenerator, BlockPos pos,
                            BlockState state, Random random) {

        // Try multi-sapling mega trees first
        int[] sizes = {5, 4, 3, 2}; // biggest first
        for (int size : sizes) {
            RegistryKey<ConfiguredFeature<?, ?>> featureKey = getMegaTreeFeature(size, random);
            if (featureKey == null) continue;

            RegistryEntry<ConfiguredFeature<?, ?>> entry =
                    world.getRegistryManager().get(RegistryKeys.CONFIGURED_FEATURE).getEntry(featureKey).orElse(null);
            if (entry == null) continue;

            for (int offsetX = 1 - size; offsetX <= 0; offsetX++) {
                for (int offsetZ = 1 - size; offsetZ <= 0; offsetZ++) {
                    if (canGenerateLargeTree(state, world, pos, size, offsetX, offsetZ)) {
                        if (tryGenerateLargeTree(world, chunkGenerator, pos, state, random, entry, size, offsetX, offsetZ)) {
                            return true;
                        }
                    }
                }
            }
        }

        // Otherwise, fall back to small tree
        RegistryKey<ConfiguredFeature<?, ?>> smallTree = this.getSmallTreeFeature(random, this.areFlowersNearby(world, pos));
        if (smallTree == null) return false;

        RegistryEntry<ConfiguredFeature<?, ?>> entry =
                world.getRegistryManager().get(RegistryKeys.CONFIGURED_FEATURE).getEntry(smallTree).orElse(null);
        if (entry == null) return false;

        BlockState fluidState = world.getFluidState(pos).getBlockState();
        world.setBlockState(pos, fluidState, Block.NO_REDRAW);

        if (entry.value().generate(world, chunkGenerator, random, pos)) {
            if (world.getBlockState(pos) == fluidState) {
                world.updateListeners(pos, state, fluidState, Block.NOTIFY_LISTENERS);
            }
            return true;
        } else {
            world.setBlockState(pos, state, Block.NO_REDRAW);
            return false;
        }
    }

    @Nullable
    private RegistryKey<ConfiguredFeature<?, ?>> getSmallTreeFeature(Random random, boolean flowersNearby) {
        if (random.nextFloat() < this.rareChance) {
            if (flowersNearby && this.rareBeesVariant.isPresent()) {
                return this.rareBeesVariant.get();
            }
            if (this.rareRegularVariant.isPresent()) {
                return this.rareRegularVariant.get();
            }
        }
        return flowersNearby && this.beesVariant.isPresent()
                ? this.beesVariant.get()
                : this.regularVariant.orElse(null);
    }

    private boolean areFlowersNearby(WorldAccess world, BlockPos pos) {
        for (BlockPos check : BlockPos.Mutable.iterate(pos.down().north(2).west(2), pos.up().south(2).east(2))) {
            if (world.getBlockState(check).isIn(BlockTags.FLOWERS)) {
                return true;
            }
        }
        return false;
    }
}
