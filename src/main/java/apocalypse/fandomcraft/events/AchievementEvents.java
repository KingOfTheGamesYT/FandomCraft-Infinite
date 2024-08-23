 package apocalypse.fandomcraft.events;

 import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraftforge.event.entity.player.AchievementEvent;

 public class AchievementEvents
 {
   @SubscribeEvent
   public void getAchieve(AchievementEvent event) {
     EntityPlayer player = (EntityPlayer)event.entity;

     boolean isSpecial = event.achievement.getSpecial();
     if (!event.achievement.isIndependent && !isSpecial)
     {
       player.playSound("fandomcraft:jingle", 1.0F, 1.0F);
     }
     if (isSpecial)
     {
       player.playSound("fandomcraft:Item", 1.0F, 1.0F);
     }
   }
 }