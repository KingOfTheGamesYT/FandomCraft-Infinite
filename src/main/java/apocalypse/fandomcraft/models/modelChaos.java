 package apocalypse.fandomcraft.models;

 import apocalypse.fandomcraft.entity.EntityChaosBoss;
 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;

 public class modelChaos
   extends ModelBase
 {
   ModelRenderer Head;
   ModelRenderer Headwear;
   ModelRenderer Body;
   ModelRenderer RightArm;
   ModelRenderer LeftArm;
   ModelRenderer RightLeg;
   ModelRenderer LeftLeg;
   ModelRenderer HeadwearLeft;
   ModelRenderer HeadwearRight;

   public modelChaos() {
     this.textureWidth = 64;
     this.textureHeight = 64;

     this.Head = new ModelRenderer(this, 0, 0);
     this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
     this.Head.setRotationPoint(0.0F, 0.0F, -2.0F);
     this.Head.setTextureSize(64, 64);
     this.Head.mirror = true;
     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
     this.Headwear = new ModelRenderer(this, 0, 31);
     this.Headwear.addBox(-3.0F, -3.0F, 0.0F, 6, 8, 14);
     this.Headwear.setRotationPoint(0.0F, -5.0F, -4.0F);
     this.Headwear.setTextureSize(64, 64);
     this.Headwear.mirror = true;
     setRotation(this.Headwear, 0.6981317F, 0.0F, 0.0F);
     this.HeadwearLeft = new ModelRenderer(this, 0, 16);
     this.HeadwearLeft.addBox(-2.0F, -2.0F, 0.0F, 5, 5, 10);
     this.HeadwearLeft.setRotationPoint(0.0F, -7.5F, 1.0F);
     this.HeadwearLeft.setTextureSize(64, 64);
     this.HeadwearLeft.mirror = true;
     setRotation(this.HeadwearLeft, -0.6981317F, 0.4363323F, 0.0F);
     this.HeadwearRight = new ModelRenderer(this, 0, 16);
     this.HeadwearRight.addBox(-2.5F, -2.0F, 0.0F, 5, 5, 10);
     this.HeadwearRight.setRotationPoint(-0.3F, -7.2F, 1.0F);
     this.HeadwearRight.setTextureSize(64, 64);
     this.HeadwearRight.mirror = true;
     setRotation(this.HeadwearRight, -0.6981317F, -0.4363323F, 0.0F);
     this.Body = new ModelRenderer(this, 30, 15);
     this.Body.addBox(-4.0F, 0.0F, -2.0F, 6, 12, 4);
     this.Body.setRotationPoint(1.0F, -0.5F, 0.0F);
     this.Body.setTextureSize(64, 64);
     this.Body.mirror = true;
     setRotation(this.Body, 0.0F, 0.0F, 0.0F);
     this.RightArm = new ModelRenderer(this, 48, 27);
     this.RightArm.addBox(-1.0F, -2.0F, -1.0F, 4, 23, 4);
     this.RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
     this.RightArm.setTextureSize(64, 64);
     this.RightArm.mirror = true;
     setRotation(this.RightArm, -0.2617994F, 0.0F, 0.2617994F);
     this.LeftArm = new ModelRenderer(this, 48, 27);
     this.LeftArm.addBox(-1.0F, -2.0F, -1.0F, 4, 23, 4);
     this.LeftArm.setRotationPoint(3.0F, 2.5F, 0.0F);
     this.LeftArm.setTextureSize(64, 64);
     this.LeftArm.mirror = true;
     setRotation(this.LeftArm, -0.2617994F, 0.0F, -0.2617994F);
     this.RightLeg = new ModelRenderer(this, 52, 0);
     this.RightLeg.addBox(-1.0F, 0.0F, -1.0F, 3, 14, 3);
     this.RightLeg.setRotationPoint(-2.5F, 10.0F, 0.0F);
     this.RightLeg.setTextureSize(64, 64);
     this.RightLeg.mirror = true;
     setRotation(this.RightLeg, 0.0F, 0.0F, 0.0F);
     this.LeftLeg = new ModelRenderer(this, 52, 0);
     this.LeftLeg.addBox(-1.0F, 0.0F, -1.0F, 3, 14, 3);
     this.LeftLeg.setRotationPoint(1.5F, 10.0F, 0.0F);
     this.LeftLeg.setTextureSize(64, 64);
     this.LeftLeg.mirror = true;
     setRotation(this.LeftLeg, 0.0F, 0.0F, 0.0F);
     this.LeftLeg.mirror = false;
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Head.render(f5);
     this.HeadwearLeft.render(f5);
     this.HeadwearLeft.render(f5);
     this.Headwear.render(f5);
     this.Body.render(f5);
     this.RightArm.render(f5);
     this.LeftArm.render(f5);
     this.RightLeg.render(f5);
     this.LeftLeg.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
     model.rotateAngleX = x;
     model.rotateAngleY = y;
     model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
     super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Head.rotateAngleY = f3 / 57.295776F;
     this.Head.rotateAngleX = f4 / 57.295776F;
     this.Headwear.rotateAngleX = this.Head.rotateAngleX;
     this.HeadwearRight.rotateAngleX = this.Head.rotateAngleX;
     this.HeadwearLeft.rotateAngleX = this.Head.rotateAngleX;
     this.LeftLeg.rotateAngleX = -1.5F * func_78172_a(f, 13.0F) * f1;
     this.RightLeg.rotateAngleX = 1.5F * func_78172_a(f, 13.0F) * f1;
     this.LeftLeg.rotateAngleY = 0.0F;
     this.RightLeg.rotateAngleY = 0.0F;
   }

   public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
     EntityChaosBoss entitychaos = (EntityChaosBoss)p_78086_1_;
     int i = entitychaos.getAttackTimer();

     if (i > 0) {

       this.RightArm.rotateAngleX = -2.0F + 1.5F * func_78172_a(i - p_78086_4_, 10.0F);
       this.LeftArm.rotateAngleX = -2.0F + 1.5F * func_78172_a(i - p_78086_4_, 10.0F);
     }
     else {

       this.RightArm.rotateAngleX = (-0.2F + 1.5F * func_78172_a(p_78086_2_, 13.0F)) * p_78086_3_;
       this.LeftArm.rotateAngleX = (-0.2F - 1.5F * func_78172_a(p_78086_2_, 13.0F)) * p_78086_3_;
     }
   }

   private float func_78172_a(float p_78172_1_, float p_78172_2_) {
     return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / p_78172_2_ * 0.25F;
   }
 }
