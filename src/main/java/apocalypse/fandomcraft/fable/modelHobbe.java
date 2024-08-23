 package apocalypse.fandomcraft.fable;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.util.MathHelper;

 public class modelHobbe
   extends ModelBase
 {
   ModelRenderer Body;
   ModelRenderer Head;
   ModelRenderer LeftLeg;
   ModelRenderer RightLeg;
   ModelRenderer LeftArm;
   ModelRenderer RightArm;
   ModelRenderer HatBase;
   ModelRenderer HatTop;
   ModelRenderer HatCurl;

   public modelHobbe() {
     this.textureWidth = 128;
     this.textureHeight = 64;

     this.Body = new ModelRenderer(this, 28, 18);
     this.Body.addBox(-6.0F, 0.0F, -6.0F, 12, 12, 12);
     this.Body.setRotationPoint(0.0F, 7.0F, 0.0F);
     this.Body.setTextureSize(128, 64);
     this.Body.mirror = true;
     setRotation(this.Body, 0.0F, 0.0F, 0.0F);
     this.Head = new ModelRenderer(this, 0, 0);
     this.Head.addBox(-5.0F, -8.0F, -5.0F, 10, 8, 10);
     this.Head.setRotationPoint(0.0F, 7.0F, 0.0F);
     this.Head.setTextureSize(128, 64);
     this.Head.mirror = true;
     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
     this.LeftLeg = new ModelRenderer(this, 0, 18);
     this.LeftLeg.addBox(-4.0F, 0.0F, -2.0F, 4, 6, 4);
     this.LeftLeg.setRotationPoint(-1.0F, 18.0F, 0.0F);
     this.LeftLeg.setTextureSize(128, 64);
     this.LeftLeg.mirror = true;
     setRotation(this.LeftLeg, 0.0F, 0.0F, 0.0F);
     this.RightLeg = new ModelRenderer(this, 0, 18);
     this.RightLeg.addBox(0.0F, 0.0F, -2.0F, 4, 6, 4);
     this.RightLeg.setRotationPoint(1.0F, 18.0F, 0.0F);
     this.RightLeg.setTextureSize(128, 64);
     this.RightLeg.mirror = true;
     setRotation(this.RightLeg, 0.0F, 0.0F, 0.0F);
     this.LeftArm = new ModelRenderer(this, 16, 18);
     this.LeftArm.addBox(-3.0F, 0.0F, -1.0F, 3, 8, 3);
     this.LeftArm.setRotationPoint(-6.0F, 8.0F, 0.0F);
     this.LeftArm.setTextureSize(128, 64);
     this.LeftArm.mirror = true;
     setRotation(this.LeftArm, 0.0F, 0.0F, 0.0F);
     this.RightArm = new ModelRenderer(this, 16, 18);
     this.RightArm.addBox(0.0F, 0.0F, -1.0F, 3, 8, 3);
     this.RightArm.setRotationPoint(6.0F, 8.0F, 0.0F);
     this.RightArm.setTextureSize(128, 64);
     this.RightArm.mirror = true;
     setRotation(this.RightArm, 0.0F, 0.0F, 0.0F);
     this.HatBase = new ModelRenderer(this, 76, 29);
     this.HatBase.addBox(-6.0F, -8.0F, -8.0F, 12, 2, 12);
     this.HatBase.setRotationPoint(0.0F, 7.0F, 0.0F);
     this.HatBase.setTextureSize(128, 64);
     this.HatBase.mirror = true;
     setRotation(this.HatBase, -0.2617994F, 0.0F, 0.0F);
     this.HatTop = new ModelRenderer(this, 76, 13);
     this.HatTop.addBox(-4.0F, -11.0F, -7.0F, 8, 8, 8);
     this.HatTop.setRotationPoint(0.0F, 7.0F, 0.0F);
     this.HatTop.setTextureSize(128, 64);
     this.HatTop.mirror = true;
     setRotation(this.HatTop, -0.5585054F, 0.0F, 0.0F);
     this.HatCurl = new ModelRenderer(this, 76, 0);
     this.HatCurl.addBox(-2.0F, -16.0F, -7.0F, 4, 9, 4);
     this.HatCurl.setRotationPoint(0.0F, 7.0F, 0.0F);
     this.HatCurl.setTextureSize(128, 64);
     this.HatCurl.mirror = true;
     setRotation(this.HatCurl, -0.8552113F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Body.render(f5);
     this.Head.render(f5);
     this.LeftLeg.render(f5);
     this.RightLeg.render(f5);
     this.LeftArm.render(f5);
     this.RightArm.render(f5);
     this.HatBase.render(f5);
     this.HatTop.render(f5);
     this.HatCurl.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
     model.rotateAngleX = x;
     model.rotateAngleY = y;
     model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
     super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Head.rotateAngleY = f3 / 57.295776F;
     this.Head.rotateAngleX = f4 / 57.295776F;
     this.RightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
     this.LeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
     this.RightLeg.rotateAngleY = 0.0F;
     this.LeftLeg.rotateAngleY = 0.0F;
     this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 2.0F * f1 * 0.5F;
     this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
     this.RightArm.rotateAngleZ = 0.0F;
     this.LeftArm.rotateAngleZ = 0.0F;
     this.HatBase.rotateAngleX = this.Head.rotateAngleX;
     this.HatBase.rotateAngleY = this.Head.rotateAngleY;
     this.HatBase.rotateAngleZ = this.Head.rotateAngleZ;
     this.HatTop.rotateAngleX = this.HatBase.rotateAngleX;
     this.HatTop.rotateAngleY = this.HatBase.rotateAngleY;
     this.HatTop.rotateAngleZ = this.HatBase.rotateAngleZ;
     this.HatCurl.rotateAngleX = this.HatTop.rotateAngleX;
     this.HatCurl.rotateAngleY = this.HatTop.rotateAngleY;
     this.HatCurl.rotateAngleZ = this.HatTop.rotateAngleZ;
   }
 }