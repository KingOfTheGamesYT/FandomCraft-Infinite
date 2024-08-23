 package apocalypse.fandomcraft.entity;

 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.world.World;

 public class EntityEnergyPulse
   extends EntityEnergyBall
 {
   public EntityEnergyPulse(World par1World) {
     super(par1World);
   }

   public EntityEnergyPulse(World world, EntityLivingBase living, float f) {
     super(world, living, f);
     this.power = f;
   }

   public EntityEnergyPulse(World world, double x, double y, double z) {
     super(world, x, y, z);
   }
 }