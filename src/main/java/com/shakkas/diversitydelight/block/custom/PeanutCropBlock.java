package com.shakkas.diversitydelight.block.custom;

import com.shakkas.diversitydelight.item.DDModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CarrotBlock;

public class PeanutCropBlock extends CarrotBlock {
    public PeanutCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return DDModItems.PEANUT;
    }
}
