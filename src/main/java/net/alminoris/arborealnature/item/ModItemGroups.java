package net.alminoris.arborealnature.item;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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

    public static final String[] CONIFER_WOODS = {"pine", "cedar", "fir", "larch", "sequoia",
            "thuja", "araucaria", "juniper", "yew", "bald_cypress"};

    public static final ItemGroup HAZELNUT_EXPANSION_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArborealNature.MOD_ID, "hazelnutexptab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.hazelnutexptab"))
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
                        entries.add(ModBlocks.CHERRY_CHISELED);
                        entries.add(ModBlocks.CHERRY_CHISELED_STAIRS);
                        entries.add(ModBlocks.CHERRY_CHISELED_SLAB);
                        entries.add(Blocks.BAMBOO_MOSAIC);
                        entries.add(Blocks.BAMBOO_MOSAIC_STAIRS);
                        entries.add(Blocks.BAMBOO_MOSAIC_SLAB);
                        for (String name : WOOD_NAMES)
                        {
                            entries.add(WOODEN_CHISELED.get(name));
                            entries.add(WOODEN_CHISELED_SLABS.get(name));
                            entries.add(WOODEN_CHISELED_STAIRS.get(name));
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
                    }).build());

    public static final ItemGroup ORCHARD_EXPANSION_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArborealNature.MOD_ID, "orchardexptab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.orchardexptab"))
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
                        entries.add(ModItems.FIGEATER_BEETLE_CHESTPLATE);
                        entries.add(ModItems.ORCHID_MANTIS_INCISOR);
                        entries.add(ModItems.FIGEATER_BEETLE_SHELL);
                        entries.add(ModItems.FIGEATER_BEETLE_SPAWN_EGG);
                        entries.add(ModItems.ORCHID_MANTIS_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups()
    {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries ->
        {
            entries.addAfter(Blocks.CHERRY_BUTTON,
                    LOGS.get("hazelnut"),
                    WOODS.get("hazelnut"),
                    STRIPPED_LOGS.get("hazelnut"),
                    STRIPPED_WOODS.get("hazelnut"),
                    BURNT_LOGS.get("hazelnut"),
                    BURNT_WOODS.get("hazelnut"),
                    WOODEN_PLANKS.get("hazelnut"),
                    WOODEN_STAIRS.get("hazelnut"),
                    WOODEN_SLABS.get("hazelnut"),
                    WOODEN_CHISELED.get("hazelnut"),
                    WOODEN_CHISELED_STAIRS.get("hazelnut"),
                    WOODEN_CHISELED_SLABS.get("hazelnut"),
                    WOODEN_FENCES.get("hazelnut"),
                    WOODEN_FENCE_GATES.get("hazelnut"),
                    WOODEN_DOORS.get("hazelnut"),
                    WOODEN_TRAPDOORS.get("hazelnut"),
                    WOODEN_PRESSURE_PLATES.get("hazelnut"),
                    WOODEN_BUTTONS.get("hazelnut"));

            String previousName = "hazelnut";

            for (String name : WOOD_NAMES)
            {
                if (!name.equals(previousName))
                {
                    entries.addAfter(WOODEN_BUTTONS.get(previousName),
                            LOGS.get(name),
                            WOODS.get(name),
                            STRIPPED_LOGS.get(name),
                            STRIPPED_WOODS.get(name),
                            BURNT_LOGS.get(name),
                            BURNT_WOODS.get(name),
                            WOODEN_PLANKS.get(name),
                            WOODEN_STAIRS.get(name),
                            WOODEN_SLABS.get(name),
                            WOODEN_CHISELED.get(name),
                            WOODEN_CHISELED_STAIRS.get(name),
                            WOODEN_CHISELED_SLABS.get(name),
                            WOODEN_FENCES.get(name),
                            WOODEN_FENCE_GATES.get(name),
                            WOODEN_DOORS.get(name),
                            WOODEN_TRAPDOORS.get(name),
                            WOODEN_PRESSURE_PLATES.get(name),
                            WOODEN_BUTTONS.get(name)
                    );
                }
                previousName = name;
            }
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries ->
        {
            entries.addAfter(Blocks.GRASS_BLOCK,
                    ModBlocks.ORCHID_GRASS_BLOCK);

            entries.addAfter(Blocks.CHERRY_LEAVES,
                    LEAVES.get("hazelnut"));

            entries.addAfter(Blocks.CHERRY_SAPLING,
                    WOODEN_SAPLINGS.get("hazelnut"));

            entries.addAfter(Blocks.CHERRY_LOG,
                    LOGS.get("hazelnut"));

            entries.addAfter(Blocks.MUSHROOM_STEM,
                    ModBlocks.WHITE_MUSHROOM_STEM);

            entries.addAfter(Blocks.RED_MUSHROOM_BLOCK,
                    ModBlocks.WHITE_MUSHROOM_BLOCK);

            entries.addAfter(Blocks.RED_MUSHROOM,
                    ModBlocks.WHITE_MUSHROOM);

            entries.addAfter(Blocks.LILY_OF_THE_VALLEY,
                    ModBlocks.GERANIUM,
                    ModBlocks.ORCHID);

            entries.addAfter(Blocks.PEONY,
                    ModBlocks.LARGE_CELANDINE,
                    ModBlocks.BLUEGRASS,
                    ModBlocks.LARGE_ORCHID);

            entries.addAfter(Blocks.VINE,
                    ModBlocks.BAUHINIA_VINES);

            entries.addAfter(Blocks.LILY_PAD,
                    ModBlocks.ORCHID_LILY_PAD);

            entries.addAfter(Blocks.MOSS_CARPET,
                    ModBlocks.HAZELNUT_COVER,
                    ModBlocks.BAUHINIA_COVER_BLOCK,
                    ModBlocks.BAUHINIA_COVER);

            entries.addAfter(Blocks.PINK_PETALS,
                    ModBlocks.WOOD_ANEMONA);

            String previousName = "hazelnut";

            for (String name : WOOD_NAMES)
            {
                if (!name.equals(previousName))
                {
                    entries.addAfter(LEAVES.get(previousName),
                            LEAVES.get(name));

                    entries.addAfter(LOGS.get(previousName),
                            LOGS.get(name));

                    entries.addAfter(WOODEN_SAPLINGS.get(previousName),
                            WOODEN_SAPLINGS.get(name));
                }
                previousName = name;
            }
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries ->
        {
            entries.addAfter(Items.CHERRY_HANGING_SIGN,
                    WOODEN_SIGN_ITEMS.get("hazelnut"),
                    WOODEN_HANGING_SIGN_ITEMS.get("hazelnut"));

            String previousName = "hazelnut";

            for (String name : WOOD_NAMES)
            {
                if (!name.equals(previousName))
                {
                    entries.addAfter(WOODEN_HANGING_SIGN_ITEMS.get(previousName),
                            WOODEN_SIGN_ITEMS.get(name),
                            WOODEN_HANGING_SIGN_ITEMS.get(name));
                }
                previousName = name;
            }
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries ->
        {
            entries.addAfter(Items.CHERRY_CHEST_BOAT,
                    WOODEN_BOATS.get("hazelnut"),
                    WOODEN_CHEST_BOATS.get("hazelnut"));

            entries.addAfter(Items.FLINT_AND_STEEL,
                    ModItems.MINIHAMMER,
                    ModItems.CHISEL);

            String previousName = "hazelnut";

            for (String name : WOOD_NAMES)
            {
                if (!name.equals(previousName))
                {
                    entries.addAfter(WOODEN_CHEST_BOATS.get(previousName),
                            WOODEN_BOATS.get(name),
                            WOODEN_CHEST_BOATS.get(name));
                }
                previousName = name;
            }
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries ->
        {
            entries.addAfter(Items.SPECTRAL_ARROW,
                    ModItems.SILENT_ARROW);

            entries.addAfter(Items.TURTLE_HELMET,
                    ModItems.FIGEATER_BEETLE_CHESTPLATE);

            entries.addAfter(Items.MACE,
                    ModItems.ORCHID_MANTIS_INCISOR);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries ->
        {
            entries.addAfter(Items.ENCHANTED_GOLDEN_APPLE,
                    ModItems.QUINCE,
                    ModItems.PLUM,
                    ModItems.MANGO,
                    ModItems.FIGS,
                    ModItems.VIBURNUM,
                    ModItems.WHITE_MULBERRY,
                    ModItems.WILD_CHERRY);

            entries.addAfter(Items.GLOW_BERRIES,
                    BERRIES.get("bilberry"),
                    BERRIES.get("blackberry"),
                    BERRIES.get("pink_currant"),
                    ModItems.HAZELNUT_PEELED);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->
        {
            entries.addAfter(Items.RABBIT_HIDE,
                    ModItems.SQUIRREL_HIDE,
                    ModItems.WOOD_MOUSE_TAIL);

            entries.addAfter(Items.EGG,
                    ModItems.HAZELNUT,
                    ModItems.HAZELNUT_CRACKED,
                    ModItems.HAZELNUT_SPOILED);

            entries.addAfter(Items.TURTLE_SCUTE,
                    ModItems.FIGEATER_BEETLE_SHELL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries ->
        {
            entries.addAfter(Items.WOLF_SPAWN_EGG,
                    ModItems.WOOD_MOUSE_SPAWN_EGG);

            entries.addAfter(Items.OCELOT_SPAWN_EGG,
                    ModItems.ORCHID_MANTIS_SPAWN_EGG);

            entries.addAfter(Items.SQUID_SPAWN_EGG,
                    ModItems.SQUIRREL_SPAWN_EGG);

            entries.addAfter(Items.EVOKER_SPAWN_EGG,
                    ModItems.FIGEATER_BEETLE_SPAWN_EGG);
        });
    }
}
