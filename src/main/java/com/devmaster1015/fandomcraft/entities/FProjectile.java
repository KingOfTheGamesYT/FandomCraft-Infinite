package com.devmaster1015.fandomcraft.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;

import net.minecraftforge.fml.network.NetworkHooks;

public abstract class FProjectile extends ProjectileItemEntity
{
	public FProjectile(EntityType<? extends ProjectileItemEntity> entity, World world)
	{
		super(entity, world);
	}

	public FProjectile(EntityType<? extends ProjectileItemEntity> entity, double x, double y, double z, World world)
	{
		super(entity, x, y, z, world);
	}

	public FProjectile(EntityType<? extends ProjectileItemEntity> entity, LivingEntity shooter, World world)
	{
		super(entity, shooter, world);
	}

	public abstract Item getShotItem();

	@Override
	protected Item getDefaultItem()
	{
		return getShotItem();
	}

	@Override
	public IPacket<?> createSpawnPacket()
	{
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
