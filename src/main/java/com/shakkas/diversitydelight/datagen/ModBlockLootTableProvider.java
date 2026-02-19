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
import net.minecraft.world.level.block.Blocks;
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

        this.add(ModBlocks.PEANUT_CROP.get(), block -> this.applyExplosionDecay(
                block, LootTable.lootTable().withPool(LootPool.lootPool().when(
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.PEANUT_CROP.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PeanutCropBlock.AGE, PeanutCropBlock.MAX_AGE))
                        ).add(LootItem.lootTableItem(DDModItems.PEANUT.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))))));

        LootItemCondition.Builder oatsLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.OATS_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OatsCropBlock.AGE, OatsCropBlock.MAX_AGE));

        this.add(ModBlocks.OATS_CROP.get(), this.createCropDrops(ModBlocks.OATS_CROP.get(),
                DDModItems.OATS.get(), DDModItems.OAT_SEEDS.get(), oatsLootItemConditionBuilder));


        LootItemCondition.Builder bellPepperCropLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BELL_PEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoubleCropBlock.AGE, DoubleCropBlock.MAX_AGE));

        this.add(ModBlocks.BELL_PEPPER_CROP.get(), this.createCropDrops(ModBlocks.BELL_PEPPER_CROP.get(),
                DDModItems.BELL_PEPPER.get(), DDModItems.BELL_PEPPER_SEEDS.get(), bellPepperCropLootItemConditionBuilder));

        LootItemCondition.Builder peaCropLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.PEA_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoubleCropBlock.AGE, DoubleCropBlock.MAX_AGE));

        this.add(ModBlocks.PEA_CROP.get(), this.createCropDrops(ModBlocks.PEA_CROP.get(),
                DDModItems.PEA.get(), DDModItems.PEA_SEEDS.get(), peaCropLootItemConditionBuilder));

        LootItemCondition.Builder greenBeanCropLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GREEN_BEAN_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoubleCropBlock.AGE, DoubleCropBlock.MAX_AGE));

        this.add(ModBlocks.GREEN_BEAN_CROP.get(), this.createCropDrops(ModBlocks.GREEN_BEAN_CROP.get(),
                DDModItems.GREEN_BEAN.get(), DDModItems.GREEN_BEAN_SEEDS.get(), greenBeanCropLootItemConditionBuilder));

        LootItemCondition.Builder chiliCropLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CHILI_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoubleCropBlock.AGE, DoubleCropBlock.MAX_AGE));

        this.add(ModBlocks.CHILI_CROP.get(), this.createCropDrops(ModBlocks.CHILI_CROP.get(),
                DDModItems.CHILI.get(), DDModItems.CHILI_SEEDS.get(), chiliCropLootItemConditionBuilder));

        LootItemCondition.Builder soyCropLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SOY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoubleCropBlock.AGE, DoubleCropBlock.MAX_AGE));

        this.add(ModBlocks.SOY_CROP.get(), this.createCropDrops(ModBlocks.SOY_CROP.get(),
                DDModItems.SOY.get(), DDModItems.SOY_BEANS.get(), soyCropLootItemConditionBuilder));


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

        dropSelf(ModBlocks.APPLE_BAG.get());
        dropSelf(ModBlocks.BANANA_BAG.get());
        dropSelf(ModBlocks.KIWI_BAG.get());
        dropSelf(ModBlocks.LEMON_BAG.get());
        dropSelf(ModBlocks.MANGO_BAG.get());
        dropSelf(ModBlocks.ORANGE_BAG.get());
        dropSelf(ModBlocks.PEAR_BAG.get());
        dropSelf(ModBlocks.PINEAPPLE_BAG.get());


        //Fruit Tree
        dropSelf(ModBlocks.APPLE_TREE_SAPLING.get());
        this.add(ModBlocks.APPLE_TREE_LEAVES.get(), this.createLeavesDrops(ModBlocks.APPLE_TREE_LEAVES.get(),ModBlocks.APPLE_TREE_SAPLING.get(),0.55F));
        this.add(ModBlocks.APPLE_TREE_FRUITING_LEAVES.get(), this.createLeavesDrops(Blocks.AIR,ModBlocks.APPLE_TREE_SAPLING.get(),0.55F));

        dropSelf(ModBlocks.ORANGE_TREE_SAPLING.get());
        dropSelf(ModBlocks.ORANGE_TREE_LOG.get());
        this.add(ModBlocks.ORANGE_TREE_LEAVES.get(), this.createLeavesDrops(ModBlocks.ORANGE_TREE_LEAVES.get(),ModBlocks.ORANGE_TREE_SAPLING.get(),0.55F));
        this.add(ModBlocks.ORANGE_TREE_FRUITING_LEAVES.get(), this.createLeavesDrops(Blocks.AIR,ModBlocks.ORANGE_TREE_SAPLING.get(),0.55F));

        dropSelf(ModBlocks.LEMON_TREE_SAPLING.get());
        dropSelf(ModBlocks.LEMON_TREE_LOG.get());
        this.add(ModBlocks.LEMON_TREE_LEAVES.get(), this.createLeavesDrops(ModBlocks.LEMON_TREE_LEAVES.get(),ModBlocks.LEMON_TREE_SAPLING.get(),0.55F));
        this.add(ModBlocks.LEMON_TREE_FRUITING_LEAVES.get(), this.createLeavesDrops(Blocks.AIR,ModBlocks.LEMON_TREE_SAPLING.get(),0.55F));

        dropSelf(ModBlocks.PEAR_TREE_SAPLING.get());
        dropSelf(ModBlocks.PEAR_TREE_LOG.get());
        this.add(ModBlocks.PEAR_TREE_LEAVES.get(), this.createLeavesDrops(ModBlocks.PEAR_TREE_LEAVES.get(), ModBlocks.PEAR_TREE_SAPLING.get(), 0.55F));
        this.add(ModBlocks.PEAR_TREE_FRUITING_LEAVES.get(), this.createLeavesDrops(Blocks.AIR, ModBlocks.PEAR_TREE_SAPLING.get(), 0.55F));

        dropSelf(ModBlocks.MANGO_TREE_SAPLING.get());
        dropSelf(ModBlocks.MANGO_TREE_LOG.get());
        this.add(ModBlocks.MANGO_TREE_LEAVES.get(), this.createLeavesDrops(ModBlocks.MANGO_TREE_LEAVES.get(), ModBlocks.MANGO_TREE_SAPLING.get(), 0.55F));
        this.add(ModBlocks.MANGO_TREE_FRUITING_LEAVES.get(), this.createLeavesDrops(Blocks.AIR, ModBlocks.MANGO_TREE_SAPLING.get(), 0.55F));

        dropSelf(ModBlocks.BANANA_TREE_SAPLING.get());
        this.add(ModBlocks.BANANA_TREE_FROND.get(), this.createLeavesDrops(ModBlocks.BANANA_TREE_FROND.get(),ModBlocks.BANANA_TREE_SAPLING.get(),0.55F));
        dropSelf(ModBlocks.BANANA_TREE_STEM.get());

        dropSelf(ModBlocks.ALMOND_TREE_SAPLING.get());
        dropSelf(ModBlocks.ALMOND_TREE_LOG.get());
        this.add(ModBlocks.ALMOND_TREE_LEAVES.get(), this.createLeavesDrops(ModBlocks.ALMOND_TREE_LEAVES.get(), ModBlocks.ALMOND_TREE_SAPLING.get(), 0.55F));
        this.add(ModBlocks.ALMOND_TREE_FRUITING_LEAVES.get(), this.createLeavesDrops(Blocks.AIR, ModBlocks.ALMOND_TREE_SAPLING.get(), 0.55F));

        dropSelf(ModBlocks.PISTACHIO_TREE_SAPLING.get());
        dropSelf(ModBlocks.PISTACHIO_TREE_LOG.get());
        this.add(ModBlocks.PISTACHIO_TREE_LEAVES.get(), this.createLeavesDrops(ModBlocks.PISTACHIO_TREE_LEAVES.get(), ModBlocks.PISTACHIO_TREE_SAPLING.get(), 0.55F));
        this.add(ModBlocks.PISTACHIO_TREE_FRUITING_LEAVES.get(), this.createLeavesDrops(Blocks.AIR, ModBlocks.PISTACHIO_TREE_SAPLING.get(), 0.55F));

        dropSelf(ModBlocks.WALNUT_TREE_SAPLING.get());
        dropSelf(ModBlocks.WALNUT_TREE_LOG.get());
        this.add(ModBlocks.WALNUT_TREE_LEAVES.get(), this.createLeavesDrops(ModBlocks.WALNUT_TREE_LEAVES.get(), ModBlocks.WALNUT_TREE_SAPLING.get(), 0.55F));
        this.add(ModBlocks.WALNUT_TREE_FRUITING_LEAVES.get(), this.createLeavesDrops(Blocks.AIR, ModBlocks.WALNUT_TREE_SAPLING.get(), 0.55F));


        dropOther(ModBlocks.KIWI_BUDDING_CROP.get(),DDModItems.KIWI.get());
        dropOther(ModBlocks.KIWI_CROP.get(),DDModItems.KIWI.get());
        dropOther(ModBlocks.GOLDEN_APPLE_TREE_FRUITING_LEAVES.get(), Blocks.AIR);
        dropOther(ModBlocks.EMERALD_PEAR_TREE_FRUITING_LEAVES.get(), Blocks.AIR);

        dropWhenSilkTouch(ModBlocks.BANOFFEE_PIE_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.LEMON_MERINGUE_PIE_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.FRUIT_FLAN_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.PEAR_PIE_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.HAWAIIAN_PIZZA_BLOCK.get());

        LootItemCondition.Builder pineappleLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.PINEAPPLE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PineappleCropBlock.AGE, PineappleCropBlock.MAX_AGE));

        this.add(ModBlocks.PINEAPPLE_CROP.get(), this.createCropDrops(ModBlocks.PINEAPPLE_CROP.get(),
                DDModItems.PINEAPPLE.get(), Items.AIR, pineappleLootItemConditionBuilder));

        LootItemCondition.Builder bananaLootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BANANA_BUNCH.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BananaBunch.AGE, BananaBunch.MAX_AGE));

        this.add(ModBlocks.BANANA_BUNCH.get(), this.createCropDrops(ModBlocks.BANANA_BUNCH.get(),
                DDModItems.BANANA.get(), Items.AIR, bananaLootItemConditionBuilder));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        //return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
        return generatedLootTables;
    }

}