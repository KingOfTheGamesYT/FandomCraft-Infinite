 package apocalypse.fandomcraft.events;

 import apocalypse.fandomcraft.main.FConfig;
 import java.util.List;
 import net.minecraft.command.ICommand;
 import net.minecraft.command.ICommandSender;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.util.ChatComponentText;
 import net.minecraft.util.EnumChatFormatting;
 import net.minecraft.util.IChatComponent;

 public class CommandFC implements ICommand {
   public boolean isUsernameIndex(int var1) {
     return false;
   }

   public boolean canCommandSenderUseCommand(ICommandSender var1) {
     return true;
   }

   public List getCommandAliases() {
     return null;
   }

   public List addTabCompletionOptions(ICommandSender sender, String[] options) {
     return null;
   }

   public boolean isUsernameIndex(String[] string, int index) {
     return true;
  }

   public String getCommandName() {
     return "FandomCraftReloadConfig";
   }

   public String getCommandUsage(ICommandSender sender) {
     return "/fcreload";
   }

   public int compareTo(Object obj) {
     return -1;
   }

   public void processCommand(ICommandSender sender, String[] cmd) {
     EntityPlayer entity = (EntityPlayer)sender;
     FConfig.fConfig.load();
     sender.addChatMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.RED + "[FandomCraft]" + EnumChatFormatting.GOLD + " Loaded config."));
   }
 }