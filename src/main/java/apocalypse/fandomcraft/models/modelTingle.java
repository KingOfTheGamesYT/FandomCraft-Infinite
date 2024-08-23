 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelTingle
   extends ModelBase
 {
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer rightarm;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;
   ModelRenderer Shape1;
   ModelRenderer Shape2;

   public modelTingle() {
     this.textureWidth = 64;
     this.textureHeight = 32;

     this.head = new ModelRenderer(this, 0, 0);
     this.head.addBox(-3.0F, -8.0F, -3.0F, 6, 8, 6);
     this.head.setRotationPoint(0.0F, 14.0F, 0.0F);
     this.head.setTextureSize(64, 32);
     this.head.mirror = true;
     setRotation(this.head, 0.0F, 0.0F, 0.0F);
     this.body = new ModelRenderer(this, 16, 14);
     this.body.addBox(-2.5F, 0.0F, -2.0F, 5, 6, 4);
     this.body.setRotationPoint(0.0F, 14.0F, 0.0F);
     this.body.setTextureSize(64, 32);
     this.body.mirror = true;
     setRotation(this.body, 0.0F, 0.0F, 0.0F);
     this.rightarm = new ModelRenderer(this, 8, 14);
     this.rightarm.addBox(-2.0F, -1.0F, -1.0F, 2, 5, 2);
     this.rightarm.setRotationPoint(-2.5F, 15.5F, 0.0F);
     this.rightarm.setTextureSize(64, 32);
     this.rightarm.mirror = true;
     setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
     this.leftarm = new ModelRenderer(this, 8, 14);
     this.leftarm.addBox(0.0F, -1.0F, -1.0F, 2, 5, 2);
     this.leftarm.setRotationPoint(2.5F, 15.5F, 0.0F);
     this.leftarm.setTextureSize(64, 32);
     this.leftarm.mirror = true;
     setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
     this.rightleg = new ModelRenderer(this, 0, 14);
     this.rightleg.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2);
     this.rightleg.setRotationPoint(-1.3F, 19.0F, 0.0F);
     this.rightleg.setTextureSize(64, 32);
     this.rightleg.mirror = true;
     setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
     this.leftleg = new ModelRenderer(this, 0, 14);
     this.leftleg.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2);
     this.leftleg.setRotationPoint(1.3F, 19.0F, 0.0F);
     this.leftleg.setTextureSize(64, 32);
     this.leftleg.mirror = true;
     setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
     this.Shape1 = new ModelRenderer(this, 19, 24);
     this.Shape1.addBox(-2.0F, 0.0F, -0.5F, 4, 4, 1);
     this.Shape1.setRotationPoint(0.0F, 15.8F, -2.0F);
     this.Shape1.setTextureSize(64, 32);
     this.Shape1.mirror = true;
     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
     this.Shape2 = new ModelRenderer(this, 0, 0);
     this.Shape2.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1);
     this.Shape2.setRotationPoint(0.0F, 15.5F, -2.0F);
     this.Shape2.setTextureSize(64, 32);
     this.Shape2.mirror = true;
     setRotation(this.Shape2, -0.3665191F, 0.0F, 0.0F);
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
     this.Shape1.render(f5);
     this.Shape2.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
     model.rotateAngleX = x;
     model.rotateAngleY = y;
     model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
     super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     this.head.rotateAngleY = f3 / 57.295776F;
     this.head.rotateAngleX = f4 / 57.295776F;
     this.leftleg.rotateAngleX = -1.5F * func_78172_a(f, 13.0F) * f1;
     this.rightleg.rotateAngleX = 1.5F * func_78172_a(f, 13.0F) * f1;
     this.leftleg.rotateAngleY = 0.0F;
     this.rightleg.rotateAngleY = 0.0F;
     this.rightleg.rotateAngleX = this.rightleg.rotateAngleX;
     this.rightleg.rotateAngleY = this.rightleg.rotateAngleY;
     this.leftleg.rotateAngleX = this.leftleg.rotateAngleX;
     this.leftleg.rotateAngleY = this.leftleg.rotateAngleY;
   }

   private float func_78172_a(float p_78172_1_, float p_78172_2_) {
     return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / p_78172_2_ * 0.25F;
   }
 }