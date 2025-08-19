package net.alminoris.arborealnature.datagen;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static net.alminoris.arborealnature.util.helper.ModBlockSetsHelper.*;

public class ModRecipeProvider extends FabricRecipeProvider
{
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter)
    {
        for(String name : WOOD_NAMES)
        {
            offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_CHISELED_SLABS.get(name), WOODEN_CHISELED.get(name));
            offerShapelessRecipe(recipeExporter, WOODEN_PLANKS.get(name), LOGS.get(name), String.valueOf(RecipeCategory.MISC), 4);
            offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_SLABS.get(name), WOODEN_PLANKS.get(name));
            offerBoatRecipe(recipeExporter, WOODEN_BOATS.get(name), WOODEN_PLANKS.get(name));
            offerChestBoatRecipe(recipeExporter, WOODEN_CHEST_BOATS.get(name), WOODEN_PLANKS.get(name));
            offerHangingSignRecipe(recipeExporter, WOODEN_HANGING_SIGN_ITEMS.get(name), WOODEN_PLANKS.get(name));
            offerPressurePlateRecipe(recipeExporter, WOODEN_PRESSURE_PLATES.get(name), WOODEN_PLANKS.get(name));
            offerSingleOutputShapelessRecipe(recipeExporter, WOODEN_BUTTONS.get(name), WOODEN_PLANKS.get(name), String.valueOf(RecipeCategory.MISC));

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODS.get(name), 3)
                    .pattern("##")
                    .pattern("##")
                    .input('#', LOGS.get(name))
                    .criterion(hasItem(LOGS.get(name)), conditionsFromItem(LOGS.get(name)))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, STRIPPED_WOODS.get(name), 3)
                    .pattern("##")
                    .pattern("##")
                    .input('#', STRIPPED_LOGS.get(name))
                    .criterion(hasItem(STRIPPED_LOGS.get(name)), conditionsFromItem(STRIPPED_LOGS.get(name)))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BURNT_WOODS.get(name), 3)
                    .pattern("##")
                    .pattern("##")
                    .input('#', BURNT_LOGS.get(name))
                    .criterion(hasItem(BURNT_LOGS.get(name)), conditionsFromItem(BURNT_LOGS.get(name)))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_STAIRS.get(name), 4)
                    .pattern("#  ")
                    .pattern("## ")
                    .pattern("###")
                    .input('#', WOODEN_PLANKS.get(name))
                    .criterion(hasItem(WOODEN_PLANKS.get(name)), conditionsFromItem(WOODEN_PLANKS.get(name)))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCES.get(name), 3)
                    .pattern("#/#")
                    .pattern("#/#")
                    .input('#', WOODEN_PLANKS.get(name))
                    .input('/', Items.STICK)
                    .criterion(hasItem(WOODEN_PLANKS.get(name)), conditionsFromItem(WOODEN_PLANKS.get(name)))
                    .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, WOODEN_FENCE_GATES.get(name))
                    .pattern("/#/")
                    .pattern("/#/")
                    .input('#', WOODEN_PLANKS.get(name))
                    .input('/', Items.STICK)
                    .criterion(hasItem(WOODEN_PLANKS.get(name)), conditionsFromItem(WOODEN_PLANKS.get(name)))
                    .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, WOODEN_SIGN_ITEMS.get(name), 3)
                    .pattern("###")
                    .pattern("###")
                    .pattern(" / ")
                    .input('#', WOODEN_PLANKS.get(name))
                    .input('/', Items.STICK)
                    .criterion(hasItem(WOODEN_PLANKS.get(name)), conditionsFromItem(WOODEN_PLANKS.get(name)))
                    .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, WOODEN_DOORS.get(name), 3)
                    .pattern("##")
                    .pattern("##")
                    .pattern("##")
                    .input('#', WOODEN_PLANKS.get(name))
                    .criterion(hasItem(WOODEN_PLANKS.get(name)), conditionsFromItem(WOODEN_PLANKS.get(name)))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, WOODEN_TRAPDOORS.get(name), 2)
                    .pattern("###")
                    .pattern("###")
                    .input('#', WOODEN_PLANKS.get(name))
                    .criterion(hasItem(WOODEN_PLANKS.get(name)), conditionsFromItem(WOODEN_PLANKS.get(name)))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_CHISELED_STAIRS.get(name), 4)
                    .pattern("#  ")
                    .pattern("## ")
                    .pattern("###")
                    .input('#', WOODEN_CHISELED.get(name))
                    .criterion(hasItem(WOODEN_CHISELED.get(name)), conditionsFromItem(WOODEN_CHISELED.get(name)))
                    .offerTo(recipeExporter);
        }

        for (String name : CLASSIC_WOOD_NAMES)
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BURNT_WOODS.get(name), 3)
                    .pattern("##")
                    .pattern("##")
                    .input('#', BURNT_LOGS.get(name))
                    .criterion(hasItem(BURNT_LOGS.get(name)), conditionsFromItem(BURNT_LOGS.get(name)))
                    .offerTo(recipeExporter);
        }

        for (String name : WF_WOOD_NAMES)
        {
            offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_CHISELED_SLABS.get(name), WOODEN_CHISELED.get(name));

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_CHISELED_STAIRS.get(name), 4)
                    .pattern("#  ")
                    .pattern("## ")
                    .pattern("###")
                    .input('#', WOODEN_CHISELED.get(name))
                    .criterion(hasItem(WOODEN_CHISELED.get(name)), conditionsFromItem(WOODEN_CHISELED.get(name)))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BURNT_WOODS.get(name), 3)
                    .pattern("##")
                    .pattern("##")
                    .input('#', BURNT_LOGS.get(name))
                    .criterion(hasItem(BURNT_LOGS.get(name)), conditionsFromItem(BURNT_LOGS.get(name)))
                    .offerTo(recipeExporter);
        }

        for (String name : ST_WOOD_NAMES)
        {
            offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_CHISELED_SLABS.get(name), WOODEN_CHISELED.get(name));

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_CHISELED_STAIRS.get(name), 4)
                    .pattern("#  ")
                    .pattern("## ")
                    .pattern("###")
                    .input('#', WOODEN_CHISELED.get(name))
                    .criterion(hasItem(WOODEN_CHISELED.get(name)), conditionsFromItem(WOODEN_CHISELED.get(name)))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BURNT_WOODS.get(name), 3)
                    .pattern("##")
                    .pattern("##")
                    .input('#', BURNT_LOGS.get(name))
                    .criterion(hasItem(BURNT_LOGS.get(name)), conditionsFromItem(BURNT_LOGS.get(name)))
                    .offerTo(recipeExporter);
        }

        for (String name : WT_WOOD_NAMES)
        {
            offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_CHISELED_SLABS.get(name), WOODEN_CHISELED.get(name));

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_CHISELED_STAIRS.get(name), 4)
                    .pattern("#  ")
                    .pattern("## ")
                    .pattern("###")
                    .input('#', WOODEN_CHISELED.get(name))
                    .criterion(hasItem(WOODEN_CHISELED.get(name)), conditionsFromItem(WOODEN_CHISELED.get(name)))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BURNT_WOODS.get(name), 3)
                    .pattern("##")
                    .pattern("##")
                    .input('#', BURNT_LOGS.get(name))
                    .criterion(hasItem(BURNT_LOGS.get(name)), conditionsFromItem(BURNT_LOGS.get(name)))
                    .offerTo(recipeExporter);
        }

        for (String name : MT_WOOD_NAMES)
        {
            offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_CHISELED_SLABS.get(name), WOODEN_CHISELED.get(name));

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_CHISELED_STAIRS.get(name), 4)
                    .pattern("#  ")
                    .pattern("## ")
                    .pattern("###")
                    .input('#', WOODEN_CHISELED.get(name))
                    .criterion(hasItem(WOODEN_CHISELED.get(name)), conditionsFromItem(WOODEN_CHISELED.get(name)))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BURNT_WOODS.get(name), 3)
                    .pattern("##")
                    .pattern("##")
                    .input('#', BURNT_LOGS.get(name))
                    .criterion(hasItem(BURNT_LOGS.get(name)), conditionsFromItem(BURNT_LOGS.get(name)))
                    .offerTo(recipeExporter);
        }

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAUHINIA_COVER_BLOCK, 1)
                .pattern("##")
                .pattern("##")
                .input('#', ModBlocks.BAUHINIA_COVER)
                .criterion(hasItem(ModBlocks.BAUHINIA_COVER), conditionsFromItem(ModBlocks.BAUHINIA_COVER))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINE_COVER_BLOCK, 1)
                .pattern("##")
                .pattern("##")
                .input('#', ModBlocks.PINE_COVER)
                .criterion(hasItem(ModBlocks.PINE_COVER), conditionsFromItem(ModBlocks.PINE_COVER))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JUNIPER_COVER_BLOCK, 1)
                .pattern("##")
                .pattern("##")
                .input('#', ModBlocks.JUNIPER_COVER)
                .criterion(hasItem(ModBlocks.JUNIPER_COVER), conditionsFromItem(ModBlocks.JUNIPER_COVER))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLAT_GRASS_BLOCK, 1)
                .pattern("##")
                .pattern("##")
                .input('#', ModBlocks.FLAT_GRASS)
                .criterion(hasItem(ModBlocks.FLAT_GRASS), conditionsFromItem(ModBlocks.FLAT_GRASS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HUNTING_KNIFE, 1)
                .pattern(" # ")
                .pattern("/  ")
                .input('#', ModItems.MOOSE_HORN)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.MOOSE_HORN), conditionsFromItem(ModItems.MOOSE_HORN))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CARIBOU_SPEAR, 1)
                .pattern("  #")
                .pattern(" / ")
                .pattern("/  ")
                .input('#', ModItems.CARIBOU_HORN)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.CARIBOU_HORN), conditionsFromItem(ModItems.CARIBOU_HORN))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CARIBOU_FUR_HELMET, 1)
                .pattern("###")
                .pattern("# #")
                .input('#', ModItems.CARIBOU_FUR)
                .criterion(hasItem(ModItems.CARIBOU_FUR), conditionsFromItem(ModItems.CARIBOU_FUR))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CARIBOU_FUR_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.CARIBOU_FUR)
                .criterion(hasItem(ModItems.CARIBOU_FUR), conditionsFromItem(ModItems.CARIBOU_FUR))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CARIBOU_FUR_LEGGINGS, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', ModItems.CARIBOU_FUR)
                .criterion(hasItem(ModItems.CARIBOU_FUR), conditionsFromItem(ModItems.CARIBOU_FUR))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CARIBOU_FUR_BOOTS, 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', ModItems.CARIBOU_FUR)
                .criterion(hasItem(ModItems.CARIBOU_FUR), conditionsFromItem(ModItems.CARIBOU_FUR))
                .offerTo(recipeExporter);

        offerSingleOutputShapelessRecipe(recipeExporter, Items.WHITE_DYE, ModBlocks.WOOD_ANEMONA, String.valueOf(RecipeCategory.MISC));
        offerSingleOutputShapelessRecipe(recipeExporter, Items.MAGENTA_DYE, ModBlocks.GERANIUM, String.valueOf(RecipeCategory.MISC));
        offerSingleOutputShapelessRecipe(recipeExporter, Items.YELLOW_DYE, ModBlocks.XEROCHRYSUM, String.valueOf(RecipeCategory.MISC));
        offerSingleOutputShapelessRecipe(recipeExporter, Items.PINK_DYE, ModBlocks.ORCHID, String.valueOf(RecipeCategory.MISC));
        offerSingleOutputShapelessRecipe(recipeExporter, Items.WHITE_DYE, ModBlocks.WOOD_SORREL, String.valueOf(RecipeCategory.MISC));
        offerSingleOutputShapelessRecipe(recipeExporter, Items.BLUE_DYE, ModBlocks.BLUEBELL, String.valueOf(RecipeCategory.MISC));

        offerFoodCookingRecipe(recipeExporter, "smoking", RecipeSerializer.SMOKING, SmokingRecipe::new,
                100, ModItems.MOOSE_VENISON, ModItems.COOKED_MOOSE_VENISON, 0.35f);

        offerFoodCookingRecipe(recipeExporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,
                600, ModItems.MOOSE_VENISON, ModItems.COOKED_MOOSE_VENISON, 0.35f);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(ModItems.MOOSE_VENISON), RecipeCategory.FOOD,
                        ModItems.COOKED_MOOSE_VENISON, 0.35F, 200)
                .criterion("has_beef", conditionsFromItem(ModItems.MOOSE_VENISON))
                .offerTo(recipeExporter);

        offerFoodCookingRecipe(recipeExporter, "smoking", RecipeSerializer.SMOKING, SmokingRecipe::new,
                100, ModItems.CARIBOU_VENISON, ModItems.COOKED_CARIBOU_VENISON, 0.35f);

        offerFoodCookingRecipe(recipeExporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,
                600, ModItems.CARIBOU_VENISON, ModItems.COOKED_CARIBOU_VENISON, 0.35f);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(ModItems.CARIBOU_VENISON), RecipeCategory.FOOD,
                        ModItems.COOKED_CARIBOU_VENISON, 0.35F, 200)
                .criterion("has_beef", conditionsFromItem(ModItems.CARIBOU_VENISON))
                .offerTo(recipeExporter);

        offerCarpetRecipe(recipeExporter, ModBlocks.REINDEER_LICHEN_CARPET, ModBlocks.REINDEER_LICHEN);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINE_RESIN_BRICKS, 4)
                .pattern("##")
                .pattern("##")
                .input('#', ModBlocks.PINE_RESIN_BLOCK)
                .criterion(hasItem(ModBlocks.PINE_RESIN_BLOCK), conditionsFromItem(ModBlocks.PINE_RESIN_BLOCK))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINE_RESIN_CHISELED, 1)
                .pattern("#")
                .pattern("#")
                .input('#', ModBlocks.PINE_RESIN_BRICKS_SLAB)
                .criterion(hasItem(ModBlocks.PINE_RESIN_BRICKS_SLAB), conditionsFromItem(ModBlocks.PINE_RESIN_BRICKS_SLAB))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINE_RESIN_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.PINE_RESIN)
                .criterion(hasItem(ModItems.PINE_RESIN), conditionsFromItem(ModItems.PINE_RESIN))
                .offerTo(recipeExporter);
        offerShapelessRecipe(recipeExporter, ModItems.PINE_RESIN, ModBlocks.PINE_RESIN_BLOCK, String.valueOf(RecipeCategory.MISC), 9);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINE_CONE_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.PINE_CONE)
                .criterion(hasItem(ModItems.PINE_CONE), conditionsFromItem(ModItems.PINE_CONE))
                .offerTo(recipeExporter);
        offerShapelessRecipe(recipeExporter, ModItems.PINE_CONE, ModBlocks.PINE_CONE_BLOCK, String.valueOf(RecipeCategory.MISC), 9);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIR_CONE_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.FIR_CONE)
                .criterion(hasItem(ModItems.FIR_CONE), conditionsFromItem(ModItems.FIR_CONE))
                .offerTo(recipeExporter);
        offerShapelessRecipe(recipeExporter, ModItems.FIR_CONE, ModBlocks.FIR_CONE_BLOCK, String.valueOf(RecipeCategory.MISC), 9);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CEDAR_CONE_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.CEDAR_CONE)
                .criterion(hasItem(ModItems.CEDAR_CONE), conditionsFromItem(ModItems.CEDAR_CONE))
                .offerTo(recipeExporter);
        offerShapelessRecipe(recipeExporter, ModItems.CEDAR_CONE, ModBlocks.CEDAR_CONE_BLOCK, String.valueOf(RecipeCategory.MISC), 9);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ARAUCARIA_CONE_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.ARAUCARIA_CONE)
                .criterion(hasItem(ModItems.ARAUCARIA_CONE), conditionsFromItem(ModItems.ARAUCARIA_CONE))
                .offerTo(recipeExporter);
        offerShapelessRecipe(recipeExporter, ModItems.ARAUCARIA_CONE, ModBlocks.ARAUCARIA_CONE_BLOCK, String.valueOf(RecipeCategory.MISC), 9);

        offerShapelessRecipe(recipeExporter, Items.YELLOW_DYE, ModBlocks.LARGE_CELANDINE, String.valueOf(RecipeCategory.MISC), 2);
        offerShapelessRecipe(recipeExporter, Items.LIGHT_GRAY_DYE, ModBlocks.BLUEGRASS, String.valueOf(RecipeCategory.MISC), 2);
        offerShapelessRecipe(recipeExporter, Items.PINK_DYE, ModBlocks.LARGE_ORCHID, String.valueOf(RecipeCategory.MISC), 2);

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
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINE_RESIN_BRICKS_SLAB, ModBlocks.PINE_RESIN_BRICKS);

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINE_RESIN_BRICKS_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBlocks.PINE_RESIN_BRICKS)
                .criterion(hasItem(ModBlocks.PINE_RESIN_BRICKS), conditionsFromItem(ModBlocks.PINE_RESIN_BRICKS))
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.LEATHER, 1)
                .pattern("##")
                .pattern("##")
                .input('#', ModItems.SQUIRREL_HIDE)
                .criterion(hasItem(ModItems.SQUIRREL_HIDE), conditionsFromItem(ModItems.SQUIRREL_HIDE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SILENT_ARROW, 2)
                .pattern(" # ")
                .pattern("#X#")
                .pattern(" # ")
                .input('X', Items.ARROW)
                .input('#', ModItems.WOOD_MOUSE_TAIL)
                .criterion(hasItem(Items.ARROW), conditionsFromItem(Items.ARROW))
                .criterion(hasItem(ModItems.WOOD_MOUSE_TAIL), conditionsFromItem(ModItems.WOOD_MOUSE_TAIL))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FIGEATER_BEETLE_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.FIGEATER_BEETLE_SHELL)
                .criterion(hasItem(ModItems.FIGEATER_BEETLE_SHELL), conditionsFromItem(ModItems.FIGEATER_BEETLE_SHELL))
                .offerTo(recipeExporter);
    }
}
