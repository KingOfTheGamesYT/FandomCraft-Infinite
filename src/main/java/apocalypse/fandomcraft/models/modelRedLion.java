 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelRedLion
   extends ModelBase
 {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;
   ModelRenderer Shape6;
   ModelRenderer Shape7;
   ModelRenderer Shape8;
   ModelRenderer Shape9;
   ModelRenderer Shape10;
   ModelRenderer Shape11;
   ModelRenderer Shape12;
   ModelRenderer Shape13;
   ModelRenderer Shape14;

   public modelRedLion() {
     this.textureWidth = 256;
     this.textureHeight = 128;

     this.Shape1 = new ModelRenderer(this, 0, 0);
     this.Shape1.addBox(-16.0F, 0.0F, -8.0F, 32, 3, 16);
     this.Shape1.setRotationPoint(0.0F, 23.0F, 0.0F);
     this.Shape1.setTextureSize(256, 128);
     this.Shape1.mirror = true;
     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
     this.Shape2 = new ModelRenderer(this, 0, 117);
     this.Shape2.addBox(0.0F, 0.0F, 0.0F, 32, 10, 1);
     this.Shape2.setRotationPoint(-16.0F, 15.0F, -9.0F);
     this.Shape2.setTextureSize(256, 128);
     this.Shape2.mirror = true;
     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
     this.Shape3 = new ModelRenderer(this, 0, 117);
     this.Shape3.addBox(0.0F, 0.0F, 0.0F, 32, 10, 1);
     this.Shape3.setRotationPoint(-16.0F, 15.0F, 8.0F);
     this.Shape3.setTextureSize(256, 128);
     this.Shape3.mirror = true;
     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
     this.Shape4 = new ModelRenderer(this, 0, 93);
     this.Shape4.addBox(-3.0F, 0.0F, -8.0F, 7, 8, 16);
     this.Shape4.setRotationPoint(-14.0F, 17.0F, 0.0F);
     this.Shape4.setTextureSize(256, 128);
     this.Shape4.mirror = true;
     setRotation(this.Shape4, 0.0F, 0.0F, 0.6806784F);
     this.Shape5 = new ModelRenderer(this, 46, 93);
     this.Shape5.addBox(-4.0F, 0.0F, -8.0F, 7, 8, 16);
     this.Shape5.setRotationPoint(14.0F, 17.0F, 0.0F);
     this.Shape5.setTextureSize(256, 128);
     this.Shape5.mirror = true;
     setRotation(this.Shape5, 0.0F, 0.0F, -0.6806784F);
     this.Shape6 = new ModelRenderer(this, 0, 91);
     this.Shape6.addBox(-11.0F, 0.0F, 0.0F, 11, 1, 1);
     this.Shape6.setRotationPoint(-13.0F, 14.0F, 0.0F);
     this.Shape6.setTextureSize(256, 128);
     this.Shape6.mirror = true;
     setRotation(this.Shape6, 0.0F, 0.0F, -0.1396263F);
     this.Shape7 = new ModelRenderer(this, 0, 93);
     this.Shape7.addBox(-2.0F, 0.0F, 0.0F, 3, 14, 1);
     this.Shape7.setRotationPoint(-22.0F, 16.0F, 0.0F);
     this.Shape7.setTextureSize(256, 128);
     this.Shape7.mirror = true;
     setRotation(this.Shape7, -0.3316126F, 0.0F, 0.1396263F);
     this.Shape8 = new ModelRenderer(this, 0, 67);
     this.Shape8.addBox(-3.0F, 0.0F, -3.0F, 6, 17, 6);
     this.Shape8.setRotationPoint(13.0F, 3.0F, 0.0F);
     this.Shape8.setTextureSize(256, 128);
     this.Shape8.mirror = true;
     setRotation(this.Shape8, 0.0F, 0.0F, -0.1396263F);
     this.Shape9 = new ModelRenderer(this, 0, 54);
     this.Shape9.addBox(0.0F, 0.0F, -5.0F, 9, 3, 10);
     this.Shape9.setRotationPoint(15.0F, 6.0F, 0.0F);
     this.Shape9.setTextureSize(256, 128);
     this.Shape9.mirror = true;
     setRotation(this.Shape9, 0.0F, 0.0F, 0.0F);
     this.Shape10 = new ModelRenderer(this, 0, 40);
     this.Shape10.addBox(0.0F, 0.0F, -4.0F, 11, 6, 8);
     this.Shape10.setRotationPoint(12.0F, 0.0F, 0.0F);
     this.Shape10.setTextureSize(256, 128);
     this.Shape10.mirror = true;
     setRotation(this.Shape10, 0.0F, 0.0F, 0.0F);
     this.Shape11 = new ModelRenderer(this, 0, 35);
     this.Shape11.addBox(0.0F, 0.0F, 0.0F, 2, 11, 2);
     this.Shape11.setRotationPoint(9.0F, -8.0F, 5.0F);
     this.Shape11.setTextureSize(256, 128);
     this.Shape11.mirror = true;
     setRotation(this.Shape11, -0.2443461F, 0.0F, -0.2617994F);
     this.Shape12 = new ModelRenderer(this, 0, 35);
     this.Shape12.addBox(0.0F, 0.0F, -2.0F, 2, 11, 2);
     this.Shape12.setRotationPoint(9.0F, -8.0F, -5.0F);
     this.Shape12.setTextureSize(256, 128);
     this.Shape12.mirror = true;
     setRotation(this.Shape12, 0.2443461F, 0.0F, -0.2617994F);
     this.Shape13 = new ModelRenderer(this, 0, 7);
     this.Shape13.addBox(0.0F, 0.0F, 0.0F, 8, 7, 0);
     this.Shape13.setRotationPoint(10.0F, 1.0F, 4.0F);
     this.Shape13.setTextureSize(256, 128);
     this.Shape13.mirror = true;
     setRotation(this.Shape13, 0.0F, -0.2094395F, 0.0F);
     this.Shape14 = new ModelRenderer(this, 0, 0);
     this.Shape14.addBox(0.0F, 0.0F, 0.0F, 8, 7, 0);
     this.Shape14.setRotationPoint(10.0F, 1.0F, -4.0F);
     this.Shape14.setTextureSize(256, 128);
     this.Shape14.mirror = true;
     setRotation(this.Shape14, 0.0F, 0.2094395F, 0.0F);
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
     this.Shape8.render(f5);
     this.Shape9.render(f5);
     this.Shape10.render(f5);
     this.Shape11.render(f5);
     this.Shape12.render(f5);
     this.Shape13.render(f5);
     this.Shape14.render(f5);
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