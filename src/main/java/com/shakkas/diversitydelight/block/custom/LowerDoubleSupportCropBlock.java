package com.shakkas.diversitydelight.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;

import java.util.function.Supplier;

public class LowerDoubleSupportCropBlock extends CropBlock {
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    private final Supplier<Item> seedDrop;
    private final Supplier<Block> upperCrop;

    public LowerDoubleSupportCropBlock(Properties properties, Supplier<Item> seedDrop, Supplier<Block> upperCrop) {
        super(properties);
        this.seedDrop = seedDrop;
        this.upperCrop = upperCrop;
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


}
