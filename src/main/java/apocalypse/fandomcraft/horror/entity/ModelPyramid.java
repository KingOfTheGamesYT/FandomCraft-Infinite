package apocalypse.fandomcraft.horror.entity;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelPyramid extends ModelBase
{
    ModelRenderer handle;
    ModelRenderer hilt;
    ModelRenderer blade;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer head;
    public int heldItemLeft;
    public int heldItemRight;
    
    public ModelPyramid() {
        this.textureWidth = 128;
        this.textureHeight = 32;
        (this.handle = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-3.0f, 7.0f, -3.0f, 1, 2, 7);
        this.handle.setRotationPoint(-5.0f, 2.0f, 0.0f);
        this.handle.setTextureSize(128, 32);
        this.handle.mirror = true;
        this.setRotation(this.handle, -0.4014257f, 0.3490659f, 0.0f);
        (this.hilt = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-3.0f, 6.0f, 4.0f, 1, 6, 1);
        this.hilt.setRotationPoint(-5.0f, 2.0f, 0.0f);
        this.hilt.setTextureSize(128, 32);
        this.hilt.mirror = true;
        this.setRotation(this.hilt, -0.4014257f, 0.3490659f, 0.0f);
        (this.blade = new ModelRenderer((ModelBase)this, 32, -5)).addBox(-2.5f, 6.0f, 5.0f, 0, 5, 32);
        this.blade.setRotationPoint(-5.0f, 2.0f, 0.0f);
        this.blade.setTextureSize(128, 32);
        this.blade.mirror = true;
        this.setRotation(this.blade, -0.4014257f, 0.3490659f, 0.0f);
        (this.body = new ModelRenderer((ModelBase)this, 32, 0)).addBox(-5.0f, 0.0f, -3.0f, 10, 14, 6);
        this.body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.body.setTextureSize(128, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase)this, 16, 16)).addBox(-4.0f, -2.0f, -2.0f, 4, 12, 4);
        this.rightarm.setRotationPoint(-5.0f, 2.0f, 0.0f);
        this.rightarm.setTextureSize(128, 32);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
        (this.leftarm = new ModelRenderer((ModelBase)this, 16, 16)).addBox(0.0f, -2.0f, -2.0f, 4, 12, 4);
        this.leftarm.setRotationPoint(5.0f, 2.0f, 0.0f);
        this.leftarm.setTextureSize(128, 32);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.0f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.rightleg.setRotationPoint(-2.0f, 12.0f, 0.0f);
        this.rightleg.setTextureSize(128, 32);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leftleg.setRotationPoint(2.0f, 12.0f, 0.0f);
        this.leftleg.setTextureSize(128, 32);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 64, 0)).addBox(-4.5f, -7.0f, -7.0f, 9, 9, 16);
        this.head.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.head.setTextureSize(128, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 1.169371f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.handle.render(f5);
        this.hilt.render(f5);
        this.blade.render(f5);
        this.body.render(f5);
        this.rightarm.render(f5);
        this.leftarm.render(f5);
        this.rightleg.render(f5);
        this.leftleg.render(f5);
        this.head.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float p_78087_1_, final float p_78087_2_, final float p_78087_3_, final float p_78087_4_, final float p_78087_5_, final float p_78087_6_, final Entity p_78087_7_) {
        this.head.rotateAngleY = p_78087_4_ / 57.295776f;
        this.head.rotateAngleX = p_78087_5_ / 57.295776f;
        this.rightarm.rotateAngleZ = 0.0f;
        this.leftarm.rotateAngleZ = 0.0f;
        this.rightleg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662f) * 1.4f * p_78087_2_;
        this.leftleg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662f + 3.1415927f) * 1.4f * p_78087_2_;
        this.rightleg.rotateAngleY = 0.0f;
        this.leftleg.rotateAngleY = 0.0f;
        this.handle.rotateAngleX = this.rightarm.rotateAngleX;
        this.handle.rotateAngleY = this.rightarm.rotateAngleY;
        this.handle.rotateAngleZ = this.rightarm.rotateAngleZ;
        this.hilt.rotateAngleX = this.handle.rotateAngleX;
        this.hilt.rotateAngleY = this.handle.rotateAngleY;
        this.hilt.rotateAngleZ = this.handle.rotateAngleZ;
        this.blade.rotateAngleX = this.hilt.rotateAngleX;
        this.blade.rotateAngleY = this.hilt.rotateAngleY;
        this.blade.rotateAngleZ = this.hilt.rotateAngleZ;
        if (this.isRiding) {}
        final ModelRenderer leftarm = this.leftarm;
        leftarm.rotateAngleX -= 0.62831855f;
        this.rightleg.rotateAngleX = -1.2566371f;
        this.leftleg.rotateAngleX = -1.2566371f;
        this.rightleg.rotateAngleY = 0.31415927f;
        this.leftleg.rotateAngleY = -0.31415927f;
        if (this.heldItemLeft != 0) {
            this.leftarm.rotateAngleX = this.leftarm.rotateAngleX * 0.5f - 0.31415927f * this.heldItemLeft;
        }
        if (this.heldItemRight != 0) {
            this.rightarm.rotateAngleX = this.rightarm.rotateAngleX * 0.5f - 0.31415927f * this.heldItemRight;
        }
        this.leftarm.rotateAngleY = 0.0f;
        if (this.heldItemLeft > -9990.0f) {
            float f6 = this.heldItemRight;
            this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.1415927f * 2.0f) * 0.2f;
            this.leftarm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0f;
            this.leftarm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0f;
            final ModelRenderer rightarm = this.rightarm;
            rightarm.rotateAngleY += this.body.rotateAngleY;
            final ModelRenderer leftarm2 = this.leftarm;
            leftarm2.rotateAngleY += this.body.rotateAngleY;
            final ModelRenderer leftarm3 = this.leftarm;
            leftarm3.rotateAngleX += this.body.rotateAngleY;
            f6 = 1.0f - this.heldItemLeft;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0f - f6;
            final float f7 = MathHelper.sin(f6 * 3.1415927f);
            final float n = MathHelper.sin(this.heldItemLeft * 3.1415927f) * -(this.head.rotateAngleX - 0.7f) * 0.75f;
        }
        this.body.rotateAngleX = 0.0f;
        this.rightleg.rotationPointZ = 0.1f;
        this.leftleg.rotationPointZ = 0.1f;
        this.rightleg.rotationPointY = 12.0f;
        this.leftleg.rotationPointY = 12.0f;
        this.head.rotationPointY = 0.0f;
        final ModelRenderer leftarm4 = this.leftarm;
        leftarm4.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer leftarm5 = this.leftarm;
        leftarm5.rotateAngleX -= MathHelper.sin(p_78087_3_ * 0.067f) * 0.05f;
    }
}
