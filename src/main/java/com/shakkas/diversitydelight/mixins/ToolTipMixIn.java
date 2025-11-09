package com.shakkas.diversitydelight.mixins;

import com.shakkas.diversitydelight.item.CondimentItem;
import com.shakkas.diversitydelight.utils.TagUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.shakkas.diversitydelight.utils.TextUtils;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.List;

@Mixin({Item.class, ConsumableItem.class})
public abstract class ToolTipMixIn {
    @Inject(method = "appendHoverText", at = @At("TAIL"))
    private void addFoodEffectTooltip(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag, CallbackInfo ci) {
        String category = "condiment";
        if (TagUtils.hasString(stack,category)) {
            TextUtils.addCondimentTooltip(stack, tooltipComponents::add, tooltipComponents);
        }
    }
}
