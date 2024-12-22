package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.world.biome.ModBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends FabricTagProvider<Biome>
{
    public ModBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, RegistryKeys.BIOME, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        this.getOrCreateTagBuilder(BiomeTags.IS_FOREST).add(ModBiomes.HAZELNUT_FOREST).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD).add(ModBiomes.HAZELNUT_FOREST).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_FOREST).add(ModBiomes.MULBERRY_GROVE).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD).add(ModBiomes.MULBERRY_GROVE).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_TAIGA).add(ModBiomes.PINE_FOREST).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD).add(ModBiomes.PINE_FOREST).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_FOREST).add(ModBiomes.ORCHID_OASIS).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD).add(ModBiomes.ORCHID_OASIS).setReplace(false);
    }
}
