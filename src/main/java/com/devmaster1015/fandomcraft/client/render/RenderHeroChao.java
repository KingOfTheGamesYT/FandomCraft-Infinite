package com.devmaster1015.fandomcraft.client.render;

import com.devmaster1015.fandomcraft.client.models.modelChao;
import com.devmaster1015.fandomcraft.entities.HeroChao;
import com.devmaster1015.fandomcraft.main.FandomCraft;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderHeroChao extends MobRenderer<HeroChao, modelChao<HeroChao>> {
    private static final ResourceLocation res = new ResourceLocation(FandomCraft.MOD_ID, "textures/models/entity/chao.png");

    public RenderHeroChao(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new modelChao(), 0.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(HeroChao entity) {
        return res;
    }

}