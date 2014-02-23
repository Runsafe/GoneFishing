package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class DilapidatedBumTickler implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Combat.Sword.Wood.getItem();
			item.setDurability((short) 70);
			item.setDisplayName("Dilapidated Bum Tickler");
			item.addLore("&8This has definitely seen better days.");
			item.setAmount(1);
		}
		return item;
	}

	private RunsafeMeta item;
}
