package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.world.biome.ModBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.tag.BiomeTags;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends FabricTagProvider<Biome>
{
    public ModBiomeTagProvider(FabricDataGenerator dataGenerator)
    {
        super(dataGenerator, BuiltinRegistries.BIOME);
    }

    @Override
    protected void generateTags()
    {
        this.getOrCreateTagBuilder(BiomeTags.IS_FOREST).add(ModBiomes.HAZELNUT_FOREST).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD).add(ModBiomes.HAZELNUT_FOREST).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_FOREST).add(ModBiomes.MULBERRY_GROVE).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD).add(ModBiomes.MULBERRY_GROVE).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_TAIGA).add(ModBiomes.PINE_FOREST).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD).add(ModBiomes.PINE_FOREST).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_FOREST).add(ModBiomes.FIR_FOREST).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD).add(ModBiomes.FIR_FOREST).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_FOREST).add(ModBiomes.ORCHID_OASIS).setReplace(false);
        this.getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD).add(ModBiomes.ORCHID_OASIS).setReplace(false);
    }

}
