package apocalypse.fandomcraft.gui;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.input.*;
import net.minecraft.client.gui.*;
import cpw.mods.fml.common.*;
import net.minecraft.client.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.server.*;

public class FCGuidePage9 extends GuiContainer
{
    private static final ResourceLocation texture;
    
    public FCGuidePage9(final World world, final int i, final int j, final int k, final EntityPlayer entity) {
        super((Container)new FCGuiContainer(entity));
    }
    
    protected void drawGuiContainerBackgroundLayer(final float f, final int x, final int y) {
        final int posX = this.width / 2;
        final int posY = this.height / 2;
    }
    
    public static void drawNonStandartTexturedRect(final int x, final int y, final int u, final int v, final int width, final int height, final int textureWidth, final int textureHeight) {
        final float f = 1.0f / textureWidth;
        final float f2 = 1.0f / textureHeight;
        final Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)x, (double)(y + height), 0.0, (double)(u * f), (double)((v + height) * f2));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + height), 0.0, (double)((u + width) * f), (double)((v + height) * f2));
        tessellator.addVertexWithUV((double)(x + width), (double)y, 0.0, (double)((u + width) * f), (double)(v * f2));
        tessellator.addVertexWithUV((double)x, (double)y, 0.0, (double)(u * f), (double)(v * f2));
        tessellator.draw();
    }
    
    protected void mouseClicked(final int par1, final int par2, final int par3) {
        super.mouseClicked(par1, par2, par3);
    }
    
    public void updateScreen() {
        final int posX = this.width / 2;
        final int posY = this.height / 2;
    }
    
    protected void keyTyped(final char par1, final int par2) {
        if (par2 != 28 && par2 != 156 && par2 == 1) {
            this.mc.displayGuiScreen((GuiScreen)null);
        }
    }
    
    protected void drawGuiContainerForegroundLayer(final int par1, final int par2) {
        final int posX = this.width / 2;
        final int posY = this.height / 2;
        this.fontRendererObj.drawString("Fellowship of the Ring", posX - 44, posY - 60, 16777215);
        this.fontRendererObj.drawString("--------------------------------------", posX - 115, posY - 52, 16777215);
        this.fontRendererObj.drawString("Will be added in the Middle Earth update", posX - 149, posY - 21, 16777215);
        this.fontRendererObj.drawString("*Lord of the Rings*", posX - 140, posY - 113, 16777215);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/Triforce2.png"));
        this.drawTexturedModalRect(posX - 19, posY - 91, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/sonic2.png"));
        this.drawTexturedModalRect(posX - 53, posY - 89, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/HP2.png"));
        this.drawTexturedModalRect(posX - 88, posY - 90, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/KH2.png"));
        this.drawTexturedModalRect(posX + 13, posY - 91, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/FF2.png"));
        this.drawTexturedModalRect(posX + 43, posY - 88, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/Elder2.png"));
        this.drawTexturedModalRect(posX - 120, posY - 87, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/Border2.png"));
        this.drawTexturedModalRect(posX + 75, posY - 90, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/lotr.png"));
        this.drawTexturedModalRect(posX + 113, posY - 86, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/doctor2.png"));
        this.drawTexturedModalRect(posX - 150, posY - 90, 0, 0, 256, 256);
    }
    
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        final int posX = this.width / 2;
        final int posY = this.height / 2;
        this.buttonList.add(new GuiButton(0, posX - 169, posY - 92, 12, 20, "1"));
        this.buttonList.add(new GuiButton(1, posX - 169, posY - 72, 12, 20, "2"));
        this.buttonList.add(new GuiButton(2, posX - 169, posY - 52, 12, 20, "3"));
        this.buttonList.add(new GuiButton(3, posX - 169, posY - 32, 12, 20, "4"));
        this.buttonList.add(new GuiButton(4, posX - 169, posY - 12, 12, 20, "5"));
        this.buttonList.add(new GuiButton(5, posX - 169, posY + 8, 12, 20, "6"));
        this.buttonList.add(new GuiButton(6, posX - 169, posY + 28, 12, 20, "7"));
        this.buttonList.add(new GuiButton(7, posX - 169, posY + 48, 12, 20, "8"));
        this.buttonList.add(new GuiButton(8, posX - 169, posY + 68, 12, 20, "9"));
        this.buttonList.add(new GuiButton(9, posX + 169, posY - 92, 12, 20, "?"));
    }
    
    protected void actionPerformed(final GuiButton button) {
        final MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
        final World world = (World)server.worldServers[0];
        final EntityPlayer player = (EntityPlayer)Minecraft.getMinecraft().thePlayer;
        final int i = (int)player.posX;
        final int j = (int)player.posY;
        final int k = (int)player.posZ;
        if (button.id == 0 && player instanceof EntityPlayer) {
            player.openGui((Object)Main.instance, Main.FGuidePage1, world, i, j, k);
        }
        if (button.id == 1 && player instanceof EntityPlayer) {
            player.openGui((Object)Main.instance, Main.FGuidePage2, world, i, j, k);
        }
        if (button.id == 2 && player instanceof EntityPlayer) {
            player.openGui((Object)Main.instance, Main.FGuidePage3, world, i, j, k);
        }
        if (button.id == 3 && player instanceof EntityPlayer) {
            player.openGui((Object)Main.instance, Main.FGuidePage4, world, i, j, k);
        }
        if (button.id == 4 && player instanceof EntityPlayer) {
            player.openGui((Object)Main.instance, Main.FGuidePage5, world, i, j, k);
        }
        if (button.id == 5 && player instanceof EntityPlayer) {
            player.openGui((Object)Main.instance, Main.FGuidePage6, world, i, j, k);
        }
        if (button.id == 6 && player instanceof EntityPlayer) {
            player.openGui((Object)Main.instance, Main.FGuidePage7, world, i, j, k);
        }
        if (button.id == 7 && player instanceof EntityPlayer) {
            player.openGui((Object)Main.instance, Main.FGuidePage8, world, i, j, k);
        }
        if (button.id == 8 && player instanceof EntityPlayer) {
            player.openGui((Object)Main.instance, Main.FGuidePage9, world, i, j, k);
        }
        if (button.id == 9 && player instanceof EntityPlayer) {
            player.openGui((Object)Main.instance, Main.FGuideHome, world, i, j, k);
        }
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    static {
        texture = new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/backgroundFCGuide.png");
    }
}
