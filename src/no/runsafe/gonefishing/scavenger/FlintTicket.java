package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class FlintTicket implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Miscellaneous.Paper.getItem();
			item.setAmount(1);
			item.setDisplayName("§6Flint Tickets");
			item.addLore("§7Official currency!");
			item.addLore("§cOfficial Currency at Captain Flint's Reef");
		}
		return item;
	}

	private RunsafeMeta item;
}
