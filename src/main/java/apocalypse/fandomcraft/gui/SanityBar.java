package apocalypse.fandomcraft.gui;

import net.minecraft.client.gui.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraftforge.client.event.*;
import apocalypse.fandomcraft.player.*;
import net.minecraft.entity.player.*;
import apocalypse.fandomcraft.main.*;
import org.lwjgl.opengl.*;
import cpw.mods.fml.common.eventhandler.*;

@SideOnly(Side.CLIENT)
public class SanityBar extends Gui
{
    private Minecraft mc;
    private static final ResourceLocation texturepath;
    
    public SanityBar(final Minecraft mc) {
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
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(SanityBar.texturepath);
        this.drawTexturedModalRect(xPos, yPos, 0, 0, 60, 8);
        final int sanitybarwidth = (int)(props.getCurrentSanity() / (float)props.getMaxSanity() * 58.0f);
        this.drawTexturedModalRect(xPos + 1, yPos + 1, 0, 8, sanitybarwidth, 6);
    }
    
    static {
        texturepath = new ResourceLocation("fandomcraft:textures/gui/sanity_bar.png");
    }
}
