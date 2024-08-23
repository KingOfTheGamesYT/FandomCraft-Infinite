 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelGoomba
   extends ModelBase
 {
   ModelRenderer RightLeg;
   ModelRenderer LeftLeg;
   ModelRenderer Body;
   ModelRenderer HeadBase;
   ModelRenderer HeadTop;
   ModelRenderer EyebrowLeft;
   ModelRenderer EyebrowRight;
   ModelRenderer ToothRight;
   ModelRenderer ToothLeft;

   public modelGoomba() {
     this.textureWidth = 64;
     this.textureHeight = 32;

     this.RightLeg = new ModelRenderer(this, 3, 25);
     this.RightLeg.addBox(-2.0F, 0.0F, -3.0F, 4, 2, 5);
     this.RightLeg.setRotationPoint(-3.0F, 22.0F, 0.0F);
     this.RightLeg.setTextureSize(64, 32);
     this.RightLeg.mirror = true;
     setRotation(this.RightLeg, 0.0F, 0.1745329F, 0.0F);
     this.LeftLeg = new ModelRenderer(this, 3, 25);
     this.LeftLeg.addBox(-2.0F, 0.0F, -3.0F, 4, 2, 5);
     this.LeftLeg.setRotationPoint(3.0F, 22.0F, 0.0F);
     this.LeftLeg.setTextureSize(64, 32);
     this.LeftLeg.mirror = true;
     setRotation(this.LeftLeg, 0.0F, -0.1745329F, 0.0F);
     this.Body = new ModelRenderer(this, 0, 16);
     this.Body.addBox(-3.0F, 0.0F, -3.0F, 6, 3, 6);
     this.Body.setRotationPoint(0.0F, 19.0F, 1.0F);
     this.Body.setTextureSize(64, 32);
     this.Body.mirror = true;
     setRotation(this.Body, 0.0F, 0.0F, 0.0F);
     this.HeadBase = new ModelRenderer(this, 24, 18);
     this.HeadBase.addBox(-5.0F, 0.0F, -5.0F, 10, 4, 10);
     this.HeadBase.setRotationPoint(0.0F, 16.0F, 1.0F);
     this.HeadBase.setTextureSize(64, 32);
     this.HeadBase.mirror = true;
     setRotation(this.HeadBase, 0.0F, 0.0F, 0.0F);
     this.HeadTop = new ModelRenderer(this, 28, 5);
     this.HeadTop.addBox(-4.0F, 0.0F, -4.0F, 8, 5, 8);
     this.HeadTop.setRotationPoint(0.0F, 11.0F, 1.0F);
     this.HeadTop.setTextureSize(64, 32);
     this.HeadTop.mirror = true;
     setRotation(this.HeadTop, 0.0F, 0.0F, 0.0F);
     this.EyebrowLeft = new ModelRenderer(this, 0, 0);
     this.EyebrowLeft.addBox(-2.0F, 0.0F, 0.0F, 5, 1, 1);
     this.EyebrowLeft.setRotationPoint(2.0F, 12.0F, -4.0F);
     this.EyebrowLeft.setTextureSize(64, 32);
     this.EyebrowLeft.mirror = true;
     setRotation(this.EyebrowLeft, 0.0F, 0.0F, -0.4363323F);
     this.EyebrowRight = new ModelRenderer(this, 0, 0);
     this.EyebrowRight.addBox(-3.0F, 0.0F, 0.0F, 5, 1, 1);
     this.EyebrowRight.setRotationPoint(-2.0F, 12.0F, -4.0F);
     this.EyebrowRight.setTextureSize(64, 32);
     this.EyebrowRight.mirror = true;
     setRotation(this.EyebrowRight, 0.0F, 0.0F, 0.4363323F);
     this.ToothRight = new ModelRenderer(this, 0, 2);
     this.ToothRight.addBox(0.0F, -1.0F, 0.0F, 1, 2, 1);
     this.ToothRight.setRotationPoint(-4.0F, 17.0F, -4.5F);
     this.ToothRight.setTextureSize(64, 32);
     this.ToothRight.mirror = true;
     setRotation(this.ToothRight, 0.3490659F, 0.0F, -0.2443461F);
     this.ToothLeft = new ModelRenderer(this, 0, 2);
     this.ToothLeft.addBox(0.0F, -1.0F, 0.0F, 1, 2, 1);
     this.ToothLeft.setRotationPoint(3.0F, 17.0F, -4.5F);
     this.ToothLeft.setTextureSize(64, 32);
     this.ToothLeft.mirror = true;
     setRotation(this.ToothLeft, 0.3490659F, 0.0F, 0.2443461F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.RightLeg.render(f5);
     this.LeftLeg.render(f5);
     this.Body.render(f5);
     this.HeadBase.render(f5);
     this.HeadTop.render(f5);
     this.EyebrowLeft.render(f5);
     this.EyebrowRight.render(f5);
     this.ToothRight.render(f5);
     this.ToothLeft.render(f5);
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