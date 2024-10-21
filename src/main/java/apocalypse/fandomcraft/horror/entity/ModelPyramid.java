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

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity potato) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, potato);
        super.setRotationAngles(f, f1, f2, f3, f4, f5, potato);
        this.head.rotateAngleY = f3 / 57.295776f;
        this.head.rotateAngleX = f4 / 57.295776f;
        this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.rightleg.rotateAngleY = 0.0f;
        this.leftleg.rotateAngleY = 0.0f;
        this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 2.0f * f1 * 0.5f;
        this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662f) * 2.0f * f1 * 0.5f;
        this.rightarm.rotateAngleZ = 0.0f;
        this.leftarm.rotateAngleZ = 0.0f;
    }
}
