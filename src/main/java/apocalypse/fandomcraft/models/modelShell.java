 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelShell
   extends ModelBase
 {
   ModelRenderer Base;
   ModelRenderer Base2;
   ModelRenderer Base3;
   ModelRenderer Base4;
   ModelRenderer Edge1;
   ModelRenderer Edge2;

   public modelShell() {
     this.textureWidth = 128;
     this.textureHeight = 64;

     this.Base = new ModelRenderer(this, 80, 16);
     this.Base.addBox(-5.0F, -2.0F, -7.0F, 10, 4, 14);
     this.Base.setRotationPoint(0.0F, 21.0F, 0.0F);
     this.Base.setTextureSize(128, 64);
     this.Base.mirror = true;
     setRotation(this.Base, 0.0F, 0.0F, 0.0F);
     this.Base2 = new ModelRenderer(this, 84, 34);
     this.Base2.addBox(-6.0F, -2.0F, -5.0F, 12, 4, 10);
     this.Base2.setRotationPoint(0.0F, 21.0F, 0.0F);
     this.Base2.setTextureSize(128, 64);
     this.Base2.mirror = true;
     setRotation(this.Base2, 0.0F, 0.0F, 0.0F);
     this.Base3 = new ModelRenderer(this, 0, 16);
     this.Base3.addBox(-4.0F, -1.0F, -5.0F, 8, 7, 10);
     this.Base3.setRotationPoint(0.0F, 18.0F, 0.0F);
     this.Base3.setTextureSize(128, 64);
     this.Base3.mirror = true;
     setRotation(this.Base3, 0.0F, 0.0F, 0.0F);
     this.Base4 = new ModelRenderer(this, 0, 0);
     this.Base4.addBox(-5.0F, -2.0F, -6.0F, 10, 4, 12);
     this.Base4.setRotationPoint(0.0F, 20.0F, 0.0F);
     this.Base4.setTextureSize(128, 64);
     this.Base4.mirror = true;
     setRotation(this.Base4, 0.0F, 0.0F, 0.0F);
     this.Edge1 = new ModelRenderer(this, 76, 0);
     this.Edge1.addBox(-5.5F, -0.5F, -7.5F, 11, 1, 15);
     this.Edge1.setRotationPoint(0.0F, 22.0F, 0.0F);
     this.Edge1.setTextureSize(128, 64);
     this.Edge1.mirror = true;
     setRotation(this.Edge1, 0.0F, 0.0F, 0.0F);
     this.Edge2 = new ModelRenderer(this, 77, 3);
     this.Edge2.addBox(-6.5F, -0.5F, -6.0F, 13, 1, 12);
     this.Edge2.setRotationPoint(0.0F, 22.0F, 0.0F);
     this.Edge2.setTextureSize(128, 64);
     this.Edge2.mirror = true;
     setRotation(this.Edge2, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Base.render(f5);
     this.Base2.render(f5);
     this.Base3.render(f5);
     this.Base4.render(f5);
     this.Edge1.render(f5);
     this.Edge2.render(f5);
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