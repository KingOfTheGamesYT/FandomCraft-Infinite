 package apocalypse.fandomcraft.events;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.eventhandler.EventPriority;
 import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 import cpw.mods.fml.common.gameevent.TickEvent;
 import net.minecraft.event.ClickEvent;
 import net.minecraft.util.ChatComponentText;
 import net.minecraft.util.ChatStyle;
 import net.minecraft.util.EnumChatFormatting;
 import net.minecraft.util.IChatComponent;

 public class LoadingEvent
 {
   private static String url = "http://missapocalypse.wix.com/fandomcraft";

   @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
   public void onEvent(TickEvent.PlayerTickEvent event) {
     if (!Main.haveWarnedVersionOutOfDate) {

       ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, "http://missapocalypse.wix.com/fandomcraft");

       ChatStyle clickableChatStyle = (new ChatStyle()).setChatClickEvent(versionCheckChatClickEvent);

       ChatComponentText versionWarningChatComponent = new ChatComponentText("Check for new version at " + EnumChatFormatting.GOLD + url);

       versionWarningChatComponent.setChatStyle(clickableChatStyle);

       event.player.addChatMessage((IChatComponent)versionWarningChatComponent);

       Main.haveWarnedVersionOutOfDate = true;
     }
   }
 }