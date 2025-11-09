package com.shakkas.diversitydelight.utils;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

public class TagUtils {
    public static boolean hasList(ItemStack stack, String category) {
        CustomData data = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        if (data.isEmpty()) {return false;}
        CompoundTag root = data.copyTag();
        return root.contains(category, Tag.TAG_LIST);
    }

    public static boolean listHasString(ItemStack stack, String category, String item) {
        CustomData data = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        if (data.isEmpty()) {return false;}
        ListTag targetList = getList(stack, category);
        if (targetList == null) {return false;}
        for (int i = 0; i < targetList.size(); i++) {
            if (targetList.getString(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    public static ListTag getList(ItemStack stack, String category) {
        CustomData data = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        if (data.isEmpty()) {return null;}
        CompoundTag root = data.copyTag();
        if (!root.contains(category, Tag.TAG_LIST)) {return null;}
        return root.getList(category, Tag.TAG_STRING);
    }

    public static boolean hasString(ItemStack stack, String category) {
        CustomData data = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        if (data.isEmpty()) {return false;}
        CompoundTag root = data.copyTag();
        return !root.getString(category).isEmpty();
    }

    public static String getString(ItemStack stack, String category) {
        CustomData data = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        CompoundTag root = data.copyTag();
        if (!(hasString(stack,category))) {
            return "";
        }
        return root.getString(category);
    }
}
