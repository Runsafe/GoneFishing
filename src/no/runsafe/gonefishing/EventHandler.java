package no.runsafe.gonefishing;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

import java.util.concurrent.ConcurrentHashMap;

public class EventHandler
{
	public EventHandler(IScheduler scheduler, EventConfig config, IServer server, MountHandler mountHandler)
	{
		this.scheduler = scheduler;
		this.config = config;
		this.server = server;
		this.mountHandler = mountHandler;
	}

	public void setupEvent()
	{
		step = config.getStepCount();
		final int stepLength = config.getStepLength();
		timer = scheduler.startSyncRepeatingTask(new Runnable()
		{
			@Override
			public void run()
			{
				// Check what step we're at.
				if (step == 0)
				{
					// We are at zero step, start the event.
					hasStarted = true; // Flag the event as started.
					server.broadcastMessage(config.getStartedMessage()); // Broadcast started message.
					startEvent(); // Start the event.
				}
				else
				{
					// We're still timing down, broadcast the next countdown message.
					server.broadcastMessage(config.getStartingMessage().replaceAll("<time>", "" + (stepLength * step) / 60));
					step--; // Fall down to the next step.
				}
			}
		}, 0, config.getStepLength());
		isRunning = true; // Flag as running.
	}

	private void startEvent()
	{
		scheduler.cancelTask(timer);
		timer = scheduler.startAsyncTask(new Runnable()
		{
			@Override
			public void run()
			{
				concludeEvent(null);
			}
		}, config.getEventLength());
	}

	private void concludeEvent(IPlayer winner)
	{
		if (winner == null)
		{
			// We have no winner, conclude without a winner.
			server.broadcastMessage(config.getConcludeNoWinnerMessage());
		}
		else
		{
			// We have a winner! Woooo!
			server.broadcastMessage(config.getConcludeMessage().replaceAll("<player>", winner.getPrettyName()));
			new TournamentWinEvent(winner).Fire(); // Fire win event.
			winner.give(mountHandler.getMountItem()); // Give the winner a squid mount.

			RunsafeMeta loot = Item.Materials.Emerald.getItem();
			loot.setAmount(10);
			winner.give(loot);
			
			loot = Item.Tool.FishingRod.getItem();
			loot.setAmount(1);
			winner.give(loot);
			
		}
		progress.clear(); // Clear all progress.
		stopEvent(); // Stop the event.
	}

	public void stopEvent()
	{
		hasStarted = false; // Flag as no longer started.
		isRunning = false; // Flag as no longer running.
		scheduler.cancelTask(timer); // Cancel any timer we have running.
	}

	public boolean isRunning()
	{
		return isRunning;
	}

	public boolean hasStarted()
	{
		return isRunning && hasStarted;
	}

	public void registerCatch(IPlayer player)
	{
		String playerName = player.getName();
		int newProgress = progress.containsKey(playerName) ? progress.get(playerName) + 1 : 1;
		if (newProgress == config.getFishToWin())
			concludeEvent(player);
		else
			progress.put(playerName, newProgress);
	}

	private int step;
	private boolean isRunning;
	private boolean hasStarted;
	private int timer;
	private final IScheduler scheduler;
	private final EventConfig config;
	private final IServer server;
	private final ConcurrentHashMap<String, Integer> progress = new ConcurrentHashMap<String, Integer>(0);
	private final MountHandler mountHandler;
}
