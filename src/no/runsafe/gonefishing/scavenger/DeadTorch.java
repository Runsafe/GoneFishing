package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class DeadTorch implements IFishingLootItem
{
	@Override
	public RunsafeMeta getItem()
	{
		if (item == null)
		{
			item = Item.Decoration.Torch.getItem();
			item.setAmount(1);
			item.setDisplayName("§cBurned out Torch");
			item.addLore("§7The water put this torch out, looks like it won't light.");
		}
		return item;
	}

	private RunsafeMeta item;
}
