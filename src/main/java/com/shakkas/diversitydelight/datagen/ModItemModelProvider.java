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
        basicItem(DDModItems.GREEN_BEAN.get());
        basicItem(DDModItems.GREEN_BEAN_SEEDS.get());
        basicItem(DDModItems.KIWI.get());
        basicItem(DDModItems.LEMON.get());
        basicItem(DDModItems.MANGO.get());
        basicItem(DDModItems.ORANGE.get());
        basicItem(DDModItems.PEA.get());
        basicItem(DDModItems.PEA_SEEDS.get());
        basicItem(DDModItems.PEAR.get());
        basicItem(DDModItems.PINEAPPLE.get());
        basicItem(DDModItems.PINEAPPLE_SLICE.get());
        basicItem(DDModItems.EMERALD_PEAR.get());
        //HANDHELD
        basicItem(DDModItems.BACON_WRAPPED_GREEN_BEANS.get());
        basicItem(DDModItems.FRITATA.get());
        basicItem(DDModItems.SMASHED_PEAS_ON_TOAST.get());
        basicItem(DDModItems.STUFFED_BELL_PEPPER.get());
        basicItem(DDModItems.VEGETABLE_STICKS.get());

        basicItem(DDModItems.BANANA_BREAD.get());
        basicItem(DDModItems.FRUIT_ROLLUP.get());
        basicItem(DDModItems.POACHED_PEAR.get());
        basicItem(DDModItems.LEMON_JELLY.get());
        basicItem(DDModItems.MANGO_JELLY.get());
        basicItem(DDModItems.KIWI_JELLY.get());
        basicItem(DDModItems.ICE_CREAM_CONE.get());
        basicItem(DDModItems.LEMON_ICE_CREAM.get());
        basicItem(DDModItems.MANGO_ICE_CREAM.get());
        basicItem(DDModItems.CHOCOLATE_ICE_CREAM.get());
        basicItem(DDModItems.ORANGE_JUICE.get());
        basicItem(DDModItems.PINEAPPLE_JUICE.get());
        basicItem(DDModItems.BANANA_MILK.get());
        basicItem(DDModItems.MANGO_YOGHURT.get());
        basicItem(DDModItems.ORANGE_YOGHURT.get());


        basicItem(DDModItems.HAWAIIAN_PIZZA.get());
        basicItem(DDModItems.BANOFFEE_PIE.get());
        basicItem(DDModItems.LEMON_MERINGUE_PIE.get());
        basicItem(DDModItems.PEAR_PIE.get());
        basicItem(DDModItems.FRUIT_FLAN.get());

        basicItem(DDModItems.HAWAIIAN_PIZZA_SLICE.get());
        basicItem(DDModItems.BANOFFEE_PIE_SLICE.get());
        basicItem(DDModItems.LEMON_MERINGUE_PIE_SLICE.get());
        basicItem(DDModItems.PEAR_PIE_SLICE.get());
        basicItem(DDModItems.FRUIT_FLAN_SLICE.get());


        //BOWLS
        basicItem(DDModItems.CAULIFLOWER_SOUP.get());
        basicItem(DDModItems.CHILI_BEAN_SOUP.get());
        basicItem(DDModItems.GUMBO.get());
        basicItem(DDModItems.TERIYAKI_CHICKEN.get());

        basicItem(DDModItems.BANANA_CHIPS.get());
        basicItem(DDModItems.CEREAL_BOWL.get());
        basicItem(DDModItems.ORANGE_CHICKEN.get());
        basicItem(DDModItems.SWEET_AND_SOUR_CHICKEN.get());
        basicItem(DDModItems.TROPICAL_SALAD.get());
        //PLATES
        basicItem(DDModItems.BUFFALO_WINGS.get());
        basicItem(DDModItems.CAULIFLOWER_STEAK.get());
        basicItem(DDModItems.CHICKEN_POT_PIE.get());
        basicItem(DDModItems.CHICKEN_POT_PIE_BLOCK.get());
        basicItem(DDModItems.GREEN_BEAN_CASSEROLE.get());
        basicItem(DDModItems.GREEN_BEAN_STIR_FRY.get());
        basicItem(DDModItems.MIXED_VEGETABLE_MEDLEY.get());
        basicItem(DDModItems.PEA_PESTO_PASTA.get());
        basicItem(DDModItems.VEGETABLE_STICKS_BLOCK.get());

        basicItem(DDModItems.APPLE_PEAR_CRUMBLE.get());

        //CONDIMENTS
        basicItem(DDModItems.KETCHUP.get());
        basicItem(DDModItems.MARMALADE.get());
        basicItem(DDModItems.MAYONNAISE.get());
        basicItem(DDModItems.HOT_SAUCE.get());

        itemGeneratedModel(DDModItems.APPLE_TREE_SAPLING.get());
        itemGeneratedModel(DDModItems.ORANGE_TREE_SAPLING.get());
        itemGeneratedModel(DDModItems.LEMON_TREE_SAPLING.get());
        itemGeneratedModel(DDModItems.PEAR_TREE_SAPLING.get());
        itemGeneratedModel(DDModItems.MANGO_TREE_SAPLING.get());
        itemGeneratedModel(DDModItems.BANANA_TREE_SAPLING.get());

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



    }


}