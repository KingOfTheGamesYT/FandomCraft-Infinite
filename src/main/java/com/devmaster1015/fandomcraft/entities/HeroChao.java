package com.devmaster1015.fandomcraft.entities;

import com.devmaster1015.fandomcraft.util.RegistryHandler;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class HeroChao extends AnimalEntity {

    public HeroChao(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
        this.moveController = new FloatingMovementController(this);
        this.noClip = true; // Prevents it from colliding incorrectly
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.0));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(3, new SwimGoal(this));
        this.goalSelector.addGoal(4, new BreedGoal(this, 0.8D));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.5D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new TemptGoal(this, 0.6D, Ingredient.fromItems(RegistryHandler.BLUE_BERRY.get()), true));
    }

    @Override
    public void tick() {
        super.tick();
        this.recalculateBoundingBox(); // Updates hitbox position
    }


    protected void recalculateBoundingBox() {
        double yOffset = 0.5; // Adjust for correct hovering
        double width = this.getWidth() / 2.0;
        this.setBoundingBox(new AxisAlignedBB(
                this.getPosX() - width, this.getPosY() + yOffset, this.getPosZ() - width,
                this.getPosX() + width, this.getPosY() + this.getHeight() + yOffset, this.getPosZ() + width
        ));
    }

    @Override
    public void travel(Vector3d movement) {
        if (this.isInWater()) {
            super.travel(movement);
        } else {
            this.move(MoverType.SELF, this.getMotion());
        }
    }

    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
        return this; // Correct way to spawn a child
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 50.0D)
                .createMutableAttribute(Attributes.FLYING_SPEED, 0.3D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D);
    }

    // Floating movement logic
    static class FloatingMovementController extends MovementController {
        private final HeroChao mob;

        public FloatingMovementController(HeroChao mob) {
            super(mob);
            this.mob = mob;
        }

        @Override
        public void tick() {
            // Get ground level
            BlockPos below = mob.getPosition().down();
            double groundLevel = below.getY() + 1.0;
            double hoverHeight = 0.5;

            // Apply hovering effect
            if (mob.getPosY() < groundLevel + hoverHeight) {
                mob.setMotion(mob.getMotion().add(0, 0.05, 0)); // Adds vertical motion
            }

            // Add a slight bobbing effect
            double bobbing = Math.sin(mob.ticksExisted / 10.0) * 0.005;
            mob.setMotion(mob.getMotion().add(0, bobbing, 0));
        }
    }
}
