 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelTektite
   extends ModelBase
 {
   ModelRenderer Eye;
   ModelRenderer Eyelid;
   ModelRenderer Body;
   ModelRenderer Leg7;
   ModelRenderer Leg5;
   ModelRenderer Leg3;
   ModelRenderer Leg1;
   ModelRenderer Leg2;
   ModelRenderer Leg4;
   ModelRenderer Leg6;
   ModelRenderer Leg8;
   ModelRenderer PincerL;
   ModelRenderer PincerR;

   public modelTektite() {
     this.textureWidth = 64;
     this.textureHeight = 32;

     this.Eye = new ModelRenderer(this, 0, 12);
     this.Eye.addBox(-1.5F, -1.5F, -1.0F, 3, 3, 2);
     this.Eye.setRotationPoint(0.0F, 17.5F, -2.3F);
     this.Eye.setTextureSize(64, 32);
     this.Eye.mirror = true;
     setRotation(this.Eye, 0.0F, 0.0F, 0.0F);
     this.Eyelid = new ModelRenderer(this, 0, 6);
     this.Eyelid.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 2);
     this.Eyelid.setRotationPoint(0.0F, 17.5F, -1.6F);
     this.Eyelid.setTextureSize(64, 32);
     this.Eyelid.mirror = true;
     setRotation(this.Eyelid, 0.0F, 0.0F, 0.0F);
     this.Body = new ModelRenderer(this, 18, 14);
     this.Body.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6);
     this.Body.setRotationPoint(0.0F, 17.0F, 0.0F);
     this.Body.setTextureSize(64, 32);
     this.Body.mirror = true;
     setRotation(this.Body, 0.0F, 0.0F, 0.0F);
     this.Leg7 = new ModelRenderer(this, 18, 0);
     this.Leg7.addBox(-5.0F, -1.0F, -1.0F, 6, 1, 1);
     this.Leg7.setRotationPoint(-4.0F, 18.0F, -1.0F);
     this.Leg7.setTextureSize(64, 32);
     this.Leg7.mirror = true;
     setRotation(this.Leg7, 0.0F, -0.3839724F, 0.6981317F);
     this.Leg5 = new ModelRenderer(this, 18, 0);
     this.Leg5.addBox(-11.0F, -1.0F, -1.0F, 10, 1, 1);
     this.Leg5.setRotationPoint(-6.0F, 14.0F, -2.0F);
     this.Leg5.setTextureSize(64, 32);
     this.Leg5.mirror = true;
     setRotation(this.Leg5, 0.0F, -0.2792527F, -1.22173F);
     this.Leg3 = new ModelRenderer(this, 18, 0);
     this.Leg3.addBox(-5.0F, -1.0F, 0.0F, 6, 1, 1);
     this.Leg3.setRotationPoint(-4.0F, 18.0F, 1.0F);
     this.Leg3.setTextureSize(64, 32);
     this.Leg3.mirror = true;
     setRotation(this.Leg3, 0.0F, 0.4712389F, 0.715585F);
     this.Leg1 = new ModelRenderer(this, 18, 0);
     this.Leg1.addBox(-10.0F, -1.0F, -1.0F, 10, 1, 1);
     this.Leg1.setRotationPoint(-6.0F, 15.0F, 3.0F);
     this.Leg1.setTextureSize(64, 32);
     this.Leg1.mirror = true;
     setRotation(this.Leg1, 0.0F, 0.5759587F, -1.22173F);
     this.Leg2 = new ModelRenderer(this, 18, 0);
     this.Leg2.addBox(-11.0F, 0.0F, -1.0F, 10, 1, 1);
     this.Leg2.setRotationPoint(6.0F, 14.0F, -2.0F);
     this.Leg2.setTextureSize(64, 32);
     this.Leg2.mirror = true;
     setRotation(this.Leg2, 0.0F, 0.2792527F, -1.919862F);
     this.Leg4 = new ModelRenderer(this, 18, 0);
     this.Leg4.addBox(0.0F, 0.0F, -1.0F, 6, 1, 1);
     this.Leg4.setRotationPoint(2.5F, 18.0F, -1.0F);
     this.Leg4.setTextureSize(64, 32);
     this.Leg4.mirror = true;
     setRotation(this.Leg4, 0.0F, 0.2792527F, -0.6981317F);
     this.Leg6 = new ModelRenderer(this, 18, 0);
     this.Leg6.addBox(-11.0F, 0.0F, -1.0F, 10, 1, 1);
     this.Leg6.setRotationPoint(6.0F, 14.0F, 3.0F);
     this.Leg6.setTextureSize(64, 32);
     this.Leg6.mirror = true;
     setRotation(this.Leg6, 0.0F, -0.2792527F, -1.919862F);
     this.Leg8 = new ModelRenderer(this, 18, 0);
     this.Leg8.addBox(0.0F, 0.0F, -1.0F, 6, 1, 1);
     this.Leg8.setRotationPoint(2.5F, 18.0F, 2.0F);
     this.Leg8.setTextureSize(64, 32);
     this.Leg8.mirror = true;
     setRotation(this.Leg8, 0.0F, -0.2792527F, -0.6981317F);
     this.PincerL = new ModelRenderer(this, 0, 17);
     this.PincerL.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
     this.PincerL.setRotationPoint(1.0F, 19.0F, -3.0F);
     this.PincerL.setTextureSize(64, 32);
     this.PincerL.mirror = true;
     setRotation(this.PincerL, -0.1745329F, 0.0F, 0.296706F);
     this.PincerR = new ModelRenderer(this, 0, 17);
     this.PincerR.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 1);
     this.PincerR.setRotationPoint(-1.0F, 19.0F, -3.0F);
     this.PincerR.setTextureSize(64, 32);
     this.PincerR.mirror = true;
     setRotation(this.PincerR, -0.1745329F, 0.0F, -0.296706F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Eye.render(f5);
     this.Eyelid.render(f5);
     this.Body.render(f5);
     this.Leg7.render(f5);
     this.Leg5.render(f5);
     this.Leg3.render(f5);
     this.Leg1.render(f5);
     this.Leg2.render(f5);
     this.Leg4.render(f5);
     this.Leg6.render(f5);
     this.Leg8.render(f5);
     this.PincerL.render(f5);
     this.PincerR.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
     model.rotateAngleX = x;
     model.rotateAngleY = y;
     model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
     super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
   }
 }