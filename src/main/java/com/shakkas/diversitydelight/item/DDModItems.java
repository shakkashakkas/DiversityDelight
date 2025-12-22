package com.shakkas.diversitydelight.item;


import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.block.ModBlocks;
import com.shakkas.diversitydelight.component.ModComponents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class DDModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DiversityDelight.MODID);

    //CROPS
    public static final DeferredItem<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BANANA)));
    public static final DeferredItem<Item> BELL_PEPPER = ITEMS.register("bell_pepper",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BELL_PEPPER)));
    public static final DeferredItem<Item> BELL_PEPPER_SEEDS = ITEMS.register("bell_pepper_seeds",
            () -> new ItemNameBlockItem(ModBlocks.LOWER_BELL_PEPPER_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> BROCCOLI = ITEMS.register("broccoli",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BROCCOLI)));
    public static final DeferredItem<Item> BROCCOLI_FLORET = ITEMS.register("broccoli_floret",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BROCCOLI_FLORET)));
    public static final DeferredItem<Item> BROCCOLI_SEEDS = ITEMS.register("broccoli_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BROCCOLI_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> CAULIFLOWER = ITEMS.register("cauliflower",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CAULIFLOWER)));
    public static final DeferredItem<Item> CAULIFLOWER_FLORET = ITEMS.register("cauliflower_floret",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CAULIFLOWER_FLORET)));
    public static final DeferredItem<Item> CAULIFLOWER_SEEDS = ITEMS.register("cauliflower_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CAULIFLOWER_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> CELERY = ITEMS.register("celery",
            () -> new ItemNameBlockItem(ModBlocks.CELERY_CROP.get(), new Item.Properties().food(ModFoodProperties.CELERY)));
    public static final DeferredItem<Item> CHILI = ITEMS.register("chili",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHILI)));
    public static final DeferredItem<Item> CHILI_SEEDS = ITEMS.register("chili_seeds",
            () -> new ItemNameBlockItem(ModBlocks.LOWER_CHILI_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> GREEN_BEAN = ITEMS.register("green_bean",
            () -> new Item(new Item.Properties().food(ModFoodProperties.GREEN_BEAN)));
    public static final DeferredItem<Item> GREEN_BEAN_SEEDS = ITEMS.register("green_bean_seeds",
            () -> new ItemNameBlockItem(ModBlocks.LOWER_GREEN_BEAN_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> KIWI = ITEMS.register("kiwi",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KIWI)));
    public static final DeferredItem<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(new Item.Properties().food(ModFoodProperties.LEMON)));
    public static final DeferredItem<Item> MANGO = ITEMS.register("mango",
            () -> new Item(new Item.Properties().food(ModFoodProperties.MANGO)));
    public static final DeferredItem<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food(ModFoodProperties.ORANGE)));
    public static final DeferredItem<Item> PEA = ITEMS.register("pea",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PEA)));
    public static final DeferredItem<Item> PEA_SEEDS = ITEMS.register("pea_seeds",
            () -> new ItemNameBlockItem(ModBlocks.LOWER_PEA_CROP.get(), new Item.Properties().food(ModFoodProperties.PEA_SEEDS)));
    public static final DeferredItem<Item> PEAR = ITEMS.register("pear",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PEAR)));
    public static final DeferredItem<Item> PINEAPPLE = ITEMS.register("pineapple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PINEAPPLE)));

    //FOODS
    //HANDHELD
    public static final DeferredItem<Item> BACON_WRAPPED_GREEN_BEANS = ITEMS.register("bacon_wrapped_green_beans",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BACON_WRAPPED_GREEN_BEANS)));
    public static final DeferredItem<Item> FRITATA = ITEMS.register("fritata",
            () -> new Item(new Item.Properties().food(ModFoodProperties.FRITATA)));
    public static final DeferredItem<Item> SMASHED_PEAS_ON_TOAST = ITEMS.register("smashed_peas_on_toast",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SMASHED_PEAS_ON_TOAST)));
    public static final DeferredItem<Item> STUFFED_BELL_PEPPER = ITEMS.register("stuffed_bell_pepper",
            () -> new Item(new Item.Properties().food(ModFoodProperties.STUFFED_BELL_PEPPER)));
    public static final DeferredItem<Item> VEGETABLE_STICKS = ITEMS.register("vegetable_sticks",
            () -> new Item(new Item.Properties().food(ModFoodProperties.VEGETABLE_STICKS)));

    //BOWLS
    public static final DeferredItem<Item> CAULIFLOWER_SOUP = ITEMS.register("cauliflower_soup",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.CAULIFLOWER_SOUP).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> CHILI_BEAN_SOUP = ITEMS.register("chili_bean_soup",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.CHILI_BEAN_SOUP).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> GUMBO = ITEMS.register("gumbo",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.GUMBO).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> TERIYAKI_CHICKEN = ITEMS.register("teriyaki_chicken",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.TERIYAKI_CHICKEN).craftRemainder(Items.BOWL).stacksTo(16),true));

    //PLATES
    public static final DeferredItem<Item> BUFFALO_WINGS = ITEMS.register("buffalo_wings",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.BUFFALO_WINGS).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> CAULIFLOWER_STEAK = ITEMS.register("cauliflower_steak",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.CAULIFLOWER_STEAK).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> CHICKEN_POT_PIE_BLOCK = ITEMS.register("chicken_pot_pie_block",
            () -> new BlockItem(ModBlocks.CHICKEN_POT_PIE_BLOCK.get(), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> CHICKEN_POT_PIE = ITEMS.register("chicken_pot_pie",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.CHICKEN_POT_PIE).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> GREEN_BEAN_CASSEROLE = ITEMS.register("green_bean_casserole",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.GREEN_BEAN_CASSEROLE).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> GREEN_BEAN_STIR_FRY = ITEMS.register("green_bean_stir_fry",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.GREEN_BEAN_STIR_FRY).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> MIXED_VEGETABLE_MEDLEY = ITEMS.register("mixed_vegetable_medley",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.MIXED_VEGETABLE_MEDLEY).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> PEA_PESTO_PASTA = ITEMS.register("pea_pesto_pasta",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.PEA_PESTO_PASTA).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> VEGETABLE_STICKS_BLOCK = ITEMS.register("vegetable_sticks_block",
            () -> new BlockItem(ModBlocks.VEGETABLE_STICKS_BLOCK.get(), new Item.Properties().stacksTo(1)));

    //CONDIMENTS
    public static final DeferredItem<Item> KETCHUP = ITEMS.register("ketchup",
            () -> new CondimentItem(new Item.Properties().durability(16).component(ModComponents.CONDIMENT_PROPERTIES,ModCondimentProperties.KETCHUP)));
    public static final DeferredItem<Item> MAYONNAISE = ITEMS.register("mayonnaise",
            () -> new CondimentItem(new Item.Properties().durability(16).component(ModComponents.CONDIMENT_PROPERTIES,ModCondimentProperties.MAYONNAISE)));
    public static final DeferredItem<Item> HOT_SAUCE = ITEMS.register("hot_sauce",
            () -> new CondimentItem(new Item.Properties().durability(16).component(ModComponents.CONDIMENT_PROPERTIES,ModCondimentProperties.HOT_SAUCE)));

    // BLOCKS
    public static final DeferredItem<BlockItem> WORM_BIN_BLOCK = ITEMS.register("worm_bin_block",
            () -> new BlockItem(ModBlocks.WORM_BIN_BLOCK.get(), new Item.Properties()));

    // Crop Crates
    public static final DeferredItem<BlockItem> BELL_PEPPER_CRATE = ITEMS.register("bell_pepper_crate",
            () -> new BlockItem(ModBlocks.BELL_PEPPER_CRATE.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> BROCCOLI_CRATE = ITEMS.register("broccoli_crate",
            () -> new BlockItem(ModBlocks.BROCCOLI_CRATE.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> CAULIFLOWER_CRATE = ITEMS.register("cauliflower_crate",
            () -> new BlockItem(ModBlocks.CAULIFLOWER_CRATE.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> CELERY_CRATE = ITEMS.register("celery_crate",
            () -> new BlockItem(ModBlocks.CELERY_CRATE.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> CHILI_CRATE = ITEMS.register("chili_crate",
            () -> new BlockItem(ModBlocks.CHILI_CRATE.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> GREEN_BEAN_CRATE = ITEMS.register("green_bean_crate",
            () -> new BlockItem(ModBlocks.GREEN_BEAN_CRATE.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> PEA_CRATE = ITEMS.register("pea_crate",
            () -> new BlockItem(ModBlocks.PEA_CRATE.get(), new Item.Properties()));

    //Fruit Trees
    public static final DeferredItem<BlockItem> ORANGE_TREE_SAPLING = ITEMS.register("orange_tree_sapling",
            () -> new BlockItem(ModBlocks.ORANGE_TREE_SAPLING.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> ORANGE_TREE_LOG = ITEMS.register("orange_tree_log",
            () -> new BlockItem(ModBlocks.ORANGE_TREE_LOG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> ORANGE_TREE_LEAVES = ITEMS.register("orange_tree_leaves",
            () -> new BlockItem(ModBlocks.ORANGE_TREE_LEAVES.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> ORANGE_TREE_FRUITING_LEAVES = ITEMS.register("orange_tree_fruiting_leaves",
            () -> new BlockItem(ModBlocks.ORANGE_TREE_FRUITING_LEAVES.get(), new Item.Properties()));

    //Wild Crops
    public static final DeferredItem<BlockItem> WILD_BELL_PEPPER = ITEMS.register("wild_bell_pepper",
            () -> new BlockItem(ModBlocks.WILD_BELL_PEPPER.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> WILD_BROCCOLI = ITEMS.register("wild_broccoli",
            () -> new BlockItem(ModBlocks.WILD_BROCCOLI.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> WILD_CAULIFLOWER = ITEMS.register("wild_cauliflower",
            () -> new BlockItem(ModBlocks.WILD_CAULIFLOWER.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> WILD_CELERY = ITEMS.register("wild_celery",
            () -> new BlockItem(ModBlocks.WILD_CELERY.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> WILD_CHILI = ITEMS.register("wild_chili",
            () -> new BlockItem(ModBlocks.WILD_CHILI.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> WILD_GREEN_BEAN = ITEMS.register("wild_green_bean",
            () -> new BlockItem(ModBlocks.WILD_GREEN_BEAN.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> WILD_PEA = ITEMS.register("wild_pea",
            () -> new BlockItem(ModBlocks.WILD_PEA.get(), new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
