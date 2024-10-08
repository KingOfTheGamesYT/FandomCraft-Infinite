 package apocalypse.fandomcraft.models;

 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.util.MathHelper;
 import org.lwjgl.opengl.GL11;

 @SideOnly(Side.CLIENT)
 public class modelPhantomGannon
   extends ModelBase
 {
   public ModelRenderer bipedHead;
   public ModelRenderer bipedHeadwear;
   public ModelRenderer bipedBody;
   public ModelRenderer bipedRightArm;
   public ModelRenderer bipedLeftArm;
   public ModelRenderer bipedRightLeg;
   public ModelRenderer bipedLeftLeg;
   public ModelRenderer bipedEars;
   public ModelRenderer bipedCloak;
   public int heldItemLeft;
   public int heldItemRight;
   public boolean isSneak;
   public boolean aimedBow;
   private static final String __OBFID = "CL_00000840";
   private float swingProgress;

   public modelPhantomGannon() {
     this(0.0F);
   }

   public modelPhantomGannon(float p_i1148_1_) {
     this(p_i1148_1_, 0.0F, 64, 32);
   }

   public modelPhantomGannon(float p_i1149_1_, float p_i1149_2_, int p_i1149_3_, int p_i1149_4_) {
     this.textureWidth = p_i1149_3_;
     this.textureHeight = p_i1149_4_;
     this.bipedCloak = new ModelRenderer(this, 0, 0);
     this.bipedCloak.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, p_i1149_1_);
     this.bipedEars = new ModelRenderer(this, 24, 0);
     this.bipedEars.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, p_i1149_1_);
     this.bipedHead = new ModelRenderer(this, 0, 0);
     this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, p_i1149_1_);
     this.bipedHead.setRotationPoint(0.0F, 0.0F + p_i1149_2_, 0.0F);
     this.bipedHeadwear = new ModelRenderer(this, 32, 0);
     this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, p_i1149_1_ + 0.5F);
     this.bipedHeadwear.setRotationPoint(0.0F, 0.0F + p_i1149_2_, 0.0F);
     this.bipedBody = new ModelRenderer(this, 16, 16);
     this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, p_i1149_1_);
     this.bipedBody.setRotationPoint(0.0F, 0.0F + p_i1149_2_, 0.0F);
     this.bipedRightArm = new ModelRenderer(this, 40, 16);
     this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, p_i1149_1_);
     this.bipedRightArm.setRotationPoint(-5.0F, 2.0F + p_i1149_2_, 0.0F);
     this.bipedLeftArm = new ModelRenderer(this, 40, 16);
     this.bipedLeftArm.mirror = true;
     this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, p_i1149_1_);
     this.bipedLeftArm.setRotationPoint(5.0F, 2.0F + p_i1149_2_, 0.0F);
     this.bipedRightLeg = new ModelRenderer(this, 0, 16);
     this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, p_i1149_1_);
     this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F + p_i1149_2_, 0.0F);
     this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
     this.bipedLeftLeg.mirror = true;
     this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, p_i1149_1_);
     this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F + p_i1149_2_, 0.0F);
   }

   public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
     setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);

     if (this.isChild) {

       float f6 = 2.0F;
       GL11.glPushMatrix();
       GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
       GL11.glTranslatef(0.0F, 16.0F * p_78088_7_, 0.0F);
       this.bipedHead.render(p_78088_7_);
       GL11.glPopMatrix();
       GL11.glPushMatrix();
       GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
       GL11.glTranslatef(0.0F, 24.0F * p_78088_7_, 0.0F);
       this.bipedBody.render(p_78088_7_);
       this.bipedRightArm.render(p_78088_7_);
       this.bipedLeftArm.render(p_78088_7_);
       this.bipedRightLeg.render(p_78088_7_);
       this.bipedLeftLeg.render(p_78088_7_);
       this.bipedHeadwear.render(p_78088_7_);
       GL11.glPopMatrix();
     }
     else {

       this.bipedHead.render(p_78088_7_);
       this.bipedBody.render(p_78088_7_);
       this.bipedRightArm.render(p_78088_7_);
       this.bipedLeftArm.render(p_78088_7_);
       this.bipedRightLeg.render(p_78088_7_);
       this.bipedLeftLeg.render(p_78088_7_);
       this.bipedHeadwear.render(p_78088_7_);
     }
   }

   public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
     this.bipedHead.rotateAngleY = p_78087_4_ / 57.295776F;
     this.bipedHead.rotateAngleX = p_78087_5_ / 57.295776F;
     this.bipedHeadwear.rotateAngleY = this.bipedHead.rotateAngleY;
     this.bipedHeadwear.rotateAngleX = this.bipedHead.rotateAngleX;
     this.bipedRightArm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + 3.1415927F) * 2.0F * p_78087_2_ * 0.5F;
     this.bipedLeftArm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 2.0F * p_78087_2_ * 0.5F;
     this.bipedRightArm.rotateAngleZ = 0.0F;
     this.bipedLeftArm.rotateAngleZ = 0.0F;
     this.bipedRightLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
     this.bipedLeftLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + 3.1415927F) * 1.4F * p_78087_2_;
     this.bipedRightLeg.rotateAngleY = 0.0F;
     this.bipedLeftLeg.rotateAngleY = 0.0F;

     if (this.isRiding) {

       this.bipedRightArm.rotateAngleX += -0.62831855F;
       this.bipedLeftArm.rotateAngleX += -0.62831855F;
       this.bipedRightLeg.rotateAngleX = -1.2566371F;
       this.bipedLeftLeg.rotateAngleX = -1.2566371F;
       this.bipedRightLeg.rotateAngleY = 0.31415927F;
       this.bipedLeftLeg.rotateAngleY = -0.31415927F;
     }

     if (this.heldItemLeft != 0)
     {
       this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - 0.31415927F * this.heldItemLeft;
     }

     if (this.heldItemRight != 0)
     {
       this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - 0.31415927F * this.heldItemRight;
     }

     this.bipedRightArm.rotateAngleY = 0.0F;
     this.bipedLeftArm.rotateAngleY = 0.0F;

     if (this.swingProgress > -9990.0F) {

       float f6 = this.swingProgress;
       this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.1415927F * 2.0F) * 0.2F;
       this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
       this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
       this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
       this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
       this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
       this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
       this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
       f6 = 1.0F - this.swingProgress;
       f6 *= f6;
       f6 *= f6;
       f6 = 1.0F - f6;
       float f7 = MathHelper.sin(f6 * 3.1415927F);
       float f8 = MathHelper.sin(this.swingProgress * 3.1415927F) * -(this.bipedHead.rotateAngleX - 0.7F) * 0.75F;
       this.bipedRightArm.rotateAngleX = (float)(this.bipedRightArm.rotateAngleX - f7 * 1.2D + f8);
       this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
       this.bipedRightArm.rotateAngleZ = MathHelper.sin(this.swingProgress * 3.1415927F) * -0.4F;
     }

     if (this.isSneak) {

       this.bipedBody.rotateAngleX = 0.5F;
       this.bipedRightArm.rotateAngleX += 0.4F;
       this.bipedLeftArm.rotateAngleX += 0.4F;
       this.bipedRightLeg.rotationPointZ = 4.0F;
       this.bipedLeftLeg.rotationPointZ = 4.0F;
       this.bipedRightLeg.rotationPointY = 9.0F;
       this.bipedLeftLeg.rotationPointY = 9.0F;
       this.bipedHead.rotationPointY = 1.0F;
       this.bipedHeadwear.rotationPointY = 1.0F;
     }
     else {

       this.bipedBody.rotateAngleX = 0.0F;
       this.bipedRightLeg.rotationPointZ = 0.1F;
       this.bipedLeftLeg.rotationPointZ = 0.1F;
       this.bipedRightLeg.rotationPointY = 12.0F;
       this.bipedLeftLeg.rotationPointY = 12.0F;
       this.bipedHead.rotationPointY = 0.0F;
       this.bipedHeadwear.rotationPointY = 0.0F;
     }

     this.bipedRightArm.rotateAngleZ += MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
     this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
     this.bipedRightArm.rotateAngleX += MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
     this.bipedLeftArm.rotateAngleX -= MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;

     if (this.aimedBow) {

       float f6 = 0.0F;
       float f7 = 0.0F;
       this.bipedRightArm.rotateAngleZ = 0.0F;
       this.bipedLeftArm.rotateAngleZ = 0.0F;
       this.bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F) + this.bipedHead.rotateAngleY;
       this.bipedLeftArm.rotateAngleY = 0.1F - f6 * 0.6F + this.bipedHead.rotateAngleY + 0.4F;
       this.bipedRightArm.rotateAngleX = -1.5707964F + this.bipedHead.rotateAngleX;
       this.bipedLeftArm.rotateAngleX = -1.5707964F + this.bipedHead.rotateAngleX;
       this.bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
       this.bipedLeftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
       this.bipedRightArm.rotateAngleZ += MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
       this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
       this.bipedRightArm.rotateAngleX += MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
       this.bipedLeftArm.rotateAngleX -= MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
     }
   }

   public void renderEars(float p_78110_1_) {
     this.bipedEars.rotateAngleY = this.bipedHead.rotateAngleY;
     this.bipedEars.rotateAngleX = this.bipedHead.rotateAngleX;
     this.bipedEars.rotationPointX = 0.0F;
     this.bipedEars.rotationPointY = 0.0F;
     this.bipedEars.render(p_78110_1_);
   }

   public void renderCloak(float p_78111_1_) {
/* 250 */     this.bipedCloak.render(p_78111_1_);
/*     */   }
 }
