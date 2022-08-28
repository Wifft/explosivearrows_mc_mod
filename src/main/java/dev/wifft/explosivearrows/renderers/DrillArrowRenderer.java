package dev.wifft.explosivearrows.renderers;

import dev.wifft.explosivearrows.entities.projectile.DrillArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class DrillArrowRenderer extends ArrowRenderer<DrillArrow>
{
    public DrillArrowRenderer(EntityRendererProvider.Context context)
    {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(DrillArrow entity)
    {
        return new ResourceLocation("explosivearrows:textures/entity/projectiles/drill_arrow.png");
    }
}
