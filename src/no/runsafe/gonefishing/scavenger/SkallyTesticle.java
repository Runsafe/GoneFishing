package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class SkallyTesticle implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Miscellaneous.Slimeball.getItem();
			item.setDisplayName("Skalamandar's Left Testicle");
			item.addLore("§8Rather sticky and seems to bounce..");
			item.setAmount(1);
		}
		return item;
	}

	private RunsafeMeta item;
}
