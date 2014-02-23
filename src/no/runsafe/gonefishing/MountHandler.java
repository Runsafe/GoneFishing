package no.runsafe.gonefishing;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.event.player.IPlayerRightClick;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

import java.util.List;

public class MountHandler implements IPlayerRightClick
{
	public RunsafeMeta getMountItem()
	{
		if (item == null)
		{
			item = Item.Brewing.Potion.getItem();
			item.setDisplayName("Squid in a Bottle");
			item.addLore("§3Right click to summon a squid mount.");
			item.addLore("§7Best used in the water!");
		}
		return item;
	}

	private boolean isMountItem(RunsafeMeta item)
	{
		String displayName = item.getDisplayName();
		if (displayName == null || !displayName.equals("Squid in a Bottle"))
			return false;

		List<String> lore = item.getLore();
		return !(lore == null || lore.isEmpty() || lore.size() < 2) && !(!lore.get(0).equals("§3Right click to summon a squid mount.") || !lore.get(1).equals("§7Best used in the water!"));
	}

	@Override
	public boolean OnPlayerRightClick(IPlayer player, RunsafeMeta usingItem, IBlock targetBlock)
	{
		if (usingItem != null && isMountItem(usingItem))
		{
			new SquidMount(player.getWorld(), player);
			return false;
		}
		return true;
	}

	private RunsafeMeta item;
}
