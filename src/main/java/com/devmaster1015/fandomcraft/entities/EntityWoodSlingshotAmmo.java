package com.devmaster1015.fandomcraft.entities;

import com.devmaster1015.fandomcraft.util.RegistryHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import net.minecraftforge.fml.network.NetworkHooks;

import org.apache.logging.log4j.util.TriConsumer;

public class EntityWoodSlingshotAmmo extends FProjectile
{
	private ItemStack shot;
	private TriConsumer<EntityWoodSlingshotAmmo, Entity, RayTraceResult> hitaction;
	private float power = 4;

	public EntityWoodSlingshotAmmo(EntityType<? extends EntityWoodSlingshotAmmo> type, World world)
	{
		super(type, world);
	}

	public EntityWoodSlingshotAmmo(World world, LivingEntity sourceentity, ItemStack itemshot, float power, TriConsumer<EntityWoodSlingshotAmmo, Entity, RayTraceResult> hitaction)
	{
		super(RegistryHandler.WOOD_SLINGSHOT_AMMO.get(), sourceentity, world);
		this.shot = itemshot;
		this.power = power;
	}

	@Override
	public IPacket<?> createSpawnPacket()
	{
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void onEntityHit(EntityRayTraceResult trace)
	{
		super.onEntityHit(trace);
		trace.getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, getShooter()), power);
	}

	@Override
	public void onImpact(RayTraceResult trace)
	{
		super.onImpact(trace);

		if (hitaction != null)
		{
			hitaction.accept(this, getShooter(), trace);
		}

		if (!this.world.isRemote)
		{
			this.world.setEntityState(this, (byte) 3);
			this.remove();
		}
	}

	@Override
	public Item getShotItem()
	{
		return shot == null ? RegistryHandler.DEKUSEED.get() : shot.getItem();
	}
}
