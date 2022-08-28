package dev.wifft.explosivearrows.events;

import dev.wifft.explosivearrows.ExplosiveArrows;

import dev.wifft.explosivearrows.registries.ModEntityTypeRegistry;
import dev.wifft.explosivearrows.renderers.AtomicArrowRenderer;
import dev.wifft.explosivearrows.renderers.DrillArrowRenderer;
import dev.wifft.explosivearrows.renderers.ExplosiveArrowRenderer;

import net.minecraftforge.api.distmarker.Dist;

import net.minecraftforge.client.event.EntityRenderersEvent;

import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExplosiveArrows.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents
{
    @SubscribeEvent
    public static void rendererRegister(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypeRegistry.ATOMIC_ARROW.get(), AtomicArrowRenderer::new);
        event.registerEntityRenderer(ModEntityTypeRegistry.DRILL_ARROW.get(), DrillArrowRenderer::new);
        event.registerEntityRenderer(ModEntityTypeRegistry.EXPLOSIVE_ARROW.get(), ExplosiveArrowRenderer::new);
    }
}
