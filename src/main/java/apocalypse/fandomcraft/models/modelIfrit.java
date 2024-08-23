 package apocalypse.fandomcraft.models;

 import apocalypse.fandomcraft.entity.EntityIfrit;
 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.util.MathHelper;

 public class modelIfrit
   extends ModelBase
 {
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer rightarm;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;
   ModelRenderer chest;
   ModelRenderer mane;
   ModelRenderer horn11;
   ModelRenderer horn12;
   ModelRenderer horn21;
   ModelRenderer horn22;

   public modelIfrit() {
     this.textureWidth = 128;
     this.textureHeight = 64;

     this.head = new ModelRenderer(this, 52, 29);
     this.head.addBox(-4.0F, -8.0F, -6.0F, 8, 8, 8);
     this.head.setRotationPoint(0.0F, -10.0F, -3.0F);
     this.head.setTextureSize(128, 64);
     this.head.mirror = true;
     setRotation(this.head, 0.0F, 0.0F, 0.0F);
     this.body = new ModelRenderer(this, 20, 16);
     this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 9, 4);
     this.body.setRotationPoint(0.0F, 2.0F, -2.0F);
     this.body.setTextureSize(128, 64);
     this.body.mirror = true;
     setRotation(this.body, 0.1396263F, 0.0F, 0.0F);
     this.rightarm = new ModelRenderer(this, 36, 29);
     this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 16, 4);
     this.rightarm.setRotationPoint(-7.0F, -7.0F, -3.0F);
     this.rightarm.setTextureSize(128, 64);
     this.rightarm.mirror = true;
     setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
     this.leftarm = new ModelRenderer(this, 36, 29);
     this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 16, 4);
     this.leftarm.setRotationPoint(7.0F, -7.0F, -4.0F);
     this.leftarm.setTextureSize(128, 64);
     this.leftarm.mirror = true;
     setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
     this.rightleg = new ModelRenderer(this, 0, 16);
     this.rightleg.addBox(-4.0F, 0.0F, -3.0F, 5, 15, 5);
     this.rightleg.setRotationPoint(-2.0F, 9.0F, 0.0F);
     this.rightleg.setTextureSize(128, 64);
     this.rightleg.mirror = true;
     setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
     this.leftleg = new ModelRenderer(this, 0, 16);
     this.leftleg.addBox(-1.0F, 0.0F, -3.0F, 5, 15, 5);
     this.leftleg.setRotationPoint(2.0F, 9.0F, 0.0F);
     this.leftleg.setTextureSize(128, 64);
     this.leftleg.mirror = true;
     setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
     this.chest = new ModelRenderer(this, 0, 36);
     this.chest.addBox(-6.0F, 0.0F, -3.0F, 12, 12, 6);
     this.chest.setRotationPoint(0.0F, -10.0F, -3.0F);
     this.chest.setTextureSize(128, 64);
     this.chest.mirror = true;
     setRotation(this.chest, 0.0523599F, 0.0F, 0.0F);
     this.mane = new ModelRenderer(this, 44, 0);
     this.mane.addBox(-4.5F, -9.0F, -5.5F, 9, 18, 11);
     this.mane.setRotationPoint(0.0F, -10.0F, -3.0F);
     this.mane.setTextureSize(128, 64);
     this.mane.mirror = true;
     setRotation(this.mane, 0.1570796F, 0.0F, 0.0F);
     this.horn11 = new ModelRenderer(this, 0, 0);
     this.horn11.addBox(-1.0F, -18.0F, -5.0F, 2, 10, 2);
     this.horn11.setRotationPoint(0.0F, -10.0F, -3.0F);
     this.horn11.setTextureSize(128, 64);
     this.horn11.mirror = true;
     setRotation(this.horn11, 0.2268928F, 0.0F, -0.4363323F);
     this.horn12 = new ModelRenderer(this, 0, 0);
     this.horn12.addBox(-1.0F, -17.0F, -9.0F, 2, 2, 12);
     this.horn12.setRotationPoint(0.0F, -10.0F, -3.0F);
     this.horn12.setTextureSize(128, 64);
     this.horn12.mirror = true;
     setRotation(this.horn12, -0.0349066F, 0.0F, -0.4363323F);
     this.horn21 = new ModelRenderer(this, 0, 0);
     this.horn21.addBox(-1.0F, -18.0F, -5.0F, 2, 10, 2);
     this.horn21.setRotationPoint(0.0F, -10.0F, -3.0F);
     this.horn21.setTextureSize(128, 64);
     this.horn21.mirror = true;
     setRotation(this.horn21, 0.2268928F, 0.0F, 0.4363323F);
     this.horn22 = new ModelRenderer(this, 0, 0);
     this.horn22.addBox(-1.0F, -17.0F, -9.0F, 2, 2, 12);
     this.horn22.setRotationPoint(0.0F, -10.0F, -3.0F);
     this.horn22.setTextureSize(128, 64);
     this.horn22.mirror = true;
     setRotation(this.horn22, -0.0349066F, 0.0F, 0.4363323F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.head.render(f5);
     this.body.render(f5);
     this.rightarm.render(f5);
     this.leftarm.render(f5);
     this.rightleg.render(f5);
     this.leftleg.render(f5);
     this.chest.render(f5);
     this.mane.render(f5);
     this.horn11.render(f5);
     this.horn12.render(f5);
     this.horn21.render(f5);
     this.horn22.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
     model.rotateAngleX = x;
     model.rotateAngleY = y;
     model.rotateAngleZ = z;
   }

   public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entity) {
     super.setRotationAngles(p_78087_6_, p_78087_6_, p_78087_6_, p_78087_6_, p_78087_6_, p_78087_6_, entity);
     this.head.rotateAngleY = p_78087_4_ / 57.295776F;
     this.head.rotateAngleX = p_78087_5_ / 57.295776F;
     this.rightarm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + 3.1415927F) * 2.0F * p_78087_2_ * 0.5F;
     this.leftarm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 2.0F * p_78087_2_ * 0.5F;
     this.rightarm.rotateAngleZ = 0.0F;
     this.leftarm.rotateAngleZ = 0.0F;
     this.mane.rotateAngleY = this.head.rotateAngleY;
     this.mane.rotateAngleX = this.head.rotateAngleX;
     this.horn11.rotateAngleY = this.head.rotateAngleY;
     this.horn11.rotateAngleX = this.head.rotateAngleX;
     this.horn12.rotateAngleY = this.head.rotateAngleY;
     this.horn12.rotateAngleX = this.head.rotateAngleX;
     this.horn21.rotateAngleY = this.head.rotateAngleY;
     this.horn21.rotateAngleX = this.head.rotateAngleX;
     this.horn22.rotateAngleY = this.head.rotateAngleY;
     this.horn22.rotateAngleX = this.head.rotateAngleX;
     this.rightleg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
     this.leftleg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + 3.1415927F) * 1.4F * p_78087_2_;
     this.rightleg.rotateAngleY = 0.0F;
     this.leftleg.rotateAngleY = 0.0F;
   }

   public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
     EntityIfrit entityirongolem = (EntityIfrit)p_78086_1_;
     int i = entityirongolem.getAttackTimer();

     if (i > 0) {

       this.rightarm.rotateAngleX = -2.0F + 1.5F * func_78172_a(i - p_78086_4_, 10.0F);
       this.leftarm.rotateAngleX = -2.0F + 1.5F * func_78172_a(i - p_78086_4_, 10.0F);
     }
     else {

       this.rightarm.rotateAngleX = (-0.2F + 1.5F * func_78172_a(p_78086_2_, 13.0F)) * p_78086_3_;
       this.leftarm.rotateAngleX = (-0.2F - 1.5F * func_78172_a(p_78086_2_, 13.0F)) * p_78086_3_;
     }
   }

   private float func_78172_a(float p_78172_1_, float p_78172_2_) {
     return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / p_78172_2_ * 0.25F;
   }
 }