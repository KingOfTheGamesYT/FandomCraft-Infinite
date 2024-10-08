 package apocalypse.fandomcraft.models;

 import apocalypse.fandomcraft.entity.EntityWolfos;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.util.MathHelper;
 import org.lwjgl.opengl.GL11;

 @SideOnly(Side.CLIENT)
 public class modelWolfos
   extends ModelBase
 {
   public ModelRenderer wolfHeadMain;
   public ModelRenderer wolfBody;
   public ModelRenderer wolfLeg1;
   public ModelRenderer wolfLeg2;
   public ModelRenderer wolfLeg3;
   public ModelRenderer wolfLeg4;
   ModelRenderer wolfTail;
   ModelRenderer wolfMane;
   private static final String __OBFID = "CL_00000868";

   public modelWolfos() {
     float f = 0.0F;
     float f1 = 13.5F;
     this.wolfHeadMain = new ModelRenderer(this, 0, 0);
     this.wolfHeadMain.addBox(-3.0F, -3.0F, -2.0F, 6, 6, 4, f);
     this.wolfHeadMain.setRotationPoint(-1.0F, f1, -7.0F);
     this.wolfBody = new ModelRenderer(this, 18, 14);
     this.wolfBody.addBox(-4.0F, -2.0F, -3.0F, 6, 9, 6, f);
     this.wolfBody.setRotationPoint(0.0F, 14.0F, 2.0F);
     this.wolfMane = new ModelRenderer(this, 21, 0);
     this.wolfMane.addBox(-4.0F, -3.0F, -3.0F, 8, 6, 7, f);
     this.wolfMane.setRotationPoint(-1.0F, 14.0F, 2.0F);
     this.wolfLeg1 = new ModelRenderer(this, 0, 18);
     this.wolfLeg1.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
     this.wolfLeg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
     this.wolfLeg2 = new ModelRenderer(this, 0, 18);
     this.wolfLeg2.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
     this.wolfLeg2.setRotationPoint(0.5F, 16.0F, 7.0F);
     this.wolfLeg3 = new ModelRenderer(this, 0, 18);
     this.wolfLeg3.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
     this.wolfLeg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
     this.wolfLeg4 = new ModelRenderer(this, 0, 18);
     this.wolfLeg4.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
     this.wolfLeg4.setRotationPoint(0.5F, 16.0F, -4.0F);
     this.wolfTail = new ModelRenderer(this, 9, 18);
     this.wolfTail.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
     this.wolfTail.setRotationPoint(-1.0F, 12.0F, 8.0F);
     this.wolfHeadMain.setTextureOffset(16, 14).addBox(-3.0F, -5.0F, 0.0F, 2, 2, 1, f);
     this.wolfHeadMain.setTextureOffset(16, 14).addBox(1.0F, -5.0F, 0.0F, 2, 2, 1, f);
     this.wolfHeadMain.setTextureOffset(0, 10).addBox(-1.5F, 0.0F, -5.0F, 3, 3, 4, f);
   }

   public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
     super.render(p_78088_1_, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
     setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);

     if (this.isChild) {

       float f6 = 2.0F;
       GL11.glPushMatrix();
       GL11.glTranslatef(0.0F, 5.0F * p_78088_7_, 2.0F * p_78088_7_);
       this.wolfHeadMain.renderWithRotation(p_78088_7_);
       GL11.glPopMatrix();
       GL11.glPushMatrix();
       GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
       GL11.glTranslatef(0.0F, 24.0F * p_78088_7_, 0.0F);
       this.wolfBody.render(p_78088_7_);
       this.wolfLeg1.render(p_78088_7_);
       this.wolfLeg2.render(p_78088_7_);
       this.wolfLeg3.render(p_78088_7_);
       this.wolfLeg4.render(p_78088_7_);
       this.wolfTail.renderWithRotation(p_78088_7_);
       this.wolfMane.render(p_78088_7_);
       GL11.glPopMatrix();
     }
     else {

       this.wolfHeadMain.renderWithRotation(p_78088_7_);
       this.wolfBody.render(p_78088_7_);
       this.wolfLeg1.render(p_78088_7_);
       this.wolfLeg2.render(p_78088_7_);
       this.wolfLeg3.render(p_78088_7_);
       this.wolfLeg4.render(p_78088_7_);
       this.wolfTail.renderWithRotation(p_78088_7_);
       this.wolfMane.render(p_78088_7_);
     }
   }

   public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
     EntityWolfos entitywolf = (EntityWolfos)p_78086_1_;

     this.wolfTail.rotateAngleY = 0.0F;
     this.wolfBody.setRotationPoint(0.0F, 14.0F, 2.0F);
     this.wolfBody.rotateAngleX = 1.5707964F;
     this.wolfMane.setRotationPoint(-1.0F, 14.0F, -3.0F);
     this.wolfMane.rotateAngleX = this.wolfBody.rotateAngleX;
     this.wolfTail.setRotationPoint(-1.0F, 12.0F, 8.0F);
     this.wolfLeg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
     this.wolfLeg2.setRotationPoint(0.5F, 16.0F, 7.0F);
     this.wolfLeg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
     this.wolfLeg4.setRotationPoint(0.5F, 16.0F, -4.0F);
     this.wolfLeg1.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
     this.wolfLeg2.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F + 3.1415927F) * 1.4F * p_78086_3_;
     this.wolfLeg3.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F + 3.1415927F) * 1.4F * p_78086_3_;
     this.wolfLeg4.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
   }

   public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
     super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
     this.wolfHeadMain.rotateAngleX = p_78087_5_ / 57.295776F;
     this.wolfHeadMain.rotateAngleY = p_78087_4_ / 57.295776F;
     this.wolfTail.rotateAngleX = p_78087_3_;
   }
 }