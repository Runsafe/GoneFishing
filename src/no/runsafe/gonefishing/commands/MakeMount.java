package no.runsafe.gonefishing.commands;

import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.command.player.PlayerCommand;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.gonefishing.MountHandler;

public class MakeMount extends PlayerCommand
{
	public MakeMount(MountHandler handler)
	{
		super("mount", "Create a fishing mount", "runsafe.fishing.mount");
		this.handler = handler;
	}

	@Override
	public String OnExecute(IPlayer executor, IArgumentList parameters)
	{
		executor.give(handler.getMountItem());
		return null;
	}

	private final MountHandler handler;
}
