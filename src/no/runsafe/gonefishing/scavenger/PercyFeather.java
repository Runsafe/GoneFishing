package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class PercyFeather implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Materials.FEATHER.getItem();
			item.setAmount(1);
			item.setDisplayName("§aPercy the Parrot's Feather");
			item.addLore("§7The only remains from Percy.");
		}
		return item;
	}

	private RunsafeMeta item;
}
