package com.shakkas.diversitydelight.datagen;

import com.shakkas.diversitydelight.item.DDModItems;
import com.shakkas.diversitydelight.tags.DDCommonTags;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
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
        cookMisc(output);
    }

    private static void cookMisc(RecipeOutput output) {
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.BANANA_MILK.get(), 1, NORMAL_COOKING, SMALL_EXP)
                .addIngredient(DDModItems.BANANA.get())
                .addIngredient(DDModItems.BANANA.get())
                .addIngredient(CommonTags.FOODS_MILK)
                .unlockedByItems("has_banana", DDModItems.BANANA.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .build(output);
    }

    private static void cookMeals(RecipeOutput output) {
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.BAKED_BEANS.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(DDModItems.SOY_BEANS.get())
                .addIngredient(DDModItems.SOY_BEANS.get())
                .addIngredient(DDModItems.SOY_BEANS.get())
                .addIngredient(ModItems.TOMATO_SAUCE.get())
                .addIngredient(Items.SUGAR)
                .unlockedByAnyIngredient(Items.CHICKEN, DDModItems.CELERY, DDModItems.PEA)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
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
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.CRUSTED_COD.get(), 1, SLOW_COOKING, LARGE_EXP)
                .addIngredient(CommonTags.FOODS_COOKED_COD)
                .addIngredient(DDModItems.ALMOND.get())
                .addIngredient(DDModItems.ALMOND.get())
                .addIngredient(DDModItems.LEMON.get())
                .addIngredient(CommonTags.FOODS_LEAFY_GREEN)
                .unlockedByAnyIngredient(DDModItems.LEMON.get(),DDModItems.ALMOND.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.CRUSTED_MUTTON_CHOPS.get(), 1, SLOW_COOKING, LARGE_EXP)
                .addIngredient(CommonTags.FOODS_COOKED_MUTTON)
                .addIngredient(CommonTags.FOODS_COOKED_MUTTON)
                .addIngredient(DDModItems.PISTACHIO.get())
                .addIngredient(DDModItems.PISTACHIO.get())
                .addIngredient(Items.CARROT)
                .addIngredient(DDModItems.BROCCOLI.get())
                .unlockedByAnyIngredient(DDModItems.PISTACHIO.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.CRUSTED_PORKCHOP.get(), 1, SLOW_COOKING, LARGE_EXP)
                .addIngredient(CommonTags.FOODS_COOKED_PORK)
                .addIngredient(CommonTags.FOODS_COOKED_PORK)
                .addIngredient(DDModItems.WALNUT.get())
                .addIngredient(DDModItems.WALNUT.get())
                .addIngredient(CommonTags.FOODS_LEAFY_GREEN)
                .addIngredient(ModItems.TOMATO.get())
                .unlockedByAnyIngredient(DDModItems.PISTACHIO.get())
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
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.GREEN_BEAN_ALMONDINE.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(DDCommonTags.CROPS_GREEN_BEAN)
                .addIngredient(DDCommonTags.CROPS_GREEN_BEAN)
                .addIngredient(DDCommonTags.CROPS_LEMON)
                .addIngredient(DDModItems.ALMOND.get())
                .addIngredient(DDModItems.ALMOND.get())
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
                .addIngredient(DDModItems.WALNUT.get())
                .addIngredient(DDModItems.WALNUT.get())
                .unlockedByAnyIngredient(DDModItems.PEA.get(), ModItems.RAW_PASTA.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.PORRIDGE.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(DDModItems.OATS.get())
                .addIngredient(DDModItems.OATS.get())
                .addIngredient(Items.HONEY_BOTTLE)
                .unlockedByAnyIngredient(DDModItems.OATS.get())
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
                .unlockedByItems("has_broccoli", DDModItems.BROCCOLI)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);

        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.APPLE_PEAR_CRUMBLE.get(), 1, NORMAL_COOKING, SMALL_EXP)
                .addIngredient(Items.APPLE)
                .addIngredient(Items.APPLE)
                .addIngredient(DDCommonTags.CROPS_PEAR)
                .addIngredient(DDCommonTags.CROPS_PEAR)
                .addIngredient(DDModItems.OATS.get())
                .addIngredient(DDModItems.ALMOND.get())
                .unlockedByItems("has_pear", DDModItems.PEAR)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);

        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.KIWI_JELLY.get(), 2, FAST_COOKING, SMALL_EXP)
                .addIngredient(DDModItems.KIWI.get())
                .addIngredient(DDModItems.KIWI.get())
                .addIngredient(Items.BONE)
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_kiwi", DDModItems.KIWI)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);

        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.LEMON_JELLY.get(), 2, FAST_COOKING, SMALL_EXP)
                .addIngredient(DDModItems.LEMON.get())
                .addIngredient(DDModItems.LEMON.get())
                .addIngredient(Items.BONE)
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_lemon", DDModItems.LEMON)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);

        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.MANGO_JELLY.get(), 2, FAST_COOKING, SMALL_EXP)
                .addIngredient(DDModItems.MANGO.get())
                .addIngredient(DDModItems.MANGO.get())
                .addIngredient(Items.BONE)
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_mango", DDModItems.MANGO)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);

        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.MANGO_YOGHURT.get(), 1, SLOW_COOKING, MEDIUM_EXP)
                .addIngredient(DDModItems.MANGO.get())
                .addIngredient(DDModItems.MANGO.get())
                .addIngredient(CommonTags.FOODS_MILK)
                .addIngredient(Items.HONEY_BOTTLE)
                .unlockedByItems("has_mango", DDModItems.MANGO)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);

        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.ORANGE_YOGHURT.get(), 1, SLOW_COOKING, MEDIUM_EXP)
                .addIngredient(DDModItems.ORANGE.get())
                .addIngredient(DDModItems.ORANGE.get())
                .addIngredient(CommonTags.FOODS_MILK)
                .addIngredient(Items.HONEY_BOTTLE)
                .unlockedByItems("has_orange", DDModItems.ORANGE)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);

        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.ORANGE_CHICKEN.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(DDModItems.ORANGE.get())
                .addIngredient(DDModItems.ORANGE.get())
                .addIngredient(CommonTags.FOODS_RAW_CHICKEN)
                .addIngredient(CommonTags.FOODS_RAW_CHICKEN)
                .addIngredient(Items.WHEAT)
                .unlockedByItems("has_orange", DDModItems.ORANGE)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);

        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.POACHED_PEAR.get(), 2, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(DDModItems.PEAR.get())
                .addIngredient(DDModItems.PEAR.get())
                .addIngredient(Items.HONEY_BOTTLE)
                .unlockedByItems("has_pear", DDModItems.PEAR)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);

        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.SWEET_AND_SOUR_CHICKEN.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(DDModItems.BELL_PEPPER.get())
                .addIngredient(DDCommonTags.FOODS_PINEAPPLE)
                .addIngredient(CommonTags.FOODS_RAW_CHICKEN)
                .addIngredient(CommonTags.FOODS_RAW_CHICKEN)
                .addIngredient(ModItems.ONION.get())
                .unlockedByItems("has_pineapple", DDModItems.PINEAPPLE)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);

        CookingPotRecipeBuilder.cookingPotRecipe(DDModItems.SWEET_STICKY_RICE.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(DDModItems.MANGO.get())
                .addIngredient(DDModItems.MANGO.get())
                .addIngredient(CommonTags.CROPS_RICE)
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_mango", DDModItems.MANGO)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
    }
}
