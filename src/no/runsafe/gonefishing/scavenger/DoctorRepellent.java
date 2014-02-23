package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class DoctorRepellent implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Food.Plant.Apple.getItem();
			item.setAmount(1);
			item.setDisplayName("Mddoctor Repellent");
			item.addLore("§8Disgusting, smelly and covered in gunk.");
		}
		return item;
	}

	private RunsafeMeta item;
}
