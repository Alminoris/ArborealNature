package net.alminoris.arborealnature.block;

import com.mojang.serialization.MapCodec;
import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.block.custom.AnimalHideBlock;
import net.alminoris.arborealnature.block.custom.FallingLeavesBlock;
import net.alminoris.arborealnature.block.custom.BerryBushBlock;
import net.alminoris.arborealnature.block.custom.CustomVineBlock;
import net.alminoris.arborealnature.particle.ModParticles;
import net.alminoris.arborealnature.world.ModConfiguredFeatures;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks
{
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

    public static final Block PINE_CONE_BLOCK = registerBlock("pine_cone_block",
            new FallingBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_ROOTS).nonOpaque()) {
                @Override
                protected MapCodec<? extends FallingBlock> getCodec() {
                    return null;
                }
            });

    public static final Block FIR_CONE_BLOCK = registerBlock("fir_cone_block",
            new FallingBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_ROOTS).nonOpaque()) {
                @Override
                protected MapCodec<? extends FallingBlock> getCodec() {
                    return null;
                }
            });

    public static final Block CEDAR_CONE_BLOCK = registerBlock("cedar_cone_block",
            new FallingBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_ROOTS).nonOpaque()) {
                @Override
                protected MapCodec<? extends FallingBlock> getCodec() {
                    return null;
                }
            });

    public static final Block PINE_RESIN_BLOCK = registerBlock("pine_resin_block",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).nonOpaque().sounds(BlockSoundGroup.CORAL)));

    public static final Block PINE_RESIN_BRICKS = registerBlock("pine_resin_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).nonOpaque().sounds(BlockSoundGroup.CORAL)));

    public static final Block PINE_RESIN_CHISELED = registerBlock("pine_resin_chiseled",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).nonOpaque().sounds(BlockSoundGroup.CORAL)));

    public static final Block PINE_RESIN_BRICKS_SLAB = registerBlock("pine_resin_bricks_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB).nonOpaque().sounds(BlockSoundGroup.CORAL)));

    public static final Block PINE_RESIN_BRICKS_STAIRS = registerBlock("pine_resin_bricks_stairs",
            new StairsBlock(PINE_RESIN_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).nonOpaque().sounds(BlockSoundGroup.CORAL)));

    public static final Block WOOD_ANEMONA = registerBlock("wood_anemona",
            new FlowerbedBlock(AbstractBlock.Settings.copy(Blocks.PINK_PETALS)));

    public static final Block LARGE_CELANDINE = registerBlock("large_celandine",
            new TallFlowerBlock(AbstractBlock.Settings.copy(Blocks.PEONY)));

    public static final Block BLUEGRASS = registerBlock("bluegrass",
            new TallFlowerBlock(AbstractBlock.Settings.copy(Blocks.PEONY)));

    public static final Block GERANIUM = registerBlock("geranium",
            new FlowerBlock(StatusEffects.HASTE, 0.35F, AbstractBlock.Settings.copy(Blocks.PEONY)));

    public static final Block XEROCHRYSUM = registerBlock("xerochrysum",
            new FlowerBlock(StatusEffects.REGENERATION, 0.45F, AbstractBlock.Settings.copy(Blocks.DANDELION)));

    public static final Block LARGE_ORCHID = registerBlock("large_orchid",
            new TallFlowerBlock(AbstractBlock.Settings.copy(Blocks.PEONY)));

    public static final Block ORCHID = registerBlock("orchid",
            new FlowerBlock(StatusEffects.NAUSEA, 0.35F, AbstractBlock.Settings.copy(Blocks.PEONY)));

    public static final Block BLUEBELL = registerBlock("bluebell",
            new FlowerBlock(StatusEffects.RESISTANCE, 0.35F, AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));

    public static final Block WOOD_SORREL = registerBlock("wood_sorrel",
            new FlowerbedBlock(AbstractBlock.Settings.copy(Blocks.PINK_PETALS)));

    public static final Block REINDEER_LICHEN = registerBlock("reindeer_lichen",
            new MossBlock(AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK).nonOpaque()));

    public static final Block REINDEER_LICHEN_CARPET = registerBlock("reindeer_lichen_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.MOSS_CARPET).nonOpaque()));

    public static final Block ORCHID_GRASS_BLOCK = registerBlock("orchid_grass_block",
            new GrassBlock(AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK)));

    public static final Block DIRTED_GRASS_BLOCK = registerBlock("dirted_grass_block",
            new GrassBlock(AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK)));

    public static final Block HAZELNUT_COVER = registerBlock("hazelnut_cover_block",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).noCollision()));

    public static final Block WHITE_MUSHROOM = registerBlock("white_mushroom",
            new MushroomPlantBlock(ModConfiguredFeatures.HUGE_WHITE_MUSHROOM_KEY, AbstractBlock.Settings.copy(Blocks.BROWN_MUSHROOM)));

    public static final Block POTTED_WHITE_MUSHROOM = registerBlock("potted_white_mushroom",
            new FlowerPotBlock(WHITE_MUSHROOM, AbstractBlock.Settings.copy(Blocks.POTTED_BROWN_MUSHROOM)));

    public static final Block POTTED_GERANIUM = registerBlock("potted_geranium",
            new FlowerPotBlock(GERANIUM, AbstractBlock.Settings.copy(Blocks.POTTED_DANDELION)));

    public static final Block POTTED_XEROCHRYSUM = registerBlock("potted_xerochrysum",
            new FlowerPotBlock(XEROCHRYSUM, AbstractBlock.Settings.copy(Blocks.POTTED_DANDELION)));

    public static final Block POTTED_BLUEBELL = registerBlock("potted_bluebell",
            new FlowerPotBlock(BLUEBELL, AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));

    public static final Block POTTED_ORCHID = registerBlock("potted_orchid",
            new FlowerPotBlock(ORCHID, AbstractBlock.Settings.copy(Blocks.POTTED_DANDELION)));

    public static final Block WHITE_MUSHROOM_BLOCK = registerBlock("white_mushroom_block",
            new MushroomBlock(AbstractBlock.Settings.copy(Blocks.BROWN_MUSHROOM_BLOCK)));

    public static final Block WHITE_MUSHROOM_STEM = registerBlock("white_mushroom_stem",
            new MushroomBlock(AbstractBlock.Settings.copy(Blocks.MUSHROOM_STEM)));

    public static final Block BAUHINIA_VINES = registerBlock("bauhinia_vines",
            new VineBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.MAGENTA)
                    .replaceable()
                    .noCollision()
                    .ticksRandomly()
                    .strength(0.2F)
                    .sounds(BlockSoundGroup.VINE)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block PINE_RESIN = registerBlock("pine_resin",
            new CustomVineBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.YELLOW)
                    .replaceable()
                    .noCollision()
                    .strength(0.2F)
                    .sounds(BlockSoundGroup.CORAL)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block BAUHINIA_COVER_BLOCK = registerBlock("bauhinia_cover_block",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.PINK_PETALS)));

    public static final Block BAUHINIA_COVER = registerBlock("bauhinia_cover",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.PINK_PETALS)));

    public static final Block PINE_COVER_BLOCK = registerBlock("pine_cover_block",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).noCollision()));

    public static final Block PINE_COVER = registerBlock("pine_cover",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).noCollision()));

    public static final Block ORCHID_LILY_PAD = registerBlock("orchid_lily_pad",
            new LilyPadBlock(AbstractBlock.Settings.copy(Blocks.LILY_PAD)));

    public static final Block LYNX_HIDE = registerBlock("lynx_hide",
            new AnimalHideBlock(AbstractBlock.Settings.copy(Blocks.BROWN_WOOL)));

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

    public static Block registerBushBlock(String name)
    {
        return registerBlock(name, new BerryBushBlock(name));
    }

    public static Block registerLeavesBlock(String name)
    {
        return switch (name)
        {
            case "bauhinia" -> registerBlock(name + "_leaves",
                    new FallingLeavesBlock(AbstractBlock.Settings.create()
                            .mapColor(MapColor.MAGENTA)
                            .strength(0.2F)
                            .ticksRandomly()
                            .sounds(BlockSoundGroup.CHERRY_LEAVES)
                            .nonOpaque()
                            .allowsSpawning(Blocks::canSpawnOnLeaves)
                            .suffocates(Blocks::never)
                            .blockVision(Blocks::never)
                            .burnable()
                            .pistonBehavior(PistonBehavior.DESTROY)
                            .solidBlock(Blocks::never), ModParticles.BAUHINIA_PETALS, 10));
            case "pine" -> registerBlock(name + "_leaves",
                    new FallingLeavesBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LEAVES), ModParticles.PINE_NEEDLES, 60));
            case "fir" -> registerBlock(name + "_leaves",
                    new FallingLeavesBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LEAVES), ModParticles.FIR_NEEDLES, 100));
            case "cedar" -> registerBlock(name + "_leaves",
                    new FallingLeavesBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LEAVES), ModParticles.CEDAR_NEEDLES, 100));
            case "hazelnut" -> registerBlock(name + "_leaves",
                    new FallingLeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES), ModParticles.HAZELNUT_LEAVES, 30));
            case "hornbeam" -> registerBlock(name + "_leaves",
                    new FallingLeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES), ModParticles.HORNBEAM_LEAVES, 35));
            case "hawthorn" -> registerBlock(name + "_leaves",
                    new FallingLeavesBlock(AbstractBlock.Settings.create()
                            .mapColor(MapColor.WHITE)
                            .strength(0.2F)
                            .ticksRandomly()
                            .sounds(BlockSoundGroup.CHERRY_LEAVES)
                            .nonOpaque()
                            .allowsSpawning(Blocks::canSpawnOnLeaves)
                            .suffocates(Blocks::never)
                            .blockVision(Blocks::never)
                            .burnable()
                            .pistonBehavior(PistonBehavior.DESTROY)
                            .solidBlock(Blocks::never), ModParticles.HAWTHORN_PETALS, 15));
            case "fig" -> registerBlock(name + "_leaves",
                    new FallingLeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES), ModParticles.FIG_LEAVES, 45));
            default -> registerBlock(name + "_leaves",
                    new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));
        };
    }

    public static Block registerLogsBlock(String name)
    {
        return registerBlock(name+"_log",
                new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    }

    public static Block registerWoodsBlock(String name)
    {
        return registerBlock(name+"_wood",
                new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));
    }

    public static Block registerStrippedLogsBlock(String name)
    {
        return registerBlock("stripped_"+name+"_log",
                new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));
    }

    public static Block registerStrippedWoodsBlock(String name)
    {
        return registerBlock("stripped_"+name+"_wood",
                new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));
    }

    public static Block registerBurntLogsBlock(String name)
    {
        return registerBlock("burnt_"+name+"_log",
                new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));
    }

    public static Block registerBurntWoodsBlock(String name)
    {
        return registerBlock("burnt_"+name+"_wood",
                new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));
    }

    public static Block registerPlanksBlock(String name)
    {
        return registerBlock(name+"_planks",
                new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    }

    public static Block registerSlabBlock(String name)
    {
        return registerBlock(name+"_slab",
                new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));
    }

    public static Block registerStairsBlock(String name, Block planks)
    {
        return registerBlock(name+"_stairs",
                new StairsBlock(planks.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));
    }

    public static Block registerChiseledBlock(String name)
    {
        return registerBlock(name+"_chiseled",
                new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    }

    public static Block registerChiseledSlabBlock(String name)
    {
        return registerBlock(name+"_chiseled_slab",
                new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));
    }

    public static Block registerChiseledStairsBlock(String name, Block planks)
    {
        return registerBlock(name+"_chiseled_stairs",
                new StairsBlock(planks.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));
    }

    public static Block registerFenceBlock(String name)
    {
        return registerBlock(name+"_fence",
                new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)));
    }

    public static Block registerFenceGateBlock(String name)
    {
        return registerBlock(name+"_fence_gate",
                new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)));
    }

    public static Block registerDoorBlock(String name)
    {
        return registerBlock(name+"_door",
                new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR)));
    }

    public static Block registerTrapdoorBlock(String name)
    {
        return registerBlock(name+"_trapdoor",
                new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR)));
    }

    public static Block registerButtonBlock(String name)
    {
        return registerBlock(name+"_button",
                new ButtonBlock(BlockSetType.OAK, 30, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)));
    }

    public static Block registerPressurePlateBlock(String name)
    {
        return registerBlock(name+"_pressure_plate",
                new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)));
    }

    public static Block registerSaplingBlock(String name, SaplingGenerator saplingGenerator)
    {
        return registerBlock(name+"_sapling",
                new SaplingBlock(saplingGenerator, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));
    }

    public static Block registerSignBlock(String name)
    {
        return registerBlock(name+"_sign",
                new TerraformSignBlock(Identifier.of(ArborealNature.MOD_ID, "entity/signs/"+name), AbstractBlock.Settings.copy(Blocks.OAK_SIGN)));
    }

    public static Block registerWallSignBlock(String name)
    {
        return registerBlock(name+"_wall_sign",
                new TerraformWallSignBlock(Identifier.of(ArborealNature.MOD_ID, "entity/signs/"+name), AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)));
    }

    public static Block registerHangingSignBlock(String name)
    {
        return registerBlock(name+"_hanging_sign",
                new TerraformHangingSignBlock(Identifier.of(ArborealNature.MOD_ID, "entity/signs/hanging/"+name),
                        Identifier.of(ArborealNature.MOD_ID, "textures/gui/hanging_signs/"+name), AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)));
    }

    public static Block registerWallHangingSignBlock(String name)
    {
        return registerBlock(name+"_wall_hanging_sign",
                new TerraformWallHangingSignBlock(Identifier.of(ArborealNature.MOD_ID, "entity/signs/hanging/"+name),
                        Identifier.of(ArborealNature.MOD_ID, "textures/gui/hanging_signs/"+name), AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN)));
    }

    public static BlockFamily registerBlockFamily(Block planks, Block sign, Block wallSign)
    {
        return new BlockFamily.Builder(planks)
                .sign(sign, wallSign)
                .group("wooden")
                .unlockCriterionName("has_planks").build();
    }
}
