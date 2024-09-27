package com.devmaster1015.fandomcraft.entities;

import com.devmaster1015.fandomcraft.util.RegistryHandler;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.List;
import java.util.Random;

public class EntityDekuNut extends FProjectile

{
	public EntityDekuNut(EntityType<? extends EntityDekuNut> type, World world)
	{
		super(type, world);
	}

	public EntityDekuNut(World world, LivingEntity sourceentity)
	{
		super(RegistryHandler.DEKUNUT_ENTITY.get(), sourceentity, world);
	}

	@Override
	public IPacket<?> createSpawnPacket()
	{
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void onImpact(RayTraceResult trace) {
		super.onImpact(trace);

		// Play sound effect
		playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 1, 1);

		// Spawn particles at the impact location
		Vector3d impactPos = trace.getHitVec();
		this.world.addParticle(ParticleTypes.LARGE_SMOKE, impactPos.x, impactPos.y, impactPos.z, 0, 0, 0);
		spawnParticles(ParticleTypes.LARGE_SMOKE, 8, 0.1, 5);
		// Apply effects to nearby entities
		AxisAlignedBB affectedArea = new AxisAlignedBB(this.getPosition()).grow(5.0D);
		List<LivingEntity> nearbyEntities = this.world.getEntitiesWithinAABB(LivingEntity.class, affectedArea);

		for (LivingEntity entity : nearbyEntities) {
			if (entity != this.getEntity()) {
				// Apply Slowness 10 for 5 seconds (100 ticks)
				entity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 9)); // 100 ticks = 5 seconds, level 9 for Slowness 10
			}
		}

		// Remove the projectile entity
		this.remove();
	}

	@Override
	public Item getShotItem()
	{
		return RegistryHandler.DEKUNUT.get();
	}

	@OnlyIn(Dist.CLIENT)
	private void spawnParticles(IParticleData particle, int amount, double velocity, double radius) {
		Random r = this.world.getRandom();
		for (int i = 0; i < amount; ++i) {
			// Generate a random point within a sphere
			double theta = r.nextDouble() * 2 * Math.PI;
			double phi = Math.acos(2 * r.nextDouble() - 1);
			double radiusFactor = r.nextDouble() * radius;

			double offsetX = radiusFactor * Math.sin(phi) * Math.cos(theta);
			double offsetY = radiusFactor * Math.sin(phi) * Math.sin(theta);
			double offsetZ = radiusFactor * Math.cos(phi);

			double velocityX = (r.nextDouble() - 0.5) * velocity;
			double velocityY = (r.nextDouble() - 0.5) * velocity;
			double velocityZ = (r.nextDouble() - 0.5) * velocity;

			this.world.addParticle(particle,
					this.getPosX() + offsetX,
					this.getPosY() + offsetY,
					this.getPosZ() + offsetZ,
					velocityX, velocityY, velocityZ);
		}
	}
}
