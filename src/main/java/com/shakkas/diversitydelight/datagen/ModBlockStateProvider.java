package com.shakkas.diversitydelight.datagen;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.block.ModBlocks;
import com.shakkas.diversitydelight.block.custom.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import vectorwing.farmersdelight.common.block.FeastBlock;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DiversityDelight.MODID, exFileHelper);
    }

    private String blockName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "block/" + path);
    }

    public ModelFile existingModel(Block block) {
        return new ModelFile.ExistingModelFile(resourceBlock(blockName(block)), models().existingFileHelper);
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.customStageBlock(ModBlocks.BROCCOLI_CROP.get(), mcLoc("cross"), "cross", ColeCropBlock.AGE, Arrays.asList(0, 1, 2, 3, 3, 4, 4, 5));
        this.customStageBlock(ModBlocks.CAULIFLOWER_CROP.get(), mcLoc("cross"), "cross", ColeCropBlock.AGE, Arrays.asList(0, 1, 2, 2, 3, 3, 4, 5));
        this.customStageBlock(ModBlocks.CELERY_CROP.get(), mcLoc("crop"), "crop", CeleryCropBlock.AGE, Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3));
        this.customStageBlock(ModBlocks.LOWER_BELL_PEPPER_CROP.get(), mcLoc("crop"), "crop", LowerDoubleSupportCropBlock.AGE, Arrays.asList(0, 1, 1, 2, 2, 3, 3, 4));
        this.customStageBlock(ModBlocks.UPPER_BELL_PEPPER_CROP.get(), mcLoc("crop"), "crop", UpperDoubleFruitingCropBlock.AGE, Arrays.asList(0, 1, 2, 3, 4, 5, 5, 6));
        this.customStageBlock(ModBlocks.LOWER_CHILI_CROP.get(), mcLoc("crop"), "crop", LowerDoubleSupportCropBlock.AGE, Arrays.asList(0, 1, 1, 2, 2, 3, 3, 4));
        this.customStageBlock(ModBlocks.UPPER_CHILI_CROP.get(), mcLoc("crop"), "crop", UpperDoubleFruitingCropBlock.AGE, Arrays.asList(0, 1, 1, 2, 2, 3, 3, 4));
        this.customStageBlock(ModBlocks.LOWER_GREEN_BEAN_CROP.get(), mcLoc("crop"), "crop", LowerDoubleFruitingCropBlock.AGE, Arrays.asList(0, 1, 2, 3, 3, 4, 4, 5));
        this.customStageBlock(ModBlocks.UPPER_GREEN_BEAN_CROP.get(), mcLoc("crop"), "crop", UpperDoubleFruitingCropBlock.AGE, Arrays.asList(0, 1, 2, 3, 3, 4, 4, 5));
        this.customStageBlock(ModBlocks.LOWER_PEA_CROP.get(), mcLoc("cross"), "cross", LowerDoubleFruitingCropBlock.AGE, Arrays.asList(0, 1, 2, 3, 3, 4, 4, 5));
        this.customStageBlock(ModBlocks.UPPER_PEA_CROP.get(), mcLoc("cross"), "cross", UpperDoubleFruitingCropBlock.AGE, Arrays.asList(0, 1, 2, 3, 3, 4, 4, 5));

        this.wormBinBlock((WormBinBlock) ModBlocks.WORM_BIN_BLOCK.get());
        this.fruitingLeavesBlock((FruitingLeavesBlock) ModBlocks.ORANGE_TREE_FRUITING_LEAVES.get());

        // Crop Crates
        this.crateBlock(ModBlocks.BELL_PEPPER_CRATE.get(), "bell_pepper");
        this.crateBlock(ModBlocks.BROCCOLI_CRATE.get(), "broccoli");
        this.crateBlock(ModBlocks.CAULIFLOWER_CRATE.get(), "cauliflower");
        this.crateBlock(ModBlocks.CELERY_CRATE.get(), "celery");
        this.crateBlock(ModBlocks.CHILI_CRATE.get(), "chili");
        this.crateBlock(ModBlocks.GREEN_BEAN_CRATE.get(), "green_bean");
        this.crateBlock(ModBlocks.PEA_CRATE.get(), "pea");

        //Feasts
        this.feastBlock((FeastBlock) ModBlocks.CHICKEN_POT_PIE_BLOCK.get());
        this.feastBlock((FeastBlock) ModBlocks.VEGETABLE_STICKS_BLOCK.get());

        // Saplings
        this.crossCutOutBlock(ModBlocks.ORANGE_TREE_SAPLING.get());

        // Wild Crops
        this.crossCutOutBlock(ModBlocks.WILD_BELL_PEPPER.get());
        this.crossCutOutBlock(ModBlocks.WILD_BROCCOLI.get());
        this.crossCutOutBlock(ModBlocks.WILD_CAULIFLOWER.get());
        this.crossCutOutBlock(ModBlocks.WILD_CELERY.get());
        this.crossCutOutBlock(ModBlocks.WILD_CHILI.get());
        this.crossCutOutBlock(ModBlocks.WILD_GREEN_BEAN.get());
        this.crossCutOutBlock(ModBlocks.WILD_PEA.get());

        logBlockAndItem(ModBlocks.ORANGE_TREE_LOG.get());
        leafBlock(ModBlocks.ORANGE_TREE_LEAVES.get());

    }

    public void logBlockAndItem(Block block) {
        String blockName = blockName(block);
        logBlock((RotatedPillarBlock) block);
        simpleBlockItem(block,models().cubeColumn(blockName,resourceBlock(blockName),resourceBlock(blockName+"_top")));
    }

    public void leafBlock(Block block) {
        this.simpleBlockWithItem(block, models().cubeAll(blockName(block),resourceBlock(blockName(block))));
    }

    // Credits to vectorwing for datagen
    public void crateBlock(Block block, String cropName) {
        this.simpleBlockWithItem(block,
                models().cubeBottomTop(blockName(block), resourceBlock(cropName + "_crate_side"), resourceBlock("crate_bottom"), resourceBlock(cropName + "_crate_top")));
    }


    public void wormBinBlock(WormBinBlock block) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    int level = state.getValue(WormBinBlock.LEVEL);
                    String contentSuffix = "_contents" + level;
                    ConfiguredModel.Builder<?> builder = ConfiguredModel.builder()
                            .modelFile(existingModel(blockName(block)+contentSuffix))
                            .rotationY(((int) state.getValue(WormBinBlock.FACING).toYRot() + 180) % 360);
                    return builder.build();
                });
    }

    public void fruitingLeavesBlock(FruitingLeavesBlock block) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    int age = state.getValue(FruitingLeavesBlock.AGE);
                    String ageSuffix = "_stage" + age;
                    ConfiguredModel.Builder<?> builder = ConfiguredModel.builder()
                            .modelFile(models().cubeAll(blockName(block)+ageSuffix,resourceBlock(blockName(block)+ageSuffix)));
                    return builder.build();
                });
        simpleBlockItem(block,models().cubeAll(blockName(block),resourceBlock(blockName(block)+"_stage3")));
    }

    // vectorwing code for datagen of custom crop block state
    public void customStageBlock(Block block, @Nullable ResourceLocation parent, String textureKey, IntegerProperty ageProperty, List<Integer> suffixes, Property<?>... ignored) {
        getVariantBuilder(block)
                .forAllStatesExcept(state -> {
                    int ageSuffix = state.getValue(ageProperty);
                    String stageName = blockName(block) + "_stage";
                    stageName += suffixes.isEmpty() ? ageSuffix : suffixes.get(Math.min(suffixes.size(), ageSuffix));
                    if (parent == null) {
                        return ConfiguredModel.builder()
                                .modelFile(models().cross(stageName, resourceBlock(stageName)).renderType("cutout")).build();
                    }
                    return ConfiguredModel.builder()
                            .modelFile(models().singleTexture(stageName, parent, textureKey, resourceBlock(stageName)).renderType("cutout")).build();
                }, ignored);
    }

    public void crossCutOutBlock(Block block) {
        this.simpleBlock(block, models().cross(blockName(block), resourceBlock(blockName(block))).renderType("cutout"));
    }

    public void feastBlock(FeastBlock block) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    IntegerProperty servingsProperty = block.getServingsProperty();
                    int servings = state.getValue(servingsProperty);

                    String suffix = "_stage" + (block.getMaxServings() - servings);

                    if (servings == 0) {
                        suffix = block.hasLeftovers ? "_leftover" : "_stage" + (servingsProperty.getPossibleValues().toArray().length - 2);
                    }

                    return ConfiguredModel.builder()
                            .modelFile(existingModel(blockName(block) + suffix))
                            .rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360)
                            .build();
                });
    }

}