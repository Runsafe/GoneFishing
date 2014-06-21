package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class BoatDebris implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Unavailable.DoubleSlab.Plank.getItem();
			item.setAmount(1);
			item.setDisplayName("§6Piece of Flint's Ship Debris");
			item.addLore("§7This looks dangerous.");
		}
		return item;
	}

	private RunsafeMeta item;
}
