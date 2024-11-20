package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.block.custom.BerryBushBlock;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.util.helper.ModBlockSetsHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

import static net.alminoris.arborealnature.util.helper.ModBlockSetsHelper.*;

public class ModLootTableProvider extends FabricBlockLootTableProvider
{
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup)
    {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate()
    {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        for (String name : ModBlockSetsHelper.WOOD_NAMES)
        {
            addDrop(ModBlockSetsHelper.LOGS.get(name));
            addDrop(ModBlockSetsHelper.STRIPPED_LOGS.get(name));
            addDrop(ModBlockSetsHelper.WOODS.get(name));
            addDrop(ModBlockSetsHelper.STRIPPED_WOODS.get(name));
            addDrop(ModBlockSetsHelper.WOODEN_PLANKS.get(name));
            addDrop(ModBlockSetsHelper.WOODEN_SLABS.get(name));
            addDrop(ModBlockSetsHelper.WOODEN_STAIRS.get(name));
            addDrop(ModBlockSetsHelper.WOODEN_CHISELED.get(name));
            addDrop(ModBlockSetsHelper.WOODEN_CHISELED_SLABS.get(name));
            addDrop(ModBlockSetsHelper.WOODEN_CHISELED_STAIRS.get(name));
            addDrop(ModBlockSetsHelper.WOODEN_FENCES.get(name));
            addDrop(ModBlockSetsHelper.WOODEN_FENCE_GATES.get(name));
            addDrop(ModBlockSetsHelper.WOODEN_TRAPDOORS.get(name));
            addDrop(ModBlockSetsHelper.WOODEN_BUTTONS.get(name));
            addDrop(ModBlockSetsHelper.WOODEN_PRESSURE_PLATES.get(name));
            addDrop(ModBlockSetsHelper.WOODEN_SIGNS.get(name), drops(ModBlockSetsHelper.WOODEN_WALL_SIGNS.get(name)));
            addDrop(ModBlockSetsHelper.WOODEN_HANGING_SIGNS.get(name), drops(ModBlockSetsHelper.WOODEN_WALL_HANGING_SIGNS.get(name)));
            addDrop(ModBlockSetsHelper.WOODEN_SAPLINGS.get(name));
        }

        for (String name : BUSHES_NAMES)
        {
            addDrop(
                    BUSHES.get(name),
                    block -> this.applyExplosionDecay(block, LootTable.builder()
                                    .pool(LootPool.builder()
                                                    .conditionally(BlockStatePropertyLootCondition.builder(BUSHES.get(name))
                                                            .properties(StatePredicate.Builder.create().exactMatch(BerryBushBlock.AGE, 3)))
                                                    .with(ItemEntry.builder(BERRIES.get(name)))
                                                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                                    .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))
                                    .pool(LootPool.builder()
                                                    .conditionally(BlockStatePropertyLootCondition.builder(BUSHES.get(name))
                                                            .properties(StatePredicate.Builder.create().exactMatch(BerryBushBlock.AGE, 2)))
                                                    .with(ItemEntry.builder(BERRIES.get(name)))
                                                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                                    .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));
        }

        addDrop(ModBlockSetsHelper.LEAVES.get("hazelnut"), leavesItemDrops(ModBlockSetsHelper.LEAVES.get("hazelnut"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("hazelnut"), ModItems.HAZELNUT, 0.0025f));

        addDrop(ModBlockSetsHelper.LEAVES.get("hornbeam"), leavesDrops(ModBlockSetsHelper.LEAVES.get("hornbeam"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("hornbeam"), 0.0025f));

        addDrop(ModBlockSetsHelper.LEAVES.get("hawthorn"), leavesDrops(ModBlockSetsHelper.LEAVES.get("hawthorn"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("hawthorn"), 0.0025f));

        addDrop(ModBlockSetsHelper.LEAVES.get("quince"), leavesItemDrops(ModBlockSetsHelper.LEAVES.get("quince"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("quince"), ModItems.QUINCE, 0.0025f));

        addDrop(ModBlockSetsHelper.LEAVES.get("plum"), leavesItemDrops(ModBlockSetsHelper.LEAVES.get("plum"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("plum"), ModItems.PLUM, 0.0025f));

        addDrop(ModBlockSetsHelper.LEAVES.get("mango"), leavesItemDrops(ModBlockSetsHelper.LEAVES.get("mango"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("mango"), ModItems.MANGO, 0.0025f));

        addDrop(ModBlockSetsHelper.LEAVES.get("fig"), leavesItemDrops(ModBlockSetsHelper.LEAVES.get("fig"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("fig"), ModItems.FIGS, 0.0025f));

        addDrop(ModBlockSetsHelper.LEAVES.get("viburnum"), leavesItemDrops(ModBlockSetsHelper.LEAVES.get("viburnum"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("viburnum"), ModItems.VIBURNUM, 0.0025f));

        addDrop(ModBlockSetsHelper.LEAVES.get("wild_cherry"), leavesItemDrops(ModBlockSetsHelper.LEAVES.get("wild_cherry"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("wild_cherry"), ModItems.WILD_CHERRY, 0.0025f));

        addDrop(ModBlockSetsHelper.LEAVES.get("white_mulberry"), leavesItemDrops(ModBlockSetsHelper.LEAVES.get("white_mulberry"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("white_mulberry"), ModItems.WHITE_MULBERRY, 0.0025f));

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
        addDrop(ModBlocks.BLUEGRASS);
        addDrop(ModBlocks.GERANIUM);
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
                                        .conditionally(TableBonusLootCondition.builder(impl.getOrThrow(Enchantments.FORTUNE), 0.00625F, 0.008333334F, 0.025F, 0.05F, 0.06F))
                        )
                );
    }
}
