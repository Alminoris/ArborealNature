package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.block.custom.BerryBushBlock;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.util.helper.ModBlockSetsHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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

        for (String name : ST_WOOD_NAMES)
        {
            addDrop(WOODEN_CHISELED.get(name));
            addDrop(WOODEN_CHISELED_SLABS.get(name));
            addDrop(WOODEN_CHISELED_STAIRS.get(name));
            addDrop(BURNT_LOGS.get(name));
            addDrop(BURNT_WOODS.get(name));
        }

        for (String name : WT_WOOD_NAMES)
        {
            addDrop(WOODEN_CHISELED.get(name));
            addDrop(WOODEN_CHISELED_SLABS.get(name));
            addDrop(WOODEN_CHISELED_STAIRS.get(name));
            addDrop(BURNT_LOGS.get(name));
            addDrop(BURNT_WOODS.get(name));
        }

        for (String name : MT_WOOD_NAMES)
        {
            addDrop(WOODEN_CHISELED.get(name));
            addDrop(WOODEN_CHISELED_SLABS.get(name));
            addDrop(WOODEN_CHISELED_STAIRS.get(name));
            addDrop(BURNT_LOGS.get(name));
            addDrop(BURNT_WOODS.get(name));
        }

        for (String name : NSS_WOOD_NAMES)
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

        Set<String> excluded = new HashSet<>(Arrays.asList("hazelnut", "fig", "pine", "fir", "cedar", "araucaria",
                "bald_cypress", "thuja", "mountain_hemlock", "sequoia", "cryptomeria"));
        for (String name : WOOD_NAMES)
            if (!excluded.contains(name))
                addDrop(LEAVES.get(name), leavesDrops(LEAVES.get(name), WOODEN_SAPLINGS.get(name), 0.0025f));

        addDrop(LEAVES.get("hazelnut"), leavesItemDrops(LEAVES.get("hazelnut"),
                WOODEN_SAPLINGS.get("hazelnut"), ModItems.HAZELNUT, 0.0025f));
        addDrop(LEAVES.get("fig"), leavesItemDrops(LEAVES.get("fig"),
                WOODEN_SAPLINGS.get("fig"), ModItems.FIGS, 0.0025f));
        addDrop(FRUITED_LEAVES.get("quince"), leavesItemDrops(FRUITED_LEAVES.get("quince"),
                WOODEN_SAPLINGS.get("quince"), ModItems.QUINCE, 0.0025f));
        addDrop(FRUITED_LEAVES.get("plum"), leavesItemDrops(FRUITED_LEAVES.get("plum"),
                WOODEN_SAPLINGS.get("plum"), ModItems.PLUM, 0.0025f));
        addDrop(FRUITED_LEAVES.get("mango"), leavesItemDrops(FRUITED_LEAVES.get("mango"),
                WOODEN_SAPLINGS.get("mango"), ModItems.MANGO, 0.0025f));
        addDrop(FRUITED_LEAVES.get("viburnum"), leavesItemDrops(FRUITED_LEAVES.get("viburnum"),
                WOODEN_SAPLINGS.get("viburnum"), ModItems.VIBURNUM, 0.0025f));
        addDrop(FRUITED_LEAVES.get("wild_cherry"), leavesItemDrops(FRUITED_LEAVES.get("wild_cherry"),
                WOODEN_SAPLINGS.get("wild_cherry"), ModItems.WILD_CHERRY, 0.0025f));
        addDrop(FRUITED_LEAVES.get("white_mulberry"), leavesItemDrops(FRUITED_LEAVES.get("white_mulberry"),
                WOODEN_SAPLINGS.get("white_mulberry"), ModItems.WHITE_MULBERRY, 0.0025f));
        addDrop(FRUITED_LEAVES.get("bauhinia"), leavesDrops(FRUITED_LEAVES.get("bauhinia"),
                WOODEN_SAPLINGS.get("bauhinia"), 0.0025f));
        addDrop(FRUITED_LEAVES.get("hawthorn"), leavesDrops(FRUITED_LEAVES.get("hawthorn"),
                WOODEN_SAPLINGS.get("hawthorn"), 0.0025f));

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
        addDrop(ModBlocks.PINE_RESIN_BLOCK);
        addDrop(ModBlocks.PINE_RESIN_BRICKS);
        addDrop(ModBlocks.PINE_RESIN_BRICKS_SLAB);
        addDrop(ModBlocks.PINE_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.PINE_RESIN_CHISELED);
        addDrop(ModBlocks.CRYPTOMERIA_RESIN_BLOCK);
        addDrop(ModBlocks.CRYPTOMERIA_RESIN_BRICKS);
        addDrop(ModBlocks.CRYPTOMERIA_RESIN_BRICKS_SLAB);
        addDrop(ModBlocks.CRYPTOMERIA_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.CRYPTOMERIA_RESIN_CHISELED);

        addDrop(ModBlocks.WOOD_ANEMONA);
        addDrop(ModBlocks.MARSH_MOSS);
        addDrop(ModBlocks.WOOD_SORREL);
        addDrop(ModBlocks.ALPINE_GENTIAN);
        addDrop(ModBlocks.REINDEER_LICHEN);
        addDrop(ModBlocks.ORCHID_LILY_PAD);
        addDrop(ModBlocks.WHITE_LILY_PAD);
        addDrop(ModBlocks.SPANISH_MOSS);
        for (String name : COVER_NAMES)
        {
            addDrop(COVERS.get(name), dropsWithSilkTouch(COVERS.get(name)));
            addDrop(COVER_BLOCKS.get(name), dropsWithSilkTouch(COVER_BLOCKS.get(name)));
        }

        addDrop(ModBlocks.MARSH_MOSS_PLANT, dropsWithSilkTouch(ModBlocks.MARSH_MOSS_PLANT));
        addDrop(ModBlocks.MARSH_MOSS_PLANT_BLOCK, dropsWithSilkTouch(ModBlocks.MARSH_MOSS_PLANT_BLOCK));
        addDrop(ModBlocks.FLAT_GRASS, dropsWithSilkTouch(ModBlocks.FLAT_GRASS));
        addDrop(ModBlocks.FLAT_GRASS_BLOCK, dropsWithSilkTouch(ModBlocks.FLAT_GRASS_BLOCK));
        addDrop(ModBlocks.LYNX_HIDE, dropsWithSilkTouch(ModBlocks.LYNX_HIDE));
        addDrop(ModBlocks.BAUHINIA_VINES, dropsWithSilkTouch(ModBlocks.BAUHINIA_VINES));
        addDrop(ModBlocks.PINE_RESIN, dropsWithSilkTouch(ModBlocks.PINE_RESIN));
        addDrop(ModBlocks.CRYPTOMERIA_RESIN, dropsWithSilkTouch(ModBlocks.CRYPTOMERIA_RESIN));
        addDrop(COVERS.get("hazelnut"), multipleOreDrops(COVERS.get("hazelnut"), ModItems.HAZELNUT, 0, 3));
        addDrop(COVERS.get("juniper"), multipleOreDrops(COVERS.get("juniper"), ModItems.JUNIPER_BERRY, 0, 3));
        addDrop(COVERS.get("yew"), multipleOreDrops(COVERS.get("yew"), ModItems.YEW_BERRY, 0, 3));
        for (String name : CONIFER_CONES_NAMES)
        {
            addDrop(CONE_BLOCKS.get(name));
            addDrop(COVERS.get(name), multipleOreDrops(COVERS.get(name), CONES.get(name), 0, 2));
        }

        for (String name : CONIFER_CONES_NAMES)
        {
            addDrop(LEAVES.get(name), leavesItemDrops(LEAVES.get(name),
                    WOODEN_SAPLINGS.get(name), CONES.get(name), 0.0025f));
        }

        addDrop(FRUITED_LEAVES.get("juniper"), leavesItemDrops(ModBlockSetsHelper.FRUITED_LEAVES.get("juniper"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("juniper"), ModItems.JUNIPER_BERRY, 0.0025f));
        addDrop(FRUITED_LEAVES.get("yew"), leavesItemDrops(ModBlockSetsHelper.FRUITED_LEAVES.get("yew"),
                ModBlockSetsHelper.WOODEN_SAPLINGS.get("yew"), ModItems.YEW_BERRY, 0.0025f));

        for (String name : FLOWER_NAMES)
            addDrop(FLOWERS.get(name));

        for (String name : TALL_FLOWER_NAMES)
            addDrop(TALL_FLOWERS.get(name), block -> this.dropsWithProperty(block, TallPlantBlock.HALF, DoubleBlockHalf.LOWER));

        addDrop(ModBlocks.SEDGE, block -> this.dropsWithProperty(block, TallPlantBlock.HALF, DoubleBlockHalf.LOWER));
        addDrop(ModBlocks.ORCHID_GRASS_BLOCK);
        addDrop(ModBlocks.DIRTED_GRASS_BLOCK);
        addDrop(ModBlocks.BOG_SOIL_COVER);
        addDrop(ModBlocks.BOG_SOIL);
        addDrop(ModBlocks.WHITE_MUSHROOM);
        addDrop(ModBlocks.WHITE_MUSHROOM_BLOCK);
        addDrop(ModBlocks.WHITE_MUSHROOM_STEM);
        addDrop(ModBlocks.GOLDEN_CHANTRELLE);
        addDrop(ModBlocks.GOLDEN_CHANTRELLE_BLOCK);
        addDrop(ModBlocks.GOLDEN_CHANTRELLE_STEM);
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