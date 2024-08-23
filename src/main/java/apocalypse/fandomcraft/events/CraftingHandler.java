 package apocalypse.fandomcraft.events;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 import cpw.mods.fml.common.gameevent.PlayerEvent;
 import net.minecraft.inventory.IInventory;
 import net.minecraft.item.ItemStack;

 public class CraftingHandler
 {
   @SubscribeEvent
   public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
     IInventory craftMatrix = null;
     for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
       if (event.craftMatrix.getStackInSlot(i) != null) {

         ItemStack item0 = event.craftMatrix.getStackInSlot(i);
         if (item0 != null && item0.getItem() == Main.plasticknife) {
           ItemStack k = new ItemStack(Main.plasticknife, 2, item0.getItemSpriteNumber() + 1);

           if (k.getItemSpriteNumber() >= k.getMaxItemUseDuration()) {
             k.stackSize--;
           }

           event.craftMatrix.setInventorySlotContents(i, k);
         }

         ItemStack item1 = event.craftMatrix.getStackInSlot(i);
         if (item1 != null && item1.getItem() == Main.philosopherStone) {

           ItemStack k = new ItemStack(Main.philosopherStone, 2, item1.getItemSpriteNumber() + 1);

           if (k.getItemSpriteNumber() >= k.getMaxItemUseDuration())
           {
             k.stackSize--;
           }

           event.craftMatrix.setInventorySlotContents(i, k);
         }
       }
     }
   }
 }