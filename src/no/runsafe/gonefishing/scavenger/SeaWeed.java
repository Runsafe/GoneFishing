package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class SeaWeed implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Decoration.Vine.getItem();
			item.setAmount(1);
			item.setDisplayName("§aWashed-up Seaweed");
			item.addLore("§7Eww this feels slimy.");
		}
		return item;
	}

	private RunsafeMeta item;
}
