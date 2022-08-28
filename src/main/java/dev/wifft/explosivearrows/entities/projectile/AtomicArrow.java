package dev.wifft.explosivearrows.entities.projectile;

import dev.wifft.explosivearrows.registries.ModItemRegistry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.item.Item;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;

public class AtomicArrow extends ExplosiveArrow
{
    public static final String ENTITY_ID = "atomic_arrow";

    protected final Item referenceItem;

    public AtomicArrow(EntityType<? extends ExplosiveArrow> type, Level level)
    {
        super(type, level);

        this.referenceItem = ModItemRegistry.ATOMIC_ARROW.get();
    }

    public AtomicArrow(LivingEntity shooter, Level level, Item referenceItem)
    {
        super(shooter, level, referenceItem);
        
        this.referenceItem = referenceItem;
    }

    @Override
    protected void tickDespawn()
    {
        float explosionRange = 128.0f;

        this.getLevel().explode(this, this.getX(), this.getY(), this.getZ(), explosionRange, true, Explosion.BlockInteraction.DESTROY);
                
        this.discard();
    }
}