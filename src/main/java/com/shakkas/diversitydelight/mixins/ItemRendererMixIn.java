package com.shakkas.diversitydelight.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shakkas.diversitydelight.utils.CondimentRenderUtils;
import com.shakkas.diversitydelight.utils.TagUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixIn {

    private static boolean alreadyRendering = false;

    @Shadow
    public abstract void render(ItemStack itemStack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay, BakedModel p_model);


    @Inject(method = "render",
            at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;popPose()V", shift = At.Shift.AFTER))
    public void renderCondimentOverlay(ItemStack itemStack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay, BakedModel p_model, CallbackInfo ci) {
        if (alreadyRendering) return;
        String category = "condiment";
        boolean hasCondiment = TagUtils.hasString(itemStack, category);
        if (hasCondiment) {
            alreadyRendering = true;
            this.render(itemStack, displayContext, leftHand, poseStack, bufferSource, combinedLight, combinedOverlay, p_model);
            alreadyRendering = false;
        }
    }

    @Inject(method = "render",
            at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(FFF)V", shift = At.Shift.AFTER))
    public void modifyCondimentRender(ItemStack itemStack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay, BakedModel p_model, CallbackInfo ci) {
        if (alreadyRendering) {
            float scaleFactor = 1.01f;
            poseStack.scale(1, scaleFactor, scaleFactor);
            poseStack.translate(0.001F, -0.005F, -0.005F);
        }
    }

    @ModifyVariable(method = "render", at = @At("HEAD"), ordinal = 0)
    private BakedModel replacedModel(BakedModel model, ItemStack itemStack) {
        if (alreadyRendering) {
            ModelResourceLocation modelLoc = CondimentRenderUtils.getModel(itemStack);
            BakedModel bakedmodel = Minecraft.getInstance().getModelManager().getModel(modelLoc);
            return bakedmodel;
        }
        return model;
    }
}
