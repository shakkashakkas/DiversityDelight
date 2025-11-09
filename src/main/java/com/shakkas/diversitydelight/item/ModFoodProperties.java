package com.shakkas.diversitydelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;


public class ModFoodProperties {
    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes

    public static MobEffectInstance comfort(int duration) {
        return new MobEffectInstance(ModEffects.COMFORT, duration, 0, false, false);
    }

    public static MobEffectInstance nourishment(int duration) {
        return new MobEffectInstance(ModEffects.NOURISHMENT, duration, 0, false, false);
    }

    public static final FoodProperties BELL_PEPPER = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f)
            .build();
    public static final FoodProperties BROCCOLI = new FoodProperties.Builder().nutrition(3).saturationModifier(0.4f)
            .build();
    public static final FoodProperties BROCCOLI_FLORET = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f)
            .build();
    public static final FoodProperties CAULIFLOWER = new FoodProperties.Builder().nutrition(3).saturationModifier(0.4f)
            .build();
    public static final FoodProperties CAULIFLOWER_FLORET = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f)
            .build();
    public static final FoodProperties CELERY = new FoodProperties.Builder().nutrition(1).saturationModifier(0.5f)
            .build();
    public static final FoodProperties CHILI = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f)
            .build();
    public static final FoodProperties GREEN_BEAN = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f)
            .build();
    public static final FoodProperties PEA = new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f)
            .build();
    public static final FoodProperties PEA_SEEDS = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f)
            .build();

    //FOODS
    //HANDHELD
    public static final FoodProperties BACON_WRAPPED_GREEN_BEANS = new FoodProperties.Builder().nutrition(8).saturationModifier(0.75f)
            .build();
    public static final FoodProperties FRITATA = new FoodProperties.Builder().nutrition(9).saturationModifier(0.8f)
            .build();
    public static final FoodProperties SMASHED_PEAS_ON_TOAST = new FoodProperties.Builder().nutrition(9).saturationModifier(0.9f)
            .build();
    public static final FoodProperties STUFFED_BELL_PEPPER = new FoodProperties.Builder().nutrition(9).saturationModifier(0.9f)
            .build();
    public static final FoodProperties VEGETABLE_STICKS = new FoodProperties.Builder().nutrition(5).saturationModifier(0.8f)
            .build();

    //BOWLS
    public static final FoodProperties CAULIFLOWER_SOUP = new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f)
            .effect(() -> comfort(MEDIUM_DURATION),1.0F).build();
    public static final FoodProperties CHILI_BEAN_SOUP = new FoodProperties.Builder().nutrition(7).saturationModifier(0.75f)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, SHORT_DURATION, 0, false, false),1.0F).build();
    public static final FoodProperties GUMBO = new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f)
            .effect(() -> nourishment(MEDIUM_DURATION),1.0F).build();
    public static final FoodProperties TERIYAKI_CHICKEN = new FoodProperties.Builder().nutrition(9).saturationModifier(0.8f)
            .effect(() -> nourishment(MEDIUM_DURATION),1.0F).build();

    //PLATES
    public static final FoodProperties BUFFALO_WINGS = new FoodProperties.Builder().nutrition(10).saturationModifier(0.75f)
            .effect(() -> comfort(MEDIUM_DURATION),1.0F).build();
    public static final FoodProperties CAULIFLOWER_STEAK = new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f)
            .effect(() -> nourishment(SHORT_DURATION),1.0F).build();
    public static final FoodProperties CHICKEN_POT_PIE = new FoodProperties.Builder().nutrition(7).saturationModifier(0.9f)
            .effect(() -> comfort(LONG_DURATION),1.0F).build();
    public static final FoodProperties GREEN_BEAN_CASSEROLE = new FoodProperties.Builder().nutrition(8).saturationModifier(0.9f)
            .effect(() -> comfort(LONG_DURATION),1.0F).build();
    public static final FoodProperties GREEN_BEAN_STIR_FRY = new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f)
            .effect(() -> nourishment(MEDIUM_DURATION),1.0F).build();
    public static final FoodProperties MIXED_VEGETABLE_MEDLEY = new FoodProperties.Builder().nutrition(8).saturationModifier(0.65f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, MEDIUM_DURATION, 0, false, false),1.0F).build();
    public static final FoodProperties PEA_PESTO_PASTA = new FoodProperties.Builder().nutrition(8).saturationModifier(0.7f)
            .effect(() -> comfort(SHORT_DURATION),1.0F).build();
}
