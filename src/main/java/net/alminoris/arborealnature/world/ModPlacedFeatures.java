package net.alminoris.arborealnature.world;

import com.google.common.collect.ImmutableList;
import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.util.helper.ModWoodHelper;
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

    public static final RegistryKey<PlacedFeature> LARGE_CELANDINE_PLACED_KEY = registerKey("large_celandine_placed");

    public static final RegistryKey<PlacedFeature> WOOD_ANEMONA_PLACED_KEY = registerKey("wood_anemona_placed");

    public static final RegistryKey<PlacedFeature> WHITE_MUSHROOM_PLACED_KEY = registerKey("white_mushroom_placed");

    public static final RegistryKey<PlacedFeature> HUGE_WHITE_MUSHROOM_PLACED_KEY = registerKey("huge_white_mushroom_placed");

    public static void bootstrap(Registerable<PlacedFeature> context)
    {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, HAZELNUT_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.HAZELNUT_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.1f, 1),
                        ModWoodHelper.WOODEN_SAPLINGS.get("hazelnut")));

        register(context, HAZELNUT_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.HAZELNUT_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(15, 0.2f, 20),
                        ModWoodHelper.WOODEN_SAPLINGS.get("hazelnut")));

        register(context, HORNBEAM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.HORNBEAM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(3, 0.1f, 7),
                        ModWoodHelper.WOODEN_SAPLINGS.get("hornbeam")));

        register(context, HAWTHORN_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.HAWTHORN_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(3, 0.1f, 7),
                        ModWoodHelper.WOODEN_SAPLINGS.get("hawthorn")));

        register(context, OAK_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.OAK),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(7, 0.1f, 12),
                        Blocks.OAK_SAPLING));

        register(context, LARGE_CELANDINE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.LARGE_CELANDINE_KEY),
                List.of(RarityFilterPlacementModifier.of(5),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));

        register(context, WOOD_ANEMONA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeautures.WOOD_ANEMONA_KEY),
                List.of(NoiseThresholdCountPlacementModifier.of(-0.5, 2, 5),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
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