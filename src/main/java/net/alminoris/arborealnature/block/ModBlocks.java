package net.alminoris.arborealnature.block;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.world.tree.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks
{
    public static final Block HAZELNUT_LOG = registerBlock("hazelnut_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block STRIPPED_HAZELNUT_LOG = registerBlock("stripped_hazelnut_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final Block HAZELNUT_WOOD = registerBlock("hazelnut_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));

    public static final Block STRIPPED_HAZELNUT_WOOD = registerBlock("stripped_hazelnut_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block HAZELNUT_PLANKS = registerBlock("hazelnut_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block HAZELNUT_LEAVES = registerBlock("hazelnut_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    public static final Block HAZELNUT_SAPLING = registerBlock("hazelnut_sapling",
            new SaplingBlock(ModSaplingGenerators.HAZELNUT, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block HAZELNUT_SLAB = registerBlock("hazelnut_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block HAZELNUT_STAIRS = registerBlock("hazelnut_stairs",
            new StairsBlock(HAZELNUT_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));

    public static final Block HAZELNUT_FENCE = registerBlock("hazelnut_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)));

    public static final Block HAZELNUT_FENCE_GATE = registerBlock("hazelnut_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)));

    public static final Block HAZELNUT_DOOR = registerBlock("hazelnut_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR)));

    public static final Block HAZELNUT_TRAPDOOR = registerBlock("hazelnut_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR)));

    public static final Block HAZELNUT_BUTTON = registerBlock("hazelnut_button",
            new ButtonBlock(BlockSetType.OAK, 30, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)));

    public static final Block HAZELNUT_PRESSURE_PLATE = registerBlock("hazelnut_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)));

    public static final Identifier HAZELNUT_SIGN_TEXTURE = Identifier.of(ArborealNature.MOD_ID, "entity/signs/hazelnut");

    public static final Identifier HAZELNUT_HANGING_SIGN_TEXTURE = Identifier.of(ArborealNature.MOD_ID, "entity/signs/hanging/hazelnut");

    public static final Identifier HAZELNUT_HANGING_GUI_SIGN_TEXTURE = Identifier.of(ArborealNature.MOD_ID, "textures/gui/hanging_signs/hazelnut");

    public static final Block HAZELNUT_SIGN = registerBlock("hazelnut_sign",
            new TerraformSignBlock(HAZELNUT_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)));

    public static final Block HAZELNUT_WALL_SIGN = registerBlock("hazelnut_wall_sign",
            new TerraformWallSignBlock(HAZELNUT_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN).dropsLike(HAZELNUT_SIGN)));

    public static final Block HAZELNUT_HANGING_SIGN = registerBlock("hazelnut_hanging_sign",
            new TerraformHangingSignBlock(HAZELNUT_HANGING_SIGN_TEXTURE, HAZELNUT_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).noBlockBreakParticles()));

    public static final Block HAZELNUT_WALL_HANGING_SIGN = registerBlock("hazelnut_wall_hanging_sign",
            new TerraformWallHangingSignBlock(HAZELNUT_HANGING_SIGN_TEXTURE, HAZELNUT_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).noBlockBreakParticles().dropsLike(HAZELNUT_HANGING_SIGN)));

    public static final BlockFamily HAZELNUT_FAMILY = new BlockFamily.Builder(ModBlocks.HAZELNUT_PLANKS)
            .sign(ModBlocks.HAZELNUT_SIGN, ModBlocks.HAZELNUT_WALL_SIGN)
            .group("wooden")
            .unlockCriterionName("has_planks").build();

    public static final Block HAZELNUT_CHISELED = registerBlock("hazelnut_chiseled",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block HAZELNUT_CHISELED_SLAB = registerBlock("hazelnut_chiseled_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block HAZELNUT_CHISELED_STAIRS = registerBlock("hazelnut_chiseled_stairs",
            new StairsBlock(HAZELNUT_CHISELED.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));

    public static final Block OAK_CHISELED = registerBlock("oak_chiseled",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block OAK_CHISELED_SLAB = registerBlock("oak_chiseled_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block OAK_CHISELED_STAIRS = registerBlock("oak_chiseled_stairs",
            new StairsBlock(OAK_CHISELED.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));

    public static final Block BIRCH_CHISELED = registerBlock("birch_chiseled",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block BIRCH_CHISELED_SLAB = registerBlock("birch_chiseled_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block BIRCH_CHISELED_STAIRS = registerBlock("birch_chiseled_stairs",
            new StairsBlock(BIRCH_CHISELED.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));

    public static final Block SPRUCE_CHISELED = registerBlock("spruce_chiseled",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block SPRUCE_CHISELED_SLAB = registerBlock("spruce_chiseled_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block SPRUCE_CHISELED_STAIRS = registerBlock("spruce_chiseled_stairs",
            new StairsBlock(SPRUCE_CHISELED.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));

    public static final Block JUNGLE_CHISELED = registerBlock("jungle_chiseled",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block JUNGLE_CHISELED_SLAB = registerBlock("jungle_chiseled_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block JUNGLE_CHISELED_STAIRS = registerBlock("jungle_chiseled_stairs",
            new StairsBlock(JUNGLE_CHISELED.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));

    public static final Block ACACIA_CHISELED = registerBlock("acacia_chiseled",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block ACACIA_CHISELED_SLAB = registerBlock("acacia_chiseled_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block ACACIA_CHISELED_STAIRS = registerBlock("acacia_chiseled_stairs",
            new StairsBlock(ACACIA_CHISELED.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));

    public static final Block DARK_OAK_CHISELED = registerBlock("dark_oak_chiseled",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block DARK_OAK_CHISELED_SLAB = registerBlock("dark_oak_chiseled_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block DARK_OAK_CHISELED_STAIRS = registerBlock("dark_oak_chiseled_stairs",
            new StairsBlock(DARK_OAK_CHISELED.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));

    public static final Block CRIMSON_CHISELED = registerBlock("crimson_chiseled",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block CRIMSON_CHISELED_SLAB = registerBlock("crimson_chiseled_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block CRIMSON_CHISELED_STAIRS = registerBlock("crimson_chiseled_stairs",
            new StairsBlock(CRIMSON_CHISELED.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));

    public static final Block WARPED_CHISELED = registerBlock("warped_chiseled",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block WARPED_CHISELED_SLAB = registerBlock("warped_chiseled_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block WARPED_CHISELED_STAIRS = registerBlock("warped_chiseled_stairs",
            new StairsBlock(WARPED_CHISELED.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));

    public static final Block MANGROVE_CHISELED = registerBlock("mangrove_chiseled",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block MANGROVE_CHISELED_SLAB = registerBlock("mangrove_chiseled_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block MANGROVE_CHISELED_STAIRS = registerBlock("mangrove_chiseled_stairs",
            new StairsBlock(MANGROVE_CHISELED.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));

    public static final Block CHERRY_CHISELED = registerBlock("cherry_chiseled",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block CHERRY_CHISELED_SLAB = registerBlock("cherry_chiseled_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block CHERRY_CHISELED_STAIRS = registerBlock("cherry_chiseled_stairs",
            new StairsBlock(CHERRY_CHISELED.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));

    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ArborealNature.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block)
    {
        Registry.register(Registries.ITEM, Identifier.of(ArborealNature.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks()
    {

    }
}
