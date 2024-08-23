package apocalypse.fandomcraft.weapons;

import net.minecraft.item.*;

public class arpeggio extends ItemSword
{
    private boolean shouldRotate;
    
    public arpeggio(final Item.ToolMaterial KingdomKey) {
        super(KingdomKey);
        this.shouldRotate = false;
        this.setMaxStackSize(1);
    }
}
