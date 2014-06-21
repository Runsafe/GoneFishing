package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class FriendshipBracelets implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Miscellaneous.Leash.getItem();
			item.setAmount(2);
			item.setDisplayName("§bTattered Friendship Bracelet");
			item.addLore("§7One of a set of friendship bracelets found deep in the ocean.");
			item.addLore("§dShare one with a friend! <3");
		}
		return item;
	}

	private RunsafeMeta item;
}
