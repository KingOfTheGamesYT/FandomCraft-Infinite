package com.devmaster1015.fandomcraft.client.render;

import com.devmaster1015.fandomcraft.client.models.modelGoomba;
import com.devmaster1015.fandomcraft.entities.EntityGoomba;
import com.devmaster1015.fandomcraft.main.FandomCraft;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

	public class RenderGoomba extends MobRenderer<EntityGoomba, modelGoomba<EntityGoomba>> {
		private static final ResourceLocation res = new ResourceLocation(FandomCraft.MOD_ID, "textures/models/entity/goomba.png");

		public RenderGoomba(EntityRendererManager renderManagerIn) {
			super(renderManagerIn, new modelGoomba<>(), 0.0F);
		}

		@Override
		public ResourceLocation getEntityTexture(EntityGoomba entity) {
			return res;
		}

	}