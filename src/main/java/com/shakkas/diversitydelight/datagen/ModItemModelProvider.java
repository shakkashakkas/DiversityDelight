package com.shakkas.diversitydelight.datagen;

import com.shakkas.diversitydelight.DiversityDelight;
import com.shakkas.diversitydelight.item.DDModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DiversityDelight.MODID, existingFileHelper);
    }

    public ResourceLocation resourceItem(String path) {
        return ResourceLocation.fromNamespaceAndPath(DiversityDelight.MODID, "block/" + path);
    }

    public void itemGeneratedModel(Item item) {
        withExistingParent(itemName(item), "item/generated").texture("layer0", resourceItem(itemName(item)));
    }

    private String itemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }

    @Override
    protected void registerModels() {
        basicItem(DDModItems.ALMOND.get());
        basicItem(DDModItems.BANANA.get());
        basicItem(DDModItems.BELL_PEPPER.get());
        basicItem(DDModItems.BELL_PEPPER_SEEDS.get());
        basicItem(DDModItems.BROCCOLI.get());
        basicItem(DDModItems.BROCCOLI_FLORET.get());
        basicItem(DDModItems.BROCCOLI_SEEDS.get());
        basicItem(DDModItems.CAULIFLOWER.get());
        basicItem(DDModItems.CAULIFLOWER_FLORET.get());
        basicItem(DDModItems.CAULIFLOWER_SEEDS.get());
        basicItem(DDModItems.CELERY.get());
        basicItem(DDModItems.CHILI.get());
        basicItem(DDModItems.CHILI_SEEDS.get());
        basicItem(DDModItems.CORN.get());
        basicItem(DDModItems.CORN_KERNELS.get());
        basicItem(DDModItems.GREEN_BEAN.get());
        basicItem(DDModItems.GREEN_BEAN_SEEDS.get());
        basicItem(DDModItems.KIWI.get());
        basicItem(DDModItems.LEMON.get());
        basicItem(DDModItems.MANGO.get());
        basicItem(DDModItems.OATS.get());
        basicItem(DDModItems.OAT_SEEDS.get());
        basicItem(DDModItems.ORANGE.get());
        basicItem(DDModItems.PEA.get());
        basicItem(DDModItems.PEA_SEEDS.get());
        basicItem(DDModItems.PEANUT.get());
        basicItem(DDModItems.PEAR.get());
        basicItem(DDModItems.PINEAPPLE.get());
        basicItem(DDModItems.PINEAPPLE_SLICE.get());
        basicItem(DDModItems.PISTACHIO.get());
        basicItem(DDModItems.SOY.get());
        basicItem(DDModItems.SOY_BEANS.get());
        basicItem(DDModItems.WALNUT.get());
        basicItem(DDModItems.EMERALD_PEAR.get());
        //HANDHELD
        basicItem(DDModItems.BACON_WRAPPED_GREEN_BEANS.get());
        basicItem(DDModItems.STUFFED_BELL_PEPPER.get());
        basicItem(DDModItems.VEGETABLE_STICKS.get());

        basicItem(DDModItems.BANANA_BREAD.get());
        basicItem(DDModItems.FRUIT_ROLLUP.get());
        basicItem(DDModItems.MANGO_JELLY.get());
        basicItem(DDModItems.KIWI_JELLY.get());
        basicItem(DDModItems.ICE_CREAM_CONE.get());
        basicItem(DDModItems.LEMON_ICE_CREAM.get());
        basicItem(DDModItems.CHOCOLATE_ICE_CREAM.get());
        basicItem(DDModItems.ORANGE_JUICE.get());
        basicItem(DDModItems.BANANA_MILK.get());

        basicItem(DDModItems.HAWAIIAN_PIZZA.get());
        basicItem(DDModItems.LEMON_MERINGUE_PIE.get());
        basicItem(DDModItems.PEAR_PIE.get());
        basicItem(DDModItems.FRUIT_FLAN.get());

        basicItem(DDModItems.HAWAIIAN_PIZZA_SLICE.get());
        basicItem(DDModItems.LEMON_MERINGUE_PIE_SLICE.get());
        basicItem(DDModItems.PEAR_PIE_SLICE.get());
        basicItem(DDModItems.FRUIT_FLAN_SLICE.get());


        //BOWLS
        basicItem(DDModItems.CAULIFLOWER_SOUP.get());
        basicItem(DDModItems.BAKED_BEANS.get());
        basicItem(DDModItems.GUMBO.get());
        basicItem(DDModItems.TERIYAKI_CHICKEN.get());

        basicItem(DDModItems.BANANA_CHIPS.get());
        basicItem(DDModItems.CEREAL_BOWL.get());
        basicItem(DDModItems.ORANGE_CHICKEN.get());
        basicItem(DDModItems.SWEET_AND_SOUR_CHICKEN.get());
        basicItem(DDModItems.SWEET_STICKY_RICE.get());
        basicItem(DDModItems.TROPICAL_SALAD.get());
        //PLATES
        basicItem(DDModItems.BUFFALO_WINGS.get());
        basicItem(DDModItems.CAULIFLOWER_STEAK.get());
        basicItem(DDModItems.CHICKEN_POT_PIE.get());
        basicItem(DDModItems.CHICKEN_POT_PIE_BLOCK.get());
        basicItem(DDModItems.GREEN_BEAN_ALMONDINE.get());
        basicItem(DDModItems.MIXED_VEGETABLE_MEDLEY.get());
        basicItem(DDModItems.PEA_PESTO_PASTA.get());
        basicItem(DDModItems.VEGETABLE_STICKS_BLOCK.get());

        basicItem(DDModItems.APPLE_PEAR_CRUMBLE.get());
        basicItem(DDModItems.PEANUT_NOODLES.get());

        //CONDIMENTS
        basicItem(DDModItems.KETCHUP.get());
        basicItem(DDModItems.MARMALADE.get());
        basicItem(DDModItems.MAYONNAISE.get());
        basicItem(DDModItems.HOT_SAUCE.get());
        basicItem(DDModItems.PEANUT_BUTTER.get());

        //GRAINS,NUTS,LEGUMES ADDITIONS:
        basicItem(DDModItems.SOY_SAUCE.get());
        basicItem(DDModItems.BEEF_TACO.get());
        basicItem(DDModItems.COOKED_TOFU.get());
        basicItem(DDModItems.TOFU.get());
        basicItem(DDModItems.PORRIDGE.get());
        basicItem(DDModItems.CORNBREAD.get());
        basicItem(DDModItems.GRANOLA_BAR.get());
        basicItem(DDModItems.OATMEAL_COOKIE.get());
        basicItem(DDModItems.PISTACHIO_ICE_CREAM.get());
        basicItem(DDModItems.TACO_SHELL.get());
        basicItem(DDModItems.TRAIL_MIX.get());
        basicItem(DDModItems.CRUSTED_COD.get());
        basicItem(DDModItems.CRUSTED_MUTTON_CHOPS.get());
        basicItem(DDModItems.CRUSTED_PORKCHOP.get());


        itemGeneratedModel(DDModItems.APPLE_TREE_SAPLING.get());
        itemGeneratedModel(DDModItems.ORANGE_TREE_SAPLING.get());
        itemGeneratedModel(DDModItems.LEMON_TREE_SAPLING.get());
        itemGeneratedModel(DDModItems.PEAR_TREE_SAPLING.get());
        itemGeneratedModel(DDModItems.MANGO_TREE_SAPLING.get());
        itemGeneratedModel(DDModItems.BANANA_TREE_SAPLING.get());
        itemGeneratedModel(DDModItems.ALMOND_TREE_SAPLING.get());
        itemGeneratedModel(DDModItems.PISTACHIO_TREE_SAPLING.get());
        itemGeneratedModel(DDModItems.WALNUT_TREE_SAPLING.get());


        withExistingParent(DDModItems.WORM_BIN_BLOCK.getId().toString(), modLoc("block/worm_bin_contents0"));
        withExistingParent(DDModItems.BANANA_TREE_FROND.getId().toString(), modLoc("block/banana_tree_frond"));
        withExistingParent(DDModItems.BANANA_BUNCH.getId().toString(), modLoc("block/banana_bunch_stage3"));
        itemGeneratedModel(DDModItems.WILD_BELL_PEPPER.get());
        itemGeneratedModel(DDModItems.WILD_BROCCOLI.get());
        itemGeneratedModel(DDModItems.WILD_CAULIFLOWER.get());
        itemGeneratedModel(DDModItems.WILD_CELERY.get());
        itemGeneratedModel(DDModItems.WILD_CHILI.get());
        itemGeneratedModel(DDModItems.WILD_GREEN_BEAN.get());
        itemGeneratedModel(DDModItems.WILD_PEA.get());
        itemGeneratedModel(DDModItems.WILD_KIWI.get());
        itemGeneratedModel(DDModItems.WILD_PINEAPPLE.get());



    }


}