package apocalypse.fandomcraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTank extends ModelBiped {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;

	public ModelTank() {
		textureWidth = 64;
		textureHeight = 64;

		(this.head = new ModelRenderer((ModelBase)this, 3, 4)).addBox( -3.0F, -7.0F, -3.0F, 6, 7, 5);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.setRotation(this.head, 0, 0.0f, 0.0f);

		(this.body = new ModelRenderer((ModelBase)this, 5, 39)).addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.setRotation(this.body, 0, 0.0f, 0.0f);

		(this.leftArm = new ModelRenderer((ModelBase)this, 42, 48)).addBox(-6.0F, -2.0F, -2.0F, 7, 12, 4, 0.0F);
		leftArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		this.setRotation(this.leftArm, 1.169371f, 0.0f, 0.0f);
		this.setRotation(this.leftArm, 0, 0.0f, 0.0f);

		(this.rightArm = new ModelRenderer((ModelBase)this, 42, 48)).addBox(-1.0F, -2.0F, -2.0F, 7, 12, 4, 0.0F);
		rightArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		this.setRotation(this.rightArm, 0, 0.0f, 0.0f);

		(this.leftLeg = new ModelRenderer((ModelBase)this, 32, 1)).addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		leftLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		this.setRotation(this.leftLeg, 0, 0.0f, 0.0f);

		(this.rightLeg = new ModelRenderer((ModelBase)this, 32, 1)).addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		rightLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		this.setRotation(this.rightLeg, 0, 0.0f, 0.0f);

	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		leftArm.render(f5);
		rightArm.render(f5);
		leftLeg.render(f5);
		rightLeg.render(f5);
	}

	public void setRotation(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity potato) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, potato);
		super.setRotationAngles(f, f1, f2, f3, f4, f5, potato);
		this.head.rotateAngleY = f3 / 57.295776f;
		this.head.rotateAngleX = f4 / 57.295776f;
		this.rightLeg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
		this.leftLeg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
		this.rightLeg.rotateAngleY = 0.0f;
		this.leftLeg.rotateAngleY = 0.0f;
		this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
		this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f;
		this.rightArm.rotateAngleZ = 0.0f;
		this.leftArm.rotateAngleZ = 0.0f;
	}

}