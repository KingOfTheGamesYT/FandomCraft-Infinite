package com.devmaster1015.fandomcraft.entities;

import com.devmaster1015.fandomcraft.main.FandomCraft;
import com.devmaster1015.fandomcraft.util.RegistryHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class EntityGoomba extends MonsterEntity {

    public EntityGoomba(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.isImmuneToFire();
        this.experienceValue = 3;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new WaterAvoidingRandomWalkingGoal(this, 0.5D));
        this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 0.5D, true));
        this.goalSelector.addGoal(4, new MoveTowardsTargetGoal(this, 0.5D, 32.0F));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected SoundEvent getDeathSound() {
        return RegistryHandler.GOOMBA_STOMP.get();
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHit) {
        int count = this.rand.nextInt(3 + looting);
        for (int i = 0; i < count; i++) {
            this.entityDropItem(RegistryHandler.RUPEE_GREEN.get());
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean success = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (7 + this.rand.nextInt(15)));
        if (success) {
            entityIn.setMotion(entityIn.getMotion().x, 0.4D, entityIn.getMotion().z); // Adds vertical motion when hit
        }
        this.playSound(SoundEvents.ENTITY_SPIDER_DEATH, 1.0F, 1.0F);
        return success;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.7)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
    }
}
