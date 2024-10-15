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

        hazelnutPlanksPool.slab(ModBlocks.HAZELNUT_SLAB);
        hazelnutPlanksPool.stairs(ModBlocks.HAZELNUT_STAIRS);
        hazelnutPlanksPool.fence(ModBlocks.HAZELNUT_FENCE);
        hazelnutPlanksPool.fenceGate(ModBlocks.HAZELNUT_FENCE_GATE);
        hazelnutPlanksPool.button(ModBlocks.HAZELNUT_BUTTON);
        hazelnutPlanksPool.pressurePlate(ModBlocks.HAZELNUT_PRESSURE_PLATE);

        hazelnutPlanksPool.family(ModBlocks.HAZELNUT_FAMILY);

        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_HAZELNUT_LOG, ModBlocks.HAZELNUT_HANGING_SIGN, ModBlocks.HAZELNUT_WALL_HANGING_SIGN);
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

        itemModelGenerator.register(ModItems.HAZELNUT_CRACKED, Models.GENERATED);

        itemModelGenerator.register(ModItems.HAZELNUT_SPOILED, Models.GENERATED);

        itemModelGenerator.register(ModItems.HAZELNUT_PEELED, Models.GENERATED);

        itemModelGenerator.register(ModItems.MINIHAMMER, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.HAZELNUT_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.HAZELNUT_CHEST_BOAT, Models.GENERATED);
    }
}
