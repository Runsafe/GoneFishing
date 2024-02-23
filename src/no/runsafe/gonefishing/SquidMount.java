package no.runsafe.gonefishing;

import net.minecraft.server.v1_12_R1.*;
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
			setSilent(true);
			setPosition(mounterLocation.getX(), mounterLocation.getY(), mounterLocation.getZ());
			rawWorld.addEntity(this);
			player.startRiding(this);
		}
	}

	/**
	 * Damage the entity.
	 * Overrides method in {@link EntityLiving}
	 * Names of this function in various spigot versions:
	 * v1_7_R3: d
	 * v1_12_R1: damageEntity0
	 * @param source damage source
	 * @param damageValue Amount of damage
	 * @return 1.12: boolean, True if damaged, false if not damaged.
	 */
	@Override
	protected boolean damageEntity0(DamageSource source, float damageValue)
	{
		if (!passengers.isEmpty() && damageValue < getHealth())
			for (Entity passenger : passengers)
				passenger.damageEntity(DamageSource.GENERIC, damageValue - getHealth());
		return true;
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
	public void n()
	{
		ILocation playerLocation = player.getLocation();
		if (player.isDead() || !player.isOnline() || passengers.isEmpty() || playerLocation == null || !passengers.get(0).getName().equals(player.getName()))
		{
			setHealth(0); // Kill the squid.
			return;
		}

		int i = getAirTicks();

		if (isAlive() && !aq())
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
		super.n();
	}

	/**
	 * Overrides method in EntityLiving.class
	 * Names of this function in various spigot versions:
	 * v1_7_R3: e(float f, float f1)
	 * v1.12_R1: a(float f, float f1, float f2)
	 * -
	 * Obfuscated stuff:
	 * v1_7_R3: W
	 * v1_12_R1: P
	 * -
	 * v1_7_R3: ap
	 * v1_12_R1: aQ
	 * -
	 * v1_7_R3: aN
	 * v1_12_R1: aO
	 * -
	 * v1_7_R3: .be
	 * v1_12_R1: .bg
	 * -
	 * v1_7_R3: i(float)
	 * v1_12_R1: k(float)
	 */
	@Override
	public void a(float f, float f1, float f2)
	{
		P = 1F;
		lastYaw = yaw = passengers.get(0).yaw;
		pitch = passengers.get(0).pitch * 0.5F;

		setYawPitch(yaw, pitch);
		aQ = aO = yaw;

		f = ((EntityLiving) passengers.get(0)).bg * 0.5f;
		//f1 = ((EntityLiving) passenger).bf;

		//if (f1 <= 0.0F)
		// f1 *= 0.25F;

		f *= 0.75F;
		k(0F);
		super.a(f, f1, f2);
	}

	/**
	 * handles this entity being struck by lightning.
	 * @param entityLightning lightning
	 */
	@Override
	public void onLightningStrike(EntityLightning entityLightning)
	{
		// Do nothing.
	}

	/**
	 * Handles a player mounting this entity.
	 * Overrides method in {@link EntityPig}
	 * @param entityHuman human
	 * @return false
	 * -
	 * Names of this function in various spigot versions:
	 * v1_7_R3: a(EntityHuman human)
	 * v1_12_R1: a(EntityHuman human, EnumHand hand)
	 */
	@Override
	public boolean a(EntityHuman entityHuman, EnumHand hand)
	{
		// We don't want people doing this.
		return false;
	}

	private final IPlayer player;
}
