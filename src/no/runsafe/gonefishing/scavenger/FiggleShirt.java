package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.minecraft.item.meta.RunsafeLeatherArmor;

public class FiggleShirt implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Combat.Chestplate.Leather.getItem();
			item.setAmount(1);
			item.setDisplayName("§aLieutenant Figgle's Dirty Shirt");
			item.addLore("§7This must have washed ashore after the crash.");
			RunsafeLeatherArmor armor = (RunsafeLeatherArmor) item;
			armor.setColor(Integer.valueOf("DDFF00", 16));
		}
		return item;
	}

	private RunsafeMeta item;
}
