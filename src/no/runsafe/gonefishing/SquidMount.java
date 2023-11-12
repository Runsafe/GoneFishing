package no.runsafe.gonefishing;

import net.minecraft.server.v1_7_R3.*;
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

	/**
	 * Damage the entity.
	 * Overrides method in EntityLiving.class
	 * Names of this function in various spigot versions:
	 * v1_7: d
	 * v1_12_R1: damageEntity0
	 * @param source damage source
	 * @param damageValue Amount of damage
	 * @return 1.12: boolean, True if damaged, false if not damaged.
	 */
	@Override
	protected void d(DamageSource source, float damageValue)
	{
		if (passenger != null && f < getHealth())
			passenger.damageEntity(DamageSource.GENERIC, f - getHealth());
	}

	@Override
	protected void dropDeathLoot(boolean flag, int i)
	{
		// Do nothing, we don't want loot.
	}

	@Override
	protected Item getLoot()
	{
		return null; // No, loot is bad.
	}

	/**
	 * Update method.
	 * Names of this function in various spigot versions:
	 * v1_7_R3: e
	 * v1_12_R1: n
	 * -
	 * obfuscated things used:
	 * isInWater:
	 * v1_7_R3: M()
	 * v1_12_R1: aq()
	 */
	@Override
	public void e()
	{
		ILocation playerLocation = player.getLocation();
		if (player.isDead() || !player.isOnline() || passenger == null || playerLocation == null || !passenger.getName().equals(player.getName()))
		{
			setHealth(0); // Kill the squid.
			return;
		}

		int i = getAirTicks();

		if (isAlive() && !M())
		{
			--i;
			setAirTicks(i);
			if (getAirTicks() == -20)
			{
				setAirTicks(0);
				damageEntity(DamageSource.DROWN, 2.0F);
			}
		}
		else
		{
			setAirTicks(300);
		}
		super.e();
	}

	/**
	 * Overrides method in EntityLiving.class
	 * Names of this function in various spigot versions:
	 * v1_7: e(float f, float f1)
	 * v1.12: a(float f, float f1, float f2)
	 * -
	 * Obfuscated stuff:
	 * v1_7: W
	 * v1_12: P
	 * -
	 * v1_7: b(yaw, pitch)
	 * v1_12: setYawPitch(yaw, pitch)
	 * -
	 * v1_7: ap
	 * v1_12: aQ
	 * -
	 * v1_7: aN
	 * v1_12: aO
	 * -
	 * v1_7: .be
	 * v1_12: .bg
	 */
	@Override
	public void e(float f, float f1)
	{
		W = 1F;
		lastYaw = yaw = passenger.yaw;
		pitch = passenger.pitch * 0.5F;

		b(yaw, pitch);
		aP = aN = yaw;

		f = ((EntityLiving) passenger).be * 0.5f;
		//f1 = ((EntityLiving) passenger).bf;

		//if (f1 <= 0.0F)
		// f1 *= 0.25F;

		f *= 0.75F;
		i(0F);
		super.e(f, f1);
	}

	/**
	 * Gets a sound.
	 * @return sound to make
	 */
	@Override
	protected String t()
	{
		return null;
	}

	/**
	 * Gets a sound.
	 * @return sound to make
	 */
	@Override
	protected String aT()
	{
		return null;
	}

	/**
	 * Gets the death sound.
	 * @return sound to make
	 */
	@Override
	protected String aS()
	{
		return null;
	}

	/**
	 * makes walking around sounds
	 */
	@Override
	protected void a(int i, int j, int k, Block block)
	{
		// Do nothing.
	}

	/**
	 * handles this entity being struck by lightning.
	 * @param entitylightning lightning
	 */
	@Override
	public void a(EntityLightning entitylightning)
	{
		// Do nothing.
	}

	@Override
	public boolean a(EntityHuman entityhuman)
	{
		// We don't want people doing this.
		return false;
	}

	private final IPlayer player;
}
