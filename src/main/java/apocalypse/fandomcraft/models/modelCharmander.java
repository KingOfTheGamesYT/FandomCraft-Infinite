 package apocalypse.fandomcraft.models;

 import apocalypse.fandomcraft.entity.EntityCharmander;
 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;

 public class modelCharmander
   extends ModelBase
 {
   ModelRenderer RightFoot;
   ModelRenderer LeftFoot;
   ModelRenderer RightLeg;
   ModelRenderer LeftLeg;
   ModelRenderer Waist;
   ModelRenderer Tail1;
   ModelRenderer Tail2;
   ModelRenderer Tail3;
   ModelRenderer Body;
   ModelRenderer RightArm;
   ModelRenderer LeftArm;
   ModelRenderer Jaw;
   ModelRenderer Head;
   ModelRenderer Flame1;
   ModelRenderer Flame2;

   public modelCharmander() {
     this.textureWidth = 64;
     this.textureHeight = 128;

     this.RightFoot = new ModelRenderer(this, 0, 124);
     this.RightFoot.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 3);
     this.RightFoot.setRotationPoint(-2.0F, 23.0F, 1.0F);
     this.RightFoot.setTextureSize(64, 128);
     this.RightFoot.mirror = true;
     setRotation(this.RightFoot, 0.0F, 0.0F, 0.0F);
     this.LeftFoot = new ModelRenderer(this, 0, 124);
     this.LeftFoot.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 3);
     this.LeftFoot.setRotationPoint(2.0F, 23.0F, 1.0F);
     this.LeftFoot.setTextureSize(64, 128);
     this.LeftFoot.mirror = true;
     setRotation(this.LeftFoot, 0.0F, 0.0F, 0.0F);
     this.RightLeg = new ModelRenderer(this, 0, 117);
     this.RightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 4, 3);
     this.RightLeg.setRotationPoint(-2.0F, 19.0F, 0.5F);
     this.RightLeg.setTextureSize(64, 128);
     this.RightLeg.mirror = true;
     setRotation(this.RightLeg, 0.4363323F, 0.0F, 0.0F);
     this.LeftLeg = new ModelRenderer(this, 0, 117);
     this.LeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 4, 3);
     this.LeftLeg.setRotationPoint(2.0F, 19.0F, 0.5F);
     this.LeftLeg.setTextureSize(64, 128);
     this.LeftLeg.mirror = true;
     setRotation(this.LeftLeg, 0.4363323F, 0.0F, 0.0F);
     this.Waist = new ModelRenderer(this, 0, 103);
     this.Waist.addBox(-3.0F, 0.0F, -3.0F, 6, 9, 5);
     this.Waist.setRotationPoint(0.0F, 13.0F, 1.2F);
     this.Waist.setTextureSize(64, 128);
     this.Waist.mirror = true;
     setRotation(this.Waist, 0.2268928F, 0.0F, 0.0F);
     this.Tail1 = new ModelRenderer(this, 22, 107);
     this.Tail1.addBox(-2.0F, -1.0F, -1.0F, 4, 4, 6);
     this.Tail1.setRotationPoint(0.0F, 18.0F, 2.0F);
     this.Tail1.setTextureSize(64, 128);
     this.Tail1.mirror = true;
     setRotation(this.Tail1, -0.1745329F, 0.0F, 0.0F);
     this.Tail2 = new ModelRenderer(this, 22, 100);
     this.Tail2.addBox(-1.5F, -1.0F, -1.0F, 3, 3, 4);
     this.Tail2.setRotationPoint(0.0F, 19.0F, 7.0F);
     this.Tail2.setTextureSize(64, 128);
     this.Tail2.mirror = true;
     setRotation(this.Tail2, 0.296706F, 0.0F, 0.0F);
     this.Tail3 = new ModelRenderer(this, 22, 92);
     this.Tail3.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 6);
     this.Tail3.setRotationPoint(0.0F, 18.5F, 10.0F);
     this.Tail3.setTextureSize(64, 128);
     this.Tail3.mirror = true;
     setRotation(this.Tail3, 1.117011F, 0.0F, 0.0F);
     this.Body = new ModelRenderer(this, 0, 92);
     this.Body.addBox(-2.5F, 0.0F, -3.0F, 5, 7, 5);
     this.Body.setRotationPoint(0.0F, 9.0F, 2.0F);
     this.Body.setTextureSize(64, 128);
     this.Body.mirror = true;
     setRotation(this.Body, 0.0F, 0.0F, 0.0F);
     this.RightArm = new ModelRenderer(this, 0, 85);
     this.RightArm.addBox(-2.0F, -1.0F, -1.0F, 2, 5, 2);
     this.RightArm.setRotationPoint(-2.5F, 14.0F, 1.0F);
     this.RightArm.setTextureSize(64, 128);
     this.RightArm.mirror = true;
     setRotation(this.RightArm, -0.4363323F, 0.0F, 0.4363323F);
     this.LeftArm = new ModelRenderer(this, 0, 85);
     this.LeftArm.addBox(0.0F, -1.0F, -1.0F, 2, 5, 2);
     this.LeftArm.setRotationPoint(2.5F, 14.0F, 1.0F);
     this.LeftArm.setTextureSize(64, 128);
     this.LeftArm.mirror = true;
     setRotation(this.LeftArm, -0.4363323F, 0.0F, -0.4363323F);
     this.Jaw = new ModelRenderer(this, 0, 75);
     this.Jaw.addBox(-3.5F, 0.0F, -12.0F, 7, 4, 6);
     this.Jaw.setRotationPoint(0.0F, 5.0F, 9.0F);
     this.Jaw.setTextureSize(64, 128);
     this.Jaw.mirror = true;
     setRotation(this.Jaw, 0.1570796F, 0.0F, 0.0F);
     this.Head = new ModelRenderer(this, 0, 60);
     this.Head.addBox(-3.0F, -7.0F, -3.0F, 6, 8, 7);
     this.Head.setRotationPoint(0.0F, 8.0F, 0.7F);
     this.Head.setTextureSize(64, 128);
     this.Head.mirror = true;
     setRotation(this.Head, -0.0349066F, 0.0F, 0.0F);
     this.Flame1 = new ModelRenderer(this, 0, 0);
     this.Flame1.addBox(0.0F, -6.0F, -2.5F, 0, 6, 5);
     this.Flame1.setRotationPoint(0.0F, 14.5F, 12.0F);
     this.Flame1.setTextureSize(64, 128);
     this.Flame1.mirror = true;
     setRotation(this.Flame1, 0.0F, 0.0F, 0.0F);
     this.Flame1.mirror = false;
     this.Flame2 = new ModelRenderer(this, 0, 0);
     this.Flame2.addBox(0.0F, -6.0F, -2.5F, 0, 6, 5);
    this.Flame2.setRotationPoint(0.0F, 14.5F, 12.0F);
     this.Flame2.setTextureSize(64, 128);
     this.Flame2.mirror = true;
     setRotation(this.Flame2, 0.0F, 1.570796F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.RightFoot.render(f5);
     this.LeftFoot.render(f5);
     this.RightLeg.render(f5);
     this.LeftLeg.render(f5);
     this.Waist.render(f5);
     this.Tail1.render(f5);
     this.Tail2.render(f5);
     this.Tail3.render(f5);
     this.Body.render(f5);
     this.RightArm.render(f5);
   this.LeftArm.render(f5);
     this.Jaw.render(f5);
    this.Head.render(f5);
     this.Flame1.render(f5);
     this.Flame2.render(f5);
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
     EntityCharmander chu = (EntityCharmander)p_78086_1_;
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