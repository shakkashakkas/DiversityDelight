package com.shakkas.diversitydelight.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.function.Supplier;

public class VegetableSticksBlock extends FeastBlock {

    public VegetableSticksBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
    }

    public static final IntegerProperty STICK_SERVINGS = IntegerProperty.create("servings", 0, 5);

    protected static final VoxelShape PLATE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
    protected static final VoxelShape SERVING_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(2.0D, 2.0D, 2.0D, 14.0D, 8.0D, 14.0D), BooleanOp.OR);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(getServingsProperty()) == 0 ? PLATE_SHAPE : SERVING_SHAPE;
    }

    @Override
    public int getMaxServings() {
        return 5;
    }

    @Override
    public IntegerProperty getServingsProperty() {
        return STICK_SERVINGS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, STICK_SERVINGS);
    }
}
