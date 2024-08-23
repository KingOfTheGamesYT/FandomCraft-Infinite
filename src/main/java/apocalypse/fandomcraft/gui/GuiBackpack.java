package apocalypse.fandomcraft.gui;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.util.*;
import apocalypse.fandomcraft.player.*;
import net.minecraft.inventory.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class GuiBackpack extends GuiContainer
{
    public float xSize_lo;
    public float ySize_lo;
    public static final ResourceLocation iconLocation;
    public final InventoryBackpack inventory;
    
    public GuiBackpack(final ContainerBackpack containerItem) {
        super((Container)containerItem);
        this.inventory = containerItem.inventory;
    }
    
    public void drawScreen(final int par1, final int par2, final float par3) {
        super.drawScreen(par1, par2, par3);
        this.xSize_lo = (float)par1;
        this.ySize_lo = (float)par2;
    }
    
    protected void drawGuiContainerBackgroundLayer(final float par1, final int par2, final int par3) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiBackpack.iconLocation);
        final int k = (this.width - this.xSize) / 2;
        final int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        drawPlayerModel(k + 51, l + 75, 30, k + 51 - this.xSize_lo, l + 75 - 50 - this.ySize_lo, (EntityLivingBase)this.mc.thePlayer);
    }
    
    protected void keyTyped(final char c, final int keyCode) {
        super.keyTyped(c, keyCode);
        if (c == '\u0001' || c == '\u0001') {
            this.mc.thePlayer.closeScreen();
        }
    }
    
    public static void drawPlayerModel(final int x, final int y, final int scale, final float yaw, final float pitch, final EntityLivingBase entity) {
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, 50.0f);
        GL11.glScalef((float)(-scale), (float)scale, (float)scale);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        final float f2 = entity.renderYawOffset;
        final float f3 = entity.rotationYaw;
        final float f4 = entity.rotationPitch;
        final float f5 = entity.prevRotationYawHead;
        final float f6 = entity.rotationYawHead;
        GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-(float)Math.atan(pitch / 40.0f) * 20.0f, 1.0f, 0.0f, 0.0f);
        entity.renderYawOffset = (float)Math.atan(yaw / 40.0f) * 20.0f;
        entity.rotationYaw = (float)Math.atan(yaw / 40.0f) * 40.0f;
        entity.rotationPitch = -(float)Math.atan(pitch / 40.0f) * 20.0f;
        entity.rotationYawHead = entity.rotationYaw;
        entity.prevRotationYawHead = entity.rotationYaw;
        GL11.glTranslatef(0.0f, entity.yOffset, 0.0f);
        RenderManager.instance.playerViewY = 180.0f;
        RenderManager.instance.renderEntityWithPosYaw((Entity)entity, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        entity.renderYawOffset = f2;
        entity.rotationYaw = f3;
        entity.rotationPitch = f4;
        entity.prevRotationYawHead = f5;
        entity.rotationYawHead = f6;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(32826);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(3553);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    static {
        iconLocation = new ResourceLocation("fandomcraft", "textures/gui/backpack.png");
    }
}
