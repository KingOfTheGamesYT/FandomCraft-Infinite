 package apocalypse.fandomcraft.events;

 import apocalypse.fandomcraft.main.FandomAchievementList;
 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.stats.StatBase;
 import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

 public class PickupEvents
 {
   @SubscribeEvent
   public void pickupItem(EntityItemPickupEvent event) {
     Item item = event.item.getEntityItem().getItem();
     EntityPlayer player = (EntityPlayer)event.entity;

     if (item == Main.rupeeGreen) {

       player.worldObj.playSoundAtEntity((Entity)player, "fandomcraft:rupee", 1.0F, 1.0F);
       player.worldObj.playSoundAtEntity((Entity)player, "fandomcraft:rupee", 1.0F, 1.0F);
       event.entityPlayer.triggerAchievement((StatBase)FandomAchievementList.rupee);
     }
     if (item == Main.rupeeBlue) {

       player.worldObj.playSoundAtEntity((Entity)player, "fandomcraft:rupee", 1.0F, 1.0F);
       event.entityPlayer.triggerAchievement((StatBase)FandomAchievementList.rupee);
     }
     if (item == Main.rupeeYellow) {

       player.worldObj.playSoundAtEntity((Entity)player, "fandomcraft:rupee", 1.0F, 1.0F);
       event.entityPlayer.triggerAchievement((StatBase)FandomAchievementList.rupee);
     }
     if (item == Main.rupeeRed) {

       player.worldObj.playSoundAtEntity((Entity)player, "fandomcraft:rupee", 1.0F, 1.0F);
       event.entityPlayer.triggerAchievement((StatBase)FandomAchievementList.rupee);
     }
     if (item == Main.rupeePurple) {

       player.worldObj.playSoundAtEntity((Entity)player, "fandomcraft:rupee", 1.0F, 1.0F);
       event.entityPlayer.triggerAchievement((StatBase)FandomAchievementList.rupee);
     }
     if (item == Main.rupeeOrange) {

       player.worldObj.playSoundAtEntity((Entity)player, "fandomcraft:rupee", 1.0F, 1.0F);
       event.entityPlayer.triggerAchievement((StatBase)FandomAchievementList.rupee);
     }
     if (item == Main.rupeeSilver) {

       player.worldObj.playSoundAtEntity((Entity)player, "fandomcraft:rupee", 1.0F, 1.0F);
       event.entityPlayer.triggerAchievement((StatBase)FandomAchievementList.rupee);
     }

     if (item == Main.darkHeart)
     {
       event.entityPlayer.triggerAchievement((StatBase)FandomAchievementList.FCdarkHeart);
     }
     if (item == Main.goldenFeather)
     {
       event.entityPlayer.triggerAchievement((StatBase)FandomAchievementList.goldenFeather);
     }
   }
 }