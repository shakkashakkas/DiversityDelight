package com.shakkas.diversitydelight.component;

import com.shakkas.diversitydelight.DiversityDelight;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModComponents {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, DiversityDelight.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CondimentProperties>> CONDIMENT_PROPERTIES = DATA_COMPONENTS.registerComponentType(
            "condiment_properties",
            builder -> builder
                    .persistent(CondimentProperties.CODEC)
                    .networkSynchronized(CondimentProperties.STREAM_CODEC)
    );

    public static void register(IEventBus bus) {
        DATA_COMPONENTS.register(bus);
    }
}
