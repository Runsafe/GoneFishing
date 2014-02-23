package no.runsafe.gonefishing.commands;

import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.gonefishing.EventHandler;

public class StopEvent extends ExecutableCommand
{
	public StopEvent(EventHandler handler)
	{
		super("stop", "Stop the current running event", "runsafe.fishing.stop");
		this.handler = handler;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, IArgumentList parameters)
	{
		// Make sure we actually have an event running.
		if (!handler.isRunning())
			return "&cNo event is running.";

		handler.stopEvent(); // Stop the event.
		return "&eEvent stopped.";
	}

	private final EventHandler handler;
}
