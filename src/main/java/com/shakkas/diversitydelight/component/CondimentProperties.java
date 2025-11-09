package com.shakkas.diversitydelight.component;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

import java.util.List;
import java.util.function.Supplier;

public record CondimentProperties(int nutritionBonus, float saturationBonus, boolean alwaysEdible, boolean fast,List<FoodProperties.PossibleEffect> extraEffects) {
    public static final Codec<CondimentProperties> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.optionalFieldOf("nutritionBonus",0).forGetter(CondimentProperties::nutritionBonus),
                    Codec.FLOAT.optionalFieldOf("saturationBonus",0.0f).forGetter(CondimentProperties::saturationBonus),
                    Codec.BOOL.optionalFieldOf("alwaysEdible",false).forGetter(CondimentProperties::alwaysEdible),
                    Codec.BOOL.optionalFieldOf("fast",false).forGetter(CondimentProperties::fast),
                    Codec.list(FoodProperties.PossibleEffect.CODEC).optionalFieldOf("extraEffects",List.of()).forGetter(CondimentProperties::extraEffects)
            ).apply(instance, CondimentProperties::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, CondimentProperties> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, CondimentProperties::nutritionBonus,
            ByteBufCodecs.FLOAT, CondimentProperties::saturationBonus,
            ByteBufCodecs.BOOL, CondimentProperties::alwaysEdible,
            ByteBufCodecs.BOOL, CondimentProperties::fast,
            FoodProperties.PossibleEffect.STREAM_CODEC.apply(ByteBufCodecs.list()), CondimentProperties::extraEffects,
            CondimentProperties::new
    );

    public static final CondimentProperties EMPTY = new CondimentProperties(0, 0.0f, false, false, List.of());

    public static class Builder {
        private int nutritionBonus = 0;
        private float saturationBonus = 0.0f;
        private boolean alwaysEdible = false;
        private boolean fast = false;
        private final ImmutableList.Builder<FoodProperties.PossibleEffect> effects = ImmutableList.builder();

        public Builder nutritionBonus(int nutritionBonus) {
            this.nutritionBonus = nutritionBonus;
            return this;
        }

        public Builder saturationBonus(float saturationBonus) {
            this.saturationBonus = saturationBonus;
            return this;
        }

        public Builder alwaysEdible(boolean alwaysEdible) {
            this.alwaysEdible = alwaysEdible;
            return this;
        }

        public Builder fast(boolean fast) {
            this.fast = fast;
            return this;
        }

        public Builder effect(Supplier<MobEffectInstance> effectIn, float probability) {
            this.effects.add(new FoodProperties.PossibleEffect(effectIn, probability));
            return this;
        }

        public CondimentProperties build() {
            return new CondimentProperties(this.nutritionBonus, this.saturationBonus, this.alwaysEdible, this.fast, this.effects.build());
        }
    }
}
