package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.api.event.player.IPlayerFishEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.entity.RunsafeItem;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerFishEvent;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.gonefishing.EventHandler;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LootHandler implements IPlayerFishEvent
{
	public LootHandler(IFishingLootItem[] lootItems, LootConfig config, EventHandler handler)
	{
		this.config = config;
		this.handler = handler;
		items = Arrays.asList(lootItems);
	}

	@Override
	public void OnPlayerFish(RunsafePlayerFishEvent event)
	{
		if (event.getCaught() == null)
			return;

		IPlayer player = event.getPlayer();
		int ran = random.nextInt(100);
		if (ran < config.getDropChance())
		{
			((RunsafeItem) event.getCaught()).setItemStack(items.get(random.nextInt(items.size())).getItem());
			new SpecialLootEvent(player).Fire(); // Fire an event!
		}
		else if (config.getEventWorld().isWorld(player.getWorld()) && handler.hasStarted() && ran < config.getEventDropChance())
		{
			((RunsafeItem) event.getCaught()).setItemStack(getEventFish());
			handler.registerCatch(player);
		}
	}

	private RunsafeMeta getEventFish()
	{
		if (eventFish == null)
		{
			eventFish = Item.Food.Meat.Fish.Clownfish.getItem();
			eventFish.setDisplayName("Tastyfish");
			eventFish.addLore("&8Just looking at it makes you drool!");
			eventFish.setAmount(1);
		}
		return eventFish;
	}

	private final LootConfig config;
	private final List<IFishingLootItem> items;
	private final Random random = new Random();
	private final EventHandler handler;
	private RunsafeMeta eventFish;
}
