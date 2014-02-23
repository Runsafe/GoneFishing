package no.runsafe.gonefishing.scavenger;

import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.event.plugin.IConfigurationChanged;

public class LootConfig implements IConfigurationChanged
{
	public int getDropChance()
	{
		return dropChance;
	}

	public int getEventDropChance()
	{
		return eventDropChance;
	}

	public IWorld getEventWorld()
	{
		return eventWorld;
	}

	@Override
	public void OnConfigurationChanged(IConfiguration config)
	{
		dropChance = config.getConfigValueAsInt("lootDropChance");
		eventDropChance = config.getConfigValueAsInt("eventDropChance");
		eventWorld = config.getConfigValueAsWorld("eventWorld");
	}

	private int dropChance;
	private int eventDropChance;
	private IWorld eventWorld;
}
