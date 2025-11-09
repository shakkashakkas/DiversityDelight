package com.shakkas.diversitydelight.item;

import com.shakkas.diversitydelight.component.CondimentProperties;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class ModCondimentProperties {
    public static final CondimentProperties KETCHUP = new CondimentProperties.Builder().nutritionBonus(1).fast(true).build();
    public static final CondimentProperties MAYONNAISE = new CondimentProperties.Builder().nutritionBonus(2).saturationBonus(0.5f).build();
    public static final CondimentProperties HOT_SAUCE = new CondimentProperties.Builder().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0, false, false), 1.0F).build();
}
