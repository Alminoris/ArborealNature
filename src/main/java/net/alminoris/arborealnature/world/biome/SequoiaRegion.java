package net.alminoris.arborealnature.world.biome;


import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class SequoiaRegion extends Region
{
    public SequoiaRegion(Identifier name, int weight)
    {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> biomeRegistry, Consumer<com.mojang.datafixers.util.Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper)
    {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder ->
        {
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.PLAINS, ModBiomes.SEQUOIA_FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.FOREST, ModBiomes.SEQUOIA_FOREST);
        });
    }
}
