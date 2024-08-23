 package apocalypse.fandomcraft.models;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.util.MathHelper;

 public class modelBokoblin
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

   public modelBokoblin() {
     this.textureWidth = 64;
     this.textureHeight = 32;

     this.head = new ModelRenderer(this, 0, 0);
     this.head.addBox(-4.0F, -7.0F, -5.0F, 8, 7, 7);
     this.head.setRotationPoint(0.0F, 2.0F, -2.0F);
     this.head.setTextureSize(64, 32);
     this.head.mirror = true;
     setRotation(this.head, 0.0F, 0.0F, 0.0F);
     this.body = new ModelRenderer(this, 12, 14);
     this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
     this.body.setRotationPoint(0.0F, 2.0F, 0.0F);
     this.body.setTextureSize(64, 32);
     this.body.mirror = true;
     setRotation(this.body, 0.0698132F, 0.0F, 0.0F);
     this.rightarm = new ModelRenderer(this, 36, 14);
     this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 3, 10, 3);
     this.rightarm.setRotationPoint(-4.0F, 4.0F, 1.0F);
     this.rightarm.setTextureSize(64, 32);
     this.rightarm.mirror = true;
     setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
     this.leftarm = new ModelRenderer(this, 36, 14);
     this.leftarm.addBox(0.0F, -2.0F, -2.0F, 3, 10, 3);
     this.leftarm.setRotationPoint(4.0F, 4.0F, 1.0F);
     this.leftarm.setTextureSize(64, 32);
     this.leftarm.mirror = true;
     setRotation(this.leftarm, -0.2792527F, 0.0F, 0.0F);
     this.rightleg = new ModelRenderer(this, 0, 14);
     this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 3, 10, 3);
     this.rightleg.setRotationPoint(-1.5F, 14.0F, 1.0F);
     this.rightleg.setTextureSize(64, 32);
     this.rightleg.mirror = true;
     setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
     this.leftleg = new ModelRenderer(this, 0, 14);
     this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 3, 10, 3);
     this.leftleg.setRotationPoint(2.5F, 14.0F, 1.0F);
     this.leftleg.setTextureSize(64, 32);
     this.leftleg.mirror = true;
     setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
     this.Shape1 = new ModelRenderer(this, 23, 0);
     this.Shape1.addBox(0.0F, -4.0F, 0.0F, 1, 4, 1);
     this.Shape1.setRotationPoint(5.0F, 11.0F, -2.0F);
     this.Shape1.setTextureSize(64, 32);
     this.Shape1.mirror = true;
     setRotation(this.Shape1, 0.9773844F, 0.0F, 0.0F);
     this.Shape2 = new ModelRenderer(this, 48, 0);
     this.Shape2.addBox(0.0F, -14.0F, -2.0F, 0, 14, 3);
     this.Shape2.setRotationPoint(5.5F, 9.0F, -5.0F);
     this.Shape2.setTextureSize(64, 32);
     this.Shape2.mirror = true;
     setRotation(this.Shape2, 0.9773844F, 0.0F, 0.0F);
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
     this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
     this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
     this.rightleg.rotateAngleY = 0.0F;
     this.leftleg.rotateAngleY = 0.0F;
     this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 2.0F * f1 * 0.5F;
     this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
     this.rightarm.rotateAngleZ = 0.0F;
     this.leftarm.rotateAngleZ = 0.0F;
   }
 }