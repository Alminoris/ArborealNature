package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.block.ModBlocks;
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
            getOrCreateTagBuilder(ItemTags.SAPLINGS)
                    .add(WOODEN_SAPLINGS.get(name).asItem());

            getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                    .add(LOGS.get(name).asItem())
                    .add(STRIPPED_LOGS.get(name).asItem())
                    .add(WOODS.get(name).asItem())
                    .add(STRIPPED_WOODS.get(name).asItem());

            getOrCreateTagBuilder(ItemTags.PLANKS)
                    .add(WOODEN_PLANKS.get(name).asItem())
                    .add(WOODEN_CHISELED.get(name).asItem());

            getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                    .add(WOODEN_FENCES.get(name).asItem());

            getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                    .add(WOODEN_SLABS.get(name).asItem())
                    .add(WOODEN_CHISELED_SLABS.get(name).asItem());

            getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                    .add(WOODEN_STAIRS.get(name).asItem())
                    .add(WOODEN_CHISELED_STAIRS.get(name).asItem());

            getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                    .add(WOODEN_BUTTONS.get(name).asItem());

            getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                    .add(WOODEN_PRESSURE_PLATES.get(name).asItem());

            getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                    .add(WOODEN_TRAPDOORS.get(name).asItem());

            getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                    .add(WOODEN_DOORS.get(name).asItem());
        }

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.OAK_CHISELED.asItem())
                .add(ModBlocks.BIRCH_CHISELED.asItem())
                .add(ModBlocks.SPRUCE_CHISELED.asItem())
                .add(ModBlocks.JUNGLE_CHISELED.asItem())
                .add(ModBlocks.ACACIA_CHISELED.asItem())
                .add(ModBlocks.DARK_OAK_CHISELED.asItem())
                .add(ModBlocks.CRIMSON_CHISELED.asItem())
                .add(ModBlocks.WARPED_CHISELED.asItem())
                .add(ModBlocks.MANGROVE_CHISELED.asItem())
                .add(ModBlocks.CHERRY_CHISELED.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.OAK_CHISELED_SLAB.asItem())
                .add(ModBlocks.BIRCH_CHISELED_SLAB.asItem())
                .add(ModBlocks.SPRUCE_CHISELED_SLAB.asItem())
                .add(ModBlocks.JUNGLE_CHISELED_SLAB.asItem())
                .add(ModBlocks.ACACIA_CHISELED_SLAB.asItem())
                .add(ModBlocks.DARK_OAK_CHISELED_SLAB.asItem())
                .add(ModBlocks.CRIMSON_CHISELED_SLAB.asItem())
                .add(ModBlocks.WARPED_CHISELED_SLAB.asItem())
                .add(ModBlocks.MANGROVE_CHISELED_SLAB.asItem())
                .add(ModBlocks.CHERRY_CHISELED_SLAB.asItem())
                .add(ModBlocks.PINE_RESIN_BRICKS_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.OAK_CHISELED_STAIRS.asItem())
                .add(ModBlocks.BIRCH_CHISELED_STAIRS.asItem())
                .add(ModBlocks.SPRUCE_CHISELED_STAIRS.asItem())
                .add(ModBlocks.JUNGLE_CHISELED_STAIRS.asItem())
                .add(ModBlocks.ACACIA_CHISELED_STAIRS.asItem())
                .add(ModBlocks.DARK_OAK_CHISELED_STAIRS.asItem())
                .add(ModBlocks.CRIMSON_CHISELED_STAIRS.asItem())
                .add(ModBlocks.WARPED_CHISELED_STAIRS.asItem())
                .add(ModBlocks.MANGROVE_CHISELED_STAIRS.asItem())
                .add(ModBlocks.CHERRY_CHISELED_STAIRS.asItem())
                .add(ModBlocks.PINE_RESIN_BRICKS_STAIRS.asItem());

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
                .add(Items.GRASS)
                .add(Items.TALL_GRASS)
                .add(Items.SWEET_BERRIES)
                .add(BERRIES.get("blueberry"));

        getOrCreateTagBuilder(ModTags.Items.CARIBOU_FOOD)
                .add(Items.LARGE_FERN)
                .add(Items.FERN)
                .add(Items.GRASS)
                .add(ModBlocks.REINDEER_LICHEN_CARPET.asItem());

        getOrCreateTagBuilder(ModTags.Items.WOLVERINE_FOOD)
                .add(Items.RABBIT)
                .add(ModItems.CARIBOU_VENISON);

        getOrCreateTagBuilder(ItemTags.ARROWS)
                .add(ModItems.SILENT_ARROW);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.FIGEATER_BEETLE_CHESTPLATE)
                .add(ModItems.CARIBOU_FUR_HELMET)
                .add(ModItems.CARIBOU_FUR_CHESTPLATE)
                .add(ModItems.CARIBOU_FUR_LEGGINGS)
                .add(ModItems.CARIBOU_FUR_BOOTS);

        getOrCreateTagBuilder(ItemTags.FREEZE_IMMUNE_WEARABLES)
                .add(ModItems.CARIBOU_FUR_HELMET, ModItems.CARIBOU_FUR_CHESTPLATE, ModItems.CARIBOU_FUR_LEGGINGS, ModItems.CARIBOU_FUR_BOOTS);
    }
}