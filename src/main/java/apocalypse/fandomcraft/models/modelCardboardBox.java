 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

 public class modelCardboardBox
   extends ModelBase
 {
   ModelRenderer Shape1;

   public modelCardboardBox() {
     this.textureWidth = 256;
     this.textureHeight = 128;

     this.Shape1 = new ModelRenderer(this, 0, 0);
     this.Shape1.addBox(0.0F, 0.0F, 0.0F, 60, 60, 60);
     this.Shape1.setRotationPoint(-30.0F, -36.0F, -30.0F);
     this.Shape1.setTextureSize(256, 128);
     this.Shape1.mirror = true;
     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
   }


   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Shape1.render(f5);
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
