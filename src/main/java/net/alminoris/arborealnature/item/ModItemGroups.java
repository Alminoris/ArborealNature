package net.alminoris.arborealnature.item;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.alminoris.arborealnature.util.helper.ModBlockSetsHelper.*;

public class ModItemGroups
{
    public static final String[] ORCHARD_WOODS = {"quince", "plum", "mango", "fig", "viburnum",
            "white_mulberry", "wild_cherry", "bauhinia"};

    public static final String[] HAZELNUT_WOODS = {"hazelnut", "hornbeam", "hawthorn"};

    public static final String[] CONIFER_WOODS = {"pine", "fir", "cedar"};

    public static final String[] CONIFER_BERRIES = {"blueberry"};

    public static final String[] ORCHARD_BERRIES = {"bilberry", "blackberry", "pink_currant"};

    //"cedar", "fir", "larch", "sequoia",
    //            "thuja", "araucaria", "juniper", "yew", "bald_cypress"

    public static final ItemGroup HAZELNUT_EXPANSION_TAB = FabricItemGroup.builder(Identifier.of(ArborealNature.MOD_ID, "hazelnutexptab"))
            .displayName(Text.translatable("itemgroup.hazelnutexptab"))
                    .icon(() -> new ItemStack(ModItems.HAZELNUT_CRACKED)).entries((displayContext, entries) ->
                    {
                        entries.add(ModBlocks.WOOD_ANEMONA);
                        entries.add(ModBlocks.LARGE_CELANDINE);
                        entries.add(ModBlocks.HAZELNUT_COVER);
                        entries.add(ModBlocks.WHITE_MUSHROOM);
                        entries.add(ModBlocks.WHITE_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.WHITE_MUSHROOM_STEM);
                        for (String name : HAZELNUT_WOODS)
                        {
                            entries.add(WOODEN_SAPLINGS.get(name));
                        }
                        for (String name : HAZELNUT_WOODS)
                        {
                            entries.add(LEAVES.get(name));
                        }
                        for (String name : HAZELNUT_WOODS)
                        {
                            entries.add(LOGS.get(name));
                            entries.add(WOODS.get(name));
                            entries.add(STRIPPED_LOGS.get(name));
                            entries.add(STRIPPED_WOODS.get(name));
                            entries.add(WOODEN_PLANKS.get(name));
                            entries.add(WOODEN_SLABS.get(name));
                            entries.add(WOODEN_STAIRS.get(name));
                            entries.add(WOODEN_FENCES.get(name));
                            entries.add(WOODEN_FENCE_GATES.get(name));
                            entries.add(WOODEN_DOORS.get(name));
                            entries.add(WOODEN_TRAPDOORS.get(name));
                            entries.add(WOODEN_BUTTONS.get(name));
                            entries.add(WOODEN_PRESSURE_PLATES.get(name));
                            entries.add(WOODEN_SIGN_ITEMS.get(name));
                            entries.add(WOODEN_HANGING_SIGN_ITEMS.get(name));
                            entries.add(WOODEN_BOATS.get(name));
                            entries.add(WOODEN_CHEST_BOATS.get(name));
                        }
                        entries.add(ModBlocks.OAK_CHISELED);
                        entries.add(ModBlocks.OAK_CHISELED_STAIRS);
                        entries.add(ModBlocks.OAK_CHISELED_SLAB);
                        entries.add(ModBlocks.BIRCH_CHISELED);
                        entries.add(ModBlocks.BIRCH_CHISELED_STAIRS);
                        entries.add(ModBlocks.BIRCH_CHISELED_SLAB);
                        entries.add(ModBlocks.SPRUCE_CHISELED);
                        entries.add(ModBlocks.SPRUCE_CHISELED_STAIRS);
                        entries.add(ModBlocks.SPRUCE_CHISELED_SLAB);
                        entries.add(ModBlocks.JUNGLE_CHISELED);
                        entries.add(ModBlocks.JUNGLE_CHISELED_STAIRS);
                        entries.add(ModBlocks.JUNGLE_CHISELED_SLAB);
                        entries.add(ModBlocks.ACACIA_CHISELED);
                        entries.add(ModBlocks.ACACIA_CHISELED_STAIRS);
                        entries.add(ModBlocks.ACACIA_CHISELED_SLAB);
                        entries.add(ModBlocks.DARK_OAK_CHISELED);
                        entries.add(ModBlocks.DARK_OAK_CHISELED_STAIRS);
                        entries.add(ModBlocks.DARK_OAK_CHISELED_SLAB);
                        entries.add(ModBlocks.CRIMSON_CHISELED);
                        entries.add(ModBlocks.CRIMSON_CHISELED_STAIRS);
                        entries.add(ModBlocks.CRIMSON_CHISELED_SLAB);
                        entries.add(ModBlocks.WARPED_CHISELED);
                        entries.add(ModBlocks.WARPED_CHISELED_STAIRS);
                        entries.add(ModBlocks.WARPED_CHISELED_SLAB);
                        entries.add(ModBlocks.MANGROVE_CHISELED);
                        entries.add(ModBlocks.MANGROVE_CHISELED_STAIRS);
                        entries.add(ModBlocks.MANGROVE_CHISELED_SLAB);
                        entries.add(Blocks.BAMBOO_MOSAIC);
                        entries.add(Blocks.BAMBOO_MOSAIC_STAIRS);
                        entries.add(Blocks.BAMBOO_MOSAIC_SLAB);
                        for (String name : WOOD_NAMES)
                        {
                            entries.add(WOODEN_CHISELED.get(name));
                            entries.add(WOODEN_CHISELED_SLABS.get(name));
                            entries.add(WOODEN_CHISELED_STAIRS.get(name));
                        }
                        if (FabricLoader.getInstance().isModLoaded("wildfields"))
                        {
                            for(String name : WF_WOOD_NAMES)
                            {
                                entries.add(WOODEN_CHISELED.get(name));
                                entries.add(WOODEN_CHISELED_SLABS.get(name));
                                entries.add(WOODEN_CHISELED_STAIRS.get(name));
                            }
                        }
                        entries.add(ModItems.HAZELNUT_PEELED);
                        entries.add(ModItems.HAZELNUT);
                        entries.add(ModItems.HAZELNUT_CRACKED);
                        entries.add(ModItems.HAZELNUT_SPOILED);
                        entries.add(ModItems.MINIHAMMER);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.SILENT_ARROW);
                        entries.add(ModItems.SQUIRREL_HIDE);
                        entries.add(ModItems.WOOD_MOUSE_TAIL);
                        entries.add(ModItems.SQUIRREL_SPAWN_EGG);
                        entries.add(ModItems.WOOD_MOUSE_SPAWN_EGG);
                    }).build();

    public static final ItemGroup ORCHARD_EXPANSION_TAB = FabricItemGroup.builder(Identifier.of(ArborealNature.MOD_ID, "orchardexptab"))
            .displayName(Text.translatable("itemgroup.orchardexptab"))
                    .icon(() -> new ItemStack(ModBlocks.LARGE_ORCHID)).entries((displayContext, entries) ->
                    {
                        entries.add(ModBlocks.ORCHID_GRASS_BLOCK);
                        entries.add(ModBlocks.GERANIUM);
                        entries.add(ModBlocks.ORCHID);
                        entries.add(ModBlocks.BLUEGRASS);
                        entries.add(ModBlocks.LARGE_ORCHID);
                        entries.add(ModItems.ORCHID_LILY_PAD);
                        entries.add(ModBlocks.BAUHINIA_COVER);
                        entries.add(ModBlocks.BAUHINIA_COVER_BLOCK);
                        entries.add(ModBlocks.BAUHINIA_VINES);
                        for (String name : ORCHARD_WOODS)
                        {
                            entries.add(WOODEN_SAPLINGS.get(name));
                        }
                        for (String name : ORCHARD_WOODS)
                        {
                            entries.add(LEAVES.get(name));
                        }
                        for (String name : ORCHARD_WOODS)
                        {
                            entries.add(LOGS.get(name));
                            entries.add(WOODS.get(name));
                            entries.add(STRIPPED_LOGS.get(name));
                            entries.add(STRIPPED_WOODS.get(name));
                            entries.add(WOODEN_PLANKS.get(name));
                            entries.add(WOODEN_SLABS.get(name));
                            entries.add(WOODEN_STAIRS.get(name));
                            entries.add(WOODEN_FENCES.get(name));
                            entries.add(WOODEN_FENCE_GATES.get(name));
                            entries.add(WOODEN_DOORS.get(name));
                            entries.add(WOODEN_TRAPDOORS.get(name));
                            entries.add(WOODEN_BUTTONS.get(name));
                            entries.add(WOODEN_PRESSURE_PLATES.get(name));
                            entries.add(WOODEN_SIGN_ITEMS.get(name));
                            entries.add(WOODEN_HANGING_SIGN_ITEMS.get(name));
                            entries.add(WOODEN_BOATS.get(name));
                            entries.add(WOODEN_CHEST_BOATS.get(name));
                        }
                        for (String name : CLASSIC_WOOD_NAMES)
                        {
                            entries.add(BURNT_LOGS.get(name));
                            entries.add(BURNT_WOODS.get(name));
                        }
                        for (String name : WOOD_NAMES)
                        {
                            entries.add(BURNT_LOGS.get(name));
                            entries.add(BURNT_WOODS.get(name));
                        }
                        if (FabricLoader.getInstance().isModLoaded("wildfields"))
                        {
                            for(String name : WF_WOOD_NAMES)
                            {
                                entries.add(BURNT_LOGS.get(name));
                                entries.add(BURNT_WOODS.get(name));
                            }
                        }
                        entries.add(ModItems.QUINCE);
                        entries.add(ModItems.PLUM);
                        entries.add(ModItems.MANGO);
                        entries.add(ModItems.FIGS);
                        entries.add(ModItems.VIBURNUM);
                        entries.add(ModItems.WILD_CHERRY);
                        entries.add(ModItems.WHITE_MULBERRY);
                        for (String name : ORCHARD_BERRIES)
                        {
                            entries.add(BERRIES.get(name));
                        }
                        entries.add(ModItems.FIGEATER_BEETLE_CHESTPLATE);
                        entries.add(ModItems.ORCHID_MANTIS_INCISOR);
                        entries.add(ModItems.FIGEATER_BEETLE_SHELL);
                        entries.add(ModItems.FIGEATER_BEETLE_SPAWN_EGG);
                        entries.add(ModItems.ORCHID_MANTIS_SPAWN_EGG);
                    }).build();

    public static final ItemGroup CONIFEROUS_EXPANSION_TAB = FabricItemGroup.builder(Identifier.of(ArborealNature.MOD_ID, "coniferousexptab"))
            .displayName(Text.translatable("itemgroup.coniferousexptab"))
                    .icon(() -> new ItemStack(Blocks.SPRUCE_SAPLING)).entries((displayContext, entries) ->
                    {
                        entries.add(ModBlocks.DIRTED_GRASS_BLOCK);
                        entries.add(ModBlocks.XEROCHRYSUM);
                        entries.add(ModBlocks.BLUEBELL);
                        entries.add(ModBlocks.WOOD_SORREL);
                        entries.add(ModBlocks.REINDEER_LICHEN_CARPET);
                        entries.add(ModBlocks.REINDEER_LICHEN);
                        entries.add(ModBlocks.PINE_COVER);
                        entries.add(ModBlocks.PINE_COVER_BLOCK);
                        entries.add(ModItems.PINE_CONE);
                        entries.add(ModBlocks.PINE_CONE_BLOCK);
                        entries.add(ModItems.FIR_CONE);
                        entries.add(ModBlocks.FIR_CONE_BLOCK);
                        entries.add(ModItems.CEDAR_CONE);
                        entries.add(ModBlocks.CEDAR_CONE_BLOCK);
                        for (String name : CONIFER_WOODS)
                        {
                            entries.add(WOODEN_SAPLINGS.get(name));
                        }
                        for (String name : CONIFER_WOODS)
                        {
                            entries.add(LEAVES.get(name));
                        }
                        for (String name : CONIFER_WOODS)
                        {
                            entries.add(LOGS.get(name));
                            entries.add(WOODS.get(name));
                            entries.add(STRIPPED_LOGS.get(name));
                            entries.add(STRIPPED_WOODS.get(name));
                            entries.add(WOODEN_PLANKS.get(name));
                            entries.add(WOODEN_SLABS.get(name));
                            entries.add(WOODEN_STAIRS.get(name));
                            entries.add(WOODEN_FENCES.get(name));
                            entries.add(WOODEN_FENCE_GATES.get(name));
                            entries.add(WOODEN_DOORS.get(name));
                            entries.add(WOODEN_TRAPDOORS.get(name));
                            entries.add(WOODEN_BUTTONS.get(name));
                            entries.add(WOODEN_PRESSURE_PLATES.get(name));
                            entries.add(WOODEN_SIGN_ITEMS.get(name));
                            entries.add(WOODEN_HANGING_SIGN_ITEMS.get(name));
                            entries.add(WOODEN_BOATS.get(name));
                            entries.add(WOODEN_CHEST_BOATS.get(name));
                        }
                        for (String name : CONIFER_BERRIES)
                        {
                            entries.add(BERRIES.get(name));
                        }
                        entries.add(ModBlocks.PINE_RESIN);
                        entries.add(ModBlocks.PINE_RESIN_BLOCK);
                        entries.add(ModBlocks.PINE_RESIN_CHISELED);
                        entries.add(ModBlocks.PINE_RESIN_BRICKS);
                        entries.add(ModBlocks.PINE_RESIN_BRICKS_SLAB);
                        entries.add(ModBlocks.PINE_RESIN_BRICKS_STAIRS);
                        entries.add(ModItems.HUNTING_KNIFE);
                        entries.add(ModItems.MOOSE_HORN);
                        entries.add(ModBlocks.LYNX_HIDE);
                        entries.add(ModItems.CARIBOU_SPEAR);
                        entries.add(ModItems.WOLVERINE_PAW);
                        entries.add(ModItems.CARIBOU_FUR_HELMET);
                        entries.add(ModItems.CARIBOU_FUR_CHESTPLATE);
                        entries.add(ModItems.CARIBOU_FUR_LEGGINGS);
                        entries.add(ModItems.CARIBOU_FUR_BOOTS);
                        entries.add(ModItems.CARIBOU_HORN);
                        entries.add(ModItems.CARIBOU_FUR);
                        entries.add(ModItems.PINE_RESIN);
                        entries.add(ModItems.MOOSE_VENISON);
                        entries.add(ModItems.COOKED_MOOSE_VENISON);
                        entries.add(ModItems.CARIBOU_VENISON);
                        entries.add(ModItems.COOKED_CARIBOU_VENISON);
                        entries.add(ModItems.MOOSE_SPAWN_EGG);
                        entries.add(ModItems.LYNX_SPAWN_EGG);
                        entries.add(ModItems.CARIBOU_SPAWN_EGG);
                        entries.add(ModItems.WOLVERINE_SPAWN_EGG);
                    }).build();

    public static void registerItemGroups()
    {

    }
}