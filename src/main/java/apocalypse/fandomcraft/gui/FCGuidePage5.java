package apocalypse.fandomcraft.gui;

import apocalypse.fandomcraft.main.Main;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

public class FCGuidePage5 extends GuiContainer {
    private static final ResourceLocation texture = new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/backgroundFCGuide.png");

    public FCGuidePage5(World world, int i, int j, int k, EntityPlayer entity) {
        super(new FCGuiContainer(entity));
    }

    protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
        int posX = this.width / 2;
        int posY = this.height / 2;
    }

    public static void drawNonStandartTexturedRect(int x, int y, int u, int v, int width, int height, int textureWidth, int textureHeight) {
        float f = 1.0F / (float)textureWidth;
        float f1 = 1.0F / (float)textureHeight;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)x, (double)(y + height), 0.0D, (double)((float)u * f), (double)((float)(v + height) * f1));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + height), 0.0D, (double)((float)(u + width) * f), (double)((float)(v + height) * f1));
        tessellator.addVertexWithUV((double)(x + width), (double)y, 0.0D, (double)((float)(u + width) * f), (double)((float)v * f1));
        tessellator.addVertexWithUV((double)x, (double)y, 0.0D, (double)((float)u * f), (double)((float)v * f1));
        tessellator.draw();
    }

    protected void mouseClicked(int par1, int par2, int par3) {
        super.mouseClicked(par1, par2, par3);
    }

    public void updateScreen() {
        int posX = this.width / 2;
        int posY = this.height / 2;
    }

    protected void keyTyped(char par1, int par2) {
        if (par2 != 28 && par2 != 156 && par2 == 1) {
            this.mc.displayGuiScreen((GuiScreen)null);
        }

    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        int posX = this.width / 2;
        int posY = this.height / 2;
        this.fontRendererObj.drawString("Master Quest", posX + -34, posY + -60, 16777215);
        this.fontRendererObj.drawString("--------------------------------------", posX + -115, posY + -52, 16777215);
        this.fontRendererObj.drawString("To obtain the Master Sword:", posX + -149, posY + -21, 16777215);
        this.fontRendererObj.drawString("Craft the Four Sword, then upgrade it to the True Four Sword.", posX + -149, posY + -11, 12970214);
        this.fontRendererObj.drawString("Gather the 3 Triforce parts and 3 Master Sword parts from", posX + -149, posY + 0, 12970214);
        this.fontRendererObj.drawString("bosses and combine them all to create the Master Sword.", posX + -149, posY + 11, 12970214);
        this.fontRendererObj.drawString("Main goal:", posX + -149, posY + 29, 16777215);
        this.fontRendererObj.drawString("Search dungeons for items you can use against bosses. ", posX + -149, posY + 38, 12970214);
        this.fontRendererObj.drawString("Din's Pearl can spawn Gohma. Link is in the Water Temple.", posX + -149, posY + 48, 12970214);
        this.fontRendererObj.drawString("Zant can rarely be found near Twilight Gates.", posX + -149, posY + 58, 12970214);
        this.fontRendererObj.drawString("Those 3 each drop a Master Sword part which is highly", posX + -149, posY + 68, 12970214);
        this.fontRendererObj.drawString("recommended to use when fighting Ganon, whose tower", posX + -149, posY + 78, 12970214);
        this.fontRendererObj.drawString("can be found high on a mountain.", posX + -149, posY + 88, 12970214);
        this.fontRendererObj.drawString("*Legend Of Zelda*", posX + -140, posY + -113, 16777215);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/Triforce.png"));
        this.drawTexturedModalRect(posX + -19, posY + -91, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/sonic2.png"));
        this.drawTexturedModalRect(posX + -53, posY + -89, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/HP2.png"));
        this.drawTexturedModalRect(posX + -88, posY + -90, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/KH2.png"));
        this.drawTexturedModalRect(posX + 13, posY + -91, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/FF2.png"));
        this.drawTexturedModalRect(posX + 43, posY + -88, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/Elder2.png"));
        this.drawTexturedModalRect(posX + -120, posY + -87, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/Border2.png"));
        this.drawTexturedModalRect(posX + 75, posY + -90, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/lotr2.png"));
        this.drawTexturedModalRect(posX + 113, posY + -86, 0, 0, 256, 256);
        this.mc.renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/doctor2.png"));
        this.drawTexturedModalRect(posX + -150, posY + -90, 0, 0, 256, 256);
    }

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        int posX = this.width / 2;
        int posY = this.height / 2;
        this.buttonList.add(new GuiButton(0, posX + -169, posY + -92, 12, 20, "1"));
        this.buttonList.add(new GuiButton(1, posX + -169, posY + -72, 12, 20, "2"));
        this.buttonList.add(new GuiButton(2, posX + -169, posY + -52, 12, 20, "3"));
        this.buttonList.add(new GuiButton(3, posX + -169, posY + -32, 12, 20, "4"));
        this.buttonList.add(new GuiButton(4, posX + -169, posY + -12, 12, 20, "5"));
        this.buttonList.add(new GuiButton(5, posX + -169, posY + 8, 12, 20, "6"));
        this.buttonList.add(new GuiButton(6, posX + -169, posY + 28, 12, 20, "7"));
        this.buttonList.add(new GuiButton(7, posX + -169, posY + 48, 12, 20, "8"));
        this.buttonList.add(new GuiButton(8, posX + -169, posY + 68, 12, 20, "9"));
        this.buttonList.add(new GuiButton(9, posX + 169, posY + -92, 12, 20, "?"));
    }

    protected void actionPerformed(GuiButton button) {
        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
        World world = server.worldServers[0];
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        int i = (int)player.posX;
        int j = (int)player.posY;
        int k = (int)player.posZ;
        if (button.id == 0 && player instanceof EntityPlayer) {
            player.openGui(Main.instance, Main.FGuidePage1, world, i, j, k);
        }

        if (button.id == 1 && player instanceof EntityPlayer) {
            player.openGui(Main.instance, Main.FGuidePage2, world, i, j, k);
        }

        if (button.id == 2 && player instanceof EntityPlayer) {
            player.openGui(Main.instance, Main.FGuidePage3, world, i, j, k);
        }

        if (button.id == 3 && player instanceof EntityPlayer) {
            player.openGui(Main.instance, Main.FGuidePage4, world, i, j, k);
        }

        if (button.id == 4 && player instanceof EntityPlayer) {
            player.openGui(Main.instance, Main.FGuidePage5, world, i, j, k);
        }

        if (button.id == 5 && player instanceof EntityPlayer) {
            player.openGui(Main.instance, Main.FGuidePage6, world, i, j, k);
        }

        if (button.id == 6 && player instanceof EntityPlayer) {
            player.openGui(Main.instance, Main.FGuidePage7, world, i, j, k);
        }

        if (button.id == 7 && player instanceof EntityPlayer) {
            player.openGui(Main.instance, Main.FGuidePage8, world, i, j, k);
        }

        if (button.id == 8 && player instanceof EntityPlayer) {
            player.openGui(Main.instance, Main.FGuidePage9, world, i, j, k);
        }

        if (button.id == 9 && player instanceof EntityPlayer) {
            player.openGui(Main.instance, Main.FGuideHome, world, i, j, k);
        }

    }

    public boolean doesGuiPauseGame() {
        return false;
    }
}
