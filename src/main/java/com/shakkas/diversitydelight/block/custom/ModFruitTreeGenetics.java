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
    public static final List<String> ROSE = createFruitFamily(ModBlocks.APPLE_TREE_FRUITING_LEAVES.get(),ModBlocks.PEAR_TREE_FRUITING_LEAVES.get());
    public static final List<String> CASHEW = createFruitFamily(ModBlocks.MANGO_TREE_FRUITING_LEAVES.get());
    public static final List<String> CITRUS = createFruitFamily(ModBlocks.LEMON_TREE_FRUITING_LEAVES.get(),ModBlocks.ORANGE_TREE_FRUITING_LEAVES.get());

    public static final FruitTreeGeneticsProperties APPLE = new FruitTreeGeneticsProperties.Builder().baseMutation(2).baseYield(1).baseGrowth(1).stableFruits(ROSE).neutralFruits(CITRUS).unstableFruits(CASHEW).build();
    public static final FruitTreeGeneticsProperties PEAR = new FruitTreeGeneticsProperties.Builder().baseMutation(1).baseYield(1).baseGrowth(1).stableFruits(ROSE).neutralFruits(CITRUS).unstableFruits(CASHEW).build();
    public static final FruitTreeGeneticsProperties ORANGE = new FruitTreeGeneticsProperties.Builder().baseMutation(1).baseYield(2).baseGrowth(0).stableFruits(CITRUS).neutralFruits(ROSE).unstableFruits(CASHEW).build();
    public static final FruitTreeGeneticsProperties LEMON = new FruitTreeGeneticsProperties.Builder().baseMutation(0).baseYield(2).baseGrowth(0).stableFruits(CITRUS).neutralFruits(ROSE).unstableFruits(CASHEW).build();
    public static final FruitTreeGeneticsProperties MANGO = new FruitTreeGeneticsProperties.Builder().baseMutation(0).baseYield(0).baseGrowth(2).stableFruits(CASHEW).neutralFruits(CITRUS).unstableFruits(ROSE).build();

    public static List<String> createFruitFamily(Block... block) {
        List<String> fruitFamily = new ArrayList<>();
        for (Block b : block) {
            String fruitType = BuiltInRegistries.BLOCK.getKey(b).toString();
            fruitFamily.add(fruitType);
        }
        return fruitFamily;
    }
}
