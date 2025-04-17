package net.alminoris.arborealnature.world.biome;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class DesertRegion extends Region
{
    public DesertRegion(Identifier name, int weight)
    {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> biomeRegistry, Consumer<com.mojang.datafixers.util.Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper)
    {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder ->
        {
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.DESERT, ModBiomes.ORCHID_OASIS);
        });
    }
}