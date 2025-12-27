package com.shakkas.diversitydelight.world.tree;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.shakkas.diversitydelight.block.ModBlocks;
import com.shakkas.diversitydelight.block.custom.BananaStem;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class BananaTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<BananaTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> trunkPlacerParts(instance).apply(instance, BananaTrunkPlacer::new));

    public BananaTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    protected int stageGetter(int freeTreeHeight, int currentHeight) {
        if (currentHeight == freeTreeHeight-2) {
            return 1;
        }
        if (currentHeight == freeTreeHeight-1) {
            return 2;
        }
        else {
            return 0;
        }
    }

    protected void placeBananaStem(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int freeTreeHeight, BlockPos pos, TreeConfiguration config,int currentHeight,BlockState trunkState) {
        if (this.validTreePos(level, pos)) {
            blockSetter.accept(pos, trunkState.getBlock().defaultBlockState().setValue(BananaStem.STAGE,stageGetter(freeTreeHeight,currentHeight)));
        }
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return DDPlacerTypes.BANANA_TRUNK.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int freeTreeHeight, BlockPos pos, TreeConfiguration config) {
        for(int i = 0; i < freeTreeHeight; ++i) {
            BlockState trunkState = config.trunkProvider.getState(random,pos.above(i));
            if (trunkState.hasProperty(BananaStem.STAGE)) {
                placeBananaStem(level,blockSetter,random,freeTreeHeight,pos.above(i),config,i,trunkState);
            }
            else {
                placeLog(level,blockSetter,random,pos.above(i),config);
            }

        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.above(freeTreeHeight), 0, false));
    }
}
