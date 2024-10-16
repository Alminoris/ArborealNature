package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider
{
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup)
    {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate()
    {
        addDrop(ModBlocks.HAZELNUT_LOG);
        addDrop(ModBlocks.STRIPPED_HAZELNUT_LOG);
        addDrop(ModBlocks.HAZELNUT_WOOD);
        addDrop(ModBlocks.STRIPPED_HAZELNUT_WOOD);
        addDrop(ModBlocks.HAZELNUT_PLANKS);
        addDrop(ModBlocks.HAZELNUT_CHISELED);
        addDrop(ModBlocks.HAZELNUT_CHISELED_SLAB);
        addDrop(ModBlocks.HAZELNUT_CHISELED_STAIRS);
        addDrop(ModBlocks.OAK_CHISELED);
        addDrop(ModBlocks.OAK_CHISELED_SLAB);
        addDrop(ModBlocks.OAK_CHISELED_STAIRS);
        addDrop(ModBlocks.BIRCH_CHISELED);
        addDrop(ModBlocks.BIRCH_CHISELED_SLAB);
        addDrop(ModBlocks.BIRCH_CHISELED_STAIRS);
        addDrop(ModBlocks.SPRUCE_CHISELED);
        addDrop(ModBlocks.SPRUCE_CHISELED_SLAB);
        addDrop(ModBlocks.SPRUCE_CHISELED_STAIRS);
        addDrop(ModBlocks.JUNGLE_CHISELED);
        addDrop(ModBlocks.JUNGLE_CHISELED_SLAB);
        addDrop(ModBlocks.JUNGLE_CHISELED_STAIRS);
        addDrop(ModBlocks.ACACIA_CHISELED);
        addDrop(ModBlocks.ACACIA_CHISELED_SLAB);
        addDrop(ModBlocks.ACACIA_CHISELED_STAIRS);
        addDrop(ModBlocks.DARK_OAK_CHISELED);
        addDrop(ModBlocks.DARK_OAK_CHISELED_SLAB);
        addDrop(ModBlocks.DARK_OAK_CHISELED_STAIRS);
        addDrop(ModBlocks.CRIMSON_CHISELED);
        addDrop(ModBlocks.CRIMSON_CHISELED_SLAB);
        addDrop(ModBlocks.CRIMSON_CHISELED_STAIRS);
        addDrop(ModBlocks.WARPED_CHISELED);
        addDrop(ModBlocks.WARPED_CHISELED_SLAB);
        addDrop(ModBlocks.WARPED_CHISELED_STAIRS);
        addDrop(ModBlocks.MANGROVE_CHISELED);
        addDrop(ModBlocks.MANGROVE_CHISELED_SLAB);
        addDrop(ModBlocks.MANGROVE_CHISELED_STAIRS);
        addDrop(ModBlocks.CHERRY_CHISELED);
        addDrop(ModBlocks.CHERRY_CHISELED_SLAB);
        addDrop(ModBlocks.CHERRY_CHISELED_STAIRS);
        addDrop(ModBlocks.HAZELNUT_SLAB);
        addDrop(ModBlocks.HAZELNUT_STAIRS);
        addDrop(ModBlocks.HAZELNUT_FENCE);
        addDrop(ModBlocks.HAZELNUT_FENCE_GATE);
        addDrop(ModBlocks.HAZELNUT_DOOR);
        addDrop(ModBlocks.HAZELNUT_TRAPDOOR);
        addDrop(ModBlocks.HAZELNUT_BUTTON);
        addDrop(ModBlocks.HAZELNUT_PRESSURE_PLATE);
        addDrop(ModBlocks.HAZELNUT_SIGN, drops(ModItems.HAZELNUT_SIGN));
        addDrop(ModBlocks.HAZELNUT_HANGING_SIGN, drops(ModItems.HAZELNUT_HANGING_SIGN));
        addDrop(ModBlocks.HAZELNUT_SAPLING);
        addDrop(ModBlocks.HAZELNUT_LEAVES, leavesDrops(ModBlocks.HAZELNUT_LEAVES, ModBlocks.HAZELNUT_SAPLING, 0.0025f));
        addDrop(ModBlocks.HAZELNUT_LEAVES, multipleOreDrops(ModBlocks.HAZELNUT_LEAVES, ModItems.HAZELNUT, 0, 2));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops)
    {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
