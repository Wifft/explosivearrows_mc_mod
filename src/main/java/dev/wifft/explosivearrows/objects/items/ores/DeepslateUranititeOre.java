package dev.wifft.explosivearrows.objects.items.ores;

import dev.wifft.explosivearrows.registries.ModBlockRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class DeepslateUranititeOre extends BlockItem
{
    public static final String ITEM_ID = "deepslate_uranitite_ore";

    public DeepslateUranititeOre(Item.Properties properties)
    {
        super(ModBlockRegistry.DEEPSLATE_URANITITE_ORE.get(), properties);
    }
}
