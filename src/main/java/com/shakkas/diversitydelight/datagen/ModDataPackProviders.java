package com.shakkas.diversitydelight.datagen;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.world.DDBiomeModifiers;
import com.shakkas.diversitydelight.world.DDConfiguredFeatures;
import com.shakkas.diversitydelight.world.DDPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDataPackProviders extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, DDConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, DDPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, DDBiomeModifiers::bootstrap);

    public ModDataPackProviders(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(DiversityDelight.MODID));
    }
}
