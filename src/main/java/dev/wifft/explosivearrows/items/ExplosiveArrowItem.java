package dev.wifft.explosivearrows.items;

import dev.wifft.explosivearrows.entities.projectile.ExplosiveArrow;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;

import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

import net.minecraft.world.level.Level;

public class ExplosiveArrowItem extends ArrowItem
{
    public static final String ITEM_ID = "explosive_arrow";

    public final float damage;

    public ExplosiveArrowItem(Properties properties, float damage)
    {
        super(properties);

        this.damage = damage;
    }
    
    @Override
    public AbstractArrow createArrow(Level level, ItemStack stack, LivingEntity entity)
    {
        ExplosiveArrow arrow = new ExplosiveArrow(entity, level, this);
        arrow.setBaseDamage(this.damage);

        return arrow;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, Player player)
    {
        int enchantmentLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.INFINITY_ARROWS, bow);

        return enchantmentLevel > 0 
            ? this instanceof ExplosiveArrowItem
            : false; 
    }
}
