package apocalypse.fandomcraft.horror.entity;

import net.minecraft.client.renderer.entity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.*;

@SideOnly(Side.CLIENT)
public class RenderPyramid extends RenderLiving
{
    private float scale;
    private static final ResourceLocation textures;
    
    public RenderPyramid(final ModelBase base, final float f, final float s) {
        super(base, f * s);
        this.scale = s;
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderPyramid.textures;
    }
    
    protected void preRenderCallback(final EntityPyramid p_77041_1_, final float p_77041_2_) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }
    
    protected void preRenderCallback(final EntityLivingBase p_77041_1_, final float p_77041_2_) {
        this.preRenderCallback((EntityPyramid)p_77041_1_, p_77041_2_);
    }
    
    public void doRender(final Entity entity, final double var2, final double var4, final double var6, final float var8, final float var9) {
        BossStatus.setBossStatus((IBossDisplayData)entity, true);
        super.doRender(entity, var2, var4, var6, var8, var9);
    }
    
    static {
        textures = new ResourceLocation("fandomcraft:textures/models/RedPyramid.png");
    }
}
