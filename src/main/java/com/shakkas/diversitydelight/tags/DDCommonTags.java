package com.shakkas.diversitydelight.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DDCommonTags {
    public static final TagKey<Block> STORAGE_BLOCKS_BELL_PEPPER = commonBlockTag("storage_blocks/bell_pepper");
    public static final TagKey<Block> STORAGE_BLOCKS_BROCCOLI = commonBlockTag("storage_blocks/broccoli");
    public static final TagKey<Block> STORAGE_BLOCKS_CAULIFLOWER = commonBlockTag("storage_blocks/cauliflower");
    public static final TagKey<Block> STORAGE_BLOCKS_CELERY = commonBlockTag("storage_blocks/celery");
    public static final TagKey<Block> STORAGE_BLOCKS_CHILI = commonBlockTag("storage_blocks/chili");
    public static final TagKey<Block> STORAGE_BLOCKS_GREEN_BEAN = commonBlockTag("storage_blocks/green_bean");
    public static final TagKey<Block> STORAGE_BLOCKS_PEA = commonBlockTag("storage_blocks/pea");

    public static final TagKey<Block> STORAGE_BLOCKS_APPLE = commonBlockTag("storage_blocks/apple");
    public static final TagKey<Block> STORAGE_BLOCKS_BANANA = commonBlockTag("storage_blocks/banana");
    public static final TagKey<Block> STORAGE_BLOCKS_ORANGE = commonBlockTag("storage_blocks/orange");
    public static final TagKey<Block> STORAGE_BLOCKS_LEMON = commonBlockTag("storage_blocks/lemon");
    public static final TagKey<Block> STORAGE_BLOCKS_MANGO = commonBlockTag("storage_blocks/mango");
    public static final TagKey<Block> STORAGE_BLOCKS_PINEAPPLE = commonBlockTag("storage_blocks/pineapple");
    public static final TagKey<Block> STORAGE_BLOCKS_PEAR = commonBlockTag("storage_blocks/pear");
    public static final TagKey<Block> STORAGE_BLOCKS_KIWI = commonBlockTag("storage_blocks/kiwi");


    public static final TagKey<Item> FOODS_BELL_PEPPER = commonItemTag("foods/bell_pepper");
    public static final TagKey<Item> FOODS_BROCCOLI = commonItemTag("foods/broccoli");
    public static final TagKey<Item> FOODS_CAULIFLOWER = commonItemTag("foods/cauliflower");
    public static final TagKey<Item> FOODS_CELERY = commonItemTag("foods/celery");
    public static final TagKey<Item> FOODS_CHILI = commonItemTag("foods/chili");
    public static final TagKey<Item> FOODS_GREEN_BEAN = commonItemTag("foods/green_bean");
    public static final TagKey<Item> FOODS_PEA = commonItemTag("foods/pea");

    public static final TagKey<Item> FOODS_ORANGE = commonItemTag("foods/orange");
    public static final TagKey<Item> FOODS_BANANA = commonItemTag("foods/banana");
    public static final TagKey<Item> FOODS_LEMON = commonItemTag("foods/lemon");
    public static final TagKey<Item> FOODS_MANGO = commonItemTag("foods/mango");
    public static final TagKey<Item> FOODS_KIWI = commonItemTag("foods/kiwi");
    public static final TagKey<Item> FOODS_PEAR = commonItemTag("foods/pear");
    public static final TagKey<Item> FOODS_PINEAPPLE = commonItemTag("foods/pineapple");


    public static final TagKey<Item> CROPS_BELL_PEPPER = commonItemTag("crops/bell_pepper");
    public static final TagKey<Item> CROPS_BROCCOLI = commonItemTag("crops/broccoli");
    public static final TagKey<Item> CROPS_CAULIFLOWER = commonItemTag("crops/cauliflower");
    public static final TagKey<Item> CROPS_CELERY = commonItemTag("crops/celery");
    public static final TagKey<Item> CROPS_CHILI = commonItemTag("crops/chili");
    public static final TagKey<Item> CROPS_GREEN_BEAN = commonItemTag("crops/green_bean");
    public static final TagKey<Item> CROPS_PEA = commonItemTag("crops/pea");

    public static final TagKey<Item> CROPS_ORANGE = commonItemTag("crops/orange");
    public static final TagKey<Item> CROPS_BANANA = commonItemTag("crops/banana");
    public static final TagKey<Item> CROPS_LEMON = commonItemTag("crops/lemon");
    public static final TagKey<Item> CROPS_MANGO = commonItemTag("crops/mango");
    public static final TagKey<Item> CROPS_KIWI = commonItemTag("crops/kiwi");
    public static final TagKey<Item> CROPS_PEAR = commonItemTag("crops/pear");
    public static final TagKey<Item> CROPS_PINEAPPLE = commonItemTag("crops/pineapple");


    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_BELL_PEPPER = commonItemTag("storage_blocks/bell_pepper");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_BROCCOLI = commonItemTag("storage_blocks/broccoli");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_CAULIFLOWER = commonItemTag("storage_blocks/cauliflower");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_CELERY = commonItemTag("storage_blocks/celery");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_CHILI = commonItemTag("storage_blocks/chili");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_GREEN_BEAN = commonItemTag("storage_blocks/green_bean");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_PEA = commonItemTag("storage_blocks/pea");

    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_APPLE = commonItemTag("storage_blocks/apple");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_BANANA = commonItemTag("storage_blocks/banana");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_ORANGE = commonItemTag("storage_blocks/orange");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_LEMON = commonItemTag("storage_blocks/lemon");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_MANGO = commonItemTag("storage_blocks/mango");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_PINEAPPLE = commonItemTag("storage_blocks/pineapple");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_PEAR = commonItemTag("storage_blocks/pear");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_KIWI = commonItemTag("storage_blocks/kiwi");

    public static final TagKey<Item> FOODS_LEAFY_GREEN = commonItemTag("foods/leafy_green");

    private static TagKey<Block> commonBlockTag(String path) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }

    private static TagKey<Item> commonItemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }
}
