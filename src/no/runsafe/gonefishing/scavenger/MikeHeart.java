package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class MikeHeart implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Materials.CharCoal.getItem();
			item.setAmount(1);
			item.setDisplayName("MkX13's Heart");
			item.addLore("§8Rock-hard, cold and smells like fish.");
		}
		return null;
	}

	private RunsafeMeta item;
}