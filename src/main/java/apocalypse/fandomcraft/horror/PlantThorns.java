package apocalypse.fandomcraft.horror;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;

public class PlantThorns extends HorrorPlant
{
    public PlantThorns(final float f) {
        super(f);
        this.setBlockBounds(f, 0.0f, f, 1.0f - f, 1.0f - f, 1.0f - f);
    }
    
    public void onEntityCollidedWithBlock(final World world, final int x, final int y, final int z, final Entity entity) {
        if (entity instanceof EntityPlayer) {
            entity.attackEntityFrom(DamageSource.generic, 2.0f);
        }
    }
}
