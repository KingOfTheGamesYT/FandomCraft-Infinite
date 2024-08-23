 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelToado
   extends ModelBase
 {
   ModelRenderer body;
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;

   public modelToado() {
     this.textureWidth = 64;
     this.textureHeight = 32;

     this.body = new ModelRenderer(this, 0, 0);
     this.body.addBox(-5.0F, -5.0F, -6.0F, 10, 10, 10);
     this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
     this.body.setTextureSize(64, 32);
     this.body.mirror = true;
     setRotation(this.body, 0.0F, 0.0F, 0.0F);
     this.Shape1 = new ModelRenderer(this, 32, 0);
     this.Shape1.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2);
     this.Shape1.setRotationPoint(0.0F, 0.0F, 4.0F);
     this.Shape1.setTextureSize(64, 32);
     this.Shape1.mirror = true;
     setRotation(this.Shape1, 1.570796F, 0.0F, 0.0F);
     this.Shape2 = new ModelRenderer(this, 0, 0);
     this.Shape2.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2);
     this.Shape2.setRotationPoint(0.0F, 0.0F, 4.0F);
     this.Shape2.setTextureSize(64, 32);
     this.Shape2.mirror = true;
     setRotation(this.Shape2, 2.356194F, 0.0F, 0.7853982F);
     this.Shape3 = new ModelRenderer(this, 0, 0);
     this.Shape3.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2);
     this.Shape3.setRotationPoint(0.0F, 0.0F, 4.0F);
     this.Shape3.setTextureSize(64, 32);
     this.Shape3.mirror = true;
     setRotation(this.Shape3, 2.356194F, 0.0F, -0.7853982F);
     this.Shape4 = new ModelRenderer(this, 0, 0);
     this.Shape4.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2);
     this.Shape4.setRotationPoint(0.0F, 0.0F, 4.0F);
     this.Shape4.setTextureSize(64, 32);
     this.Shape4.mirror = true;
     setRotation(this.Shape4, 0.7853982F, 0.0F, 0.7853982F);
     this.Shape5 = new ModelRenderer(this, 0, 0);
     this.Shape5.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2);
     this.Shape5.setRotationPoint(0.0F, 0.0F, 4.0F);
     this.Shape5.setTextureSize(64, 32);
     this.Shape5.mirror = true;
     setRotation(this.Shape5, 0.7853982F, 0.0F, -0.7853982F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.body.render(f5);
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

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
     super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
   }
 }