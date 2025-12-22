package com.shakkas.diversitydelight.world.tree;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.world.DDConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class DDTreeGrowers {
    public static final TreeGrower ORANGE_FRUIT = new TreeGrower(DiversityDelight.MODID + ":orange_tree",
            Optional.empty(), Optional.of(DDConfiguredFeatures.ORANGE_FRUIT_KEY), Optional.empty());
}
