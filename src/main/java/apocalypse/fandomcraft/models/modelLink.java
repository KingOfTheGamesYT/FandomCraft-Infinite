 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.util.MathHelper;

 public class modelLink
   extends ModelBase
 {
   ModelRenderer Sword;
   ModelRenderer Shield;
   ModelRenderer Hair;
   ModelRenderer Hat;
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer rightarm;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;
   public int heldItemRight;
   public boolean isSneak;
   public int heldItemLeft;
   public boolean aimedBow;

   public modelLink() {
     this.textureWidth = 256;
     this.textureHeight = 128;

     this.Sword = new ModelRenderer(this, 108, 24);
     this.Sword.addBox(-7.5F, -16.0F, 0.0F, 15, 40, 0);
     this.Sword.setRotationPoint(4.0F, -10.0F, 5.0F);
     this.Sword.setTextureSize(256, 128);
     this.Sword.mirror = true;
     setRotation(this.Sword, 0.0F, 0.0F, 0.5759587F);
     this.Shield = new ModelRenderer(this, 64, 0);
     this.Shield.addBox(-10.0F, -12.0F, 0.0F, 20, 26, 1);
     this.Shield.setRotationPoint(0.0F, -10.0F, 6.0F);
     this.Shield.setTextureSize(256, 128);
     this.Shield.mirror = true;
     setRotation(this.Shield, 0.0F, 0.0F, 0.0F);
     this.Hair = new ModelRenderer(this, 72, 64);
     this.Hair.addBox(-8.5F, -8.5F, -8.5F, 17, 17, 17);
     this.Hair.setRotationPoint(0.0F, -32.0F, -1.0F);
     this.Hair.setTextureSize(256, 128);
     this.Hair.mirror = true;
     setRotation(this.Hair, 0.0F, 0.0F, 0.0F);
     this.Hat = new ModelRenderer(this, 0, 64);
     this.Hat.addBox(-9.0F, 0.0F, -9.0F, 18, 26, 18);
     this.Hat.setRotationPoint(0.0F, -42.0F, -1.0F);
     this.Hat.setTextureSize(256, 128);
     this.Hat.mirror = true;
     setRotation(this.Hat, 0.0F, 0.0F, 0.0F);
     this.head = new ModelRenderer(this, 0, 0);
     this.head.addBox(-8.0F, -16.0F, -7.0F, 16, 16, 16);
     this.head.setRotationPoint(0.0F, -24.0F, -2.0F);
     this.head.setTextureSize(256, 128);
     this.head.mirror = true;
     setRotation(this.head, 0.0F, 0.0F, 0.0F);
     this.body = new ModelRenderer(this, 32, 32);
     this.body.addBox(-8.0F, 0.0F, -4.0F, 16, 24, 8);
     this.body.setRotationPoint(0.0F, -24.0F, 0.0F);
     this.body.setTextureSize(256, 128);
     this.body.mirror = true;
     setRotation(this.body, 0.0F, 0.0F, 0.0F);
     this.rightarm = new ModelRenderer(this, 80, 32);
     this.rightarm.addBox(-7.0F, -4.0F, -3.5F, 7, 24, 7);
     this.rightarm.setRotationPoint(-8.0F, -20.0F, 0.0F);
     this.rightarm.setTextureSize(256, 128);
     this.rightarm.mirror = true;
     setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
     this.leftarm = new ModelRenderer(this, 80, 32);
     this.leftarm.addBox(0.0F, -4.0F, -3.5F, 7, 24, 7);
     this.leftarm.setRotationPoint(8.0F, -20.0F, 0.0F);
     this.leftarm.setTextureSize(256, 128);
     this.leftarm.mirror = true;
     setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
     this.rightleg = new ModelRenderer(this, 0, 32);
     this.rightleg.addBox(-4.0F, 0.0F, -4.0F, 8, 24, 8);
     this.rightleg.setRotationPoint(-4.0F, 0.0F, 0.0F);
     this.rightleg.setTextureSize(256, 128);
     this.rightleg.mirror = true;
     setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
     this.leftleg = new ModelRenderer(this, 0, 32);
     this.leftleg.addBox(-4.0F, 0.0F, -4.0F, 8, 24, 8);
     this.leftleg.setRotationPoint(4.0F, 0.0F, 0.0F);
     this.leftleg.setTextureSize(256, 128);
     this.leftleg.mirror = true;
     setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.Sword.render(f5);
     this.Shield.render(f5);
     this.Hair.render(f5);
     this.Hat.render(f5);
     this.head.render(f5);
     this.body.render(f5);
     this.rightarm.render(f5);
     this.leftarm.render(f5);
     this.rightleg.render(f5);
     this.leftleg.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
     model.rotateAngleX = x;
     model.rotateAngleY = y;
     model.rotateAngleZ = z;
   }

   public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
     this.head.rotateAngleY = p_78087_4_ / 57.295776F;
     this.head.rotateAngleX = p_78087_5_ / 57.295776F;
     this.rightarm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + 3.1415927F) * 2.0F * p_78087_2_ * 0.5F;
     this.leftarm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 2.0F * p_78087_2_ * 0.5F;
     this.rightarm.rotateAngleZ = 0.0F;
     this.leftarm.rotateAngleZ = 0.0F;
     this.rightleg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
     this.leftleg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + 3.1415927F) * 1.4F * p_78087_2_;
     this.rightleg.rotateAngleY = 0.0F;
     this.leftleg.rotateAngleY = 0.0F;
     this.Hat.rotateAngleY = this.head.rotateAngleY;
     this.Hat.rotateAngleX = this.head.rotateAngleX;
     this.Hair.rotateAngleY = this.head.rotateAngleY;
     this.Hair.rotateAngleX = this.head.rotateAngleX;
     if (this.heldItemLeft != 0)
     {
       this.leftarm.rotateAngleX = this.leftarm.rotateAngleX * 0.5F - 0.31415927F * this.heldItemLeft;
     }
     if (this.heldItemRight != 0)
     {
       this.rightarm.rotateAngleX = this.rightarm.rotateAngleX * 0.5F - 0.31415927F * this.heldItemRight;
     }
     this.rightarm.rotateAngleY = 0.0F;
     this.leftarm.rotateAngleY = 0.0F;

     this.rightarm.rotateAngleZ += MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
     this.leftarm.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
     this.rightarm.rotateAngleX += MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
     this.leftarm.rotateAngleX -= MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
   }
 }