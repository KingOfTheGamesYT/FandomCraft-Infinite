 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.util.MathHelper;

 public class modelRedead
   extends ModelBase
 {
   ModelRenderer headgear;
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer rightarm;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;

   public modelRedead() {
     this.textureWidth = 64;
     this.textureHeight = 32;

     this.headgear = new ModelRenderer(this, 32, 0);
     this.headgear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
     this.headgear.setRotationPoint(0.0F, 0.0F, -0.5F);
     this.headgear.setTextureSize(64, 32);
     this.headgear.mirror = true;
     setRotation(this.headgear, 0.0F, 0.0F, 0.0F);
     this.head = new ModelRenderer(this, 0, 0);
     this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
     this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
     this.head.setTextureSize(64, 32);
     this.head.mirror = true;
     setRotation(this.head, 0.0F, 0.0F, 0.0F);
     this.body = new ModelRenderer(this, 16, 16);
     this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
     this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
     this.body.setTextureSize(64, 32);
     this.body.mirror = true;
     setRotation(this.body, 0.0F, 0.0F, 0.0F);
     this.rightarm = new ModelRenderer(this, 40, 16);
     this.rightarm.addBox(-2.0F, -2.0F, -1.0F, 2, 12, 2);
     this.rightarm.setRotationPoint(-4.0F, 2.0F, 0.0F);
     this.rightarm.setTextureSize(64, 32);
     this.rightarm.mirror = true;
     setRotation(this.rightarm, -1.047198F, 0.0F, 0.0F);
     this.leftarm = new ModelRenderer(this, 40, 16);
     this.leftarm.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2);
     this.leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
     this.leftarm.setTextureSize(64, 32);
     this.leftarm.mirror = true;
     setRotation(this.leftarm, -1.047198F, 0.0F, 0.0F);
     this.rightleg = new ModelRenderer(this, 0, 16);
     this.rightleg.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2);
     this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
     this.rightleg.setTextureSize(64, 32);
     this.rightleg.mirror = true;
     setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
     this.leftleg = new ModelRenderer(this, 0, 16);
     this.leftleg.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2);
     this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
     this.leftleg.setTextureSize(64, 32);
     this.leftleg.mirror = true;
     setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.headgear.render(f5);
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
     this.headgear.rotateAngleY = this.head.rotateAngleY;
     this.headgear.rotateAngleX = this.head.rotateAngleX;
     this.rightarm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + 3.1415927F) * 2.0F * p_78087_2_ * 0.5F;
     this.leftarm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 2.0F * p_78087_2_ * 0.5F;
     this.rightarm.rotateAngleZ = 0.0F;
     this.leftarm.rotateAngleZ = 0.0F;
     this.rightleg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
     this.leftleg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + 3.1415927F) * 1.4F * p_78087_2_;
     this.rightleg.rotateAngleY = 0.0F;
     this.leftleg.rotateAngleY = 0.0F;
     this.rightarm.rotateAngleY = 0.0F;
     this.leftarm.rotateAngleY = 0.0F;
     this.headgear.rotateAngleY = this.head.rotateAngleY;
     this.headgear.rotateAngleX = this.head.rotateAngleX;
   }
 }