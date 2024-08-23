 package apocalypse.fandomcraft.models;

 import apocalypse.fandomcraft.entity.EntityPikachu;
 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;

 public class modelPikachu
   extends ModelBase
 {
   ModelRenderer RightEar;
   ModelRenderer LeftEar;
   ModelRenderer Head;
   ModelRenderer RightArm;
   ModelRenderer LeftArm;
   ModelRenderer Body;
   ModelRenderer RightLeg;
   ModelRenderer LeftLeg;
   ModelRenderer RightFoot;
   ModelRenderer LeftFoot;
   ModelRenderer Tail1;
   ModelRenderer Tail2;
   ModelRenderer Tail3;
   ModelRenderer Tail4;
   ModelRenderer Tail5;
   ModelRenderer Tail6;

   public modelPikachu() {
     this.textureWidth = 256;
     this.textureHeight = 64;

     this.RightEar = new ModelRenderer(this, 220, 0);
     this.RightEar.addBox(-2.0F, -14.0F, -2.0F, 4, 18, 5);
     this.RightEar.setRotationPoint(-7.0F, -20.0F, -1.0F);
     this.RightEar.setTextureSize(256, 64);
     this.RightEar.mirror = true;
     setRotation(this.RightEar, -0.2617994F, 0.0F, -0.2617994F);
     this.LeftEar = new ModelRenderer(this, 238, 0);
     this.LeftEar.addBox(-2.0F, -14.0F, -2.0F, 4, 18, 5);
     this.LeftEar.setRotationPoint(9.0F, -18.0F, -1.0F);
     this.LeftEar.setTextureSize(256, 64);
     this.LeftEar.mirror = true;
     setRotation(this.LeftEar, -0.2617994F, 0.0F, 0.9599311F);
     this.Head = new ModelRenderer(this, 2, 28);
     this.Head.addBox(-9.0F, -18.0F, -9.0F, 18, 18, 18);
     this.Head.setRotationPoint(0.0F, 0.0F, -5.0F);
     this.Head.setTextureSize(256, 64);
     this.Head.mirror = true;
     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
     this.RightArm = new ModelRenderer(this, 0, 33);
     this.RightArm.addBox(-5.0F, 0.0F, -2.5F, 5, 8, 5);
     this.RightArm.setRotationPoint(-5.0F, 2.0F, -7.0F);
     this.RightArm.setTextureSize(256, 64);
     this.RightArm.mirror = true;
     setRotation(this.RightArm, -0.2443461F, 0.0F, -0.3490659F);
     this.LeftArm = new ModelRenderer(this, 56, 33);
     this.LeftArm.addBox(0.0F, 0.0F, -2.5F, 5, 8, 5);
     this.LeftArm.setRotationPoint(5.0F, 2.0F, -7.0F);
     this.LeftArm.setTextureSize(256, 64);
     this.LeftArm.mirror = true;
     setRotation(this.LeftArm, -0.2443461F, 0.0F, 0.3490659F);
     this.Body = new ModelRenderer(this, 196, 28);
     this.Body.addBox(-8.0F, -12.0F, -7.0F, 16, 22, 14);
     this.Body.setRotationPoint(0.0F, 10.0F, 1.0F);
     this.Body.setTextureSize(256, 64);
     this.Body.mirror = true;
     setRotation(this.Body, 0.2443461F, 0.0F, 0.0F);
     this.RightLeg = new ModelRenderer(this, 74, 45);
     this.RightLeg.addBox(-4.0F, 0.0F, -6.0F, 8, 9, 10);
     this.RightLeg.setRotationPoint(5.0F, 13.0F, 0.0F);
     this.RightLeg.setTextureSize(256, 64);
     this.RightLeg.mirror = true;
     setRotation(this.RightLeg, 0.2094395F, 0.0F, 0.0F);
     this.LeftLeg = new ModelRenderer(this, 110, 45);
     this.LeftLeg.addBox(-4.0F, 0.0F, -6.0F, 8, 9, 10);
     this.LeftLeg.setRotationPoint(-5.0F, 13.0F, 0.0F);
     this.LeftLeg.setTextureSize(256, 64);
     this.LeftLeg.mirror = true;
     setRotation(this.LeftLeg, 0.2094395F, 0.0F, 0.0F);
     this.RightFoot = new ModelRenderer(this, 0, 0);
     this.RightFoot.addBox(-3.0F, 0.0F, -5.0F, 6, 3, 8);
     this.RightFoot.setRotationPoint(5.0F, 21.0F, -1.0F);
     this.RightFoot.setTextureSize(256, 64);
     this.RightFoot.mirror = true;
     setRotation(this.RightFoot, 0.0F, 0.0F, 0.0F);
     this.LeftFoot = new ModelRenderer(this, 0, 11);
     this.LeftFoot.addBox(-3.0F, 0.0F, -5.0F, 6, 3, 8);
     this.LeftFoot.setRotationPoint(-5.0F, 21.0F, -1.0F);
     this.LeftFoot.setTextureSize(256, 64);
     this.LeftFoot.mirror = true;
     setRotation(this.LeftFoot, 0.0F, 0.0F, 0.0F);
     this.Tail1 = new ModelRenderer(this, 26, 0);
     this.Tail1.addBox(0.0F, -1.0F, 0.0F, 1, 4, 13);
     this.Tail1.setRotationPoint(0.0F, 13.0F, 7.0F);
     this.Tail1.setTextureSize(256, 64);
     this.Tail1.mirror = true;
     setRotation(this.Tail1, 0.5235988F, 0.0F, 0.0F);
     this.Tail2 = new ModelRenderer(this, 41, 2);
     this.Tail2.addBox(0.0F, 0.0F, 0.0F, 1, 7, 4);
     this.Tail2.setRotationPoint(0.0F, 2.0F, 11.0F);
     this.Tail2.setTextureSize(256, 64);
     this.Tail2.mirror = true;
     setRotation(this.Tail2, 0.5235988F, 0.0F, 0.0F);
     this.Tail3 = new ModelRenderer(this, 54, 0);
     this.Tail3.addBox(0.0F, 0.0F, 0.0F, 1, 5, 12);
     this.Tail3.setRotationPoint(0.0F, 1.0F, 10.0F);
     this.Tail3.setTextureSize(256, 64);
     this.Tail3.mirror = true;
     setRotation(this.Tail3, 0.6806784F, 0.0F, 0.0F);
     this.Tail4 = new ModelRenderer(this, 80, 0);
     this.Tail4.addBox(0.0F, 0.0F, 0.0F, 1, 9, 5);
     this.Tail4.setRotationPoint(0.0F, -10.0F, 10.0F);
     this.Tail4.setTextureSize(256, 64);
     this.Tail4.mirror = true;
     setRotation(this.Tail4, 0.6981317F, 0.0F, 0.0F);
     this.Tail5 = new ModelRenderer(this, 92, 0);
     this.Tail5.addBox(0.0F, 0.0F, 0.0F, 1, 5, 17);
     this.Tail5.setRotationPoint(0.0F, -11.0F, 10.0F);
     this.Tail5.setTextureSize(256, 64);
     this.Tail5.mirror = true;
     setRotation(this.Tail5, 0.5235988F, 0.0F, 0.0F);
     this.Tail6 = new ModelRenderer(this, 92, 0);
     this.Tail6.addBox(0.0F, -2.0F, 0.0F, 1, 5, 17);
     this.Tail6.setRotationPoint(0.0F, -9.0F, 11.0F);
     this.Tail6.setTextureSize(256, 64);
     this.Tail6.mirror = true;
     setRotation(this.Tail6, 0.8203047F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.RightEar.render(f5);
     this.LeftEar.render(f5);
     this.Head.render(f5);
     this.RightArm.render(f5);
     this.LeftArm.render(f5);
     this.Body.render(f5);
     this.RightLeg.render(f5);
    this.LeftLeg.render(f5);
     this.RightFoot.render(f5);
     this.LeftFoot.render(f5);
     this.Tail1.render(f5);
     this.Tail2.render(f5);
     this.Tail3.render(f5);
     this.Tail4.render(f5);
     this.Tail5.render(f5);
     this.Tail6.render(f5);
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
     this.RightEar.rotateAngleX = this.Head.rotateAngleX;
     this.RightEar.rotateAngleY = this.Head.rotateAngleY;
     this.LeftEar.rotateAngleX = this.Head.rotateAngleX;
     this.LeftEar.rotateAngleY = this.Head.rotateAngleY;
     this.LeftLeg.rotateAngleX = -1.5F * func_78172_a(f, 13.0F) * f1;
     this.RightLeg.rotateAngleX = 1.5F * func_78172_a(f, 13.0F) * f1;
     this.LeftLeg.rotateAngleY = 0.0F;
     this.RightLeg.rotateAngleY = 0.0F;
     this.RightFoot.rotateAngleX = this.RightLeg.rotateAngleX;
     this.RightFoot.rotateAngleY = this.RightLeg.rotateAngleY;
     this.LeftFoot.rotateAngleX = this.LeftLeg.rotateAngleX;
     this.LeftFoot.rotateAngleY = this.LeftLeg.rotateAngleY;
   }

   public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
     EntityPikachu chu = (EntityPikachu)p_78086_1_;
     int i = chu.getAttackTimer();

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