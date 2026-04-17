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
import vectorwing.farmersdelight.common.block.PieBlock;
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
    public static final DeferredBlock<Block> BELL_PEPPER_CROP = BLOCKS.register("bell_pepper_crop",
            () -> new DoubleCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT),3,DDModItems.BELL_PEPPER,DDModItems.BELL_PEPPER_SEEDS,false));
    public static final DeferredBlock<Block> PEA_CROP = BLOCKS.register("pea_crop",
            () -> new DoubleCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT),2,DDModItems.PEA,DDModItems.PEA_SEEDS,true));
    public static final DeferredBlock<Block> GREEN_BEAN_CROP = BLOCKS.register("green_bean_crop",
            () -> new DoubleCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT),3,DDModItems.GREEN_BEAN,DDModItems.GREEN_BEAN_SEEDS,true));
    public static final DeferredBlock<Block> CHILI_CROP = BLOCKS.register("chili_crop",
            () -> new DoubleCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT),3,DDModItems.CHILI,DDModItems.CHILI_SEEDS,false));

    public static final DeferredBlock<Block> KIWI_BUDDING_CROP = BLOCKS.register("kiwi_budding_crop",
            () -> new BuddingKiwiBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<Block> KIWI_CROP = BLOCKS.register("kiwi_crop",
            () -> new KiwiVineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<Block> PINEAPPLE_CROP = BLOCKS.register("pineapple_crop",
            () -> new PineappleCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));

    public static final DeferredBlock<Block> OATS_CROP = BLOCKS.register("oats_crop",
            () -> new OatsCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<Block> PEANUT_CROP = BLOCKS.register("peanut_crop",
            () -> new PeanutCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS)));
    public static final DeferredBlock<Block> SOY_CROP = BLOCKS.register("soy_crop",
            () -> new DoubleCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT),5,DDModItems.SOY,DDModItems.SOY_BEANS,false));
      public static final DeferredBlock<Block> CORN_CROP = BLOCKS.register("corn_crop",
              () -> new CornCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));


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

    public static final DeferredBlock<Block> CORN_CRATE = BLOCKS.register("corn_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> SOY_CRATE = BLOCKS.register("soy_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> APPLE_BAG = BLOCKS.register("apple_bag",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> BANANA_BAG = BLOCKS.register("banana_bag",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> KIWI_BAG = BLOCKS.register("kiwi_bag",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> LEMON_BAG = BLOCKS.register("lemon_bag",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> MANGO_BAG = BLOCKS.register("mango_bag",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> ORANGE_BAG = BLOCKS.register("orange_bag",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> PEAR_BAG = BLOCKS.register("pear_bag",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> PINEAPPLE_BAG = BLOCKS.register("pineapple_bag",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL)));

    public static final DeferredBlock<Block> OAT_BALE = BLOCKS.register("oat_bale",
            () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(Blocks.HAY_BLOCK)));

    public static final DeferredBlock<Block> ALMOND_BAG = BLOCKS.register("almond_bag",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> PISTACHIO_BAG = BLOCKS.register("pistachio_bag",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> PEANUT_BAG = BLOCKS.register("peanut_bag",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> WALNUT_BAG = BLOCKS.register("walnut_bag",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL)));


    // Feasts
    public static final DeferredBlock<Block> CHICKEN_POT_PIE_BLOCK = BLOCKS.register("chicken_pot_pie_block",
            () -> new ChickenPotPieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), DDModItems.CHICKEN_POT_PIE, true));
    public static final DeferredBlock<Block> VEGETABLE_STICKS_BLOCK = BLOCKS.register("vegetable_sticks_block",
            () -> new VegetableSticksBlock(Block.Properties.ofFullCopy(Blocks.CAKE),DDModItems.VEGETABLE_STICKS,false));

    public static final DeferredBlock<Block> PEAR_PIE_BLOCK = BLOCKS.register("pear_pie_block",
            () -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), DDModItems.PEAR_PIE_SLICE));
    public static final DeferredBlock<Block> LEMON_MERINGUE_PIE_BLOCK = BLOCKS.register("lemon_meringue_pie_block",
            () -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), DDModItems.LEMON_MERINGUE_PIE_SLICE));
    public static final DeferredBlock<Block> FRUIT_FLAN_BLOCK = BLOCKS.register("fruit_flan_block",
            () -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), DDModItems.FRUIT_FLAN_SLICE));

    public static final DeferredBlock<Block> HAWAIIAN_PIZZA_BLOCK = BLOCKS.register("hawaiian_pizza_block",
            () -> new PizzaBlock(Block.Properties.ofFullCopy(Blocks.CAKE), DDModItems.HAWAIIAN_PIZZA_SLICE));

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
    public static final DeferredBlock<Block> WILD_KIWI = BLOCKS.register("wild_kiwi",
            () -> new WildCropBlock(MobEffects.JUMP, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final DeferredBlock<Block> WILD_PINEAPPLE = BLOCKS.register("wild_pineapple",
            () -> new WildCropBlock(MobEffects.BLINDNESS, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final DeferredBlock<Block> WILD_CORN = BLOCKS.register("wild_corn",
            () -> new WildCropBlock(MobEffects.WEAKNESS, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final DeferredBlock<Block> WILD_OATS = BLOCKS.register("wild_oats",
            () -> new WildCropBlock(MobEffects.HUNGER, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final DeferredBlock<Block> WILD_PEANUT = BLOCKS.register("wild_peanut",
            () -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final DeferredBlock<Block> WILD_SOY = BLOCKS.register("wild_soy",
            () -> new WildCropBlock(MobEffects.UNLUCK, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));

    //Fruit Trees
    public static final DeferredBlock<Block> APPLE_TREE_SAPLING = BLOCKS.register("apple_tree_sapling",
            () -> new SaplingBlock(DDTreeGrowers.APPLE_FRUIT,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> APPLE_TREE_LEAVES = BLOCKS.register("apple_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> APPLE_TREE_FRUITING_LEAVES = BLOCKS.register("apple_tree_fruiting_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), () -> Items.APPLE,() -> ModFruitTreeGenetics.APPLE, ModBlocks.GOLDEN_APPLE_TREE_FRUITING_LEAVES));
    public static final DeferredBlock<Block> GOLDEN_APPLE_TREE_FRUITING_LEAVES = BLOCKS.register("golden_apple_tree_fruiting_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), () -> Items.GOLDEN_APPLE,() -> ModFruitTreeGenetics.GOLDEN_APPLE,true));

    public static final DeferredBlock<Block> ORANGE_TREE_SAPLING = BLOCKS.register("orange_tree_sapling",
            () -> new SaplingBlock(DDTreeGrowers.ORANGE_FRUIT,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> ORANGE_TREE_LOG = BLOCKS.register("orange_tree_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> ORANGE_TREE_LEAVES = BLOCKS.register("orange_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> ORANGE_TREE_FRUITING_LEAVES = BLOCKS.register("orange_tree_fruiting_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES),DDModItems.ORANGE,() -> ModFruitTreeGenetics.ORANGE,false));

    public static final DeferredBlock<Block> LEMON_TREE_SAPLING = BLOCKS.register("lemon_tree_sapling",
            () -> new SaplingBlock(DDTreeGrowers.LEMON_FRUIT,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> LEMON_TREE_LOG = BLOCKS.register("lemon_tree_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> LEMON_TREE_LEAVES = BLOCKS.register("lemon_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> LEMON_TREE_FRUITING_LEAVES = BLOCKS.register("lemon_tree_fruiting_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES),DDModItems.LEMON,() -> ModFruitTreeGenetics.LEMON,false));

    public static final DeferredBlock<Block> PEAR_TREE_SAPLING = BLOCKS.register("pear_tree_sapling",
            () -> new SaplingBlock(DDTreeGrowers.PEAR_FRUIT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> PEAR_TREE_LOG = BLOCKS.register("pear_tree_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PEAR_TREE_LEAVES = BLOCKS.register("pear_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> PEAR_TREE_FRUITING_LEAVES = BLOCKS.register("pear_tree_fruiting_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), DDModItems.PEAR,() -> ModFruitTreeGenetics.PEAR,ModBlocks.EMERALD_PEAR_TREE_FRUITING_LEAVES));
    public static final DeferredBlock<Block> EMERALD_PEAR_TREE_FRUITING_LEAVES = BLOCKS.register("emerald_pear_tree_fruiting_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), DDModItems.EMERALD_PEAR,() -> ModFruitTreeGenetics.EMERALD_PEAR,true));

    public static final DeferredBlock<Block> MANGO_TREE_SAPLING = BLOCKS.register("mango_tree_sapling",
            () -> new SaplingBlock(DDTreeGrowers.MANGO_FRUIT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> MANGO_TREE_LOG = BLOCKS.register("mango_tree_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> MANGO_TREE_LEAVES = BLOCKS.register("mango_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> MANGO_TREE_FRUITING_LEAVES = BLOCKS.register("mango_tree_fruiting_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), DDModItems.MANGO,() -> ModFruitTreeGenetics.MANGO,false));

    public static final DeferredBlock<Block> BANANA_TREE_SAPLING = BLOCKS.register("banana_tree_sapling",
            () -> new SaplingBlock(DDTreeGrowers.BANANA_FRUIT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> BANANA_TREE_FROND = BLOCKS.register("banana_tree_frond",
            () -> new BananaFrond(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> BANANA_TREE_STEM = BLOCKS.register("banana_tree_stem",
            () -> new BananaStem(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> BANANA_BUNCH = BLOCKS.register("banana_bunch",
            () -> new BananaBunch(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));

    public static final DeferredBlock<Block> ALMOND_TREE_SAPLING = BLOCKS.register("almond_tree_sapling",
            () -> new SaplingBlock(DDTreeGrowers.ALMOND_FRUIT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> ALMOND_TREE_LOG = BLOCKS.register("almond_tree_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> ALMOND_TREE_LEAVES = BLOCKS.register("almond_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> ALMOND_TREE_FRUITING_LEAVES = BLOCKS.register("almond_tree_fruiting_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), DDModItems.ALMOND,() -> ModFruitTreeGenetics.ALMOND,false));

    public static final DeferredBlock<Block> PISTACHIO_TREE_SAPLING = BLOCKS.register("pistachio_tree_sapling",
            () -> new SaplingBlock(DDTreeGrowers.PISTACHIO_FRUIT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> PISTACHIO_TREE_LOG = BLOCKS.register("pistachio_tree_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PISTACHIO_TREE_LEAVES = BLOCKS.register("pistachio_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> PISTACHIO_TREE_FRUITING_LEAVES = BLOCKS.register("pistachio_tree_fruiting_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), DDModItems.PISTACHIO, () -> ModFruitTreeGenetics.PISTACHIO, false));

    public static final DeferredBlock<Block> WALNUT_TREE_SAPLING = BLOCKS.register("walnut_tree_sapling",
            () -> new SaplingBlock(DDTreeGrowers.WALNUT_FRUIT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> WALNUT_TREE_LOG = BLOCKS.register("walnut_tree_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> WALNUT_TREE_LEAVES = BLOCKS.register("walnut_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> WALNUT_TREE_FRUITING_LEAVES = BLOCKS.register("walnut_tree_fruiting_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), DDModItems.WALNUT, () -> ModFruitTreeGenetics.WALNUT, false));



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