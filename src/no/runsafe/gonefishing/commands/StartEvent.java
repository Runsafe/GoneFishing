package no.runsafe.gonefishing.commands;

import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.gonefishing.EventHandler;

public class StartEvent extends ExecutableCommand
{
	public StartEvent(EventHandler handler)
	{
		super("start", "Start the fishing event", "runsafe.fishing.start");
		this.handler = handler;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, IArgumentList parameters)
	{
		// Check we don't have an event already running.
		if (handler.isRunning())
			return "&cThe event is already running";

		handler.setupEvent(); // Start the event
		return "&eEvent started.";
	}

	private final EventHandler handler;
}
