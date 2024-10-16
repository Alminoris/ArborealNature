package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider
{
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter)
    {
        offerShapelessRecipe(recipeExporter, ModBlocks.HAZELNUT_LOG, ModBlocks.HAZELNUT_PLANKS, String.valueOf(RecipeCategory.MISC), 4);
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAZELNUT_SLAB, ModBlocks.HAZELNUT_PLANKS);
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAZELNUT_CHISELED_SLAB, ModBlocks.HAZELNUT_CHISELED);
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_CHISELED_SLAB, ModBlocks.OAK_CHISELED);
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIRCH_CHISELED_SLAB, ModBlocks.BIRCH_CHISELED);
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPRUCE_CHISELED_SLAB, ModBlocks.SPRUCE_CHISELED);
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JUNGLE_CHISELED_SLAB, ModBlocks.JUNGLE_CHISELED);
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACACIA_CHISELED_SLAB, ModBlocks.ACACIA_CHISELED);
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_OAK_CHISELED_SLAB, ModBlocks.DARK_OAK_CHISELED);
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_CHISELED_SLAB, ModBlocks.CRIMSON_CHISELED);
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_CHISELED_SLAB, ModBlocks.WARPED_CHISELED);
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MANGROVE_CHISELED_SLAB, ModBlocks.MANGROVE_CHISELED);
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHERRY_CHISELED_SLAB, ModBlocks.CHERRY_CHISELED);
        offerBoatRecipe(recipeExporter, ModItems.HAZELNUT_BOAT, ModBlocks.HAZELNUT_PLANKS);
        offerChestBoatRecipe(recipeExporter, ModItems.HAZELNUT_CHEST_BOAT, ModBlocks.HAZELNUT_PLANKS);
        offerHangingSignRecipe(recipeExporter, ModItems.HAZELNUT_HANGING_SIGN, ModBlocks.HAZELNUT_PLANKS);
        offerPressurePlateRecipe(recipeExporter, ModBlocks.HAZELNUT_PRESSURE_PLATE, ModBlocks.HAZELNUT_PLANKS);
        offerSingleOutputShapelessRecipe(recipeExporter, ModBlocks.HAZELNUT_BUTTON, ModBlocks.HAZELNUT_PLANKS, String.valueOf(RecipeCategory.MISC));
        offerSingleOutputShapelessRecipe(recipeExporter, ModItems.HAZELNUT_PEELED, ModItems.HAZELNUT_CRACKED, String.valueOf(RecipeCategory.MISC));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAZELNUT_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBlocks.HAZELNUT_PLANKS)
                .criterion(hasItem(ModBlocks.HAZELNUT_PLANKS), conditionsFromItem(ModBlocks.HAZELNUT_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAZELNUT_CHISELED_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBlocks.HAZELNUT_CHISELED)
                .criterion(hasItem(ModBlocks.HAZELNUT_CHISELED), conditionsFromItem(ModBlocks.HAZELNUT_CHISELED))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_CHISELED_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBlocks.OAK_CHISELED)
                .criterion(hasItem(ModBlocks.OAK_CHISELED), conditionsFromItem(ModBlocks.OAK_CHISELED))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIRCH_CHISELED_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBlocks.BIRCH_CHISELED)
                .criterion(hasItem(ModBlocks.BIRCH_CHISELED), conditionsFromItem(ModBlocks.BIRCH_CHISELED))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPRUCE_CHISELED_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBlocks.SPRUCE_CHISELED)
                .criterion(hasItem(ModBlocks.SPRUCE_CHISELED), conditionsFromItem(ModBlocks.SPRUCE_CHISELED))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JUNGLE_CHISELED_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBlocks.JUNGLE_CHISELED)
                .criterion(hasItem(ModBlocks.JUNGLE_CHISELED), conditionsFromItem(ModBlocks.JUNGLE_CHISELED))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACACIA_CHISELED_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBlocks.ACACIA_CHISELED)
                .criterion(hasItem(ModBlocks.ACACIA_CHISELED), conditionsFromItem(ModBlocks.ACACIA_CHISELED))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_OAK_CHISELED_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBlocks.DARK_OAK_CHISELED)
                .criterion(hasItem(ModBlocks.DARK_OAK_CHISELED), conditionsFromItem(ModBlocks.DARK_OAK_CHISELED))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_CHISELED_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBlocks.CRIMSON_CHISELED)
                .criterion(hasItem(ModBlocks.CRIMSON_CHISELED), conditionsFromItem(ModBlocks.CRIMSON_CHISELED))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_CHISELED_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBlocks.WARPED_CHISELED)
                .criterion(hasItem(ModBlocks.WARPED_CHISELED), conditionsFromItem(ModBlocks.WARPED_CHISELED))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MANGROVE_CHISELED_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBlocks.MANGROVE_CHISELED)
                .criterion(hasItem(ModBlocks.MANGROVE_CHISELED), conditionsFromItem(ModBlocks.MANGROVE_CHISELED))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHERRY_CHISELED_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBlocks.CHERRY_CHISELED)
                .criterion(hasItem(ModBlocks.CHERRY_CHISELED), conditionsFromItem(ModBlocks.CHERRY_CHISELED))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAZELNUT_FENCE, 3)
                .pattern("#/#")
                .pattern("#/#")
                .input('#', ModBlocks.HAZELNUT_PLANKS)
                .input('/', Items.STICK)
                .criterion(hasItem(ModBlocks.HAZELNUT_PLANKS), conditionsFromItem(ModBlocks.HAZELNUT_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.HAZELNUT_FENCE_GATE)
                .pattern("/#/")
                .pattern("/#/")
                .input('#', ModBlocks.HAZELNUT_PLANKS)
                .input('/', Items.STICK)
                .criterion(hasItem(ModBlocks.HAZELNUT_PLANKS), conditionsFromItem(ModBlocks.HAZELNUT_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.HAZELNUT_SIGN, 3)
                .pattern("###")
                .pattern("###")
                .pattern(" / ")
                .input('#', ModBlocks.HAZELNUT_PLANKS)
                .input('/', Items.STICK)
                .criterion(hasItem(ModBlocks.HAZELNUT_PLANKS), conditionsFromItem(ModBlocks.HAZELNUT_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.HAZELNUT_DOOR, 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .input('#', ModBlocks.HAZELNUT_PLANKS)
                .criterion(hasItem(ModBlocks.HAZELNUT_PLANKS), conditionsFromItem(ModBlocks.HAZELNUT_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.HAZELNUT_TRAPDOOR, 2)
                .pattern("###")
                .pattern("###")
                .input('#', ModBlocks.HAZELNUT_PLANKS)
                .criterion(hasItem(ModBlocks.HAZELNUT_PLANKS), conditionsFromItem(ModBlocks.HAZELNUT_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MINIHAMMER, 1)
                .pattern("  #")
                .pattern("//#")
                .pattern("  #")
                .input('#', Items.IRON_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CHISEL, 1)
                .pattern("//#")
                .input('#', Items.IRON_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);
    }
}
