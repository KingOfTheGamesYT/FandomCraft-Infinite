// Date: 09/08/2014 15:39:25
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package assets.fandomcraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

import apocalypse.fandomcraft.entity.EntityKoopa;

public class modelKoopa extends ModelBase
{
  //fields
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
  
  public modelKoopa()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-3.5F, -6F, -6F, 7, 6, 8);
      head.setRotationPoint(0F, 6F, -2F);
      head.setTextureSize(128, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 21);
      body.addBox(-3.5F, 0F, -2F, 7, 8, 3);
      body.setRotationPoint(0F, 8F, -1F);
      body.setTextureSize(128, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 0);
      rightarm.addBox(-2.5F, -2F, -2F, 3, 7, 3);
      rightarm.setRotationPoint(-4F, 11F, 0F);
      rightarm.setTextureSize(128, 32);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 0);
      leftarm.addBox(-1F, -2F, -2F, 3, 7, 3);
      leftarm.setRotationPoint(4.5F, 11F, 0F);
      leftarm.setTextureSize(128, 32);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 20);
      rightleg.addBox(-2F, 0F, -2F, 4, 8, 4);
      rightleg.setRotationPoint(-2F, 16F, 0F);
      rightleg.setTextureSize(128, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 20);
      leftleg.addBox(-2F, 0F, -2F, 4, 8, 4);
      leftleg.setRotationPoint(2F, 16F, 0F);
      leftleg.setTextureSize(128, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      Neck = new ModelRenderer(this, 52, 0);
      Neck.addBox(-1.5F, -3F, -2F, 3, 3, 3);
      Neck.setRotationPoint(0F, 8F, 0F);
      Neck.setTextureSize(128, 32);
      Neck.mirror = true;
      setRotation(Neck, 0.2617994F, 0F, 0F);
      Shell = new ModelRenderer(this, 64, 17);
      Shell.addBox(-4.5F, -4F, 0F, 9, 10, 5);
      Shell.setRotationPoint(0F, 10.5F, 0F);
      Shell.setTextureSize(128, 32);
      Shell.mirror = true;
      setRotation(Shell, 0F, 0F, 0F);
      Tail = new ModelRenderer(this, 64, 0);
      Tail.addBox(-1F, -1F, 0F, 2, 2, 9);
      Tail.setRotationPoint(0F, 14.5F, -1F);
      Tail.setTextureSize(128, 32);
      Tail.mirror = true;
      setRotation(Tail, -0.4363323F, 0F, 0F);
      Eyes = new ModelRenderer(this, 46, 14);
      Eyes.addBox(-2.5F, -5F, -2F, 5, 9, 4);
      Eyes.setRotationPoint(0F, 1F, -1F);
      Eyes.setTextureSize(128, 32);
      Eyes.mirror = true;
      setRotation(Eyes, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    Neck.render(f5);
    Shell.render(f5);
    Tail.render(f5);
    Eyes.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.Eyes.rotateAngleX = this.head.rotateAngleX;
    this.Eyes.rotateAngleY = this.head.rotateAngleY;
    this.leftleg.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1;
    this.rightleg.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1;
    this.leftleg.rotateAngleY = 0.0F;
    this.rightleg.rotateAngleY = 0.0F;
  }
  public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
  {
      EntityKoopa koopa = (EntityKoopa)p_78086_1_;
      int i = koopa.getAttackTimer();

      if (i > 0)
      {
          this.rightarm.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - p_78086_4_, 10.0F);
          this.leftarm.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - p_78086_4_, 10.0F);
      }
      else
      {
          this.rightarm.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(p_78086_2_, 13.0F)) * p_78086_3_;
          this.leftarm.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(p_78086_2_, 13.0F)) * p_78086_3_;
      
      }
  }
  private float func_78172_a(float p_78172_1_, float p_78172_2_)
  {
      return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
  }

}
