package com.shakkas.diversitydelight.mixins;

import net.neoforged.fml.loading.FMLLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class DDMixinPlugin implements IMixinConfigPlugin {
    private static final boolean PRODUCTIVE_BEES_LOADED =
            FMLLoader.getLoadingModList().getModFileById("productivebees") != null;

    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return "";
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.endsWith("BeePollinateGoalMixIn")) {
            return !PRODUCTIVE_BEES_LOADED;
        }
        if (mixinClassName.endsWith("BeePollinateGoalProductiveBeesMixIn")) {
            return PRODUCTIVE_BEES_LOADED;
        }
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return List.of();
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
