package no.runsafe.gonefishing;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class TournamentWinEvent extends RunsafeCustomEvent
{
	public TournamentWinEvent(IPlayer player)
	{
		super(player, "fishing.tournament.win");
	}

	@Override
	public Object getData()
	{
		return null;
	}
}
