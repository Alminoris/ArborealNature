package net.alminoris.arborealnature.world.gen;

import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.entity.custom.LynxEntity;
import net.alminoris.arborealnature.entity.custom.MooseEntity;
import net.alminoris.arborealnature.entity.custom.OrchidMantisEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntityGeneration
{
    public static void addSpawns()
    {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST), SpawnGroup.CREATURE,
                ModEntities.SQUIRREL, 25, 1, 3);

        SpawnRestriction.register(ModEntities.SQUIRREL, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SAVANNA), SpawnGroup.CREATURE,
                ModEntities.FIGEATER_BEETLE, 25, 1, 3);

        SpawnRestriction.register(ModEntities.FIGEATER_BEETLE, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), SpawnGroup.CREATURE,
                ModEntities.ORCHID_MANTIS, 75, 1, 2);

        SpawnRestriction.register(ModEntities.ORCHID_MANTIS, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, OrchidMantisEntity::isValidNaturalSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_PINE_TAIGA), SpawnGroup.CREATURE,
                ModEntities.MOOSE, 75, 1, 1);

        SpawnRestriction.register(ModEntities.MOOSE, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MooseEntity::isValidNaturalSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_PINE_TAIGA), SpawnGroup.CREATURE,
                ModEntities.LYNX, 35, 1, 2);

        SpawnRestriction.register(ModEntities.LYNX, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LynxEntity::isValidNaturalSpawn);
    }
}
