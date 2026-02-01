package com.shakkas.diversitydelight.block.entity;

import com.shakkas.diversitydelight.component.FruitTreeGeneticsProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FruitingLeavesBlockEntity extends BlockEntity {
    public FruitingLeavesBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FRUITING_LEAVES_BE.get(), pos, state);
    }
    public static int MAX_GENETIC_VALUE = 9;
    public static int MIN_GENETIC_VALUE = 0;
    public static int DIST_DOMINANCE = 3;
    public int mutation = 0;
    public int yield = 0;
    public int growth = 0;
    public boolean isPollinated = false;
    public ListTag stable = new ListTag();
    public ListTag unstable = new ListTag();

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.mutation = tag.getInt("mutation");
        this.yield = tag.getInt("yield");
        this.growth = tag.getInt("growth");
        this.stable = tag.getList("stableFruits", Tag.TAG_STRING);
        this.unstable = tag.getList("unstableFruits", Tag.TAG_STRING);
        this.isPollinated = tag.getBoolean("pollinated");
    }

    @Override
    public void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("mutation", this.mutation);
        tag.putInt("yield", this.yield);
        tag.putInt("growth", this.growth);
        tag.putBoolean("pollinated",this.isPollinated);
        tag.put("stableFruits",this.stable);
        tag.put("unstableFruits",this.unstable);
    }

    public void freshGenetics(FruitTreeGeneticsProperties treeGenetics) {
        mutation = treeGenetics.baseMutation();
        yield = treeGenetics.baseYield();
        growth = treeGenetics.baseGrowth();

        for (String fruitType : treeGenetics.stableFruits()) {
            stable.add(StringTag.valueOf(fruitType));
        }
        for (String fruitType : treeGenetics.unstableFruits()) {
            unstable.add(StringTag.valueOf(fruitType));
        }
    }

    public void freshGenetics(int freshMutation, int freshYield, int freshGrowth) {
        mutation = freshMutation;
        yield = freshYield;
        growth = freshGrowth;
    }

    public void crossPollinate(RandomSource random, int maleMutation, int maleYield, int maleGrowth, String fruitType) {
        int femaleMutation = this.mutation;
        int femaleYield = this.yield;
        int femaleGrowth = this.growth;

        int tempMutation = randomiseInheritance(random, maleMutation, femaleMutation);
        int tempYield = randomiseInheritance(random, maleYield, femaleYield);
        int tempGrowth = randomiseInheritance(random, maleGrowth, femaleGrowth);

        mutation = Mth.clamp(mutateGene(random,tempMutation,fruitType),MIN_GENETIC_VALUE,MAX_GENETIC_VALUE);
        yield = Mth.clamp(mutateGene(random,mutation,tempYield,fruitType),MIN_GENETIC_VALUE,MAX_GENETIC_VALUE);
        growth = Mth.clamp(mutateGene(random,mutation,tempGrowth,fruitType),MIN_GENETIC_VALUE,MAX_GENETIC_VALUE);

        this.setChanged();
    }

    public int randomiseInheritance(RandomSource random, int gene1, int gene2) {
        if (Mth.abs(gene1-gene2) >= DIST_DOMINANCE) {
            return (gene1 > gene2) ? gene1 : gene2;
        }
        return (random.nextInt(2) == 0) ? gene1 : gene2;
    }

    public boolean isMatching(ListTag listTag, String fruitType) {
        for (int i = 0; i < listTag.size(); i++) {
            if (listTag.getString(i).equals(fruitType)) {
                return true;
            }
        }
        return false;
    }

    public int mutateGene(RandomSource random, int gene, String fruitType) {
        boolean isUnstable = isMatching(this.unstable,fruitType);
        if (isUnstable && (random.nextInt(2) == 0)) {
            return gene + 1;
        }
        return gene;
    }

    public int mutateGene(RandomSource random, int mutation, int gene, String fruitType) {
        int mutationChance = 11 - mutation;
        if (random.nextInt(mutationChance/2) == 0) {
            boolean isStable = isMatching(this.stable,fruitType);
            int mutationBonus = isStable ? 1 : 0;
            return (random.nextInt(2) == 0) ? (gene + 1) : (gene - 1 + mutationBonus);
        }
        return gene;
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
