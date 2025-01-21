package net.alminoris.arborealnature.world;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.block.custom.BerryBushBlock;
import net.alminoris.arborealnature.block.custom.FlowerbedBlock;
import net.alminoris.arborealnature.util.helper.ModBlockSetsHelper;
import net.alminoris.arborealnature.world.gen.decorator.custom.CustomAlterGroundTreeDecorator;
import net.alminoris.arborealnature.world.gen.decorator.custom.CustomVineLogDecorator;
import net.alminoris.arborealnature.world.gen.decorator.custom.LeafCarpetDecorator;
import net.alminoris.arborealnature.world.gen.decorator.custom.CustomVineDecorator;
import net.alminoris.arborealnature.world.gen.feature.ModFeatures;
import net.alminoris.arborealnature.world.tree.custom.*;
import net.minecraft.block.*;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.FeatureSize;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.NoiseBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.trunk.*;

import java.util.List;
import java.util.OptionalInt;

import static net.alminoris.arborealnature.util.helper.ModBlockSetsHelper.*;

public class ModConfiguredFeatures
{
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> HAZELNUT_SPAWN = registerTree("hazelnut", 0.5f,
            new LargeHazelnutTrunkPlacer(5, 3, 5),
            new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(4),
                    0.25F, 0.5F, 0.16666667F, 0.33333334F),
            new TwoLayersFeatureSize(2, 2, 0),
            new LeafCarpetDecorator(BlockStateProvider.of(ModBlocks.HAZELNUT_COVER), 2, 0.75f));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> HORNBEAM_SPAWN = registerTree("hornbeam", 0.5f,
            new LargeHornbeamTrunkPlacer(7, 2, 3),
            new LargeHornbeamFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0),5),
            new TwoLayersFeatureSize(2, 0, 2));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> HAWTHORN_SPAWN = registerTree("hawthorn", 0.5f,
            new LargeOakTrunkPlacer(6, 2, 2),
            new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(7),
                    0.25F, 0.5F, 0.08F, 0.16F),
            new TwoLayersFeatureSize(2, 0, 2));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> QUINCE_SPAWN = registerTree("quince", 0.5f,
            new ForkingTrunkPlacer(5, 2, 2),
            new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
            new TwoLayersFeatureSize(1, 0, 1));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> PLUM_SPAWN = registerTree("plum", 0.5f,
            new CherryTrunkPlacer(2, 2, 3, ConstantIntProvider.create(3),
                    UniformIntProvider.create(2, 4), UniformIntProvider.create(-1, 0), ConstantIntProvider.create(1)),
            new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(1), UniformIntProvider.create(6, 7),
                    0.1f, 0.2f, 0.3f, 0.2f),
            new TwoLayersFeatureSize(1, 0, 1));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> MANGO_SPAWN = registerTree("mango", 0.5f,
            new CherryTrunkPlacer(4, 2, 3, ConstantIntProvider.create(2),
                    UniformIntProvider.create(2, 4), UniformIntProvider.create(-1, 0), ConstantIntProvider.create(1)),
            new LargeOakFoliagePlacer(UniformIntProvider.create(2, 4), UniformIntProvider.create(0, 2), 4),
            new TwoLayersFeatureSize(1, 0, 1),
            new LeavesVineTreeDecorator(0.33f));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> FIG_SPAWN = registerTree("fig", 0.5f,
            new ForkingTrunkPlacer(2, 2, 2),
            new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(2), 3),
            new TwoLayersFeatureSize(1, 0, 1));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> VIBURNUM_SPAWN = registerTree("viburnum", 0.5f,
            new ViburnumTrunkPlacer(3, 5, 0),
            new BlobFoliagePlacer(ConstantIntProvider.create(2),  ConstantIntProvider.create(2), 3),
            new TwoLayersFeatureSize(1, 0, 1));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> WILD_CHERRY_SPAWN = registerTree("wild_cherry", 0.5f,
            new StraightTrunkPlacer(3, 3, 2),
            new WildCherryFoliagePlacer(ConstantIntProvider.create(4),  ConstantIntProvider.create(1), 3),
            new TwoLayersFeatureSize(1, 0, 1));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> WHITE_MULBERRY_SPAWN = registerTree("white_mulberry", 0.5f,
            new ForkingTrunkPlacer(3, 5, 2),
            new WhiteMulberryFoliagePlacer(ConstantIntProvider.create(3),  ConstantIntProvider.create(0), 3),
            new TwoLayersFeatureSize(1, 0, 1));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> BAUHINIA_SPAWN = registerTree("bauhinia", 0.5f,
            new StraightTrunkPlacer(3, 2, 0),
            new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(2), 3),
            new TwoLayersFeatureSize(1, 0, 2),
            new CustomVineDecorator(0.05f, ModBlocks.BAUHINIA_VINES),
            new LeafCarpetDecorator(BlockStateProvider.of(ModBlocks.BAUHINIA_COVER), 2, 0.75f),
            new CustomAlterGroundTreeDecorator(0.05f, BlockStateProvider.of(Blocks.WATER)),
            new CustomAlterGroundTreeDecorator(0.05f, BlockStateProvider.of(ModBlocks.ORCHID_GRASS_BLOCK)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> PINE_SPAWN = registerTree("pine", 0.5f,
            new StraightTrunkPlacer(6, 4, 0),
            new PineFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), UniformIntProvider.create(3, 4)),
            new TwoLayersFeatureSize(3, 0, 3),
            new LeafCarpetDecorator(BlockStateProvider.of(ModBlocks.PINE_COVER), 2, 0.75f),
            new CustomVineLogDecorator(0.5f, ModBlocks.PINE_RESIN),
            new CustomAlterGroundTreeDecorator(0.15f, BlockStateProvider.of(ModBlocks.DIRTED_GRASS_BLOCK)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> MEGA_PINE_SPAWN = registerTree("mega_pine", 0.5f,
            new GiantTrunkPlacer(13, 2, 14),
            new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(3, 7)),
            new TwoLayersFeatureSize(1, 1, 2),
            new CustomVineLogDecorator(0.5f, ModBlocks.PINE_RESIN),
            new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> FIR_SPAWN = registerTree("fir", 0.5f,
            new FirTrunkPlacer(6),
            new FirFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(0), ConstantIntProvider.create(6)),
            new TwoLayersFeatureSize(1, 0, 1),
            new LeafCarpetDecorator(BlockStateProvider.of(ModBlocks.REINDEER_LICHEN_CARPET), 0, 0.05f),
            new LeafCarpetDecorator(BlockStateProvider.of(Blocks.SNOW), 5, 0.35f));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> CEDAR_SPAWN = registerTree("cedar", 0.5f,
            new CedarGiantTrunkPlacer(13, 3, 4),
            new CedarGiantFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
            new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()),
            new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)),
            new LeafCarpetDecorator(BlockStateProvider.of(Blocks.SNOW), 5, 0.45f));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> GERANIUM =
            ConfiguredFeatures.register("flower_geranium", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GERANIUM))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> BLUEGRASS =
            ConfiguredFeatures.register("flower_bluegrass", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUEGRASS))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> XEROCHRYSUM =
            ConfiguredFeatures.register("flower_xerochrysum", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.XEROCHRYSUM))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> BLUEBELL =
            ConfiguredFeatures.register("flower_bluebell", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUEBELL))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> ORCHID =
            ConfiguredFeatures.register("flower_orchid", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ORCHID))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> LARGE_CELANDINE =
            ConfiguredFeatures.register("flower_large_celandine", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LARGE_CELANDINE))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> LARGE_ORCHID =
            ConfiguredFeatures.register("flower_large_orchid", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LARGE_ORCHID)), List.of(Blocks.GRASS_BLOCK, Blocks.DIRT), 64));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> FIR_FOREST_GRASS =
            ConfiguredFeatures.register("fir_forest_grass", Feature.RANDOM_PATCH,
                    createRandomPatchFeatureConfig(new WeightedBlockStateProvider(DataPool.<BlockState>builder().
                                    add(Blocks.GRASS.getDefaultState(), 35).add(Blocks.FERN.getDefaultState(), 55)), 512));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PINE_FOREST_GRASS =
            ConfiguredFeatures.register("fir_forest_grass", Feature.RANDOM_PATCH,
                    createRandomPatchFeatureConfig(new WeightedBlockStateProvider(DataPool.<BlockState>builder().
                            add(Blocks.GRASS.getDefaultState(), 55).
                            add(Blocks.FERN.getDefaultState(), 15).
                            add(Blocks.TALL_GRASS.getDefaultState(), 30)), 128));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PINE_FOREST_FLOWERS =
            ConfiguredFeatures.register("pine_forest_flowers", Feature.RANDOM_PATCH,
                    new RandomPatchFeatureConfig(96, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(new NoiseBlockStateProvider(2345L,
                                                    new DoublePerlinNoiseSampler.NoiseParameters(0, 1.0),
                                                    0.020833334F, List.of(
                                                            Blocks.CORNFLOWER.getDefaultState(),
                                                            Blocks.OXEYE_DAISY.getDefaultState(),
                                                            Blocks.LILY_OF_THE_VALLEY.getDefaultState()
                                                    )
                                            )
                                    )
                            )
                    ));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> WHITE_MUSHROOM =
            ConfiguredFeatures.register("mushroom_white_mushroom", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WHITE_MUSHROOM))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> ORCHID_LILY_PAD =
            ConfiguredFeatures.register("lilypad_orchid_lily_pad", Feature.RANDOM_PATCH,
                    new RandomPatchFeatureConfig(10, 7, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ORCHID_LILY_PAD)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> BILBERRY = registerBerryBush("bilberry");
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> BLACKBERRY = registerBerryBush("blackberry");
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PINK_CURRANT = registerBerryBush("pink_currant");
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> BLUEBERRY = registerBerryBush("blueberry");

    public static final RegistryEntry<ConfiguredFeature<HugeMushroomFeatureConfig, ?>> HUGE_WHITE_MUSHROOM =
            ConfiguredFeatures.register("hugemushroom_white_mushroom", ModFeatures.HUGE_WHITE_MUSHROOM,
                    new HugeMushroomFeatureConfig(
                            BlockStateProvider.of(ModBlocks.WHITE_MUSHROOM_BLOCK.getDefaultState().with(MushroomBlock.UP, Boolean.valueOf(true))
                                    .with(MushroomBlock.DOWN, Boolean.valueOf(false))),
                            BlockStateProvider.of(ModBlocks.WHITE_MUSHROOM_STEM.getDefaultState().with(MushroomBlock.UP, Boolean.valueOf(false))
                                    .with(MushroomBlock.DOWN, Boolean.valueOf(false))),
                            2
                    ));

    public static final RegistryEntry<ConfiguredFeature<SingleStateFeatureConfig, ?>> COBBLESTONE_ROCK =
            ConfiguredFeatures.register("cobblestone_rock", Feature.FOREST_ROCK, new SingleStateFeatureConfig(Blocks.COBBLESTONE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> WOOD_ANEMONA = registerFlowerbed("wood_anemona", ModBlocks.WOOD_ANEMONA);
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> WOOD_SORREL = registerFlowerbed("wood_sorrel", ModBlocks.WOOD_SORREL);

    public static RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> registerFlowerbed(String name, Block block)
    {
        DataPool.Builder<BlockState> builder = DataPool.builder();
        for (int i = 1; i <= 4; i++)
            for (Direction direction : Direction.Type.HORIZONTAL)
                builder.add(block.getDefaultState().with(FlowerbedBlock.FLOWER_AMOUNT, Integer.valueOf(i)).with(FlowerbedBlock.FACING, direction), 1);

        return ConfiguredFeatures.register("flowerbed_"+name, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(96, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(builder)))));
    }

    public static RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> registerBerryBush(String name)
    {
        return ConfiguredFeatures.register("berrybush_"+name, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(BUSHES.get(name).getDefaultState().with(BerryBushBlock.AGE, Integer.valueOf(3)))),
                        List.of(Blocks.GRASS_BLOCK)));
    }

    public static RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> registerTree(String name, float chance, TrunkPlacer trunkPlacer, FoliagePlacer foliagePlacer,
    FeatureSize featureSize, TreeDecorator... treeDecorators)
    {
        RegistryEntry<PlacedFeature> pf = PlacedFeatures.register(name+"_checked", ConfiguredFeatures.register(name+"_tree", Feature.TREE,
                new TreeFeatureConfig.Builder(BlockStateProvider.of(ModBlockSetsHelper.LOGS.get(name)), trunkPlacer,
                        BlockStateProvider.of(ModBlockSetsHelper.LEAVES.get(name)), foliagePlacer, featureSize)
                        .ignoreVines().decorators(List.of(treeDecorators)).build()), List.of(PlacedFeatures.wouldSurvive(WOODEN_SAPLINGS.get(name))));
        return ConfiguredFeatures.register(name+"_spawn", Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(pf, chance)),
                        pf));
    }

    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries)
    {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(block)));
    }
}