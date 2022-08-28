package dev.wifft.explosivearrows.renderers;

import dev.wifft.explosivearrows.entities.projectile.ExplosiveArrow;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.minecraft.resources.ResourceLocation;

public class ExplosiveArrowRenderer extends ArrowRenderer<ExplosiveArrow>
{
    public ExplosiveArrowRenderer(EntityRendererProvider.Context context)
    {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(ExplosiveArrow entity) {
        return new ResourceLocation("explosivearrows:textures/entity/projectiles/explosive_arrow.png");
    }
}
