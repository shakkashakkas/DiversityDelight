package com.shakkas.diversitydelight.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.shakkas.diversitydelight.block.custom.FruitingLeavesBlock;
import com.shakkas.diversitydelight.block.entity.FruitingLeavesBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;
import java.util.function.Predicate;

@Mixin(targets = "net.minecraft.world.entity.animal.Bee$BeePollinateGoal")
public abstract class BeePollinateGoalMixIn {
    @Shadow
    private Bee this$0;

    @Inject(method = "stop", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Bee;setHasNectar(Z)V", shift = At.Shift.AFTER))
    public void stop(CallbackInfo ci) {
        if (this$0.getSavedFlowerPos() != null) {
            BlockEntity targetFlowerEntity = this$0.level().getBlockEntity(this$0.getSavedFlowerPos());
            BlockState targetFlowerBlockState = this$0.level().getBlockState(this$0.getSavedFlowerPos());
            Block targetFlowerBlock = targetFlowerBlockState.getBlock();
            if (targetFlowerEntity instanceof FruitingLeavesBlockEntity fruitingLeavesBlockEntity) {
                CompoundTag compound = this$0.getPersistentData();
                boolean hasPollinatedFlower = compound.getBoolean("hasPollinatedFlower");
                if (hasPollinatedFlower) {
                    copyFlowerGenetics(compound, fruitingLeavesBlockEntity, targetFlowerBlock);
                }
                else {
                    int maleMutation = compound.getInt("geneMutation");
                    int maleYield = compound.getInt("geneYield");
                    int maleGrowth = compound.getInt("geneGrowth");
                    String fruitType = compound.getString("fruitType");
                    RandomSource random = this$0.level().getRandom();
                    fruitingLeavesBlockEntity.crossPollinate(random, maleMutation, maleYield, maleGrowth, fruitType);
                    fruitingLeavesBlockEntity.setPollinated();
                    if (targetFlowerBlock instanceof FruitingLeavesBlock fruitingLeavesBlock) {
                        if ((fruitingLeavesBlock.hasMutatedVariant()) && (fruitingLeavesBlockEntity.mutation == FruitingLeavesBlockEntity.MAX_GENETIC_VALUE)) {
                            int parentMutation = fruitingLeavesBlockEntity.mutation;
                            int parentYield = fruitingLeavesBlockEntity.yield;
                            int parentGrowth = fruitingLeavesBlockEntity.growth;
                            this$0.level().setBlockAndUpdate(this$0.getSavedFlowerPos(),fruitingLeavesBlock.getMutatedVariant().defaultBlockState().setValue(FruitingLeavesBlock.AGE,fruitingLeavesBlock.getAge(targetFlowerBlockState)));
                            BlockEntity newTargetFlowerEntity = this$0.level().getBlockEntity(this$0.getSavedFlowerPos());
                            if (newTargetFlowerEntity instanceof FruitingLeavesBlockEntity newFruitingLeavesBlockEntity) {
                                newFruitingLeavesBlockEntity.freshGenetics(parentMutation,parentYield,parentGrowth);
                            }
                        }
                    }

                }
                fruitingLeavesBlockEntity.setPollinated();
                updatePollinationStatus(compound,hasPollinatedFlower);
            }
        }
    }

    public void copyFlowerGenetics(CompoundTag compound, FruitingLeavesBlockEntity fruitingLeavesBlockEntity, Block block) {
        String fruitType = BuiltInRegistries.BLOCK.getKey(block).toString();
        compound.putInt("geneMutation", fruitingLeavesBlockEntity.mutation);
        compound.putInt("geneYield", fruitingLeavesBlockEntity.yield);
        compound.putInt("geneGrowth", fruitingLeavesBlockEntity.growth);
        compound.putString("fruitType",fruitType);
    }

    public void updatePollinationStatus(CompoundTag compound, boolean hasPollinatedFlower) {
        if (hasPollinatedFlower) {
            compound.putBoolean("hasPollinatedFlower",false);
        }
        else {
            compound.putBoolean("hasPollinatedFlower",true);
        }
    }

    @WrapOperation(method = "findNearestBlock", at = @At(value = "INVOKE", target = "Ljava/util/function/Predicate;test(Ljava/lang/Object;)Z"))
    private boolean isValidFlowerTarget(Predicate<BlockState> predicate, Object obj, Operation<Boolean> original, @Local BlockPos.MutableBlockPos blockpos$mutableblockpos) {
        BlockState state = (BlockState) obj;
        if (state.getBlock() instanceof FruitingLeavesBlock fruitingLeavesBlock) {
            if (fruitingLeavesBlock.getPollinationStatus(this$0.level(),blockpos$mutableblockpos)) {
                return false;
            }
        }
        return original.call(predicate,obj);
    }
}
