package com.shakkas.diversitydelight.world;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.block.ModBlocks;
import com.shakkas.diversitydelight.world.tree.BananaFoliagePlacer;
import com.shakkas.diversitydelight.world.tree.BananaTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class DDConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_FRUIT_KEY = registerKey("apple_fruit");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_FRUIT_KEY = registerKey("orange_fruit");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_FRUIT_KEY = registerKey("lemon_fruit");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR_FRUIT_KEY = registerKey("pear_fruit");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGO_FRUIT_KEY = registerKey("mango_fruit");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALMOND_FRUIT_KEY = registerKey("almond_fruit");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PISTACHIO_FRUIT_KEY = registerKey("pistachio_fruit");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WALNUT_FRUIT_KEY = registerKey("walnut_fruit");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BANANA_FRUIT_KEY = registerKey("banana_fruit");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        register(context, APPLE_FRUIT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new StraightTrunkPlacer(4, 1, 3),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.APPLE_TREE_LEAVES.get().defaultBlockState(), 4).add(ModBlocks.APPLE_TREE_FRUITING_LEAVES.get().defaultBlockState(), 1).build()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());
        register(context, ORANGE_FRUIT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ORANGE_TREE_LOG.get()),
                new ForkingTrunkPlacer(3, 2, 4),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.ORANGE_TREE_LEAVES.get().defaultBlockState(), 4).add(ModBlocks.ORANGE_TREE_FRUITING_LEAVES.get().defaultBlockState(), 1).build()),
                new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 70),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, LEMON_FRUIT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.LEMON_TREE_LOG.get()),
                new ForkingTrunkPlacer(3, 2, 4),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.LEMON_TREE_LEAVES.get().defaultBlockState(), 4).add(ModBlocks.LEMON_TREE_FRUITING_LEAVES.get().defaultBlockState(), 1).build()),
                new CherryFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(4), 0.25F, 0.5F, 0.16666667F, 0F),
                new TwoLayersFeatureSize(1, 1, 2)).build());
        register(context, PEAR_FRUIT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PEAR_TREE_LOG.get()),
                new BendingTrunkPlacer(3, 1, 2,4,ConstantInt.of(1)),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.PEAR_TREE_LEAVES.get().defaultBlockState(), 3).add(ModBlocks.PEAR_TREE_FRUITING_LEAVES.get().defaultBlockState(), 1).build()),
                new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(3), 70),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, MANGO_FRUIT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.MANGO_TREE_LOG.get()),
                new ForkingTrunkPlacer(3, 2, 4),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.MANGO_TREE_LEAVES.get().defaultBlockState(), 4).add(ModBlocks.MANGO_TREE_FRUITING_LEAVES.get().defaultBlockState(), 1).build()),
                new CherryFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(4), 0.25F, 0.5F, 0.16666667F, 0F),
                new TwoLayersFeatureSize(1, 1, 0)).build());
        register(context, ALMOND_FRUIT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ALMOND_TREE_LOG.get()),
                new ForkingTrunkPlacer(3, 2, 4),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.ALMOND_TREE_LEAVES.get().defaultBlockState(), 4).add(ModBlocks.ALMOND_TREE_FRUITING_LEAVES.get().defaultBlockState(), 1).build()),
                new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 70),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, PISTACHIO_FRUIT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PISTACHIO_TREE_LOG.get()),
                new ForkingTrunkPlacer(3, 2, 4),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.PISTACHIO_TREE_LEAVES.get().defaultBlockState(), 4).add(ModBlocks.PISTACHIO_TREE_FRUITING_LEAVES.get().defaultBlockState(), 1).build()),
                new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 70),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, WALNUT_FRUIT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.WALNUT_TREE_LOG.get()),
                new ForkingTrunkPlacer(3, 2, 4),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.WALNUT_TREE_LEAVES.get().defaultBlockState(), 4).add(ModBlocks.WALNUT_TREE_FRUITING_LEAVES.get().defaultBlockState(), 1).build()),
                new CherryFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(4), 0.25F, 0.5F, 0.16666667F, 0F),
                new TwoLayersFeatureSize(1, 1, 0)).build());
        register(context, BANANA_FRUIT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.BANANA_TREE_STEM.get()),
                new BananaTrunkPlacer(2, 1, 3),
                BlockStateProvider.simple(ModBlocks.BANANA_TREE_FROND.get()),
                new BananaFoliagePlacer(ConstantInt.of(3),ConstantInt.of(0)),
                //new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(4), 0.25F, 0.5F, 0.16666667F, 0F),
                new TwoLayersFeatureSize(1, 1, 0)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
