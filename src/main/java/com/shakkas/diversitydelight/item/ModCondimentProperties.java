package com.shakkas.diversitydelight.item;

import com.shakkas.diversitydelight.component.CondimentProperties;
import com.shakkas.diversitydelight.effect.DDModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class ModCondimentProperties {
    public static final CondimentProperties KETCHUP = new CondimentProperties.Builder().nutritionBonus(1).fast(true).build();
    public static final CondimentProperties MARMALADE = new CondimentProperties.Builder().nutritionBonus(1).effect(() -> new MobEffectInstance(DDModEffects.IMMUNITY_EFFECT, 200, 0, false, false), 1.0F).build();
    public static final CondimentProperties MAYONNAISE = new CondimentProperties.Builder().nutritionBonus(2).saturationBonus(0.5f).build();
    public static final CondimentProperties HOT_SAUCE = new CondimentProperties.Builder().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false), 1.0F).build();
    public static final CondimentProperties PEANUT_BUTTER = new CondimentProperties.Builder().nutritionBonus(2).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0, false, false), 1.0F).build();
}
