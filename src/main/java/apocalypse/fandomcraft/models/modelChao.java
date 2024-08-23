 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelChao
   extends ModelBase
 {
   ModelRenderer Head;
   ModelRenderer Headwear;
   ModelRenderer Body;
   ModelRenderer RightArm;
   ModelRenderer LeftArm;
   ModelRenderer RightLeg;
   ModelRenderer LeftLeg;

   public modelChao() {
     this.textureWidth = 64;
     this.textureHeight = 64;

     this.Head = new ModelRenderer(this, 0, 0);
     this.Head.addBox(1.0F, -1.0F, -2.0F, 3, 3, 3);
     this.Head.setRotationPoint(0.0F, -19.0F, -3.0F);
     this.Head.setTextureSize(64, 64);
     this.Head.mirror = true;
     setRotation(this.Head, 0.7504916F, -1.570796F, -0.8028515F);
     this.Headwear = new ModelRenderer(this, 0, 16);
     this.Headwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
     this.Headwear.setRotationPoint(0.0F, -8.0F, -1.0F);
     this.Headwear.setTextureSize(64, 64);
     this.Headwear.mirror = true;
     setRotation(this.Headwear, 0.0F, 0.0F, 0.0F);
     this.Body = new ModelRenderer(this, 32, 16);
     this.Body.addBox(-4.0F, 0.0F, -2.0F, 6, 6, 5);
     this.Body.setRotationPoint(1.0F, -8.0F, -1.0F);
     this.Body.setTextureSize(64, 64);
     this.Body.mirror = true;
     setRotation(this.Body, 0.0F, 0.0F, 0.0F);
     this.RightArm = new ModelRenderer(this, 56, 0);
     this.RightArm.addBox(-1.0F, -2.0F, -1.0F, 2, 9, 2);
     this.RightArm.setRotationPoint(-4.0F, -6.0F, 0.0F);
     this.RightArm.setTextureSize(64, 64);
     setRotation(this.RightArm, 0.0F, 0.0F, 0.2268928F);
     this.LeftArm = new ModelRenderer(this, 56, 0);
     this.LeftArm.addBox(-1.0F, -2.0F, -1.0F, 2, 9, 2);
     this.LeftArm.setRotationPoint(4.0F, -6.0F, 0.0F);
     this.LeftArm.setTextureSize(64, 64);
     setRotation(this.LeftArm, 0.0F, 0.0F, -0.2268928F);
     this.LeftArm.mirror = false;
     this.RightLeg = new ModelRenderer(this, 48, 0);
     this.RightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
     this.RightLeg.setRotationPoint(-2.0F, -2.0F, -1.0F);
     this.RightLeg.setTextureSize(64, 64);
     this.RightLeg.mirror = false;
     setRotation(this.RightLeg, -0.4363323F, 0.2617994F, 0.0F);
     this.LeftLeg = new ModelRenderer(this, 48, 0);
     this.LeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
     this.LeftLeg.setRotationPoint(2.0F, -2.0F, -1.0F);
     this.LeftLeg.setTextureSize(64, 64);
     setRotation(this.LeftLeg, -0.4363323F, -0.2617994F, 0.0F);
     this.LeftLeg.mirror = false;
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Head.render(f5);
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
     float f6 = 57.295776F;
     this.Headwear.rotateAngleX = f4 / 57.295776F;
     this.Headwear.rotateAngleY = f3 / 57.295776F;
   }
 }