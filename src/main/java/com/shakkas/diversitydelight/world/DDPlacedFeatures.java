package com.shakkas.diversitydelight.world;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class DDPlacedFeatures {
    public static final ResourceKey<PlacedFeature> APPLE_PLACED_KEY  = registerKey("apple_placed");
    public static final ResourceKey<PlacedFeature> PEAR_PLACED_KEY   = registerKey("pear_placed");
    public static final ResourceKey<PlacedFeature> MANGO_PLACED_KEY  = registerKey("mango_placed");
    public static final ResourceKey<PlacedFeature> ORANGE_PLACED_KEY = registerKey("orange_placed");
    public static final ResourceKey<PlacedFeature> LEMON_PLACED_KEY  = registerKey("lemon_placed");
    public static final ResourceKey<PlacedFeature> ALMOND_PLACED_KEY = registerKey("almond_placed");
    public static final ResourceKey<PlacedFeature> PISTACHIO_PLACED_KEY = registerKey("pistachio_placed");
    public static final ResourceKey<PlacedFeature> WALNUT_PLACED_KEY = registerKey("walnut_placed");
    public static final ResourceKey<PlacedFeature> BANANA_PLACED_KEY = registerKey("banana_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, APPLE_PLACED_KEY, configuredFeatures.getOrThrow(DDConfiguredFeatures.APPLE_FRUIT_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.05f, 1),
                        ModBlocks.APPLE_TREE_SAPLING.get()
                ));

        register(context, PEAR_PLACED_KEY, configuredFeatures.getOrThrow(DDConfiguredFeatures.PEAR_FRUIT_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.05f, 1),
                        ModBlocks.PEAR_TREE_SAPLING.get()
                ));

        register(context, MANGO_PLACED_KEY, configuredFeatures.getOrThrow(DDConfiguredFeatures.MANGO_FRUIT_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.05f, 1),
                        ModBlocks.MANGO_TREE_SAPLING.get()
                ));

        register(context, ORANGE_PLACED_KEY, configuredFeatures.getOrThrow(DDConfiguredFeatures.ORANGE_FRUIT_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.05f, 1),
                        ModBlocks.ORANGE_TREE_SAPLING.get()
                ));

        register(context, LEMON_PLACED_KEY, configuredFeatures.getOrThrow(DDConfiguredFeatures.LEMON_FRUIT_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.05f, 1),
                        ModBlocks.LEMON_TREE_SAPLING.get()
                ));

        register(context, ALMOND_PLACED_KEY, configuredFeatures.getOrThrow(DDConfiguredFeatures.ALMOND_FRUIT_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.05f, 1),
                        ModBlocks.ALMOND_TREE_SAPLING.get()
                ));

        register(context, PISTACHIO_PLACED_KEY, configuredFeatures.getOrThrow(DDConfiguredFeatures.PISTACHIO_FRUIT_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.05f, 1),
                        ModBlocks.PISTACHIO_TREE_SAPLING.get()
                ));

        register(context, WALNUT_PLACED_KEY, configuredFeatures.getOrThrow(DDConfiguredFeatures.WALNUT_FRUIT_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.05f, 1),
                        ModBlocks.WALNUT_TREE_SAPLING.get()
                ));


        register(context, BANANA_PLACED_KEY, configuredFeatures.getOrThrow(DDConfiguredFeatures.BANANA_FRUIT_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.05f, 1),
                        ModBlocks.BANANA_TREE_SAPLING.get()
                ));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
