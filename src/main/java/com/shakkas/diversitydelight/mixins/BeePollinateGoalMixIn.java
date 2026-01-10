package com.shakkas.diversitydelight.mixins;

import com.shakkas.diversitydelight.block.custom.FruitingLeavesBlock;
import com.shakkas.diversitydelight.block.entity.FruitingLeavesBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(targets = "net.minecraft.world.entity.animal.Bee$BeePollinateGoal")
public abstract class BeePollinateGoalMixIn {
    @Shadow
    private Bee this$0;

    @Inject(method = "stop", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Bee;setHasNectar(Z)V", shift = At.Shift.AFTER))
    public void stop(CallbackInfo ci) {
        if (this$0.getSavedFlowerPos() != null) {
            BlockEntity targetFlower = this$0.level().getBlockEntity(this$0.getSavedFlowerPos());

            if (targetFlower instanceof FruitingLeavesBlockEntity fruitingLeavesBlockEntity) {
                CompoundTag compound = this$0.getPersistentData();
                compound.putInt("geneMutation", fruitingLeavesBlockEntity.mutation);
                compound.putInt("geneYield", fruitingLeavesBlockEntity.yield);
                compound.putInt("geneGrowth", fruitingLeavesBlockEntity.growth);
            }
        }
    }
}
