 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelMew
   extends ModelBase
 {
   ModelRenderer Head;
   ModelRenderer Nose;
   ModelRenderer LeftEar;
   ModelRenderer RightEar;
   ModelRenderer Body;
   ModelRenderer Butt;
   ModelRenderer Neck;
   ModelRenderer RightLeg;
   ModelRenderer LeftLeg;
   ModelRenderer RightArm;
   ModelRenderer LeftArm;
   ModelRenderer Tail1;
   ModelRenderer Tail2;
   ModelRenderer Tail3;
   ModelRenderer RightFoot;
   ModelRenderer LeftFoot;

   public modelMew() {
     this.textureWidth = 64;
     this.textureHeight = 128;

     this.Head = new ModelRenderer(this, 0, 0);
     this.Head.addBox(-4.0F, -7.0F, -3.0F, 8, 7, 6);
     this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
     this.Head.setTextureSize(64, 128);
     this.Head.mirror = true;
     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
     this.Nose = new ModelRenderer(this, 12, 13);
     this.Nose.addBox(-2.0F, -1.0F, -2.0F, 4, 2, 2);
     this.Nose.setRotationPoint(0.0F, -0.5F, -1.5F);
     this.Nose.setTextureSize(64, 128);
     this.Nose.mirror = true;
     setRotation(this.Nose, 0.0F, 0.0F, 0.0F);
     this.LeftEar = new ModelRenderer(this, 0, 13);
     this.LeftEar.addBox(-2.0F, -3.0F, 0.0F, 4, 4, 2);
     this.LeftEar.setRotationPoint(2.5F, -5.5F, 0.0F);
     this.LeftEar.setTextureSize(64, 128);
     this.LeftEar.mirror = true;
     setRotation(this.LeftEar, 0.0F, 0.2268928F, 0.7853982F);
     this.RightEar = new ModelRenderer(this, 0, 13);
     this.RightEar.addBox(-4.0F, -2.0F, 0.0F, 4, 4, 2);
     this.RightEar.setRotationPoint(-2.0F, -5.0F, 0.0F);
     this.RightEar.setTextureSize(64, 128);
     this.RightEar.mirror = true;
     setRotation(this.RightEar, 0.0F, -0.2268928F, 0.7853982F);
     this.Body = new ModelRenderer(this, 28, 0);
     this.Body.addBox(-2.5F, 0.0F, -2.0F, 5, 10, 4);
     this.Body.setRotationPoint(0.0F, 1.0F, 1.0F);
     this.Body.setTextureSize(64, 128);
     this.Body.mirror = true;
     setRotation(this.Body, 0.122173F, 0.0F, 0.0F);
     this.Butt = new ModelRenderer(this, 0, 19);
     this.Butt.addBox(-3.0F, 0.0F, -2.5F, 6, 6, 5);
     this.Butt.setRotationPoint(0.0F, 5.0F, 1.4F);
     this.Butt.setTextureSize(64, 128);
     this.Butt.mirror = true;
     setRotation(this.Butt, 0.1745329F, 0.0F, 0.0F);
     this.Neck = new ModelRenderer(this, 46, 0);
     this.Neck.addBox(-2.0F, -1.0F, -1.5F, 4, 3, 3);
     this.Neck.setRotationPoint(0.0F, 0.0F, 1.0F);
     this.Neck.setTextureSize(64, 128);
     this.Neck.mirror = true;
     setRotation(this.Neck, 0.122173F, 0.0F, 0.0F);
     this.RightLeg = new ModelRenderer(this, 36, 14);
     this.RightLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 4, 4);
     this.RightLeg.setRotationPoint(-1.5F, 8.0F, 0.5F);
     this.RightLeg.setTextureSize(64, 128);
     this.RightLeg.mirror = true;
     setRotation(this.RightLeg, 0.2094395F, 0.0F, 0.0F);
     this.LeftLeg = new ModelRenderer(this, 36, 14);
     this.LeftLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 4, 4);
     this.LeftLeg.setRotationPoint(1.5F, 8.0F, 0.5F);
     this.LeftLeg.setTextureSize(64, 128);
     this.LeftLeg.mirror = true;
     setRotation(this.LeftLeg, 0.2094395F, 0.0F, 0.0F);
     this.RightArm = new ModelRenderer(this, 0, 30);
     this.RightArm.addBox(-2.0F, 0.0F, -1.0F, 2, 5, 2);
     this.RightArm.setRotationPoint(-2.0F, 2.0F, 0.0F);
     this.RightArm.setTextureSize(64, 128);
     this.RightArm.mirror = true;
     setRotation(this.RightArm, -0.3316126F, 0.0F, 0.2443461F);
     this.LeftArm = new ModelRenderer(this, 0, 30);
     this.LeftArm.addBox(0.0F, 0.0F, -1.0F, 2, 5, 2);
     this.LeftArm.setRotationPoint(2.0F, 2.0F, 0.0F);
     this.LeftArm.setTextureSize(64, 128);
     this.LeftArm.mirror = true;
     setRotation(this.RightArm, -0.3316126F, 0.0F, -0.2443461F);
     this.Tail1 = new ModelRenderer(this, 22, 14);
     this.Tail1.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 12);
     this.Tail1.setRotationPoint(0.0F, 9.0F, 3.0F);
     this.Tail1.setTextureSize(64, 128);
     this.Tail1.mirror = true;
     setRotation(this.Tail1, 0.715585F, -0.9948377F, 0.0F);
     this.Tail2 = new ModelRenderer(this, 16, 14);
     this.Tail2.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 18);
     this.Tail2.setRotationPoint(-8.0F, 1.5F, 8.0F);
     this.Tail2.setTextureSize(64, 128);
     this.Tail2.mirror = true;
     setRotation(this.Tail2, 2.565634F, -1.919862F, 0.0F);
     this.Tail3 = new ModelRenderer(this, 46, 6);
     this.Tail3.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 6);
     this.Tail3.setRotationPoint(6.0F, -9.0F, 13.0F);
     this.Tail3.setTextureSize(64, 128);
     this.Tail3.mirror = true;
     setRotation(this.Tail3, 2.565634F, -1.919862F, 0.0F);
     this.RightFoot = new ModelRenderer(this, 0, 0);
     this.RightFoot.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 1);
     this.RightFoot.setRotationPoint(-2.0F, 11.0F, 2.0F);
     this.RightFoot.setTextureSize(64, 128);
     this.RightFoot.mirror = true;
     setRotation(this.RightFoot, 0.0F, 0.0F, 0.0F);
     this.LeftFoot = new ModelRenderer(this, 0, 0);
     this.LeftFoot.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 1);
     this.LeftFoot.setRotationPoint(2.0F, 11.0F, 2.0F);
     this.LeftFoot.setTextureSize(64, 128);
     this.LeftFoot.mirror = true;
     setRotation(this.LeftFoot, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Head.render(f5);
     this.Nose.render(f5);
     this.LeftEar.render(f5);
     this.RightEar.render(f5);
     this.Body.render(f5);
     this.Butt.render(f5);
     this.Neck.render(f5);
     this.RightLeg.render(f5);
     this.LeftLeg.render(f5);
     this.RightArm.render(f5);
     this.LeftArm.render(f5);
     this.Tail1.render(f5);
     this.Tail2.render(f5);
     this.Tail3.render(f5);
     this.RightFoot.render(f5);
     this.LeftFoot.render(f5);
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
     this.RightLeg.rotateAngleX = this.RightLeg.rotateAngleX;
     this.RightLeg.rotateAngleY = this.RightLeg.rotateAngleY;
     this.LeftLeg.rotateAngleX = this.LeftLeg.rotateAngleX;
     this.LeftLeg.rotateAngleY = this.LeftLeg.rotateAngleY;
   }

   private float func_78172_a(float p_78172_1_, float p_78172_2_) {
     return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / p_78172_2_ * 0.25F;
   }
 }