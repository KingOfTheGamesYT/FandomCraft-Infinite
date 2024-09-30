package com.devmaster1015.fandomcraft.entities;

import com.devmaster1015.fandomcraft.util.RegistryHandler;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import net.minecraftforge.fml.network.NetworkHooks;

public class EntityGreenShell extends FProjectile

{
	public EntityGreenShell(EntityType<? extends EntityGreenShell> type, World world)
	{
		super(type, world);
	}

	public EntityGreenShell(World world, LivingEntity sourceentity)
	{
		super(RegistryHandler.SHELL_ENTITY.get(), sourceentity, world);
	}

	@Override
	public IPacket<?> createSpawnPacket()
	{
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void onImpact(RayTraceResult trace) {
		super.onImpact(trace);
		float damage = 40.0F;
		for (int l = 0; l < 5; l++)
		{
			this.world.addParticle(ParticleTypes.CRIT, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
		}
		this.remove();
	}

	@Override
	protected void onEntityHit(EntityRayTraceResult trace) {
		super.onEntityHit(trace);
		float damage = 40.0F;
		trace.getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, getShooter()), damage);
		this.remove();
	}
	@Override
	public Item getShotItem()
	{
		return RegistryHandler.SHELL.get();
	}
}
