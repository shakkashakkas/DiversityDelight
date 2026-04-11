package com.shakkas.diversitydelight.effect;

import com.shakkas.diversitydelight.DiversityDelight;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, DiversityDelight.MODID);

    public static final Holder<MobEffect> RELAXED_EFFECT = MOB_EFFECTS.register("relaxed", () -> new ModAttributeEffect(MobEffectCategory.BENEFICIAL, 0x36ebab)
            .addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "relaxed"), 1.0, AttributeModifier.Operation.ADD_VALUE)
            );
    public static final Holder<MobEffect> STURDY_EFFECT = MOB_EFFECTS.register("sturdy", () -> new ModAttributeEffect(MobEffectCategory.BENEFICIAL, 0x36ebab)
            .addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "sturdy"), 0.25, AttributeModifier.Operation.ADD_VALUE)
    );
    public static final Holder<MobEffect> LIGHTFOOTED_EFFECT = MOB_EFFECTS.register("lightfooted", () -> new ModAttributeEffect(MobEffectCategory.BENEFICIAL, 0x36ebab)
            .addAttributeModifier(Attributes.SNEAKING_SPEED, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "lightfooted"), 1.0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );
    public static final Holder<MobEffect> ENRICHMENT_EFFECT = MOB_EFFECTS.register("enrichment", () -> new ModAttributeEffect(MobEffectCategory.BENEFICIAL, 0x36ebab)
    );
    public static final Holder<MobEffect> IMMUNITY_EFFECT = MOB_EFFECTS.register("immunity", () -> new ModAttributeEffect(MobEffectCategory.BENEFICIAL, 0x36ebab)
    );
    public static final Holder<MobEffect> PUNGENT_EFFECT = MOB_EFFECTS.register("pungent", () -> new ModAttributeEffect(MobEffectCategory.BENEFICIAL, 0x36ebab)
    );
    public static final Holder<MobEffect> GATHERING_EFFECT = MOB_EFFECTS.register("gathering", () -> new ModAttributeEffect(MobEffectCategory.BENEFICIAL, 0x36ebab)
    );


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
