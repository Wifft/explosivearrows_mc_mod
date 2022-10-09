package dev.wifft.explosivearrows.objects.blocks;

import net.minecraft.core.BlockPos;

import net.minecraft.world.level.LevelAccessor;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class DeepslateUranititeOre extends Block
{
    public static final String BLOCK_ID = "deepslate_uranitite_ore";
    
    public DeepslateUranititeOre(Properties properties)
    {
        super(properties);
    }

    @Override
    public void destroy(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState)
    {
        super.destroy(levelAccessor, blockPos, blockState);
    }
}
