package dev.wifft.explosivearrows.calculators;

import java.util.function.Predicate;

import net.minecraft.core.BlockPos;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;

import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.Tags;

public class OreExplosionDamageCalculator extends ExplosionDamageCalculator {    
    @Override
    public boolean shouldBlockExplode(Explosion explosion, BlockGetter block, BlockPos pos, BlockState blockState, float range) {
        return !isOre(blockState);
    }

    public static boolean isOre(BlockState blockState)
    {
        return blockState.getTags().anyMatch(Predicate.isEqual(Tags.Blocks.ORES));
    }
    
    public static boolean isBedrock(BlockState blockState)
    {
        return blockState.getBlock().getDescriptionId().equals("block.minecraft.bedrock");
    }
}
