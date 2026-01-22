package com.shakkas.diversitydelight.block.entity;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, DiversityDelight.MODID);

    public static final Supplier<BlockEntityType<FruitingLeavesBlockEntity>> FRUITING_LEAVES_BE =
            BLOCK_ENTITIES.register("fruiting_leaves_be", () -> BlockEntityType.Builder.of(
                    FruitingLeavesBlockEntity::new,
                    ModBlocks.APPLE_TREE_FRUITING_LEAVES.get(),
                    ModBlocks.GOLDEN_APPLE_TREE_FRUITING_LEAVES.get(),
                    ModBlocks.ORANGE_TREE_FRUITING_LEAVES.get(),
                    ModBlocks.LEMON_TREE_FRUITING_LEAVES.get(),
                    ModBlocks.PEAR_TREE_FRUITING_LEAVES.get(),
                    ModBlocks.EMERALD_PEAR_TREE_FRUITING_LEAVES.get(),
                    ModBlocks.MANGO_TREE_FRUITING_LEAVES.get())
                    .build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
