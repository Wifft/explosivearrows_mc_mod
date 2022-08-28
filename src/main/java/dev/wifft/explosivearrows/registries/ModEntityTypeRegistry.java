package dev.wifft.explosivearrows.registries;

import dev.wifft.explosivearrows.ExplosiveArrows;
import dev.wifft.explosivearrows.entities.projectile.AtomicArrow;
import dev.wifft.explosivearrows.entities.projectile.DrillArrow;
import dev.wifft.explosivearrows.entities.projectile.ExplosiveArrow;

import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.entity.EntityType;

import net.minecraft.world.entity.MobCategory;

import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypeRegistry
{
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ExplosiveArrows.MOD_ID);

    public static final RegistryObject<EntityType<AtomicArrow>> ATOMIC_ARROW = ENTITY_TYPES.register(
        AtomicArrow.ENTITY_ID,
        () -> EntityType
            .Builder
            .<AtomicArrow>of(AtomicArrow::new, MobCategory.MISC)
            .sized(0.5f, 0.5f)
            .clientTrackingRange(4)
            .updateInterval(20)
            .build(new ResourceLocation(ExplosiveArrows.MOD_ID, AtomicArrow.ENTITY_ID).toString())
    );
    
    public static final RegistryObject<EntityType<DrillArrow>> DRILL_ARROW = ENTITY_TYPES.register(
        DrillArrow.ENTITY_ID,
        () -> EntityType
            .Builder
            .<DrillArrow>of(DrillArrow::new, MobCategory.MISC)
            .sized(0.5f, 0.5f)
            .clientTrackingRange(4)
            .updateInterval(20)
            .build(new ResourceLocation(ExplosiveArrows.MOD_ID, DrillArrow.ENTITY_ID).toString())
    );

    public static final RegistryObject<EntityType<ExplosiveArrow>> EXPLOSIVE_ARROW = ENTITY_TYPES.register(
        ExplosiveArrow.ENTITY_ID,
        () -> EntityType
            .Builder
            .<ExplosiveArrow>of(ExplosiveArrow::new, MobCategory.MISC)
            .sized(0.5f, 0.5f)
            .clientTrackingRange(4)
            .updateInterval(20)
            .build(new ResourceLocation(ExplosiveArrows.MOD_ID, ExplosiveArrow.ENTITY_ID).toString())
    );

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }
}
