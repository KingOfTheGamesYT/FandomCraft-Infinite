package com.devmaster1015.fandomcraft.client.render;

import com.devmaster1015.fandomcraft.entities.EntityDekuNut;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;

public class RenderDekuNut extends SpriteRenderer<EntityDekuNut>
{
	public RenderDekuNut(EntityRendererManager renderer)
	{
		super(renderer, Minecraft.getInstance().getItemRenderer());
	}

	@Override
	public void render(EntityDekuNut entity, float f1, float partialticks, MatrixStack ms, IRenderTypeBuffer rb, int packedlight)
	{
		super.render(entity, f1, partialticks, ms, rb, packedlight);
	}
}