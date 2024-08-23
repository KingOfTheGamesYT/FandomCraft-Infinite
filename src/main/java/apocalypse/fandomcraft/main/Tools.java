package apocalypse.fandomcraft.main;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.world.*;

public class Tools
{
    public static void println(final String string) {
        System.out.println(string);
    }
    
    public static void printcon(final String string) {
        if (FConfig2.printConsole()) {
            System.out.println(string);
        }
    }
    
    public static void addChat(final EntityPlayer player, final String message) {
        player.addChatMessage((IChatComponent)new ChatComponentText(message));
    }
    
    public static void addColouredChat(final EntityPlayer player, final EnumChatFormatting format, final String text) {
        player.addChatMessage((IChatComponent)new ChatComponentText(format + text));
    }
    
    public static void addSystemChat(final EntityPlayer player, final EnumChatFormatting format1, final String title, final EnumChatFormatting format2, final String text) {
        player.addChatMessage((IChatComponent)new ChatComponentText(format1 + title + format2 + text));
    }
    
    public static EntityPlayer getPlayer() {
        final EntityPlayer player = (EntityPlayer)Minecraft.getMinecraft().thePlayer;
        return player;
    }
    
    public static World getWorld() {
        return getPlayer().worldObj;
    }
}
