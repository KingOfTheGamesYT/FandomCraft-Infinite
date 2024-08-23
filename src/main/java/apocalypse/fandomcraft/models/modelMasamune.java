 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelMasamune
   extends ModelBase
 {
   ModelRenderer handle;
   ModelRenderer handguard;
   ModelRenderer blade1;
   ModelRenderer blade2;

   public modelMasamune() {
     this.textureWidth = 32;
     this.textureHeight = 32;

     this.handle = new ModelRenderer(this, 4, 0);
     this.handle.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
     this.handle.setRotationPoint(-0.5F, 0.0F, -6.0F);
     this.handle.setTextureSize(32, 32);
     this.handle.mirror = true;
     setRotation(this.handle, 0.7853982F, 0.0F, 0.0F);
     this.handguard = new ModelRenderer(this, 8, 0);
     this.handguard.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3);
     this.handguard.setRotationPoint(-1.5F, 0.0F, -7.5F);
     this.handguard.setTextureSize(32, 32);
     this.handguard.mirror = true;
     setRotation(this.handguard, 0.7853982F, 0.0F, 0.0F);
     this.blade1 = new ModelRenderer(this, 0, 0);
     this.blade1.addBox(0.0F, 0.0F, 0.0F, 1, 16, 1);
     this.blade1.setRotationPoint(-0.5F, -1.5F, -6.0F);
     this.blade1.setTextureSize(32, 32);
     this.blade1.mirror = true;
     setRotation(this.blade1, -2.356194F, 0.0F, 0.0F);
     this.blade2 = new ModelRenderer(this, 20, 0);
     this.blade2.addBox(0.0F, 0.0F, 0.0F, 1, 18, 1);
     this.blade2.setRotationPoint(-0.5F, -12.2F, -17.0F);
     this.blade2.setTextureSize(32, 32);
     this.blade2.mirror = true;
     setRotation(this.blade2, -2.513274F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.handle.render(f5);
     this.handguard.render(f5);
     this.blade1.render(f5);
     this.blade2.render(f5);
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