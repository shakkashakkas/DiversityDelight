package com.shakkas.diversitydelight.datagen;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.block.ModBlocks;
import com.shakkas.diversitydelight.block.custom.*;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.block.PieBlock;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

import static com.shakkas.diversitydelight.block.custom.BananaStem.STAGE;
import static com.shakkas.diversitydelight.block.custom.DoubleCropBlock.HALF;
import static net.minecraft.world.level.block.CropBlock.AGE;


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
        this.customStageBlock(ModBlocks.BROCCOLI_CROP.get(), mcLoc("cross"), "cross", ColeCropBlock.AGE, Arrays.asList(0, 1, 1, 2, 2, 3, 3, 4));
        this.customStageBlock(ModBlocks.CAULIFLOWER_CROP.get(), mcLoc("cross"), "cross", ColeCropBlock.AGE, Arrays.asList(0, 1, 1, 2, 2, 3, 3, 4));
        this.customStageBlock(ModBlocks.CELERY_CROP.get(), mcLoc("crop"), "crop", CeleryCropBlock.AGE, Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3));
        this.customDoubleStageBlock((DoubleCropBlock) ModBlocks.BELL_PEPPER_CROP.get(), mcLoc("crop"), "crop", DoubleCropBlock.AGE, Arrays.asList(0, 1, 2, 3, 3, 4, 5, 6));
        this.customDoubleStageBlock((DoubleCropBlock) ModBlocks.PEA_CROP.get(), mcLoc("crop"), "crop", DoubleCropBlock.AGE, Arrays.asList(0, 1, 2, 3, 3, 4, 5, 6));
        this.customDoubleStageBlock((DoubleCropBlock) ModBlocks.GREEN_BEAN_CROP.get(), mcLoc("crop"), "crop", DoubleCropBlock.AGE, Arrays.asList(0, 1, 2, 3, 3, 4, 5, 6));
        this.customDoubleStageBlock((DoubleCropBlock) ModBlocks.CHILI_CROP.get(), mcLoc("crop"), "crop", DoubleCropBlock.AGE, Arrays.asList(0, 1, 2, 3, 3, 4, 5, 6));
        this.customStageBlock(ModBlocks.PINEAPPLE_CROP.get(), resourceBlock("crop_cross"), "cross", PineappleCropBlock.AGE, Arrays.asList(0, 1, 2, 3, 3, 4, 4, 5));

        this.customStageBlock(ModBlocks.KIWI_BUDDING_CROP.get(), resourceBlock("crop_cross"), "cross", BuddingKiwiBlock.AGE, Arrays.asList(0, 1, 2, 3));
        //this.customStageBlock(ModBlocks.KIWI_CROP.get(), mcLoc("cross"), "cross", KiwiVineBlock.VINE_AGE, Arrays.asList(0, 1, 2, 3));

        this.wormBinBlock((WormBinBlock) ModBlocks.WORM_BIN_BLOCK.get());
        this.fruitingLeavesBlock((FruitingLeavesBlock) ModBlocks.APPLE_TREE_FRUITING_LEAVES.get());
        this.fruitingLeavesBlock((FruitingLeavesBlock) ModBlocks.GOLDEN_APPLE_TREE_FRUITING_LEAVES.get());
        this.fruitingLeavesBlock((FruitingLeavesBlock) ModBlocks.ORANGE_TREE_FRUITING_LEAVES.get());
        this.fruitingLeavesBlock((FruitingLeavesBlock) ModBlocks.LEMON_TREE_FRUITING_LEAVES.get());
        this.fruitingLeavesBlock((FruitingLeavesBlock) ModBlocks.PEAR_TREE_FRUITING_LEAVES.get());
        this.fruitingLeavesBlock((FruitingLeavesBlock) ModBlocks.EMERALD_PEAR_TREE_FRUITING_LEAVES.get());
        this.fruitingLeavesBlock((FruitingLeavesBlock) ModBlocks.MANGO_TREE_FRUITING_LEAVES.get());

        // Crop Crates
        this.crateBlock(ModBlocks.BELL_PEPPER_CRATE.get(), "bell_pepper");
        this.crateBlock(ModBlocks.BROCCOLI_CRATE.get(), "broccoli");
        this.crateBlock(ModBlocks.CAULIFLOWER_CRATE.get(), "cauliflower");
        this.crateBlock(ModBlocks.CELERY_CRATE.get(), "celery");
        this.crateBlock(ModBlocks.CHILI_CRATE.get(), "chili");
        this.crateBlock(ModBlocks.GREEN_BEAN_CRATE.get(), "green_bean");
        this.crateBlock(ModBlocks.PEA_CRATE.get(), "pea");

        this.bagBlock(ModBlocks.APPLE_BAG.get());
        this.bagBlock(ModBlocks.BANANA_BAG.get());
        this.bagBlock(ModBlocks.KIWI_BAG.get());
        this.bagBlock(ModBlocks.LEMON_BAG.get());
        this.bagBlock(ModBlocks.MANGO_BAG.get());
        this.bagBlock(ModBlocks.ORANGE_BAG.get());
        this.bagBlock(ModBlocks.PEAR_BAG.get());
        this.bagBlock(ModBlocks.PINEAPPLE_BAG.get());

        //Feasts
        this.feastBlock((FeastBlock) ModBlocks.CHICKEN_POT_PIE_BLOCK.get());
        this.feastBlock((FeastBlock) ModBlocks.VEGETABLE_STICKS_BLOCK.get());

        //Pies and Pizzas
        this.pieBlock(ModBlocks.BANOFFEE_PIE_BLOCK.get());
        this.pieBlock(ModBlocks.FRUIT_FLAN_BLOCK.get());
        this.pieBlock(ModBlocks.LEMON_MERINGUE_PIE_BLOCK.get());
        this.pieBlock(ModBlocks.PEAR_PIE_BLOCK.get());
        this.pieBlock(ModBlocks.HAWAIIAN_PIZZA_BLOCK.get());

        // Saplings
        this.crossCutOutBlock(ModBlocks.APPLE_TREE_SAPLING.get());
        this.crossCutOutBlock(ModBlocks.ORANGE_TREE_SAPLING.get());
        this.crossCutOutBlock(ModBlocks.LEMON_TREE_SAPLING.get());
        this.crossCutOutBlock(ModBlocks.PEAR_TREE_SAPLING.get());
        this.crossCutOutBlock(ModBlocks.MANGO_TREE_SAPLING.get());
        this.crossCutOutBlock(ModBlocks.BANANA_TREE_SAPLING.get());

        // Wild Crops
        this.crossCutOutBlock(ModBlocks.WILD_BELL_PEPPER.get());
        this.crossCutOutBlock(ModBlocks.WILD_BROCCOLI.get());
        this.crossCutOutBlock(ModBlocks.WILD_CAULIFLOWER.get());
        this.crossCutOutBlock(ModBlocks.WILD_CELERY.get());
        this.crossCutOutBlock(ModBlocks.WILD_CHILI.get());
        this.crossCutOutBlock(ModBlocks.WILD_GREEN_BEAN.get());
        this.crossCutOutBlock(ModBlocks.WILD_PEA.get());
        this.crossCutOutBlock(ModBlocks.WILD_KIWI.get());
        this.crossCutOutBlock(ModBlocks.WILD_PINEAPPLE.get());

        leafBlock(ModBlocks.APPLE_TREE_LEAVES.get());
        logBlockAndItem(ModBlocks.ORANGE_TREE_LOG.get());
        leafBlock(ModBlocks.ORANGE_TREE_LEAVES.get());
        logBlockAndItem(ModBlocks.LEMON_TREE_LOG.get());
        leafBlock(ModBlocks.LEMON_TREE_LEAVES.get());
        logBlockAndItem(ModBlocks.PEAR_TREE_LOG.get());
        leafBlock(ModBlocks.PEAR_TREE_LEAVES.get());
        logBlockAndItem(ModBlocks.MANGO_TREE_LOG.get());
        leafBlock(ModBlocks.MANGO_TREE_LEAVES.get());

        //logBlockAndItem(ModBlocks.BANANA_TREE_STEM.get());
        bananaStemBlock((BananaStem) ModBlocks.BANANA_TREE_STEM.get());
        frondBlockAndItem(ModBlocks.BANANA_TREE_FROND.get());
        bananaBunch(ModBlocks.BANANA_BUNCH.get(),Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3));
        //this.crossCutOutBlock(ModBlocks.BANANA_BUNCH.get());
    }

    public void frondBlockAndItem(Block block) {
        String blockName = blockName(block);
        horizontalBlock(block,existingModel(blockName));
    }

    public void bananaBunch(Block block, List<Integer> suffixes) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    int age = state.getValue(BananaBunch.AGE);
                    int stage = suffixes.isEmpty() ? age : suffixes.get(Math.min(suffixes.size() - 1, age));
                    String stageSuffix = "_stage" + stage;
                    ConfiguredModel.Builder<?> builder = ConfiguredModel.builder()
                            .modelFile(existingModel(blockName(block)+stageSuffix))
                            .rotationY(((int) state.getValue(BananaBunch.FACING).toYRot() + 180) % 360);
                    return builder.build();
                });
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

    public void bagBlock(Block block) {
        String bag = "bag";
        this.simpleBlockWithItem(block, models().withExistingParent(blockName(block), "cube")
                .texture("particle", resourceBlock(blockName(block) + "_top"))
                .texture("down", resourceBlock(bag + "_bottom"))
                .texture("up", resourceBlock(blockName(block) + "_top"))
                .texture("north", resourceBlock(bag + "_side_tied"))
                .texture("south", resourceBlock(bag + "_side_tied"))
                .texture("east", resourceBlock(bag + "_side"))
                .texture("west", resourceBlock(bag + "_side"))
        );
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

    public void bananaStemBlock(BananaStem block) {
        String blockName = blockName(block);
        getVariantBuilder(block)
                .forAllStates(state -> {
                    int stage = state.getValue(STAGE);
                    String stemSuffix = "";
                    switch (stage) {
                        case 0 -> {
                            stemSuffix = "";
                        }
                        case 1 -> {
                            stemSuffix = "_transition";
                        }
                        case 2 -> {
                            stemSuffix = "_upper";
                        }
                    }
                    Direction.Axis axis = state.getValue(BlockStateProperties.AXIS);
                    int rotX = 0; int rotY = 0;
                    switch (axis) {
                        case X -> {
                            rotX = 90; rotY = 90;
                        }
                        case Y -> {
                            rotX = 0; rotY = 0;
                        }
                        case Z -> {
                            rotX = 90; rotY = 0;
                        }
                    }
                    ConfiguredModel.Builder<?> builder = ConfiguredModel.builder()
                            .modelFile(models().cubeColumn(blockName+stemSuffix,resourceBlock(blockName+stemSuffix),resourceBlock(blockName + "_top"+stemSuffix))).rotationX(rotX).rotationY(rotY);
                    return builder.build();
                });
        simpleBlockItem(block,models().cubeColumn(blockName,resourceBlock(blockName),resourceBlock(blockName+"_top")));
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

    public void customDoubleStageBlock(DoubleCropBlock block, @Nullable ResourceLocation parent, String textureKey, IntegerProperty ageProperty, List<Integer> suffixes, Property<?>... ignored) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    int ageSuffix = state.getValue(ageProperty);
                    String upperSuffix = ((state.getValue(HALF) == DoubleBlockHalf.UPPER) && (ageSuffix >= block.getAgeForUpper())) ? "_upper" : "";
                    String stageName = blockName(block) + "_stage";
                    stageName += suffixes.isEmpty() ? ageSuffix + upperSuffix : suffixes.get(Math.min(suffixes.size(), ageSuffix)) + upperSuffix;
                    if (parent == null) {
                        return ConfiguredModel.builder()
                                .modelFile(models().cross(stageName, resourceBlock(stageName)).renderType("cutout")).build();
                    }
                    return ConfiguredModel.builder()
                            .modelFile(models().singleTexture(stageName, parent, textureKey, resourceBlock(stageName)).renderType("cutout")).build();
                });
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

    public void pieBlock(Block block) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                            int bites = state.getValue(PieBlock.BITES);
                            String suffix = bites > 0 ? "_slice" + bites : "";
                            return ConfiguredModel.builder()
                                    .modelFile(existingModel(blockName(block) + suffix))
                                    .rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360)
                                    .build();
                        }
                );
    }

}