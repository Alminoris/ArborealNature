package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.block.custom.BerryBushBlock;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.util.helper.ModBlockSetsHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
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

        for (String name : WOOD_NAMES)
        {
            addDrop(LOGS.get(name));
            addDrop(STRIPPED_LOGS.get(name));
            addDrop(BURNT_LOGS.get(name));
            addDrop(WOODS.get(name));
            addDrop(STRIPPED_WOODS.get(name));
            addDrop(BURNT_WOODS.get(name));
            addDrop(WOODEN_PLANKS.get(name));
            addDrop(WOODEN_SLABS.get(name));
            addDrop(WOODEN_STAIRS.get(name));
            addDrop(WOODEN_CHISELED.get(name));
            addDrop(WOODEN_CHISELED_SLABS.get(name));
            addDrop(WOODEN_CHISELED_STAIRS.get(name));
            addDrop(WOODEN_FENCES.get(name));
            addDrop(WOODEN_FENCE_GATES.get(name));
            addDrop(WOODEN_TRAPDOORS.get(name));
            addDrop(WOODEN_BUTTONS.get(name));
            addDrop(WOODEN_PRESSURE_PLATES.get(name));
            addDrop(WOODEN_SIGNS.get(name), drops(ModBlockSetsHelper.WOODEN_WALL_SIGNS.get(name)));
            addDrop(WOODEN_HANGING_SIGNS.get(name), drops(ModBlockSetsHelper.WOODEN_WALL_HANGING_SIGNS.get(name)));
            addDrop(WOODEN_SAPLINGS.get(name));
        }

        for (String name : CLASSIC_WOOD_NAMES)
        {
            addDrop(BURNT_LOGS.get(name));
            addDrop(BURNT_WOODS.get(name));
        }

        for (String name : WF_WOOD_NAMES)
        {
            addDrop(WOODEN_CHISELED.get(name));
            addDrop(WOODEN_CHISELED_SLABS.get(name));
            addDrop(WOODEN_CHISELED_STAIRS.get(name));
            addDrop(BURNT_LOGS.get(name));
            addDrop(BURNT_WOODS.get(name));
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

        addDrop(LEAVES.get("hazelnut"), leavesItemDrops(LEAVES.get("hazelnut"),
                WOODEN_SAPLINGS.get("hazelnut"), ModItems.HAZELNUT, 0.0025f));

        addDrop(LEAVES.get("hornbeam"), leavesDrops(LEAVES.get("hornbeam"),
                WOODEN_SAPLINGS.get("hornbeam"), 0.0025f));

        addDrop(LEAVES.get("hawthorn"), leavesDrops(LEAVES.get("hawthorn"),
                WOODEN_SAPLINGS.get("hawthorn"), 0.0025f));

        addDrop(LEAVES.get("quince"), leavesItemDrops(LEAVES.get("quince"),
                WOODEN_SAPLINGS.get("quince"), ModItems.QUINCE, 0.0025f));

        addDrop(LEAVES.get("plum"), leavesItemDrops(LEAVES.get("plum"),
                WOODEN_SAPLINGS.get("plum"), ModItems.PLUM, 0.0025f));

        addDrop(LEAVES.get("mango"), leavesItemDrops(LEAVES.get("mango"),
                WOODEN_SAPLINGS.get("mango"), ModItems.MANGO, 0.0025f));

        addDrop(LEAVES.get("fig"), leavesItemDrops(LEAVES.get("fig"),
                WOODEN_SAPLINGS.get("fig"), ModItems.FIGS, 0.0025f));

        addDrop(LEAVES.get("viburnum"), leavesItemDrops(LEAVES.get("viburnum"),
                WOODEN_SAPLINGS.get("viburnum"), ModItems.VIBURNUM, 0.0025f));

        addDrop(LEAVES.get("wild_cherry"), leavesItemDrops(LEAVES.get("wild_cherry"),
                WOODEN_SAPLINGS.get("wild_cherry"), ModItems.WILD_CHERRY, 0.0025f));

        addDrop(LEAVES.get("white_mulberry"), leavesItemDrops(LEAVES.get("white_mulberry"),
                WOODEN_SAPLINGS.get("white_mulberry"), ModItems.WHITE_MULBERRY, 0.0025f));

        addDrop(LEAVES.get("bauhinia"), leavesDrops(LEAVES.get("bauhinia"),
                WOODEN_SAPLINGS.get("bauhinia"), 0.0025f));

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
        addDrop(ModBlocks.PINE_CONE_BLOCK);
        addDrop(ModBlocks.PINE_RESIN_BLOCK);
        addDrop(ModBlocks.PINE_RESIN_BRICKS);
        addDrop(ModBlocks.PINE_RESIN_BRICKS_SLAB);
        addDrop(ModBlocks.PINE_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.PINE_RESIN_CHISELED);

        addDrop(ModBlocks.WOOD_ANEMONA);
        addDrop(ModBlocks.BLUEBELL);
        addDrop(ModBlocks.WOOD_SORREL);
        addDrop(ModBlocks.REINDEER_LICHEN);
        addDrop(ModBlocks.ORCHID_LILY_PAD);
        addDrop(ModBlocks.HAZELNUT_COVER, dropsWithSilkTouch(ModBlocks.HAZELNUT_COVER));
        addDrop(ModBlocks.BAUHINIA_COVER, dropsWithSilkTouch(ModBlocks.BAUHINIA_COVER));
        addDrop(ModBlocks.BAUHINIA_COVER_BLOCK, dropsWithSilkTouch(ModBlocks.BAUHINIA_COVER_BLOCK));
        addDrop(ModBlocks.PINE_COVER, dropsWithSilkTouch(ModBlocks.PINE_COVER));
        addDrop(ModBlocks.PINE_COVER_BLOCK, dropsWithSilkTouch(ModBlocks.PINE_COVER_BLOCK));
        addDrop(ModBlocks.JUNIPER_COVER, dropsWithSilkTouch(ModBlocks.JUNIPER_COVER));
        addDrop(ModBlocks.JUNIPER_COVER_BLOCK, dropsWithSilkTouch(ModBlocks.JUNIPER_COVER_BLOCK));
        addDrop(ModBlocks.FLAT_GRASS, dropsWithSilkTouch(ModBlocks.FLAT_GRASS));
        addDrop(ModBlocks.FLAT_GRASS_BLOCK, dropsWithSilkTouch(ModBlocks.FLAT_GRASS_BLOCK));
        addDrop(ModBlocks.LYNX_HIDE, dropsWithSilkTouch(ModBlocks.LYNX_HIDE));
        addDrop(ModBlocks.BAUHINIA_VINES, dropsWithSilkTouch(ModBlocks.BAUHINIA_VINES));
        addDrop(ModBlocks.PINE_RESIN, dropsWithSilkTouch(ModBlocks.PINE_RESIN));
        addDrop(ModBlocks.HAZELNUT_COVER, multipleOreDrops(ModBlocks.HAZELNUT_COVER, ModItems.HAZELNUT, 0, 3));
        addDrop(ModBlocks.JUNIPER_COVER, multipleOreDrops(ModBlocks.JUNIPER_COVER, ModItems.JUNIPER_BERRY, 0, 3));
        addDrop(ModBlocks.PINE_COVER, multipleOreDrops(ModBlocks.PINE_COVER, ModItems.PINE_CONE, 0, 3));
        addDrop(LEAVES.get("pine"), leavesItemDrops(ModBlockSetsHelper.LEAVES.get("pine"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("pine"), ModItems.PINE_CONE, 0.0025f));
        addDrop(LEAVES.get("fir"), leavesItemDrops(ModBlockSetsHelper.LEAVES.get("fir"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("fir"), ModItems.FIR_CONE, 0.0025f));
        addDrop(LEAVES.get("cedar"), leavesItemDrops(ModBlockSetsHelper.LEAVES.get("cedar"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("cedar"), ModItems.CEDAR_CONE, 0.0025f));
        addDrop(LEAVES.get("araucaria"), leavesItemDrops(ModBlockSetsHelper.LEAVES.get("araucaria"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("araucaria"), ModItems.ARAUCARIA_CONE, 0.0025f));
        addDrop(LEAVES.get("juniper"), leavesItemDrops(ModBlockSetsHelper.LEAVES.get("juniper"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("juniper"), ModItems.JUNIPER_BERRY, 0.0025f));
        addDrop(ModBlocks.GERANIUM);
        addDrop(ModBlocks.XEROCHRYSUM);
        addDrop(ModBlocks.LARGE_CELANDINE, block -> this.dropsWithProperty(block, TallPlantBlock.HALF, DoubleBlockHalf.LOWER));
        addDrop(ModBlocks.BLUEGRASS, block -> this.dropsWithProperty(block, TallPlantBlock.HALF, DoubleBlockHalf.LOWER));
        addDrop(ModBlocks.LARGE_ORCHID, block -> this.dropsWithProperty(block, TallPlantBlock.HALF, DoubleBlockHalf.LOWER));
        addDrop(ModBlocks.ORCHID);
        addDrop(ModBlocks.ORCHID_GRASS_BLOCK);
        addDrop(ModBlocks.DIRTED_GRASS_BLOCK);
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
