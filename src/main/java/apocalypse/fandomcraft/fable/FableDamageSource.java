 package apocalypse.fandomcraft.fable;

 import net.minecraft.entity.Entity;
 import net.minecraft.util.DamageSource;
 import net.minecraft.util.EntityDamageSourceIndirect;

 public class FableDamageSource
 {
   public static DamageSource causeArrowDamage(ProjectileBolt p_76353_0_, Entity p_76353_1_) {
     return (new EntityDamageSourceIndirect("bolt", p_76353_0_, p_76353_1_)).setProjectile();
   }

   public static DamageSource causeArrowDamage(ProjectileBullet p_76353_0_, Entity p_76353_1_) {
     return (new EntityDamageSourceIndirect("bullet", (Entity)p_76353_0_, p_76353_1_)).setProjectile();
   }
 }