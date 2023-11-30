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
            item = Item.Materials.RabbitHide.getItem();
            item.setAmount(1);
            item.setDisplayName("§aCharles Hide");
            item.addLore("§7Gone but never forgotten.");
        }
        return item;
    }

    private RunsafeMeta item;
}
