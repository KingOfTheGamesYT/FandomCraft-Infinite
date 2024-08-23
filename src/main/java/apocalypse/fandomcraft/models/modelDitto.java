 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelDitto
   extends ModelBase
 {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;
   ModelRenderer Shape6;
   ModelRenderer Shape7;

   public modelDitto() {
     this.textureWidth = 64;
     this.textureHeight = 32;

     this.Shape1 = new ModelRenderer(this, 0, 0);
     this.Shape1.addBox(-6.0F, 0.0F, -4.0F, 12, 3, 8);
     this.Shape1.setRotationPoint(0.0F, 21.0F, 0.0F);
     this.Shape1.setTextureSize(64, 32);
     this.Shape1.mirror = true;
     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
     this.Shape2 = new ModelRenderer(this, 0, 0);
     this.Shape2.addBox(-5.0F, 0.0F, -5.0F, 10, 2, 10);
     this.Shape2.setRotationPoint(0.0F, 22.0F, 0.0F);
     this.Shape2.setTextureSize(64, 32);
     this.Shape2.mirror = true;
     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
     this.Shape3 = new ModelRenderer(this, 0, 0);
     this.Shape3.addBox(-5.0F, 0.0F, -4.0F, 10, 4, 8);
     this.Shape3.setRotationPoint(0.0F, 19.0F, 0.0F);
     this.Shape3.setTextureSize(64, 32);
     this.Shape3.mirror = true;
     setRotation(this.Shape3, -0.122173F, 0.0F, 0.0F);
     this.Shape4 = new ModelRenderer(this, 0, 12);
     this.Shape4.addBox(-4.5F, 0.0F, -3.5F, 9, 5, 7);
     this.Shape4.setRotationPoint(0.0F, 14.7F, 0.2F);
     this.Shape4.setTextureSize(64, 32);
     this.Shape4.mirror = true;
     setRotation(this.Shape4, -0.1047198F, -0.0116413F, 0.0F);
     this.Shape5 = new ModelRenderer(this, 0, 0);
     this.Shape5.addBox(-4.0F, 0.0F, -2.0F, 8, 2, 5);
     this.Shape5.setRotationPoint(0.0F, 14.0F, 0.0F);
     this.Shape5.setTextureSize(64, 32);
     this.Shape5.mirror = true;
     setRotation(this.Shape5, -0.2094395F, 0.0F, 0.0F);
     this.Shape6 = new ModelRenderer(this, 0, 0);
     this.Shape6.addBox(0.0F, 0.0F, 0.0F, 3, 3, 2);
     this.Shape6.setRotationPoint(-6.0F, 16.0F, -1.0F);
     this.Shape6.setTextureSize(64, 32);
     this.Shape6.mirror = true;
     setRotation(this.Shape6, -0.2094395F, -0.122173F, -0.2268928F);
     this.Shape7 = new ModelRenderer(this, 0, 0);
     this.Shape7.addBox(-3.0F, 0.0F, 0.0F, 3, 3, 2);
     this.Shape7.setRotationPoint(6.0F, 16.0F, -1.0F);
     this.Shape7.setTextureSize(64, 32);
     this.Shape7.mirror = true;
     setRotation(this.Shape7, -0.2094395F, 0.122173F, 0.2268928F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Shape1.render(f5);
     this.Shape2.render(f5);
     this.Shape3.render(f5);
     this.Shape4.render(f5);
     this.Shape5.render(f5);
     this.Shape6.render(f5);
     this.Shape7.render(f5);
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