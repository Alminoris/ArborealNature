package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.block.ModBlocks;
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
            getOrCreateTagBuilder(BlockTags.SAPLINGS)
                    .add(WOODEN_SAPLINGS.get(name));

            getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                    .add(LOGS.get(name))
                    .add(STRIPPED_LOGS.get(name))
                    .add(WOODS.get(name))
                    .add(STRIPPED_WOODS.get(name));

            getOrCreateTagBuilder(ModTags.Blocks.LOGS_TO_BE_BURNT)
                    .add(STRIPPED_LOGS.get(name));

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

            this.getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(LEAVES.get(name));
        }

        for (String name : WF_WOOD_NAMES)
        {
            getOrCreateTagBuilder(BlockTags.PLANKS)
                    .add(WOODEN_CHISELED.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                    .add(WOODEN_CHISELED_STAIRS.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                    .add(WOODEN_CHISELED_SLABS.get(name));
        }

        for (String name : ST_WOOD_NAMES)
        {
            getOrCreateTagBuilder(BlockTags.PLANKS)
                    .add(WOODEN_CHISELED.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                    .add(WOODEN_CHISELED_STAIRS.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                    .add(WOODEN_CHISELED_SLABS.get(name));
        }

        for (String name : WT_WOOD_NAMES)
        {
            getOrCreateTagBuilder(BlockTags.PLANKS)
                    .add(WOODEN_CHISELED.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                    .add(WOODEN_CHISELED_STAIRS.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                    .add(WOODEN_CHISELED_SLABS.get(name));
        }

        for (String name : MT_WOOD_NAMES)
        {
            getOrCreateTagBuilder(BlockTags.PLANKS)
                    .add(WOODEN_CHISELED.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                    .add(WOODEN_CHISELED_STAIRS.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                    .add(WOODEN_CHISELED_SLABS.get(name));
        }

        for (String name : NSS_WOOD_NAMES)
        {
            getOrCreateTagBuilder(BlockTags.PLANKS)
                    .add(WOODEN_CHISELED.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                    .add(WOODEN_CHISELED_STAIRS.get(name));

            getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                    .add(WOODEN_CHISELED_SLABS.get(name));
        }

        getOrCreateTagBuilder(ModTags.Blocks.LOGS_TO_BE_BURNT)
                .add(Blocks.STRIPPED_BIRCH_LOG)
                .add(Blocks.STRIPPED_BAMBOO_BLOCK)
                .add(Blocks.STRIPPED_OAK_LOG)
                .add(Blocks.STRIPPED_DARK_OAK_LOG)
                .add(Blocks.STRIPPED_ACACIA_LOG)
                .add(Blocks.STRIPPED_MANGROVE_LOG)
                .add(Blocks.STRIPPED_JUNGLE_LOG)
                .add(Blocks.STRIPPED_SPRUCE_LOG)
                .add(Blocks.STRIPPED_CRIMSON_STEM)
                .add(Blocks.STRIPPED_WARPED_STEM)
                .add(Blocks.STRIPPED_CHERRY_LOG);

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
                .add(ModBlocks.ORCHID)
                .add(ModBlocks.GERANIUM)
                .add(ModBlocks.XEROCHRYSUM)
                .add(ModBlocks.BLUEBELL)
                .add(ModBlocks.WOOD_SORREL)
                .add(ModBlocks.PRICKLY_GRASS)
                .add(ModBlocks.THISTLE)
                .add(LEAVES.get("hawthorn"));

        getOrCreateTagBuilder(BlockTags.TALL_FLOWERS)
                .add(ModBlocks.BLUEGRASS)
                .add(ModBlocks.LARGE_ORCHID)
                .add(ModBlocks.LARGE_CELANDINE);

        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                .add(ModBlocks.POTTED_GERANIUM)
                .add(ModBlocks.POTTED_XEROCHRYSUM)
                .add(ModBlocks.POTTED_BLUEBELL)
                .add(ModBlocks.POTTED_THISTLE)
                .add(ModBlocks.POTTED_PRICKLY_GRASS)
                .add(ModBlocks.POTTED_ORCHID)
                .add(ModBlocks.POTTED_WHITE_MUSHROOM);

        this.getOrCreateTagBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(ModBlocks.ORCHID_LILY_PAD);

        this.getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(ModBlocks.ORCHID_LILY_PAD);

        this.getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT).add(ModBlocks.ORCHID_LILY_PAD).add(ModBlocks.REINDEER_LICHEN, ModBlocks.REINDEER_LICHEN_CARPET);

        this.getOrCreateTagBuilder(BlockTags.FROG_PREFER_JUMP_TO).add(ModBlocks.ORCHID_LILY_PAD);

        this.getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.REINDEER_LICHEN, ModBlocks.REINDEER_LICHEN_CARPET);

        this.getOrCreateTagBuilder(BlockTags.DIRT).add(ModBlocks.REINDEER_LICHEN);

        this.getOrCreateTagBuilder(BlockTags.COMBINATION_STEP_SOUND_BLOCKS).add(ModBlocks.REINDEER_LICHEN_CARPET);

        this.getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(ModBlocks.BAUHINIA_VINES);

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
                .add(ModBlocks.CHERRY_CHISELED)
                .add(ModBlocks.PINE_RESIN_BRICKS);

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
                .add(ModBlocks.CHERRY_CHISELED_SLAB)
                .add(ModBlocks.PINE_RESIN_BRICKS_SLAB);

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
                .add(ModBlocks.CHERRY_CHISELED_STAIRS)
                .add(ModBlocks.PINE_RESIN_BRICKS_STAIRS);

        getOrCreateTagBuilder(ModTags.Blocks.ORCHID_MANTIS_FLOWERS)
                .add(ModBlocks.ORCHID)
                .add(ModBlocks.LARGE_ORCHID);

        getOrCreateTagBuilder(ModTags.Blocks.MOOSE_SPAWNABLE_ON)
                .add(Blocks.GRASS_BLOCK)
                .add(Blocks.PODZOL)
                .add(ModBlocks.DIRTED_GRASS_BLOCK)
                .add(ModBlocks.PINE_COVER);

        getOrCreateTagBuilder(ModTags.Blocks.CARIBOU_SPAWNABLE_ON)
                .add(Blocks.GRASS_BLOCK)
                .add(ModBlocks.REINDEER_LICHEN_CARPET)
                .add(Blocks.SNOW);

        getOrCreateTagBuilder(ModTags.Blocks.WOLVERINE_SPAWNABLE_ON)
                .add(Blocks.GRASS_BLOCK)
                .add(Blocks.PODZOL)
                .add(Blocks.SNOW);
    }
}
