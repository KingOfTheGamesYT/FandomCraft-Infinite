 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelShadow
   extends ModelBase
 {
   ModelRenderer Head;
   ModelRenderer Head1;
   ModelRenderer Head2;
   ModelRenderer Head3;
   ModelRenderer Body;
   ModelRenderer Body1;
   ModelRenderer Body2;
   ModelRenderer Body3;
   ModelRenderer LeftShoulder;
   ModelRenderer LeftArm;
   ModelRenderer RightShoulder;
   ModelRenderer RightArm;
   ModelRenderer Neck;
   ModelRenderer RightLeg;
   ModelRenderer RightFoot;
   ModelRenderer LeftLeg;
   ModelRenderer LeftFoot;
   ModelRenderer LeftAntennae;
   ModelRenderer RightAntennae;
   ModelRenderer RightEye;
   ModelRenderer LeftEye;

   public modelShadow() {
     this.textureWidth = 128;
     this.textureHeight = 64;

     this.Head = new ModelRenderer(this, 0, 0);
     this.Head.addBox(-10.0F, -21.0F, -10.0F, 20, 20, 20);
     this.Head.setRotationPoint(0.0F, -14.0F, -5.0F);
     this.Head.setTextureSize(128, 64);
     this.Head.mirror = true;
     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
     this.Head1 = new ModelRenderer(this, 0, 0);
     this.Head1.addBox(-12.0F, -8.0F, -8.0F, 24, 16, 16);
     this.Head1.setRotationPoint(0.0F, -25.0F, -5.0F);
     this.Head1.setTextureSize(128, 64);
     this.Head1.mirror = true;
     setRotation(this.Head1, 0.0F, 0.0F, 0.0F);
     this.Head2 = new ModelRenderer(this, 0, 0);
     this.Head2.addBox(-8.0F, -8.0F, -12.0F, 16, 16, 24);
     this.Head2.setRotationPoint(0.0F, -25.0F, -5.0F);
     this.Head2.setTextureSize(128, 64);
     this.Head2.mirror = true;
     setRotation(this.Head2, 0.0F, 0.0F, 0.0F);
     this.Head3 = new ModelRenderer(this, 0, 0);
     this.Head3.addBox(-8.0F, -12.0F, -8.0F, 16, 24, 16);
     this.Head3.setRotationPoint(0.0F, -25.0F, -5.0F);
     this.Head3.setTextureSize(128, 64);
     this.Head3.mirror = true;
     setRotation(this.Head3, 0.0F, 0.0F, 0.0F);
     this.Body = new ModelRenderer(this, 0, 0);
     this.Body.addBox(-6.0F, -6.0F, -10.0F, 12, 12, 20);
     this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
     this.Body.setTextureSize(128, 64);
     this.Body.mirror = true;
     setRotation(this.Body, 0.0F, 0.0F, 0.0F);
     this.Body1 = new ModelRenderer(this, 0, 0);
     this.Body1.addBox(-10.0F, -6.0F, -6.0F, 20, 12, 12);
     this.Body1.setRotationPoint(0.0F, 0.0F, 0.0F);
     this.Body1.setTextureSize(128, 64);
     this.Body1.mirror = true;
     setRotation(this.Body1, 0.0F, 0.0F, 0.0F);
     this.Body2 = new ModelRenderer(this, 0, 0);
     this.Body2.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16);
     this.Body2.setRotationPoint(0.0F, 0.0F, 0.0F);
     this.Body2.setTextureSize(128, 64);
     this.Body2.mirror = true;
     setRotation(this.Body2, 0.0F, 0.0F, 0.0F);
     this.Body3 = new ModelRenderer(this, 0, 0);
     this.Body3.addBox(-6.0F, -10.0F, -6.0F, 12, 20, 12);
     this.Body3.setRotationPoint(0.0F, 0.0F, 0.0F);
     this.Body3.setTextureSize(128, 64);
     this.Body3.mirror = true;
     setRotation(this.Body3, 0.0F, 0.0F, 0.0F);
     this.LeftShoulder = new ModelRenderer(this, 0, 0);
     this.LeftShoulder.addBox(-1.0F, 0.0F, -1.0F, 3, 15, 3);
     this.LeftShoulder.setRotationPoint(9.0F, -4.0F, 2.0F);
     this.LeftShoulder.setTextureSize(128, 64);
     this.LeftShoulder.mirror = true;
     setRotation(this.LeftShoulder, 0.2443461F, 0.0F, -0.4014257F);
     this.LeftArm = new ModelRenderer(this, 0, 0);
     this.LeftArm.addBox(0.0F, 0.0F, 0.0F, 3, 24, 3);
     this.LeftArm.setRotationPoint(13.0F, 7.0F, 4.0F);
     this.LeftArm.setTextureSize(128, 64);
     this.LeftArm.mirror = true;
     setRotation(this.LeftArm, -0.8726646F, 0.0F, -0.1919862F);
     this.RightShoulder = new ModelRenderer(this, 0, 0);
     this.RightShoulder.addBox(-2.0F, 0.0F, -1.0F, 3, 15, 3);
     this.RightShoulder.setRotationPoint(-9.0F, -4.0F, 1.0F);
     this.RightShoulder.setTextureSize(128, 64);
     this.RightShoulder.mirror = true;
     setRotation(this.RightShoulder, 0.2443461F, 0.0F, 0.4014257F);
     this.RightArm = new ModelRenderer(this, 0, 0);
     this.RightArm.addBox(-1.0F, 0.0F, -2.0F, 3, 24, 3);
     this.RightArm.setRotationPoint(-15.0F, 8.0F, 5.0F);
     this.RightArm.setTextureSize(128, 64);
     this.RightArm.mirror = true;
     setRotation(this.RightArm, -0.8726646F, 0.0F, 0.1919862F);
     this.Neck = new ModelRenderer(this, 0, 0);
     this.Neck.addBox(-5.0F, -10.0F, -5.0F, 10, 17, 10);
     this.Neck.setRotationPoint(0.0F, -9.0F, 0.0F);
     this.Neck.setTextureSize(128, 64);
     this.Neck.mirror = true;
     setRotation(this.Neck, 0.3141593F, 0.0F, 0.0F);
     this.RightLeg = new ModelRenderer(this, 0, 0);
     this.RightLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 13, 3);
     this.RightLeg.setRotationPoint(-4.0F, 9.0F, 0.0F);
     this.RightLeg.setTextureSize(128, 64);
     this.RightLeg.mirror = true;
     setRotation(this.RightLeg, 0.4363323F, 0.0F, 0.2094395F);
     this.RightFoot = new ModelRenderer(this, 0, 0);
     this.RightFoot.addBox(-4.0F, -2.0F, -8.0F, 7, 4, 11);
     this.RightFoot.setRotationPoint(-6.0F, 20.0F, 2.0F);
     this.RightFoot.setTextureSize(128, 64);
     this.RightFoot.mirror = true;
     setRotation(this.RightFoot, 0.3490659F, 0.2617994F, 0.0F);
     this.LeftLeg = new ModelRenderer(this, 0, 0);
     this.LeftLeg.addBox(-1.0F, 0.0F, -1.0F, 3, 13, 3);
     this.LeftLeg.setRotationPoint(4.5F, 9.5F, -1.0F);
     this.LeftLeg.setTextureSize(128, 64);
     this.LeftLeg.mirror = true;
     setRotation(this.LeftLeg, 0.4363323F, 0.0F, -0.2094395F);
     this.LeftFoot = new ModelRenderer(this, 0, 0);
     this.LeftFoot.addBox(-3.0F, -1.0F, -8.0F, 7, 4, 11);
     this.LeftFoot.setRotationPoint(7.0F, 18.5F, 2.0F);
     this.LeftFoot.setTextureSize(128, 64);
     this.LeftFoot.mirror = true;
     setRotation(this.LeftFoot, 0.3490659F, -0.2617994F, 0.0F);
     this.LeftAntennae = new ModelRenderer(this, 86, 43);
     this.LeftAntennae.addBox(-20.0F, -20.0F, 0.0F, 20, 20, 1);
     this.LeftAntennae.setRotationPoint(-8.0F, -29.0F, 1.0F);
     this.LeftAntennae.setTextureSize(128, 64);
     this.LeftAntennae.mirror = true;
     setRotation(this.LeftAntennae, 0.2617994F, 0.6108652F, 0.4363323F);
     this.RightAntennae = new ModelRenderer(this, 86, 43);
     this.RightAntennae.addBox(-20.0F, -20.0F, 0.0F, 20, 20, 1);
     this.RightAntennae.setRotationPoint(7.0F, -29.5F, 1.5F);
     this.RightAntennae.setTextureSize(128, 64);
     this.RightAntennae.mirror = true;
     setRotation(this.RightAntennae, -0.2617994F, 2.530727F, 0.4363323F);
     this.RightEye = new ModelRenderer(this, 118, 0);
     this.RightEye.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 1);
     this.RightEye.setRotationPoint(-4.0F, -24.0F, -15.5F);
     this.RightEye.setTextureSize(128, 64);
     this.RightEye.mirror = true;
     setRotation(this.RightEye, 0.0F, 0.0F, 0.0F);
     this.LeftEye = new ModelRenderer(this, 118, 0);
     this.LeftEye.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 1);
     this.LeftEye.setRotationPoint(4.0F, -24.0F, -15.5F);
     this.LeftEye.setTextureSize(128, 64);
     this.LeftEye.mirror = true;
     setRotation(this.LeftEye, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Head.render(f5);
     this.Head1.render(f5);
     this.Head2.render(f5);
     this.Head3.render(f5);
     this.Body.render(f5);
     this.Body1.render(f5);
     this.Body2.render(f5);
     this.Body3.render(f5);
     this.LeftShoulder.render(f5);
     this.LeftArm.render(f5);
     this.RightShoulder.render(f5);
     this.RightArm.render(f5);
     this.Neck.render(f5);
     this.RightLeg.render(f5);
     this.RightFoot.render(f5);
     this.LeftLeg.render(f5);
     this.LeftFoot.render(f5);
     this.LeftAntennae.render(f5);
     this.RightAntennae.render(f5);
     this.RightEye.render(f5);
     this.LeftEye.render(f5);
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