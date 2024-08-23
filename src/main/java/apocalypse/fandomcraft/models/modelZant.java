 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.util.MathHelper;

 public class modelZant
   extends ModelBase
 {
   ModelRenderer body;
   ModelRenderer rightarm;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;
   ModelRenderer head;
            private float swingProgress;

   public modelZant() {
     this.textureWidth = 128;
     this.textureHeight = 64;

     this.body = new ModelRenderer(this, 16, 20);
     this.body.addBox(-4.5F, 0.0F, -2.5F, 9, 17, 5);
     this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
     this.body.setTextureSize(128, 64);
     this.body.mirror = true;
     setRotation(this.body, 0.0F, 0.0F, 0.0F);
     this.rightarm = new ModelRenderer(this, 32, 0);
     this.rightarm.addBox(-3.5F, -2.0F, -2.0F, 4, 16, 4);
     this.rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
     this.rightarm.setTextureSize(128, 64);
     this.rightarm.mirror = true;
     setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
     this.leftarm = new ModelRenderer(this, 32, 0);
     this.leftarm.addBox(-0.5F, -2.0F, -2.0F, 4, 16, 4);
     this.leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
     this.leftarm.setTextureSize(128, 64);
     this.leftarm.mirror = true;
     setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
     this.rightleg = new ModelRenderer(this, 0, 20);
     this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
     this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
     this.rightleg.setTextureSize(128, 64);
     this.rightleg.mirror = true;
     setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
     this.leftleg = new ModelRenderer(this, 0, 20);
     this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
     this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
     this.leftleg.setTextureSize(128, 64);
     this.leftleg.mirror = true;
     setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
     this.head = new ModelRenderer(this, 0, 0);
     this.head.addBox(-4.0F, -12.0F, -4.0F, 8, 12, 8);
     this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
     this.head.setTextureSize(128, 64);
     this.head.mirror = true;
     setRotation(this.head, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.body.render(f5);
     this.rightarm.render(f5);
     this.leftarm.render(f5);
     this.rightleg.render(f5);
     this.leftleg.render(f5);
     this.head.render(f5);
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

     if (this.isRiding) {

       this.rightarm.rotateAngleX += -0.62831855F;
       this.leftarm.rotateAngleX += -0.62831855F;
       this.rightleg.rotateAngleX = -1.2566371F;
       this.leftleg.rotateAngleX = -1.2566371F;
       this.rightleg.rotateAngleY = 0.31415927F;
       this.leftleg.rotateAngleY = -0.31415927F;
     }
     this.rightarm.rotateAngleY = 0.0F;
     this.leftarm.rotateAngleY = 0.0F;

     if (this.swingProgress > -9990.0F) {

     float f6 = this.swingProgress;
       this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.1415927F * 2.0F) * 0.2F;
       this.rightarm.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
       this.rightarm.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
       this.leftarm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
       this.leftarm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
       this.rightarm.rotateAngleY += this.body.rotateAngleY;
       this.leftarm.rotateAngleY += this.body.rotateAngleY;
       this.leftarm.rotateAngleX += this.body.rotateAngleY;
       f6 = 1.0F - this.swingProgress;
       f6 *= f6;
       f6 *= f6;
       f6 = 1.0F - f6;
       float f7 = MathHelper.sin(f6 * 3.1415927F);
       float f8 = MathHelper.sin(this.swingProgress * 3.1415927F) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
       this.rightarm.rotateAngleX = (float)(this.rightarm.rotateAngleX - f7 * 1.2D + f8);
       this.rightarm.rotateAngleY += this.body.rotateAngleY * 2.0F;
       this.rightarm.rotateAngleZ = MathHelper.sin(this.swingProgress * 3.1415927F) * -0.4F;
     }
     this.body.rotateAngleX = 0.0F;
     this.rightleg.rotationPointZ = 0.1F;
     this.leftleg.rotationPointZ = 0.1F;
     this.rightleg.rotationPointY = 12.0F;
     this.leftleg.rotationPointY = 12.0F;
     this.head.rotationPointY = 0.0F;

     this.rightarm.rotateAngleZ += MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
     this.leftarm.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
     this.rightarm.rotateAngleX += MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
     this.leftarm.rotateAngleX -= MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
   }
 }