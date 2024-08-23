 package apocalypse.fandomcraft.events;

 import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 import net.minecraft.entity.Entity;
 import net.minecraftforge.event.entity.living.LivingHurtEvent;

 public class BossWeakpoints
 {
   @SubscribeEvent
   public void onHit(LivingHurtEvent living) {
     Entity entity = living.source.getSourceOfDamage();
     if (living.entity instanceof net.minecraft.entity.player.EntityPlayer) {
       return;
     }

     if (living.source.isProjectile())
     {
       if (living.entity instanceof apocalypse.fandomcraft.entity.EntityGohma && entity instanceof net.minecraft.entity.IProjectile)
       {
         if (living.entity.posY + living.entity.getEyeHeight() - 0.4000000059604645D < entity.posY && entity.posY < living.entity.posY + living.entity
           .getEyeHeight() + 0.4000000059604645D)
         {
          living.ammount *= 10.0F;
         }
       }
     }
   }
 }