package apocalypse.fandomcraft.horror;

import net.minecraft.command.*;
import java.util.*;
import net.minecraft.entity.player.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.util.*;

public class CommandGiveSanity implements ICommand
{
    public boolean isUsernameIndex(final int var1) {
        return false;
    }
    
    public boolean canCommandSenderUseCommand(final ICommandSender var1) {
        return true;
    }
    
    public List getCommandAliases() {
        return null;
    }
    
    public List addTabCompletionOptions(final ICommandSender sender, final String[] options) {
        return null;
    }
    
    public boolean isUsernameIndex(final String[] string, final int index) {
        return true;
    }
    
    public String getCommandName() {
        return "FandomCraftReloadConfig";
    }
    
    public String getCommandUsage(final ICommandSender sender) {
        return "/fcreload";
    }
    
    public int compareTo(final Object obj) {
        return -1;
    }
    
    public void processCommand(final ICommandSender sender, final String[] cmd) {
        final EntityPlayer entity = (EntityPlayer)sender;
        FConfig.fConfig.load();
        sender.addChatMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.RED + "[FandomCraft]" + EnumChatFormatting.GOLD + " Loaded config."));
    }
}
