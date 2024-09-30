package com.devmaster1015.fandomcraft.client.models;

import com.devmaster1015.fandomcraft.entities.EntityKoopa;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class modelKoopa<E> extends EntityModel<EntityKoopa> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;
	private final ModelRenderer Neck;
	private final ModelRenderer Shell;
	private final ModelRenderer Tail;
	private final ModelRenderer Eyes;

	public modelKoopa() {
		textureWidth = 128;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 6.0F, -2.0F);
		head.setTextureOffset(0, 0).addBox(-3.5F, -6.0F, -6.0F, 7.0F, 6.0F, 8.0F, 0.0F, true);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 8.0F, -1.0F);
		body.setTextureOffset(16, 21).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 8.0F, 3.0F, 0.0F, true);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-4.0F, 11.0F, 0.0F);
		rightarm.setTextureOffset(40, 0).addBox(-2.5F, -2.0F, -2.0F, 3.0F, 7.0F, 3.0F, 0.0F, true);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(4.5F, 11.0F, 0.0F);
		leftarm.setTextureOffset(40, 0).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 7.0F, 3.0F, 0.0F, true);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-2.0F, 16.0F, 0.0F);
		rightleg.setTextureOffset(0, 20).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, true);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(2.0F, 16.0F, 0.0F);
		leftleg.setTextureOffset(0, 20).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, true);

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.0F, 8.0F, 0.0F);
		setRotationAngle(Neck, 0.2618F, 0.0F, 0.0F);
		Neck.setTextureOffset(52, 0).addBox(-1.5F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, 0.0F, true);

		Shell = new ModelRenderer(this);
		Shell.setRotationPoint(0.0F, 10.5F, 0.0F);
		Shell.setTextureOffset(64, 17).addBox(-4.5F, -4.0F, 0.0F, 9.0F, 10.0F, 5.0F, 0.0F, true);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 14.5F, -1.0F);
		setRotationAngle(Tail, -0.4363F, 0.0F, 0.0F);
		Tail.setTextureOffset(64, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 9.0F, 0.0F, true);

		Eyes = new ModelRenderer(this);
		Eyes.setRotationPoint(0.0F, 1.0F, -1.0F);
		Eyes.setTextureOffset(46, 14).addBox(-2.5F, -5.0F, -2.0F, 5.0F, 9.0F, 4.0F, 0.0F, true);
	}

	@Override
	public void setRotationAngles(EntityKoopa entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setLivingAnimations(EntityKoopa entityLiving, float limbSwing, float limbSwingAmount, float partialTicks) {
		// Arm movement: right and left arms swing opposite to each other
		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

		// Head rotation (if desired, you may want to base this on entity look angles)
		this.head.rotateAngleY = ((float)Math.PI / 180F);
		this.head.rotateAngleX = ((float)Math.PI / 180F);

		// Sync Eyes with Head
		this.Eyes.rotateAngleX = this.head.rotateAngleX;
		this.Eyes.rotateAngleY = this.head.rotateAngleY;

		// Leg movement: legs should swing opposite to each other
		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount; // Right leg swings forward
		this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount; // Left leg swings backward

		// Resetting Y axis leg movement
		this.leftleg.rotateAngleY = 0.0F;
		this.rightleg.rotateAngleY = 0.0F;
	}


	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Neck.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Shell.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Eyes.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}