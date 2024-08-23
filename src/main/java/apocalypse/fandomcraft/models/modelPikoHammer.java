 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelPikoHammer
   extends ModelBase
 {
   ModelRenderer Handle;
   ModelRenderer Base0;
   ModelRenderer Base1;

   public modelPikoHammer() {
     this.textureWidth = 64;
     this.textureHeight = 64;

     this.Handle = new ModelRenderer(this, 0, 0);
     this.Handle.addBox(0.0F, 0.0F, 0.0F, 1, 18, 1);
     this.Handle.setRotationPoint(0.0F, 0.0F, 0.0F);
     this.Handle.setTextureSize(64, 64);
     this.Handle.mirror = true;
     setRotation(this.Handle, 0.0F, 0.0F, 0.0F);
     this.Base0 = new ModelRenderer(this, 5, 19);
     this.Base0.addBox(0.0F, 0.0F, 0.0F, 7, 7, 11);
     this.Base0.setRotationPoint(-3.0F, -6.0F, -5.0F);
     this.Base0.setTextureSize(64, 64);
     this.Base0.mirror = true;
     setRotation(this.Base0, 0.0F, 0.0F, 0.0F);
     this.Base1 = new ModelRenderer(this, 4, 0);
     this.Base1.addBox(0.0F, 0.0F, 0.0F, 7, 7, 12);
     this.Base1.setRotationPoint(-4.5F, -2.5F, -5.5F);
     this.Base1.setTextureSize(64, 64);
     this.Base1.mirror = true;
     setRotation(this.Base1, 0.0F, 0.0F, -0.7853982F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Handle.render(f5);
     this.Base0.render(f5);
     this.Base1.render(f5);
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