package net.alminoris.arborealnature.world;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.util.helper.ModWoodHelper;
import net.alminoris.arborealnature.world.gen.decorator.custom.LeafCarpetDecorator;
import net.alminoris.arborealnature.world.gen.feature.ModFeatures;
import net.alminoris.arborealnature.world.tree.custom.LargeHazelnutTrunkPlacer;
import net.alminoris.arborealnature.world.tree.custom.LargeHornbeamFoliagePlacer;
import net.alminoris.arborealnature.world.tree.custom.LargeHornbeamTrunkPlacer;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.block.MushroomBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;

import java.util.List;

public class ModConfiguredFeautures
{
    public static RegistryKey<ConfiguredFeature<?, ?>> HAZELNUT_KEY = registerKey("hazelnut");

    public static RegistryKey<ConfiguredFeature<?, ?>> HORNBEAM_KEY = registerKey("hornbeam");

    public static RegistryKey<ConfiguredFeature<?, ?>> HAWTHORN_KEY = registerKey("hawthorn");

    public static RegistryKey<ConfiguredFeature<?, ?>> QUINCE_KEY = registerKey("quince");

    public static RegistryKey<ConfiguredFeature<?, ?>> PLUM_KEY = registerKey("plum");

    public static RegistryKey<ConfiguredFeature<?, ?>> MANGO_KEY = registerKey("mango");

    public static RegistryKey<ConfiguredFeature<?, ?>> LARGE_CELANDINE_KEY = registerKey("large_celandine");

    public static RegistryKey<ConfiguredFeature<?, ?>> WOOD_ANEMONA_KEY = registerKey("wood_anemona");

    public static RegistryKey<ConfiguredFeature<?, ?>> WHITE_MUSHROOM_KEY = registerKey("white_mushroom");

    public static RegistryKey<ConfiguredFeature<?, ?>> HUGE_WHITE_MUSHROOM_KEY = registerKey("huge_white_mushroom");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context)
    {
        register(context, HAZELNUT_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModWoodHelper.LOGS.get("hazelnut")),
                new LargeHazelnutTrunkPlacer(5, 3, 5),

                BlockStateProvider.of(ModWoodHelper.LEAVES.get("hazelnut")),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(4),
                        0.25F, 0.5F, 0.16666667F, 0.33333334F),

                new TwoLayersFeatureSize(2, 2, 0)).decorators(List.of(new LeafCarpetDecorator())).ignoreVines().build());

        register(context, HORNBEAM_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModWoodHelper.LOGS.get("hornbeam")),
                new LargeHornbeamTrunkPlacer(7, 2, 3),

                BlockStateProvider.of(ModWoodHelper.LEAVES.get("hornbeam")),
                new LargeHornbeamFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0),5),

                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());

        register(context, HAWTHORN_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModWoodHelper.LOGS.get("hawthorn")),
                new LargeOakTrunkPlacer(6, 2, 2),

                BlockStateProvider.of(ModWoodHelper.LEAVES.get("hawthorn")),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(7),
                        0.25F, 0.5F, 0.08F, 0.16F),

                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());

        register(context, QUINCE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModWoodHelper.LOGS.get("quince")),
                new ForkingTrunkPlacer(5, 2, 2),
                BlockStateProvider.of(ModWoodHelper.LEAVES.get("quince")),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build());

        register(context, PLUM_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModWoodHelper.LOGS.get("plum")),
                new CherryTrunkPlacer(
                        2,
                        2,
                        3,
                        ConstantIntProvider.create(3),
                        UniformIntProvider.create(2, 4),
                        UniformIntProvider.create(-1, 0),
                        ConstantIntProvider.create(1)
                ),
                BlockStateProvider.of(ModWoodHelper.LEAVES.get("plum")),
                new CherryFoliagePlacer(
                        ConstantIntProvider.create(4),
                        ConstantIntProvider.create(1),
                        UniformIntProvider.create(6, 7),
                        0.1f,
                        0.2f,
                        0.3f,
                        0.2f
                ),
                new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build());

        register(context, MANGO_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModWoodHelper.LOGS.get("mango")),
                new CherryTrunkPlacer(
                        4,
                        2,
                        3,
                        ConstantIntProvider.create(2),
                        UniformIntProvider.create(2, 4),
                        UniformIntProvider.create(-1, 0),
                        ConstantIntProvider.create(1)
                ),
                BlockStateProvider.of(ModWoodHelper.LEAVES.get("mango")),
                new LargeOakFoliagePlacer(
                        UniformIntProvider.create(2, 4),
                        UniformIntProvider.create(0, 2),
                        4
                ),
                new TwoLayersFeatureSize(1, 0, 1)
        ).decorators(List.of(new LeavesVineTreeDecorator(0.33f))).build());

        register(context, WHITE_MUSHROOM_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WHITE_MUSHROOM))));

        register(context, LARGE_CELANDINE_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LARGE_CELANDINE))));

        DataPool.Builder<BlockState> builder = DataPool.builder();
        for (int i = 1; i <= 4; i++)
            for (Direction direction : Direction.Type.HORIZONTAL)
                builder.add(ModBlocks.WOOD_ANEMONA.getDefaultState().with(FlowerbedBlock.FLOWER_AMOUNT, Integer.valueOf(i)).with(FlowerbedBlock.FACING, direction), 1);

        register(context, WOOD_ANEMONA_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(96, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(builder)))));

        register(context, HUGE_WHITE_MUSHROOM_KEY, ModFeatures.HUGE_WHITE_MUSHROOM,
                new HugeMushroomFeatureConfig(
                        BlockStateProvider.of(
                                ModBlocks.WHITE_MUSHROOM_BLOCK.getDefaultState().with(MushroomBlock.UP, Boolean.valueOf(true)).with(MushroomBlock.DOWN, Boolean.valueOf(false))
                        ),
                        BlockStateProvider.of(
                                ModBlocks.WHITE_MUSHROOM_STEM.getDefaultState().with(MushroomBlock.UP, Boolean.valueOf(false)).with(MushroomBlock.DOWN, Boolean.valueOf(false))
                        ),
                        2
                )
        );
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name)
    {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ArborealNature.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration)
    {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}