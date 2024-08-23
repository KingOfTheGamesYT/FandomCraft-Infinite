package apocalypse.fandomcraft.gui;

import net.minecraft.client.gui.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraftforge.client.event.*;
import apocalypse.fandomcraft.player.*;
import net.minecraft.entity.player.*;
import apocalypse.fandomcraft.horror.*;
import net.minecraft.item.*;
import apocalypse.fandomcraft.main.*;
import org.lwjgl.opengl.*;
import cpw.mods.fml.common.eventhandler.*;

@SideOnly(Side.CLIENT)
public class FuelBar extends Gui
{
    private Minecraft mc;
    private static final ResourceLocation texturepath;
    
    public FuelBar(final Minecraft mc) {
        this.mc = mc;
    }
    
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRenderExperienceBar(final RenderGameOverlayEvent.Post event) {
        final ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)this.mc.thePlayer);
        final EntityPlayer player = (EntityPlayer)this.mc.thePlayer;
        if (event.isCancelable() && player.inventory.armorInventory[1] != new ItemStack(HorrorReg.jetpack)) {
            return;
        }
        if (event.isCancelable() || event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE) {
            return;
        }
        if (props == null) {
            Tools.printcon("This is null!");
            return;
        }
        final int xPos = 2;
        final int yPos = 12;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(FuelBar.texturepath);
        this.drawTexturedModalRect(xPos, yPos, 0, 0, 60, 8);
        final int fuelbarwidth = (int)(props.getCurrentFuel() / (float)props.getMaxFuel() * 58.0f);
        this.drawTexturedModalRect(xPos + 1, yPos + 1, 0, 8, fuelbarwidth, 6);
    }
    
    static {
        texturepath = new ResourceLocation("fandomcraft:textures/gui/fuel_bar.png");
    }
}
