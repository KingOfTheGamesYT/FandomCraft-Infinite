 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelPot
   extends ModelBase
 {
   ModelRenderer base;
   ModelRenderer baseX;
   ModelRenderer baseZ;
   ModelRenderer bottom;
   ModelRenderer front1;
   ModelRenderer back1;
   ModelRenderer left1;
   ModelRenderer right1;
   ModelRenderer front2;
   ModelRenderer back2;
   ModelRenderer left2;
   ModelRenderer right2;
   ModelRenderer topfront1;
   ModelRenderer topback1;
   ModelRenderer topleft1;
   ModelRenderer topright1;
   ModelRenderer topback2;
   ModelRenderer topfront2;
   ModelRenderer topleft2;
   ModelRenderer topright2;

   public modelPot() {
     this.textureWidth = 64;
     this.textureHeight = 32;

     this.base = new ModelRenderer(this, 32, 0);
     this.base.addBox(0.0F, 0.0F, 0.0F, 8, 2, 8);
     this.base.setRotationPoint(-4.0F, 21.0F, -4.0F);
     this.base.setTextureSize(64, 32);
     setRotation(this.base, 0.0F, 0.0F, 0.0F);
     this.baseX = new ModelRenderer(this, 0, 11);
     this.baseX.addBox(0.0F, 0.0F, 0.0F, 10, 1, 6);
     this.baseX.setRotationPoint(-5.0F, 21.0F, -3.0F);
     this.baseX.setTextureSize(64, 32);
     setRotation(this.baseX, 0.0F, 0.0F, 0.0F);
     this.baseZ = new ModelRenderer(this, 0, 0);
     this.baseZ.addBox(0.0F, 0.0F, 0.0F, 6, 1, 10);
     this.baseZ.setRotationPoint(-3.0F, 21.0F, -5.0F);
     this.baseZ.setTextureSize(64, 32);
     setRotation(this.baseZ, 0.0F, 0.0F, 0.0F);
     this.bottom = new ModelRenderer(this, 0, 18);
     this.bottom.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6);
     this.bottom.setRotationPoint(-3.0F, 23.0F, -3.0F);
     this.bottom.setTextureSize(64, 32);
     setRotation(this.bottom, 0.0F, 0.0F, 0.0F);
     this.front1 = new ModelRenderer(this, 34, 25);
     this.front1.addBox(0.0F, 0.0F, 0.0F, 8, 6, 1);
     this.front1.setRotationPoint(-4.0F, 15.0F, -5.0F);
     this.front1.setTextureSize(64, 32);
     setRotation(this.front1, 0.0F, 0.0F, 0.0F);
     this.back1 = new ModelRenderer(this, 22, 0);
     this.back1.addBox(0.0F, 0.0F, 0.0F, 8, 6, 1);
     this.back1.setRotationPoint(-4.0F, 15.0F, 4.0F);
     this.back1.setTextureSize(64, 32);
     setRotation(this.back1, 0.0F, 0.0F, 0.0F);
     this.left1 = new ModelRenderer(this, 24, 10);
     this.left1.addBox(0.0F, 0.0F, 0.0F, 1, 6, 8);
     this.left1.setRotationPoint(-5.0F, 15.0F, -4.0F);
     this.left1.setTextureSize(64, 32);
     setRotation(this.left1, 0.0F, 0.0F, 0.0F);
     this.right1 = new ModelRenderer(this, 24, 10);
     this.right1.addBox(0.0F, 0.0F, 0.0F, 1, 6, 8);
     this.right1.setRotationPoint(4.0F, 15.0F, -4.0F);
     this.right1.setTextureSize(64, 32);
     setRotation(this.right1, 0.0F, 0.0F, 0.0F);
     this.front2 = new ModelRenderer(this, 0, 25);
     this.front2.addBox(0.0F, 0.0F, 0.0F, 6, 4, 1);
     this.front2.setRotationPoint(-3.0F, 16.0F, -6.0F);
     this.front2.setTextureSize(64, 32);
     setRotation(this.front2, 0.0F, 0.0F, 0.0F);
     this.back2 = new ModelRenderer(this, 0, 25);
     this.back2.addBox(0.0F, 0.0F, 0.0F, 6, 4, 1);
     this.back2.setRotationPoint(-3.0F, 16.0F, 5.0F);
     this.back2.setTextureSize(64, 32);
     setRotation(this.back2, 0.0F, 0.0F, 0.0F);
     this.left2 = new ModelRenderer(this, 42, 10);
     this.left2.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6);
     this.left2.setRotationPoint(-6.0F, 16.0F, -3.0F);
     this.left2.setTextureSize(64, 32);
     setRotation(this.left2, 0.0F, 0.0F, 0.0F);
     this.right2 = new ModelRenderer(this, 42, 10);
     this.right2.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6);
     this.right2.setRotationPoint(5.0F, 16.0F, -3.0F);
     this.right2.setTextureSize(64, 32);
     setRotation(this.right2, 0.0F, 0.0F, 0.0F);
     this.topfront1 = new ModelRenderer(this, 14, 25);
     this.topfront1.addBox(0.0F, 0.0F, 0.0F, 8, 1, 2);
     this.topfront1.setRotationPoint(-4.0F, 14.0F, -4.0F);
     this.topfront1.setTextureSize(64, 32);
     setRotation(this.topfront1, 0.0F, 0.0F, 0.0F);
     this.topback1 = new ModelRenderer(this, 14, 25);
     this.topback1.addBox(0.0F, 0.0F, 0.0F, 8, 1, 2);
     this.topback1.setRotationPoint(-4.0F, 14.0F, 2.0F);
     this.topback1.setTextureSize(64, 32);
     setRotation(this.topback1, 0.0F, 0.0F, 0.0F);
     this.topleft1 = new ModelRenderer(this, 42, 20);
     this.topleft1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 4);
     this.topleft1.setRotationPoint(2.0F, 14.0F, -2.0F);
     this.topleft1.setTextureSize(64, 32);
     setRotation(this.topleft1, 0.0F, 0.0F, 0.0F);
     this.topright1 = new ModelRenderer(this, 42, 20);
     this.topright1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 4);
     this.topright1.setRotationPoint(-4.0F, 14.0F, -2.0F);
     this.topright1.setTextureSize(64, 32);
     setRotation(this.topright1, 0.0F, 0.0F, 0.0F);
     this.topback2 = new ModelRenderer(this, 0, 4);
     this.topback2.addBox(0.0F, 0.0F, 0.0F, 4, 2, 1);
     this.topback2.setRotationPoint(-2.0F, 12.0F, 1.0F);
     this.topback2.setTextureSize(64, 32);
     setRotation(this.topback2, 0.0F, 0.0F, 0.0F);
     this.topfront2 = new ModelRenderer(this, 0, 7);
     this.topfront2.addBox(0.0F, 0.0F, 0.0F, 4, 2, 1);
     this.topfront2.setRotationPoint(-2.0F, 12.0F, -2.0F);
     this.topfront2.setTextureSize(64, 32);
     setRotation(this.topfront2, 0.0F, 0.0F, 0.0F);
     this.topleft2 = new ModelRenderer(this, 0, 0);
     this.topleft2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
     this.topleft2.setRotationPoint(-2.0F, 12.0F, -1.0F);
     this.topleft2.setTextureSize(64, 32);
     setRotation(this.topleft2, 0.0F, 0.0F, 0.0F);
     this.topright2 = new ModelRenderer(this, 0, 0);
     this.topright2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
     this.topright2.setRotationPoint(1.0F, 12.0F, -1.0F);
     this.topright2.setTextureSize(64, 32);
     setRotation(this.topright2, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.base.render(f5);
     this.baseX.render(f5);
     this.baseZ.render(f5);
     this.bottom.render(f5);
     this.front1.render(f5);
     this.back1.render(f5);
     this.left1.render(f5);
     this.right1.render(f5);
     this.front2.render(f5);
     this.back2.render(f5);
     this.left2.render(f5);
     this.right2.render(f5);
     this.topfront1.render(f5);
     this.topback1.render(f5);
     this.topleft1.render(f5);
     this.topright1.render(f5);
     this.topback2.render(f5);
     this.topfront2.render(f5);
     this.topleft2.render(f5);
     this.topright2.render(f5);
   }

   public void renderModel(float f) {
     this.base.render(f);
     this.baseX.render(f);
     this.baseZ.render(f);
     this.bottom.render(f);
     this.front1.render(f);
     this.back1.render(f);
     this.left1.render(f);
     this.right1.render(f);
     this.front2.render(f);
     this.back2.render(f);
     this.left2.render(f);
     this.right2.render(f);
     this.topfront1.render(f);
     this.topback1.render(f);
     this.topleft1.render(f);
     this.topright1.render(f);
     this.topback2.render(f);
     this.topfront2.render(f);
     this.topleft2.render(f);
     this.topright2.render(f);
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