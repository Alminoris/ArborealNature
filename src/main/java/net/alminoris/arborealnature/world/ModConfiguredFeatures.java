package net.alminoris.arborealnature.world;

import com.google.common.collect.ImmutableList;
import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.block.custom.BerryBushBlock;
import net.alminoris.arborealnature.util.helper.ModBlockSetsHelper;
import net.alminoris.arborealnature.world.gen.decorator.custom.CustomAlterGroundTreeDecorator;
import net.alminoris.arborealnature.world.gen.decorator.custom.CustomVineLogDecorator;
import net.alminoris.arborealnature.world.gen.decorator.custom.LeafCarpetDecorator;
import net.alminoris.arborealnature.world.gen.decorator.custom.CustomVineDecorator;
import net.alminoris.arborealnature.world.gen.feature.ModFeatures;
import net.alminoris.arborealnature.world.tree.custom.*;
import net.minecraft.block.*;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.*;

import java.util.List;
import java.util.OptionalInt;

import static net.alminoris.arborealnature.util.helper.ModBlockSetsHelper.BUSHES;

public class ModConfiguredFeatures
{
    public static RegistryKey<ConfiguredFeature<?, ?>> HAZELNUT_KEY = registerKey("hazelnut");

    public static RegistryKey<ConfiguredFeature<?, ?>> HORNBEAM_KEY = registerKey("hornbeam");

    public static RegistryKey<ConfiguredFeature<?, ?>> HAWTHORN_KEY = registerKey("hawthorn");

    public static RegistryKey<ConfiguredFeature<?, ?>> QUINCE_KEY = registerKey("quince");

    public static RegistryKey<ConfiguredFeature<?, ?>> PLUM_KEY = registerKey("plum");

    public static RegistryKey<ConfiguredFeature<?, ?>> MANGO_KEY = registerKey("mango");

    public static RegistryKey<ConfiguredFeature<?, ?>> FIG_KEY = registerKey("fig");

    public static RegistryKey<ConfiguredFeature<?, ?>> VIBURNUM_KEY = registerKey("viburnum");

    public static RegistryKey<ConfiguredFeature<?, ?>> WILD_CHERRY_KEY = registerKey("wild_cherry");

    public static RegistryKey<ConfiguredFeature<?, ?>> WHITE_MULBERRY_KEY = registerKey("white_mulberry");

    public static RegistryKey<ConfiguredFeature<?, ?>> BAUHINIA_KEY = registerKey("bauhinia");

    public static RegistryKey<ConfiguredFeature<?, ?>> PINE_KEY = registerKey("pine");

    public static RegistryKey<ConfiguredFeature<?, ?>> FIR_KEY = registerKey("fir");

    public static RegistryKey<ConfiguredFeature<?, ?>> ARAUCARIA_KEY = registerKey("araucaria");

    public static RegistryKey<ConfiguredFeature<?, ?>> JUNIPER_KEY = registerKey("juniper");

    public static RegistryKey<ConfiguredFeature<?, ?>> CEDAR_KEY = registerKey("cedar");

    public static RegistryKey<ConfiguredFeature<?, ?>> MEGA_PINE_KEY = registerKey("mega_pine");

    public static RegistryKey<ConfiguredFeature<?, ?>> BILBERRY_KEY = registerKey("bilberry");

    public static RegistryKey<ConfiguredFeature<?, ?>> BLACKBERRY_KEY = registerKey("blackberry");

    public static RegistryKey<ConfiguredFeature<?, ?>> BLUEBERRY_KEY = registerKey("blueberry");

    public static RegistryKey<ConfiguredFeature<?, ?>> PINK_CURRANT_KEY = registerKey("pink_currant");

    public static RegistryKey<ConfiguredFeature<?, ?>> LARGE_CELANDINE_KEY = registerKey("large_celandine");

    public static RegistryKey<ConfiguredFeature<?, ?>> BLUEGRASS_KEY = registerKey("bluegrass");

    public static RegistryKey<ConfiguredFeature<?, ?>> GERANIUM_KEY = registerKey("geranium");

    public static RegistryKey<ConfiguredFeature<?, ?>> XEROCHRYSUM_KEY = registerKey("xerochrysum");

    public static RegistryKey<ConfiguredFeature<?, ?>> THISTLE_KEY = registerKey("thistle");

    public static RegistryKey<ConfiguredFeature<?, ?>> PRICKLY_GRASS_KEY = registerKey("prickly_grass");

