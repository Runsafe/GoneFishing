package no.runsafe.gonefishing;

import net.minecraft.server.v1_7_R1.EntityPlayer;
import net.minecraft.server.v1_7_R1.EntitySquid;
import net.minecraft.server.v1_7_R1.World;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import org.bukkit.util.Vector;

public class SquidMount extends EntitySquid
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

	@Override
	protected void dropDeathLoot(boolean flag, int i)
	{
		// Do nothing, we don't want loot.
	}

	@Override
	public void e()
	{
		ILocation playerLocation = player.getLocation();
		if (player.isDead() || !player.isOnline() || passenger == null || playerLocation == null || !passenger.getName().equals(player.getName()))
		{
			setHealth(0); // Kill the squid.
			return;
		}

		Vector direction = playerLocation.getDirection();
		this.motX = direction.getX();
		this.motY = direction.getY();
		this.motZ = direction.getZ();
	}

	private final IPlayer player;
}
