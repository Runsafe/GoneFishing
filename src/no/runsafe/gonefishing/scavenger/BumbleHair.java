package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class BumbleHair implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Materials.String.getItem();
			item.setDisplayName("Bleached Strand of Bumble's Belly Hair");
			item.addLore("&8This has been underwater for far too long.");
			item.setAmount(1);
		}
		return item;
	}

	private RunsafeMeta item;
}
