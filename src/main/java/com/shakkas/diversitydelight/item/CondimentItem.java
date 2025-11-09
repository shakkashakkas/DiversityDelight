package com.shakkas.diversitydelight.item;

import com.shakkas.diversitydelight.component.CondimentProperties;
import com.shakkas.diversitydelight.component.ModComponents;
import com.shakkas.diversitydelight.utils.TagUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CondimentItem extends Item {
    public CondimentItem(Properties properties) {
        super(properties);
    }

    protected static final String CATEGORY = "condiment";

    public String getCategory() {
        return CATEGORY;
    }

    public String getCondimentName() {
        return BuiltInRegistries.ITEM.getKey(this).getPath();
    }

    public boolean canApplyCondiment(ItemStack stack, String category, Player player) {
        return (!TagUtils.hasString(stack,category)) && stack.getItem().getFoodProperties(stack, player) != null;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack condimentStack = player.getItemInHand(hand);
        EquipmentSlot useSlot = LivingEntity.getSlotForHand(hand);
        InteractionHand otherHand = (hand == InteractionHand.MAIN_HAND) ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack otherHeldItem = player.getItemInHand(otherHand);
        String category = CATEGORY;
        if (canApplyCondiment(otherHeldItem,category,player)) {
            condimentStack.hurtAndBreak(1, player, useSlot);
            applyCondiment(condimentStack, otherHeldItem,category,player);
            return InteractionResultHolder.sidedSuccess(condimentStack, level.isClientSide());
        }
        return InteractionResultHolder.pass(condimentStack);
    }

    public void applyCondiment(ItemStack condimentStack, ItemStack stack, String category, Player player) {
        ItemStack targetItem = stack.copy();
        modifyFood(condimentStack, targetItem, category, getCondimentName());
        stack.shrink(1);
        targetItem.setCount(1);
        player.addItem(targetItem);
        player.playNotifySound(SoundEvents.HONEY_BLOCK_PLACE,SoundSource.PLAYERS,1.0f,1.0f);
    }

    public void modifyFood(ItemStack condimentStack, ItemStack stack, String category, String condimentType) {
        //Modify NBT data components first
        CompoundTag root = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();
        root.putString(category,condimentType);
        stack.set(DataComponents.CUSTOM_DATA, CustomData.of(root));
        stack.set(DataComponents.FOOD, modifiedFoodProperties(condimentStack,stack,condimentType));
    }

    public FoodProperties modifiedFoodProperties(ItemStack condimentStack, ItemStack stack, String condimentType) {
        //Calculate new food property values
        FoodProperties base = stack.get(DataComponents.FOOD);
        CondimentProperties modifier = condimentStack.getOrDefault(ModComponents.CONDIMENT_PROPERTIES,CondimentProperties.EMPTY);
        int originalNutrition = base.nutrition();
        float originalSaturation = base.saturation();
        List<FoodProperties.PossibleEffect> effects = base.effects();

        int extraNutrition = modifier.nutritionBonus();
        float extraSaturation = modifier.saturationBonus();
        boolean canAlwaysEat = modifier.alwaysEdible();
        boolean fast = modifier.fast();
        List<FoodProperties.PossibleEffect> extraEffects = modifier.extraEffects();

        List<FoodProperties.PossibleEffect> combinedEffects = Stream.concat(effects.stream(),extraEffects.stream()).toList();

        FoodProperties.Builder modifiedBase = new FoodProperties.Builder().nutrition(originalNutrition + extraNutrition).saturationModifier(originalSaturation+extraSaturation);
        if (canAlwaysEat) {
            modifiedBase.alwaysEdible();
        }
        if (fast) {
            modifiedBase.fast();
        }
        for (FoodProperties.PossibleEffect e : combinedEffects) {
            modifiedBase.effect(e.effect(),1.0F); // 1.0F = 100% chance
        }

        return modifiedBase.build();
    }

}


