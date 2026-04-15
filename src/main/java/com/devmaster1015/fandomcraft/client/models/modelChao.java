package com.devmaster1015.fandomcraft.client.models;

import com.devmaster1015.fandomcraft.entities.HeroChao;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class modelChao<E> extends EntityModel<HeroChao> {
	private final ModelRenderer Head;
	private final ModelRenderer Headwear;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public modelChao() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -19.0F, -3.0F);
		setRotationAngle(Head, 0.7505F, -1.5708F, -0.8029F);
		Head.setTextureOffset(0, 0).addBox(1.0F, -1.0F, -2.0F, 3.0F, 3.0F, 3.0F, 0.0F, true);

		Headwear = new ModelRenderer(this);
		Headwear.setRotationPoint(0.0F, -8.0F, -1.0F);
		Headwear.setTextureOffset(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, true);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(1.0F, -8.0F, -1.0F);
		Body.setTextureOffset(32, 16).addBox(-4.0F, 0.0F, -2.0F, 6.0F, 6.0F, 5.0F, 0.0F, true);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-4.0F, -6.0F, 0.0F);
		setRotationAngle(RightArm, 0.0F, 0.0F, 0.2269F);
		RightArm.setTextureOffset(56, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(4.0F, -6.0F, 0.0F);
		setRotationAngle(LeftArm, 0.0F, 0.0F, -0.2269F);
		LeftArm.setTextureOffset(56, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-2.0F, -2.0F, -1.0F);
		setRotationAngle(RightLeg, -0.4363F, 0.2618F, 0.0F);
		RightLeg.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(2.0F, -2.0F, -1.0F);
		setRotationAngle(LeftLeg, -0.4363F, -0.2618F, 0.0F);
		LeftLeg.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(HeroChao entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Headwear.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}