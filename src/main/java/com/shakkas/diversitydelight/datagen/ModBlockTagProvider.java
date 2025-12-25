package com.shakkas.diversitydelight.datagen;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.block.ModBlocks;
import com.shakkas.diversitydelight.tags.DDCommonTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.CompatibilityTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DiversityDelight.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.registerMinecraftTags();
        this.registerBlockMineables();
        this.registerCommonTags();
        this.registerSereneSeasonTags();
    }

    protected void registerBlockMineables() {
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(
                ModBlocks.BELL_PEPPER_CRATE.get(),
                ModBlocks.BROCCOLI_CRATE.get(),
                ModBlocks.CAULIFLOWER_CRATE.get(),
                ModBlocks.CELERY_CRATE.get(),
                ModBlocks.CHILI_CRATE.get(),
                ModBlocks.GREEN_BEAN_CRATE.get(),
                ModBlocks.PEA_CRATE.get(),
                ModBlocks.WORM_BIN_BLOCK.get()
        );
    }

    protected void registerMinecraftTags() {
        tag(net.minecraft.tags.BlockTags.CROPS).add(
                ModBlocks.LOWER_BELL_PEPPER_CROP.get(),
                ModBlocks.UPPER_BELL_PEPPER_CROP.get(),
                ModBlocks.BROCCOLI_CROP.get(),
                ModBlocks.CAULIFLOWER_CROP.get(),
                ModBlocks.CELERY_CROP.get(),
                ModBlocks.LOWER_CHILI_CROP.get(),
                ModBlocks.UPPER_CHILI_CROP.get(),
                ModBlocks.LOWER_GREEN_BEAN_CROP.get(),
                ModBlocks.UPPER_GREEN_BEAN_CROP.get(),
                ModBlocks.LOWER_PEA_CROP.get(),
                ModBlocks.UPPER_PEA_CROP.get()
        );
        tag(net.minecraft.tags.BlockTags.MAINTAINS_FARMLAND).add(
                ModBlocks.LOWER_BELL_PEPPER_CROP.get(),
                ModBlocks.BROCCOLI_CROP.get(),
                ModBlocks.CAULIFLOWER_CROP.get(),
                ModBlocks.CELERY_CROP.get(),
                ModBlocks.LOWER_CHILI_CROP.get(),
                ModBlocks.LOWER_GREEN_BEAN_CROP.get(),
                ModBlocks.LOWER_PEA_CROP.get()
        );
        tag(net.minecraft.tags.BlockTags.LOGS).add(
                ModBlocks.ORANGE_TREE_LOG.get(),
                ModBlocks.LEMON_TREE_LOG.get(),
                ModBlocks.PEAR_TREE_LOG.get(),
                ModBlocks.MANGO_TREE_LOG.get()
        );
    }

    protected void registerCommonTags() {
        tag(Tags.Blocks.STORAGE_BLOCKS).addTags(
                DDCommonTags.STORAGE_BLOCKS_BELL_PEPPER,
                DDCommonTags.STORAGE_BLOCKS_BROCCOLI,
                DDCommonTags.STORAGE_BLOCKS_CAULIFLOWER,
                DDCommonTags.STORAGE_BLOCKS_CELERY,
                DDCommonTags.STORAGE_BLOCKS_CHILI,
                DDCommonTags.STORAGE_BLOCKS_GREEN_BEAN,
                DDCommonTags.STORAGE_BLOCKS_PEA
        );

        tag(DDCommonTags.STORAGE_BLOCKS_BELL_PEPPER).add(ModBlocks.BELL_PEPPER_CRATE.get());
        tag(DDCommonTags.STORAGE_BLOCKS_BROCCOLI).add(ModBlocks.BROCCOLI_CRATE.get());
        tag(DDCommonTags.STORAGE_BLOCKS_CAULIFLOWER).add(ModBlocks.CAULIFLOWER_CRATE.get());
        tag(DDCommonTags.STORAGE_BLOCKS_CELERY).add(ModBlocks.CELERY_CRATE.get());
        tag(DDCommonTags.STORAGE_BLOCKS_CHILI).add(ModBlocks.CHILI_CRATE.get());
        tag(DDCommonTags.STORAGE_BLOCKS_GREEN_BEAN).add(ModBlocks.GREEN_BEAN_CRATE.get());
        tag(DDCommonTags.STORAGE_BLOCKS_PEA).add(ModBlocks.PEA_CRATE.get());
    }

    protected void registerSereneSeasonTags() {
        tag(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS_BLOCK).add(
                ModBlocks.LOWER_BELL_PEPPER_CROP.get(),
                ModBlocks.UPPER_BELL_PEPPER_CROP.get(),
                ModBlocks.CELERY_CROP.get(),
                ModBlocks.LOWER_CHILI_CROP.get(),
                ModBlocks.UPPER_CHILI_CROP.get(),
                ModBlocks.LOWER_GREEN_BEAN_CROP.get(),
                ModBlocks.UPPER_GREEN_BEAN_CROP.get());
        tag(CompatibilityTags.SERENE_SEASONS_AUTUMN_CROPS_BLOCK).add(
                ModBlocks.BROCCOLI_CROP.get());
        tag(CompatibilityTags.SERENE_SEASONS_WINTER_CROPS_BLOCK).add(
                ModBlocks.BROCCOLI_CROP.get(),
                ModBlocks.CAULIFLOWER_CROP.get());
        tag(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS_BLOCK).add(
                ModBlocks.CELERY_CROP.get(),
                ModBlocks.LOWER_PEA_CROP.get(),
                ModBlocks.UPPER_PEA_CROP.get());
    }
}
