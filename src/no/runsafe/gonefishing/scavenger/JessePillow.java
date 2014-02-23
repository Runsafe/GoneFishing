package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class JessePillow implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.BuildingBlock.Wool.White.getItem();
			item.setAmount(1);
			item.setDisplayName("Hesse's Soggy Pillow");
			item.addLore("§8It's soggy from being in the water.. you hope.");
		}
		return item;
	}

	private RunsafeMeta item;
}
