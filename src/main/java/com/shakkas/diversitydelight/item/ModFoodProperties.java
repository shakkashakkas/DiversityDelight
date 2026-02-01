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

    public static final FoodProperties BANANA = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5f)
            .build();
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
    public static final FoodProperties KIWI = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f)
            .build();
    public static final FoodProperties LEMON = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3f)
            .build();
    public static final FoodProperties MANGO = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f)
            .build();
    public static final FoodProperties ORANGE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f)
            .build();
    public static final FoodProperties PEA = new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f)
            .build();
    public static final FoodProperties PEA_SEEDS = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f)
            .build();
    public static final FoodProperties PEAR = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f)
            .build();
    public static final FoodProperties PINEAPPLE = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3f)
            .build();
    public static final FoodProperties PINEAPPLE_SLICE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f)
            .build();

    public static final FoodProperties EMERALD_PEAR = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 100, 1, false, true),1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 0, false, true),1.0F)
            .build();

    //FOODS
    //HANDHELD
    public static final FoodProperties BACON_WRAPPED_GREEN_BEANS = new FoodProperties.Builder().nutrition(8).saturationModifier(0.75f)
            .build();
    public static final FoodProperties FRITATA = new FoodProperties.Builder().nutrition(14).saturationModifier(0.8f)
            .build();
    public static final FoodProperties SMASHED_PEAS_ON_TOAST = new FoodProperties.Builder().nutrition(9).saturationModifier(0.7f)
            .build();
    public static final FoodProperties STUFFED_BELL_PEPPER = new FoodProperties.Builder().nutrition(12).saturationModifier(0.8f)
            .build();
    public static final FoodProperties VEGETABLE_STICKS = new FoodProperties.Builder().nutrition(5).saturationModifier(0.8f)
            .build();

    public static final FoodProperties BANANA_BREAD = new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f)
            .build();
    public static final FoodProperties MANGO_JELLY = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2f).fast().effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, BRIEF_DURATION, 0, false, false),1.0F)
            .build();
    public static final FoodProperties LEMON_JELLY = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2f).fast().effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, BRIEF_DURATION, 0, false, false),1.0F)
            .build();
    public static final FoodProperties KIWI_JELLY = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2f).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, BRIEF_DURATION, 0, false, false),1.0F)
            .build();
    public static final FoodProperties FRUIT_ROLLUP = new FoodProperties.Builder().nutrition(6).saturationModifier(0.8f).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, BRIEF_DURATION, 1, false, false),1.0F)
            .build();
    public static final FoodProperties ICE_CREAM_CONE = new FoodProperties.Builder().nutrition(1).saturationModifier(0.2f).fast()
            .build();
    public static final FoodProperties LEMON_ICE_CREAM = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, BRIEF_DURATION, 0, false, false),1.0F)
            .build();
    public static final FoodProperties MANGO_ICE_CREAM = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, BRIEF_DURATION, 0, false, false),1.0F)
            .build();
    public static final FoodProperties CHOCOLATE_ICE_CREAM = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, BRIEF_DURATION, 0, false, false),1.0F)
            .build();
    public static final FoodProperties ORANGE_JUICE = new FoodProperties.Builder().nutrition(1).saturationModifier(0.2f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, SHORT_DURATION, 0, false, false),1.0F)
            .build();
    public static final FoodProperties PINEAPPLE_JUICE = new FoodProperties.Builder().nutrition(1).saturationModifier(0.2f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.HEAL, 0, 0, false, false),1.0F)
            .build();
    public static final FoodProperties BANANA_MILK = new FoodProperties.Builder().nutrition(1).saturationModifier(0.4f).effect(() -> new MobEffectInstance(MobEffects.JUMP, 0, 0, false, false),1.0F)
            .build();
    public static final FoodProperties MANGO_YOGHURT = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 0, 0, false, false),1.0F)
            .build();
    public static final FoodProperties ORANGE_YOGHURT = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 0, 0, false, false),1.0F)
            .build();
    public static final FoodProperties POACHED_PEAR = new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f)
            .build();

    //HANDHELD SLICES
    public static final FoodProperties PEAR_PIE_SLICE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, BRIEF_DURATION, 0, false, false), 1.0F).build();
    public static final FoodProperties LEMON_MERINGUE_PIE_SLICE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, BRIEF_DURATION, 0, false, false), 1.0F).build();
    public static final FoodProperties BANOFFEE_PIE_SLICE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, BRIEF_DURATION, 0, false, false), 1.0F).build();
    public static final FoodProperties FRUIT_FLAN_SLICE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, BRIEF_DURATION, 0, false, false), 1.0F).build();
    public static final FoodProperties HAWAIIAN_PIZZA_SLICE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).fast()
            .effect(() -> comfort(SHORT_DURATION),1.0F).build();

    //BOWLS
    public static final FoodProperties CAULIFLOWER_SOUP = new FoodProperties.Builder().nutrition(12).saturationModifier(0.7f)
            .effect(() -> comfort(MEDIUM_DURATION),1.0F).build();
    public static final FoodProperties CHILI_BEAN_SOUP = new FoodProperties.Builder().nutrition(7).saturationModifier(0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, SHORT_DURATION, 0, false, false),1.0F).build();
    public static final FoodProperties GUMBO = new FoodProperties.Builder().nutrition(15).saturationModifier(0.75f)
            .effect(() -> nourishment(MEDIUM_DURATION),1.0F).build();
    public static final FoodProperties TERIYAKI_CHICKEN = new FoodProperties.Builder().nutrition(14).saturationModifier(0.8f)
            .effect(() -> nourishment(MEDIUM_DURATION),1.0F).build();

    public static final FoodProperties BANANA_CHIPS = new FoodProperties.Builder().nutrition(6).saturationModifier(0.5f)
            .build();
    public static final FoodProperties CEREAL_BOWL = new FoodProperties.Builder().nutrition(7).saturationModifier(0.7f)
            .build();
    public static final FoodProperties ORANGE_CHICKEN = new FoodProperties.Builder().nutrition(10).saturationModifier(0.7f)
            .effect(() -> comfort(MEDIUM_DURATION),1.0F).build();
    public static final FoodProperties SWEET_AND_SOUR_CHICKEN = new FoodProperties.Builder().nutrition(12).saturationModifier(0.8f)
            .effect(() -> nourishment(MEDIUM_DURATION),1.0F).build();
    public static final FoodProperties SWEET_STICKY_RICE = new FoodProperties.Builder().nutrition(7).saturationModifier(0.6f)
            .effect(() -> comfort(MEDIUM_DURATION),1.0F).build();
    public static final FoodProperties TROPICAL_SALAD = new FoodProperties.Builder().nutrition(8).saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, SHORT_DURATION, 0, false, false),1.0F).build();

    //PLATES
    public static final FoodProperties BUFFALO_WINGS = new FoodProperties.Builder().nutrition(16).saturationModifier(0.8f)
            .effect(() -> comfort(MEDIUM_DURATION),1.0F).build();
    public static final FoodProperties CAULIFLOWER_STEAK = new FoodProperties.Builder().nutrition(8).saturationModifier(0.4f)
            .effect(() -> nourishment(SHORT_DURATION),1.0F).build();
    public static final FoodProperties CHICKEN_POT_PIE = new FoodProperties.Builder().nutrition(8).saturationModifier(0.75f)
            .effect(() -> comfort(LONG_DURATION),1.0F).build();
    public static final FoodProperties GREEN_BEAN_CASSEROLE = new FoodProperties.Builder().nutrition(12).saturationModifier(0.75f)
            .effect(() -> comfort(LONG_DURATION),1.0F).build();
    public static final FoodProperties GREEN_BEAN_STIR_FRY = new FoodProperties.Builder().nutrition(12).saturationModifier(0.8f)
            .effect(() -> nourishment(MEDIUM_DURATION),1.0F).build();
    public static final FoodProperties MIXED_VEGETABLE_MEDLEY = new FoodProperties.Builder().nutrition(12).saturationModifier(0.75f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, MEDIUM_DURATION, 0, false, false),1.0F).build();
    public static final FoodProperties PEA_PESTO_PASTA = new FoodProperties.Builder().nutrition(10).saturationModifier(0.7f)
            .effect(() -> comfort(SHORT_DURATION),1.0F).build();

    public static final FoodProperties APPLE_PEAR_CRUMBLE = new FoodProperties.Builder().nutrition(9).saturationModifier(0.6f)
            .effect(() -> comfort(MEDIUM_DURATION),1.0F).build();
}
