package com.shakkas.diversitydelight.world.tree;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.shakkas.diversitydelight.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import org.jetbrains.annotations.NotNull;

public class BananaFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<BananaFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> foliagePlacerParts(instance).apply(instance, BananaFoliagePlacer::new));

    public BananaFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return DDPlacerTypes.BANANA_FOLIAGE.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        createLowerFrondLeaf(blockSetter,random,config,attachment.pos(),Direction.NORTH);
        createLowerFrondLeaf(blockSetter,random,config,attachment.pos(),Direction.SOUTH);
        createLowerFrondLeaf(blockSetter,random,config,attachment.pos(),Direction.EAST);
        createLowerFrondLeaf(blockSetter,random,config,attachment.pos(),Direction.WEST);

        if (random.nextInt(1) == 0) {
            placeFrondBlock(blockSetter,random,config,attachment.pos(),Direction.EAST);
            createMiddleFrondLeaves(blockSetter,random,config,attachment.pos(),Direction.EAST);
            createMiddleFrondLeaves(blockSetter,random,config,attachment.pos(),Direction.WEST);
        }
        else {
            placeFrondBlock(blockSetter,random,config,attachment.pos(),Direction.NORTH);
            createMiddleFrondLeaves(blockSetter,random,config,attachment.pos(),Direction.NORTH);
            createMiddleFrondLeaves(blockSetter,random,config,attachment.pos(),Direction.SOUTH);
        }
    }

    protected void createMiddleFrondLeaves(FoliageSetter blockSetter,RandomSource random,TreeConfiguration config, BlockPos pos, Direction dir) {
        BlockPos.MutableBlockPos frondCursorRight = pos.mutable();
        BlockPos.MutableBlockPos frondCursorLeft = pos.mutable();
        for (int i = 0; i < 2; ++i) {
            frondCursorRight.move(Direction.UP);
            frondCursorRight.move(dir.getClockWise());
            frondCursorRight.move(dir);
            placeFrondBlock(blockSetter,random,config, frondCursorRight, dir);

            frondCursorLeft.move(Direction.UP);
            frondCursorLeft.move(dir.getCounterClockWise());
            frondCursorLeft.move(dir);
            placeFrondBlock(blockSetter,random,config, frondCursorLeft, dir);
        }
        Direction bendDirectionRight = (random.nextInt(1) == 0) ? dir : dir.getClockWise();
        Direction bendDirectionLeft = (random.nextInt(1) == 0) ? dir : dir.getCounterClockWise();
        for (int j = 0; j < random.nextInt(1,3); ++j) {
            frondCursorRight.move(bendDirectionRight);
            frondCursorLeft.move(bendDirectionLeft);
            placeFrondBlock(blockSetter,random,config, frondCursorRight, bendDirectionRight);
            placeFrondBlock(blockSetter,random,config, frondCursorLeft, bendDirectionLeft);
        }
    }

    protected void createLowerFrondLeaf(FoliageSetter blockSetter,RandomSource random,TreeConfiguration config, BlockPos pos, Direction dir) {
        BlockPos.MutableBlockPos frondCursor = pos.mutable();
        //First leaf outward at same y-level
        frondCursor.move(Direction.DOWN);
        frondCursor.move(dir);
        placeFrondBlock(blockSetter,random,config, frondCursor, dir);
        placeBananaBunch(blockSetter,frondCursor,dir);
        //Second leaf outward at same y-level
        frondCursor.move(dir);
        placeFrondBlock(blockSetter,random,config, frondCursor, dir);
        //Third leaf down 1 y-level and out again
        frondCursor.move(dir);
        frondCursor.move(Direction.DOWN);
        placeFrondBlock(blockSetter,random,config, frondCursor, dir);
    }

    protected void placeFrondBlock(FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, BlockPos pos, Direction dir) {
        BlockState foliageState = config.foliageProvider.getState(random, pos);
        if (foliageState.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
            foliageState = foliageState.setValue(BlockStateProperties.HORIZONTAL_FACING,dir);
        }
        blockSetter.set(pos,foliageState);
    }

    protected static void placeBananaBunch(FoliageSetter blockSetter, BlockPos pos, Direction dir) {
        BlockState bananaBunchState = ModBlocks.BANANA_BUNCH.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING,dir.getOpposite());
        blockSetter.set(pos.below(),bananaBunchState);
    }

    @Override
    public int foliageHeight(RandomSource randomSource, int i, TreeConfiguration treeConfiguration) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource randomSource, int i, int i1, int i2, int i3, boolean b) {
        return false;
    }
}
