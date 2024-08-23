package apocalypse.fandomcraft.horror.entity;

import net.minecraft.client.renderer.entity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.*;

@SideOnly(Side.CLIENT)
public class RenderLGM extends RenderEnderman
{
    private float scale;
    private static final ResourceLocation textures;
    
    public RenderLGM(final ModelLGM base, final float f, final float s) {
        this.scale = s;
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderLGM.textures;
    }
    
    protected void preRenderCallback(final EntityLGM p_77041_1_, final float p_77041_2_) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }
    
    protected void preRenderCallback(final EntityLivingBase p_77041_1_, final float p_77041_2_) {
        this.preRenderCallback((EntityLGM)p_77041_1_, p_77041_2_);
    }
    
    static {
        textures = new ResourceLocation("fandomcraft:textures/models/entity/alien.png");
    }
}
