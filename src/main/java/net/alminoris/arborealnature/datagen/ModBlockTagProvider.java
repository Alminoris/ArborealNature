package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider
{
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.HAZELNUT_LOG)
                .add(ModBlocks.STRIPPED_HAZELNUT_LOG)
                .add(ModBlocks.HAZELNUT_WOOD)
                .add(ModBlocks.STRIPPED_HAZELNUT_WOOD);

        getOrCreateTagBuilder(ModTags.Blocks.CHISELABLE_BLOCKS)
                .add(ModBlocks.STRIPPED_HAZELNUT_WOOD)
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

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.HAZELNUT_PLANKS)
                .add(ModBlocks.HAZELNUT_CHISELED)
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

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.HAZELNUT_FENCE);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.HAZELNUT_SLAB)
                .add(ModBlocks.HAZELNUT_CHISELED_SLAB)
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
                .add(ModBlocks.HAZELNUT_STAIRS)
                .add(ModBlocks.HAZELNUT_CHISELED_STAIRS)
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

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.HAZELNUT_BUTTON);

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.HAZELNUT_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.HAZELNUT_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.HAZELNUT_DOOR);

        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
                .add(ModBlocks.HAZELNUT_SIGN);

        getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
                .add(ModBlocks.HAZELNUT_WALL_SIGN);

        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
                .add(ModBlocks.HAZELNUT_HANGING_SIGN);

        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
                .add(ModBlocks.HAZELNUT_WALL_HANGING_SIGN);
    }
}
