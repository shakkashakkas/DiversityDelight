package com.shakkas.diversitydelight.datagen;

import com.shakkas.diversitydelight.item.DDModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(DDModItems.BELL_PEPPER_SEEDS.getId(), new Compostable(0.25f), false)
                .add(DDModItems.BELL_PEPPER.getId(), new Compostable(0.45f), false)
                .add(DDModItems.BROCCOLI_SEEDS.getId(), new Compostable(0.25f), false)
                .add(DDModItems.BROCCOLI.getId(), new Compostable(0.45f), false)
                .add(DDModItems.CAULIFLOWER.getId(), new Compostable(0.45f), false)
                .add(DDModItems.CAULIFLOWER_SEEDS.getId(), new Compostable(0.25f), false)
                .add(DDModItems.CHILI.getId(), new Compostable(0.45f), false)
                .add(DDModItems.CHILI_SEEDS.getId(), new Compostable(0.25f), false)
                .add(DDModItems.CELERY.getId(), new Compostable(0.45f), false)
                .add(DDModItems.GREEN_BEAN.getId(), new Compostable(0.45f), false)
                .add(DDModItems.GREEN_BEAN_SEEDS.getId(), new Compostable(0.25f), false)
                .add(DDModItems.PEA.getId(), new Compostable(0.45f), false)
                .add(DDModItems.PEA_SEEDS.getId(), new Compostable(0.25f), false);
    }
}
