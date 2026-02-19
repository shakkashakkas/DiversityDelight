package com.shakkas.diversitydelight.block.custom;

import com.shakkas.diversitydelight.item.DDModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class OatsCropBlock extends CropBlock {
    public OatsCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return DDModItems.OAT_SEEDS;
    }
}
