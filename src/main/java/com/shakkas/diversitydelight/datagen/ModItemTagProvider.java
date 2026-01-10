package com.shakkas.diversitydelight.datagen;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.item.DDModItems;
import com.shakkas.diversitydelight.tags.DDCommonTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.CompatibilityTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, DiversityDelight.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.registerMinecraftTags();
        this.registerCommonTags();
        this.registerNeoForgeTags();
        this.registerSereneSeasonTags();
    }

    private void registerMinecraftTags() {
        tag(net.minecraft.tags.ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(DDModItems.BELL_PEPPER_SEEDS.get())
                .add(DDModItems.BROCCOLI_SEEDS.get())
                .add(DDModItems.CAULIFLOWER_SEEDS.get())
                .add(DDModItems.CELERY.get())
                .add(DDModItems.CHILI_SEEDS.get())
                .add(DDModItems.GREEN_BEAN_SEEDS.get())
                .add(DDModItems.PEA_SEEDS.get());
    }

    private void registerNeoForgeTags() {
        tag(Tags.Items.FOODS)
                .addTag(DDCommonTags.FOODS_LEAFY_GREEN);
        tag(Tags.Items.FOODS_VEGETABLE).add(
                DDModItems.BELL_PEPPER.get(),
                DDModItems.BROCCOLI.get(),
                DDModItems.CAULIFLOWER.get(),
                DDModItems.CELERY.get(),
                DDModItems.CHILI.get(),
                DDModItems.GREEN_BEAN.get(),
                DDModItems.PEA.get()
        );
        tag(Tags.Items.FOODS_FRUIT).add(
                DDModItems.ORANGE.get(),
                DDModItems.BANANA.get(),
                DDModItems.LEMON.get(),
                DDModItems.MANGO.get(),
                DDModItems.KIWI.get(),
                DDModItems.PEAR.get(),
                DDModItems.PINEAPPLE.get()
        );
        tag(Tags.Items.FOODS_EDIBLE_WHEN_PLACED).add(
                DDModItems.CHICKEN_POT_PIE_BLOCK.get(),
                DDModItems.HAWAIIAN_PIZZA.get(),
                DDModItems.BANOFFEE_PIE.get(),
                DDModItems.LEMON_MERINGUE_PIE.get(),
                DDModItems.PEAR_PIE.get(),
                DDModItems.FRUIT_FLAN.get()
                );
        tag(Tags.Items.FOODS_SOUP)
                .add(DDModItems.CAULIFLOWER_SOUP.get())
                .add(DDModItems.CHILI_BEAN_SOUP.get())
                .add(DDModItems.GUMBO.get());
    }

    private void registerCommonTags() {
        tag(DDCommonTags.CROPS_BELL_PEPPER).add(DDModItems.BELL_PEPPER.get());
        tag(DDCommonTags.CROPS_BROCCOLI).add(DDModItems.BROCCOLI.get(), DDModItems.BROCCOLI_FLORET.get());
        tag(DDCommonTags.CROPS_CAULIFLOWER).add(DDModItems.CAULIFLOWER.get(), DDModItems.CAULIFLOWER_FLORET.get());
        tag(DDCommonTags.CROPS_CELERY).add(DDModItems.CELERY.get());
        tag(DDCommonTags.CROPS_CHILI).add(DDModItems.CHILI.get());
        tag(DDCommonTags.CROPS_GREEN_BEAN).add(DDModItems.GREEN_BEAN.get());
        tag(DDCommonTags.CROPS_PEA).add(DDModItems.PEA.get());

        tag(DDCommonTags.CROPS_ORANGE).add(DDModItems.ORANGE.get());
        tag(DDCommonTags.CROPS_BANANA).add(DDModItems.BANANA.get());
        tag(DDCommonTags.CROPS_LEMON).add(DDModItems.LEMON.get());
        tag(DDCommonTags.CROPS_MANGO).add(DDModItems.MANGO.get());
        tag(DDCommonTags.CROPS_KIWI).add(DDModItems.KIWI.get());
        tag(DDCommonTags.CROPS_PEAR).add(DDModItems.PEAR.get());
        tag(DDCommonTags.CROPS_PINEAPPLE).add(DDModItems.PINEAPPLE.get(), DDModItems.PINEAPPLE_SLICE.get());

        tag(DDCommonTags.FOODS_BELL_PEPPER).add(DDModItems.BELL_PEPPER.get());
        tag(DDCommonTags.FOODS_BROCCOLI).add(DDModItems.BROCCOLI.get(), DDModItems.BROCCOLI_FLORET.get());
        tag(DDCommonTags.FOODS_CAULIFLOWER).add(DDModItems.CAULIFLOWER.get(), DDModItems.CAULIFLOWER_FLORET.get());
        tag(DDCommonTags.FOODS_CELERY).add(DDModItems.CELERY.get());
        tag(DDCommonTags.FOODS_CHILI).add(DDModItems.CHILI.get());
        tag(DDCommonTags.FOODS_GREEN_BEAN).add(DDModItems.GREEN_BEAN.get());
        tag(DDCommonTags.FOODS_PEA).add(DDModItems.PEA.get());

        tag(DDCommonTags.FOODS_ORANGE).add(DDModItems.ORANGE.get());
        tag(DDCommonTags.FOODS_BANANA).add(DDModItems.BANANA.get());
        tag(DDCommonTags.FOODS_LEMON).add(DDModItems.LEMON.get());
        tag(DDCommonTags.FOODS_MANGO).add(DDModItems.MANGO.get());
        tag(DDCommonTags.FOODS_KIWI).add(DDModItems.KIWI.get());
        tag(DDCommonTags.FOODS_PEAR).add(DDModItems.PEAR.get());
        tag(DDCommonTags.FOODS_PINEAPPLE).add(DDModItems.PINEAPPLE.get(), DDModItems.PINEAPPLE_SLICE.get());


        tag(DDCommonTags.FOODS_LEAFY_GREEN).addTags(DDCommonTags.FOODS_BROCCOLI, DDCommonTags.FOODS_CAULIFLOWER);

        tag(DDCommonTags.STORAGE_BLOCKS_ITEM_BELL_PEPPER).add(DDModItems.BELL_PEPPER_CRATE.get());
        tag(DDCommonTags.STORAGE_BLOCKS_ITEM_BROCCOLI).add(DDModItems.BROCCOLI_CRATE.get());
        tag(DDCommonTags.STORAGE_BLOCKS_ITEM_CAULIFLOWER).add(DDModItems.CAULIFLOWER_CRATE.get());
        tag(DDCommonTags.STORAGE_BLOCKS_ITEM_CELERY).add(DDModItems.CELERY_CRATE.get());
        tag(DDCommonTags.STORAGE_BLOCKS_ITEM_CHILI).add(DDModItems.CHILI_CRATE.get());
        tag(DDCommonTags.STORAGE_BLOCKS_ITEM_GREEN_BEAN).add(DDModItems.GREEN_BEAN_CRATE.get());
        tag(DDCommonTags.STORAGE_BLOCKS_ITEM_PEA).add(DDModItems.PEA_CRATE.get());
    }

    private void registerSereneSeasonTags() {
        tag(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS)
                .add(DDModItems.BELL_PEPPER.get())
                .add(DDModItems.CELERY.get())
                .add(DDModItems.CHILI.get())
                .add(DDModItems.GREEN_BEAN.get())
                .add(DDModItems.BANANA.get())
                .add(DDModItems.MANGO.get())
                .add(DDModItems.PEAR.get())
                .add(DDModItems.PINEAPPLE.get()
                );
        tag(CompatibilityTags.SERENE_SEASONS_AUTUMN_CROPS)
                .add(DDModItems.BROCCOLI.get())
                .add(DDModItems.BANANA.get())
                .add(DDModItems.KIWI.get())
                .add(DDModItems.PEAR.get())
                .add(DDModItems.PINEAPPLE.get()
                );
        tag(CompatibilityTags.SERENE_SEASONS_WINTER_CROPS)
                .add(DDModItems.BROCCOLI.get())
                .add(DDModItems.CAULIFLOWER.get())
                .add(DDModItems.ORANGE.get())
                .add(DDModItems.LEMON.get()
                );
        tag(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS)
                .add(DDModItems.CELERY.get())
                .add(DDModItems.PEA.get())
                .add(DDModItems.ORANGE.get())
                .add(DDModItems.LEMON.get()
                );
    }
}
