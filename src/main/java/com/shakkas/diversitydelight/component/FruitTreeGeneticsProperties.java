package com.shakkas.diversitydelight.component;

import java.util.List;

public record FruitTreeGeneticsProperties(int baseGrowthChance, int baseMutation, int baseYield, int baseGrowth, List<String> stableFruits, List<String> unstableFruits) {
    public static class Builder {
        private int baseGrowthChance;
        private int baseMutation;
        private int baseYield;
        private int baseGrowth;
        private List<String> stableFruits;
        private List<String> unstableFruits;

        public Builder baseGrowthChance(int baseGrowthChance) {
            this.baseGrowthChance = baseGrowthChance;
            return this;
        }
        public Builder baseMutation(int baseMutation) {
            this.baseMutation = baseMutation;
            return this;
        }
        public Builder baseYield(int baseYield) {
            this.baseYield = baseYield;
            return this;
        }
        public Builder baseGrowth(int baseGrowth) {
            this.baseGrowth = baseGrowth;
            return this;
        }

        public Builder stableFruits(List<String> stableFruits) {
            this.stableFruits = stableFruits;
            return this;
        }
        public Builder unstableFruits(List<String> unstableFruits) {
            this.unstableFruits = unstableFruits;
            return this;
        }

        public FruitTreeGeneticsProperties build() {
            return new FruitTreeGeneticsProperties(this.baseGrowthChance,this.baseMutation,this.baseYield,this.baseGrowth,this.stableFruits,this.unstableFruits);
        }
    }
}
