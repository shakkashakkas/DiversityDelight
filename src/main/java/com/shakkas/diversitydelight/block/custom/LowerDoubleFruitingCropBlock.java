package com.shakkas.diversitydelight.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;

import java.util.function.Supplier;

public class LowerDoubleFruitingCropBlock extends CropBlock {
    public static final int PREMATURE_MAX_AGE = 4;

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};


    private final Supplier<Item> cropDrop;
    private final Supplier<Item> seedDrop;
    private final Supplier<Block> upperCrop;

    public LowerDoubleFruitingCropBlock(Properties properties, Supplier<Item> cropDrop, Supplier<Item> seedDrop, Supplier<Block> upperCrop) {
        super(properties);
        this.cropDrop = cropDrop;
        this.seedDrop = seedDrop;
        this.upperCrop = upperCrop;
    }
    protected Item getCropDrop() {
        return cropDrop.get();
    }
    protected Item getSeedDrop() {
        return seedDrop.get();
    }
    protected Block getUpperCrop() {
        return upperCrop.get();
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return getSeedDrop();
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isAreaLoaded(pos, 1)) return;
        if (level.getRawBrightness(pos, 0) >= 9) {
            int age = this.getAge(state);
            boolean upperExists = level.getBlockState(pos.above()).is(this.getUpperCrop());
            float speed = getGrowthSpeed(state, level, pos);

            if (CommonHooks.canCropGrow(level, pos, state, random.nextInt((int) (25.0F / speed) + 1) == 0)) {
                if (age == this.getMaxAge()) {
                    if (!upperExists && level.getBlockState(pos.above()).isAir()) {
                        level.setBlockAndUpdate(pos.above(), getUpperCrop().defaultBlockState());
                        CommonHooks.fireCropGrowPost(level, pos, state);
                    }
                }
                else if (age >= PREMATURE_MAX_AGE) {
                    if (!upperExists && level.getBlockState(pos.above()).isAir()) {
                        level.setBlockAndUpdate(pos.above(), getUpperCrop().defaultBlockState());
                        CommonHooks.fireCropGrowPost(level, pos, state);
                    }
                    if (upperExists) {
                        int upperAge = level.getBlockState(pos.above()).getValue(getAgeProperty());
                        if (upperAge >= UpperDoubleFruitingCropBlock.PREMATURE_MAX_AGE) {
                            level.setBlock(pos, this.getStateForAge(age + 1), 2);
                            CommonHooks.fireCropGrowPost(level, pos, state);
                        }
                    }
                }
                else {
                    level.setBlock(pos, this.getStateForAge(age + 1), 2);
                    CommonHooks.fireCropGrowPost(level, pos, state);
                }
            }
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }


    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        int age = state.getValue(getAgeProperty());
        boolean isMature = age == getMaxAge();
        if (isMature) {
            int quantity = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(getCropDrop(), quantity));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, state.setValue(getAgeProperty(), PREMATURE_MAX_AGE), 2);
            return InteractionResult.SUCCESS;
        } else {
            return super.useWithoutItem(state, level, pos, player, hit);
        }
    }
}
