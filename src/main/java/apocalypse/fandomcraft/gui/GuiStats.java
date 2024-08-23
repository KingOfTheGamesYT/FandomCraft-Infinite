package apocalypse.fandomcraft.gui;

import net.minecraft.client.gui.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.*;
import net.minecraftforge.client.event.*;
import apocalypse.fandomcraft.player.*;
import net.minecraft.entity.player.*;
import apocalypse.fandomcraft.main.*;
import cpw.mods.fml.common.eventhandler.*;

@SideOnly(Side.CLIENT)
public class GuiStats extends Gui
{
    private Minecraft mc;
    
    public GuiStats(final Minecraft mc) {
        this.mc = mc;
    }
    
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRenderExperienceBar(final RenderGameOverlayEvent.Post event) {
        if (event.isCancelable() || event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE) {
            return;
        }
        final ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)this.mc.thePlayer);
        if (props == null) {
            Tools.printcon("This is null!");
            return;
        }
        final int xPos = 2;
        final int yPos = 2;
        this.mc.fontRenderer.drawStringWithShadow("$" + Integer.toString(props.getMoney()), xPos, yPos + this.getAdjustment(), 16777215);
    }
    
    public int getAdjustment() {
        final EntityPlayer player = (EntityPlayer)this.mc.thePlayer;
        return 10;
    }
}
