package apocalypse.fandomcraft.horror.entity;

import net.minecraftforge.client.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

@SideOnly(Side.CLIENT)
public class RenderItemGiantKnife implements IItemRenderer
{
    protected ModelGiantKnife giantKnife;
    
    public RenderItemGiantKnife() {
        this.giantKnife = new ModelGiantKnife();
    }
    
    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        switch (type) {
            case EQUIPPED: {
                return true;
            }
            case EQUIPPED_FIRST_PERSON: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        return false;
    }
    
    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object... data) {
        switch (type) {
            case EQUIPPED: {
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/models/entity/GiantKnife.png"));
                GL11.glRotatef(90.0f, 0.0f, 180.0f, 1.0f);
                GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(0.0f, -1.8f, 0.8f);
                GL11.glScalef(1.2f, 1.2f, 1.2f);
                this.giantKnife.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.06215f);
                GL11.glPopMatrix();
            }
            case EQUIPPED_FIRST_PERSON: {
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/models/entity/GiantKnife.png"));
                GL11.glRotatef(90.0f, 0.0f, 180.0f, 1.0f);
                GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(0.0f, -1.8f, 0.8f);
                GL11.glScalef(1.2f, 1.2f, 1.2f);
                this.giantKnife.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.06215f);
                GL11.glPopMatrix();
                break;
            }
        }
    }
}
