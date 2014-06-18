package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class DogBone implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Miscellaneous.Bone.getItem();
			item.setAmount(1);
			item.setDisplayName("§6DOG's Vacation Treat");
			item.addLore("§7Yes, even DOG likes to relax at the beach.");
		}
		return item;
	}

	private RunsafeMeta item;
}
