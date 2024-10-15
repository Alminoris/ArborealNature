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
        offerBoatRecipe(recipeExporter, ModItems.HAZELNUT_BOAT, ModBlocks.HAZELNUT_PLANKS);
        offerChestBoatRecipe(recipeExporter, ModItems.HAZELNUT_CHEST_BOAT, ModBlocks.HAZELNUT_PLANKS);
        offerHangingSignRecipe(recipeExporter, ModBlocks.HAZELNUT_HANGING_SIGN, ModBlocks.HAZELNUT_PLANKS);
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.HAZELNUT_SIGN, 3)
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
