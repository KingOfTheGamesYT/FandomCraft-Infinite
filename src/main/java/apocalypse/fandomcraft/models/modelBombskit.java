 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.util.MathHelper;

 public class modelBombskit
   extends ModelBase
 {
   ModelRenderer body;
   ModelRenderer legR;
   ModelRenderer legL;

   public modelBombskit() {
     this.textureWidth = 64;
     this.textureHeight = 32;

     this.body = new ModelRenderer(this, 0, 0);
     this.body.addBox(-3.5F, -3.5F, -3.5F, 7, 7, 7);
     this.body.setRotationPoint(0.0F, 5.0F, 0.0F);
     this.body.setTextureSize(64, 32);
     this.body.mirror = true;
     setRotation(this.body, 0.0F, 0.0F, 0.0F);
     this.legR = new ModelRenderer(this, 0, 14);
     this.legR.addBox(0.0F, 0.0F, 0.0F, 1, 16, 1);
     this.legR.setRotationPoint(-2.5F, 8.0F, 1.0F);
     this.legR.setTextureSize(64, 32);
     this.legR.mirror = true;
     setRotation(this.legR, 0.0F, 0.0F, 0.0F);
   this.legL = new ModelRenderer(this, 0, 14);
     this.legL.addBox(0.0F, 0.0F, 0.0F, 1, 16, 1);
     this.legL.setRotationPoint(1.5F, 8.0F, 1.0F);
     this.legL.setTextureSize(64, 32);
     this.legL.mirror = true;
     setRotation(this.legL, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.body.render(f5);
     this.legR.render(f5);
     this.legL.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
     model.rotateAngleX = x;
     model.rotateAngleY = y;
     model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
     super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.body.rotateAngleY = f3 / 57.295776F;
     this.body.rotateAngleX = f4 / 57.295776F;
     this.legR.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
     this.legL.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
     this.legR.rotateAngleY = 0.0F;
     this.legL.rotateAngleY = 0.0F;
   }
 }