package com.shakkas.diversitydelight.datagen;

import com.shakkas.diversitydelight.item.DDModItems;
import com.shakkas.diversitydelight.tags.DDCommonTags;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

public class ModCookingRecipes {
    public static final int FAST_COOKING = 100;      // 5 seconds
    public static final int NORMAL_COOKING = 200;    // 10 seconds
    public static final int SLOW_COOKING = 400;      // 20 seconds

    public static final float SMALL_EXP = 0.35F;
    public static final float MEDIUM_EXP = 1.0F;
    public static final float LARGE_EXP = 2.0F;

    public static void register(RecipeOutput output) {
        cookMeals(output);
    }

    private static void cookMeals(RecipeOutput output) {
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.BUFFALO_WINGS.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(ModItems.CHICKEN_CUTS.get())
                .addIngredient(ModItems.CHICKEN_CUTS.get())
                .addIngredient(Items.WHEAT)
                .addIngredient(DDModItems.CELERY.get())
                .addIngredient(DDModItems.PEA_SEEDS.get())
                .addIngredient(DDModItems.PEA_SEEDS.get())
                .unlockedByAnyIngredient(Items.CHICKEN, DDModItems.CELERY, DDModItems.PEA)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.CAULIFLOWER_SOUP.get(), 1, FAST_COOKING, SMALL_EXP)
                .addIngredient(DDCommonTags.CROPS_CAULIFLOWER)
                .addIngredient(DDCommonTags.CROPS_CAULIFLOWER)
                .addIngredient(Items.POTATO)
                .addIngredient(ModItems.ONION.get())
                .addIngredient(ModItems.MILK_BOTTLE.get())
                .unlockedByItems("has_cauliflower", DDModItems.CAULIFLOWER)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.CAULIFLOWER_STEAK.get(), 1, SLOW_COOKING, MEDIUM_EXP)
                .addIngredient(DDModItems.CAULIFLOWER.get())
                .addIngredient(DDCommonTags.CROPS_GREEN_BEAN)
                .addIngredient(DDCommonTags.CROPS_GREEN_BEAN)
                .addIngredient(DDCommonTags.CROPS_GREEN_BEAN)
                .unlockedByItems("has_cauliflower", DDModItems.CAULIFLOWER)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.CHICKEN_POT_PIE_BLOCK.get(), 1, SLOW_COOKING, LARGE_EXP)
                .addIngredient(CommonTags.FOODS_COOKED_CHICKEN)
                .addIngredient(DDCommonTags.CROPS_PEA)
                .addIngredient(Items.CARROT)
                .addIngredient(CommonTags.CROPS_ONION)
                .addIngredient(CommonTags.FOODS_MILK)
                .addIngredient(Items.EGG)
                .unlockedByAnyIngredient(ModItems.ONION.get(), DDModItems.PEA.get(), Items.COOKED_CHICKEN, Items.CARROT)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.CHILI_BEAN_SOUP.get(), 1, FAST_COOKING, SMALL_EXP)
                .addIngredient(DDCommonTags.CROPS_CHILI)
                .addIngredient(DDCommonTags.CROPS_GREEN_BEAN)
                .addIngredient(ModItems.TOMATO_SAUCE.get())
                .addIngredient(CommonTags.CROPS_ONION)
                .unlockedByAnyIngredient(ModItems.ONION.get(), DDModItems.CHILI.get(), DDModItems.GREEN_BEAN.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.FRITATA.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(DDCommonTags.CROPS_BROCCOLI)
                .addIngredient(DDCommonTags.CROPS_BROCCOLI)
                .addIngredient(CommonTags.FOODS_COOKED_CHICKEN)
                .addIngredient(Items.EGG)
                .addIngredient(CommonTags.FOODS_MILK)
                .unlockedByItems("has_broccoli", DDModItems.BROCCOLI)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.GREEN_BEAN_CASSEROLE.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(DDCommonTags.CROPS_GREEN_BEAN)
                .addIngredient(DDCommonTags.CROPS_GREEN_BEAN)
                .addIngredient(DDCommonTags.CROPS_CELERY)
                .addIngredient(Items.BROWN_MUSHROOM)
                .addIngredient(CommonTags.FOODS_MILK)
                .addIngredient(CommonTags.FOODS_COOKED_BACON)
                .unlockedByItems("has_green_bean", DDModItems.GREEN_BEAN)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.GREEN_BEAN_STIR_FRY.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(DDCommonTags.CROPS_GREEN_BEAN)
                .addIngredient(DDCommonTags.CROPS_GREEN_BEAN)
                .addIngredient(DDCommonTags.CROPS_CHILI)
                .addIngredient(CommonTags.CROPS_ONION)
                .addIngredient(ModItems.HAM.get())
                .unlockedByItems("has_green_bean", DDModItems.GREEN_BEAN)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.GUMBO.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(DDCommonTags.CROPS_BELL_PEPPER)
                .addIngredient(DDCommonTags.CROPS_CELERY)
                .addIngredient(CommonTags.CROPS_ONION)
                .addIngredient(CommonTags.FOODS_COOKED_PORK)
                .addIngredient(CommonTags.CROPS_RICE)
                .unlockedByAnyIngredient(DDModItems.BELL_PEPPER.get(), DDModItems.CELERY.get(), ModItems.RICE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.MIXED_VEGETABLE_MEDLEY.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(DDCommonTags.CROPS_CAULIFLOWER)
                .addIngredient(DDCommonTags.CROPS_BROCCOLI)
                .addIngredient(DDCommonTags.CROPS_PEA)
                .addIngredient(Items.CARROT)
                .addIngredient(DDCommonTags.CROPS_BELL_PEPPER)
                .addIngredient(Items.BROWN_MUSHROOM)
                .unlockedByAnyIngredient(DDModItems.CAULIFLOWER.get(), DDModItems.BROCCOLI.get(), DDModItems.PEA.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.PEA_PESTO_PASTA.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(DDCommonTags.CROPS_PEA)
                .addIngredient(DDCommonTags.CROPS_PEA)
                .addIngredient(CommonTags.FOODS_PASTA)
                .addIngredient(CommonTags.CROPS_TOMATO)
                .unlockedByAnyIngredient(DDModItems.PEA.get(), ModItems.RAW_PASTA.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.STUFFED_BELL_PEPPER.get(), 1, FAST_COOKING, SMALL_EXP)
                .addIngredient(DDCommonTags.CROPS_BELL_PEPPER)
                .addIngredient(CommonTags.FOODS_COOKED_BEEF)
                .addIngredient(CommonTags.CROPS_TOMATO)
                .addIngredient(CommonTags.CROPS_RICE)
                .unlockedByItems("has_bell_pepper", DDModItems.BELL_PEPPER)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.TERIYAKI_CHICKEN.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(DDCommonTags.CROPS_BROCCOLI)
                .addIngredient(CommonTags.CROPS_RICE)
                .addIngredient(DDCommonTags.CROPS_CHILI)
                .addIngredient(CommonTags.FOODS_COOKED_CHICKEN)
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_broccoli", DDModItems.BROCCOLI)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
    }
}
