package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class FlintBoardingPass implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Miscellaneous.Paper.getItem();
			item.setAmount(1);
			item.setDisplayName("§cCaptain Flint's Boarding Pass");
			item.addLore("§3Use this pass to get onto Flint's Pirate Ship.");
		}
		return item;
	}

	private RunsafeMeta item;
}
