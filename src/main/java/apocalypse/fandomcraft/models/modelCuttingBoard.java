 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelCuttingBoard
   extends ModelBase
 {
   ModelRenderer board1;
   ModelRenderer board2;
   ModelRenderer handle;
   ModelRenderer blade;

   public modelCuttingBoard() {
     this.textureWidth = 64;
     this.textureHeight = 32;

     this.board1 = new ModelRenderer(this, 0, 0);
     this.board1.addBox(0.0F, 0.0F, 0.0F, 9, 1, 10);
     this.board1.setRotationPoint(-4.0F, 23.0F, -7.0F);
     this.board1.setTextureSize(64, 32);
     this.board1.mirror = true;
     setRotation(this.board1, 0.0F, -0.3490659F, 0.0F);
     this.board2 = new ModelRenderer(this, 6, 11);
     this.board2.addBox(0.0F, 0.0F, 0.0F, 7, 1, 2);
     this.board2.setRotationPoint(-6.2F, 23.0F, 2.0F);
     this.board2.setTextureSize(64, 32);
     this.board2.mirror = true;
     setRotation(this.board2, 0.0F, -0.3490659F, 0.0F);
     this.handle = new ModelRenderer(this, 0, 11);
     this.handle.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
     this.handle.setRotationPoint(6.0F, 23.0F, 5.0F);
     this.handle.setTextureSize(64, 32);
     this.handle.mirror = true;
     setRotation(this.handle, 0.0F, -1.22173F, 0.0F);
     this.blade = new ModelRenderer(this, 0, 0);
     this.blade.addBox(0.0F, -1.0F, 0.0F, 4, 0, 1);
     this.blade.setRotationPoint(4.9F, 24.5F, 1.2F);
     this.blade.setTextureSize(64, 32);
     this.blade.mirror = true;
     setRotation(this.blade, 0.0F, -1.22173F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.board1.render(f5);
     this.board2.render(f5);
     this.handle.render(f5);
     this.blade.render(f5);
   }

   public void renderModel(float f) {
     this.board1.render(f);
     this.board2.render(f);
     this.handle.render(f);
     this.blade.render(f);
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