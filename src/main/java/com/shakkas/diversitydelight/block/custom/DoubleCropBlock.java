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
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;

import java.util.function.Supplier;

public class DoubleCropBlock extends CropBlock {
    public DoubleCropBlock(Properties properties, int ageForUpper, Supplier<Item> cropDrop, Supplier<Item> seedDrop, boolean isTall) {
        super(properties);
        this.ageForUpper = ageForUpper;
        this.cropDrop = cropDrop;
        this.seedDrop = seedDrop;
        this.isTall = isTall;
        this.registerDefaultState((this.stateDefinition.any()).setValue(this.getAgeProperty(), 0).setValue(HALF,DoubleBlockHalf.LOWER));
    }
    private final int ageForUpper;
    private final Supplier<Item> cropDrop;
    private final Supplier<Item> seedDrop;
    private final boolean isTall;
    private final int FRUITING_AGE = 5;
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public int getAgeForUpper() {
        return this.ageForUpper;
    }

    protected Item getSeedDrop() {
        return seedDrop.get();
    }
    protected Item getCropDrop() { return cropDrop.get();}

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(HALF);
    }

    private static final VoxelShape[] SHAPE_BY_AGE_LOWER = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    private static final VoxelShape[] SHAPE_BY_AGE_TALL_UPPER = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D)};

    private static final VoxelShape[] SHAPE_BY_AGE_MEDIUM_UPPER = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)};

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int age = state.getValue(this.getAgeProperty());
        if (isTall) {
            return state.getValue(HALF) == DoubleBlockHalf.LOWER ? SHAPE_BY_AGE_LOWER[age] : SHAPE_BY_AGE_TALL_UPPER[age];
        }
        else {
            return state.getValue(HALF) == DoubleBlockHalf.LOWER ? SHAPE_BY_AGE_LOWER[age] : SHAPE_BY_AGE_MEDIUM_UPPER[age];
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(AGE,0);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState stateBelow = level.getBlockState(pos.below());
        if ((state.getValue(HALF) == DoubleBlockHalf.UPPER) && (stateBelow.getBlock() instanceof DoubleCropBlock)) {
            return (stateBelow.getValue(HALF) == DoubleBlockHalf.LOWER);
        }
        else {
            return super.canSurvive(state,level,pos);
        }
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return this.getSeedDrop();
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(HALF) != DoubleBlockHalf.UPPER;
    }

    @Override
    public void onRemove(BlockState oldState, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!oldState.is(newState.getBlock())) {
            if (oldState.getValue(HALF) == DoubleBlockHalf.UPPER) {
                level.setBlockAndUpdate(pos.below(),Blocks.AIR.defaultBlockState());
            }
            super.onRemove(oldState, level, pos, newState, isMoving);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isAreaLoaded(pos, 1)) return;
        if (level.getRawBrightness(pos, 0) >= 9) {
            int age = this.getAge(state);
            boolean upperExists = level.getBlockState(pos.above()).is(this);
            float speed = getGrowthSpeed(state, level, pos);
            float maturity = (age < FRUITING_AGE) ? 1 : 2;

            if (CommonHooks.canCropGrow(level, pos, state, random.nextInt((int) ((25.0F / speed) + 1))*maturity == 0)) {
                if (age < this.getMaxAge()) {
                    level.setBlock(pos, this.getStateForAge(age + 1).setValue(HALF,DoubleBlockHalf.LOWER), 2);
                    CommonHooks.fireCropGrowPost(level, pos, state);
                    if (age >= getAgeForUpper()-1) {
                        if (!upperExists && level.getBlockState(pos.above()).isAir()) {
                            level.setBlockAndUpdate(pos.above(), this.defaultBlockState().setValue(AGE,age+1).setValue(HALF,DoubleBlockHalf.UPPER));
                            CommonHooks.fireCropGrowPost(level, pos.above(), state);
                        }
                    }
                    if (upperExists) {
                        level.setBlockAndUpdate(pos.above(), this.defaultBlockState().setValue(AGE,age+1).setValue(HALF,DoubleBlockHalf.UPPER));
                        CommonHooks.fireCropGrowPost(level, pos.above(), state);
                    }
                }
            }
        }
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            BlockState lowerState = level.getBlockState(pos.below());
            this.growCrops(level,pos.below(),lowerState);
            int lowerAge = level.getBlockState(pos.below()).getValue(getAgeProperty());
            level.setBlock(pos, this.defaultBlockState().setValue(AGE,lowerAge).setValue(HALF,DoubleBlockHalf.UPPER), 2);
        }
        else {
            this.growCrops(level,pos,state);
            boolean upperExists = level.getBlockState(pos.above()).is(this);
            int age = level.getBlockState(pos).getValue(getAgeProperty());
            if (upperExists) {
                level.setBlock(pos.above(), this.defaultBlockState().setValue(AGE,age).setValue(HALF,DoubleBlockHalf.UPPER), 2);
            }
            else if (age >= getAgeForUpper()) {
                level.setBlock(pos.above(), this.defaultBlockState().setValue(AGE,age).setValue(HALF,DoubleBlockHalf.UPPER), 2);
            }
        }
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        int age = state.getValue(getAgeProperty());
        boolean isMature = age == getMaxAge();
        boolean upperExists = level.getBlockState(pos.above()).is(this);
        if (isMature) {
            int quantity = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(this.getCropDrop(), quantity));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
                level.setBlock(pos, state.setValue(getAgeProperty(), FRUITING_AGE), 2);
                if (upperExists) {
                    level.setBlock(pos.above(), this.defaultBlockState().setValue(AGE,FRUITING_AGE).setValue(HALF,DoubleBlockHalf.UPPER), 2);
                }
            }
            else {
                level.setBlock(pos, this.defaultBlockState().setValue(AGE,FRUITING_AGE).setValue(HALF,DoubleBlockHalf.UPPER), 2);
                level.setBlock(pos.below(), this.defaultBlockState().setValue(AGE,FRUITING_AGE).setValue(HALF,DoubleBlockHalf.LOWER), 2);
            }

            return InteractionResult.SUCCESS;
        } else {
            return super.useWithoutItem(state, level, pos, player, hit);
        }
    }
}
