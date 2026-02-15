package com.shakkas.diversitydelight.block.custom;

import com.shakkas.diversitydelight.block.ModBlocks;
import com.shakkas.diversitydelight.component.CondimentProperties;
import com.shakkas.diversitydelight.component.FruitTreeGeneticsProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class ModFruitTreeGenetics {
    public static final List<String> ROSE = createFruitFamily(
            ModBlocks.APPLE_TREE_FRUITING_LEAVES.get(),
            ModBlocks.GOLDEN_APPLE_TREE_FRUITING_LEAVES.get(),
            ModBlocks.PEAR_TREE_FRUITING_LEAVES.get(),
            ModBlocks.EMERALD_PEAR_TREE_FRUITING_LEAVES.get(),
            ModBlocks.ALMOND_TREE_FRUITING_LEAVES.get());
    public static final List<String> CASHEW = createFruitFamily(
            ModBlocks.MANGO_TREE_FRUITING_LEAVES.get(),
            ModBlocks.PISTACHIO_TREE_SAPLING.get());
    public static final List<String> CITRUS = createFruitFamily(
            ModBlocks.LEMON_TREE_FRUITING_LEAVES.get(),
            ModBlocks.ORANGE_TREE_FRUITING_LEAVES.get());
    public static final List<String> JUGLANS = createFruitFamily(
            ModBlocks.WALNUT_TREE_SAPLING.get());

    public static final FruitTreeGeneticsProperties APPLE = new FruitTreeGeneticsProperties.Builder().baseGrowthChance(80).baseMutation(1).baseYield(3).baseGrowth(2).stableFruits(ROSE).unstableFruits(CASHEW).build();
    public static final FruitTreeGeneticsProperties GOLDEN_APPLE = new FruitTreeGeneticsProperties.Builder().baseGrowthChance(240).baseMutation(1).baseYield(3).baseGrowth(2).stableFruits(ROSE).unstableFruits(CASHEW).build();
    public static final FruitTreeGeneticsProperties PEAR = new FruitTreeGeneticsProperties.Builder().baseGrowthChance(80).baseMutation(3).baseYield(0).baseGrowth(3).stableFruits(ROSE).unstableFruits(CASHEW).build();
    public static final FruitTreeGeneticsProperties EMERALD_PEAR = new FruitTreeGeneticsProperties.Builder().baseGrowthChance(240).baseMutation(3).baseYield(0).baseGrowth(3).stableFruits(ROSE).unstableFruits(CASHEW).build();
    public static final FruitTreeGeneticsProperties ORANGE = new FruitTreeGeneticsProperties.Builder().baseGrowthChance(80).baseMutation(4).baseYield(1).baseGrowth(1).stableFruits(CITRUS).unstableFruits(CASHEW).build();
    public static final FruitTreeGeneticsProperties LEMON = new FruitTreeGeneticsProperties.Builder().baseGrowthChance(80).baseMutation(2).baseYield(0).baseGrowth(4).stableFruits(CITRUS).unstableFruits(CASHEW).build();
    public static final FruitTreeGeneticsProperties MANGO = new FruitTreeGeneticsProperties.Builder().baseGrowthChance(80).baseMutation(0).baseYield(2).baseGrowth(4).stableFruits(CASHEW).unstableFruits(ROSE).build();
    public static final FruitTreeGeneticsProperties ALMOND = new FruitTreeGeneticsProperties.Builder().baseGrowthChance(80).baseMutation(3).baseYield(2).baseGrowth(1).stableFruits(ROSE).unstableFruits(CASHEW).build();
    public static final FruitTreeGeneticsProperties PISTACHIO = new FruitTreeGeneticsProperties.Builder().baseGrowthChance(80).baseMutation(1).baseYield(4).baseGrowth(1).stableFruits(CASHEW).unstableFruits(ROSE).build();
    public static final FruitTreeGeneticsProperties WALNUT = new FruitTreeGeneticsProperties.Builder().baseGrowthChance(80).baseMutation(2).baseYield(2).baseGrowth(2).stableFruits(JUGLANS).unstableFruits(CITRUS).build();

    public static List<String> createFruitFamily(Block... block) {
        List<String> fruitFamily = new ArrayList<>();
        for (Block b : block) {
            String fruitType = BuiltInRegistries.BLOCK.getKey(b).toString();
            fruitFamily.add(fruitType);
        }
        return fruitFamily;
    }
}
