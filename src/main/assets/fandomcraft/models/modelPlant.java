// Date: 04/05/2014 16:10:25
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package assets.fandomcraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelPlant extends ModelBase
{
  //fields
    ModelRenderer base;
    ModelRenderer right;
    ModelRenderer left;
    ModelRenderer front;
    ModelRenderer back;
    ModelRenderer middle;
    ModelRenderer tree;
    ModelRenderer leaves1;
    ModelRenderer leaves_2;
    ModelRenderer leaves_3;
    ModelRenderer leaves_4;
    ModelRenderer tree2;
  
  public modelPlant()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      base = new ModelRenderer(this, 0, 55);
      base.addBox(0F, 0F, 0F, 8, 1, 8);
      base.setRotationPoint(-4F, 23F, -4F);
      base.setTextureSize(64, 64);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      right = new ModelRenderer(this, 0, 40);
      right.addBox(0F, 0F, 0F, 1, 7, 8);
      right.setRotationPoint(4F, 16F, -4F);
      right.setTextureSize(64, 64);
      right.mirror = true;
      setRotation(right, 0F, 0F, 0F);
      left = new ModelRenderer(this, 0, 40);
      left.addBox(0F, 0F, 0F, 1, 7, 8);
      left.setRotationPoint(-5F, 16F, -4F);
      left.setTextureSize(64, 64);
      left.mirror = true;
      setRotation(left, 0F, 0F, 0F);
      front = new ModelRenderer(this, 0, 32);
      front.addBox(0F, 0F, 0F, 8, 7, 1);
      front.setRotationPoint(-4F, 16F, -5F);
      front.setTextureSize(64, 64);
      front.mirror = true;
      setRotation(front, 0F, 0F, 0F);
      back = new ModelRenderer(this, 0, 32);
      back.addBox(0F, 0F, 0F, 8, 7, 1);
      back.setRotationPoint(-4F, 16F, 4F);
      back.setTextureSize(64, 64);
      back.mirror = true;
      setRotation(back, 0F, 0F, 0F);
      middle = new ModelRenderer(this, 32, 50);
      middle.addBox(0F, 0F, 0F, 8, 6, 8);
      middle.setRotationPoint(-4F, 17F, -4F);
      middle.setTextureSize(64, 64);
      middle.mirror = true;
      setRotation(middle, 0F, 0F, 0F);
      tree = new ModelRenderer(this, 18, 39);
      tree.addBox(0F, 0F, 0F, 2, 14, 2);
      tree.setRotationPoint(-1.5F, 3F, 0F);
      tree.setTextureSize(64, 64);
      tree.mirror = true;
      setRotation(tree, 0F, 0.7853982F, 0F);
      leaves1 = new ModelRenderer(this, 0, 0);
      leaves1.addBox(0F, 0F, 0F, 10, 10, 10);
      leaves1.setRotationPoint(-5F, -8F, -5F);
      leaves1.setTextureSize(64, 64);
      leaves1.mirror = true;
      setRotation(leaves1, 0F, 0F, 0F);
      leaves_2 = new ModelRenderer(this, 0, 0);
      leaves_2.addBox(0F, 0F, 0F, 8, 8, 12);
      leaves_2.setRotationPoint(-4F, -7F, -6F);
      leaves_2.setTextureSize(64, 64);
      leaves_2.mirror = true;
      setRotation(leaves_2, 0F, 0F, 0F);
      leaves_3 = new ModelRenderer(this, 0, 0);
      leaves_3.addBox(0F, 0F, 0F, 12, 8, 8);
      leaves_3.setRotationPoint(-6F, -7F, -4F);
      leaves_3.setTextureSize(64, 64);
      leaves_3.mirror = true;
      setRotation(leaves_3, 0F, 0F, 0F);
      leaves_4 = new ModelRenderer(this, 0, 0);
      leaves_4.addBox(0F, 0F, 0F, 8, 12, 8);
      leaves_4.setRotationPoint(-4F, -9F, -4F);
      leaves_4.setTextureSize(64, 64);
      leaves_4.mirror = true;
      setRotation(leaves_4, 0F, 0F, 0F);
      tree2 = new ModelRenderer(this, 18, 39);
      tree2.addBox(0F, 0F, 0F, 2, 14, 2);
      tree2.setRotationPoint(-1F, 3F, 1F);
      tree2.setTextureSize(64, 64);
      tree2.mirror = true;
      setRotation(tree2, 0F, 1.570796F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    base.render(f5);
    right.render(f5);
    left.render(f5);
    front.render(f5);
    back.render(f5);
    middle.render(f5);
    tree.render(f5);
    leaves1.render(f5);
    leaves_2.render(f5);
    leaves_3.render(f5);
    leaves_4.render(f5);
    tree2.render(f5);
  }
  
  public void renderModel(float f)
  {

	    base.render(f);
	    right.render(f);
	    left.render(f);
	    front.render(f);
	    back.render(f);
	    middle.render(f);
	    tree.render(f);
	    leaves1.render(f);
	    leaves_2.render(f);
	    leaves_3.render(f);
	    leaves_4.render(f);
	    tree2.render(f);
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
