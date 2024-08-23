package apocalypse.fandomcraft.horror.entity;

import net.minecraft.client.renderer.entity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.*;

@SideOnly(Side.CLIENT)
public class RenderMerchantOther extends RenderLiving
{
    private float scale;
    private static final ResourceLocation textures;
    
    public RenderMerchantOther(final ModelBase base, final float f, final float s) {
        super(base, f * s);
        this.scale = s;
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderMerchantOther.textures;
    }
    
    protected void preRenderCallback(final EntityMerchantOther p_77041_1_, final float p_77041_2_) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }
    
    protected void preRenderCallback(final EntityLivingBase p_77041_1_, final float p_77041_2_) {
        this.preRenderCallback((EntityMerchantOther)p_77041_1_, p_77041_2_);
    }
    
    static {
        textures = new ResourceLocation("fandomcraft:textures/models/entity/salesman2.png");
    }
}
