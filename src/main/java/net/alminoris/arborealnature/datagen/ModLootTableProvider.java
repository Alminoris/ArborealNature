package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.util.helper.ModWoodHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
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
        for (String name : ModWoodHelper.WOOD_NAMES)
        {
            addDrop(ModWoodHelper.LOGS.get(name));
            addDrop(ModWoodHelper.STRIPPED_LOGS.get(name));
            addDrop(ModWoodHelper.WOODS.get(name));
            addDrop(ModWoodHelper.STRIPPED_WOODS.get(name));
            addDrop(ModWoodHelper.WOODEN_PLANKS.get(name));
            addDrop(ModWoodHelper.WOODEN_SLABS.get(name));
            addDrop(ModWoodHelper.WOODEN_STAIRS.get(name));
            addDrop(ModWoodHelper.WOODEN_CHISELED.get(name));
            addDrop(ModWoodHelper.WOODEN_CHISELED_SLABS.get(name));
            addDrop(ModWoodHelper.WOODEN_CHISELED_STAIRS.get(name));
            addDrop(ModWoodHelper.WOODEN_FENCES.get(name));
            addDrop(ModWoodHelper.WOODEN_FENCE_GATES.get(name));
            addDrop(ModWoodHelper.WOODEN_DOORS.get(name));
            addDrop(ModWoodHelper.WOODEN_TRAPDOORS.get(name));
            addDrop(ModWoodHelper.WOODEN_BUTTONS.get(name));
            addDrop(ModWoodHelper.WOODEN_PRESSURE_PLATES.get(name));
            addDrop(ModWoodHelper.WOODEN_SIGNS.get(name), drops(ModWoodHelper.WOODEN_WALL_SIGNS.get(name)));
            addDrop(ModWoodHelper.WOODEN_HANGING_SIGNS.get(name), drops(ModWoodHelper.WOODEN_WALL_HANGING_SIGNS.get(name)));
            addDrop(ModWoodHelper.WOODEN_SAPLINGS.get(name));
            addDrop(ModWoodHelper.LEAVES.get(name), leavesItemDrops(ModWoodHelper.LEAVES.get(name),
                    ModWoodHelper.WOODEN_SAPLINGS.get(name), ModItems.HAZELNUT, 0.0025f));
        }

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

        addDrop(ModBlocks.WOOD_ANEMONA);
        addDrop(ModBlocks.HAZELNUT_COVER, dropsWithSilkTouch(ModBlocks.HAZELNUT_COVER));
        addDrop(ModBlocks.HAZELNUT_COVER, multipleOreDrops(ModBlocks.HAZELNUT_COVER, ModItems.HAZELNUT, 0, 3));
        addDrop(ModBlocks.LARGE_CELANDINE);
        addDrop(ModBlocks.WHITE_MUSHROOM);
        addDrop(ModBlocks.WHITE_MUSHROOM_BLOCK);
        addDrop(ModBlocks.WHITE_MUSHROOM_STEM);
    }

    private LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops)
    {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }

    private LootTable.Builder leavesItemDrops(Block leaves, Block sapling, Item item, float... saplingChance)
    {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.leavesDrops(leaves, sapling, saplingChance)
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(this.createWithoutShearsOrSilkTouchCondition())
                        .with(
                                ((LeafEntry.Builder)this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(item)))
                                        .conditionally(TableBonusLootCondition.builder(impl.getOrThrow(Enchantments.FORTUNE), 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))
                        )
                );
    }
}
