package net.alminoris.arborealnature.world;

import com.google.common.collect.ImmutableList;
import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.util.helper.ModBlockSetsHelper;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ClampedIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModPlacedFeatures
{
    public static final RegistryKey<PlacedFeature> HAZELNUT_PLACED_KEY = registerKey("hazelnut_placed");

    public static final RegistryKey<PlacedFeature> HAZELNUT_FOREST_PLACED_KEY = registerKey("large_hazelnut_placed");

    public static final RegistryKey<PlacedFeature> HORNBEAM_PLACED_KEY = registerKey("hornbeam_placed");

    public static final RegistryKey<PlacedFeature> HAWTHORN_PLACED_KEY = registerKey("hawthorn_placed");

    public static final RegistryKey<PlacedFeature> OAK_PLACED_KEY = registerKey("oak_placed");

    public static final RegistryKey<PlacedFeature> QUINCE_PLACED_KEY = registerKey("quince_placed");

    public static final RegistryKey<PlacedFeature> PLUM_PLACED_KEY = registerKey("plum_placed");

    public static final RegistryKey<PlacedFeature> MANGO_PLACED_KEY = registerKey("mango_placed");

    public static final RegistryKey<PlacedFeature> FIG_PLACED_KEY = registerKey("fig_placed");

    public static final RegistryKey<PlacedFeature> VIBURNUM_PLACED_KEY = registerKey("viburnum_placed");

    public static final RegistryKey<PlacedFeature> WILD_CHERRY_PLACED_KEY = registerKey("wild_cherry_placed");

    public static final RegistryKey<PlacedFeature> WHITE_MULBERRY_PLACED_KEY = registerKey("white_mulberry_placed");

    public static final RegistryKey<PlacedFeature> BAUHINIA_PLACED_KEY = registerKey("bauhinia_placed");

    public static final RegistryKey<PlacedFeature> PINE_PLACED_KEY = registerKey("pine_placed");

    public static final RegistryKey<PlacedFeature> MEGA_PINE_PLACED_KEY = registerKey("mega_pine_placed");

    public static final RegistryKey<PlacedFeature> PINE_FOREST_PLACED_KEY = registerKey("pine_forest_placed");

    public static final RegistryKey<PlacedFeature> MEGA_PINE_FOREST_PLACED_KEY = registerKey("mega_pine_forest_placed");

    public static final RegistryKey<PlacedFeature> BILBERRY_PLACED_KEY = registerKey("bilberry_placed");

    public static final RegistryKey<PlacedFeature> BLACKBERRY_PLACED_KEY = registerKey("blackberry_placed");

    public static final RegistryKey<PlacedFeature> BLUEBERRY_PLACED_KEY = registerKey("blueberry_placed");

    public static final RegistryKey<PlacedFeature> PINK_CURRANT_PLACED_KEY = registerKey("pink_currant_placed");

    public static final RegistryKey<PlacedFeature> LARGE_CELANDINE_PLACED_KEY = registerKey("large_celandine_placed");

    public static final RegistryKey<PlacedFeature> BLUEGRASS_PLACED_KEY = registerKey("bluegrass_placed");

    public static final RegistryKey<PlacedFeature> GERANIUM_PLACED_KEY = registerKey("geranium_placed");

    public static final RegistryKey<PlacedFeature> XEROCHRYSUM_PLACED_KEY = registerKey("xerochrysum_placed");

    public static final RegistryKey<PlacedFeature> LARGE_ORCHID_PLACED_KEY = registerKey("large_orchid_placed");

    public static final RegistryKey<PlacedFeature> ORCHID_PLACED_KEY = registerKey("orchid_placed");

    public static final RegistryKey<PlacedFeature> LARGE_ORCHID_BIOME_PLACED_KEY = registerKey("large_orchid_biome_placed");

    public static final RegistryKey<PlacedFeature> ORCHID_BIOME_PLACED_KEY = registerKey("orchid_biome_placed");

    public static final RegistryKey<PlacedFeature> ORCHID_LILY_PLACED_KEY = registerKey("orchid_lily_placed");

    public static final RegistryKey<PlacedFeature> WOOD_ANEMONA_PLACED_KEY = registerKey("wood_anemona_placed");

    public static final RegistryKey<PlacedFeature> WHITE_MUSHROOM_PLACED_KEY = registerKey("white_mushroom_placed");

    public static final RegistryKey<PlacedFeature> WHITE_MUSHROOM_PINE_FOREST_PLACED_KEY = registerKey("white_mushroom_pine_forest_placed");

    public static final RegistryKey<PlacedFeature> BROWN_MUSHROOM_PINE_FOREST_PLACED_KEY = registerKey("brown_mushroom_pine_forest_placed");

    public static final RegistryKey<PlacedFeature> HUGE_WHITE_MUSHROOM_PLACED_KEY = registerKey("huge_white_mushroom_placed");

    public static final RegistryKey<PlacedFeature> PINE_FOREST_FLOWERS_PLACED_KEY = registerKey("pine_forest_flowers_placed");

    public static final RegistryKey<PlacedFeature> PINE_FOREST_GRASS_PLACED_KEY = registerKey("pine_forest_grass_placed");

    public static void bootstrap(Registerable<PlacedFeature> context)
    {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, HAZELNUT_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HAZELNUT_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.05f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("hazelnut")));

        register(context, HAZELNUT_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HAZELNUT_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(15, 0.2f, 20),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("hazelnut")));

        register(context, HORNBEAM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HORNBEAM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(3, 0.1f, 7),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("hornbeam")));

        register(context, HAWTHORN_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HAWTHORN_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(3, 0.1f, 7),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("hawthorn")));

        register(context, OAK_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.OAK),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(7, 0.1f, 12),
                        Blocks.OAK_SAPLING));

        register(context, QUINCE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.QUINCE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.1f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("quince")));

        register(context, PLUM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PLUM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.05f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("plum")));

        register(context, MANGO_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MANGO_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("mango")));

        register(context, FIG_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FIG_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.1f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("fig")));

        register(context, VIBURNUM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VIBURNUM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(7, 0.1f, 12),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("viburnum")));

        register(context, WILD_CHERRY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WILD_CHERRY_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(12, 0.1f, 17),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("wild_cherry")));

        register(context, WHITE_MULBERRY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WHITE_MULBERRY_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(15, 0.1f, 20),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("white_mulberry")));

        register(context, BAUHINIA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BAUHINIA_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(30, 0.1f, 40),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("bauhinia")));

        register(context, PINE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(15, 0.1f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("pine")));

        register(context, MEGA_PINE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MEGA_PINE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("pine")));

        register(context, PINE_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(40, 0.1f, 20),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("pine")));

        register(context, MEGA_PINE_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MEGA_PINE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(15, 0.1f, 5),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("pine")));

        register(context, PINE_FOREST_FLOWERS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINE_FOREST_FLOWERS_KEY),
                List.of(RarityFilterPlacementModifier.of(5),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        CountPlacementModifier.of(ClampedIntProvider.create(UniformIntProvider.create(-3, 1), 0, 1)),
                        BiomePlacementModifier.of()));

        register(context, PINE_FOREST_GRASS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINE_FOREST_GRASS_KEY),
                List.of(SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, LARGE_CELANDINE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LARGE_CELANDINE_KEY),
                List.of(RarityFilterPlacementModifier.of(5),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, BLUEGRASS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUEGRASS_KEY),
                List.of(RarityFilterPlacementModifier.of(1),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, GERANIUM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GERANIUM_KEY),
                List.of(RarityFilterPlacementModifier.of(3),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, XEROCHRYSUM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.XEROCHRYSUM_KEY),
                List.of(RarityFilterPlacementModifier.of(5),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, LARGE_ORCHID_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LARGE_ORCHID_KEY),
                List.of(RarityFilterPlacementModifier.of(5),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, ORCHID_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORCHID_KEY),
                List.of(RarityFilterPlacementModifier.of(5),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, LARGE_ORCHID_BIOME_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LARGE_ORCHID_KEY),
                List.of(RarityFilterPlacementModifier.of(1),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, ORCHID_BIOME_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORCHID_KEY),
                List.of(RarityFilterPlacementModifier.of(1),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, WOOD_ANEMONA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WOOD_ANEMONA_KEY),
                List.of(NoiseThresholdCountPlacementModifier.of(-0.5, 2, 5),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, BILBERRY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BILBERRY_KEY),
                List.of(RarityFilterPlacementModifier.of(32),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, BLACKBERRY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLACKBERRY_KEY),
                List.of(RarityFilterPlacementModifier.of(32),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, BLUEBERRY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUEBERRY_KEY),
                List.of(RarityFilterPlacementModifier.of(48),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, PINK_CURRANT_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_CURRANT_KEY),
                List.of(RarityFilterPlacementModifier.of(32),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, WHITE_MUSHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WHITE_MUSHROOM_KEY),
                mushroomModifiers(128, CountPlacementModifier.of(3)));

        register(context, WHITE_MUSHROOM_PINE_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WHITE_MUSHROOM_KEY),
                mushroomModifiers(64, CountPlacementModifier.of(2)));

        register(context, BROWN_MUSHROOM_PINE_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(VegetationConfiguredFeatures.PATCH_BROWN_MUSHROOM),
                mushroomModifiers(64, CountPlacementModifier.of(2)));

        register(context, HUGE_WHITE_MUSHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HUGE_WHITE_MUSHROOM_KEY),
                List.of(
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));

        register(context, ORCHID_LILY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORCHID_LILY_KEY),
                List.of(CountPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()));
    }

    private static List<PlacementModifier> mushroomModifiers(int chance, @Nullable PlacementModifier modifier)
    {
        ImmutableList.Builder<PlacementModifier> builder = ImmutableList.builder();
        if (modifier != null)
            builder.add(modifier);

        if (chance != 0)
            builder.add(RarityFilterPlacementModifier.of(chance));

        builder.add(SquarePlacementModifier.of());
        builder.add(PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP);
        builder.add(BiomePlacementModifier.of());
        return builder.build();
    }

    public static RegistryKey<PlacedFeature> registerKey(String name)
    {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(ArborealNature.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers)
    {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}