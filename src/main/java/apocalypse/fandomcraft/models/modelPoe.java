 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.util.MathHelper;

 public class modelPoe
   extends ModelBase
 {
   ModelRenderer Head;
   ModelRenderer Headwear;
   ModelRenderer Body;
   ModelRenderer RightArm;
   ModelRenderer LeftArm;
   ModelRenderer RightLeg;
   ModelRenderer LeftLeg;

   public modelPoe() {
     this.textureWidth = 64;
     this.textureHeight = 32;

     this.Head = new ModelRenderer(this, 0, 0);
     this.Head.addBox(-3.5F, -7.5F, -3.5F, 7, 7, 7);
     this.Head.setRotationPoint(0.0F, -11.0F, 0.0F);
     this.Head.setTextureSize(64, 32);
     this.Head.mirror = true;
     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
     this.Headwear = new ModelRenderer(this, 0, 16);
     this.Headwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
     this.Headwear.setRotationPoint(0.0F, -11.0F, 0.0F);
     this.Headwear.setTextureSize(64, 32);
     this.Headwear.mirror = true;
     setRotation(this.Headwear, 0.0F, 0.0F, 0.0F);
     this.Body = new ModelRenderer(this, 32, 16);
     this.Body.addBox(-4.0F, 0.0F, -3.0F, 8, 9, 7);
     this.Body.setRotationPoint(0.0F, -11.0F, 0.0F);
     this.Body.setTextureSize(64, 32);
     this.Body.mirror = true;
     setRotation(this.Body, 0.3490659F, 0.0F, 0.0F);
     this.RightArm = new ModelRenderer(this, 52, 0);
     this.RightArm.addBox(-1.0F, -2.0F, -1.0F, 2, 6, 2);
     this.RightArm.setRotationPoint(-5.0F, -9.0F, -1.0F);
     this.RightArm.setTextureSize(64, 32);
     this.RightArm.mirror = true;
     setRotation(this.RightArm, -0.8203047F, 0.1919862F, 0.2617994F);
     this.LeftArm = new ModelRenderer(this, 52, 0);
     this.LeftArm.addBox(-1.0F, -2.0F, -1.0F, 2, 6, 2);
     this.LeftArm.setRotationPoint(5.0F, -9.0F, 0.0F);
     this.LeftArm.setTextureSize(64, 32);
     setRotation(this.LeftArm, -0.1396263F, -0.2094395F, -0.1745329F);
     this.LeftArm.mirror = false;
     this.RightLeg = new ModelRenderer(this, 32, 0);
     this.RightLeg.addBox(-2.5F, 0.0F, -2.5F, 5, 7, 5);
     this.RightLeg.setRotationPoint(-6.0F, -4.0F, -4.0F);
     this.RightLeg.setTextureSize(64, 32);
     setRotation(this.RightLeg, 0.0F, 0.0F, 0.0F);
     this.LeftLeg = new ModelRenderer(this, 0, 0);
     this.LeftLeg.addBox(-1.5F, 0.0F, -1.0F, 3, 3, 0);
     this.LeftLeg.setRotationPoint(-6.0F, -7.0F, -3.0F);
     this.LeftLeg.setTextureSize(64, 32);
     setRotation(this.LeftLeg, 0.0F, 0.0F, 0.0F);
     this.LeftLeg.mirror = false;
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Head.render(f5);
     this.Headwear.render(f5);
     this.Body.render(f5);
     this.RightArm.render(f5);
     this.LeftArm.render(f5);
     this.RightLeg.render(f5);
     this.LeftLeg.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
     model.rotateAngleX = x;
     model.rotateAngleY = y;
     model.rotateAngleZ = z;
   }

   public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entity) {
     super.setRotationAngles(p_78087_6_, p_78087_6_, p_78087_6_, p_78087_6_, p_78087_6_, p_78087_6_, entity);
     this.Head.rotateAngleY = p_78087_4_ / 57.295776F;
     this.Head.rotateAngleX = p_78087_5_ / 57.295776F;
     this.RightArm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + 3.1415927F) * 2.0F * p_78087_2_ * 0.5F;
     this.LeftArm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 2.0F * p_78087_2_ * 0.5F;
     this.RightArm.rotateAngleZ = 0.0F;
     this.LeftArm.rotateAngleZ = 0.0F;
     this.Headwear.rotateAngleY = this.Head.rotateAngleY;
     this.Headwear.rotateAngleX = this.Head.rotateAngleX;
     this.LeftLeg.rotateAngleY = this.RightArm.rotateAngleY;
     this.LeftLeg.rotateAngleX = this.RightArm.rotateAngleX;
     this.RightLeg.rotateAngleY = this.LeftLeg.rotateAngleY;
     this.RightLeg.rotateAngleX = this.LeftLeg.rotateAngleX;
   }
 }