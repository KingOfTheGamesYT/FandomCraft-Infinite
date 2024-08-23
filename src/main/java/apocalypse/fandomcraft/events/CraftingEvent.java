 package apocalypse.fandomcraft.events;

 import apocalypse.fandomcraft.main.FandomAchievementList;
 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 import cpw.mods.fml.common.gameevent.PlayerEvent;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.ItemStack;
 import net.minecraft.stats.StatBase;

 public class CraftingEvent
 {
   @SubscribeEvent
   public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
     ItemStack itemStack = event.crafting;
     EntityPlayer player = event.player;
     if (itemStack.getItem() == Main.jungleKing)
     {
       event.player.triggerAchievement((StatBase)FandomAchievementList.FCdarkHeart);
   }
   }
 }