package com.shakkas.diversitydelight.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import java.util.function.Supplier;

public class BananaFrond extends LeavesBlock {
    public BananaFrond(Properties properties) {
        super(properties);
    }

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    public static BlockState updateDistance(BlockState state, LevelAccessor level, BlockPos pos) {
        int i = 7;

        int xDist = 1; int yDist = 1; int zDist = 1;
        BlockPos vertex1 = pos.offset(-xDist,-yDist,-zDist);
        BlockPos vertex2 = pos.offset(xDist,yDist,zDist);
        if (state.getValue(DISTANCE) >= 2) {
            for (BlockPos targetPos : BlockPos.betweenClosed(vertex1, vertex2)) {
                BlockState targetState = level.getBlockState(targetPos);
                // Do not consider the block's own position in the for loop
                if (targetPos.equals(pos)) {
                    continue;
                }
                if (targetState.hasProperty(DISTANCE)) {
                    i = Math.min(i, targetState.getValue(DISTANCE)+1);
                }
                if (i == 1) {
                    break;
                }
            }
        }

        BlockPos.MutableBlockPos cursor = new BlockPos.MutableBlockPos();

        for(Direction direction : Direction.values()) {
            cursor.setWithOffset(pos, direction);
            BlockState targetState = level.getBlockState(cursor);
            i = Math.min(i, getOptionalDistanceAt(targetState).orElse(7)+1);
            if (i == 1) {
                break;
            }
        }
        return state.setValue(DISTANCE, i);
    }


    public boolean isAdjacentToValidLeaf(BlockState state, BlockPos pos, ServerLevel level) {
        int xDist = 1; int yDist = 1; int zDist = 1;
        BlockPos vertex1 = pos.offset(-xDist,-yDist,-zDist);
        BlockPos vertex2 = pos.offset(xDist,yDist,zDist);
        for (BlockPos targetPos : BlockPos.betweenClosed(vertex1, vertex2)) {
            BlockState targetState = level.getBlockState(targetPos);
            if (targetPos.equals(pos)) {
                continue;
            }
            if (targetState.hasProperty(DISTANCE)) {
                if (state.getValue(DISTANCE) >= 2) {
                    if (targetState.getValue(DISTANCE) == (state.getValue(DISTANCE) - 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isFacingLog(BlockPos pos, ServerLevel level) {
        BlockPos.MutableBlockPos cursor = new BlockPos.MutableBlockPos();

        for(Direction direction : Direction.values()) {
            cursor.setWithOffset(pos, direction);
            BlockState targetState = level.getBlockState(cursor);
            if (targetState.is(BlockTags.LOGS)) {
                return true;
            }
        }
        return false;
    }


    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        level.scheduleTick(currentPos, this, 1);
        return super.updateShape(state,facing,facingState,level,currentPos,facingPos);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!isAdjacentToValidLeaf(state,pos,level) && !isFacingLog(pos,level)) {
            dropResources(state, level, pos);
            level.removeBlock(pos, false);
        }
    }
    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(PERSISTENT);
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        level.setBlock(pos, updateDistance(state, level, pos), 3);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidContext = context.getLevel().getFluidState(context.getClickedPos());
        Level level = context.getLevel();
        BlockPos posContext = context.getClickedPos();
        Direction dirContext = context.getHorizontalDirection().getOpposite();
        BlockState stateContext = (this.defaultBlockState().setValue(PERSISTENT, true)).setValue(WATERLOGGED, fluidContext.getType() == Fluids.WATER).setValue(FACING, dirContext);
        return updateDistance(stateContext, level, posContext);
    }
}
