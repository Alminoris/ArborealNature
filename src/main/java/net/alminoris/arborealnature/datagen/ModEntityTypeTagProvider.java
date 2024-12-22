package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider
{
    public ModEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        getOrCreateTagBuilder(ModTags.Entities.LEATHER_DROPPERS)
                .add(ModEntities.MOOSE)
                .add(EntityType.HORSE)
                .add(EntityType.DONKEY)
                .add(EntityType.MOOSHROOM)
                .add(EntityType.LLAMA)
                .add(EntityType.TRADER_LLAMA)
                .add(EntityType.COW);
    }
}
