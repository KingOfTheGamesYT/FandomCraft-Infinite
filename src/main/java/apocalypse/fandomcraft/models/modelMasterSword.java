 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelMasterSword
   extends ModelBase
 {
   ModelRenderer hilt1;
   ModelRenderer jewel1;
   ModelRenderer wing2;
   ModelRenderer wing1;
   ModelRenderer jewel2;
   ModelRenderer blade1;
   ModelRenderer triforce;
   ModelRenderer point;
   ModelRenderer bladeedge;
   ModelRenderer bladeedge2;
   ModelRenderer wing11;
   ModelRenderer wing22;

   public modelMasterSword() {
     this.textureWidth = 64;
     this.textureHeight = 64;

     this.hilt1 = new ModelRenderer(this, 0, 50);
     this.hilt1.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2);
     this.hilt1.setRotationPoint(-1.0F, 14.0F, -1.0F);
     this.hilt1.setTextureSize(64, 64);
     this.hilt1.mirror = true;
     setRotation(this.hilt1, 0.0F, 0.0F, 0.0F);
     this.jewel1 = new ModelRenderer(this, 0, 44);
     this.jewel1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
     this.jewel1.setRotationPoint(-1.5F, 14.5F, -1.5F);
     this.jewel1.setTextureSize(64, 64);
     this.jewel1.mirror = true;
     setRotation(this.jewel1, 0.0F, 0.0F, 0.0F);
     this.wing2 = new ModelRenderer(this, 16, 50);
     this.wing2.addBox(0.0F, 0.0F, 0.0F, 2, 8, 4);
     this.wing2.setRotationPoint(-1.0F, 12.0F, 6.0F);
     this.wing2.setTextureSize(64, 64);
     this.wing2.mirror = true;
     setRotation(this.wing2, -1.22173F, 0.0F, 0.0F);
     this.wing1 = new ModelRenderer(this, 28, 50);
     this.wing1.addBox(0.0F, 0.0F, 0.0F, 2, 8, 4);
     this.wing1.setRotationPoint(-1.0F, 15.8F, -7.3F);
     this.wing1.setTextureSize(64, 64);
     this.wing1.mirror = true;
     setRotation(this.wing1, 1.22173F, 0.0F, 0.0F);
     this.jewel2 = new ModelRenderer(this, 12, 46);
     this.jewel2.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2);
     this.jewel2.setRotationPoint(-2.0F, 16.0F, -1.4F);
     this.jewel2.setTextureSize(64, 64);
     this.jewel2.mirror = true;
     setRotation(this.jewel2, 0.7853982F, 0.0F, 0.0F);
     this.blade1 = new ModelRenderer(this, 0, 0);
     this.blade1.addBox(0.0F, 0.0F, 0.0F, 1, 40, 3);
     this.blade1.setRotationPoint(-0.5F, -26.0F, -1.5F);
     this.blade1.setTextureSize(64, 64);
     this.blade1.mirror = true;
     setRotation(this.blade1, 0.0F, 0.0F, 0.0F);
     this.triforce = new ModelRenderer(this, 24, 48);
     this.triforce.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
     this.triforce.setRotationPoint(-1.0F, 12.5F, -0.75F);
     this.triforce.setTextureSize(64, 64);
     this.triforce.mirror = true;
     setRotation(this.triforce, 0.7853982F, 0.0F, 0.0F);
     this.point = new ModelRenderer(this, 30, 44);
     this.point.addBox(0.0F, 0.0F, 0.0F, 1, 3, 3);
     this.point.setRotationPoint(-0.5F, -26.0F, -2.1F);
     this.point.setTextureSize(64, 64);
     this.point.mirror = true;
     setRotation(this.point, 0.7853982F, 0.0F, 0.0F);
     this.bladeedge = new ModelRenderer(this, 8, 0);
     this.bladeedge.addBox(0.0F, 0.0F, 0.0F, 1, 35, 2);
     this.bladeedge.setRotationPoint(-0.5F, -26.0F, -2.0F);
     this.bladeedge.setTextureSize(64, 64);
     this.bladeedge.mirror = true;
     setRotation(this.bladeedge, 0.0174533F, 0.0F, 0.0F);
     this.bladeedge2 = new ModelRenderer(this, 14, 0);
     this.bladeedge2.addBox(0.0F, 0.0F, 0.0F, 1, 35, 2);
     this.bladeedge2.setRotationPoint(-0.5F, -26.0F, 0.0F);
     this.bladeedge2.setTextureSize(64, 64);
     this.bladeedge2.mirror = true;
     setRotation(this.bladeedge2, -0.0174533F, 0.0F, 0.0F);
     this.wing11 = new ModelRenderer(this, 20, 0);
     this.wing11.addBox(0.0F, 0.0F, 0.0F, 1, 4, 5);
     this.wing11.setRotationPoint(-0.5F, 13.0F, 4.5F);
     this.wing11.setTextureSize(64, 64);
     this.wing11.mirror = true;
     setRotation(this.wing11, 0.7853982F, 0.0F, 0.0F);
     this.wing22 = new ModelRenderer(this, 20, 9);
     this.wing22.addBox(0.0F, 0.0F, 0.0F, 1, 4, 5);
     this.wing22.setRotationPoint(-0.5F, 9.5F, -8.0F);
     this.wing22.setTextureSize(64, 64);
     this.wing22.mirror = true;
     setRotation(this.wing22, -0.7853982F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.hilt1.render(f5);
     this.jewel1.render(f5);
     this.wing2.render(f5);
     this.wing1.render(f5);
     this.jewel2.render(f5);
     this.blade1.render(f5);
     this.triforce.render(f5);
     this.point.render(f5);
     this.bladeedge.render(f5);
     this.bladeedge2.render(f5);
     this.wing11.render(f5);
     this.wing22.render(f5);
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