package apocalypse.fandomcraft.horror.entity;

import cpw.mods.fml.relauncher.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

@SideOnly(Side.CLIENT)
public class ModelLGM extends ModelBiped
{
    public boolean isCarrying;
    public boolean isAttacking;
    private static final String __OBFID = "CL_00000838";
    
    public ModelLGM() {
        super(0.0f, -14.0f, 64, 32);
        final float f = -14.0f;
        final float f2 = 0.0f;
        (this.bipedHeadwear = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f2 - 0.5f);
        this.bipedHeadwear.setRotationPoint(0.0f, 0.0f + f, 0.0f);
        (this.bipedBody = new ModelRenderer((ModelBase)this, 32, 16)).addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, f2);
        this.bipedBody.setRotationPoint(0.0f, 0.0f + f, 0.0f);
        (this.bipedRightArm = new ModelRenderer((ModelBase)this, 56, 0)).addBox(-1.0f, -2.0f, -1.0f, 2, 30, 2, f2);
        this.bipedRightArm.setRotationPoint(-3.0f, 2.0f + f, 0.0f);
        this.bipedLeftArm = new ModelRenderer((ModelBase)this, 56, 0);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0f, -2.0f, -1.0f, 2, 30, 2, f2);
        this.bipedLeftArm.setRotationPoint(5.0f, 2.0f + f, 0.0f);
        (this.bipedRightLeg = new ModelRenderer((ModelBase)this, 56, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 30, 2, f2);
        this.bipedRightLeg.setRotationPoint(-2.0f, 12.0f + f, 0.0f);
        this.bipedLeftLeg = new ModelRenderer((ModelBase)this, 56, 0);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 30, 2, f2);
        this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f + f, 0.0f);
    }
    
    public void setRotationAngles(final float p_78087_1_, final float p_78087_2_, final float p_78087_3_, final float p_78087_4_, final float p_78087_5_, final float p_78087_6_, final Entity p_78087_7_) {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
        this.bipedHead.showModel = true;
        final float f6 = -14.0f;
        this.bipedBody.rotateAngleX = 0.0f;
        this.bipedBody.rotationPointY = f6;
        this.bipedBody.rotationPointZ = -0.0f;
        final ModelRenderer bipedRightLeg = this.bipedRightLeg;
        bipedRightLeg.rotateAngleX -= 0.0f;
        final ModelRenderer bipedLeftLeg = this.bipedLeftLeg;
        bipedLeftLeg.rotateAngleX -= 0.0f;
        this.bipedRightArm.rotateAngleX *= 0.5;
        this.bipedLeftArm.rotateAngleX *= 0.5;
        this.bipedRightLeg.rotateAngleX *= 0.5;
        this.bipedLeftLeg.rotateAngleX *= 0.5;
        final float f7 = 0.4f;
        if (this.bipedRightArm.rotateAngleX > f7) {
            this.bipedRightArm.rotateAngleX = f7;
        }
        if (this.bipedLeftArm.rotateAngleX > f7) {
            this.bipedLeftArm.rotateAngleX = f7;
        }
        if (this.bipedRightArm.rotateAngleX < -f7) {
            this.bipedRightArm.rotateAngleX = -f7;
        }
        if (this.bipedLeftArm.rotateAngleX < -f7) {
            this.bipedLeftArm.rotateAngleX = -f7;
        }
        if (this.bipedRightLeg.rotateAngleX > f7) {
            this.bipedRightLeg.rotateAngleX = f7;
        }
        if (this.bipedLeftLeg.rotateAngleX > f7) {
            this.bipedLeftLeg.rotateAngleX = f7;
        }
        if (this.bipedRightLeg.rotateAngleX < -f7) {
            this.bipedRightLeg.rotateAngleX = -f7;
        }
        if (this.bipedLeftLeg.rotateAngleX < -f7) {
            this.bipedLeftLeg.rotateAngleX = -f7;
        }
        if (this.isCarrying) {
            this.bipedRightArm.rotateAngleX = -0.5f;
            this.bipedLeftArm.rotateAngleX = -0.5f;
            this.bipedRightArm.rotateAngleZ = 0.05f;
            this.bipedLeftArm.rotateAngleZ = -0.05f;
        }
        this.bipedRightArm.rotationPointZ = 0.0f;
        this.bipedLeftArm.rotationPointZ = 0.0f;
        this.bipedRightLeg.rotationPointZ = 0.0f;
        this.bipedLeftLeg.rotationPointZ = 0.0f;
        this.bipedRightLeg.rotationPointY = 9.0f + f6;
        this.bipedLeftLeg.rotationPointY = 9.0f + f6;
        this.bipedHead.rotationPointZ = -0.0f;
        this.bipedHead.rotationPointY = f6 + 1.0f;
        this.bipedHeadwear.rotationPointX = this.bipedHead.rotationPointX;
        this.bipedHeadwear.rotationPointY = this.bipedHead.rotationPointY;
        this.bipedHeadwear.rotationPointZ = this.bipedHead.rotationPointZ;
        this.bipedHeadwear.rotateAngleX = this.bipedHead.rotateAngleX;
        this.bipedHeadwear.rotateAngleY = this.bipedHead.rotateAngleY;
        this.bipedHeadwear.rotateAngleZ = this.bipedHead.rotateAngleZ;
        if (this.isAttacking) {
            final float f8 = 1.0f;
            final ModelRenderer bipedHead = this.bipedHead;
            bipedHead.rotationPointY -= f8 * 5.0f;
        }
    }
}
