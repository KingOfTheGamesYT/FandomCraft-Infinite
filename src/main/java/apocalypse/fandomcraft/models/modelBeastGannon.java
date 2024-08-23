 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.util.MathHelper;

 public class modelBeastGannon
   extends ModelBase
 {
   ModelRenderer tusk1;
   ModelRenderer tusk2;
   ModelRenderer WolfHead;
   ModelRenderer Body;
   ModelRenderer Mane;
   ModelRenderer Leg1;
   ModelRenderer Leg2;
   ModelRenderer Leg3;
   ModelRenderer Leg4;
   ModelRenderer Tail;
   ModelRenderer Ear1;
   ModelRenderer Ear2;
   ModelRenderer Nose;

   public modelBeastGannon() {
     this.textureWidth = 128;
     this.textureHeight = 64;

     this.tusk1 = new ModelRenderer(this, 0, 0);
     this.tusk1.addBox(1.0F, 0.0F, -7.0F, 1, 1, 4);
     this.tusk1.setRotationPoint(-1.0F, 13.5F, -7.0F);
     this.tusk1.setTextureSize(128, 64);
     this.tusk1.mirror = true;
     setRotation(this.tusk1, 0.4363323F, -0.2617994F, 0.0F);
     this.tusk2 = new ModelRenderer(this, 0, 0);
     this.tusk2.addBox(-2.0F, 0.0F, -7.0F, 1, 1, 4);
     this.tusk2.setRotationPoint(-1.0F, 13.5F, -7.0F);
     this.tusk2.setTextureSize(128, 64);
     this.tusk2.mirror = true;
     setRotation(this.tusk2, 0.4363323F, 0.2617994F, 0.0F);
     this.WolfHead = new ModelRenderer(this, 0, 5);
     this.WolfHead.addBox(-3.0F, -3.0F, -2.0F, 6, 6, 4);
     this.WolfHead.setRotationPoint(-1.0F, 13.5F, -8.0F);
     this.WolfHead.setTextureSize(128, 64);
     this.WolfHead.mirror = true;
     setRotation(this.WolfHead, 0.0F, 0.0F, 0.0F);
     this.Body = new ModelRenderer(this, 53, 0);
     this.Body.addBox(-4.0F, -2.0F, -3.0F, 7, 6, 7);
     this.Body.setRotationPoint(-0.5F, 13.5F, 5.0F);
     this.Body.setTextureSize(128, 64);
     this.Body.mirror = true;
     setRotation(this.Body, 1.570796F, 0.0F, 0.0F);
     this.Mane = new ModelRenderer(this, 21, 0);
     this.Mane.addBox(-4.0F, -3.0F, -3.0F, 8, 10, 8);
     this.Mane.setRotationPoint(-1.0F, 14.0F, -3.0F);
     this.Mane.setTextureSize(128, 64);
     this.Mane.mirror = true;
     setRotation(this.Mane, 1.570796F, 0.0F, 0.0F);
     this.Leg1 = new ModelRenderer(this, 0, 30);
     this.Leg1.addBox(-1.0F, 0.0F, -1.0F, 3, 9, 3);
     this.Leg1.setRotationPoint(-4.5F, 15.0F, 6.0F);
     this.Leg1.setTextureSize(128, 64);
     this.Leg1.mirror = true;
     setRotation(this.Leg1, 0.0F, 0.0F, 0.0F);
     this.Leg2 = new ModelRenderer(this, 0, 30);
     this.Leg2.addBox(-1.0F, 0.0F, -1.0F, 3, 9, 3);
     this.Leg2.setRotationPoint(1.5F, 15.0F, 6.0F);
     this.Leg2.setTextureSize(128, 64);
     this.Leg2.mirror = true;
     setRotation(this.Leg2, 0.0F, 0.0F, 0.0F);
     this.Leg3 = new ModelRenderer(this, 0, 18);
     this.Leg3.addBox(-2.0F, 0.0F, -1.0F, 3, 9, 3);
     this.Leg3.setRotationPoint(-4.0F, 15.0F, -4.0F);
     this.Leg3.setTextureSize(128, 64);
     this.Leg3.mirror = true;
     setRotation(this.Leg3, 0.0F, 0.0F, 0.0F);
     this.Leg4 = new ModelRenderer(this, 0, 18);
     this.Leg4.addBox(-1.0F, 0.0F, -1.0F, 3, 9, 3);
     this.Leg4.setRotationPoint(2.0F, 15.0F, -4.0F);
     this.Leg4.setTextureSize(128, 64);
     this.Leg4.mirror = true;
     setRotation(this.Leg4, 0.0F, 0.0F, 0.0F);
     this.Tail = new ModelRenderer(this, 12, 18);
     this.Tail.addBox(-1.0F, 0.0F, -1.0F, 4, 9, 4);
     this.Tail.setRotationPoint(-2.0F, 13.0F, 7.0F);
     this.Tail.setTextureSize(128, 64);
     this.Tail.mirror = true;
     setRotation(this.Tail, 1.130069F, 0.0F, 0.0F);
     this.Ear1 = new ModelRenderer(this, 15, 15);
     this.Ear1.addBox(-4.0F, -4.0F, -1.0F, 2, 2, 1);
     this.Ear1.setRotationPoint(-1.0F, 13.5F, -7.0F);
     this.Ear1.setTextureSize(128, 64);
     this.Ear1.mirror = true;
     setRotation(this.Ear1, 0.0F, 0.0F, 0.0F);
     this.Ear2 = new ModelRenderer(this, 15, 15);
     this.Ear2.addBox(2.0F, -4.0F, -1.0F, 2, 2, 1);
     this.Ear2.setRotationPoint(-1.0F, 13.5F, -7.0F);
     this.Ear2.setTextureSize(128, 64);
     this.Ear2.mirror = true;
     setRotation(this.Ear2, 0.0F, 0.0F, 0.0F);
     this.Nose = new ModelRenderer(this, 28, 18);
     this.Nose.addBox(-1.5F, 0.0F, -4.0F, 3, 3, 5);
     this.Nose.setRotationPoint(-1.0F, 14.5F, -7.0F);
     this.Nose.setTextureSize(128, 64);
     this.Nose.mirror = true;
     setRotation(this.Nose, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.tusk1.render(f5);
     this.tusk2.render(f5);
     this.WolfHead.render(f5);
     this.Body.render(f5);
     this.Mane.render(f5);
     this.Leg1.render(f5);
     this.Leg2.render(f5);
     this.Leg3.render(f5);
     this.Leg4.render(f5);
     this.Tail.render(f5);
     this.Ear1.render(f5);
     this.Ear2.render(f5);
     this.Nose.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
     model.rotateAngleX = x;
     model.rotateAngleY = y;
     model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
     super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     float f6 = 57.295776F;
     this.WolfHead.rotateAngleX = f4 / 57.295776F;
     this.WolfHead.rotateAngleY = f3 / 57.295776F;
     this.Mane.rotateAngleX = this.WolfHead.rotateAngleX;
     this.Mane.rotateAngleZ = this.WolfHead.rotateAngleZ;
     this.Mane.rotateAngleY = this.WolfHead.rotateAngleY;
     this.Nose.rotateAngleX = this.WolfHead.rotateAngleX;
     this.Nose.rotateAngleZ = this.WolfHead.rotateAngleZ;
     this.Nose.rotateAngleY = this.WolfHead.rotateAngleY;
     this.Ear1.rotateAngleX = this.WolfHead.rotateAngleX;
     this.Ear1.rotateAngleZ = this.WolfHead.rotateAngleZ;
     this.Ear1.rotateAngleY = this.WolfHead.rotateAngleY;
     this.Ear2.rotateAngleX = this.WolfHead.rotateAngleX;
     this.Ear2.rotateAngleZ = this.WolfHead.rotateAngleZ;
     this.Ear2.rotateAngleY = this.WolfHead.rotateAngleY;
     this.tusk1.rotateAngleX = this.WolfHead.rotateAngleX;
     this.tusk1.rotateAngleZ = this.WolfHead.rotateAngleZ;
     this.tusk1.rotateAngleY = this.WolfHead.rotateAngleY;
     this.tusk2.rotateAngleX = this.WolfHead.rotateAngleX;
     this.tusk2.rotateAngleZ = this.WolfHead.rotateAngleZ;
     this.tusk2.rotateAngleY = this.WolfHead.rotateAngleY;
     this.Body.rotateAngleX = 1.5707964F;
     this.Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
     this.Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
     this.Leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
     this.Leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
   }
 }