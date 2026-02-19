package com.shakkas.diversitydelight.events;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.effect.DDModEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;

import java.util.Map;

@EventBusSubscriber(modid = DiversityDelight.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    @SubscribeEvent
    public static void onXpChange(PlayerXpEvent.XpChange event) {
        Player player = event.getEntity();
        if (player.getEffect(DDModEffects.ENRICHMENT_EFFECT) != null) {
            MobEffectInstance effect = player.getEffect(DDModEffects.ENRICHMENT_EFFECT);
            int originalAmount = event.getAmount();
            int modifiedAmount = (int) (originalAmount + originalAmount*(effect.getAmplifier()*0.25 + 0.5));
            event.setAmount(modifiedAmount);
        }
    }

    @SubscribeEvent
    public static void onEffectGain(MobEffectEvent.Applicable event) {
        LivingEntity entity = event.getEntity();
        if (entity.getEffect(DDModEffects.IMMUNITY_EFFECT) != null && event.getEffectInstance().getEffect().value().getCategory() == MobEffectCategory.HARMFUL) {
            MobEffectInstance effect = entity.getEffect(DDModEffects.IMMUNITY_EFFECT);
            int amplifier = effect.getAmplifier();

            MobEffectInstance targetEffect = event.getEffectInstance();
            int targetAmplifier = targetEffect.getAmplifier();
            if (targetAmplifier <= amplifier) {
                event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);
            }

        }
    }
}
