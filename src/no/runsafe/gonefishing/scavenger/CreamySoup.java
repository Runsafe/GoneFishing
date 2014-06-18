package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class CreamySoup implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Food.Cooked.MushroomSoup.getItem();
			item.setAmount(1);
			item.setDisplayName("§6Creamy's Nasty Outdated Soup");
			item.addLore("§7You look down to see something moving in the soup.");
		}
		return item;
	}

	private RunsafeMeta item;
}
