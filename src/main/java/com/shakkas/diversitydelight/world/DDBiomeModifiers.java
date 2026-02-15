package com.shakkas.diversitydelight.world;

import com.shakkas.diversitydelight.DiversityDelight;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class DDBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_APPLE  = registerKey("add_tree_apple");
    public static final ResourceKey<BiomeModifier> ADD_TREE_PEAR   = registerKey("add_tree_pear");
    public static final ResourceKey<BiomeModifier> ADD_TREE_MANGO  = registerKey("add_tree_mango");
    public static final ResourceKey<BiomeModifier> ADD_TREE_ORANGE = registerKey("add_tree_orange");
    public static final ResourceKey<BiomeModifier> ADD_TREE_LEMON  = registerKey("add_tree_lemon");
    public static final ResourceKey<BiomeModifier> ADD_TREE_ALMOND = registerKey("add_tree_almond");
    public static final ResourceKey<BiomeModifier> ADD_TREE_PISTACHIO = registerKey("add_tree_pistachio");
    public static final ResourceKey<BiomeModifier> ADD_TREE_WALNUT = registerKey("add_tree_walnut");
    public static final ResourceKey<BiomeModifier> ADD_TREE_BANANA = registerKey("add_tree_banana");


    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TREE_APPLE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS),biomes.getOrThrow(Biomes.FOREST),biomes.getOrThrow(Biomes.FLOWER_FOREST),biomes.getOrThrow(Biomes.BIRCH_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(DDPlacedFeatures.APPLE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_TREE_PEAR, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS),biomes.getOrThrow(Biomes.FOREST),biomes.getOrThrow(Biomes.FLOWER_FOREST),biomes.getOrThrow(Biomes.BIRCH_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(DDPlacedFeatures.PEAR_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_TREE_MANGO, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE),biomes.getOrThrow(Biomes.SPARSE_JUNGLE),biomes.getOrThrow(Biomes.BAMBOO_JUNGLE)),
                HolderSet.direct(placedFeatures.getOrThrow(DDPlacedFeatures.MANGO_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_TREE_ORANGE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SAVANNA),biomes.getOrThrow(Biomes.WOODED_BADLANDS)),
                HolderSet.direct(placedFeatures.getOrThrow(DDPlacedFeatures.ORANGE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_TREE_LEMON, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SAVANNA),biomes.getOrThrow(Biomes.WOODED_BADLANDS)),
                HolderSet.direct(placedFeatures.getOrThrow(DDPlacedFeatures.LEMON_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_TREE_ALMOND, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.TAIGA),biomes.getOrThrow(Biomes.OLD_GROWTH_PINE_TAIGA)),
                HolderSet.direct(placedFeatures.getOrThrow(DDPlacedFeatures.ALMOND_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_TREE_PISTACHIO, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BIRCH_FOREST),biomes.getOrThrow(Biomes.OLD_GROWTH_BIRCH_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(DDPlacedFeatures.PISTACHIO_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_TREE_WALNUT, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DARK_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(DDPlacedFeatures.WALNUT_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_TREE_BANANA, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE),biomes.getOrThrow(Biomes.SPARSE_JUNGLE),biomes.getOrThrow(Biomes.BAMBOO_JUNGLE)),
                HolderSet.direct(placedFeatures.getOrThrow(DDPlacedFeatures.BANANA_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, name));
    }
}
