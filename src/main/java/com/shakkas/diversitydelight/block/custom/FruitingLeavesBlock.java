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
    private final Supplier<Block> mutatedVariant;
    private final boolean isMutated;

    public FruitingLeavesBlock(Properties properties, Supplier<Item> cropDrop, Supplier<FruitTreeGeneticsProperties> treeGenetics, boolean isMutated) {
        super(properties);
        this.cropDrop = cropDrop;
        this.treeGenetics = treeGenetics;
        this.mutatedVariant = null;
        this.isMutated = isMutated;
    }

    public FruitingLeavesBlock(Properties properties, Supplier<Item> cropDrop, Supplier<FruitTreeGeneticsProperties> treeGenetics, Supplier<Block> mutatedVariant) {
        super(properties);
        this.cropDrop = cropDrop;
        this.treeGenetics = treeGenetics;
        this.mutatedVariant = mutatedVariant;
        this.isMutated = false;
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return ((getAge(state) < MAX_AGE) || (state.getValue(DISTANCE) == 7 && !state.getValue(PERSISTENT)));
    }

    protected boolean beeCanPollinate(BlockState state) {
        return (getAge(state) <= 1);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.isAreaLoaded(pos, 1)) {
            if (level.getRawBrightness(pos, 0) >= 9) {
                int age = this.getAge(state);
                int growthChance = getGrowthChance(level,pos,getGrowthGene(level,pos));
                if (age < this.getMaxAge()) {
                    if (CommonHooks.canCropGrow(level, pos, state, (random.nextInt(growthChance) == 0))) {
                        int newAge = age+1;
                        level.setBlock(pos, state.setValue(AGE,newAge), 2);
                        CommonHooks.fireCropGrowPost(level, pos, state);
                        if (newAge == MAX_AGE) {
                            if (level.getBlockEntity(pos) instanceof FruitingLeavesBlockEntity fruitingLeavesBlockEntity) {
                                fruitingLeavesBlockEntity.setPollinated();
                            }
                        }
                    }
                }
            }
        }
        if (state.getValue(DISTANCE) == 7 && !state.getValue(PERSISTENT)) {
            super.randomTick(state,level,pos,random);
        }
    }

    protected int getYieldGene(Level level, BlockPos pos) {
        if(level.getBlockEntity(pos) instanceof FruitingLeavesBlockEntity fruitingLeavesBlockEntity) {
            return fruitingLeavesBlockEntity.yield;
        }
        return 0;
    }

    protected int getGrowthGene(Level level, BlockPos pos) {
        if(level.getBlockEntity(pos) instanceof FruitingLeavesBlockEntity fruitingLeavesBlockEntity) {
            return fruitingLeavesBlockEntity.growth;
        }
        return 0;
    }

    protected int getMutationGene(Level level, BlockPos pos) {
        if(level.getBlockEntity(pos) instanceof FruitingLeavesBlockEntity fruitingLeavesBlockEntity) {
            return fruitingLeavesBlockEntity.mutation;
        }
        return 0;
    }

    protected int getGrowthChance(ServerLevel level, BlockPos pos, int growthGene) {
        int baseChance = this.treeGenetics.get().baseGrowthChance();
        int skyLightFactor = level.canSeeSky(pos) ? 1 : 0;
        int lightLevelFactor = level.getRawBrightness(pos,0);
        return baseChance/((growthGene+1) + ((lightLevelFactor/5)+1) + skyLightFactor);
    }

    public boolean getPollinationStatus(Level level, BlockPos pos) {
        if(level.getBlockEntity(pos) instanceof FruitingLeavesBlockEntity fruitingLeavesBlockEntity) {
            return fruitingLeavesBlockEntity.isPollinated;
        }
        return false;
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

    public boolean hasMutatedVariant() {
        return (this.mutatedVariant != null);
    }

    public Block getMutatedVariant() {
        return hasMutatedVariant() ? this.mutatedVariant.get() : null;
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
        int growthBonus = Mth.nextInt(level.random, 0, 1);
        int newAge = getAge(state) + growthBonus;
        if (newAge > MAX_AGE) {
            newAge = MAX_AGE;
        }
        level.setBlock(pos, state.setValue(AGE, newAge), 2);
        if (newAge == MAX_AGE) {
            if (level.getBlockEntity(pos) instanceof FruitingLeavesBlockEntity fruitingLeavesBlockEntity) {
                fruitingLeavesBlockEntity.setPollinated();
            }
        }
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        int age = getAge(state);
        if (age==MAX_AGE) {
            int quantity = 1 + level.random.nextInt(getYieldBonus(getYieldGene(level,pos)));
            popResource(level, pos, new ItemStack(getCropDrop(), quantity));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, state.setValue(AGE, 0), 2);
            if (level.getBlockEntity(pos) instanceof FruitingLeavesBlockEntity fruitingLeavesBlockEntity) {
                fruitingLeavesBlockEntity.resetPollination();
            }
            return InteractionResult.SUCCESS;
        } else {
            return super.useWithoutItem(state, level, pos, player, hit);
        }
    }

    protected int getYieldBonus(int yieldGene) {
        int baseBonus = 2;
        return baseBonus + (yieldGene/3);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        super.onPlace(state, level, pos, oldState, movedByPiston);
        if (!level.isClientSide) {
            if (oldState.getBlock() != state.getBlock()) {
                if (level.getBlockEntity(pos) instanceof FruitingLeavesBlockEntity fruitingLeavesBlockEntity) {
                    FruitTreeGeneticsProperties genetics = treeGenetics.get();
                    fruitingLeavesBlockEntity.freshGenetics(genetics);
                }
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
