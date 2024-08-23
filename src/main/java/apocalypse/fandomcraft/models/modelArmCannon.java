 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelArmCannon
   extends ModelBase
 {
   ModelRenderer insideEnergy;
   ModelRenderer longThin;
   ModelRenderer shortThick;

   public modelArmCannon() {
     this.textureWidth = 64;
     this.textureHeight = 32;

     this.insideEnergy = new ModelRenderer(this, 0, 28);
     this.insideEnergy.addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3);
     this.insideEnergy.setRotationPoint(0.0F, 14.0F, 0.0F);
     this.insideEnergy.setTextureSize(64, 32);
     this.insideEnergy.mirror = true;
     setRotation(this.insideEnergy, 0.0F, 0.0F, 0.0F);
     this.longThin = new ModelRenderer(this, 0, 13);
     this.longThin.addBox(-2.0F, 0.0F, -2.0F, 4, 11, 4);
     this.longThin.setRotationPoint(0.0F, 4.5F, 0.0F);
     this.longThin.setTextureSize(64, 32);
     this.longThin.mirror = true;
     setRotation(this.longThin, 0.0F, 0.0F, 0.0F);
     this.shortThick = new ModelRenderer(this, 0, 0);
     this.shortThick.addBox(-2.5F, 0.0F, -2.5F, 5, 8, 5);
     this.shortThick.setRotationPoint(0.0F, 5.5F, 0.0F);
     this.shortThick.setTextureSize(64, 32);
     this.shortThick.mirror = true;
     setRotation(this.shortThick, 0.0F, 0.0F, 0.0F);
   }


   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.insideEnergy.render(f5);
     this.longThin.render(f5);
     this.shortThick.render(f5);
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
