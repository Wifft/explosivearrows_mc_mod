package dev.wifft.explosivearrows.entities.projectile;

import dev.wifft.explosivearrows.registries.ModEntityTypeRegistry;
import dev.wifft.explosivearrows.registries.ModItemRegistry;

import net.minecraft.network.protocol.Packet;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.entity.projectile.AbstractArrow;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

import net.minecraftforge.network.NetworkHooks;

public class ExplosiveArrow extends AbstractArrow
{
    protected final Item referenceItem;

    public static final String ENTITY_ID = "explosive_arrow";

    public ExplosiveArrow(EntityType<? extends AbstractArrow> type, Level level)
    {
        super(type, level);

        this.referenceItem = ModItemRegistry.EXPLOSIVE_ARROW.get();
    }

    public ExplosiveArrow(LivingEntity shooter, Level level, Item referenceItem)
    {
        super(ModEntityTypeRegistry.EXPLOSIVE_ARROW.get(), shooter, level);
        
        this.referenceItem = referenceItem;
    }

    @Override
    public ItemStack getPickupItem()
    {
        return new ItemStack(this.referenceItem);
    }

    @Override
    protected void tickDespawn()
    {
        float explosionRange = 4.0f;

        this.getLevel().explode(this, this.getX(), this.getY(), this.getZ(), explosionRange, true, Explosion.BlockInteraction.DESTROY);
                
        this.discard();
    }

    @Override
    public Packet<?> getAddEntityPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    } 
}
