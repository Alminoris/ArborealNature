package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.function.Function;

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
        BlockStateModelGenerator.BlockTexturePool hazelnutPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.HAZELNUT_PLANKS);
        BlockStateModelGenerator.BlockTexturePool hazelnutChiseledPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.HAZELNUT_CHISELED);
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

        hazelnutPlanksPool.slab(ModBlocks.HAZELNUT_SLAB);
        hazelnutPlanksPool.stairs(ModBlocks.HAZELNUT_STAIRS);

        hazelnutChiseledPool.slab(ModBlocks.HAZELNUT_CHISELED_SLAB);
        hazelnutChiseledPool.stairs(ModBlocks.HAZELNUT_CHISELED_STAIRS);

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

        registerLogBlock(blockStateModelGenerator, ModBlocks.HAZELNUT_LOG,
                Identifier.of(ArborealNature.MOD_ID, "block/hazelnut_log_top"),
                Identifier.of(ArborealNature.MOD_ID, "block/hazelnut_log_side"));

        registerLogBlock(blockStateModelGenerator, ModBlocks.STRIPPED_HAZELNUT_LOG,
                Identifier.of(ArborealNature.MOD_ID, "block/stripped_hazelnut_log_top"),
                Identifier.of(ArborealNature.MOD_ID, "block/stripped_hazelnut_log_side"));

        registerLogBlock(blockStateModelGenerator, ModBlocks.HAZELNUT_WOOD,
                Identifier.of(ArborealNature.MOD_ID, "block/hazelnut_log_side"),
                Identifier.of(ArborealNature.MOD_ID, "block/hazelnut_log_side"));

        registerLogBlock(blockStateModelGenerator, ModBlocks.STRIPPED_HAZELNUT_WOOD,
                Identifier.of(ArborealNature.MOD_ID, "block/stripped_hazelnut_log_side"),
                Identifier.of(ArborealNature.MOD_ID, "block/stripped_hazelnut_log_side"));

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HAZELNUT_LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.HAZELNUT_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerDoor(ModBlocks.HAZELNUT_DOOR);

        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.HAZELNUT_TRAPDOOR);

        hazelnutPlanksPool.fence(ModBlocks.HAZELNUT_FENCE);
        hazelnutPlanksPool.fenceGate(ModBlocks.HAZELNUT_FENCE_GATE);
        hazelnutPlanksPool.button(ModBlocks.HAZELNUT_BUTTON);
        hazelnutPlanksPool.pressurePlate(ModBlocks.HAZELNUT_PRESSURE_PLATE);

        hazelnutPlanksPool.family(ModBlocks.HAZELNUT_FAMILY);

        blockStateModelGenerator.registerParentedItemModel(ModItems.SQUIRREL_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
    }

    private void registerHangingSign(BlockStateModelGenerator blockStateModelGenerator, Block strippedLog, Block hangingSign, Block wallHangingSign)
    {
        TextureMap textureMap = TextureMap.particle(strippedLog);
        Identifier identifier = Models.PARTICLE.upload(hangingSign, textureMap, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(createSingletonBlockState(hangingSign, identifier));
        blockStateModelGenerator.blockStateCollector.accept(createSingletonBlockState(wallHangingSign, identifier));
        blockStateModelGenerator.registerItemModel(wallHangingSign.asItem());
    }

    private void registerLogBlock(BlockStateModelGenerator generator, Block logBlock, Identifier topTexture, Identifier sideTexture)
    {
        // Create a texture map for the log's side and top
        Function<Block, TextureMap> texturesGetter = block -> new TextureMap()
                .put(TextureKey.TOP, topTexture)
                .put(TextureKey.SIDE, sideTexture)
                .put(TextureKey.END, topTexture);

        // Register the blockstate for the log (handles axis-based rotation)
        generator.registerAxisRotated(
                logBlock,
                TexturedModel.makeFactory(texturesGetter, Models.CUBE_COLUMN),         // Factory for cube_column (vertical)
                TexturedModel.makeFactory(texturesGetter, Models.CUBE_COLUMN_HORIZONTAL)  // Factory for cube_column_horizontal (horizontal)
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        itemModelGenerator.register(ModItems.HAZELNUT, Models.GENERATED);

        itemModelGenerator.register(ModItems.HAZELNUT_HANGING_SIGN, Models.GENERATED);

        itemModelGenerator.register(ModItems.HAZELNUT_CRACKED, Models.GENERATED);

        itemModelGenerator.register(ModItems.HAZELNUT_SPOILED, Models.GENERATED);

        itemModelGenerator.register(ModItems.HAZELNUT_PEELED, Models.GENERATED);

        itemModelGenerator.register(ModItems.MINIHAMMER, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.HAZELNUT_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.HAZELNUT_CHEST_BOAT, Models.GENERATED);
    }
}
