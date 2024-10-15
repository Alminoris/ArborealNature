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
            new TerraformHangingSignBlock(HAZELNUT_HANGING_SIGN_TEXTURE, HAZELNUT_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)));

    public static final Block HAZELNUT_WALL_HANGING_SIGN = registerBlock("hazelnut_wall_hanging_sign",
            new TerraformWallHangingSignBlock(HAZELNUT_HANGING_SIGN_TEXTURE, HAZELNUT_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).dropsLike(HAZELNUT_HANGING_SIGN)));

    public static final BlockFamily HAZELNUT_FAMILY = new BlockFamily.Builder(ModBlocks.HAZELNUT_PLANKS)
            .sign(ModBlocks.HAZELNUT_SIGN, ModBlocks.HAZELNUT_WALL_SIGN)
            .group("wooden")
            .unlockCriterionName("has_planks").build();

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
