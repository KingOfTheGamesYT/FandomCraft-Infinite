 package apocalypse.fandomcraft.events;

 import cpw.mods.fml.common.eventhandler.Cancelable;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraftforge.event.entity.living.LivingEvent;

 @Cancelable
 public class BasicTeleportEvent
   extends LivingEvent
 {
   public double targetX;
   public double targetY;
   public double targetZ;
   public float attackDamage;

   public BasicTeleportEvent(EntityLivingBase entity, double targetX, double targetY, double targetZ) {
     super(entity);
     this.targetX = targetX;
     this.targetY = targetY;
     this.targetZ = targetZ;
   }
 }