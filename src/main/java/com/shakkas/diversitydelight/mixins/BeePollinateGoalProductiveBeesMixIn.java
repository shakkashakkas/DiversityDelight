package com.shakkas.diversitydelight.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.shakkas.diversitydelight.block.custom.FruitingLeavesBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;
import java.util.function.Predicate;

@Mixin(targets = "net.minecraft.world.entity.animal.Bee$BeePollinateGoal")
public abstract class BeePollinateGoalProductiveBeesMixIn {
    @Shadow
    private Bee this$0;

    @Shadow
    private Optional<BlockPos> findNearestBlock(Predicate<BlockPos> predicate, double distance) {
        return Optional.empty();
    }

    private final Predicate<BlockPos> VALID_FLOWERING_LEAVES_BLOCKS = pos -> {
        BlockState state = this$0.level().getBlockState(pos);
        if (state.getBlock() instanceof FruitingLeavesBlock fruitingLeavesBlock) {
            return !fruitingLeavesBlock.getPollinationStatus(this$0.level(), pos);
        }
        return false;
    };

    @Inject(method = "findNearbyFlower", at = @At("RETURN"), cancellable = true)
    public void onFindNearbyFlower(CallbackInfoReturnable<Optional<BlockPos>> cir) {
        Optional<BlockPos> productiveBeesResult = cir.getReturnValue();
        Optional<BlockPos> fruitingLeavesResult = findNearestBlock(VALID_FLOWERING_LEAVES_BLOCKS, 5.0);

        if (fruitingLeavesResult.isEmpty()) {
            return;
        }
        if (productiveBeesResult.isEmpty()) {
            cir.setReturnValue(fruitingLeavesResult);
            return;
        }

        BlockPos beePos = this$0.blockPosition();
        double productiveBeesDistance = beePos.distSqr(productiveBeesResult.get());
        double fruitingLeavesDistance = beePos.distSqr(fruitingLeavesResult.get());

        if (fruitingLeavesDistance < productiveBeesDistance) {
            cir.setReturnValue(fruitingLeavesResult);
        }
    }
}
