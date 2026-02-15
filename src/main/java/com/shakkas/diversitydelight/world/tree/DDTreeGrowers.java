package com.shakkas.diversitydelight.world.tree;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.world.DDConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class DDTreeGrowers {
    public static final TreeGrower APPLE_FRUIT = new TreeGrower(DiversityDelight.MODID + ":apple_tree",
            Optional.empty(), Optional.of(DDConfiguredFeatures.APPLE_FRUIT_KEY), Optional.empty());
    public static final TreeGrower ORANGE_FRUIT = new TreeGrower(DiversityDelight.MODID + ":orange_tree",
            Optional.empty(), Optional.of(DDConfiguredFeatures.ORANGE_FRUIT_KEY), Optional.empty());
    public static final TreeGrower LEMON_FRUIT = new TreeGrower(DiversityDelight.MODID + ":lemon_tree",
            Optional.empty(), Optional.of(DDConfiguredFeatures.LEMON_FRUIT_KEY), Optional.empty());
    public static final TreeGrower PEAR_FRUIT = new TreeGrower(DiversityDelight.MODID + ":pear_tree",
            Optional.empty(), Optional.of(DDConfiguredFeatures.PEAR_FRUIT_KEY), Optional.empty());
    public static final TreeGrower MANGO_FRUIT = new TreeGrower(DiversityDelight.MODID + ":mango_tree",
            Optional.empty(), Optional.of(DDConfiguredFeatures.MANGO_FRUIT_KEY), Optional.empty());
    public static final TreeGrower ALMOND_FRUIT = new TreeGrower(DiversityDelight.MODID + ":almond_tree",
            Optional.empty(), Optional.of(DDConfiguredFeatures.ALMOND_FRUIT_KEY), Optional.empty());
    public static final TreeGrower PISTACHIO_FRUIT = new TreeGrower(DiversityDelight.MODID + ":pistachio_tree",
            Optional.empty(), Optional.of(DDConfiguredFeatures.PISTACHIO_FRUIT_KEY), Optional.empty());
    public static final TreeGrower WALNUT_FRUIT = new TreeGrower(DiversityDelight.MODID + ":walnut_tree",
            Optional.empty(), Optional.of(DDConfiguredFeatures.WALNUT_FRUIT_KEY), Optional.empty());
    public static final TreeGrower BANANA_FRUIT = new TreeGrower(DiversityDelight.MODID + ":banana_tree",
            Optional.empty(), Optional.of(DDConfiguredFeatures.BANANA_FRUIT_KEY), Optional.empty());
}
