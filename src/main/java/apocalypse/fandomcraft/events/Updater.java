 package apocalypse.fandomcraft.events;

 import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 import java.io.IOException;
 import java.io.InputStream;
 import java.net.MalformedURLException;
 import java.net.URL;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.util.ChatComponentText;
 import net.minecraft.util.IChatComponent;
 import net.minecraftforge.event.entity.EntityJoinWorldEvent;

 public class Updater
 {
   public static boolean twice = true;
   public static String version = "2.1";
   public static String checkOnlineVersion = "http://www.mediafire.com/view/f2irhluo9kwen9o/version.txt";
   public static String newVersionNotification = "http://www.mediafire.com/view/gn2tx8ifb1kigs9/newversion.txt";

   @SubscribeEvent
   public void onWorldLoad(EntityJoinWorldEvent event) {
     if (event.entity instanceof EntityPlayer && event.world.isRemote) {

       EntityPlayer player = (EntityPlayer)event.entity;
       getonlineVersion(player);
     }
   }

   public static void getonlineVersion(EntityPlayer player) {
     try {
       URL onlineVersion = new URL(checkOnlineVersion);
       InputStream input = onlineVersion.openStream();
       byte[] data = new byte[input.available()];
       input.read(data);
       String onlineVersionId = new String(data);
       setUpdateMessage(player);
     }
     catch (MalformedURLException exception) {

       exception.printStackTrace();
     }
     catch (IOException exception) {

       exception.printStackTrace();
     }
   }

   public static void setUpdateMessage(EntityPlayer player) {
     try {
       URL u = new URL(newVersionNotification);
       InputStream stream = u.openStream();
       byte[] data = new byte[stream.available()];
       stream.read(data);

       if (twice = true)
       {

         player.addChatMessage((IChatComponent)new ChatComponentText(new String(newVersionNotification)));
       }
       else
       {
         player.addChatMessage((IChatComponent)new ChatComponentText(new String("Check http://www.planetminecraft.com/mod/1710-fandomcraft/ for mod updates.")));
         twice = false;
       }

     } catch (MalformedURLException exception) {

       exception.printStackTrace();
     }
     catch (IOException exception) {

       exception.printStackTrace();
     }
   }
 }