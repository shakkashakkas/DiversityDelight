package com.shakkas.diversitydelight.datagen;

import com.shakkas.diversitydelight.item.DDModItems;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

public class ModCuttingBoardRecipe {
    public static void register(RecipeOutput output) {
        cuttingVegetables(output);
    }

    private static void cuttingVegetables(RecipeOutput output) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(DDModItems.BROCCOLI.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), DDModItems.BROCCOLI_FLORET.get(), 2)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(DDModItems.CAULIFLOWER.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), DDModItems.CAULIFLOWER_FLORET.get(), 2)
                .build(output);
    }
}
