package dev.wifft.explosivearrows.entities.projectile;

import dev.wifft.explosivearrows.calculators.OreExplosionDamageCalculator;
import dev.wifft.explosivearrows.registries.ModEntityTypeRegistry;
import dev.wifft.explosivearrows.registries.ModItemRegistry;

import net.minecraft.core.BlockPos;

import net.minecraft.network.protocol.Packet;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.entity.projectile.AbstractArrow;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.material.EmptyFluid;
import net.minecraft.world.level.material.Fluid;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import net.minecraftforge.network.NetworkHooks;

public class DrillArrow extends AbstractArrow
{
    private final Item referenceItem;

    public static final String ENTITY_ID = "drill_arrow";

    public DrillArrow(EntityType<? extends AbstractArrow> type, Level level)
    {
        super(type, level);

        this.referenceItem = ModItemRegistry.DRILL_ARROW.get();
    }

    public DrillArrow(LivingEntity shooter, Level level, Item referenceItem)
    {
        super(ModEntityTypeRegistry.DRILL_ARROW.get(), shooter, level);
        
        this.referenceItem = referenceItem;
    }

    @Override
    public ItemStack getPickupItem()
    {
        return new ItemStack(this.referenceItem);
    }

    @Override
    protected void onHit(HitResult result)
    {
        super.onHit(result);

        Fluid hittingFluid = this.getLevel().getFluidState(new BlockPos(this.position())).getType();

        if (!(hittingFluid instanceof EmptyFluid)) this.discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
       
        BlockState blockState = this.getLevel().getBlockState(result.getBlockPos());

        if (OreExplosionDamageCalculator.isOre(blockState)) this.discard();
    }

    @Override
    protected void tickDespawn()
    {
        float explosionRange = 16.0f;
        OreExplosionDamageCalculator damageCalculator = new OreExplosionDamageCalculator();

        this.getLevel()
            .explode(
                this,
                null,
                damageCalculator,
                this.getX(),
                this.getY(),
                this.getZ(),
                explosionRange,
                false,
                Explosion.BlockInteraction.DESTROY
            )
            .clearToBlow();

        if (this.getY() <= -48) this.discard();
    }

    @Override
    public Packet<?> getAddEntityPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