    public static RegistryKey<ConfiguredFeature<?, ?>> BLUEBELL_KEY = registerKey("bluebell");

    public static RegistryKey<ConfiguredFeature<?, ?>> LARGE_ORCHID_KEY = registerKey("large_orchid");

    public static RegistryKey<ConfiguredFeature<?, ?>> ORCHID_KEY = registerKey("orchid");

    public static RegistryKey<ConfiguredFeature<?, ?>> ORCHID_LILY_KEY = registerKey("orchid_lily");

    public static RegistryKey<ConfiguredFeature<?, ?>> WOOD_ANEMONA_KEY = registerKey("wood_anemona");

    public static RegistryKey<ConfiguredFeature<?, ?>> WOOD_SORREL_KEY = registerKey("wood_sorrel");

    public static RegistryKey<ConfiguredFeature<?, ?>> FIR_FOREST_GRASS_KEY = registerKey("fir_forest_grass");

    public static RegistryKey<ConfiguredFeature<?, ?>> WHITE_MUSHROOM_KEY = registerKey("white_mushroom");

    public static RegistryKey<ConfiguredFeature<?, ?>> HUGE_WHITE_MUSHROOM_KEY = registerKey("huge_white_mushroom");

    public static RegistryKey<ConfiguredFeature<?, ?>> PINE_FOREST_FLOWERS_KEY = registerKey("pine_forest_flowers");

    public static RegistryKey<ConfiguredFeature<?, ?>> PINE_FOREST_GRASS_KEY = registerKey("pine_forest_grass");

    public static RegistryKey<ConfiguredFeature<?, ?>> ARAUCARIA_SAVANNA_GRASS_KEY = registerKey("araucaria_savanna_grass");

