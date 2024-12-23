package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static net.alminoris.arborealnature.util.helper.ModBlockSetsHelper.*;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider
{
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        for (String name : WOOD_NAMES)
        {
            getOrCreateTagBuilder(ItemTags.HANGING_SIGNS)
                    .add(WOODEN_HANGING_SIGN_ITEMS.get(name));

            getOrCreateTagBuilder(ItemTags.SIGNS)
                    .add(WOODEN_SIGN_ITEMS.get(name));
        }

        getOrCreateTagBuilder(ModTags.Items.SQUIRREL_FOOD)
                .add(ModItems.HAZELNUT_PEELED);

        getOrCreateTagBuilder(ModTags.Items.MOOSE_FOOD)
                .add(Items.WHEAT)
                .add(Items.WHEAT_SEEDS)
                .add(Items.SHORT_GRASS)
                .add(Items.TALL_GRASS)
                .add(Items.SWEET_BERRIES)
                .add(BERRIES.get("blueberry"));

        getOrCreateTagBuilder(ItemTags.ARROWS)
                .add(ModItems.SILENT_ARROW);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.FIGEATER_BEETLE_CHESTPLATE);

        this.getOrCreateTagBuilder(ItemTags.MEAT)
                .add(
                        ModItems.MOOSE_VENISON,
                        ModItems.COOKED_MOOSE_VENISON
                );
    }
}
