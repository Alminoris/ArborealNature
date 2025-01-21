package net.alminoris.arborealnature.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.math.intprovider.ClampedIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import org.jetbrains.annotations.Nullable;
import net.minecraft.util.registry.RegistryEntry;

import java.util.List;

public class ModPlacedFeatures
{
    public static final RegistryEntry<PlacedFeature> HAZELNUT_PLACED_KEY = PlacedFeatures.register("hazelnut_placed", ModConfiguredFeatures.HAZELNUT_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(0, 0.05f, 1)));

    public static final RegistryEntry<PlacedFeature> HAZELNUT_FOREST_PLACED_KEY = PlacedFeatures.register("hazelnut_forest_placed", ModConfiguredFeatures.HAZELNUT_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(15, 0.2f, 20)));

    public static final RegistryEntry<PlacedFeature> HORNBEAM_PLACED_KEY = PlacedFeatures.register("hornbeam_placed", ModConfiguredFeatures.HORNBEAM_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(3, 0.1f, 7)));

    public static final RegistryEntry<PlacedFeature> HAWTHORN_PLACED_KEY = PlacedFeatures.register("hawthorn_placed", ModConfiguredFeatures.HAWTHORN_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(3, 0.1f, 7)));

    public static final RegistryEntry<PlacedFeature> OAK_PLACED_KEY = PlacedFeatures.register("oak_placed", TreeConfiguredFeatures.OAK,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(7, 0.1f, 12)));

    public static final RegistryEntry<PlacedFeature> QUINCE_PLACED_KEY = PlacedFeatures.register("quince_placed", ModConfiguredFeatures.QUINCE_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(0, 0.1f, 1)));

    public static final RegistryEntry<PlacedFeature> PLUM_PLACED_KEY = PlacedFeatures.register("plum_placed", ModConfiguredFeatures.PLUM_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(0, 0.1f, 1)));

    public static final RegistryEntry<PlacedFeature> MANGO_PLACED_KEY = PlacedFeatures.register("mango_placed", ModConfiguredFeatures.MANGO_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(0, 0.1f, 1)));

    public static final RegistryEntry<PlacedFeature> FIG_PLACED_KEY = PlacedFeatures.register("fig_placed", ModConfiguredFeatures.FIG_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(0, 0.1f, 1)));

    public static final RegistryEntry<PlacedFeature> VIBURNUM_PLACED_KEY = PlacedFeatures.register("viburnum_placed", ModConfiguredFeatures.VIBURNUM_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(7, 0.1f, 12)));

    public static final RegistryEntry<PlacedFeature> WILD_CHERRY_PLACED_KEY = PlacedFeatures.register("wild_cherry_placed", ModConfiguredFeatures.WILD_CHERRY_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(12, 0.1f, 17)));

    public static final RegistryEntry<PlacedFeature> WHITE_MULBERRY_PLACED_KEY = PlacedFeatures.register("white_mulberry_placed", ModConfiguredFeatures.WHITE_MULBERRY_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(15, 0.1f, 20)));

    public static final RegistryEntry<PlacedFeature> BAUHINIA_PLACED_KEY = PlacedFeatures.register("bauhinia_placed", ModConfiguredFeatures.BAUHINIA_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(30, 0.1f, 40)));

    public static final RegistryEntry<PlacedFeature> PINE_PLACED_KEY = PlacedFeatures.register("pine_placed", ModConfiguredFeatures.PINE_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(15, 0.1f, 1)));

    public static final RegistryEntry<PlacedFeature> FIR_PLACED_KEY = PlacedFeatures.register("fir_placed", ModConfiguredFeatures.FIR_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 3)));

    public static final RegistryEntry<PlacedFeature> CEDAR_PLACED_KEY = PlacedFeatures.register("cedar_placed", ModConfiguredFeatures.CEDAR_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(0, 0.01f, 1)));

    public static final RegistryEntry<PlacedFeature> MEGA_PINE_PLACED_KEY = PlacedFeatures.register("mega_pine_placed", ModConfiguredFeatures.MEGA_PINE_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2)));

    public static final RegistryEntry<PlacedFeature> PINE_FOREST_PLACED_KEY = PlacedFeatures.register("pine_forest_placed", ModConfiguredFeatures.PINE_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(40, 0.1f, 20)));

    public static final RegistryEntry<PlacedFeature> FIR_FOREST_PLACED_KEY = PlacedFeatures.register("fir_forest_placed", ModConfiguredFeatures.FIR_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(30, 0.1f, 15)));

    public static final RegistryEntry<PlacedFeature> CEDAR_FOREST_PLACED_KEY = PlacedFeatures.register("cedar_forest_placed", ModConfiguredFeatures.CEDAR_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(0, 0.1f, 1)));

    public static final RegistryEntry<PlacedFeature> MEGA_PINE_FOREST_PLACED_KEY = PlacedFeatures.register("mega_pine_forest_placed", ModConfiguredFeatures.MEGA_PINE_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(15, 0.1f, 5)));

    public static final RegistryEntry<PlacedFeature> BILBERRY_PLACED_KEY = PlacedFeatures.register("bilberry_placed", ModConfiguredFeatures.BILBERRY,
            List.of(RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> BLACKBERRY_PLACED_KEY = PlacedFeatures.register("blackberry_placed", ModConfiguredFeatures.BLACKBERRY,
            List.of(RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> BLUEBERRY_PLACED_KEY = PlacedFeatures.register("blueberry_placed", ModConfiguredFeatures.BLUEBERRY,
            List.of(RarityFilterPlacementModifier.of(48), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> PINK_CURRANT_PLACED_KEY = PlacedFeatures.register("pink_currant_placed", ModConfiguredFeatures.PINK_CURRANT,
            List.of(RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> LARGE_CELANDINE_PLACED_KEY = PlacedFeatures.register("large_celandine_placed", ModConfiguredFeatures.LARGE_CELANDINE,
            List.of(RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> BLUEGRASS_PLACED_KEY = PlacedFeatures.register("bluegrass_placed", ModConfiguredFeatures.BLUEGRASS,
            List.of(RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> GERANIUM_PLACED_KEY = PlacedFeatures.register("geranium_placed", ModConfiguredFeatures.GERANIUM,
            List.of(RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> XEROCHRYSUM_PLACED_KEY = PlacedFeatures.register("xerochrysum_placed", ModConfiguredFeatures.XEROCHRYSUM,
            List.of(RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> BLUEBELL_PLACED_KEY = PlacedFeatures.register("bluebell_placed", ModConfiguredFeatures.BLUEBELL,
            List.of(RarityFilterPlacementModifier.of(15), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> LARGE_ORCHID_PLACED_KEY = PlacedFeatures.register("large_orchid_placed", ModConfiguredFeatures.LARGE_ORCHID,
            List.of(RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> ORCHID_PLACED_KEY = PlacedFeatures.register("orchid_placed", ModConfiguredFeatures.ORCHID,
            List.of(RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> LARGE_ORCHID_BIOME_PLACED_KEY = PlacedFeatures.register("large_orchid_biome_placed", ModConfiguredFeatures.LARGE_ORCHID,
            List.of(RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> ORCHID_BIOME_PLACED_KEY = PlacedFeatures.register("orchid_biome_placed", ModConfiguredFeatures.ORCHID,
            List.of(RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> ORCHID_LILY_PLACED_KEY = PlacedFeatures.register("orchid_lily_placed", ModConfiguredFeatures.ORCHID_LILY_PAD,
            List.of(CountPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> WOOD_ANEMONA_PLACED_KEY = PlacedFeatures.register("wood_anemona_placed", ModConfiguredFeatures.WOOD_ANEMONA,
            List.of(NoiseThresholdCountPlacementModifier.of(-0.5, 2, 5), SquarePlacementModifier.of(),
                    PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> WOOD_SORREL_PLACED_KEY = PlacedFeatures.register("wood_sorrel_placed", ModConfiguredFeatures.WOOD_SORREL,
            List.of(NoiseThresholdCountPlacementModifier.of(-0.25, 1, 3), SquarePlacementModifier.of(),
                    PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> WHITE_MUSHROOM_PLACED_KEY = PlacedFeatures.register("white_mushroom_placed", ModConfiguredFeatures.WHITE_MUSHROOM,
            mushroomModifiers(128, CountPlacementModifier.of(3)));

    public static final RegistryEntry<PlacedFeature> WHITE_MUSHROOM_PINE_FOREST_PLACED_KEY = PlacedFeatures.register("white_mushroom_pine_forest_placed", ModConfiguredFeatures.WHITE_MUSHROOM,
            mushroomModifiers(64, CountPlacementModifier.of(2)));

    public static final RegistryEntry<PlacedFeature> BROWN_MUSHROOM_PINE_FOREST_PLACED_KEY = PlacedFeatures.register("brown_mushroom_pine_forest_placed", VegetationConfiguredFeatures.PATCH_BROWN_MUSHROOM,
            mushroomModifiers(64, CountPlacementModifier.of(2)));

    public static final RegistryEntry<PlacedFeature> HUGE_WHITE_MUSHROOM_PLACED_KEY = PlacedFeatures.register("huge_white_mushroom_placed", ModConfiguredFeatures.HUGE_WHITE_MUSHROOM,
            List.of(SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> PINE_FOREST_FLOWERS_PLACED_KEY = PlacedFeatures.register("pine_forest_flowers_placed", ModConfiguredFeatures.PINE_FOREST_FLOWERS,
            List.of(RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                    CountPlacementModifier.of(ClampedIntProvider.create(UniformIntProvider.create(-3, 1), 0, 1)), BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> PINE_FOREST_GRASS_PLACED_KEY = PlacedFeatures.register("pine_forest_grass_placed", ModConfiguredFeatures.PINE_FOREST_GRASS,
            List.of(SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> FIR_FOREST_GRASS_PLACED_KEY = PlacedFeatures.register("fir_forest_grass_placed", ModConfiguredFeatures.FIR_FOREST_GRASS,
            List.of(SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final RegistryEntry<PlacedFeature> COBBLESTONE_ROCK_PLACED_KEY = PlacedFeatures.register("cobblestone_rock_placed", ModConfiguredFeatures.COBBLESTONE_ROCK,
            List.of(CountPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

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
}