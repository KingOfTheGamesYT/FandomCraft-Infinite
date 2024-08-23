 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;

 public class modelDarknut
   extends ModelBase
 {
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer rightarm;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;
   ModelRenderer Shape1;

   public modelDarknut() {
     this.textureWidth = 128;
     this.textureHeight = 32;

     this.head = new ModelRenderer(this, 0, 0);
     this.head.addBox(-3.5F, -8.0F, -3.5F, 7, 7, 7);
     this.head.setRotationPoint(0.0F, 3.0F, 0.0F);
     this.head.setTextureSize(128, 32);
     this.head.mirror = true;
     setRotation(this.head, 0.0F, 0.0F, 0.0F);
     this.body = new ModelRenderer(this, 32, 0);
     this.body.addBox(-6.0F, 0.0F, -4.0F, 12, 12, 8);
     this.body.setRotationPoint(0.0F, 2.0F, 0.0F);
     this.body.setTextureSize(128, 32);
     this.body.mirror = true;
     setRotation(this.body, 0.0F, 0.0F, 0.0F);
     this.rightarm = new ModelRenderer(this, 16, 16);
     this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4);
     this.rightarm.setRotationPoint(-7.0F, 4.0F, 0.0F);
     this.rightarm.setTextureSize(128, 32);
     this.rightarm.mirror = true;
     setRotation(this.rightarm, 0.0F, 0.0F, 0.1919862F);
     this.leftarm = new ModelRenderer(this, 16, 16);
     this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4);
     this.leftarm.setRotationPoint(7.0F, 4.0F, 0.0F);
     this.leftarm.setTextureSize(128, 32);
     this.leftarm.mirror = true;
     setRotation(this.leftarm, -0.715585F, 0.0F, 0.0F);
     this.rightleg = new ModelRenderer(this, 0, 16);
     this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4);
     this.rightleg.setRotationPoint(-2.0F, 14.0F, 0.0F);
     this.rightleg.setTextureSize(128, 32);
     this.rightleg.mirror = true;
     setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
     this.leftleg = new ModelRenderer(this, 0, 16);
     this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4);
     this.leftleg.setRotationPoint(2.0F, 14.0F, 0.0F);
     this.leftleg.setTextureSize(128, 32);
     this.leftleg.mirror = true;
     setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
     this.Shape1 = new ModelRenderer(this, 72, 0);
     this.Shape1.addBox(0.0F, -16.0F, -4.0F, 0, 18, 7);
     this.Shape1.setRotationPoint(8.0F, 9.0F, -6.0F);
     this.Shape1.setTextureSize(128, 32);
     this.Shape1.mirror = true;
     setRotation(this.Shape1, 0.6457718F, 0.0F, 0.0F);
   }

   public void render(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(e, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, e);
     this.head.render(f5);
     this.body.render(f5);
     this.rightarm.render(f5);
     this.leftarm.render(f5);
     this.rightleg.render(f5);
     this.leftleg.render(f5);
     this.Shape1.render(f5);
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