package com.devmaster1015.fandomcraft.client.render;

import com.devmaster1015.fandomcraft.client.models.modelKoopa;
import com.devmaster1015.fandomcraft.entities.EntityKoopa;
import com.devmaster1015.fandomcraft.main.FandomCraft;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;

public class RenderKoopa extends MobRenderer<EntityKoopa, modelKoopa<EntityKoopa>> {
    private static final ResourceLocation res = new ResourceLocation(FandomCraft.MOD_ID, "textures/models/entity/koopa.png");

    public RenderKoopa(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new modelKoopa<>(), 0.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityKoopa entity) {
        return res;
    }

}