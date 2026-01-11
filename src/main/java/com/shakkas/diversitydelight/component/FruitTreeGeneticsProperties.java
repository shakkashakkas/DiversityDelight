package com.shakkas.diversitydelight.component;

import java.util.List;

public record FruitTreeGeneticsProperties(int baseMutation, int baseYield, int baseGrowth, List<String> stableFruits, List<String> neutralFruits, List<String> unstableFruits) {
    public static class Builder {
        private int baseMutation;
        private int baseYield;
        private int baseGrowth;
        private List<String> stableFruits;
        private List<String> neutralFruits;
        private List<String> unstableFruits;

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
        public Builder neutralFruits(List<String> neutralFruits) {
            this.neutralFruits = neutralFruits;
            return this;
        }
        public Builder unstableFruits(List<String> unstableFruits) {
            this.unstableFruits = unstableFruits;
            return this;
        }

        public FruitTreeGeneticsProperties build() {
            return new FruitTreeGeneticsProperties(this.baseMutation,this.baseYield,this.baseGrowth,this.stableFruits,this.neutralFruits,this.unstableFruits);
        }
    }
}
