 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelPlant
   extends ModelBase
 {
   ModelRenderer base;
   ModelRenderer right;
   ModelRenderer left;
   ModelRenderer front;
   ModelRenderer back;
   ModelRenderer middle;
   ModelRenderer tree;
   ModelRenderer leaves1;
   ModelRenderer leaves_2;
   ModelRenderer leaves_3;
   ModelRenderer leaves_4;
   ModelRenderer tree2;

   public modelPlant() {
     this.textureWidth = 64;
     this.textureHeight = 64;

     this.base = new ModelRenderer(this, 0, 55);
     this.base.addBox(0.0F, 0.0F, 0.0F, 8, 1, 8);
     this.base.setRotationPoint(-4.0F, 23.0F, -4.0F);
     this.base.setTextureSize(64, 64);
     this.base.mirror = true;
     setRotation(this.base, 0.0F, 0.0F, 0.0F);
     this.right = new ModelRenderer(this, 0, 40);
     this.right.addBox(0.0F, 0.0F, 0.0F, 1, 7, 8);
     this.right.setRotationPoint(4.0F, 16.0F, -4.0F);
     this.right.setTextureSize(64, 64);
     this.right.mirror = true;
     setRotation(this.right, 0.0F, 0.0F, 0.0F);
     this.left = new ModelRenderer(this, 0, 40);
     this.left.addBox(0.0F, 0.0F, 0.0F, 1, 7, 8);
     this.left.setRotationPoint(-5.0F, 16.0F, -4.0F);
     this.left.setTextureSize(64, 64);
     this.left.mirror = true;
     setRotation(this.left, 0.0F, 0.0F, 0.0F);
     this.front = new ModelRenderer(this, 0, 32);
     this.front.addBox(0.0F, 0.0F, 0.0F, 8, 7, 1);
     this.front.setRotationPoint(-4.0F, 16.0F, -5.0F);
     this.front.setTextureSize(64, 64);
     this.front.mirror = true;
     setRotation(this.front, 0.0F, 0.0F, 0.0F);
     this.back = new ModelRenderer(this, 0, 32);
     this.back.addBox(0.0F, 0.0F, 0.0F, 8, 7, 1);
     this.back.setRotationPoint(-4.0F, 16.0F, 4.0F);
     this.back.setTextureSize(64, 64);
     this.back.mirror = true;
     setRotation(this.back, 0.0F, 0.0F, 0.0F);
     this.middle = new ModelRenderer(this, 32, 50);
     this.middle.addBox(0.0F, 0.0F, 0.0F, 8, 6, 8);
     this.middle.setRotationPoint(-4.0F, 17.0F, -4.0F);
     this.middle.setTextureSize(64, 64);
     this.middle.mirror = true;
     setRotation(this.middle, 0.0F, 0.0F, 0.0F);
     this.tree = new ModelRenderer(this, 18, 39);
     this.tree.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2);
     this.tree.setRotationPoint(-1.5F, 3.0F, 0.0F);
     this.tree.setTextureSize(64, 64);
     this.tree.mirror = true;
     setRotation(this.tree, 0.0F, 0.7853982F, 0.0F);
     this.leaves1 = new ModelRenderer(this, 0, 0);
     this.leaves1.addBox(0.0F, 0.0F, 0.0F, 10, 10, 10);
     this.leaves1.setRotationPoint(-5.0F, -8.0F, -5.0F);
     this.leaves1.setTextureSize(64, 64);
     this.leaves1.mirror = true;
     setRotation(this.leaves1, 0.0F, 0.0F, 0.0F);
     this.leaves_2 = new ModelRenderer(this, 0, 0);
     this.leaves_2.addBox(0.0F, 0.0F, 0.0F, 8, 8, 12);
     this.leaves_2.setRotationPoint(-4.0F, -7.0F, -6.0F);
     this.leaves_2.setTextureSize(64, 64);
     this.leaves_2.mirror = true;
     setRotation(this.leaves_2, 0.0F, 0.0F, 0.0F);
     this.leaves_3 = new ModelRenderer(this, 0, 0);
     this.leaves_3.addBox(0.0F, 0.0F, 0.0F, 12, 8, 8);
     this.leaves_3.setRotationPoint(-6.0F, -7.0F, -4.0F);
     this.leaves_3.setTextureSize(64, 64);
     this.leaves_3.mirror = true;
     setRotation(this.leaves_3, 0.0F, 0.0F, 0.0F);
     this.leaves_4 = new ModelRenderer(this, 0, 0);
     this.leaves_4.addBox(0.0F, 0.0F, 0.0F, 8, 12, 8);
     this.leaves_4.setRotationPoint(-4.0F, -9.0F, -4.0F);
     this.leaves_4.setTextureSize(64, 64);
     this.leaves_4.mirror = true;
     setRotation(this.leaves_4, 0.0F, 0.0F, 0.0F);
     this.tree2 = new ModelRenderer(this, 18, 39);
     this.tree2.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2);
     this.tree2.setRotationPoint(-1.0F, 3.0F, 1.0F);
     this.tree2.setTextureSize(64, 64);
     this.tree2.mirror = true;
     setRotation(this.tree2, 0.0F, 1.570796F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.base.render(f5);
     this.right.render(f5);
     this.left.render(f5);
     this.front.render(f5);
     this.back.render(f5);
     this.middle.render(f5);
     this.tree.render(f5);
     this.leaves1.render(f5);
     this.leaves_2.render(f5);
     this.leaves_3.render(f5);
     this.leaves_4.render(f5);
     this.tree2.render(f5);
   }

   public void renderModel(float f) {
     this.base.render(f);
     this.right.render(f);
     this.left.render(f);
     this.front.render(f);
     this.back.render(f);
     this.middle.render(f);
     this.tree.render(f);
     this.leaves1.render(f);
     this.leaves_2.render(f);
     this.leaves_3.render(f);
     this.leaves_4.render(f);
     this.tree2.render(f);
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