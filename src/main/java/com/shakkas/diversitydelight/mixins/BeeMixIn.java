package com.shakkas.diversitydelight.mixins;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.animal.Bee;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Bee.class)
public abstract class BeeMixIn {
    private int mutation = 0;
    private int yield = 0;
    private int growth = 0;

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    public void addAdditionalSaveData(CompoundTag compound, CallbackInfo ci) {
//        compound.putInt("geneMutation", this.mutation);
//        compound.putInt("geneYield", this.yield);
//        compound.putInt("geneGrowth", this.growth);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    public void readAdditionalSaveData(CompoundTag compound,CallbackInfo ci) {
//        compound.getInt("geneMutation");
//        compound.getInt("geneYield");
//        compound.getInt("geneGrowth");
    }
}
