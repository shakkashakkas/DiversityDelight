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

                        //BOWLS
                        output.accept(DDModItems.CAULIFLOWER_SOUP);
                        output.accept(DDModItems.CHILI_BEAN_SOUP);
                        output.accept(DDModItems.GUMBO);
                        output.accept(DDModItems.TERIYAKI_CHICKEN);

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

                        //CONDIMENTS
                        output.accept(DDModItems.KETCHUP);
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

                        output.accept(DDModItems.ORANGE_TREE_SAPLING);
                        output.accept(DDModItems.ORANGE_TREE_LOG);
                        output.accept(DDModItems.ORANGE_TREE_LEAVES);
                        output.accept(DDModItems.ORANGE_TREE_FRUITING_LEAVES);

                        output.accept(DDModItems.WILD_BELL_PEPPER);
                        output.accept(DDModItems.WILD_BROCCOLI);
                        output.accept(DDModItems.WILD_CAULIFLOWER);
                        output.accept(DDModItems.WILD_CELERY);
                        output.accept(DDModItems.WILD_CHILI);
                        output.accept(DDModItems.WILD_GREEN_BEAN);
                        output.accept(DDModItems.WILD_PEA);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}