package com.shakkas.diversitydelight.item;

import com.shakkas.diversitydelight.DiversityDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DiversityDelight.MODID);

    public static final Supplier<CreativeModeTab> CROP_ITEMS_TAB = CREATIVE_MODE_TAB.register("crop_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DDModItems.BROCCOLI.get()))
                    .title(Component.translatable("creativetab.diversitydelight.crop_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(DDModItems.BANANA);
                        output.accept(DDModItems.BELL_PEPPER);
                        output.accept(DDModItems.BROCCOLI);
                        output.accept(DDModItems.CAULIFLOWER);
                        output.accept(DDModItems.CELERY);
                        output.accept(DDModItems.CHILI);
                        output.accept(DDModItems.GREEN_BEAN);
                        output.accept(DDModItems.KIWI);
                        output.accept(DDModItems.LEMON);
                        output.accept(DDModItems.MANGO);
                        output.accept(DDModItems.ORANGE);
                        output.accept(DDModItems.PEA);
                        output.accept(DDModItems.PEAR);
                        output.accept(DDModItems.PINEAPPLE);
                        output.accept(DDModItems.BROCCOLI_FLORET);
                        output.accept(DDModItems.CAULIFLOWER_FLORET);
                        output.accept(DDModItems.PINEAPPLE_SLICE);
                        output.accept(DDModItems.EMERALD_PEAR);
                        output.accept(DDModItems.BELL_PEPPER_SEEDS);
                        output.accept(DDModItems.BROCCOLI_SEEDS);
                        output.accept(DDModItems.CAULIFLOWER_SEEDS);
                        output.accept(DDModItems.CHILI_SEEDS);
                        output.accept(DDModItems.GREEN_BEAN_SEEDS);
                        output.accept(DDModItems.PEA_SEEDS);

                        //HANDHELD
                        output.accept(DDModItems.BACON_WRAPPED_GREEN_BEANS);
                        output.accept(DDModItems.FRITATA);
                        output.accept(DDModItems.SMASHED_PEAS_ON_TOAST);
                        output.accept(DDModItems.STUFFED_BELL_PEPPER);
                        output.accept(DDModItems.VEGETABLE_STICKS);

                        output.accept(DDModItems.BANANA_BREAD);
                        output.accept(DDModItems.FRUIT_ROLLUP);
                        output.accept(DDModItems.POACHED_PEAR);
                        output.accept(DDModItems.LEMON_JELLY);
                        output.accept(DDModItems.MANGO_JELLY);
                        output.accept(DDModItems.KIWI_JELLY);
                        output.accept(DDModItems.ICE_CREAM_CONE);
                        output.accept(DDModItems.LEMON_ICE_CREAM);
                        output.accept(DDModItems.MANGO_ICE_CREAM);
                        output.accept(DDModItems.CHOCOLATE_ICE_CREAM);
                        output.accept(DDModItems.ORANGE_JUICE);
                        output.accept(DDModItems.PINEAPPLE_JUICE);
                        output.accept(DDModItems.BANANA_MILK);
                        output.accept(DDModItems.MANGO_YOGHURT);
                        output.accept(DDModItems.ORANGE_YOGHURT);

                        output.accept(DDModItems.HAWAIIAN_PIZZA);
                        output.accept(DDModItems.HAWAIIAN_PIZZA_SLICE);
                        output.accept(DDModItems.BANOFFEE_PIE);
                        output.accept(DDModItems.BANOFFEE_PIE_SLICE);
                        output.accept(DDModItems.LEMON_MERINGUE_PIE);
                        output.accept(DDModItems.LEMON_MERINGUE_PIE_SLICE);
                        output.accept(DDModItems.PEAR_PIE);
                        output.accept(DDModItems.PEAR_PIE_SLICE);
                        output.accept(DDModItems.FRUIT_FLAN);
                        output.accept(DDModItems.FRUIT_FLAN_SLICE);


                        //BOWLS
                        output.accept(DDModItems.CAULIFLOWER_SOUP);
                        output.accept(DDModItems.CHILI_BEAN_SOUP);
                        output.accept(DDModItems.GUMBO);
                        output.accept(DDModItems.TERIYAKI_CHICKEN);

                        output.accept(DDModItems.BANANA_CHIPS);
                        output.accept(DDModItems.CEREAL_BOWL);
                        output.accept(DDModItems.ORANGE_CHICKEN);
                        output.accept(DDModItems.SWEET_AND_SOUR_CHICKEN);
                        output.accept(DDModItems.TROPICAL_SALAD);

                        //PLATES
                        output.accept(DDModItems.BUFFALO_WINGS);
                        output.accept(DDModItems.CAULIFLOWER_STEAK);
                        output.accept(DDModItems.CHICKEN_POT_PIE);
                        output.accept(DDModItems.CHICKEN_POT_PIE_BLOCK);
                        output.accept(DDModItems.GREEN_BEAN_CASSEROLE);
                        output.accept(DDModItems.GREEN_BEAN_STIR_FRY);
                        output.accept(DDModItems.MIXED_VEGETABLE_MEDLEY);
                        output.accept(DDModItems.PEA_PESTO_PASTA);
                        output.accept(DDModItems.VEGETABLE_STICKS_BLOCK);

                        output.accept(DDModItems.APPLE_PEAR_CRUMBLE);

                        //CONDIMENTS
                        output.accept(DDModItems.KETCHUP);
                        output.accept(DDModItems.MARMALADE);
                        output.accept(DDModItems.MAYONNAISE);
                        output.accept(DDModItems.HOT_SAUCE);

                        //blocks
                        output.accept(DDModItems.WORM_BIN_BLOCK);

                        output.accept(DDModItems.BELL_PEPPER_CRATE);
                        output.accept(DDModItems.BROCCOLI_CRATE);
                        output.accept(DDModItems.CAULIFLOWER_CRATE);
                        output.accept(DDModItems.CELERY_CRATE);
                        output.accept(DDModItems.CHILI_CRATE);
                        output.accept(DDModItems.GREEN_BEAN_CRATE);
                        output.accept(DDModItems.PEA_CRATE);

                        output.accept(DDModItems.APPLE_BAG);
                        output.accept(DDModItems.BANANA_BAG);
                        output.accept(DDModItems.KIWI_BAG);
                        output.accept(DDModItems.LEMON_BAG);
                        output.accept(DDModItems.MANGO_BAG);
                        output.accept(DDModItems.ORANGE_BAG);
                        output.accept(DDModItems.PEAR_BAG);
                        output.accept(DDModItems.PINEAPPLE_BAG);

                        output.accept(DDModItems.APPLE_TREE_SAPLING);
                        output.accept(DDModItems.APPLE_TREE_LEAVES);
                        output.accept(DDModItems.APPLE_TREE_FRUITING_LEAVES);
                        output.accept(DDModItems.GOLDEN_APPLE_TREE_FRUITING_LEAVES);

                        output.accept(DDModItems.ORANGE_TREE_SAPLING);
                        output.accept(DDModItems.ORANGE_TREE_LOG);
                        output.accept(DDModItems.ORANGE_TREE_LEAVES);
                        output.accept(DDModItems.ORANGE_TREE_FRUITING_LEAVES);

                        output.accept(DDModItems.LEMON_TREE_SAPLING);
                        output.accept(DDModItems.LEMON_TREE_LOG);
                        output.accept(DDModItems.LEMON_TREE_LEAVES);
                        output.accept(DDModItems.LEMON_TREE_FRUITING_LEAVES);

                        output.accept(DDModItems.PEAR_TREE_SAPLING);
                        output.accept(DDModItems.PEAR_TREE_LOG);
                        output.accept(DDModItems.PEAR_TREE_LEAVES);
                        output.accept(DDModItems.PEAR_TREE_FRUITING_LEAVES);
                        output.accept(DDModItems.EMERALD_PEAR_TREE_FRUITING_LEAVES);

                        output.accept(DDModItems.MANGO_TREE_SAPLING);
                        output.accept(DDModItems.MANGO_TREE_LOG);
                        output.accept(DDModItems.MANGO_TREE_LEAVES);
                        output.accept(DDModItems.MANGO_TREE_FRUITING_LEAVES);

                        output.accept(DDModItems.BANANA_TREE_SAPLING);
                        output.accept(DDModItems.BANANA_TREE_FROND);
                        output.accept(DDModItems.BANANA_TREE_STEM);
                        output.accept(DDModItems.BANANA_BUNCH);

                        output.accept(DDModItems.WILD_BELL_PEPPER);
                        output.accept(DDModItems.WILD_BROCCOLI);
                        output.accept(DDModItems.WILD_CAULIFLOWER);
                        output.accept(DDModItems.WILD_CELERY);
                        output.accept(DDModItems.WILD_CHILI);
                        output.accept(DDModItems.WILD_GREEN_BEAN);
                        output.accept(DDModItems.WILD_PEA);

                        output.accept(DDModItems.FRUIT_PROBE);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}