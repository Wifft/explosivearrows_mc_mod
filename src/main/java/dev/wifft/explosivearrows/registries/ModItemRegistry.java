package dev.wifft.explosivearrows.registries;

import dev.wifft.explosivearrows.ExplosiveArrows;

import dev.wifft.explosivearrows.objects.items.ores.DeepslateUranititeOre;
import dev.wifft.explosivearrows.objects.items.projectiles.AtomicArrowItem;
import dev.wifft.explosivearrows.objects.items.projectiles.DrillArrowItem;
import dev.wifft.explosivearrows.objects.items.projectiles.ExplosiveArrowItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemRegistry
{
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExplosiveArrows.MOD_ID);

    public static final RegistryObject<Item> ATOMIC_ARROW = ITEMS.register(
        AtomicArrowItem.ITEM_ID,
        () -> new AtomicArrowItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), 1.5f)
    );
    
    public static final RegistryObject<Item> DRILL_ARROW = ITEMS.register(
        DrillArrowItem.ITEM_ID,
        () -> new DrillArrowItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), 1.5f)
    );
    
    public static final RegistryObject<Item> EXPLOSIVE_ARROW = ITEMS.register(
        ExplosiveArrowItem.ITEM_ID,
        () -> new ExplosiveArrowItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), 1.5f)
    );
    
    public static final RegistryObject<Item> DEEPSLATE_URANITITE_ORE = ITEMS.register(
        DeepslateUranititeOre.ITEM_ID,
        () -> new DeepslateUranititeOre(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS))
    );
    
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
