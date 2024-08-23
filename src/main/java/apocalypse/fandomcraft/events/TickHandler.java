 package apocalypse.fandomcraft.events;

 import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 import cpw.mods.fml.common.gameevent.TickEvent;
 import net.minecraft.client.Minecraft;
 import net.minecraft.entity.player.EntityPlayer;

 public class TickHandler
 {
   public EntityPlayer player = (EntityPlayer)(Minecraft.getMinecraft()).thePlayer;
   public int[] armorInventory = new int[4];

   @SubscribeEvent
   public void onClientTick(TickEvent.ClientTickEvent event) {}

   @SubscribeEvent
   public void onServerTick(TickEvent.ServerTickEvent event) {}

   @SubscribeEvent
   public void onRenderTick(TickEvent.RenderTickEvent event) {}

   @SubscribeEvent
   public void onWorldTick(TickEvent.WorldTickEvent event) {}
 }