 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelSmallTable
   extends ModelBase
 {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;

   public modelSmallTable() {
     this.textureWidth = 256;
     this.textureHeight = 64;

     this.Shape1 = new ModelRenderer(this, 0, 0);
     this.Shape1.addBox(-8.0F, 0.0F, -8.0F, 16, 4, 16);
     this.Shape1.setRotationPoint(0.0F, 8.0F, 0.0F);
     this.Shape1.setTextureSize(256, 64);
     this.Shape1.mirror = true;
     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
     this.Shape2 = new ModelRenderer(this, 0, 0);
     this.Shape2.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2);
     this.Shape2.setRotationPoint(-6.0F, 12.0F, -6.0F);
     this.Shape2.setTextureSize(256, 64);
     this.Shape2.mirror = true;
     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
     this.Shape3 = new ModelRenderer(this, 0, 0);
     this.Shape3.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2);
     this.Shape3.setRotationPoint(6.0F, 12.0F, -6.0F);
     this.Shape3.setTextureSize(256, 64);
     this.Shape3.mirror = true;
     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
     this.Shape4 = new ModelRenderer(this, 0, 0);
     this.Shape4.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2);
     this.Shape4.setRotationPoint(-6.0F, 12.0F, 6.0F);
     this.Shape4.setTextureSize(256, 64);
     this.Shape4.mirror = true;
     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
     this.Shape5 = new ModelRenderer(this, 0, 0);
     this.Shape5.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2);
     this.Shape5.setRotationPoint(6.0F, 12.0F, 6.0F);
     this.Shape5.setTextureSize(256, 64);
     this.Shape5.mirror = true;
     setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
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

   public void renderModel(float f) {
     this.Shape1.render(f);
     this.Shape2.render(f);
     this.Shape3.render(f);
     this.Shape4.render(f);
     this.Shape5.render(f);
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