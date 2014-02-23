package no.runsafe.gonefishing.commands;

import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.command.player.PlayerCommand;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.gonefishing.SquidMount;

public class MakeMount extends PlayerCommand
{
	public MakeMount()
	{
		super("mount", "Create a fishing mount", "runsafe.fishing.mount");
	}

	@Override
	public String OnExecute(IPlayer executor, IArgumentList parameters)
	{
		new SquidMount(executor.getWorld(), executor);
		return null;
	}
}
