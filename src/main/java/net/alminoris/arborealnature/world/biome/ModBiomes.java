package net.alminoris.arborealnature.world.biome;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.world.ModPlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.*;

public class ModBiomes
{
    public static final RegistryKey<Biome> HAZELNUT_FOREST = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(ArborealNature.MOD_ID, "hazelnut_forest_biome"));

    public static final RegistryKey<Biome> MULBERRY_GROVE = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(ArborealNature.MOD_ID, "mulberry_grove_biome"));

    public static final RegistryKey<Biome> ORCHID_OASIS = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(ArborealNature.MOD_ID, "orchid_oasis_biome"));

    public static final RegistryKey<Biome> PINE_FOREST = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(ArborealNature.MOD_ID, "pine_forest_biome"));

    public static void bootstrap(Registerable<Biome> context)
    {
        RegistryEntryLookup<PlacedFeature> placedFeatures = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntryLookup<ConfiguredCarver<?>> configuredCarvers = context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);

        context.register(HAZELNUT_FOREST, hazelnutForestBiome(placedFeatures, configuredCarvers));

        context.register(MULBERRY_GROVE, mulberryGroveBiome(placedFeatures, configuredCarvers));

        context.register(ORCHID_OASIS, orchidOasisBiome(placedFeatures, configuredCarvers));

        context.register(PINE_FOREST, pineForestBiome(placedFeatures, configuredCarvers));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder)
    {
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addDefaultOres(builder);
    }

    public static Biome hazelnutForestBiome(RegistryEntryLookup<PlacedFeature> placedFeatures, RegistryEntryLookup<ConfiguredCarver<?>> configuredCarvers)
    {
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(placedFeatures, configuredCarvers);
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.SQUIRREL, 35, 3, 5));

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.WOOD_MOUSE, 25, 1, 3));

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 10, 2, 4));

        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        globalOverworldGeneration(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.FLUID_SPRINGS, MiscPlacedFeatures.SPRING_WATER);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HAZELNUT_FOREST_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HORNBEAM_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HAWTHORN_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.OAK_PLACED_KEY);
        DefaultBiomeFeatures.addPlainsTallGrass(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WHITE_MUSHROOM_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_CELANDINE_PLACED_KEY);
        DefaultBiomeFeatures.addLargeFerns(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WOOD_ANEMONA_PLACED_KEY);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x1b5ba6)
                        .waterFogColor(0x11437d)
                        .skyColor(0X78d7ff)
                        .grassColor(0x496c2b)
                        .foliageColor(0x496c2b)
                        .fogColor(0Xa7c5b5)
                        .moodSound(BiomeMoodSound.CAVE).build())
                .build();
    }

    public static Biome mulberryGroveBiome(RegistryEntryLookup<PlacedFeature> placedFeatures, RegistryEntryLookup<ConfiguredCarver<?>> configuredCarvers)
    {
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(placedFeatures, configuredCarvers);
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);
        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);

        globalOverworldGeneration(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.FLUID_SPRINGS, MiscPlacedFeatures.SPRING_WATER);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WHITE_MULBERRY_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.VIBURNUM_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_CHERRY_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_FOREST);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_TALL_GRASS);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GERANIUM_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUEGRASS_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BILBERRY_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLACKBERRY_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PINK_CURRANT_PLACED_KEY);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.6f)
                .temperature(0.75f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3c67e8)
                        .waterFogColor(0x2d4fb5)
                        .skyColor(0X99ebff)
                        .grassColor(0x529024)
                        .foliageColor(0x529024)
                        .fogColor(0Xb9c4a5)
                        .moodSound(BiomeMoodSound.CAVE).build())
                .build();
    }

    public static Biome orchidOasisBiome(RegistryEntryLookup<PlacedFeature> placedFeatures, RegistryEntryLookup<ConfiguredCarver<?>> configuredCarvers)
    {
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(placedFeatures, configuredCarvers);
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.ORCHID_MANTIS, 75, 1, 3));

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);

        globalOverworldGeneration(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BAUHINIA_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_FOREST);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_TALL_GRASS);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ORCHID_BIOME_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_ORCHID_BIOME_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PINK_CURRANT_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ORCHID_LILY_PLACED_KEY);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.3f)
                .temperature(0.75f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x2492d9)
                        .waterFogColor(0x004e8e)
                        .skyColor(0X3cc9df)
                        .grassColor(0x7f922a)
                        .foliageColor(0x7f922a)
                        .fogColor(0Xc3e6b6)
                        .moodSound(BiomeMoodSound.CAVE).build())
                .build();
    }

    public static Biome pineForestBiome(RegistryEntryLookup<PlacedFeature> placedFeatures, RegistryEntryLookup<ConfiguredCarver<?>> configuredCarvers)
    {
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(placedFeatures, configuredCarvers);
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 5, 2, 3));

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 5, 2, 2));

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.MOOSE, 75, 1, 1));

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.LYNX, 40, 1, 2));

        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        globalOverworldGeneration(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.FLUID_SPRINGS, MiscPlacedFeatures.SPRING_WATER);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PINE_FOREST_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MEGA_PINE_FOREST_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PINE_FOREST_GRASS_PLACED_KEY);
        DefaultBiomeFeatures.addPlainsTallGrass(biomeBuilder);
        DefaultBiomeFeatures.addLargeFerns(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PINE_FOREST_FLOWERS_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.XEROCHRYSUM_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUEBERRY_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WHITE_MUSHROOM_PINE_FOREST_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BROWN_MUSHROOM_PINE_FOREST_PLACED_KEY);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.5f)
                .temperature(0.6f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x2d64a4)
                        .waterFogColor(0x003e79)
                        .skyColor(0Xa6daf0)
                        .grassColor(0x567d44)
                        .foliageColor(0x567d44)
                        .fogColor(0X95b290)
                        .moodSound(BiomeMoodSound.CAVE).build())
                .build();
    }
}
