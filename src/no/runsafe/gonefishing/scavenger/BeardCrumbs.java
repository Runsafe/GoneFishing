package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class BeardCrumbs implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Materials.Cocoa.getItem();
			item.setAmount(1);
			item.setDisplayName("§cSoggy Beard Crumbs");
			item.addLore("§7What is this strange looking thing?");
		}
		return item;
	}

	private RunsafeMeta item;
}
