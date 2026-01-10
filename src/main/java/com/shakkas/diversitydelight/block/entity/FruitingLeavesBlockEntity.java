package com.shakkas.diversitydelight.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FruitingLeavesBlockEntity extends BlockEntity {
    public FruitingLeavesBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FRUITING_LEAVES_BE.get(), pos, state);
    }

    public int mutation = 0;
    public int yield = 0;
    public int growth = 0;
    public boolean isPollinated = false;

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.mutation = tag.getInt("mutation");
        this.yield = tag.getInt("yield");
        this.growth = tag.getInt("growth");
        this.isPollinated = tag.getBoolean("pollinated");
    }

    @Override
    public void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("mutation", this.mutation);
        tag.putInt("yield", this.yield);
        tag.putInt("growth", this.growth);
        tag.putBoolean("pollinated",this.isPollinated);
    }

    public void freshGenetics(RandomSource random) {
        mutation = random.nextInt(0,3);
        yield = random.nextInt(0,3);
        growth = random.nextInt(0,3);
    }

    public void resetPollination() {
        isPollinated = false;
        this.setChanged();
    }

    public void setPollinated() {
        isPollinated = true;
        this.setChanged();
    }
}
