package com.shakkas.diversitydelight.datagen;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.block.ModBlocks;
import com.shakkas.diversitydelight.item.DDModItems;
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

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WORM_BIN_BLOCK.get())
                .pattern("CgC")
                .pattern("gcg")
                .pattern("CgC")
                .define('c', Items.COMPOSTER)
                .define('g', Items.GREEN_DYE)
                .define('C', Items.COPPER_INGOT)
                .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(output);
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
                .requires(DDModItems.CHILI.get())
                .requires(DDModItems.CHILI.get())
                .requires(DDModItems.BELL_PEPPER.get())
                .requires(ModItems.APPLE_CIDER.get())
                .requires(ModItems.ONION.get())
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_chili", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.CHILI.get()))
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDModItems.SMASHED_PEAS_ON_TOAST.get(), 1)
                .requires(DDModItems.PEA_SEEDS.get())
                .requires(DDModItems.PEA_SEEDS.get())
                .requires(ModItems.FRIED_EGG.get())
                .requires(Items.BREAD)
                .unlockedBy("has_pea", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.PEA.get()))
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
    }
}
