 package apocalypse.fandomcraft.events;

 import apocalypse.fandomcraft.main.FConfig2;
 import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 import cpw.mods.fml.common.gameevent.TickEvent;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.audio.ISound;
 import net.minecraft.client.audio.PositionedSoundRecord;
 import net.minecraft.client.multiplayer.WorldClient;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.world.World;

 public class TimeEvents
 {
   Minecraft mc;
   ISound sound;
   EntityPlayer player;

   @SubscribeEvent
   public void onWorldTick(TickEvent.ClientTickEvent event) {
     WorldClient worldClient = this.mc.theWorld;
     if (worldClient.getWorldTime() == 10000L)
     {
       if (((World)worldClient).provider.dimensionId == FConfig2.OtherworldID()) {

         ResourceLocation file = new ResourceLocation("fandomcraft:records.SirenWorld");
         this.sound = (ISound)PositionedSoundRecord.func_147673_a(file);
         this.mc.getSoundHandler().playSound(this.sound);
       }
     }
   }
 }