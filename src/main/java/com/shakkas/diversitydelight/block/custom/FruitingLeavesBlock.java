package com.shakkas.diversitydelight.block.custom;

import com.shakkas.diversitydelight.block.entity.FruitingLeavesBlockEntity;
import com.shakkas.diversitydelight.component.FruitTreeGeneticsProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.CommonHooks;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class FruitingLeavesBlock extends LeavesBlock implements BonemealableBlock, EntityBlock {
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private final Supplier<Item> cropDrop;
    private final Supplier<FruitTreeGeneticsProperties> treeGenetics;

    public FruitingLeavesBlock(Properties properties, Supplier<Item> cropDrop, Supplier<FruitTreeGeneticsProperties> treeGenetics) {
        super(properties);
        this.cropDrop = cropDrop;
        this.treeGenetics = treeGenetics;
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return (getAge(state) < MAX_AGE);
    }

    protected boolean beeCanPollinate(BlockState state) {
        return (getAge(state) <= 1);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.isAreaLoaded(pos, 1)) {
            if (level.getRawBrightness(pos, 0) >= 9) {
                int age = this.getAge(state);
                int growthChance = 20;
                if (age < this.getMaxAge()) {
                    if (CommonHooks.canCropGrow(level, pos, state, (random.nextInt(growthChance) == 0))) {
                        level.setBlock(pos, state.setValue(AGE,age+1), 2);
                        CommonHooks.fireCropGrowPost(level, pos, state);
                    }
                }
            }
        }
    }

    protected Item getCropDrop() {
        return cropDrop.get();
    }

    public int getMaxAge() {
        return MAX_AGE;
    }

    public int getAge(BlockState state) {
        return state.getValue(AGE);
    }

    public BlockState getStateForAge(int age) {
        return this.defaultBlockState().setValue(AGE, age);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return !(getAge(state) >= MAX_AGE);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int growthBonus = Mth.nextInt(level.random, 1, 2);
        int newAge = getAge(state) + growthBonus;
        if (newAge > MAX_AGE) {
            newAge = MAX_AGE;
        }
        level.setBlock(pos, state.setValue(AGE, newAge), 2);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        int age = getAge(state);
        if (age==MAX_AGE) {
            int quantity = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(getCropDrop(), quantity));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, state.setValue(AGE, 0), 2);
            if(level.getBlockEntity(pos) instanceof FruitingLeavesBlockEntity fruitingLeavesBlockEntity) {
                fruitingLeavesBlockEntity.resetPollination();
            }
            return InteractionResult.SUCCESS;
        } else {
            return super.useWithoutItem(state, level, pos, player, hit);
        }
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()) {
            if(level.getBlockEntity(pos) instanceof FruitingLeavesBlockEntity fruitingLeavesBlockEntity) {
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        super.onPlace(state, level, pos, oldState, movedByPiston);
        if (!level.isClientSide && oldState.getBlock() != state.getBlock()) {
            if(level.getBlockEntity(pos) instanceof FruitingLeavesBlockEntity fruitingLeavesBlockEntity) {
                FruitTreeGeneticsProperties genetics = treeGenetics.get();
                fruitingLeavesBlockEntity.freshGenetics(genetics);
            }
        }
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(AGE);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new FruitingLeavesBlockEntity(blockPos, blockState);
    }

}
