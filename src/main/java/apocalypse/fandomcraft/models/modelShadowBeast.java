 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelShadowBeast
   extends ModelBase
 {
   ModelRenderer Headwear;
   ModelRenderer Headwear2;
   ModelRenderer Headwear3;
   ModelRenderer Body;
   ModelRenderer RightArm;
   ModelRenderer LeftArm;
   ModelRenderer RightLeg;
   ModelRenderer LeftLeg;
   ModelRenderer Tentacles1;

   public modelShadowBeast() {
     this.textureWidth = 64;
     this.textureHeight = 32;

     this.Headwear = new ModelRenderer(this, 0, 16);
     this.Headwear.addBox(-7.0F, -7.0F, -2.0F, 14, 14, 2);
     this.Headwear.setRotationPoint(0.0F, 4.0F, -6.0F);
     this.Headwear.setTextureSize(64, 32);
     this.Headwear.mirror = true;
     setRotation(this.Headwear, -0.2268928F, 0.0F, 0.0F);
     this.Headwear2 = new ModelRenderer(this, 12, 0);
     this.Headwear2.addBox(-6.0F, -6.0F, -2.0F, 6, 6, 2);
     this.Headwear2.setRotationPoint(-3.0F, 0.0F, -5.1F);
     this.Headwear2.setTextureSize(64, 32);
     this.Headwear2.mirror = true;
     setRotation(this.Headwear2, -0.2268928F, 0.0F, 0.0F);
     this.Headwear3 = new ModelRenderer(this, 12, 8);
     this.Headwear3.addBox(0.0F, -6.0F, -2.0F, 6, 6, 2);
     this.Headwear3.setRotationPoint(3.0F, 0.0F, -5.1F);
     this.Headwear3.setTextureSize(64, 32);
     this.Headwear3.mirror = true;
     setRotation(this.Headwear3, -0.2268928F, 0.0F, 0.0F);
     this.Body = new ModelRenderer(this, 32, 16);
     this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
     this.Body.setRotationPoint(0.0F, 1.0F, -5.0F);
     this.Body.setTextureSize(64, 32);
     this.Body.mirror = true;
     setRotation(this.Body, 0.418879F, 0.0F, 0.0F);
     this.RightArm = new ModelRenderer(this, 0, 0);
     this.RightArm.addBox(-3.0F, -2.0F, -1.5F, 3, 13, 3);
     this.RightArm.setRotationPoint(-4.0F, 7.0F, -2.0F);
     this.RightArm.setTextureSize(64, 32);
     this.RightArm.mirror = true;
     setRotation(this.RightArm, -0.1745329F, 0.0F, 0.122173F);
     this.LeftArm = new ModelRenderer(this, 0, 0);
     this.LeftArm.addBox(0.0F, -2.0F, -1.5F, 3, 13, 3);
     this.LeftArm.setRotationPoint(4.0F, 7.0F, -2.0F);
     this.LeftArm.setTextureSize(64, 32);
     this.LeftArm.mirror = true;
     setRotation(this.LeftArm, -0.1745329F, 0.0F, -0.122173F);
     this.LeftArm.mirror = false;
     this.RightLeg = new ModelRenderer(this, 0, 0);
     this.RightLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 13, 3);
     this.RightLeg.setRotationPoint(-2.0F, 11.0F, 0.0F);
     this.RightLeg.setTextureSize(64, 32);
     this.RightLeg.mirror = true;
     setRotation(this.RightLeg, 0.0F, 0.0F, 0.0F);
     this.LeftLeg = new ModelRenderer(this, 0, 0);
     this.LeftLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 13, 3);
     this.LeftLeg.setRotationPoint(2.0F, 11.0F, 0.0F);
     this.LeftLeg.setTextureSize(64, 32);
     this.LeftLeg.mirror = true;
     setRotation(this.LeftLeg, 0.0F, 0.0F, 0.0F);
     this.Tentacles1 = new ModelRenderer(this, 32, 0);
     this.Tentacles1.addBox(-6.0F, -8.0F, 0.0F, 12, 9, 4);
     this.Tentacles1.setRotationPoint(0.0F, -3.0F, -5.0F);
     this.Tentacles1.setTextureSize(64, 32);
     this.Tentacles1.mirror = true;
     setRotation(this.Tentacles1, -0.5410521F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Headwear.render(f5);
     this.Headwear2.render(f5);
     this.Headwear3.render(f5);
     this.Body.render(f5);
     this.RightArm.render(f5);
     this.LeftArm.render(f5);
     this.RightLeg.render(f5);
     this.LeftLeg.render(f5);
     this.Tentacles1.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
     model.rotateAngleX = x;
     model.rotateAngleY = y;
     model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
     super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Headwear.rotateAngleY = f3 / 57.295776F;
     this.Headwear.rotateAngleX = f4 / 57.295776F;
     this.Headwear2.rotateAngleY = f3 / 57.295776F;
     this.Headwear2.rotateAngleX = f4 / 57.295776F;
     this.Headwear3.rotateAngleY = f3 / 57.295776F;
     this.Headwear3.rotateAngleX = f4 / 57.295776F;
     this.Tentacles1.rotateAngleY = f3 / 57.295776F;
     this.Tentacles1.rotateAngleX = f4 / 57.295776F;
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