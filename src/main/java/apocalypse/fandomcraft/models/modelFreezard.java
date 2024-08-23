 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelFreezard
   extends ModelBase
 {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;

   public modelFreezard() {
     this.textureWidth = 256;
     this.textureHeight = 128;

     this.Shape1 = new ModelRenderer(this, 0, 42);
     this.Shape1.addBox(-12.0F, -12.0F, -12.0F, 24, 28, 24);
     this.Shape1.setRotationPoint(0.0F, 8.0F, 0.0F);
     this.Shape1.setTextureSize(256, 128);
     this.Shape1.mirror = true;
     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
     this.Shape2 = new ModelRenderer(this, 0, 0);
     this.Shape2.addBox(-5.0F, -16.0F, -5.0F, 10, 16, 10);
     this.Shape2.setRotationPoint(0.0F, -12.0F, 1.0F);
     this.Shape2.setTextureSize(256, 128);
     this.Shape2.mirror = true;
     setRotation(this.Shape2, -0.2094395F, 0.0F, 0.0F);
     this.Shape3 = new ModelRenderer(this, 0, 0);
     this.Shape3.addBox(-8.0F, -19.0F, -9.0F, 16, 19, 18);
     this.Shape3.setRotationPoint(0.0F, 3.0F, -1.0F);
     this.Shape3.setTextureSize(256, 128);
     this.Shape3.mirror = true;
     setRotation(this.Shape3, -0.1396263F, 0.0F, 0.0F);
     this.Shape4 = new ModelRenderer(this, 0, 0);
     this.Shape4.addBox(-8.0F, -19.0F, -9.0F, 16, 24, 18);
     this.Shape4.setRotationPoint(7.0F, 13.0F, 3.0F);
     this.Shape4.setTextureSize(256, 128);
     this.Shape4.mirror = true;
     setRotation(this.Shape4, -0.1396263F, 0.0F, 0.5759587F);
     this.Shape5 = new ModelRenderer(this, 0, 0);
     this.Shape5.addBox(-8.0F, -19.0F, -9.0F, 16, 24, 18);
     this.Shape5.setRotationPoint(-7.0F, 13.0F, 3.0F);
     this.Shape5.setTextureSize(256, 128);
     this.Shape5.mirror = true;
     setRotation(this.Shape5, -0.1396263F, 0.0F, -0.5759587F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Shape1.render(f5);
     this.Shape2.render(f5);
     this.Shape3.render(f5);
     this.Shape4.render(f5);
     this.Shape5.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
     model.rotateAngleX = x;
     model.rotateAngleY = y;
     model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity sandwich) {
     super.setRotationAngles(f, f1, f2, f3, f4, f5, sandwich);
   }
 }