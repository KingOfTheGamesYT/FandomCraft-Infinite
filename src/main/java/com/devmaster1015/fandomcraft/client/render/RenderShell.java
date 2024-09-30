package com.devmaster1015.fandomcraft.client.render;

import com.devmaster1015.fandomcraft.entities.EntityGreenShell;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;

public class RenderShell extends SpriteRenderer<EntityGreenShell>
{
	public RenderShell(EntityRendererManager renderer)
	{
		super(renderer, Minecraft.getInstance().getItemRenderer());
	}

	@Override
	public void render(EntityGreenShell entity, float f1, float partialticks, MatrixStack ms, IRenderTypeBuffer rb, int packedlight)
	{
		super.render(entity, f1, partialticks, ms, rb, packedlight);
	}
}