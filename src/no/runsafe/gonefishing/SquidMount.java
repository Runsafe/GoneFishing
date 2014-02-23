package no.runsafe.gonefishing;

import net.minecraft.server.v1_7_R1.*;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;

public class SquidMount extends EntityBoat
{
	public SquidMount(IWorld world, IPlayer mounter)
	{
		super(ObjectUnwrapper.getMinecraft(world));
		World rawWorld = ObjectUnwrapper.getMinecraft(world);
		EntityPlayer player = ObjectUnwrapper.getMinecraft(mounter);
		ILocation mounterLocation = mounter.getLocation();
		this.player = mounter;

		if (rawWorld != null && mounterLocation != null && player != null)
		{
			setPosition(mounterLocation.getX(), mounterLocation.getY(), mounterLocation.getZ());
			rawWorld.addEntity(this);
			player.setPassengerOf(this);
		}
	}

	private final IPlayer player;
}
