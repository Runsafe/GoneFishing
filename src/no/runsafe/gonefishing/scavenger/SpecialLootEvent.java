package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class SpecialLootEvent extends RunsafeCustomEvent
{
	public SpecialLootEvent(IPlayer player)
	{
		super(player, "fishing.special.loot");
	}

	@Override
	public Object getData()
	{
		return null;
	}
}
