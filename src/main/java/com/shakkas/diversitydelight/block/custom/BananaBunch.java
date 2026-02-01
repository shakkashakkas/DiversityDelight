package com.shakkas.diversitydelight.block.custom;

import com.shakkas.diversitydelight.item.DDModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;

import java.util.function.Supplier;

public class BananaBunch extends CropBlock {
    public BananaBunch(Properties properties) {
        super(properties);
    }

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 4.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 4.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.isAreaLoaded(pos, 1)) {
            if (level.getRawBrightness(pos, 0) >= 9) {
                int age = this.getAge(state);
                float growthChance = getGrowthSpeed(state, level, pos);
                if (age < this.getMaxAge()) {
                    if (CommonHooks.canCropGrow(level, pos, state, (random.nextInt((int)(25.0F / growthChance) + 1) == 0))) {
                        level.setBlock(pos, state.setValue(getAgeProperty(), age+1), 2);
                        CommonHooks.fireCropGrowPost(level, pos, state);
                    }
                }
            }
        }
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return DDModItems.BANANA;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getBlock() instanceof BananaFrond;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos above = pos.above();
        BlockState aboveState = level.getBlockState(above);
        return mayPlaceOn(aboveState,level,above);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        int age = getAge(state);
        if (age==MAX_AGE) {
            int quantity = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(DDModItems.BANANA.get(), quantity));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, state.setValue(getAgeProperty(), 0), 2);
            return InteractionResult.SUCCESS;
        } else {
            return super.useWithoutItem(state, level, pos, player, hit);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(AGE,0);
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }
}
