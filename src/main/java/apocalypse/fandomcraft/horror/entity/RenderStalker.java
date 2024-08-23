package apocalypse.fandomcraft.horror.entity;

import net.minecraft.client.renderer.entity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.*;

@SideOnly(Side.CLIENT)
public class RenderStalker extends RenderBiped
{
    private float scale;
    private static final ResourceLocation textures;
    
    public RenderStalker(final ModelStalker modelStalker, final float f, final float s) {
        super((ModelBiped)modelStalker, f * s);
        this.scale = s;
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderStalker.textures;
    }
    
    protected void preRenderCallback(final EntityStalker p_77041_1_, final float p_77041_2_) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }
    
    protected void preRenderCallback(final EntityLivingBase p_77041_1_, final float p_77041_2_) {
        this.preRenderCallback((EntityStalker)p_77041_1_, p_77041_2_);
    }
    
    static {
        textures = new ResourceLocation("fandomcraft:textures/models/SH_Stalker.png");
    }
}
