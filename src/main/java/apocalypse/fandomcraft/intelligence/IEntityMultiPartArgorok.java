package apocalypse.fandomcraft.intelligence;

import apocalypse.fandomcraft.entity.EntityArgorokPart;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public interface IEntityMultiPartArgorok {
  World func_82194_d();
  
  boolean attackEntityFromPart(EntityArgorokPart paramEntityArgorokPart, DamageSource paramDamageSource, float paramFloat);
}