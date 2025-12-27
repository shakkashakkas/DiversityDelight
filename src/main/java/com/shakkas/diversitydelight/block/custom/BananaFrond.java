package com.shakkas.diversitydelight.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
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
    public static final BooleanProperty CONNECTED = BooleanProperty.create("connected");

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING,CONNECTED);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(PERSISTENT) && !state.getValue(CONNECTED);
    }

    protected boolean checkConnection(BlockState state, LevelAccessor level, BlockPos pos) {
        int xDist = 1; int yDist = 1; int zDist = 1;
        BlockPos vertex1 = pos.offset(-xDist,-yDist,-zDist);
        BlockPos vertex2 = pos.offset(xDist,yDist,zDist);
        for (BlockPos targetPos : BlockPos.betweenClosed(vertex1, vertex2)) {
            BlockState targetState = level.getBlockState(targetPos);
            // Do not consider the block's own position in the for loop
            if (targetPos.equals(pos)) {
                continue;
            }
            if (targetState.is(BlockTags.LOGS)) {
                return true;
            }

            if (targetState.getBlock() instanceof BananaFrond) {
                if (targetState.getValue(CONNECTED)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected BlockState updateConnection(BlockState state, LevelAccessor level, BlockPos pos) {
        return (checkConnection(state,level,pos)) ? state.setValue(CONNECTED,true) : state.setValue(CONNECTED,false);
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        level.scheduleTick(currentPos, this, 1);
        return super.updateShape(state,facing,facingState,level,currentPos,facingPos);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.getValue(PERSISTENT) && !state.getValue(CONNECTED)) {
            dropResources(state, level, pos);
            level.removeBlock(pos, false);
        }
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        level.setBlock(pos, updateConnection(state, level, pos), 3);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(PERSISTENT, false).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER).setValue(CONNECTED,false);
    }
}
