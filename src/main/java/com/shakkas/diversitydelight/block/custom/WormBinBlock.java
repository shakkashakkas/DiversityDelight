package com.shakkas.diversitydelight.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.CommonHooks;

import javax.annotation.Nullable;

public class WormBinBlock extends ComposterBlock {
    public WormBinBlock(Properties properties) {
        super(properties.randomTicks());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LEVEL,0));
    }

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(LEVEL,0);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        int i = (Integer)state.getValue(LEVEL);
        if (i == 7) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        return super.useItemOn(stack,state,level,pos,player,hand,hitResult);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!oldState.is(this)) {
            level.invalidateCapabilities(pos);
        }
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        return InteractionResult.PASS;
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return !(state.getValue(LEVEL) == 0);
    }

    public boolean isNearbyBonemealable(ServerLevel level, BlockPos pos) {
        int xDist = 5; int yDist = 1; int zDist = 5;
        BlockPos vertex1 = pos.offset(-xDist,0,-zDist);
        BlockPos vertex2 = pos.offset(xDist,yDist,zDist);
        for (BlockPos targetPos : BlockPos.betweenClosed(vertex1, vertex2)) {
            BlockState targetState = level.getBlockState(targetPos);
            if (targetState.getBlock() instanceof BonemealableBlock) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isAreaLoaded(pos, 1)) return;
        int xDist = 5; int yDist = 1; int zDist = 5; int contentLevel = state.getValue(WormBinBlock.LEVEL);
        if ((random.nextInt(30) == 0) && isNearbyBonemealable(level, pos)) {
            level.setBlock(pos, state.setValue(WormBinBlock.LEVEL,contentLevel-1), 3);
            BlockPos vertex1 = pos.offset(-xDist,0,-zDist);
            BlockPos vertex2 = pos.offset(xDist,yDist,zDist);
            for (BlockPos targetPos : BlockPos.betweenClosed(vertex1, vertex2)) {
                BlockState targetState = level.getBlockState(targetPos);
                if ((targetState.getBlock() instanceof BonemealableBlock growable)) {
                    if (CommonHooks.canCropGrow(level, targetPos, targetState, random.nextInt(8)==0) && growable.isValidBonemealTarget(level, targetPos, targetState)) {
                        growable.performBonemeal(level, level.random, targetPos, targetState);
                        CommonHooks.fireCropGrowPost(level, targetPos, targetState);
                        level.sendParticles(ParticleTypes.HAPPY_VILLAGER, targetPos.getX() + 0.5, targetPos.getY() + 1.0, targetPos.getZ() + 0.5, 5, 0.25, 0.25, 0.25, 0.05);
                    }
                }
            }
        }
    }
}
