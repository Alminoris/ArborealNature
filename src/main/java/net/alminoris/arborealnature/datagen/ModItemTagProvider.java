package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider
{
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        getOrCreateTagBuilder(ItemTags.HANGING_SIGNS)
                .add(ModItems.HAZELNUT_HANGING_SIGN);

        getOrCreateTagBuilder(ItemTags.SIGNS)
                .add(ModItems.HAZELNUT_SIGN);

        getOrCreateTagBuilder(ModTags.Items.SQUIRREL_FOOD)
                .add(ModItems.HAZELNUT_PEELED);
    }
}
