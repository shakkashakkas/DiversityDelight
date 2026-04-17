package com.shakkas.diversitydelight.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;

public class CornCropBlock extends CropBlock {

    public CornCropBlock(Properties properties) {
        super(properties);
    }


    public static final EnumProperty<Section> SECTION = EnumProperty.create("section",Section.class);

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(SECTION);

    }

    private static final VoxelShape[] SHAPE_BY_AGE_LOWER = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    private static final VoxelShape[] SHAPE_BY_AGE_MIDDLE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    private static final VoxelShape[] SHAPE_BY_AGE_UPPER = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int age = state.getValue(this.getAgeProperty());
        Section section = state.getValue(SECTION);
        switch (section) {
            case LOWER -> {
                return SHAPE_BY_AGE_LOWER[age];
            }
            case MIDDLE -> {
                return SHAPE_BY_AGE_MIDDLE[age];
            }
            case UPPER -> {
                return SHAPE_BY_AGE_UPPER[age];
            }
        }
        return SHAPE_BY_AGE_LOWER[age];
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(SECTION, Section.LOWER).setValue(AGE,0);
    }

    public EnumProperty<Section> getSectionProperty() {
        return SECTION;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        Section section = state.getValue(SECTION);
        int age = state.getValue(AGE);
        return switch (section) {
            case LOWER -> (0 <= age && age <= 1);
            case MIDDLE -> (2 <= age && age <= 3);
            case UPPER -> (4 <= age && age <= 6);
        };
    }

    public boolean canPlaceAbove(BlockState state, ServerLevel level, BlockPos pos, boolean isBonemealed) {
        int age = state.getValue(AGE);
        Section section = state.getValue(SECTION);
        switch (section) {
            case LOWER -> {
                if (age >= 3 || isBonemealed) {
                    return ((level.getBlockState(pos.above()).isAir()) || level.getBlockState(pos.above()).getBlock() instanceof CornCropBlock) && (((level.getBlockState(pos.above(2)).isAir()) || level.getBlockState(pos.above(2)).getBlock() instanceof CornCropBlock));
                }
                if (age >= 1) {
                    return ((level.getBlockState(pos.above()).isAir()) || level.getBlockState(pos.above()).getBlock() instanceof CornCropBlock);
                }
            }
            case MIDDLE -> {
                if (age >= 3 || isBonemealed) {
                    return ((level.getBlockState(pos.above()).isAir()) || level.getBlockState(pos.above()).getBlock() instanceof CornCropBlock);
                }
            }
        };
        return true;
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState stateBelow = level.getBlockState(pos.below());
        Section section = state.getValue(SECTION);
        switch (section) {
            case LOWER -> {
                return super.canSurvive(state,level,pos);
            }
            case MIDDLE -> {
                if ((stateBelow.getBlock() instanceof CornCropBlock)) {
                    return (stateBelow.getValue(SECTION) == Section.LOWER);
                }
            }
            case UPPER -> {
                if ((stateBelow.getBlock() instanceof CornCropBlock)) {
                    return (stateBelow.getValue(SECTION) == Section.MIDDLE);
                }
            }
        }
        return false;
    }

    public void updateCorn(Level level, BlockPos pos, int yOffset, BlockState newState, Section newSection) {
        BlockPos targetPos = pos.above(yOffset);
        if (newState.getBlock() instanceof CornCropBlock) {
            newState = newState.setValue(SECTION,newSection);
            Section section = newState.getValue(SECTION);
            int age = newState.getValue(AGE);
            switch (section) {
                case MIDDLE -> {
                    if (age <= 1) {
                        newState = Blocks.AIR.defaultBlockState();
                    }
                }
                case UPPER -> {
                    if (age <= 3) {
                        newState = Blocks.AIR.defaultBlockState();
                    }
                }
            }
        }
        BlockState targetState =  level.getBlockState(targetPos);
        if ((targetState.getBlock() instanceof CornCropBlock) || (level.getBlockState(targetPos).isAir())) {
            level.setBlockAndUpdate(targetPos, newState);
        }
    }

    public void updateAllSegments(BlockState oldState, Level level, BlockPos pos, BlockState newState) {
        Section section = oldState.getValue(SECTION);
        switch (section) {
            case LOWER -> {
                updateCorn(level, pos, 1, newState, Section.MIDDLE);
                updateCorn(level, pos, 2, newState, Section.UPPER);
            }
            case MIDDLE -> {
                updateCorn(level, pos, 1, newState, Section.UPPER);
                updateCorn(level, pos, -1, newState, Section.LOWER);
            }
            case UPPER -> {
                updateCorn(level, pos, -1, newState, Section.MIDDLE);
                updateCorn(level, pos, -2, newState, Section.LOWER);
            }
        };
    }

    public void placeCornAbove(BlockState state, ServerLevel level, BlockPos pos) {
        Section section = state.getValue(SECTION);
        int age = state.getValue(AGE);
        switch (section) {
            case LOWER -> {
                if (age == 1) {
                    updateCorn(level, pos, 1, state, Section.MIDDLE);
                }
            }
            case MIDDLE -> {
                if (age == 3) {
                    updateCorn(level, pos, 1, state, Section.UPPER);
                }
            }
        }
    }

    @Override
    public void onRemove(BlockState oldState, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!oldState.is(newState.getBlock())) {
            updateAllSegments(oldState, level, pos, Blocks.AIR.defaultBlockState());
            super.onRemove(oldState, level, pos, newState, isMoving);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isAreaLoaded(pos, 1)) return;
        if (level.getRawBrightness(pos, 0) >= 9) {
            int age = this.getAge(state);
            float speed = getGrowthSpeed(state, level, pos);
            if (CommonHooks.canCropGrow(level, pos, state, random.nextInt((int) (25.0F / speed) + 1) == 0)) {
                if (age < this.getMaxAge() && canPlaceAbove(state,level,pos,false)) {
                    level.setBlock(pos, state.setValue(getAgeProperty(), age+1), 2);
                    updateAllSegments(state, level, pos, state.setValue(getAgeProperty(), age+1));
                    CommonHooks.fireCropGrowPost(level, pos, state);
                }
            }
        }
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (canPlaceAbove(state,level,pos,true)) {
            this.growCrops(level,pos,state);
        }
    }

    @Override
    public void growCrops(Level level, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(level);
        int j = getMaxAge();
        if (i > j) {
            i = j;
        }
        level.setBlock(pos, state.setValue(getAgeProperty(),i), 2);
        updateAllSegments(state.setValue(getAgeProperty(),i), level, pos, state.setValue(getAgeProperty(),i));
    }

    public enum Section implements StringRepresentable {
        LOWER("lower"),
        MIDDLE("middle"),
        UPPER("upper");

        private final String name;
        Section(String name) {
            this.name = name; }

        @Override
        public String getSerializedName() {
            return this.name; }
        @Override
        public String toString() {
            return this.name; }
    }
}
