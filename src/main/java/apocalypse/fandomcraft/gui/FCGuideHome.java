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

public class FCGuideHome extends GuiContainer {
    private static final ResourceLocation texture = new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/backgroundFCGuide.png");

    public FCGuideHome(World world, int i, int j, int k, EntityPlayer entity) {
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
        this.fontRendererObj.drawString("Welcome to the FandomCraft Quest Guide!", posX + -97, posY + -77, 26265);
        this.fontRendererObj.drawString("Before you open the guide, let's cover the basics.", posX + -119, posY + -64, 16777215);
        this.fontRendererObj.drawString("In the guide you can click on page numbers to view", posX + -119, posY + -54, 16777215);
        this.fontRendererObj.drawString("each game's quests. The game's icon will light up", posX + -114, posY + -43, 16777215);
        this.fontRendererObj.drawString("if you're viewing quests from that game.", posX + -98, posY + -33, 16777215);
        this.fontRendererObj.drawString("Only guides to each game's main quests are listed.", posX + -118, posY + -11, 16777215);
        this.fontRendererObj.drawString("For info on Bosses and dungeons that aren't", posX + -107, posY + -2, 16777215);
        this.fontRendererObj.drawString("related to major quests (Tingle and Argorok, for", posX + -119, posY + 6, 16777215);
        this.fontRendererObj.drawString("example) you can check out their pages on", posX + -106, posY + 15, 16777215);
        this.fontRendererObj.drawString("missapocalypse.wix.com/fandomcraft", posX + -89, posY + 25, 26265);
        this.fontRendererObj.drawString("Check your quest progress in Achievements.", posX + -108, posY + 38, 16777215);
    }

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        int posX = this.width / 2;
        int posY = this.height / 2;
        this.buttonList.add(new GuiButton(0, posX + -81, posY + 56, 164, 20, "Open quest guide"));
    }

    protected void actionPerformed(GuiButton button) {
        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
        World world = server.worldServers[0];
        if (button.id == 0) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            int i = (int)player.posX;
            int j = (int)player.posY;
            int k = (int)player.posZ;
            if (player instanceof EntityPlayer) {
                player.openGui(Main.instance, Main.FGuidePage5, world, i, j, k);
            }
        }

    }

    public boolean doesGuiPauseGame() {
        return false;
    }
}
