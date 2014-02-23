package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class RbartelWeed implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Decoration.LongGrass.getItem();
			item.setDisplayName("Rbartel's Lost Weed");
			item.addLore("With added seaweed flavour!");
			item.setAmount(1);
		}
		return item;
	}

	private RunsafeMeta item;
}
