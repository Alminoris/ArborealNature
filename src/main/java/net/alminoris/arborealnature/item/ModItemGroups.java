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

public class ModItemGroups
{
    public static final ItemGroup ARBOREAL_NATURE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArborealNature.MOD_ID, "antab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.antab"))
                    .icon(() -> new ItemStack(ModItems.HAZELNUT)).entries((displayContext, entries) ->
                    {
                        entries.add(ModBlocks.HAZELNUT_LOG);
                        entries.add(ModBlocks.STRIPPED_HAZELNUT_LOG);
                        entries.add(ModBlocks.HAZELNUT_WOOD);
                        entries.add(ModBlocks.STRIPPED_HAZELNUT_WOOD);
                        entries.add(ModBlocks.HAZELNUT_PLANKS);
                        entries.add(ModBlocks.HAZELNUT_CHISELED);
                        entries.add(ModBlocks.HAZELNUT_CHISELED_STAIRS);
                        entries.add(ModBlocks.HAZELNUT_CHISELED_SLAB);
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
                        entries.add(ModBlocks.HAZELNUT_STAIRS);
                        entries.add(ModBlocks.HAZELNUT_SLAB);
                        entries.add(ModBlocks.HAZELNUT_FENCE);
                        entries.add(ModBlocks.HAZELNUT_FENCE_GATE);
                        entries.add(ModBlocks.HAZELNUT_DOOR);
                        entries.add(ModBlocks.HAZELNUT_TRAPDOOR);
                        entries.add(ModBlocks.HAZELNUT_BUTTON);
                        entries.add(ModBlocks.HAZELNUT_PRESSURE_PLATE);
                        entries.add(ModItems.HAZELNUT_SIGN);
                        entries.add(ModItems.HAZELNUT_HANGING_SIGN);
                        entries.add(ModItems.HAZELNUT_BOAT);
                        entries.add(ModItems.HAZELNUT_CHEST_BOAT);
                        entries.add(ModBlocks.HAZELNUT_SAPLING);
                        entries.add(ModItems.MINIHAMMER);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.HAZELNUT);
                        entries.add(ModItems.HAZELNUT_CRACKED);
                        entries.add(ModItems.HAZELNUT_SPOILED);
                        entries.add(ModItems.HAZELNUT_PEELED);
                        entries.add(ModItems.SQUIRREL_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups()
    {

    }
}
