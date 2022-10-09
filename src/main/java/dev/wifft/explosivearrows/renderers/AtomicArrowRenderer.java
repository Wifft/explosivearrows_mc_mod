package dev.wifft.explosivearrows.renderers;

import dev.wifft.explosivearrows.objects.entities.projectiles.AtomicArrow;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.minecraft.resources.ResourceLocation;

public class AtomicArrowRenderer extends ArrowRenderer<AtomicArrow>
{
    public AtomicArrowRenderer(EntityRendererProvider.Context context)
    {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(AtomicArrow p_114482_) {
        return new ResourceLocation("explosivearrows:textures/entity/projectiles/atomic_arrow.png");
    }
}
