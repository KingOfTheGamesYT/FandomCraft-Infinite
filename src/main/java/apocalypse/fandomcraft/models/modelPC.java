 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelPC
   extends ModelBase
 {
   ModelRenderer keyboard;
   ModelRenderer monitor;
   ModelRenderer mouse;
   ModelRenderer tower;
   ModelRenderer neck;
   ModelRenderer neckstand;
   ModelRenderer neckpiece;

   public modelPC() {
     this.textureWidth = 128;
     this.textureHeight = 64;

     this.keyboard = new ModelRenderer(this, 0, 52);
     this.keyboard.addBox(0.0F, 0.0F, 0.0F, 29, 1, 11);
     this.keyboard.setRotationPoint(-14.0F, 53.0F, -14.0F);
     this.keyboard.setTextureSize(128, 64);
     this.keyboard.mirror = true;
     setRotation(this.keyboard, 0.0F, -0.3346075F, 0.0F);

     // Initialize monitor before adding a box
     this.monitor = new ModelRenderer(this, 6, 25);
     this.monitor.addBox(0.0F, 0.0F, 0.0F, 36, 25, 2);
     this.monitor.setRotationPoint(-18.0F, 17.0F, 8.0F);
     this.monitor.setTextureSize(128, 64);
     this.monitor.mirror = true;
     setRotation(this.monitor, 0.0F, 0.0F, 0.0F);

     this.mouse = new ModelRenderer(this, 69, 56);
     this.mouse.addBox(0.0F, -1.0F, 0.0F, 3, 2, 5);
     this.mouse.setRotationPoint(14.0F, 53.0F, -13.0F);
     this.mouse.setTextureSize(128, 64);
     this.mouse.mirror = true;
     setRotation(this.mouse, 0.0F, -0.2974289F, 0.0F);

     this.tower = new ModelRenderer(this, 6, 8);
     this.tower.addBox(0.0F, 0.0F, 0.0F, 24, 7, 10);
     this.tower.setRotationPoint(-12.0F, 47.0F, 6.0F);
     this.tower.setTextureSize(128, 64);
     this.tower.mirror = true;
     setRotation(this.tower, 0.0F, 0.0F, 0.0F);

     this.neck = new ModelRenderer(this, 0, 31);
     this.neck.addBox(0.0F, 0.0F, 0.0F, 2, 20, 1);
     this.neck.setRotationPoint(-1.0F, 27.0F, 10.0F);
     this.neck.setTextureSize(128, 64);
     this.neck.mirror = true;
     setRotation(this.neck, 0.1115358F, 0.0F, 0.0F);

     this.neckstand = new ModelRenderer(this, 10, 0);
     this.neckstand.addBox(0.0F, 0.0F, 0.0F, 12, 1, 6);
     this.neckstand.setRotationPoint(-6.0F, 46.0F, 9.0F);
     this.neckstand.setTextureSize(128, 64);
     this.neckstand.mirror = true;
     setRotation(this.neckstand, 0.0F, 0.0F, 0.0F);

     this.neckpiece = new ModelRenderer(this, 0, 0);
     this.neckpiece.addBox(0.0F, 0.0F, 0.0F, 4, 6, 1);
     this.neckpiece.setRotationPoint(-2.0F, 25.0F, 10.0F);
     this.neckpiece.setTextureSize(128, 64);
     this.neckpiece.mirror = true;
     setRotation(this.neckpiece, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.keyboard.render(f5);
     this.monitor.render(f5);
     this.mouse.render(f5);
     this.tower.render(f5);
     this.neck.render(f5);
     this.neckstand.render(f5);
     this.neckpiece.render(f5);
   }

   public void renderModel(float f) {
     this.keyboard.render(f);
     this.monitor.render(f);
     this.mouse.render(f);
     this.tower.render(f);
     this.neck.render(f);
     this.neckstand.render(f);
     this.neckpiece.render(f);
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