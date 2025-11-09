package com.shakkas.diversitydelight.events;

import com.shakkas.diversitydelight.DiversityDelight;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ModelEvent;

@EventBusSubscriber(modid = DiversityDelight.MODID, bus = EventBusSubscriber.Bus.MOD, value =  Dist.CLIENT)
public class AdditionalModelRegisterEvent {
    @SubscribeEvent
    public static void registerAdditional(ModelEvent.RegisterAdditional event) {
        event.register(ModelResourceLocation.standalone(
                ResourceLocation.fromNamespaceAndPath("diversitydelight", "item/ketchup_overlay")));
        event.register(ModelResourceLocation.standalone(
                ResourceLocation.fromNamespaceAndPath("diversitydelight", "item/ketchup_bowl_overlay")));
        event.register(ModelResourceLocation.standalone(
                ResourceLocation.fromNamespaceAndPath("diversitydelight", "item/mayonnaise_overlay")));
        event.register(ModelResourceLocation.standalone(
                ResourceLocation.fromNamespaceAndPath("diversitydelight", "item/mayonnaise_bowl_overlay")));
        event.register(ModelResourceLocation.standalone(
                ResourceLocation.fromNamespaceAndPath("diversitydelight", "item/hot_sauce_overlay")));
        event.register(ModelResourceLocation.standalone(
                ResourceLocation.fromNamespaceAndPath("diversitydelight", "item/hot_sauce_bowl_overlay")));
    }
}
