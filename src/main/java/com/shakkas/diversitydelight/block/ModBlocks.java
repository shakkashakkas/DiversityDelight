package com.shakkas.diversitydelight.block;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.block.custom.*;
import com.shakkas.diversitydelight.item.DDModItems;
import com.shakkas.diversitydelight.world.tree.DDTreeGrowers;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(DiversityDelight.MODID);


    public static final DeferredBlock<Block> BROCCOLI_CROP = BLOCKS.register("broccoli_crop",
            () -> new ColeCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT),DDModItems.BROCCOLI_SEEDS));
    public static final DeferredBlock<Block> CAULIFLOWER_CROP = BLOCKS.register("cauliflower_crop",
            () -> new ColeCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT), DDModItems.CAULIFLOWER_SEEDS));
    public static final DeferredBlock<Block> CELERY_CROP = BLOCKS.register("celery_crop",
            () -> new CeleryCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS)));
    public static final DeferredBlock<Block> LOWER_BELL_PEPPER_CROP = BLOCKS.register("lower_bell_pepper_crop",
            () -> new LowerDoubleSupportCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT), DDModItems.BELL_PEPPER_SEEDS,ModBlocks.UPPER_BELL_PEPPER_CROP));
    public static final DeferredBlock<Block> UPPER_BELL_PEPPER_CROP = BLOCKS.register("upper_bell_pepper_crop",
            () -> new UpperDoubleFruitingCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT), DDModItems.BELL_PEPPER, DDModItems.BELL_PEPPER_SEEDS,ModBlocks.LOWER_BELL_PEPPER_CROP));
    public static final DeferredBlock<Block> LOWER_CHILI_CROP = BLOCKS.register("lower_chili_crop",
            () -> new LowerDoubleSupportCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT), DDModItems.CHILI_SEEDS,ModBlocks.UPPER_CHILI_CROP));
    public static final DeferredBlock<Block> UPPER_CHILI_CROP = BLOCKS.register("upper_chili_crop",
            () -> new UpperDoubleFruitingCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT), DDModItems.CHILI, DDModItems.CHILI_SEEDS,ModBlocks.LOWER_CHILI_CROP));
    public static final DeferredBlock<Block> LOWER_GREEN_BEAN_CROP = BLOCKS.register("lower_green_bean_crop",
            () -> new LowerDoubleFruitingCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT), DDModItems.GREEN_BEAN, DDModItems.GREEN_BEAN_SEEDS,ModBlocks.UPPER_GREEN_BEAN_CROP));
    public static final DeferredBlock<Block> UPPER_GREEN_BEAN_CROP = BLOCKS.register("upper_green_bean_crop",
            () -> new UpperDoubleFruitingCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT), DDModItems.GREEN_BEAN, DDModItems.GREEN_BEAN_SEEDS,ModBlocks.LOWER_GREEN_BEAN_CROP));
    public static final DeferredBlock<Block> LOWER_PEA_CROP = BLOCKS.register("lower_pea_crop",
            () -> new LowerDoubleFruitingCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT), DDModItems.PEA, DDModItems.PEA_SEEDS,ModBlocks.UPPER_PEA_CROP));
    public static final DeferredBlock<Block> UPPER_PEA_CROP = BLOCKS.register("upper_pea_crop",
            () -> new UpperDoubleFruitingCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT), DDModItems.PEA, DDModItems.PEA_SEEDS,ModBlocks.LOWER_PEA_CROP));

    public static final DeferredBlock<Block> WORM_BIN_BLOCK = BLOCKS.register("worm_bin",
                () -> new WormBinBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COMPOSTER)));

    // Crop Storage
    public static final DeferredBlock<Block> BELL_PEPPER_CRATE = BLOCKS.register("bell_pepper_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> BROCCOLI_CRATE = BLOCKS.register("broccoli_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> CAULIFLOWER_CRATE = BLOCKS.register("cauliflower_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> CELERY_CRATE = BLOCKS.register("celery_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> CHILI_CRATE = BLOCKS.register("chili_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> GREEN_BEAN_CRATE = BLOCKS.register("green_bean_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PEA_CRATE = BLOCKS.register("pea_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    // Feasts
    public static final DeferredBlock<Block> CHICKEN_POT_PIE_BLOCK = BLOCKS.register("chicken_pot_pie_block",
            () -> new ChickenPotPieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), DDModItems.CHICKEN_POT_PIE, true));
    public static final DeferredBlock<Block> VEGETABLE_STICKS_BLOCK = BLOCKS.register("vegetable_sticks_block",
            () -> new VegetableSticksBlock(Block.Properties.ofFullCopy(Blocks.CAKE),DDModItems.VEGETABLE_STICKS,false));

    // Wild Crops
    public static final DeferredBlock<Block> WILD_BELL_PEPPER = BLOCKS.register("wild_bell_pepper",
            () -> new WildCropBlock(MobEffects.REGENERATION, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final DeferredBlock<Block> WILD_BROCCOLI = BLOCKS.register("wild_broccoli",
            () -> new WildCropBlock(MobEffects.POISON, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final DeferredBlock<Block> WILD_CAULIFLOWER = BLOCKS.register("wild_cauliflower",
            () -> new WildCropBlock(MobEffects.DIG_SLOWDOWN, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final DeferredBlock<Block> WILD_CELERY = BLOCKS.register("wild_celery",
            () -> new WildCropBlock(MobEffects.DAMAGE_RESISTANCE, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final DeferredBlock<Block> WILD_CHILI = BLOCKS.register("wild_chili",
            () -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final DeferredBlock<Block> WILD_GREEN_BEAN = BLOCKS.register("wild_green_bean",
            () -> new WildCropBlock(MobEffects.MOVEMENT_SLOWDOWN, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final DeferredBlock<Block> WILD_PEA = BLOCKS.register("wild_pea",
            () -> new WildCropBlock(MobEffects.CONFUSION, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));

    //Fruit Trees
    public static final DeferredBlock<Block> APPLE_TREE_SAPLING = BLOCKS.register("apple_tree_sapling",
            () -> new SaplingBlock(DDTreeGrowers.APPLE_FRUIT,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> APPLE_TREE_LEAVES = BLOCKS.register("apple_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> APPLE_TREE_FRUITING_LEAVES = BLOCKS.register("apple_tree_fruiting_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), () -> Items.APPLE,() -> ModFruitTreeGenetics.APPLE));

    public static final DeferredBlock<Block> ORANGE_TREE_SAPLING = BLOCKS.register("orange_tree_sapling",
            () -> new SaplingBlock(DDTreeGrowers.ORANGE_FRUIT,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> ORANGE_TREE_LOG = BLOCKS.register("orange_tree_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> ORANGE_TREE_LEAVES = BLOCKS.register("orange_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> ORANGE_TREE_FRUITING_LEAVES = BLOCKS.register("orange_tree_fruiting_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES),DDModItems.ORANGE,() -> ModFruitTreeGenetics.ORANGE));

    public static final DeferredBlock<Block> LEMON_TREE_SAPLING = BLOCKS.register("lemon_tree_sapling",
            () -> new SaplingBlock(DDTreeGrowers.LEMON_FRUIT,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> LEMON_TREE_LOG = BLOCKS.register("lemon_tree_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> LEMON_TREE_LEAVES = BLOCKS.register("lemon_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> LEMON_TREE_FRUITING_LEAVES = BLOCKS.register("lemon_tree_fruiting_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES),DDModItems.LEMON,() -> ModFruitTreeGenetics.LEMON));

    public static final DeferredBlock<Block> PEAR_TREE_SAPLING = BLOCKS.register("pear_tree_sapling",
            () -> new SaplingBlock(DDTreeGrowers.PEAR_FRUIT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> PEAR_TREE_LOG = BLOCKS.register("pear_tree_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PEAR_TREE_LEAVES = BLOCKS.register("pear_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> PEAR_TREE_FRUITING_LEAVES = BLOCKS.register("pear_tree_fruiting_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), DDModItems.PEAR,() -> ModFruitTreeGenetics.PEAR));

    public static final DeferredBlock<Block> MANGO_TREE_SAPLING = BLOCKS.register("mango_tree_sapling",
            () -> new SaplingBlock(DDTreeGrowers.MANGO_FRUIT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> MANGO_TREE_LOG = BLOCKS.register("mango_tree_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> MANGO_TREE_LEAVES = BLOCKS.register("mango_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> MANGO_TREE_FRUITING_LEAVES = BLOCKS.register("mango_tree_fruiting_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), DDModItems.MANGO,() -> ModFruitTreeGenetics.MANGO));

    public static final DeferredBlock<Block> BANANA_TREE_SAPLING = BLOCKS.register("banana_tree_sapling",
            () -> new SaplingBlock(DDTreeGrowers.BANANA_FRUIT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> BANANA_TREE_FROND = BLOCKS.register("banana_tree_frond",
            () -> new BananaFrond(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> BANANA_TREE_STEM = BLOCKS.register("banana_tree_stem",
            () -> new BananaStem(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> BANANA_BUNCH = BLOCKS.register("banana_bunch",
            () -> new BananaBunch(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        DDModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}