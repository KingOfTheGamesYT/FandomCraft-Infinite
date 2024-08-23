package apocalypse.fandomcraft.gui;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import apocalypse.fandomcraft.horror.*;
import apocalypse.fandomcraft.network.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.entity.player.*;

public class TravellerShopOtherworld extends GuiContainer
{
    private static final ResourceLocation texture;
    
    public TravellerShopOtherworld(final Container container) {
        super(container);
        Tools.printcon("Constructor");
    }
    
    protected void drawGuiContainerBackgroundLayer(final float f, final int x, final int y) {
        final int posX = this.width / 2;
        final int posY = this.height / 2;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.renderEngine.bindTexture(TravellerShopOtherworld.texture);
        final int xSize = 196;
        final int ySize = 128;
        final int k = (this.width - xSize) / 2;
        final int l = (this.height - ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
    }
    
    protected void mouseClicked(final int par1, final int par2, final int par3) {
        Tools.printcon("Mouse was clicked");
        super.mouseClicked(par1, par2, par3);
    }
    
    public void updateScreen() {
        final int posX = this.width / 2;
        final int posY = this.height / 2;
    }
    
    protected void keyTyped(final char par1, final int par2) {
        Tools.printcon("Key typed");
        if (par2 != 28 && par2 != 156 && par2 == 1) {
            this.mc.displayGuiScreen((GuiScreen)null);
        }
    }
    
    protected void drawGuiContainerForegroundLayer(final int par1, final int par2) {
        final int posX = this.width / 2;
        final int posY = this.height / 2;
        this.fontRendererObj.drawString("Holy Water: $200", posX - 85, posY - 59, 0);
        this.fontRendererObj.drawString("Pumpkin Bomb: $300", posX - 85, posY - 31, 0);
        this.fontRendererObj.drawString("Handgun: $1500", posX - 85, posY - 3, 0);
        this.fontRendererObj.drawString("Bullet (x4): $50", posX - 85, posY + 25, 0);
    }
    
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    public void initGui() {
        Tools.printcon("Initialising gui");
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        final int posX = this.width / 2;
        final int posY = this.height / 2;
        this.buttonList.add(new GuiButton(0, posX + 50, posY - 59, 36, 20, "Buy"));
        this.buttonList.add(new GuiButton(1, posX + 50, posY - 31, 36, 20, "Buy"));
        this.buttonList.add(new GuiButton(2, posX + 50, posY - 3, 36, 20, "Buy"));
        this.buttonList.add(new GuiButton(3, posX + 50, posY + 25, 36, 20, "Buy"));
    }
    
    protected void actionPerformed(final GuiButton button) {
        Tools.printcon("Button clicked");
        final EntityPlayer player = (EntityPlayer)Minecraft.getMinecraft().thePlayer;
        final int i = (int)player.posX;
        final int j = (int)player.posY;
        final int k = (int)player.posZ;
        if (button.id == 0) {
            Tools.printcon("Sending packet for purchase #1");
            final APacketPurchase.PurchaseMessage purchaseMessage = new APacketPurchase.PurchaseMessage(player, 200, HorrorReg.holyWater);
        }
        if (button.id == 1) {
            Tools.printcon("Sending packet for purchase #2");
            final APacketPurchase.PurchaseMessage purchaseMessage2 = new APacketPurchase.PurchaseMessage(player, 300, HorrorReg.pumpkinBomb);
        }
        if (button.id == 2) {
            Tools.printcon("Sending packet for purchase #3");
            final APacketPurchase.PurchaseMessage purchaseMessage3 = new APacketPurchase.PurchaseMessage(player, 1500, HorrorReg.handgun);
        }
        if (button.id == 3) {
            Tools.printcon("Sending packet for purchase #4");
            final APacketPurchase.PurchaseMessage purchaseMessage4 = new APacketPurchase.PurchaseMessage(player, 50, Main.bullet, 4);
        }
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    static {
        texture = new ResourceLocation("fandomcraft:textures/gui/stretchedIcons/guiShop.png");
    }
}
