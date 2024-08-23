 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelUnownA
   extends ModelBase
 {
   ModelRenderer Eye;
   ModelRenderer Eyeball;
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape8;
   ModelRenderer Shape7;
   ModelRenderer Shape4;
   ModelRenderer Shape5;
   ModelRenderer Shape6;
   ModelRenderer Shape11;
   ModelRenderer Shape12;
   ModelRenderer Shape9;
   ModelRenderer Shape10;

   public modelUnownA() {
     this.textureWidth = 32;
     this.textureHeight = 32;

     this.Eye = new ModelRenderer(this, 26, 0);
     this.Eye.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 1);
     this.Eye.setRotationPoint(0.0F, 3.0F, 0.0F);
     this.Eye.setTextureSize(32, 32);
     this.Eye.mirror = true;
     setRotation(this.Eye, 0.0F, 0.0F, 0.0F);
     this.Eyeball = new ModelRenderer(this, 24, 3);
     this.Eyeball.addBox(0.0F, 0.0F, 0.5F, 4, 4, 0);
     this.Eyeball.setRotationPoint(-2.0F, 1.0F, 0.0F);
     this.Eyeball.setTextureSize(32, 32);
     this.Eyeball.mirror = true;
     setRotation(this.Eyeball, 0.0F, 0.0F, 0.0F);
     this.Shape1 = new ModelRenderer(this, 0, 0);
     this.Shape1.addBox(-2.0F, 0.0F, 0.0F, 4, 1, 1);
     this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
     this.Shape1.setTextureSize(32, 32);
     this.Shape1.mirror = true;
     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
     this.Shape2 = new ModelRenderer(this, 0, 0);
     this.Shape2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
     this.Shape2.setRotationPoint(1.5F, 0.5F, 0.0F);
     this.Shape2.setTextureSize(32, 32);
     this.Shape2.mirror = true;
     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
     this.Shape3 = new ModelRenderer(this, 0, 0);
     this.Shape3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
     this.Shape3.setRotationPoint(-2.5F, 0.5F, 0.0F);
     this.Shape3.setTextureSize(32, 32);
     this.Shape3.mirror = true;
     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
     this.Shape8 = new ModelRenderer(this, 0, 0);
     this.Shape8.addBox(-2.0F, 0.0F, 0.0F, 4, 1, 1);
     this.Shape8.setRotationPoint(0.0F, 5.0F, 0.0F);
     this.Shape8.setTextureSize(32, 32);
     this.Shape8.mirror = true;
     setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
     this.Shape7 = new ModelRenderer(this, 0, 0);
     this.Shape7.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
     this.Shape7.setRotationPoint(-2.5F, 4.5F, 0.0F);
     this.Shape7.setTextureSize(32, 32);
     this.Shape7.mirror = true;
     setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
     this.Shape4 = new ModelRenderer(this, 0, 0);
     this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
     this.Shape4.setRotationPoint(-3.0F, 1.0F, 0.0F);
     this.Shape4.setTextureSize(32, 32);
     this.Shape4.mirror = true;
     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
     this.Shape5 = new ModelRenderer(this, 0, 0);
     this.Shape5.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
     this.Shape5.setRotationPoint(2.0F, 1.0F, 0.0F);
     this.Shape5.setTextureSize(32, 32);
     this.Shape5.mirror = true;
     setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
     this.Shape6 = new ModelRenderer(this, 0, 0);
     this.Shape6.addBox(0.0F, 4.0F, 0.0F, 1, 1, 1);
     this.Shape6.setRotationPoint(1.5F, 0.5F, 0.0F);
     this.Shape6.setTextureSize(32, 32);
     this.Shape6.mirror = true;
     setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
     this.Shape11 = new ModelRenderer(this, 0, 0);
     this.Shape11.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
     this.Shape11.setRotationPoint(2.0F, 5.0F, 0.0F);
     this.Shape11.setTextureSize(32, 32);
     this.Shape11.mirror = true;
     setRotation(this.Shape11, 0.0F, 0.0F, 0.0F);
     this.Shape12 = new ModelRenderer(this, 0, 0);
     this.Shape12.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
     this.Shape12.setRotationPoint(-3.0F, 5.0F, 0.0F);
     this.Shape12.setTextureSize(32, 32);
     this.Shape12.mirror = true;
     setRotation(this.Shape11, 0.0F, 0.0F, 0.0F);
     this.Shape9 = new ModelRenderer(this, 0, 0);
     this.Shape9.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1);
     this.Shape9.setRotationPoint(-3.0F, 1.0F, 0.0F);
     this.Shape9.setTextureSize(32, 32);
     this.Shape9.mirror = true;
     setRotation(this.Shape9, 0.0F, 0.0F, -1.22173F);
     this.Shape10 = new ModelRenderer(this, 0, 0);
     this.Shape10.addBox(0.0F, -6.0F, 0.0F, 1, 8, 1);
     this.Shape10.setRotationPoint(1.4F, -0.5F, 0.0F);
     this.Shape10.setTextureSize(32, 32);
     this.Shape10.mirror = true;
     setRotation(this.Shape10, 0.0F, 0.0F, -0.3490659F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Eye.render(f5);
     this.Eyeball.render(f5);
     this.Shape1.render(f5);
     this.Shape2.render(f5);
     this.Shape3.render(f5);
     this.Shape8.render(f5);
     this.Shape7.render(f5);
     this.Shape4.render(f5);
     this.Shape5.render(f5);
     this.Shape6.render(f5);
     this.Shape11.render(f5);
     this.Shape12.render(f5);
     this.Shape9.render(f5);
     this.Shape10.render(f5);
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