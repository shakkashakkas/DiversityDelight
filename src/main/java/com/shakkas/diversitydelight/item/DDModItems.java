package com.shakkas.diversitydelight.item;


import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.block.ModBlocks;
import com.shakkas.diversitydelight.component.FruitProbeMode;
import com.shakkas.diversitydelight.component.ModComponents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomModelData;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class DDModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DiversityDelight.MODID);

    //CROPS
    public static final DeferredItem<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BANANA)));
    public static final DeferredItem<Item> BELL_PEPPER = ITEMS.register("bell_pepper",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BELL_PEPPER)));
    public static final DeferredItem<Item> BELL_PEPPER_SEEDS = ITEMS.register("bell_pepper_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BELL_PEPPER_CROP.get(), new Item.Properties()));
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
            () -> new ItemNameBlockItem(ModBlocks.CHILI_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> GREEN_BEAN = ITEMS.register("green_bean",
            () -> new Item(new Item.Properties().food(ModFoodProperties.GREEN_BEAN)));
    public static final DeferredItem<Item> GREEN_BEAN_SEEDS = ITEMS.register("green_bean_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GREEN_BEAN_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> KIWI = ITEMS.register("kiwi",
            () -> new ItemNameBlockItem(ModBlocks.KIWI_BUDDING_CROP.get(),new Item.Properties().food(ModFoodProperties.KIWI)));
    public static final DeferredItem<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(new Item.Properties().food(ModFoodProperties.LEMON)));
    public static final DeferredItem<Item> MANGO = ITEMS.register("mango",
            () -> new Item(new Item.Properties().food(ModFoodProperties.MANGO)));
    public static final DeferredItem<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food(ModFoodProperties.ORANGE)));
    public static final DeferredItem<Item> PEA = ITEMS.register("pea",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PEA)));
    public static final DeferredItem<Item> PEA_SEEDS = ITEMS.register("pea_seeds",
            () -> new ItemNameBlockItem(ModBlocks.PEA_CROP.get(), new Item.Properties().food(ModFoodProperties.PEA_SEEDS)));
    public static final DeferredItem<Item> PEAR = ITEMS.register("pear",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PEAR)));
    public static final DeferredItem<Item> PINEAPPLE = ITEMS.register("pineapple",
            () -> new ItemNameBlockItem(ModBlocks.PINEAPPLE_CROP.get(),new Item.Properties().food(ModFoodProperties.PINEAPPLE)));
    public static final DeferredItem<Item> PINEAPPLE_SLICE = ITEMS.register("pineapple_slice",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PINEAPPLE_SLICE)));

    //SPECIAL CROPS
    public static final DeferredItem<Item> EMERALD_PEAR = ITEMS.register("emerald_pear",
            () -> new Item(new Item.Properties().food(ModFoodProperties.EMERALD_PEAR).rarity(Rarity.RARE)));

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

    //HH - FRUITS AND CONFECTIONERIES
    public static final DeferredItem<Item> BANANA_BREAD = ITEMS.register("banana_bread",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BANANA_BREAD)));
    public static final DeferredItem<Item> FRUIT_ROLLUP = ITEMS.register("fruit_rollup",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.FRUIT_ROLLUP),true));
    public static final DeferredItem<Item> POACHED_PEAR = ITEMS.register("poached_pear",
            () -> new Item(new Item.Properties().food(ModFoodProperties.POACHED_PEAR)));
    public static final DeferredItem<Item> LEMON_JELLY = ITEMS.register("lemon_jelly",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.JELLY),true));
    public static final DeferredItem<Item> MANGO_JELLY = ITEMS.register("mango_jelly",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.JELLY),true));
    public static final DeferredItem<Item> KIWI_JELLY = ITEMS.register("kiwi_jelly",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.JELLY),true));
    public static final DeferredItem<Item> ICE_CREAM_CONE = ITEMS.register("ice_cream_cone",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.ICE_CREAM_CONE),true));
    public static final DeferredItem<Item> LEMON_ICE_CREAM = ITEMS.register("lemon_ice_cream",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.LEMON_ICE_CREAM),true));
    public static final DeferredItem<Item> MANGO_ICE_CREAM = ITEMS.register("mango_ice_cream",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.MANGO_ICE_CREAM),true));
    public static final DeferredItem<Item> CHOCOLATE_ICE_CREAM = ITEMS.register("chocolate_ice_cream",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.CHOCOLATE_ICE_CREAM),true));
    public static final DeferredItem<Item> ORANGE_JUICE = ITEMS.register("orange_juice",
            () -> new DrinkableItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(ModFoodProperties.ORANGE_JUICE),true));
    public static final DeferredItem<Item> PINEAPPLE_JUICE = ITEMS.register("pineapple_juice",
            () -> new DrinkableItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(ModFoodProperties.PINEAPPLE_JUICE),true));
    public static final DeferredItem<Item> BANANA_MILK = ITEMS.register("banana_milk",
            () -> new DrinkableItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(ModFoodProperties.BANANA_MILK),true));
    public static final DeferredItem<Item> MANGO_YOGHURT = ITEMS.register("mango_yoghurt",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.YOGHURT),true));
    public static final DeferredItem<Item> ORANGE_YOGHURT = ITEMS.register("orange_yoghurt",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.YOGHURT),true));

    public static final DeferredItem<Item> HAWAIIAN_PIZZA = ITEMS.register("hawaiian_pizza",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PINEAPPLE)));
    public static final DeferredItem<Item> BANOFFEE_PIE = ITEMS.register("banoffee_pie",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BANANA)));
    public static final DeferredItem<Item> LEMON_MERINGUE_PIE = ITEMS.register("lemon_meringue_pie",
            () -> new Item(new Item.Properties().food(ModFoodProperties.LEMON)));
    public static final DeferredItem<Item> PEAR_PIE = ITEMS.register("pear_pie",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PEAR)));
    public static final DeferredItem<Item> FRUIT_FLAN = ITEMS.register("fruit_flan",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KIWI)));

    public static final DeferredItem<Item> HAWAIIAN_PIZZA_SLICE = ITEMS.register("hawaiian_pizza_slice",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PINEAPPLE)));
    public static final DeferredItem<Item> BANOFFEE_PIE_SLICE = ITEMS.register("banoffee_pie_slice",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BANANA)));
    public static final DeferredItem<Item> LEMON_MERINGUE_PIE_SLICE = ITEMS.register("lemon_meringue_pie_slice",
            () -> new Item(new Item.Properties().food(ModFoodProperties.LEMON)));
    public static final DeferredItem<Item> PEAR_PIE_SLICE = ITEMS.register("pear_pie_slice",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PEAR)));
    public static final DeferredItem<Item> FRUIT_FLAN_SLICE = ITEMS.register("fruit_flan_slice",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KIWI)));

    //BOWLS
    public static final DeferredItem<Item> CAULIFLOWER_SOUP = ITEMS.register("cauliflower_soup",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.CAULIFLOWER_SOUP).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> CHILI_BEAN_SOUP = ITEMS.register("chili_bean_soup",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.CHILI_BEAN_SOUP).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> GUMBO = ITEMS.register("gumbo",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.GUMBO).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> TERIYAKI_CHICKEN = ITEMS.register("teriyaki_chicken",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.TERIYAKI_CHICKEN).craftRemainder(Items.BOWL).stacksTo(16),true));

    public static final DeferredItem<Item> BANANA_CHIPS = ITEMS.register("banana_chips",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.BANANA_CHIPS).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> CEREAL_BOWL = ITEMS.register("cereal_bowl",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.CEREAL_BOWL).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> ORANGE_CHICKEN = ITEMS.register("orange_chicken",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.ORANGE_CHICKEN).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> SWEET_AND_SOUR_CHICKEN = ITEMS.register("sweet_and_sour_chicken",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.SWEET_AND_SOUR_CHICKEN).craftRemainder(Items.BOWL).stacksTo(16),true));
    public static final DeferredItem<Item> TROPICAL_SALAD = ITEMS.register("tropical_salad",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.TROPICAL_SALAD).craftRemainder(Items.BOWL).stacksTo(16),true));

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

    public static final DeferredItem<Item> APPLE_PEAR_CRUMBLE = ITEMS.register("apple_pear_crumble",
            () -> new ConsumableItem(new Item.Properties().food(ModFoodProperties.APPLE_PEAR_CRUMBLE).craftRemainder(Items.BOWL).stacksTo(16),true));

    //CONDIMENTS
    public static final DeferredItem<Item> KETCHUP = ITEMS.register("ketchup",
            () -> new CondimentItem(new Item.Properties().durability(16).component(ModComponents.CONDIMENT_PROPERTIES,ModCondimentProperties.KETCHUP)));
    public static final DeferredItem<Item> MAYONNAISE = ITEMS.register("mayonnaise",
            () -> new CondimentItem(new Item.Properties().durability(16).component(ModComponents.CONDIMENT_PROPERTIES,ModCondimentProperties.MAYONNAISE)));
    public static final DeferredItem<Item> MARMALADE = ITEMS.register("marmalade",
            () -> new CondimentItem(new Item.Properties().durability(16).component(ModComponents.CONDIMENT_PROPERTIES,ModCondimentProperties.MARMALADE)));
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

    public static final DeferredItem<BlockItem> APPLE_BAG = ITEMS.register("apple_bag",
            () -> new BlockItem(ModBlocks.APPLE_BAG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> BANANA_BAG = ITEMS.register("banana_bag",
            () -> new BlockItem(ModBlocks.BANANA_BAG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> KIWI_BAG = ITEMS.register("kiwi_bag",
            () -> new BlockItem(ModBlocks.KIWI_BAG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> LEMON_BAG = ITEMS.register("lemon_bag",
            () -> new BlockItem(ModBlocks.LEMON_BAG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> MANGO_BAG = ITEMS.register("mango_bag",
            () -> new BlockItem(ModBlocks.MANGO_BAG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> ORANGE_BAG = ITEMS.register("orange_bag",
            () -> new BlockItem(ModBlocks.ORANGE_BAG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> PEAR_BAG = ITEMS.register("pear_bag",
            () -> new BlockItem(ModBlocks.PEAR_BAG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> PINEAPPLE_BAG = ITEMS.register("pineapple_bag",
            () -> new BlockItem(ModBlocks.PINEAPPLE_BAG.get(), new Item.Properties()));


    //Fruit Trees
    public static final DeferredItem<BlockItem> APPLE_TREE_SAPLING = ITEMS.register("apple_tree_sapling",
            () -> new BlockItem(ModBlocks.APPLE_TREE_SAPLING.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> APPLE_TREE_LEAVES = ITEMS.register("apple_tree_leaves",
            () -> new BlockItem(ModBlocks.APPLE_TREE_LEAVES.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> APPLE_TREE_FRUITING_LEAVES = ITEMS.register("apple_tree_fruiting_leaves",
            () -> new BlockItem(ModBlocks.APPLE_TREE_FRUITING_LEAVES.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> GOLDEN_APPLE_TREE_FRUITING_LEAVES = ITEMS.register("golden_apple_tree_fruiting_leaves",
            () -> new BlockItem(ModBlocks.GOLDEN_APPLE_TREE_FRUITING_LEAVES.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> ORANGE_TREE_SAPLING = ITEMS.register("orange_tree_sapling",
            () -> new BlockItem(ModBlocks.ORANGE_TREE_SAPLING.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> ORANGE_TREE_LOG = ITEMS.register("orange_tree_log",
            () -> new BlockItem(ModBlocks.ORANGE_TREE_LOG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> ORANGE_TREE_LEAVES = ITEMS.register("orange_tree_leaves",
            () -> new BlockItem(ModBlocks.ORANGE_TREE_LEAVES.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> ORANGE_TREE_FRUITING_LEAVES = ITEMS.register("orange_tree_fruiting_leaves",
            () -> new BlockItem(ModBlocks.ORANGE_TREE_FRUITING_LEAVES.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> LEMON_TREE_SAPLING = ITEMS.register("lemon_tree_sapling",
            () -> new BlockItem(ModBlocks.LEMON_TREE_SAPLING.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> LEMON_TREE_LOG = ITEMS.register("lemon_tree_log",
            () -> new BlockItem(ModBlocks.LEMON_TREE_LOG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> LEMON_TREE_LEAVES = ITEMS.register("lemon_tree_leaves",
            () -> new BlockItem(ModBlocks.LEMON_TREE_LEAVES.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> LEMON_TREE_FRUITING_LEAVES = ITEMS.register("lemon_tree_fruiting_leaves",
            () -> new BlockItem(ModBlocks.LEMON_TREE_FRUITING_LEAVES.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> PEAR_TREE_SAPLING = ITEMS.register("pear_tree_sapling",
            () -> new BlockItem(ModBlocks.PEAR_TREE_SAPLING.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> PEAR_TREE_LOG = ITEMS.register("pear_tree_log",
            () -> new BlockItem(ModBlocks.PEAR_TREE_LOG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> PEAR_TREE_LEAVES = ITEMS.register("pear_tree_leaves",
            () -> new BlockItem(ModBlocks.PEAR_TREE_LEAVES.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> PEAR_TREE_FRUITING_LEAVES = ITEMS.register("pear_tree_fruiting_leaves",
            () -> new BlockItem(ModBlocks.PEAR_TREE_FRUITING_LEAVES.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> EMERALD_PEAR_TREE_FRUITING_LEAVES = ITEMS.register("emerald_pear_tree_fruiting_leaves",
            () -> new BlockItem(ModBlocks.EMERALD_PEAR_TREE_FRUITING_LEAVES.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> MANGO_TREE_SAPLING = ITEMS.register("mango_tree_sapling",
            () -> new BlockItem(ModBlocks.MANGO_TREE_SAPLING.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> MANGO_TREE_LOG = ITEMS.register("mango_tree_log",
            () -> new BlockItem(ModBlocks.MANGO_TREE_LOG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> MANGO_TREE_LEAVES = ITEMS.register("mango_tree_leaves",
            () -> new BlockItem(ModBlocks.MANGO_TREE_LEAVES.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> MANGO_TREE_FRUITING_LEAVES = ITEMS.register("mango_tree_fruiting_leaves",
            () -> new BlockItem(ModBlocks.MANGO_TREE_FRUITING_LEAVES.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> BANANA_TREE_SAPLING = ITEMS.register("banana_tree_sapling",
            () -> new BlockItem(ModBlocks.BANANA_TREE_SAPLING.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> BANANA_TREE_FROND = ITEMS.register("banana_tree_frond",
            () -> new BlockItem(ModBlocks.BANANA_TREE_FROND.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> BANANA_TREE_STEM = ITEMS.register("banana_tree_stem",
            () -> new BlockItem(ModBlocks.BANANA_TREE_STEM.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> BANANA_BUNCH = ITEMS.register("banana_bunch",
            () -> new BlockItem(ModBlocks.BANANA_BUNCH.get(), new Item.Properties()));



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

    //SPECIAL ITEMS
    public static final DeferredItem<Item> FRUIT_PROBE = ITEMS.register("fruit_probe",
            () -> new FruitProbeItem(new Item.Properties().component(ModComponents.FRUIT_PROBE_PROPERTIES, FruitProbeMode.NONE)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