    public static RegistryKey<ConfiguredFeature<?, ?>> COBBLESTONE_ROCK_KEY = registerKey("cobblestone_rock");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context)
    {
        register(context, HAZELNUT_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("hazelnut")),
                new LargeHazelnutTrunkPlacer(5, 3, 5),

                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("hazelnut")),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(4),
                        0.25F, 0.5F, 0.16666667F, 0.33333334F),

                new TwoLayersFeatureSize(2, 2, 0)).ignoreVines().decorators(ImmutableList.of(
                        new LeafCarpetDecorator(BlockStateProvider.of(ModBlocks.HAZELNUT_COVER), 2, 0.75f))).ignoreVines().build());

        register(context, HORNBEAM_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("hornbeam")),
                new LargeHornbeamTrunkPlacer(7, 2, 3),

                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("hornbeam")),
                new LargeHornbeamFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0),5),

                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());

        register(context, HAWTHORN_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("hawthorn")),
                new LargeOakTrunkPlacer(6, 2, 2),

                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("hawthorn")),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(7),
                        0.25F, 0.5F, 0.08F, 0.16F),

                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());

        register(context, QUINCE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("quince")),
                new ForkingTrunkPlacer(5, 2, 2),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("quince")),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build());

        register(context, PLUM_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("plum")),
                new CherryTrunkPlacer(
                        2,
                        2,
                        3,
                        ConstantIntProvider.create(3),
                        UniformIntProvider.create(2, 4),
                        UniformIntProvider.create(-1, 0),
                        ConstantIntProvider.create(1)
                ),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("plum")),
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
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("mango")),
                new CherryTrunkPlacer(
                        4,
                        2,
                        3,
                        ConstantIntProvider.create(2),
                        UniformIntProvider.create(2, 4),
                        UniformIntProvider.create(-1, 0),
                        ConstantIntProvider.create(1)
                ),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("mango")),
                new LargeOakFoliagePlacer(
                        UniformIntProvider.create(2, 4),
                        UniformIntProvider.create(0, 2),
                        4
                ),
                new TwoLayersFeatureSize(1, 0, 1)
        ).decorators(List.of(new LeavesVineTreeDecorator(0.33f))).build());

        register(context, FIG_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("fig")),
                new ForkingTrunkPlacer(2, 2, 2),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("fig")),
                new BlobFoliagePlacer(
                        ConstantIntProvider.create(2),
                        ConstantIntProvider.create(2),
                        3
                ),
                new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build());

        register(context, VIBURNUM_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("viburnum")),
                new ViburnumTrunkPlacer(3, 5, 0),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("viburnum")),
                new BlobFoliagePlacer(ConstantIntProvider.create(2),  ConstantIntProvider.create(2), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build());

        register(context, WILD_CHERRY_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("wild_cherry")),
                new StraightTrunkPlacer(3, 3, 2),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("wild_cherry")),
                new WildCherryFoliagePlacer(ConstantIntProvider.create(4),  ConstantIntProvider.create(1), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build());

        register(context, WHITE_MULBERRY_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("white_mulberry")),
                new ForkingTrunkPlacer(3, 5, 2),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("white_mulberry")),
                new WhiteMulberryFoliagePlacer(ConstantIntProvider.create(3),  ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build());

        register(context, BAUHINIA_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("bauhinia")),
                new StraightTrunkPlacer(3, 2, 0),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("bauhinia")),
                new BlobFoliagePlacer(
                        ConstantIntProvider.create(3),
                        ConstantIntProvider.create(2),
                        3
                ),
                new TwoLayersFeatureSize(1, 0, 2)
        ).decorators(ImmutableList.of(
                new CustomVineDecorator(0.05f, ModBlocks.BAUHINIA_VINES),
                new LeafCarpetDecorator(BlockStateProvider.of(ModBlocks.BAUHINIA_COVER), 2, 0.75f),
                new CustomAlterGroundTreeDecorator(0.05f, BlockStateProvider.of(Blocks.WATER)),
                new CustomAlterGroundTreeDecorator(0.05f, BlockStateProvider.of(ModBlocks.ORCHID_GRASS_BLOCK)))).build());

        register(context, PINE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("pine")),
                new StraightTrunkPlacer(6, 4, 0),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("pine")),
                new PineFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), UniformIntProvider.create(3, 4)),
                new TwoLayersFeatureSize(2, 0, 2)
        ).ignoreVines().decorators(ImmutableList.of(
                new LeafCarpetDecorator(BlockStateProvider.of(ModBlocks.PINE_COVER), 2, 0.75f),
                new CustomVineLogDecorator(0.5f, ModBlocks.PINE_RESIN),
                new CustomAlterGroundTreeDecorator(0.15f, BlockStateProvider.of(ModBlocks.DIRTED_GRASS_BLOCK)))).build());

        register(context, FIR_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("fir")),
                new FirTrunkPlacer(6),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("fir")),
                new FirFoliagePlacer(
                        ConstantIntProvider.create(1),
                        ConstantIntProvider.create(0),
                        ConstantIntProvider.create(6)
                ),
                new TwoLayersFeatureSize(3, 0, 3))
                .ignoreVines().decorators(ImmutableList.of(new LeafCarpetDecorator(BlockStateProvider.of(ModBlocks.REINDEER_LICHEN_CARPET), 0, 0.05f),
                        new LeafCarpetDecorator(BlockStateProvider.of(Blocks.SNOW), 5, 0.35f))).build());

        register(context, ARAUCARIA_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("araucaria")),
                new StraightTrunkPlacer(6, 2, 0),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("araucaria")),
                new AraucariaFoliagePlacer(
                        ConstantIntProvider.create(3),
                        ConstantIntProvider.create(0)
                ),
                new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build());

        register(context, JUNIPER_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("juniper")),
                new ForkingTrunkPlacer(4, 2, 1),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("juniper")),
                new DarkOakFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(1, 0, 2)
        ).ignoreVines().decorators(ImmutableList.of(
                new LeafCarpetDecorator(BlockStateProvider.of(ModBlocks.JUNIPER_COVER), 2, 0.75f))).build());


        register(context, CEDAR_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("cedar")),
                new CedarGiantTrunkPlacer(13, 3, 4),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("cedar")),
                new CedarGiantFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
        ).ignoreVines().decorators(ImmutableList.of(
                new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)),
                new LeafCarpetDecorator(BlockStateProvider.of(Blocks.SNOW), 5, 0.45f))).build());

        register(context, MEGA_PINE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("pine")),
                new GiantTrunkPlacer(13, 2, 14),
                BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get("pine")),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(3, 7)),
                new TwoLayersFeatureSize(1, 1, 2)
        ).ignoreVines().decorators(ImmutableList.of(
                new CustomVineLogDecorator(0.5f, ModBlocks.PINE_RESIN),
                new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)))).build());

        register(context, FIR_FOREST_GRASS_KEY, Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig(
                        new WeightedBlockStateProvider(DataPool.<BlockState>builder().
                                add(Blocks.GRASS.getDefaultState(), 35).
                                add(Blocks.FERN.getDefaultState(), 55)), 512
                ));

        register(context, PINE_FOREST_FLOWERS_KEY, Feature.SIMPLE_RANDOM_SELECTOR,
                new SimpleRandomFeatureConfig(
                        RegistryEntryList.of(
                                PlacedFeatures.createEntry(
                                        Feature.RANDOM_PATCH,
                                        ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.CORNFLOWER)))
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.RANDOM_PATCH,
                                        ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.OXEYE_DAISY)))
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.NO_BONEMEAL_FLOWER,
                                        ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.LILY_OF_THE_VALLEY)))
                                )
                        )
                ));

        register(context, PINE_FOREST_GRASS_KEY, Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig(
                        new WeightedBlockStateProvider(DataPool.<BlockState>builder().
                                add(Blocks.GRASS.getDefaultState(), 55).
                                add(Blocks.FERN.getDefaultState(), 15).
                                add(Blocks.TALL_GRASS.getDefaultState(), 30)), 128
                ));

        register(context, ARAUCARIA_SAVANNA_GRASS_KEY, Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig(
                        new WeightedBlockStateProvider(DataPool.<BlockState>builder().
                                add(Blocks.GRASS.getDefaultState(), 1)), 1024
                ));

        register(context, WHITE_MUSHROOM_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WHITE_MUSHROOM))));

        register(context, LARGE_CELANDINE_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LARGE_CELANDINE))));

        register(context, BLUEGRASS_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUEGRASS))));

        register(context, GERANIUM_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GERANIUM))));

        register(context, XEROCHRYSUM_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.XEROCHRYSUM))));

        register(context, THISTLE_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THISTLE))));

        register(context, PRICKLY_GRASS_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PRICKLY_GRASS))));

        register(context, BLUEBELL_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUEBELL))));

        register(context, LARGE_ORCHID_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LARGE_ORCHID)),
                        List.of(Blocks.GRASS_BLOCK, Blocks.DIRT),
                        64));

        register(context, ORCHID_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ORCHID))));

        DataPool.Builder<BlockState> builder = DataPool.builder();
        for (int i = 1; i <= 4; i++)
            for (Direction direction : Direction.Type.HORIZONTAL)
                builder.add(ModBlocks.WOOD_ANEMONA.getDefaultState().with(FlowerbedBlock.FLOWER_AMOUNT, Integer.valueOf(i)).with(FlowerbedBlock.FACING, direction), 1);

        register(context, WOOD_ANEMONA_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(96, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(builder)))));

        DataPool.Builder<BlockState> builder1 = DataPool.builder();
        for (int i = 1; i <= 4; i++)
            for (Direction direction : Direction.Type.HORIZONTAL)
                builder1.add(ModBlocks.WOOD_SORREL.getDefaultState().with(FlowerbedBlock.FLOWER_AMOUNT, Integer.valueOf(i)).with(FlowerbedBlock.FACING, direction), 1);

        register(context, WOOD_SORREL_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(96, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(builder1)))));

        register(context, BILBERRY_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(BUSHES.get("bilberry").getDefaultState().with(BerryBushBlock.AGE, Integer.valueOf(3)))),
                        List.of(Blocks.GRASS_BLOCK)
                )
        );

        register(context, BLACKBERRY_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(BUSHES.get("blackberry").getDefaultState().with(BerryBushBlock.AGE, Integer.valueOf(3)))),
                        List.of(Blocks.GRASS_BLOCK)
                )
        );

        register(context, BLUEBERRY_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(BUSHES.get("blueberry").getDefaultState().with(BerryBushBlock.AGE, Integer.valueOf(3)))),
                        List.of(Blocks.GRASS_BLOCK)
                )
        );

        register(context, PINK_CURRANT_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(BUSHES.get("pink_currant").getDefaultState().with(BerryBushBlock.AGE, Integer.valueOf(3)))),
                        List.of(Blocks.GRASS_BLOCK)
                )
        );

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

        register(context, ORCHID_LILY_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        10, 7, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ORCHID_LILY_PAD)))
                )
        );

        register(context, COBBLESTONE_ROCK_KEY, Feature.FOREST_ROCK, new SingleStateFeatureConfig(Blocks.COBBLESTONE.getDefaultState()));
    }

    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries)
    {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(block)));
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