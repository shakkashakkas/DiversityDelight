package com.shakkas.diversitydelight.datagen;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.block.ModBlocks;
import com.shakkas.diversitydelight.item.DDModItems;
import com.shakkas.diversitydelight.tags.DDCommonTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;

public class ModCraftingRecipes {
    public static void register(RecipeOutput output) {
        recipesBlocks(output);
        recipesMaterials(output);
        recipesFoodstuffs(output);
        recipesCraftedMeals(output);
        recipesFoodBlocks(output);
        recipesItems(output);
    }
    private static void recipesBlocks(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.BELL_PEPPER_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.BELL_PEPPER.get())
                .unlockedBy("has_bell_pepper", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.BELL_PEPPER.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.BROCCOLI_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.BROCCOLI.get())
                .unlockedBy("has_broccoli", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.BROCCOLI.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.CAULIFLOWER_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.CAULIFLOWER.get())
                .unlockedBy("has_cauliflower", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.CAULIFLOWER.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.CELERY_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.CELERY.get())
                .unlockedBy("has_celery", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.CELERY.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.CHILI_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.CHILI.get())
                .unlockedBy("has_chili", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.CHILI.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.GREEN_BEAN_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.GREEN_BEAN.get())
                .unlockedBy("has_green_bean", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.GREEN_BEAN.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.PEA_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.PEA.get())
                .unlockedBy("has_pea", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PEA.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.CORN_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.CORN.get())
                .unlockedBy("has_corn", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.CORN.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.SOY_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.SOY.get())
                .unlockedBy("has_soy", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.SOY.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.OAT_BALE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.OATS.get())
                .unlockedBy("has_oats", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.OATS.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.APPLE_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Items.APPLE)
                .unlockedBy("has_apple", InventoryChangeTrigger.TriggerInstance.hasItems(Items.APPLE))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.BANANA_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.BANANA.get())
                .unlockedBy("has_banana", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.BANANA.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.ORANGE_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.ORANGE.get())
                .unlockedBy("has_orange", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.ORANGE.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.KIWI_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.KIWI.get())
                .unlockedBy("has_kiwi", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.KIWI.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.LEMON_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.LEMON.get())
                .unlockedBy("has_lemon", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.LEMON.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.PEAR_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.PEAR.get())
                .unlockedBy("has_pear", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PEAR.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.MANGO_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.MANGO.get())
                .unlockedBy("has_mango", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.MANGO.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.PINEAPPLE_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.PINEAPPLE.get())
                .unlockedBy("has_pineapple", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PINEAPPLE.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.ALMOND_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.ALMOND.get())
                .unlockedBy("has_almond", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.ALMOND.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.PISTACHIO_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.PISTACHIO.get())
                .unlockedBy("has_pistachio", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PISTACHIO.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.PEANUT_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.PEANUT.get())
                .unlockedBy("has_peanut", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PEANUT.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDModItems.WALNUT_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', DDModItems.WALNUT.get())
                .unlockedBy("has_walnut", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.WALNUT.get()))
                .save(output);


        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WORM_BIN_BLOCK.get())
                .pattern("CgC")
                .pattern("gcg")
                .pattern("CgC")
                .define('c', Items.COMPOSTER)
                .define('g', Items.GREEN_DYE)
                .define('C', Items.COPPER_INGOT)
                .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.OAK_PLANKS, 4)
                .requires(DDModItems.ORANGE_TREE_LOG.get())
                .unlockedBy("has_orange_tree_log", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.ORANGE_TREE_LOG.get()))
                .save(output,ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "oak_planks_from_orange_tree_log"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.OAK_PLANKS, 4)
                .requires(DDModItems.LEMON_TREE_LOG.get())
                .unlockedBy("has_lemon_tree_log", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.LEMON_TREE_LOG.get()))
                .save(output,ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "oak_planks_from_lemon_tree_log"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_PLANKS, 4)
                .requires(DDModItems.PEAR_TREE_LOG.get())
                .unlockedBy("has_pear_tree_log", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PEAR_TREE_LOG.get()))
                .save(output,ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "birch_planks_from_pear_tree_log"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_PLANKS, 4)
                .requires(DDModItems.MANGO_TREE_LOG.get())
                .unlockedBy("has_mango_tree_log", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.MANGO_TREE_LOG.get()))
                .save(output,ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "jungle_planks_from_mango_tree_log"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_PLANKS, 4)
                .requires(DDModItems.BANANA_TREE_STEM.get())
                .unlockedBy("has_banana_tree_stem", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.BANANA_TREE_STEM.get()))
                .save(output,ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "jungle_planks_from_banana_tree_stem"));
    }

    private static void recipesMaterials(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.BELL_PEPPER, 9)
                .requires(DDModItems.BELL_PEPPER_CRATE.get())
                .unlockedBy("has_bell_pepper_crate", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.BELL_PEPPER_CRATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "bell_pepper_from_crate"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.BROCCOLI, 9)
                .requires(DDModItems.BROCCOLI_CRATE.get())
                .unlockedBy("has_broccoli_crate", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.BROCCOLI_CRATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "broccoli_from_crate"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.CAULIFLOWER, 9)
                .requires(DDModItems.CAULIFLOWER_CRATE.get())
                .unlockedBy("has_cauliflower_crate", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.CAULIFLOWER_CRATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "cauliflower_from_crate"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.CELERY, 9)
                .requires(DDModItems.CELERY_CRATE.get())
                .unlockedBy("has_celery_crate", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.CELERY_CRATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "celery_from_crate"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.CHILI, 9)
                .requires(DDModItems.CHILI_CRATE.get())
                .unlockedBy("has_chili_crate", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.CHILI_CRATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "chili_from_crate"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.GREEN_BEAN, 9)
                .requires(DDModItems.GREEN_BEAN_CRATE.get())
                .unlockedBy("has_green_bean_crate", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.GREEN_BEAN_CRATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "green_bean_from_crate"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.PEA, 9)
                .requires(DDModItems.PEA_CRATE.get())
                .unlockedBy("has_pea_crate", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PEA_CRATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "pea_from_crate"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.SOY, 9)
                .requires(DDModItems.SOY_CRATE.get())
                .unlockedBy("has_soy_crate", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.SOY_CRATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "soy_from_crate"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.CORN, 9)
                .requires(DDModItems.CORN_CRATE.get())
                .unlockedBy("has_corn_crate", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.CORN_CRATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "corn_from_crate"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.OATS, 9)
                .requires(DDModItems.OAT_BALE.get())
                .unlockedBy("has_oat_bale", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.OAT_BALE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "oats_from_bale"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.BELL_PEPPER_SEEDS.get())
                .requires(DDModItems.BELL_PEPPER.get())
                .unlockedBy("has_bell_pepper", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.BELL_PEPPER.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.CHILI_SEEDS.get())
                .requires(DDModItems.CHILI.get())
                .unlockedBy("has_chili", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.CHILI.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.GREEN_BEAN_SEEDS.get())
                .requires(DDModItems.GREEN_BEAN.get())
                .unlockedBy("has_green_bean", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.GREEN_BEAN.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.PEA_SEEDS.get())
                .requires(DDModItems.PEA.get())
                .unlockedBy("has_pea", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PEA.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.CORN_KERNELS.get(),2)
                .requires(DDModItems.CORN.get())
                .unlockedBy("has_corn", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.CORN.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.APPLE, 9)
                .requires(DDModItems.APPLE_BAG.get())
                .unlockedBy("has_apple_bag", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.APPLE_BAG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "apple_from_bag"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.BANANA, 9)
                .requires(DDModItems.BANANA_BAG.get())
                .unlockedBy("has_banana_bag", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.BANANA_BAG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "banana_from_bag"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.ORANGE, 9)
                .requires(DDModItems.ORANGE_BAG.get())
                .unlockedBy("has_orange_bag", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.ORANGE_BAG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "orange_from_bag"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.KIWI, 9)
                .requires(DDModItems.KIWI_BAG.get())
                .unlockedBy("has_kiwi_bag", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.KIWI_BAG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "kiwi_from_bag"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.LEMON, 9)
                .requires(DDModItems.LEMON_BAG.get())
                .unlockedBy("has_lemon_bag", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.LEMON_BAG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "lemon_from_bag"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.PEAR, 9)
                .requires(DDModItems.PEAR_BAG.get())
                .unlockedBy("has_pear_bag", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PEAR_BAG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "pear_from_bag"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.MANGO, 9)
                .requires(DDModItems.MANGO_BAG.get())
                .unlockedBy("has_mango_bag", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.MANGO_BAG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "mango_from_bag"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.PINEAPPLE, 9)
                .requires(DDModItems.PINEAPPLE_BAG.get())
                .unlockedBy("has_pineapple_bag", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PINEAPPLE_BAG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "pineapple_from_bag"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.ALMOND, 9)
                .requires(DDModItems.ALMOND_BAG.get())
                .unlockedBy("has_almond_bag", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.ALMOND_BAG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "almond_from_bag"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.PEANUT, 9)
                .requires(DDModItems.PEANUT_BAG.get())
                .unlockedBy("has_peanut_bag", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PEANUT_BAG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "peanut_from_bag"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.PISTACHIO, 9)
                .requires(DDModItems.PISTACHIO_BAG.get())
                .unlockedBy("has_pistachio_bag", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PISTACHIO_BAG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "pistachio_from_bag"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.WALNUT, 9)
                .requires(DDModItems.WALNUT_BAG.get())
                .unlockedBy("has_walnut_bag", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.WALNUT_BAG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "walnut_from_bag"));
    }

    private static void recipesFoodstuffs(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.KETCHUP.get(), 1)
                .requires(ModItems.TOMATO_SAUCE.get())
                .requires(CommonTags.CROPS_ONION)
                .requires(ModItems.TOMATO_SAUCE.get())
                .requires(Items.SUGAR)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_tomato_sauce", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TOMATO_SAUCE.get()))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.MAYONNAISE.get(), 1)
                .requires(Items.EGG)
                .requires(Items.EGG)
                .requires(ModItems.APPLE_CIDER.get())
                .requires(ModItems.APPLE_CIDER.get())
                .requires(Items.SUNFLOWER)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_egg", InventoryChangeTrigger.TriggerInstance.hasItems(Items.EGG))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.HOT_SAUCE.get(), 1)
                .requires(DDModItems.SOY_BEANS.get())
                .requires(DDModItems.SOY_BEANS.get())
                .requires(DDModItems.SOY_BEANS.get())
                .requires(Items.WHEAT)
                .requires(Items.WHEAT)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_soy", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.SOY.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.MARMALADE.get(), 1)
                .requires(DDModItems.ORANGE.get())
                .requires(DDModItems.ORANGE.get())
                .requires(DDModItems.ORANGE.get())
                .requires(DDModItems.LEMON.get())
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_orange", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.ORANGE.get()))
                .save(output);
    }

    private static void recipesCraftedMeals(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.BACON_WRAPPED_GREEN_BEANS.get(), 1)
                .requires(DDModItems.GREEN_BEAN.get())
                .requires(DDModItems.GREEN_BEAN.get())
                .requires(DDModItems.GREEN_BEAN.get())
                .requires(ModItems.COOKED_BACON.get())
                .requires(ModItems.COOKED_BACON.get())
                .unlockedBy("has_green_bean", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.GREEN_BEAN.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.BEEF_TACO.get(), 1)
                .requires(DDModItems.TACO_SHELL.get())
                .requires(CommonTags.FOODS_COOKED_BEEF)
                .requires(DDModItems.CHILI.get())
                .requires(ModItems.TOMATO.get())
                .requires(CommonTags.FOODS_CABBAGE)
                .unlockedBy("has_corn", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.CORN.get()))
                .save(output);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.VEGETABLE_STICKS_BLOCK.get(), 1)
                .requires(DDModItems.CELERY.get())
                .requires(DDModItems.BELL_PEPPER.get())
                .requires(DDModItems.PEA_SEEDS.get())
                .requires(DDModItems.PEA_SEEDS.get())
                .requires(Items.CARROT)
                .requires(Items.BOWL)
                .unlockedBy("has_celery", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.CELERY.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, DDModItems.BANANA_BREAD.get(),1)
                .pattern("beb")
                .pattern("www")
                .define('w', Items.WHEAT)
                .define('b', DDModItems.BANANA.get())
                .define('e', Items.EGG)
                .unlockedBy("has_banana", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.BANANA.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.BANANA_CHIPS.get(), 1)
                .requires(DDModItems.BANANA.get())
                .requires(DDModItems.BANANA.get())
                .requires(DDModItems.LEMON.get())
                .requires(Items.BOWL)
                .unlockedBy("has_banana", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.BANANA.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.CEREAL_BOWL.get(), 1)
                .requires(DDModItems.KIWI.get())
                .requires(DDModItems.BANANA.get())
                .requires(DDModItems.OATS.get())
                .requires(Items.SWEET_BERRIES)
                .requires(Items.SWEET_BERRIES)
                .requires(CommonTags.FOODS_MILK)
                .requires(Items.BOWL)
                .unlockedBy("has_kiwi", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.KIWI.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.CORNBREAD.get(), 1)
                .requires(DDModItems.CORN.get())
                .requires(DDModItems.CORN.get())
                .requires(DDModItems.CORN.get())
                .requires(Items.EGG)
                .unlockedBy("has_corn", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.CORN.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.GRANOLA_BAR.get(), 1)
                .requires(DDModItems.OATS.get())
                .requires(DDModItems.WALNUT.get())
                .requires(DDModItems.PISTACHIO.get())
                .requires(DDModItems.ALMOND.get())
                .requires(DDModItems.PEANUT.get())
                .requires(Items.SWEET_BERRIES)
                .unlockedBy("has_oats", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.OATS.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.ICE_CREAM_CONE.get(), 3)
                .requires(Items.EGG)
                .requires(Items.WHEAT)
                .requires(CommonTags.FOODS_MILK)
                .unlockedBy("has_wheat", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.OATMEAL_COOKIE.get(), 3)
                .requires(DDModItems.OATS.get())
                .requires(DDModItems.OATS.get())
                .requires(DDModItems.OATS.get())
                .requires(Items.SUGAR)
                .requires(Items.SWEET_BERRIES)
                .unlockedBy("has_oats", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.OATS.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.FRUIT_ROLLUP.get(), 3)
                .requires(Items.APPLE)
                .requires(DDModItems.PEAR.get())
                .requires(Items.APPLE)
                .requires(DDModItems.PEAR.get())
                .requires(DDModItems.LEMON.get())
                .requires(Items.SUGAR)
                .unlockedBy("has_pear", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PEAR.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.ORANGE_JUICE.get(), 1)
                .requires(DDModItems.ORANGE.get())
                .requires(DDModItems.ORANGE.get())
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_orange", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.ORANGE.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.TACO_SHELL.get(), 2)
                .requires(DDModItems.CORN)
                .requires(DDModItems.CORN)
                .requires(DDModItems.CORN)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_corn", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.CORN.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.TOFU.get(), 2)
                .requires(DDModItems.SOY_BEANS)
                .requires(DDModItems.SOY_BEANS)
                .requires(DDModItems.SOY_BEANS)
                .requires(DDModItems.SOY_BEANS)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_soy", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.SOY.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.TRAIL_MIX.get(), 3)
                .requires(DDModItems.PEANUT)
                .requires(DDModItems.PEANUT)
                .requires(DDModItems.PISTACHIO)
                .requires(DDModItems.PISTACHIO)
                .requires(DDModItems.WALNUT)
                .requires(DDModItems.WALNUT)
                .requires(DDModItems.ALMOND)
                .requires(DDModItems.ALMOND)
                .requires(Items.PUMPKIN_SEEDS)
                .unlockedBy("has_peanut", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PEANUT.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.TROPICAL_SALAD.get(), 1)
                .requires(DDCommonTags.CROPS_PINEAPPLE)
                .requires(DDCommonTags.FOODS_KIWI)
                .requires(DDCommonTags.FOODS_BANANA)
                .requires(DDCommonTags.FOODS_MANGO)
                .requires(DDModItems.ORANGE.get())
                .requires(Items.BOWL)
                .unlockedBy("has_pineapple", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PINEAPPLE.get()))
                .save(output);
    }

    private static void recipesFoodBlocks(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, DDModItems.PEAR_PIE.get(), 1)
                .pattern("###")
                .pattern("ppp")
                .pattern("xOx")
                .define('#', Items.WHEAT)
                .define('p', DDModItems.PEAR.get())
                .define('x', Items.SUGAR)
                .define('O', ModItems.PIE_CRUST.get())
                .unlockedBy("has_pie_crust", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PIE_CRUST.get()))
                .group("dd_pear_pie")
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, DDModItems.PEAR_PIE.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', DDModItems.PEAR_PIE_SLICE.get())
                .unlockedBy("has_pear_pie_slice", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PEAR_PIE_SLICE.get()))
                .group("dd_pear_pie")
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "pear_pie_from_slices"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, DDModItems.HAWAIIAN_PIZZA.get(), 1)
                .pattern("eme")
                .pattern("php")
                .pattern("###")
                .define('#', Items.WHEAT)
                .define('m', CommonTags.FOODS_MILK)
                .define('p', DDModItems.PINEAPPLE.get())
                .define('h', ModItems.HAM.get())
                .define('e', Items.EGG)
                .unlockedBy("has_pineapple", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PINEAPPLE.get()))
                .group("dd_hawaiian_pizza")
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, DDModItems.HAWAIIAN_PIZZA.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', DDModItems.HAWAIIAN_PIZZA_SLICE.get())
                .unlockedBy("has_hawaiian_pizza_slice",
                        InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.HAWAIIAN_PIZZA_SLICE.get()))
                .group("dd_hawaiian_pizza")
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "hawaiian_pizza_from_slices"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, DDModItems.LEMON_MERINGUE_PIE.get(), 1)
                .pattern("###")
                .pattern("lel")
                .pattern("xOx")
                .define('#', Items.WHEAT)
                .define('l', DDModItems.LEMON.get())
                .define('e', Items.EGG)
                .define('x', CommonTags.FOODS_MILK)
                .define('O', ModItems.PIE_CRUST.get())
                .unlockedBy("has_pie_crust", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PIE_CRUST.get()))
                .group("dd_lemon_meringue_pie")
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, DDModItems.LEMON_MERINGUE_PIE.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', DDModItems.LEMON_MERINGUE_PIE_SLICE.get())
                .unlockedBy("has_lemon_meringue_pie_slice", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.LEMON_MERINGUE_PIE_SLICE.get()))
                .group("dd_lemon_meringue_pie")
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "lemon_meringue_pie_from_slices"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, DDModItems.FRUIT_FLAN.get(), 1)
                .pattern("sss")
                .pattern("kmk")
                .pattern("xOx")
                .define('s', Items.SWEET_BERRIES)
                .define('k', DDModItems.KIWI.get())
                .define('m', DDModItems.MANGO.get())
                .define('x', Items.SUGAR)
                .define('O', ModItems.PIE_CRUST.get())
                .unlockedBy("has_pie_crust", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PIE_CRUST.get()))
                .group("dd_fruit_flan")
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, DDModItems.FRUIT_FLAN.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', DDModItems.FRUIT_FLAN_SLICE.get())
                .unlockedBy("has_fruit_flan_slice", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.FRUIT_FLAN_SLICE.get()))
                .group("dd_fruit_flan")
                .save(output, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "fruit_flan_from_slices"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, DDModItems.EMERALD_PEAR.get(), 1)
                .pattern("eee")
                .pattern("epe")
                .pattern("eee")
                .define('e', Items.EMERALD)
                .define('p', DDModItems.PEAR.get())
                .unlockedBy("has_pear", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PEAR.get()))
                .save(output);
    }

    private static void recipesItems(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, DDModItems.FRUIT_PROBE.get(), 1)
                .pattern("ccc")
                .pattern("cac")
                .pattern("crc")
                .define('c', Items.COPPER_INGOT)
                .define('a', Items.AMETHYST_SHARD)
                .define('r', Items.REDSTONE)
                .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(output);
    }

}
