package dev.wifft.explosivearrows;

import dev.wifft.explosivearrows.events.ClientModEvents;
import dev.wifft.explosivearrows.events.ServerModEvents;

import dev.wifft.explosivearrows.registries.ModBlockRegistry;
import dev.wifft.explosivearrows.registries.ModEntityTypeRegistry;
import dev.wifft.explosivearrows.registries.ModItemRegistry;

import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ExplosiveArrows.MOD_ID)
public class ExplosiveArrows
{
    public static final String MOD_ID = "explosivearrows";

    public ExplosiveArrows()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlockRegistry.register(modEventBus);
        ModEntityTypeRegistry.register(modEventBus);
        ModItemRegistry.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(ClientModEvents.class);
        MinecraftForge.EVENT_BUS.register(ServerModEvents.class);
    }
}
