package no.runsafe.gonefishing;

import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.event.plugin.IConfigurationChanged;

public class EventConfig implements IConfigurationChanged
{
	public int getStepCount()
	{
		return stepCount;
	}

	public int getStepLength()
	{
		return stepLength;
	}

	public String getStartingMessage()
	{
		return startingMessage;
	}

	public String getStartedMessage()
	{
		return startedMessage;
	}

	public int getEventLength()
	{
		return eventLength;
	}

	public String getConcludeMessage()
	{
		return concludeMessage;
	}

	public String getConcludeNoWinnerMessage()
	{
		return concludeNoWinnerMessage;
	}

	public int getFishToWin()
	{
		return fishToWin;
	}

	@Override
	public void OnConfigurationChanged(IConfiguration config)
	{
		stepCount = config.getConfigValueAsInt("stepCount");
		stepLength = config.getConfigValueAsInt("stepLength");
		startingMessage = config.getConfigValueAsString("startingMessage");
		startedMessage = config.getConfigValueAsString("startedMessage");
		eventLength = config.getConfigValueAsInt("eventLength");
		concludeMessage = config.getConfigValueAsString("concludeMessage");
		concludeNoWinnerMessage = config.getConfigValueAsString("concludeNoWinnerMessage");
		fishToWin = config.getConfigValueAsInt("fishToWin");
	}

	private int stepCount;
	private int stepLength;
	private String startingMessage;
	private String startedMessage;
	private int eventLength;
	private String concludeMessage;
	private String concludeNoWinnerMessage;
	private int fishToWin;
}
