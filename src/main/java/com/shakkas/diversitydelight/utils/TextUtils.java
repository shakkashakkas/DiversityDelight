package com.shakkas.diversitydelight.utils;

import java.util.List;
import java.util.function.Consumer;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class TextUtils {
    public static void addCondimentTooltip(ItemStack stack, Consumer<Component> tooltipAdder, List<Component> tooltipComponents) {
        String category = "condiment";

        String condimentType = TagUtils.getString(stack,category);
        if (tooltipComponents.size() > 1) {
            tooltipAdder.accept(CommonComponents.EMPTY);
        }

        tooltipAdder.accept(Component.translatable("tooltip.diversitydelight.condiments").withStyle(ChatFormatting.DARK_GRAY));
        tooltipAdder.accept(Component.translatable("tooltip.diversitydelight."+ condimentType).withStyle(ChatFormatting.DARK_BLUE));
    }
}
