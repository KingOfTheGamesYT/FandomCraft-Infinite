package com.devmaster1015.fandomcraft.client.models;

import com.devmaster1015.fandomcraft.entities.EntityGoomba;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class modelGoomba<E> extends EntityModel<EntityGoomba> {
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Body;
	private final ModelRenderer HeadBase;
	private final ModelRenderer HeadTop;
	private final ModelRenderer EyebrowLeft;
	private final ModelRenderer EyebrowRight;
	private final ModelRenderer ToothRight;
	private final ModelRenderer ToothLeft;

	public modelGoomba() {
		textureWidth = 64;
		textureHeight = 32;

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-3.0F, 22.0F, 0.0F);
		RightLeg.setTextureOffset(3, 25).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 2.0F, 5.0F, 0.0F, true);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(3.0F, 22.0F, 0.0F);
		LeftLeg.setTextureOffset(3, 25).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 2.0F, 5.0F, 0.0F, true);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 19.0F, 1.0F);
		Body.setTextureOffset(0, 16).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F, 0.0F, true);

		HeadBase = new ModelRenderer(this);
		HeadBase.setRotationPoint(0.0F, 16.0F, 1.0F);
		HeadBase.setTextureOffset(24, 18).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 4.0F, 10.0F, 0.0F, true);

		HeadTop = new ModelRenderer(this);
		HeadTop.setRotationPoint(0.0F, 11.0F, 1.0F);
		HeadTop.setTextureOffset(28, 5).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 5.0F, 8.0F, 0.0F, true);

		EyebrowLeft = new ModelRenderer(this);
		EyebrowLeft.setRotationPoint(2.0F, 12.0F, -4.0F);
		EyebrowLeft.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		EyebrowRight = new ModelRenderer(this);
		EyebrowRight.setRotationPoint(-2.0F, 12.0F, -4.0F);
		EyebrowRight.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		ToothRight = new ModelRenderer(this);
		ToothRight.setRotationPoint(-4.0F, 17.0F, -4.5F);
		ToothRight.setTextureOffset(0, 2).addBox(0.0F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, true);

		ToothLeft = new ModelRenderer(this);
		ToothLeft.setRotationPoint(3.0F, 17.0F, -4.5F);
		ToothLeft.setTextureOffset(0, 2).addBox(0.0F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, true);
	}

	@Override
	public void setRotationAngles(EntityGoomba entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		HeadBase.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		HeadTop.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		EyebrowLeft.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		EyebrowRight.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		ToothRight.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		ToothLeft.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}