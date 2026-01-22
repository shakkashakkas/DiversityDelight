package com.shakkas.diversitydelight.item;

import com.shakkas.diversitydelight.block.custom.FruitingLeavesBlock;
import com.shakkas.diversitydelight.block.entity.FruitingLeavesBlockEntity;
import com.shakkas.diversitydelight.component.FruitProbeMode;
import com.shakkas.diversitydelight.component.ModComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;

public class FruitProbeItem extends Item {
    protected static final int UPPER_BAD_BOUND = 3;
    protected static final int UPPER_OKAY_BOUND = 6;
    protected static final int UPPER_GOOD_BOUND = 9;
    public FruitProbeItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        FruitProbeMode mode = stack.getOrDefault(ModComponents.FRUIT_PROBE_PROPERTIES, FruitProbeMode.NONE);

        if (!level.isClientSide) {
            if ((state.getBlock() instanceof FruitingLeavesBlock) && mode != FruitProbeMode.NONE) {
                if (level.getBlockEntity(pos) instanceof FruitingLeavesBlockEntity fruitingLeavesBlockEntity) {
                    int sampledGene = sampleGene(fruitingLeavesBlockEntity, mode);
                    stack.set(DataComponents.CUSTOM_MODEL_DATA,new CustomModelData(getModelQuality(sampledGene)));
                    player.playNotifySound(SoundEvents.COPPER_BULB_TURN_ON, SoundSource.PLAYERS,1.0f,1.0f);
                    return InteractionResult.SUCCESS;
                }
            }
            else {
                FruitProbeMode newMode = cycleMode(mode);
                stack.set(ModComponents.FRUIT_PROBE_PROPERTIES,newMode);
                stack.set(DataComponents.CUSTOM_MODEL_DATA,new CustomModelData(0));
                player.displayClientMessage(Component.translatable("item.diversitydelight.fruit_probe" + getTranslationSuffix(newMode)), true);
                player.playNotifySound(SoundEvents.COPPER_BULB_TURN_ON, SoundSource.PLAYERS,1.0f,1.0f);
                return InteractionResult.SUCCESS;
            }
        }
        return super.useOn(context);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);
        AttributeMap attributes = player.getAttributes();
        double blockInteractionRange = attributes.getValue(Attributes.BLOCK_INTERACTION_RANGE);
        HitResult hitResult = player.pick(blockInteractionRange,0,false);
        if (hitResult.getType() != HitResult.Type.MISS) {
            return InteractionResultHolder.pass(stack);
        }
        if (!level.isClientSide) {
            FruitProbeMode mode = stack.getOrDefault(ModComponents.FRUIT_PROBE_PROPERTIES, FruitProbeMode.NONE);
            FruitProbeMode newMode = cycleMode(mode);
            stack.set(ModComponents.FRUIT_PROBE_PROPERTIES,newMode);
            stack.set(DataComponents.CUSTOM_MODEL_DATA,new CustomModelData(0));
            player.displayClientMessage(Component.translatable("item.diversitydelight.fruit_probe" + getTranslationSuffix(newMode)), true);
            player.playNotifySound(SoundEvents.COPPER_BULB_TURN_ON, SoundSource.PLAYERS,1.0f,1.0f);
            return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
        }
        return super.use(level,player,usedHand);
    }

    public String getTranslationSuffix(FruitProbeMode currentMode) {
        return switch (currentMode) {
            case GROWTH -> ".mode_growth";
            case NONE -> "";
            case MUTATION -> ".mode_mutation";
            case YIELD -> ".mode_yield";
        };
    }
    
    public FruitProbeMode cycleMode(FruitProbeMode currentMode) {
        return switch (currentMode) {
            case NONE, GROWTH -> FruitProbeMode.MUTATION;
            case MUTATION -> FruitProbeMode.YIELD;
            case YIELD -> FruitProbeMode.GROWTH;
        };
    }

    public int sampleGene(FruitingLeavesBlockEntity fruitingLeavesBlockEntity, FruitProbeMode currentMode) {
        return switch (currentMode) {
            case GROWTH -> fruitingLeavesBlockEntity.growth;
            case NONE -> 0;
            case MUTATION -> fruitingLeavesBlockEntity.mutation;
            case YIELD -> fruitingLeavesBlockEntity.yield;
        };
    }

    public int getModelQuality(int gene) {
        if (gene <= UPPER_BAD_BOUND) {
            return 3;
        }
        else if (gene <= UPPER_OKAY_BOUND) {
            return 2;
        }
        else if (gene <= UPPER_GOOD_BOUND) {
            return 1;
        }
        else {
            return 0;
        }
    }

}
