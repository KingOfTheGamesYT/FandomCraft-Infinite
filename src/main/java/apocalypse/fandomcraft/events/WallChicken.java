 package apocalypse.fandomcraft.events;

 import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 import net.minecraft.block.Block;
 import net.minecraft.entity.item.EntityItem;
 import net.minecraft.init.Blocks;
 import net.minecraft.init.Items;
 import net.minecraft.world.World;
 import net.minecraftforge.event.world.BlockEvent;

 public class WallChicken
 {
   @SubscribeEvent
   public void BreakEvent(BlockEvent.BreakEvent event) {
     World world = event.world;
     EntityItem item = new EntityItem(world);
     Block block = event.block;
     if (block == Blocks.stone)
     {
       item.dropItem(Items.cooked_chicken, 1);
     }
   }
 }