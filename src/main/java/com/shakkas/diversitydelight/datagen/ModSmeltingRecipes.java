package com.shakkas.diversitydelight.datagen;

import com.shakkas.diversitydelight.item.DDModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

public class ModSmeltingRecipes {
    public static void register(RecipeOutput output) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDModItems.TOFU.get()), RecipeCategory.FOOD,
                        DDModItems.COOKED_TOFU.get(), 0.35F, 200)
                .unlockedBy("has_tofu", InventoryChangeTrigger.TriggerInstance.hasItems(DDModItems.TOFU.get()))
                .save(output);
    }
}
