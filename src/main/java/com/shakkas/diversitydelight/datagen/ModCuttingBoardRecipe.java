package com.shakkas.diversitydelight.datagen;

import com.shakkas.diversitydelight.item.DDModItems;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

public class ModCuttingBoardRecipe {
    public static void register(RecipeOutput output) {
        cuttingCrops(output);
    }

    private static void cuttingCrops(RecipeOutput output) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(DDModItems.BROCCOLI.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), DDModItems.BROCCOLI_FLORET.get(), 2)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(DDModItems.CAULIFLOWER.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), DDModItems.CAULIFLOWER_FLORET.get(), 2)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(DDModItems.PINEAPPLE.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), DDModItems.PINEAPPLE_SLICE.get(), 2)
                .build(output);
    }

    private static void cuttingFoodstuff(RecipeOutput output) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(DDModItems.HAWAIIAN_PIZZA.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), DDModItems.HAWAIIAN_PIZZA_SLICE.get(), 4)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(DDModItems.BANOFFEE_PIE.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), DDModItems.BANOFFEE_PIE_SLICE.get(), 4)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(DDModItems.LEMON_MERINGUE_PIE.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), DDModItems.LEMON_MERINGUE_PIE_SLICE.get(), 4)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(DDModItems.PEAR_PIE.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), DDModItems.PEAR_PIE_SLICE.get(), 4)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(DDModItems.FRUIT_FLAN.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), DDModItems.FRUIT_FLAN_SLICE.get(), 4)
                .build(output);

    }
}
