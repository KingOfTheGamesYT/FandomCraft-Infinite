package apocalypse.fandomcraft.horror;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelTrashBin extends ModelBase
{
    ModelRenderer Bin;
    ModelRenderer Lid;
    ModelRenderer Handle;
    
    public ModelTrashBin() {
        this.textureWidth = 128;
        this.textureHeight = 32;
        (this.Bin = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-5.0f, 0.0f, -5.0f, 10, 14, 10);
        this.Bin.setRotationPoint(0.0f, 10.0f, 0.0f);
        this.Bin.setTextureSize(128, 32);
        this.Bin.mirror = true;
        this.setRotation(this.Bin, 0.0f, 0.0f, 0.0f);
        (this.Lid = new ModelRenderer((ModelBase)this, 40, 0)).addBox(-5.5f, 1.0f, -5.5f, 11, 2, 11);
        this.Lid.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.Lid.setTextureSize(128, 32);
        this.Lid.mirror = true;
        this.setRotation(this.Lid, 0.0f, 0.0f, 0.0f);
        (this.Handle = new ModelRenderer((ModelBase)this, 40, 13)).addBox(-2.0f, 0.0f, -0.5f, 4, 1, 1);
        this.Handle.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.Handle.setTextureSize(128, 32);
        this.Handle.mirror = true;
        this.setRotation(this.Handle, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Bin.render(f5);
        this.Lid.render(f5);
        this.Handle.render(f5);
    }
    
    public void renderModel(final float f) {
        this.Bin.render(f);
        this.Lid.render(f);
        this.Handle.render(f);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
