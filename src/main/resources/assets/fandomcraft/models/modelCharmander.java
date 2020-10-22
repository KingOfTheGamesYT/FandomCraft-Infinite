
package assets.fandomcraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelCharmander extends ModelBase
{
  //fields
    ModelRenderer RightFoot;
    ModelRenderer LeftFoot;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer Waist;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer Body;
    ModelRenderer RightArm;
    ModelRenderer LeftArm;
    ModelRenderer Jaw;
    ModelRenderer Head;
    ModelRenderer Flame1;
    ModelRenderer Flame2;
  
  public modelCharmander()
  {
    textureWidth = 64;
    textureHeight = 128;
    
      RightFoot = new ModelRenderer(this, 0, 124);
      RightFoot.addBox(-1F, 0F, -2F, 2, 1, 3);
      RightFoot.setRotationPoint(-2F, 23F, 1F);
      RightFoot.setTextureSize(64, 128);
      RightFoot.mirror = true;
      setRotation(RightFoot, 0F, 0F, 0F);
      LeftFoot = new ModelRenderer(this, 0, 124);
      LeftFoot.addBox(-1F, 0F, -2F, 2, 1, 3);
      LeftFoot.setRotationPoint(2F, 23F, 1F);
      LeftFoot.setTextureSize(64, 128);
      LeftFoot.mirror = true;
      setRotation(LeftFoot, 0F, 0F, 0F);
      RightLeg = new ModelRenderer(this, 0, 117);
      RightLeg.addBox(-1.5F, 0F, -2F, 3, 4, 3);
      RightLeg.setRotationPoint(-2F, 19F, 0.5F);
      RightLeg.setTextureSize(64, 128);
      RightLeg.mirror = true;
      setRotation(RightLeg, 0.4363323F, 0F, 0F);
      LeftLeg = new ModelRenderer(this, 0, 117);
      LeftLeg.addBox(-1.5F, 0F, -2F, 3, 4, 3);
      LeftLeg.setRotationPoint(2F, 19F, 0.5F);
      LeftLeg.setTextureSize(64, 128);
      LeftLeg.mirror = true;
      setRotation(LeftLeg, 0.4363323F, 0F, 0F);
      Waist = new ModelRenderer(this, 0, 103);
      Waist.addBox(-3F, 0F, -3F, 6, 9, 5);
      Waist.setRotationPoint(0F, 13F, 1.2F);
      Waist.setTextureSize(64, 128);
      Waist.mirror = true;
      setRotation(Waist, 0.2268928F, 0F, 0F);
      Tail1 = new ModelRenderer(this, 22, 107);
      Tail1.addBox(-2F, -1F, -1F, 4, 4, 6);
      Tail1.setRotationPoint(0F, 18F, 2F);
      Tail1.setTextureSize(64, 128);
      Tail1.mirror = true;
      setRotation(Tail1, -0.1745329F, 0F, 0F);
      Tail2 = new ModelRenderer(this, 22, 100);
      Tail2.addBox(-1.5F, -1F, -1F, 3, 3, 4);
      Tail2.setRotationPoint(0F, 19F, 7F);
      Tail2.setTextureSize(64, 128);
      Tail2.mirror = true;
      setRotation(Tail2, 0.296706F, 0F, 0F);
      Tail3 = new ModelRenderer(this, 22, 92);
      Tail3.addBox(-1F, -1F, -1F, 2, 2, 6);
      Tail3.setRotationPoint(0F, 18.5F, 10F);
      Tail3.setTextureSize(64, 128);
      Tail3.mirror = true;
      setRotation(Tail3, 1.117011F, 0F, 0F);
      Body = new ModelRenderer(this, 0, 92);
      Body.addBox(-2.5F, 0F, -3F, 5, 7, 5);
      Body.setRotationPoint(0F, 9F, 2F);
      Body.setTextureSize(64, 128);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      RightArm = new ModelRenderer(this, 0, 85);
      RightArm.addBox(-2F, -1F, -1F, 2, 5, 2);
      RightArm.setRotationPoint(-2.5F, 14F, 1F);
      RightArm.setTextureSize(64, 128);
      RightArm.mirror = true;
      setRotation(RightArm, -0.4363323F, 0F, 0.4363323F);
      LeftArm = new ModelRenderer(this, 0, 85);
      LeftArm.addBox(0F, -1F, -1F, 2, 5, 2);
      LeftArm.setRotationPoint(2.5F, 14F, 1F);
      LeftArm.setTextureSize(64, 128);
      LeftArm.mirror = true;
      setRotation(LeftArm, -0.4363323F, 0F, -0.4363323F);
      Jaw = new ModelRenderer(this, 0, 75);
      Jaw.addBox(-3.5F, 0F, -12F, 7, 4, 6);
      Jaw.setRotationPoint(0F, 5F, 9F);
      Jaw.setTextureSize(64, 128);
      Jaw.mirror = true;
      setRotation(Jaw, 0.1570796F, 0F, 0F);
      Head = new ModelRenderer(this, 0, 60);
      Head.addBox(-3F, -7F, -3F, 6, 8, 7);
      Head.setRotationPoint(0F, 8F, 0.7F);
      Head.setTextureSize(64, 128);
      Head.mirror = true;
      setRotation(Head, -0.0349066F, 0F, 0F);
      Flame1.mirror = true;
      Flame1 = new ModelRenderer(this, 0, 0);
      Flame1.addBox(0F, -6F, -2.5F, 0, 6, 5);
      Flame1.setRotationPoint(0F, 14.5F, 12F);
      Flame1.setTextureSize(64, 128);
      Flame1.mirror = true;
      setRotation(Flame1, 0F, 0F, 0F);
      Flame1.mirror = false;
      Flame2 = new ModelRenderer(this, 0, 0);
      Flame2.addBox(0F, -6F, -2.5F, 0, 6, 5);
      Flame2.setRotationPoint(0F, 14.5F, 12F);
      Flame2.setTextureSize(64, 128);
      Flame2.mirror = true;
      setRotation(Flame2, 0F, 1.570796F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    RightFoot.render(f5);
    LeftFoot.render(f5);
    RightLeg.render(f5);
    LeftLeg.render(f5);
    Waist.render(f5);
    Tail1.render(f5);
    Tail2.render(f5);
    Tail3.render(f5);
    Body.render(f5);
    RightArm.render(f5);
    LeftArm.render(f5);
    Jaw.render(f5);
    Head.render(f5);
    Flame1.render(f5);
    Flame2.render(f5);
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
  }

}
