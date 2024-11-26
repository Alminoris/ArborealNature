package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

import static net.alminoris.arborealnature.util.helper.ModBlockSetsHelper.*;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider
{
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        for (String name : WOOD_NAMES)
        {
            getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                    .add(LOGS.get(name))
                    .add(STRIPPED_LOGS.get(name))
                    .add(WOODS.get(name))
                    .add(STRIPPED_WOODS.get(name));

            getOrCreateTagBuilder(ModTags.Blocks.CHISELABLE_BLOCKS)
                    .add(STRIPPED_WOODS.get(name));

            getOrCreateTagBuilder(BlockTags.PLANKS)
                    .add(WOODEN_PLANKS.get(name))
                    .add(WOODEN_CHISELED.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                    .add(WOODEN_FENCES.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                    .add(WOODEN_SLABS.get(name))
                    .add(WOODEN_CHISELED_SLABS.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                    .add(WOODEN_STAIRS.get(name))
                    .add(WOODEN_CHISELED_STAIRS.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                    .add(WOODEN_BUTTONS.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                    .add(WOODEN_PRESSURE_PLATES.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                    .add(WOODEN_TRAPDOORS.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                    .add(WOODEN_DOORS.get(name));

            getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
                    .add(WOODEN_SIGNS.get(name));

            getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
                    .add(WOODEN_WALL_SIGNS.get(name));

            getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
                    .add(WOODEN_HANGING_SIGNS.get(name));

            getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
                    .add(WOODEN_WALL_HANGING_SIGNS.get(name));
        }

        getOrCreateTagBuilder(ModTags.Blocks.CHISELABLE_BLOCKS)
                .add(Blocks.STRIPPED_OAK_WOOD)
                .add(Blocks.STRIPPED_BIRCH_WOOD)
                .add(Blocks.STRIPPED_SPRUCE_WOOD)
                .add(Blocks.STRIPPED_JUNGLE_WOOD)
                .add(Blocks.STRIPPED_ACACIA_WOOD)
                .add(Blocks.STRIPPED_DARK_OAK_WOOD)
                .add(Blocks.STRIPPED_CRIMSON_HYPHAE)
                .add(Blocks.STRIPPED_WARPED_HYPHAE)
                .add(Blocks.STRIPPED_MANGROVE_WOOD)
                .add(Blocks.STRIPPED_CHERRY_WOOD)
                .add(Blocks.STRIPPED_BAMBOO_BLOCK);

        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.WOOD_ANEMONA)
                .add(LEAVES.get("hawthorn"));

        getOrCreateTagBuilder(BlockTags.TALL_FLOWERS)
                .add(ModBlocks.LARGE_CELANDINE);

        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                .add(ModBlocks.POTTED_WHITE_MUSHROOM);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.OAK_CHISELED)
                .add(ModBlocks.BIRCH_CHISELED)
                .add(ModBlocks.SPRUCE_CHISELED)
                .add(ModBlocks.JUNGLE_CHISELED)
                .add(ModBlocks.ACACIA_CHISELED)
                .add(ModBlocks.DARK_OAK_CHISELED)
                .add(ModBlocks.CRIMSON_CHISELED)
                .add(ModBlocks.WARPED_CHISELED)
                .add(ModBlocks.MANGROVE_CHISELED)
                .add(ModBlocks.CHERRY_CHISELED);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.OAK_CHISELED_SLAB)
                .add(ModBlocks.BIRCH_CHISELED_SLAB)
                .add(ModBlocks.SPRUCE_CHISELED_SLAB)
                .add(ModBlocks.JUNGLE_CHISELED_SLAB)
                .add(ModBlocks.ACACIA_CHISELED_SLAB)
                .add(ModBlocks.DARK_OAK_CHISELED_SLAB)
                .add(ModBlocks.CRIMSON_CHISELED_SLAB)
                .add(ModBlocks.WARPED_CHISELED_SLAB)
                .add(ModBlocks.MANGROVE_CHISELED_SLAB)
                .add(ModBlocks.CHERRY_CHISELED_SLAB);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.OAK_CHISELED_STAIRS)
                .add(ModBlocks.BIRCH_CHISELED_STAIRS)
                .add(ModBlocks.SPRUCE_CHISELED_STAIRS)
                .add(ModBlocks.JUNGLE_CHISELED_STAIRS)
                .add(ModBlocks.ACACIA_CHISELED_STAIRS)
                .add(ModBlocks.DARK_OAK_CHISELED_STAIRS)
                .add(ModBlocks.CRIMSON_CHISELED_STAIRS)
                .add(ModBlocks.WARPED_CHISELED_STAIRS)
                .add(ModBlocks.MANGROVE_CHISELED_STAIRS)
                .add(ModBlocks.CHERRY_CHISELED_STAIRS);

        getOrCreateTagBuilder(ModTags.Blocks.ORCHID_MANTIS_FLOWERS)
                .add(ModBlocks.ORCHID)
                .add(ModBlocks.LARGE_ORCHID);
    }
}
