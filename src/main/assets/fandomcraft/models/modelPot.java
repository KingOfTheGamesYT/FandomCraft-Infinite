package assets.fandomcraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelPot extends ModelBase
{
  //fields
    ModelRenderer base;
    ModelRenderer baseX;
    ModelRenderer baseZ;
    ModelRenderer bottom;
    ModelRenderer front1;
    ModelRenderer back1;
    ModelRenderer left1;
    ModelRenderer right1;
    ModelRenderer front2;
    ModelRenderer back2;
    ModelRenderer left2;
    ModelRenderer right2;
    ModelRenderer topfront1;
    ModelRenderer topback1;
    ModelRenderer topleft1;
    ModelRenderer topright1;
    ModelRenderer topback2;
    ModelRenderer topfront2;
    ModelRenderer topleft2;
    ModelRenderer topright2;
  
  public modelPot()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      base = new ModelRenderer(this, 32, 0);
      base.addBox(0F, 0F, 0F, 8, 2, 8);
      base.setRotationPoint(-4F, 21F, -4F);
      base.setTextureSize(64, 32);
      setRotation(base, 0F, 0F, 0F);
      baseX = new ModelRenderer(this, 0, 11);
      baseX.addBox(0F, 0F, 0F, 10, 1, 6);
      baseX.setRotationPoint(-5F, 21F, -3F);
      baseX.setTextureSize(64, 32);
      setRotation(baseX, 0F, 0F, 0F);
      baseZ = new ModelRenderer(this, 0, 0);
      baseZ.addBox(0F, 0F, 0F, 6, 1, 10);
      baseZ.setRotationPoint(-3F, 21F, -5F);
      baseZ.setTextureSize(64, 32);
      setRotation(baseZ, 0F, 0F, 0F);
      bottom = new ModelRenderer(this, 0, 18);
      bottom.addBox(0F, 0F, 0F, 6, 1, 6);
      bottom.setRotationPoint(-3F, 23F, -3F);
      bottom.setTextureSize(64, 32);
      setRotation(bottom, 0F, 0F, 0F);
      front1 = new ModelRenderer(this, 34, 25);
      front1.addBox(0F, 0F, 0F, 8, 6, 1);
      front1.setRotationPoint(-4F, 15F, -5F);
      front1.setTextureSize(64, 32);
      setRotation(front1, 0F, 0F, 0F);
      back1 = new ModelRenderer(this, 22, 0);
      back1.addBox(0F, 0F, 0F, 8, 6, 1);
      back1.setRotationPoint(-4F, 15F, 4F);
      back1.setTextureSize(64, 32);
      setRotation(back1, 0F, 0F, 0F);
      left1 = new ModelRenderer(this, 24, 10);
      left1.addBox(0F, 0F, 0F, 1, 6, 8);
      left1.setRotationPoint(-5F, 15F, -4F);
      left1.setTextureSize(64, 32);
      setRotation(left1, 0F, 0F, 0F);
      right1 = new ModelRenderer(this, 24, 10);
      right1.addBox(0F, 0F, 0F, 1, 6, 8);
      right1.setRotationPoint(4F, 15F, -4F);
      right1.setTextureSize(64, 32);
      setRotation(right1, 0F, 0F, 0F);
      front2 = new ModelRenderer(this, 0, 25);
      front2.addBox(0F, 0F, 0F, 6, 4, 1);
      front2.setRotationPoint(-3F, 16F, -6F);
      front2.setTextureSize(64, 32);
      setRotation(front2, 0F, 0F, 0F);
      back2 = new ModelRenderer(this, 0, 25);
      back2.addBox(0F, 0F, 0F, 6, 4, 1);
      back2.setRotationPoint(-3F, 16F, 5F);
      back2.setTextureSize(64, 32);
      setRotation(back2, 0F, 0F, 0F);
      left2 = new ModelRenderer(this, 42, 10);
      left2.addBox(0F, 0F, 0F, 1, 4, 6);
      left2.setRotationPoint(-6F, 16F, -3F);
      left2.setTextureSize(64, 32);
      setRotation(left2, 0F, 0F, 0F);
      right2 = new ModelRenderer(this, 42, 10);
      right2.addBox(0F, 0F, 0F, 1, 4, 6);
      right2.setRotationPoint(5F, 16F, -3F);
      right2.setTextureSize(64, 32);
      setRotation(right2, 0F, 0F, 0F);
      topfront1 = new ModelRenderer(this, 14, 25);
      topfront1.addBox(0F, 0F, 0F, 8, 1, 2);
      topfront1.setRotationPoint(-4F, 14F, -4F);
      topfront1.setTextureSize(64, 32);
      setRotation(topfront1, 0F, 0F, 0F);
      topback1 = new ModelRenderer(this, 14, 25);
      topback1.addBox(0F, 0F, 0F, 8, 1, 2);
      topback1.setRotationPoint(-4F, 14F, 2F);
      topback1.setTextureSize(64, 32);
      setRotation(topback1, 0F, 0F, 0F);
      topleft1 = new ModelRenderer(this, 42, 20);
      topleft1.addBox(0F, 0F, 0F, 2, 1, 4);
      topleft1.setRotationPoint(2F, 14F, -2F);
      topleft1.setTextureSize(64, 32);
      setRotation(topleft1, 0F, 0F, 0F);
      topright1 = new ModelRenderer(this, 42, 20);
      topright1.addBox(0F, 0F, 0F, 2, 1, 4);
      topright1.setRotationPoint(-4F, 14F, -2F);
      topright1.setTextureSize(64, 32);
      setRotation(topright1, 0F, 0F, 0F);
      topback2 = new ModelRenderer(this, 0, 4);
      topback2.addBox(0F, 0F, 0F, 4, 2, 1);
      topback2.setRotationPoint(-2F, 12F, 1F);
      topback2.setTextureSize(64, 32);
      setRotation(topback2, 0F, 0F, 0F);
      topfront2 = new ModelRenderer(this, 0, 7);
      topfront2.addBox(0F, 0F, 0F, 4, 2, 1);
      topfront2.setRotationPoint(-2F, 12F, -2F);
      topfront2.setTextureSize(64, 32);
      setRotation(topfront2, 0F, 0F, 0F);
      topleft2 = new ModelRenderer(this, 0, 0);
      topleft2.addBox(0F, 0F, 0F, 1, 2, 2);
      topleft2.setRotationPoint(-2F, 12F, -1F);
      topleft2.setTextureSize(64, 32);
      setRotation(topleft2, 0F, 0F, 0F);
      topright2 = new ModelRenderer(this, 0, 0);
      topright2.addBox(0F, 0F, 0F, 1, 2, 2);
      topright2.setRotationPoint(1F, 12F, -1F);
      topright2.setTextureSize(64, 32);
      setRotation(topright2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    base.render(f5);
    baseX.render(f5);
    baseZ.render(f5);
    bottom.render(f5);
    front1.render(f5);
    back1.render(f5);
    left1.render(f5);
    right1.render(f5);
    front2.render(f5);
    back2.render(f5);
    left2.render(f5);
    right2.render(f5);
    topfront1.render(f5);
    topback1.render(f5);
    topleft1.render(f5);
    topright1.render(f5);
    topback2.render(f5);
    topfront2.render(f5);
    topleft2.render(f5);
    topright2.render(f5);
  }
  
  public void renderModel(float f)
  {

	base.render(f);
	baseX.render(f);
	baseZ.render(f);
	bottom.render(f);
	front1.render(f);
	back1.render(f);
	left1.render(f);
	right1.render(f);
	front2.render(f);
	back2.render(f);
	left2.render(f);
	right2.render(f);
	topfront1.render(f);
	topback1.render(f);
	topleft1.render(f);
	topright1.render(f);
	topback2.render(f);
	topfront2.render(f);
	topleft2.render(f);
	topright2.render(f);
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
