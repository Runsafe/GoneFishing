package no.runsafe.gonefishing;

import net.minecraft.server.v1_7_R1.*;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;

public class SquidMount extends EntityPig
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
	public void e(float f, float f1)
	{
		ILocation playerLocation = player.getLocation();
		if (player.isDead() || !player.isOnline() || passenger == null || playerLocation == null || !passenger.getName().equals(player.getName()))
		{
			setHealth(0); // Kill the squid.
			return;
		}

		X = 0.5F;
		lastYaw = yaw = passenger.yaw;
		pitch = passenger.pitch * 0.5F;

		b(yaw, pitch);
		aP = aN = yaw;

		f = ((EntityLiving) passenger).be * 0.5f;
		f1 = ((EntityLiving) passenger).bf;

		if (f1 <= 0.0F)
			f1 *= 0.25F;

		f *= 0.75F;
		i(0.35F);
		super.e(f, f1);
	}

	private final IPlayer player;
}
