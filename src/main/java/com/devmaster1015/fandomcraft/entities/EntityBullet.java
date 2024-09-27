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

public class EntityBullet extends FProjectile
{
	private ItemStack shot;
	private TriConsumer<EntityBullet, Entity, RayTraceResult> hitaction;
	private float power = 2;

	public EntityBullet(EntityType<? extends EntityBullet> type, World world)
	{
		super(type, world);
	}

	public EntityBullet(World world, LivingEntity sourceentity, ItemStack itemshot, float power, TriConsumer<EntityBullet, Entity, RayTraceResult> hitaction)
	{
		super(RegistryHandler.BULLET_ENTITY.get(), sourceentity, world);
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
		return shot == null ? RegistryHandler.BULLET.get() : shot.getItem();
	}
}
