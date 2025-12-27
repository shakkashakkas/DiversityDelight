package com.shakkas.diversitydelight;


import com.mojang.logging.LogUtils;
import com.shakkas.diversitydelight.block.ModBlocks;
import com.shakkas.diversitydelight.component.ModComponents;
import com.shakkas.diversitydelight.item.ModCreativeModeTabs;
import com.shakkas.diversitydelight.item.DDModItems;
import com.shakkas.diversitydelight.world.tree.DDPlacerTypes;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(DiversityDelight.MODID)
public class DiversityDelight {
    public static final String MODID = "diversitydelight";
    public static final Logger LOGGER = LogUtils.getLogger();



    public DiversityDelight(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);


        NeoForge.EVENT_BUS.register(this);
        ModCreativeModeTabs.register(modEventBus);
        DDModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModComponents.register(modEventBus);
        DDPlacerTypes.register(modEventBus);
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {

        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
