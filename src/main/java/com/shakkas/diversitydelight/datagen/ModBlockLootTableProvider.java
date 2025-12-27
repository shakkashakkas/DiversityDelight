package com.shakkas.diversitydelight.datagen;

import com.shakkas.diversitydelight.block.ModBlocks;
import com.shakkas.diversitydelight.block.custom.*;
import com.shakkas.diversitydelight.item.DDModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;


import java.util.HashSet;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    private final Set<Block> generatedLootTables = new HashSet<>();

    @Override
    protected void add(Block block, LootTable.Builder builder) {
        this.generatedLootTables.add(block);
        this.map.put(block.getLootTable(), builder);
    }


    @Override
    protected void generate() {
        LootItemCondition.Builder broccoliLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BROCCOLI_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ColeCropBlock.AGE, ColeCropBlock.MAX_AGE));

        this.add(ModBlocks.BROCCOLI_CROP.get(), this.createCropDrops(ModBlocks.BROCCOLI_CROP.get(),
                DDModItems.BROCCOLI.get(), DDModItems.BROCCOLI_SEEDS.get(), broccoliLootItemConditionBuilder));

        LootItemCondition.Builder cauliflowerLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CAULIFLOWER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ColeCropBlock.AGE, ColeCropBlock.MAX_AGE));

        this.add(ModBlocks.CAULIFLOWER_CROP.get(), this.createCropDrops(ModBlocks.CAULIFLOWER_CROP.get(),
                DDModItems.CAULIFLOWER.get(), DDModItems.CAULIFLOWER_SEEDS.get(), cauliflowerLootItemConditionBuilder));

        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        this.add(ModBlocks.CELERY_CROP.get(), block -> this.applyExplosionDecay(
                block, LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CELERY_CROP.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CeleryCropBlock.AGE, CeleryCropBlock.MAX_AGE))
                                ).add(LootItem.lootTableItem(DDModItems.CELERY.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))))));

        dropOther(ModBlocks.LOWER_CHILI_CROP.get(), DDModItems.CHILI_SEEDS);

        LootItemCondition.Builder upperChiliCropLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.UPPER_CHILI_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UpperDoubleFruitingCropBlock.AGE, UpperDoubleFruitingCropBlock.MAX_AGE));

        this.add(ModBlocks.UPPER_CHILI_CROP.get(), this.createCropDrops(ModBlocks.UPPER_CHILI_CROP.get(),
                DDModItems.CHILI.get(), DDModItems.CHILI_SEEDS.get(), upperChiliCropLootItemConditionBuilder));

        LootItemCondition.Builder lowerGreenBeanCropLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.LOWER_GREEN_BEAN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LowerDoubleFruitingCropBlock.AGE, LowerDoubleFruitingCropBlock.MAX_AGE));

        this.add(ModBlocks.LOWER_GREEN_BEAN_CROP.get(), this.createCropDrops(ModBlocks.LOWER_GREEN_BEAN_CROP.get(),
                DDModItems.GREEN_BEAN.get(), DDModItems.GREEN_BEAN_SEEDS.get(), lowerGreenBeanCropLootItemConditionBuilder));

        LootItemCondition.Builder upperGreenBeanCropLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.UPPER_GREEN_BEAN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UpperDoubleFruitingCropBlock.AGE, UpperDoubleFruitingCropBlock.MAX_AGE));

        this.add(ModBlocks.UPPER_GREEN_BEAN_CROP.get(), this.createCropDrops(ModBlocks.UPPER_GREEN_BEAN_CROP.get(),
                DDModItems.GREEN_BEAN.get(), DDModItems.GREEN_BEAN_SEEDS.get(), upperGreenBeanCropLootItemConditionBuilder));

        LootItemCondition.Builder lowerPeaCropLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.LOWER_PEA_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LowerDoubleFruitingCropBlock.AGE, LowerDoubleFruitingCropBlock.MAX_AGE));

        this.add(ModBlocks.LOWER_PEA_CROP.get(), this.createCropDrops(ModBlocks.LOWER_PEA_CROP.get(),
                DDModItems.PEA.get(), DDModItems.PEA_SEEDS.get(), lowerPeaCropLootItemConditionBuilder));

        LootItemCondition.Builder upperPeaCropLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.UPPER_PEA_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UpperDoubleFruitingCropBlock.AGE, UpperDoubleFruitingCropBlock.MAX_AGE));

        this.add(ModBlocks.UPPER_PEA_CROP.get(), this.createCropDrops(ModBlocks.UPPER_PEA_CROP.get(),
                DDModItems.PEA.get(), DDModItems.PEA_SEEDS.get(), upperPeaCropLootItemConditionBuilder));

        dropOther(ModBlocks.LOWER_BELL_PEPPER_CROP.get(), DDModItems.BELL_PEPPER_SEEDS);

        LootItemCondition.Builder upperBellPepperCropLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.UPPER_BELL_PEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UpperDoubleFruitingCropBlock.AGE, UpperDoubleFruitingCropBlock.MAX_AGE));

        this.add(ModBlocks.UPPER_BELL_PEPPER_CROP.get(), this.createCropDrops(ModBlocks.UPPER_BELL_PEPPER_CROP.get(),
                DDModItems.BELL_PEPPER.get(), DDModItems.BELL_PEPPER_SEEDS.get(), upperBellPepperCropLootItemConditionBuilder));

        dropSelf(ModBlocks.WORM_BIN_BLOCK.get());

        // FEASTS
        LootItemCondition.Builder chickenPotPieLootCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CHICKEN_POT_PIE_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ChickenPotPieBlock.SERVINGS, 0));
        this.add(ModBlocks.CHICKEN_POT_PIE_BLOCK.get(), LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(Items.BOWL).when(chickenPotPieLootCondition).otherwise(LootItem.lootTableItem(Items.AIR)))));

        LootItemCondition.Builder vegetableSticksLootCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.VEGETABLE_STICKS_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(VegetableSticksBlock.STICK_SERVINGS, 0));
        this.add(ModBlocks.VEGETABLE_STICKS_BLOCK.get(), LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(Items.BOWL).when(vegetableSticksLootCondition).otherwise(LootItem.lootTableItem(Items.AIR)))));

        dropSelf(ModBlocks.WORM_BIN_BLOCK.get());
        // Crop Crates
        dropSelf(ModBlocks.BELL_PEPPER_CRATE.get());
        dropSelf(ModBlocks.BROCCOLI_CRATE.get());
        dropSelf(ModBlocks.CAULIFLOWER_CRATE.get());
        dropSelf(ModBlocks.CELERY_CRATE.get());
        dropSelf(ModBlocks.CHILI_CRATE.get());
        dropSelf(ModBlocks.GREEN_BEAN_CRATE.get());
        dropSelf(ModBlocks.PEA_CRATE.get());

        //Fruit Tree
        dropSelf(ModBlocks.APPLE_TREE_SAPLING.get());
        this.add(ModBlocks.APPLE_TREE_LEAVES.get(), this.createLeavesDrops(ModBlocks.APPLE_TREE_LEAVES.get(),ModBlocks.APPLE_TREE_SAPLING.get(),0.55F));
        this.add(ModBlocks.APPLE_TREE_FRUITING_LEAVES.get(), this.createLeavesDrops(ModBlocks.APPLE_TREE_FRUITING_LEAVES.get(),ModBlocks.APPLE_TREE_SAPLING.get(),0.55F));

        dropSelf(ModBlocks.ORANGE_TREE_SAPLING.get());
        dropSelf(ModBlocks.ORANGE_TREE_LOG.get());
        this.add(ModBlocks.ORANGE_TREE_LEAVES.get(), this.createLeavesDrops(ModBlocks.ORANGE_TREE_LEAVES.get(),ModBlocks.ORANGE_TREE_SAPLING.get(),0.55F));
        this.add(ModBlocks.ORANGE_TREE_FRUITING_LEAVES.get(), this.createLeavesDrops(ModBlocks.ORANGE_TREE_FRUITING_LEAVES.get(),ModBlocks.ORANGE_TREE_SAPLING.get(),0.55F));

        dropSelf(ModBlocks.LEMON_TREE_SAPLING.get());
        dropSelf(ModBlocks.LEMON_TREE_LOG.get());
        this.add(ModBlocks.LEMON_TREE_LEAVES.get(), this.createLeavesDrops(ModBlocks.LEMON_TREE_LEAVES.get(),ModBlocks.LEMON_TREE_SAPLING.get(),0.55F));
        this.add(ModBlocks.LEMON_TREE_FRUITING_LEAVES.get(), this.createLeavesDrops(ModBlocks.LEMON_TREE_FRUITING_LEAVES.get(),ModBlocks.LEMON_TREE_SAPLING.get(),0.55F));

        dropSelf(ModBlocks.PEAR_TREE_SAPLING.get());
        dropSelf(ModBlocks.PEAR_TREE_LOG.get());
        this.add(ModBlocks.PEAR_TREE_LEAVES.get(), this.createLeavesDrops(ModBlocks.PEAR_TREE_LEAVES.get(), ModBlocks.PEAR_TREE_SAPLING.get(), 0.55F));
        this.add(ModBlocks.PEAR_TREE_FRUITING_LEAVES.get(), this.createLeavesDrops(ModBlocks.PEAR_TREE_FRUITING_LEAVES.get(), ModBlocks.PEAR_TREE_SAPLING.get(), 0.55F));

        dropSelf(ModBlocks.MANGO_TREE_SAPLING.get());
        dropSelf(ModBlocks.MANGO_TREE_LOG.get());
        this.add(ModBlocks.MANGO_TREE_LEAVES.get(), this.createLeavesDrops(ModBlocks.MANGO_TREE_LEAVES.get(), ModBlocks.MANGO_TREE_SAPLING.get(), 0.55F));
        this.add(ModBlocks.MANGO_TREE_FRUITING_LEAVES.get(), this.createLeavesDrops(ModBlocks.MANGO_TREE_FRUITING_LEAVES.get(), ModBlocks.MANGO_TREE_SAPLING.get(), 0.55F));

        dropSelf(ModBlocks.BANANA_TREE_SAPLING.get());
        dropSelf(ModBlocks.BANANA_TREE_FROND.get());
        dropSelf(ModBlocks.BANANA_TREE_STEM.get());
        dropSelf(ModBlocks.BANANA_BUNCH.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        //return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
        return generatedLootTables;
    }

}