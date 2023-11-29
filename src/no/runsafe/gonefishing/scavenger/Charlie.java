package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class Charlie implements IFishingLootItem
{
    @Override
    public RunsafeMeta getItem()
    {
        if (item == null)
        {
            item = Item.Minecraft.Rabbit_Hide.getItem();
            item.setAmount(1);
            item.setDisplayName("§aCharlies Hide");
            item.addLore("§7Gone but never forgotten.");
        }
        return item;
    }

    private RunsafeMeta item;
}