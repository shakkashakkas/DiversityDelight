package com.shakkas.diversitydelight.component;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.food.FoodProperties;
import net.neoforged.neoforge.network.codec.NeoForgeStreamCodecs;

public class FruitProbeProperties {
    public static final Codec<FruitProbeMode> CODEC =
            Codec.INT.xmap(i -> FruitProbeMode.values()[i], FruitProbeMode::ordinal
    );

    public static final StreamCodec<FriendlyByteBuf, FruitProbeMode> STREAM_CODEC =
            NeoForgeStreamCodecs.enumCodec(FruitProbeMode.class);
}
