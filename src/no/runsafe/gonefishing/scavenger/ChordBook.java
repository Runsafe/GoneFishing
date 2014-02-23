package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class ChordBook implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Special.Crafted.EnchantedBook.getItem();
			item.setDisplayName("Mysterious Chord Book");
			item.addLore("Its My Life - Bon Jovi");
			item.setAmount(1);
		}
		return item;
	}

	private RunsafeMeta item;
}
