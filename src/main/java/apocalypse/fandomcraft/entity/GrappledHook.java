 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.eventhandler.Event;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import java.util.Random;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.entity.player.EntityPlayerMP;
 import net.minecraft.entity.projectile.EntityThrowable;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.DamageSource;
 import net.minecraft.util.MovingObjectPosition;
 import net.minecraft.world.World;
 import net.minecraftforge.common.MinecraftForge;
 import net.minecraftforge.event.entity.living.EnderTeleportEvent;

 public class GrappledHook extends EntityThrowable {
   public boolean canSteal = true;
   int fadeTimer;

   public GrappledHook(World p_i1782_1_) {
     super(p_i1782_1_);

     this.fadeTimer = 0; } public GrappledHook(World p_i1783_1_, EntityLivingBase p_i1783_2_) { super(p_i1783_1_, p_i1783_2_); this.fadeTimer = 0; } @SideOnly(Side.CLIENT) public GrappledHook(World p_i1784_1_, double p_i1784_2_, double p_i1784_4_, double p_i1784_6_) { super(p_i1784_1_, p_i1784_2_, p_i1784_4_, p_i1784_6_); this.fadeTimer = 0; } protected float getGravityVelocity() {
     return 0.05F;
   } protected void onImpact(MovingObjectPosition mop) {
     EntityPlayer player = (EntityPlayer)getThrower();
     if (mop.entityHit != null) {

       mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)getThrower()), 0.0F);
       if (mop.entityHit instanceof EntityBokoblin) {

         Random r = new Random();
         int stealChance = r.nextInt(5);
         if (stealChance == 1)
         {
           player.inventory.addItemStackToInventory(new ItemStack(Main.skullNecklace, 1));
         }
       }
       else {

         player.playSound("fandomcraft:ropeSwing", 1.0F, 1.0F);

         Random r = new Random();
         int i = 1 + r.nextInt(100);

         if (i <= 25)
         {
           player.inventory.addItemStackToInventory(new ItemStack(Main.rupeeGreen, 1));
         }
         if (i > 51 && i <= 55)
         {
           player.inventory.addItemStackToInventory(new ItemStack(Main.rupeeBlue, 1));
         }
         if (i > 71 && i <= 72)
         {
           player.inventory.addItemStackToInventory(new ItemStack(Main.rupeeRed, 1));
         }
         if (i == 73)
         {
           player.inventory.addItemStackToInventory(new ItemStack(Main.rupeePurple, 1));
         }
       }
       setDead();
     }
     if (!this.worldObj.isRemote) {

       if (getThrower() != null && getThrower() instanceof EntityPlayerMP) {

         EntityPlayerMP entityplayermp = (EntityPlayerMP)getThrower();

         if (entityplayermp.playerNetServerHandler.func_147362_b().isChannelOpen() && entityplayermp.worldObj == this.worldObj) {

           EnderTeleportEvent event = new EnderTeleportEvent((EntityLivingBase)entityplayermp, this.posX, this.posY, this.posZ, 5.0F);
           if (!MinecraftForge.EVENT_BUS.post((Event)event)) {

             if (getThrower().isRiding())
             {
               getThrower().mountEntity((Entity)null);
             }

             getThrower().setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
             (getThrower()).fallDistance = 0.0F;
           }
         }
       }
       setDead();
     }
   }
 }