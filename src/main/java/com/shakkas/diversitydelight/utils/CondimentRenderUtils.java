package com.shakkas.diversitydelight.utils;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class CondimentRenderUtils {
    public static final String CATEGORY = "condiment";
    public static final String BOWL = "bowl";
    public static ModelResourceLocation getModel(ItemStack stack) {
        String modelId = getModelTypeId(stack);
        ResourceLocation loc = ResourceLocation.fromNamespaceAndPath("diversitydelight","item/"+modelId);
        return ModelResourceLocation.standalone(loc);
    }

    public static String getModelTypeId(ItemStack stack) {
        String base = TagUtils.getString(stack, CATEGORY);
        boolean hasBowlRemainingItem = stack.getItem().getCraftingRemainingItem() == Items.BOWL;
        return (hasBowlRemainingItem) ? (base + "_" + BOWL + "_overlay") : (base + "_overlay");
    }
}
