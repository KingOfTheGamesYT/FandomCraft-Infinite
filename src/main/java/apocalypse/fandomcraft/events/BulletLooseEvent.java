 package apocalypse.fandomcraft.events;

 import cpw.mods.fml.common.eventhandler.Cancelable;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.event.entity.player.PlayerEvent;

 @Cancelable
 public class BulletLooseEvent
   extends PlayerEvent
 {
   public final ItemStack gun;
   public int charge;

   public BulletLooseEvent(EntityPlayer player, ItemStack gun, int charge) {
     super(player);
     this.gun = gun;
     this.charge = charge;
   }
 }