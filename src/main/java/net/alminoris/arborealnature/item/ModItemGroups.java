package net.alminoris.arborealnature.item;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
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
    public static final ItemGroup WOODS_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArborealNature.MOD_ID, "anwoodstab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.anwoodstab"))
                    .icon(() -> new ItemStack(WOODS.get("hazelnut"))).entries((displayContext, entries) ->
                    {
                        for (String name : WOOD_NAMES)
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
                            entries.add(WOODEN_CHISELED.get(name));
                            entries.add(WOODEN_CHISELED_SLABS.get(name));
                            entries.add(WOODEN_CHISELED_STAIRS.get(name));
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
                        entries.add(ModBlocks.CHERRY_CHISELED);
                        entries.add(ModBlocks.CHERRY_CHISELED_STAIRS);
                        entries.add(ModBlocks.CHERRY_CHISELED_SLAB);
                        entries.add(Blocks.BAMBOO_MOSAIC);
                        entries.add(Blocks.BAMBOO_MOSAIC_STAIRS);
                        entries.add(Blocks.BAMBOO_MOSAIC_SLAB);
                    }).build());

    public static final ItemGroup SPAWN_EGGS_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArborealNature.MOD_ID, "anspawneggstab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.anspawneggstab"))
                    .icon(() -> new ItemStack(ModItems.SQUIRREL_SPAWN_EGG)).entries((displayContext, entries) ->
                    {
                        entries.add(ModItems.SQUIRREL_SPAWN_EGG);
                        entries.add(ModItems.WOOD_MOUSE_SPAWN_EGG);
                        entries.add(ModItems.FIGEATER_BEETLE_SPAWN_EGG);
                        entries.add(ModItems.ORCHID_MANTIS_SPAWN_EGG);
                    }).build());

    public static final ItemGroup PLANTS_AND_MUSHROOMS_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArborealNature.MOD_ID, "anplntsmshrmstab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.anplntsmshrmstab"))
                    .icon(() -> new ItemStack(LEAVES.get("hazelnut"))).entries((displayContext, entries) ->
                    {
                        //entries.add(ModBlocks.ORCHID_GRASS_BLOCK);
                        for (String name : WOOD_NAMES)
                        {
                            entries.add(LEAVES.get(name));
                        }
                        entries.add(ModBlocks.WHITE_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.WHITE_MUSHROOM_STEM);
                        for (String name : WOOD_NAMES)
                        {
                            entries.add(WOODEN_SAPLINGS.get(name));
                        }
                        entries.add(ModBlocks.HAZELNUT_COVER);
                        entries.add(ModBlocks.LARGE_CELANDINE);
                        entries.add(ModBlocks.BLUEGRASS);
                        entries.add(ModBlocks.GERANIUM);
                        entries.add(ModBlocks.LARGE_ORCHID);
                        entries.add(ModBlocks.ORCHID);
                        entries.add(ModBlocks.WOOD_ANEMONA);
                        entries.add(ModBlocks.WHITE_MUSHROOM);
                    }).build());

    public static final ItemGroup TOOLS_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArborealNature.MOD_ID, "antoolstab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.antoolstab"))
                    .icon(() -> new ItemStack(ModItems.MINIHAMMER)).entries((displayContext, entries) ->
                    {
                        entries.add(ModItems.MINIHAMMER);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.SILENT_ARROW);
                        entries.add(ModItems.FIGEATER_BEETLE_CHESTPLATE);
                        entries.add(ModItems.ORCHID_MANTIS_INCISOR);
                    }).build());

    public static final ItemGroup FOOD_AND_INGREDIENTS_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArborealNature.MOD_ID, "anfoodingtab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.anfoodingtab"))
                    .icon(() -> new ItemStack(ModItems.HAZELNUT_CRACKED)).entries((displayContext, entries) ->
                    {
                        entries.add(ModItems.HAZELNUT_PEELED);
                        entries.add(ModItems.QUINCE);
                        entries.add(ModItems.PLUM);
                        entries.add(ModItems.MANGO);
                        entries.add(ModItems.FIGS);
                        entries.add(ModItems.VIBURNUM);
                        entries.add(ModItems.WILD_CHERRY);
                        entries.add(ModItems.WHITE_MULBERRY);
                        for (String name : BUSHES_NAMES)
                        {
                            entries.add(BERRIES.get(name));
                        }
                        entries.add(ModItems.HAZELNUT);
                        entries.add(ModItems.HAZELNUT_CRACKED);
                        entries.add(ModItems.HAZELNUT_SPOILED);
                        entries.add(ModItems.SQUIRREL_HIDE);
                        entries.add(ModItems.WOOD_MOUSE_TAIL);
                        entries.add(ModItems.FIGEATER_BEETLE_SHELL);
                    }).build());

    public static void registerItemGroups()
    {

    }
}
