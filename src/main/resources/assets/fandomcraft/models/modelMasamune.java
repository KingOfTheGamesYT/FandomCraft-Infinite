package assets.fandomcraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelMasamune extends ModelBase
{
  //fields
    ModelRenderer handle;
    ModelRenderer handguard;
    ModelRenderer blade1;
    ModelRenderer blade2;
  
  public modelMasamune()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      handle = new ModelRenderer(this, 4, 0);
      handle.addBox(0F, 0F, 0F, 1, 5, 1);
      handle.setRotationPoint(-0.5F, 0F, -6F);
      handle.setTextureSize(32, 32);
      handle.mirror = true;
      setRotation(handle, 0.7853982F, 0F, 0F);
      handguard = new ModelRenderer(this, 8, 0);
      handguard.addBox(0F, 0F, 0F, 3, 1, 3);
      handguard.setRotationPoint(-1.5F, 0F, -7.5F);
      handguard.setTextureSize(32, 32);
      handguard.mirror = true;
      setRotation(handguard, 0.7853982F, 0F, 0F);
      blade1 = new ModelRenderer(this, 0, 0);
      blade1.addBox(0F, 0F, 0F, 1, 16, 1);
      blade1.setRotationPoint(-0.5F, -1.5F, -6F);
      blade1.setTextureSize(32, 32);
      blade1.mirror = true;
      setRotation(blade1, -2.356194F, 0F, 0F);
      blade2 = new ModelRenderer(this, 20, 0);
      blade2.addBox(0F, 0F, 0F, 1, 18, 1);
      blade2.setRotationPoint(-0.5F, -12.2F, -17F);
      blade2.setTextureSize(32, 32);
      blade2.mirror = true;
      setRotation(blade2, -2.513274F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    handle.render(f5);
    handguard.render(f5);
    blade1.render(f5);
    blade2.render(f5);
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
