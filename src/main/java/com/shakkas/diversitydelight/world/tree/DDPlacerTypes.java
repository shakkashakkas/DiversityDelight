package com.shakkas.diversitydelight.world.tree;

import com.shakkas.diversitydelight.DiversityDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class DDPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, DiversityDelight.MODID);
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, DiversityDelight.MODID);

    public static final Supplier<TrunkPlacerType<BananaTrunkPlacer>> BANANA_TRUNK =
            TRUNK_PLACERS.register("banana", () -> new TrunkPlacerType<>(BananaTrunkPlacer.CODEC));

    public static final Supplier<FoliagePlacerType<BananaFoliagePlacer>> BANANA_FOLIAGE =
            FOLIAGE_PLACERS.register("banana", () -> new FoliagePlacerType<>(BananaFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACERS.register(eventBus);
        FOLIAGE_PLACERS.register(eventBus);
    }
}
