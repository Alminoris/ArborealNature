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

    public static final RegistryKey<PlacedFeature> BILBERRY_PLACED_KEY = registerKey("bilberry_placed");

    public static final RegistryKey<PlacedFeature> BLACKBERRY_PLACED_KEY = registerKey("blackberry_placed");

    public static final RegistryKey<PlacedFeature> PINK_CURRANT_PLACED_KEY = registerKey("pink_currant_placed");

    public static final RegistryKey<PlacedFeature> LARGE_CELANDINE_PLACED_KEY = registerKey("large_celandine_placed");

    public static final RegistryKey<PlacedFeature> BLUEGRASS_PLACED_KEY = registerKey("bluegrass_placed");

    public static final RegistryKey<PlacedFeature> GERANIUM_PLACED_KEY = registerKey("geranium_placed");

    public static final RegistryKey<PlacedFeature> LARGE_ORCHID_PLACED_KEY = registerKey("large_orchid_placed");

    public static final RegistryKey<PlacedFeature> ORCHID_PLACED_KEY = registerKey("orchid_placed");

    public static final RegistryKey<PlacedFeature> WOOD_ANEMONA_PLACED_KEY = registerKey("wood_anemona_placed");

    public static final RegistryKey<PlacedFeature> WHITE_MUSHROOM_PLACED_KEY = registerKey("white_mushroom_placed");

    public static final RegistryKey<PlacedFeature> HUGE_WHITE_MUSHROOM_PLACED_KEY = registerKey("huge_white_mushroom_placed");

    public static void bootstrap(Registerable<PlacedFeature> context)
    {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, HAZELNUT_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.HAZELNUT_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.05f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("hazelnut")));

        register(context, HAZELNUT_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.HAZELNUT_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(15, 0.2f, 20),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("hazelnut")));

        register(context, HORNBEAM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.HORNBEAM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(3, 0.1f, 7),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("hornbeam")));

        register(context, HAWTHORN_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.HAWTHORN_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(3, 0.1f, 7),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("hawthorn")));

        register(context, OAK_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.OAK),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(7, 0.1f, 12),
                        Blocks.OAK_SAPLING));

        register(context, QUINCE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.QUINCE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.1f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("quince")));

        register(context, PLUM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.PLUM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.05f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("plum")));

        register(context, MANGO_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.MANGO_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("mango")));

        register(context, FIG_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.FIG_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.1f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("fig")));

        register(context, VIBURNUM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.VIBURNUM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(7, 0.1f, 12),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("viburnum")));

        register(context, WILD_CHERRY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.WILD_CHERRY_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(12, 0.1f, 17),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("wild_cherry")));

        register(context, WHITE_MULBERRY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.WHITE_MULBERRY_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(15, 0.1f, 20),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("white_mulberry")));

        register(context, LARGE_CELANDINE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.LARGE_CELANDINE_KEY),
                List.of(RarityFilterPlacementModifier.of(5),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, BLUEGRASS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.BLUEGRASS_KEY),
                List.of(RarityFilterPlacementModifier.of(1),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, GERANIUM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.GERANIUM_KEY),
                List.of(RarityFilterPlacementModifier.of(3),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, LARGE_ORCHID_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.LARGE_ORCHID_KEY),
                List.of(RarityFilterPlacementModifier.of(5),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, ORCHID_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.ORCHID_KEY),
                List.of(RarityFilterPlacementModifier.of(5),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, WOOD_ANEMONA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.WOOD_ANEMONA_KEY),
                List.of(NoiseThresholdCountPlacementModifier.of(-0.5, 2, 5),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, BILBERRY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.BILBERRY_KEY),
                List.of(RarityFilterPlacementModifier.of(32),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, BLACKBERRY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.BLACKBERRY_KEY),
                List.of(RarityFilterPlacementModifier.of(32),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, PINK_CURRANT_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.PINK_CURRANT_KEY),
                List.of(RarityFilterPlacementModifier.of(32),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, WHITE_MUSHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.WHITE_MUSHROOM_KEY),
                mushroomModifiers(128, CountPlacementModifier.of(3)));

        register(context, HUGE_WHITE_MUSHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.HUGE_WHITE_MUSHROOM_KEY),
                List.of(SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));
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