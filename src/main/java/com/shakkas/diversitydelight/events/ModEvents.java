package com.shakkas.diversitydelight.events;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.effect.DDModEffects;
import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.Map;
import java.util.function.Predicate;

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

    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof Monster mob) {
            Predicate<LivingEntity> shouldAvoid = (entity) -> {
                if (entity instanceof Player player) {
                    MobEffectInstance effect = player.getEffect(DDModEffects.PUNGENT_EFFECT);
                    if (effect == null) {
                        return false;
                    }
                    int amplifier = effect.getAmplifier();
                    double avoidDistance = 4.0 + amplifier;
                    return mob.distanceToSqr(player) <= (avoidDistance * avoidDistance);
                }
                return false;
            };
            mob.goalSelector.addGoal(0, new AvoidEntityGoal<>(mob,Player.class,8,1,1,shouldAvoid));
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        Level level = player.level();
        if (!(level.isClientSide) && player.getEffect(DDModEffects.GATHERING_EFFECT) != null) {
            MobEffectInstance effect = player.getEffect(DDModEffects.GATHERING_EFFECT);
            int amplifier = effect.getAmplifier();
            AABB bb = player.getBoundingBox().inflate(amplifier);
            for (ItemEntity item : level.getEntitiesOfClass(ItemEntity.class, bb)) {
                item.playerTouch(player);
            }
        }
    }
}
