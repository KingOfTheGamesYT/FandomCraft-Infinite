 package apocalypse.fandomcraft.models;

 import apocalypse.fandomcraft.entity.EntityKoopa;
 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;

 public class modelKoopa
   extends ModelBase
 {
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer rightarm;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;
   ModelRenderer Neck;
   ModelRenderer Shell;
   ModelRenderer Tail;
   ModelRenderer Eyes;

   public modelKoopa() {
     this.textureWidth = 128;
     this.textureHeight = 32;

     this.head = new ModelRenderer(this, 0, 0);
     this.head.addBox(-3.5F, -6.0F, -6.0F, 7, 6, 8);
     this.head.setRotationPoint(0.0F, 6.0F, -2.0F);
     this.head.setTextureSize(128, 32);
     this.head.mirror = true;
     setRotation(this.head, 0.0F, 0.0F, 0.0F);
     this.body = new ModelRenderer(this, 16, 21);
     this.body.addBox(-3.5F, 0.0F, -2.0F, 7, 8, 3);
     this.body.setRotationPoint(0.0F, 8.0F, -1.0F);
     this.body.setTextureSize(128, 32);
     this.body.mirror = true;
     setRotation(this.body, 0.0F, 0.0F, 0.0F);
     this.rightarm = new ModelRenderer(this, 40, 0);
     this.rightarm.addBox(-2.5F, -2.0F, -2.0F, 3, 7, 3);
     this.rightarm.setRotationPoint(-4.0F, 11.0F, 0.0F);
     this.rightarm.setTextureSize(128, 32);
     this.rightarm.mirror = true;
     setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
     this.leftarm = new ModelRenderer(this, 40, 0);
     this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 3, 7, 3);
     this.leftarm.setRotationPoint(4.5F, 11.0F, 0.0F);
     this.leftarm.setTextureSize(128, 32);
     this.leftarm.mirror = true;
     setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
     this.rightleg = new ModelRenderer(this, 0, 20);
     this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4);
     this.rightleg.setRotationPoint(-2.0F, 16.0F, 0.0F);
     this.rightleg.setTextureSize(128, 32);
     this.rightleg.mirror = true;
     setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
     this.leftleg = new ModelRenderer(this, 0, 20);
     this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4);
     this.leftleg.setRotationPoint(2.0F, 16.0F, 0.0F);
     this.leftleg.setTextureSize(128, 32);
     this.leftleg.mirror = true;
     setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
     this.Neck = new ModelRenderer(this, 52, 0);
     this.Neck.addBox(-1.5F, -3.0F, -2.0F, 3, 3, 3);
     this.Neck.setRotationPoint(0.0F, 8.0F, 0.0F);
     this.Neck.setTextureSize(128, 32);
     this.Neck.mirror = true;
     setRotation(this.Neck, 0.2617994F, 0.0F, 0.0F);
     this.Shell = new ModelRenderer(this, 64, 17);
     this.Shell.addBox(-4.5F, -4.0F, 0.0F, 9, 10, 5);
     this.Shell.setRotationPoint(0.0F, 10.5F, 0.0F);
     this.Shell.setTextureSize(128, 32);
     this.Shell.mirror = true;
     setRotation(this.Shell, 0.0F, 0.0F, 0.0F);
     this.Tail = new ModelRenderer(this, 64, 0);
     this.Tail.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 9);
     this.Tail.setRotationPoint(0.0F, 14.5F, -1.0F);
     this.Tail.setTextureSize(128, 32);
     this.Tail.mirror = true;
     setRotation(this.Tail, -0.4363323F, 0.0F, 0.0F);
     this.Eyes = new ModelRenderer(this, 46, 14);
     this.Eyes.addBox(-2.5F, -5.0F, -2.0F, 5, 9, 4);
     this.Eyes.setRotationPoint(0.0F, 1.0F, -1.0F);
     this.Eyes.setTextureSize(128, 32);
     this.Eyes.mirror = true;
     setRotation(this.Eyes, 0.0F, 0.0F, 0.0F);
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
     this.Neck.render(f5);
     this.Shell.render(f5);
     this.Tail.render(f5);
     this.Eyes.render(f5);
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
     this.Eyes.rotateAngleX = this.head.rotateAngleX;
     this.Eyes.rotateAngleY = this.head.rotateAngleY;
     this.leftleg.rotateAngleX = -1.5F * func_78172_a(f, 13.0F) * f1;
     this.rightleg.rotateAngleX = 1.5F * func_78172_a(f, 13.0F) * f1;
     this.leftleg.rotateAngleY = 0.0F;
     this.rightleg.rotateAngleY = 0.0F;
   }

   public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
     EntityKoopa koopa = (EntityKoopa)p_78086_1_;
     int i = koopa.getAttackTimer();

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