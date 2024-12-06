package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.function.Function;

import static net.alminoris.arborealnature.util.helper.ModBlockSetsHelper.*;
import static net.minecraft.data.client.BlockStateModelGenerator.createBlockStateWithRandomHorizontalRotations;
import static net.minecraft.data.client.BlockStateModelGenerator.createSingletonBlockState;

public class ModModelProvider extends FabricModelProvider
{
    public ModModelProvider(FabricDataOutput output)
    {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator)
    {
        Dictionary<String, BlockStateModelGenerator.BlockTexturePool> woodenPlanksPool = new Hashtable<>()
        {{
            for(String name : WOOD_NAMES)
                put(name, blockStateModelGenerator.registerCubeAllModelTexturePool(WOODEN_PLANKS.get(name)));
        }};

        Dictionary<String, BlockStateModelGenerator.BlockTexturePool> woodenChiseledPool = new Hashtable<>()
        {{
            for(String name : WOOD_NAMES)
                put(name, blockStateModelGenerator.registerCubeAllModelTexturePool(WOODEN_CHISELED.get(name)));
        }};

        for(String name : WOOD_NAMES)
        {
            woodenPlanksPool.get(name).slab(WOODEN_SLABS.get(name));
            woodenPlanksPool.get(name).stairs(WOODEN_STAIRS.get(name));

            woodenChiseledPool.get(name).slab(WOODEN_CHISELED_SLABS.get(name));
            woodenChiseledPool.get(name).stairs(WOODEN_CHISELED_STAIRS.get(name));

            registerLogBlock(blockStateModelGenerator, LOGS.get(name),
                    Identifier.of(ArborealNature.MOD_ID, "block/"+name+"_log_top"),
                    Identifier.of(ArborealNature.MOD_ID, "block/"+name+"_log"));

            registerLogBlock(blockStateModelGenerator, STRIPPED_LOGS.get(name),
                    Identifier.of(ArborealNature.MOD_ID, "block/stripped_"+name+"_log_top"),
                    Identifier.of(ArborealNature.MOD_ID, "block/stripped_"+name+"_log"));

            registerLogBlock(blockStateModelGenerator, BURNT_LOGS.get(name),
                    Identifier.of(ArborealNature.MOD_ID, "block/burnt_"+name+"_log_top"),
                    Identifier.of(ArborealNature.MOD_ID, "block/burnt_"+name+"_log"));

            registerLogBlock(blockStateModelGenerator, WOODS.get(name),
                    Identifier.of(ArborealNature.MOD_ID, "block/"+name+"_log"),
                    Identifier.of(ArborealNature.MOD_ID, "block/"+name+"_log"));

            registerLogBlock(blockStateModelGenerator, STRIPPED_WOODS.get(name),
                    Identifier.of(ArborealNature.MOD_ID, "block/stripped_"+name+"_log"),
                    Identifier.of(ArborealNature.MOD_ID, "block/stripped_"+name+"_log"));

            registerLogBlock(blockStateModelGenerator, BURNT_WOODS.get(name),
                    Identifier.of(ArborealNature.MOD_ID, "block/burnt_"+name+"_log"),
                    Identifier.of(ArborealNature.MOD_ID, "block/burnt_"+name+"_log"));

            blockStateModelGenerator.registerSingleton(LEAVES.get(name), TexturedModel.LEAVES);
            blockStateModelGenerator.registerTintableCross(WOODEN_SAPLINGS.get(name), BlockStateModelGenerator.TintType.NOT_TINTED);

            blockStateModelGenerator.registerDoor(WOODEN_DOORS.get(name));

            blockStateModelGenerator.registerOrientableTrapdoor(WOODEN_TRAPDOORS.get(name));

            woodenPlanksPool.get(name).fence(WOODEN_FENCES.get(name));
            woodenPlanksPool.get(name).fenceGate(WOODEN_FENCE_GATES.get(name));
            woodenPlanksPool.get(name).button(WOODEN_BUTTONS.get(name));
            woodenPlanksPool.get(name).pressurePlate(WOODEN_PRESSURE_PLATES.get(name));

            woodenPlanksPool.get(name).family(WOODEN_BLOCK_FAMILIES.get(name));
            registerHangingSign(blockStateModelGenerator, STRIPPED_LOGS.get(name), WOODEN_HANGING_SIGNS.get(name), WOODEN_WALL_HANGING_SIGNS.get(name));
        }

        for (String name : CLASSIC_WOOD_NAMES)
        {
            registerLogBlock(blockStateModelGenerator, BURNT_LOGS.get(name),
                    Identifier.of(ArborealNature.MOD_ID, "block/burnt_"+name+"_log_top"),
                    Identifier.of(ArborealNature.MOD_ID, "block/burnt_"+name+"_log"));
            registerLogBlock(blockStateModelGenerator, BURNT_WOODS.get(name),
                    Identifier.of(ArborealNature.MOD_ID, "block/burnt_"+name+"_log"),
                    Identifier.of(ArborealNature.MOD_ID, "block/burnt_"+name+"_log"));
        }

        for (String name : BUSHES_NAMES)
        {
            blockStateModelGenerator.registerTintableCrossBlockStateWithStages(BUSHES.get(name),
                    BlockStateModelGenerator.TintType.NOT_TINTED, Properties.AGE_3, 0, 1, 2, 3);
        }
        
        BlockStateModelGenerator.BlockTexturePool oakChiseledPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OAK_CHISELED);
        BlockStateModelGenerator.BlockTexturePool birchChiseledPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BIRCH_CHISELED);
        BlockStateModelGenerator.BlockTexturePool spruceChiseledPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SPRUCE_CHISELED);
        BlockStateModelGenerator.BlockTexturePool jungleChiseledPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JUNGLE_CHISELED);
        BlockStateModelGenerator.BlockTexturePool acaciaChiseledPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ACACIA_CHISELED);
        BlockStateModelGenerator.BlockTexturePool darkOakChiseledPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DARK_OAK_CHISELED);
        BlockStateModelGenerator.BlockTexturePool crimsonChiseledPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRIMSON_CHISELED);
        BlockStateModelGenerator.BlockTexturePool warpedChiseledPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.WARPED_CHISELED);
        BlockStateModelGenerator.BlockTexturePool mangroveChiseledPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MANGROVE_CHISELED);
        BlockStateModelGenerator.BlockTexturePool cherryChiseledPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHERRY_CHISELED);

        oakChiseledPool.slab(ModBlocks.OAK_CHISELED_SLAB);
        oakChiseledPool.stairs(ModBlocks.OAK_CHISELED_STAIRS);

        birchChiseledPool.slab(ModBlocks.BIRCH_CHISELED_SLAB);
        birchChiseledPool.stairs(ModBlocks.BIRCH_CHISELED_STAIRS);

        spruceChiseledPool.slab(ModBlocks.SPRUCE_CHISELED_SLAB);
        spruceChiseledPool.stairs(ModBlocks.SPRUCE_CHISELED_STAIRS);

        jungleChiseledPool.slab(ModBlocks.JUNGLE_CHISELED_SLAB);
        jungleChiseledPool.stairs(ModBlocks.JUNGLE_CHISELED_STAIRS);

        acaciaChiseledPool.slab(ModBlocks.ACACIA_CHISELED_SLAB);
        acaciaChiseledPool.stairs(ModBlocks.ACACIA_CHISELED_STAIRS);

        darkOakChiseledPool.slab(ModBlocks.DARK_OAK_CHISELED_SLAB);
        darkOakChiseledPool.stairs(ModBlocks.DARK_OAK_CHISELED_STAIRS);

        crimsonChiseledPool.slab(ModBlocks.CRIMSON_CHISELED_SLAB);
        crimsonChiseledPool.stairs(ModBlocks.CRIMSON_CHISELED_STAIRS);

        warpedChiseledPool.slab(ModBlocks.WARPED_CHISELED_SLAB);
        warpedChiseledPool.stairs(ModBlocks.WARPED_CHISELED_STAIRS);

        mangroveChiseledPool.slab(ModBlocks.MANGROVE_CHISELED_SLAB);
        mangroveChiseledPool.stairs(ModBlocks.MANGROVE_CHISELED_STAIRS);

        cherryChiseledPool.slab(ModBlocks.CHERRY_CHISELED_SLAB);
        cherryChiseledPool.stairs(ModBlocks.CHERRY_CHISELED_STAIRS);

        blockStateModelGenerator.registerParentedItemModel(ModItems.SQUIRREL_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.WOOD_MOUSE_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.FIGEATER_BEETLE_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.ORCHID_MANTIS_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));

        blockStateModelGenerator.registerFlowerbed(ModBlocks.WOOD_ANEMONA);
        registerCarpet(blockStateModelGenerator, LEAVES.get("hazelnut"), ModBlocks.HAZELNUT_COVER);
        blockStateModelGenerator.registerSingleton(ModBlocks.BAUHINIA_COVER_BLOCK, TexturedModel.LEAVES);
        registerCarpet(blockStateModelGenerator, ModBlocks.BAUHINIA_COVER_BLOCK, ModBlocks.BAUHINIA_COVER);
        blockStateModelGenerator.registerWallPlant(ModBlocks.BAUHINIA_VINES);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.LARGE_CELANDINE, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.BLUEGRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.LARGE_ORCHID, BlockStateModelGenerator.TintType.NOT_TINTED);

        registerLilyPad(blockStateModelGenerator, ModBlocks.ORCHID_LILY_PAD);

        registerGrassBlock(blockStateModelGenerator, ModBlocks.ORCHID_GRASS_BLOCK);

        blockStateModelGenerator.registerMushroomBlock(ModBlocks.WHITE_MUSHROOM_BLOCK);
        blockStateModelGenerator.registerMushroomBlock(ModBlocks.WHITE_MUSHROOM_STEM);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.WHITE_MUSHROOM, ModBlocks.POTTED_WHITE_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.ORCHID, ModBlocks.POTTED_ORCHID, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GERANIUM, ModBlocks.POTTED_GERANIUM, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    private void registerLilyPad(BlockStateModelGenerator blockStateModelGenerator, Block block)
    {
        blockStateModelGenerator.registerItemModel(block);
        blockStateModelGenerator.blockStateCollector.accept(createBlockStateWithRandomHorizontalRotations(block, ModelIds.getBlockModelId(block)));
    }

    private void registerGrassBlock(BlockStateModelGenerator generator, Block grassBlock)
    {
        TextureMap textureMap = new TextureMap()
                .put(TextureKey.BOTTOM, TextureMap.getId(Blocks.DIRT))
                .put(TextureKey.TOP, TextureMap.getSubId(grassBlock, "_top"))
                .put(TextureKey.SIDE, TextureMap.getSubId(grassBlock, "_side"));
        generator.blockStateCollector.accept(createSingletonBlockState(grassBlock, Models.CUBE_BOTTOM_TOP.upload(grassBlock, textureMap, generator.modelCollector)));
    }

    public final void registerCarpet(BlockStateModelGenerator blockStateModelGenerator, Block wool, Block carpet)
    {
        Identifier identifier = TexturedModel.CARPET.get(wool).upload(carpet, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(createSingletonBlockState(carpet, identifier));
    }

    private void registerHangingSign(BlockStateModelGenerator blockStateModelGenerator, Block strippedLog, Block hangingSign, Block wallHangingSign)
    {
        TextureMap textureMap = TextureMap.particle(strippedLog);
        Identifier identifier = Models.PARTICLE.upload(hangingSign, textureMap, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(createSingletonBlockState(hangingSign, identifier));
        blockStateModelGenerator.blockStateCollector.accept(createSingletonBlockState(wallHangingSign, identifier));
    }

    private void registerLogBlock(BlockStateModelGenerator generator, Block logBlock, Identifier topTexture, Identifier sideTexture)
    {
        Function<Block, TextureMap> texturesGetter = block -> new TextureMap()
                .put(TextureKey.TOP, topTexture)
                .put(TextureKey.SIDE, sideTexture)
                .put(TextureKey.END, topTexture);

        generator.registerAxisRotated(
                logBlock,
                TexturedModel.makeFactory(texturesGetter, Models.CUBE_COLUMN),
                TexturedModel.makeFactory(texturesGetter, Models.CUBE_COLUMN_HORIZONTAL)
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        itemModelGenerator.register(ModItems.HAZELNUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.HAZELNUT_CRACKED, Models.GENERATED);
        itemModelGenerator.register(ModItems.HAZELNUT_SPOILED, Models.GENERATED);
        itemModelGenerator.register(ModItems.HAZELNUT_PEELED, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUINCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.MANGO, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIBURNUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.WILD_CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHITE_MULBERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SQUIRREL_HIDE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOOD_MOUSE_TAIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIGEATER_BEETLE_SHELL, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILENT_ARROW, Models.GENERATED);
        itemModelGenerator.register(ModItems.MINIHAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORCHID_MANTIS_INCISOR, Models.GENERATED);

        for(String name : WOOD_NAMES)
        {
            itemModelGenerator.register(WOODEN_BOATS.get(name), Models.GENERATED);
            itemModelGenerator.register(WOODEN_CHEST_BOATS.get(name), Models.GENERATED);
            itemModelGenerator.register(WOODEN_HANGING_SIGN_ITEMS.get(name), Models.GENERATED);
        }

        itemModelGenerator.registerArmor((ArmorItem) ModItems.FIGEATER_BEETLE_CHESTPLATE);
    }
}
