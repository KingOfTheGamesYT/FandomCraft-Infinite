
package assets.fandomcraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelMasterSword extends ModelBase
{
  //fields
    ModelRenderer hilt1;
    ModelRenderer jewel1;
    ModelRenderer wing2;
    ModelRenderer wing1;
    ModelRenderer jewel2;
    ModelRenderer blade1;
    ModelRenderer triforce;
    ModelRenderer point;
    ModelRenderer bladeedge;
    ModelRenderer bladeedge2;
    ModelRenderer wing11;
    ModelRenderer wing22;
  
  public modelMasterSword()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      hilt1 = new ModelRenderer(this, 0, 50);
      hilt1.addBox(0F, 0F, 0F, 2, 10, 2);
      hilt1.setRotationPoint(-1F, 14F, -1F);
      hilt1.setTextureSize(64, 64);
      hilt1.mirror = true;
      setRotation(hilt1, 0F, 0F, 0F);
      jewel1 = new ModelRenderer(this, 0, 44);
      jewel1.addBox(0F, 0F, 0F, 3, 3, 3);
      jewel1.setRotationPoint(-1.5F, 14.5F, -1.5F);
      jewel1.setTextureSize(64, 64);
      jewel1.mirror = true;
      setRotation(jewel1, 0F, 0F, 0F);
      wing2 = new ModelRenderer(this, 16, 50);
      wing2.addBox(0F, 0F, 0F, 2, 8, 4);
      wing2.setRotationPoint(-1F, 12F, 6F);
      wing2.setTextureSize(64, 64);
      wing2.mirror = true;
      setRotation(wing2, -1.22173F, 0F, 0F);
      wing1 = new ModelRenderer(this, 28, 50);
      wing1.addBox(0F, 0F, 0F, 2, 8, 4);
      wing1.setRotationPoint(-1F, 15.8F, -7.3F);
      wing1.setTextureSize(64, 64);
      wing1.mirror = true;
      setRotation(wing1, 1.22173F, 0F, 0F);
      jewel2 = new ModelRenderer(this, 12, 46);
      jewel2.addBox(0F, 0F, 0F, 4, 2, 2);
      jewel2.setRotationPoint(-2F, 16F, -1.4F);
      jewel2.setTextureSize(64, 64);
      jewel2.mirror = true;
      setRotation(jewel2, 0.7853982F, 0F, 0F);
      blade1 = new ModelRenderer(this, 0, 0);
      blade1.addBox(0F, 0F, 0F, 1, 40, 3);
      blade1.setRotationPoint(-0.5F, -26F, -1.5F);
      blade1.setTextureSize(64, 64);
      blade1.mirror = true;
      setRotation(blade1, 0F, 0F, 0F);
      triforce = new ModelRenderer(this, 24, 48);
      triforce.addBox(0F, 0F, 0F, 2, 1, 1);
      triforce.setRotationPoint(-1F, 12.5F, -0.75F);
      triforce.setTextureSize(64, 64);
      triforce.mirror = true;
      setRotation(triforce, 0.7853982F, 0F, 0F);
      point = new ModelRenderer(this, 30, 44);
      point.addBox(0F, 0F, 0F, 1, 3, 3);
      point.setRotationPoint(-0.5F, -26F, -2.1F);
      point.setTextureSize(64, 64);
      point.mirror = true;
      setRotation(point, 0.7853982F, 0F, 0F);
      bladeedge = new ModelRenderer(this, 8, 0);
      bladeedge.addBox(0F, 0F, 0F, 1, 35, 2);
      bladeedge.setRotationPoint(-0.5F, -26F, -2F);
      bladeedge.setTextureSize(64, 64);
      bladeedge.mirror = true;
      setRotation(bladeedge, 0.0174533F, 0F, 0F);
      bladeedge2 = new ModelRenderer(this, 14, 0);
      bladeedge2.addBox(0F, 0F, 0F, 1, 35, 2);
      bladeedge2.setRotationPoint(-0.5F, -26F, 0F);
      bladeedge2.setTextureSize(64, 64);
      bladeedge2.mirror = true;
      setRotation(bladeedge2, -0.0174533F, 0F, 0F);
      wing11 = new ModelRenderer(this, 20, 0);
      wing11.addBox(0F, 0F, 0F, 1, 4, 5);
      wing11.setRotationPoint(-0.5F, 13F, 4.5F);
      wing11.setTextureSize(64, 64);
      wing11.mirror = true;
      setRotation(wing11, 0.7853982F, 0F, 0F);
      wing22 = new ModelRenderer(this, 20, 9);
      wing22.addBox(0F, 0F, 0F, 1, 4, 5);
      wing22.setRotationPoint(-0.5F, 9.5F, -8F);
      wing22.setTextureSize(64, 64);
      wing22.mirror = true;
      setRotation(wing22, -0.7853982F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    hilt1.render(f5);
    jewel1.render(f5);
    wing2.render(f5);
    wing1.render(f5);
    jewel2.render(f5);
    blade1.render(f5);
    triforce.render(f5);
    point.render(f5);
    bladeedge.render(f5);
    bladeedge2.render(f5);
    wing11.render(f5);
    wing22.render(f5);
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
