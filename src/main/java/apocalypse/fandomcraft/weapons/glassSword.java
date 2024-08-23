package apocalypse.fandomcraft.weapons;

import net.minecraft.item.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraft.entity.monster.*;
import apocalypse.fandomcraft.main.*;
import cpw.mods.fml.common.eventhandler.*;

public class glassSword extends ItemSword
{
    public glassSword(final Item.ToolMaterial Glass) {
        super(Glass);
        this.setMaxStackSize(1);
    }
    
    @SubscribeEvent
    public void onEntityDrop(final LivingDropsEvent event) {
        if (event.entityLiving instanceof EntitySlime) {
            event.entityLiving.dropItem(Main.glassSword, 1);
        }
    }
}
