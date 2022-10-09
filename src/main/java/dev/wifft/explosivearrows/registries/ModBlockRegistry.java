package dev.wifft.explosivearrows.registries;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

import dev.wifft.explosivearrows.ExplosiveArrows;
import dev.wifft.explosivearrows.objects.blocks.DeepslateUranititeOre;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockRegistry
{
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExplosiveArrows.MOD_ID);

    public static final RegistryObject<Block> DEEPSLATE_URANITITE_ORE = BLOCKS.register(
        DeepslateUranititeOre.BLOCK_ID,
        () -> new DeepslateUranititeOre(
            Properties.of(Material.METAL, MaterialColor.DEEPSLATE)
                .sound(SoundType.STONE)
                .strength(3.0f)
                .requiresCorrectToolForDrops()
        )
    );

    public static void register(IEventBus eventbBus)
    {
        BLOCKS.register(eventbBus);
    }
}
