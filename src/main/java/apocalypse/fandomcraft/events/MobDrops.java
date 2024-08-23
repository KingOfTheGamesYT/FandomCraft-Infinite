 package apocalypse.fandomcraft.events;

 import apocalypse.fandomcraft.main.FandomAchievementList;
 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 import java.util.Random;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.stats.StatBase;
 import net.minecraft.util.EntityDamageSource;
 import net.minecraftforge.event.entity.living.LivingDeathEvent;

 public class MobDrops
 {
   public static Random random;
   public static int dropped;

   @SubscribeEvent
   public void onDeath(LivingDeathEvent event) {
     random = new Random();
     dropped = random.nextInt(2) + 1;

     if (!(event.source instanceof EntityDamageSource)) {
       return;
     }

     EntityDamageSource damageSource = (EntityDamageSource)event.source;

     Entity entity = damageSource.getSourceOfDamage();
     if (!(entity instanceof EntityPlayer)) {
       return;
     }

     EntityPlayer player = (EntityPlayer)entity;

     if (event.entityLiving instanceof apocalypse.fandomcraft.entity.EntityBombskit)
     {
       player.triggerAchievement((StatBase)FandomAchievementList.bombskit);
     }
     if (event.entityLiving instanceof apocalypse.fandomcraft.entity.EntityArgorok)
     {
       player.triggerAchievement((StatBase)FandomAchievementList.dragon2);
     }

     ItemStack stack = player.getCurrentEquippedItem();
     Item item = player.inventory.getCurrentItem().getItem();

     if (player.inventory.getCurrentItem() != null) {

       if (item == Main.keyKingdom || item == Main.keyKingdomD || item == Main.jungleKing || item == Main.oblivion || item == Main.ultima || item == Main.oneWingedAngel || item == Main.destinyEmbrace || item == Main.oathkeeper || item == Main.photonDebugger || item == Main.metalChocobo || item == Main.dreamSword) {

         if (event.entityLiving instanceof net.minecraft.entity.monster.EntityZombie)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.darkHeart), dropped);
         }
         if (event.entityLiving instanceof net.minecraft.entity.monster.EntitySkeleton)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.darkHeart), dropped);
         }
         if (event.entityLiving instanceof net.minecraft.entity.monster.EntityPigZombie)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.darkHeart), dropped);
         }
         if (event.entityLiving instanceof net.minecraft.entity.monster.EntityGhast)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.darkHeart), dropped);
         }
         if (event.entityLiving instanceof net.minecraft.entity.monster.EntityWitch)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.darkHeart), dropped);
         }
         if (event.entityLiving instanceof net.minecraft.entity.monster.EntityEnderman)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.darkHeart), dropped);
         }
         if (event.entityLiving instanceof net.minecraft.entity.boss.EntityWither) {

           event.entityLiving.entityDropItem(new ItemStack(Main.crown), dropped);
         } else {
           return;
         }
       }

       if (stack.getItem() == Main.soulEater) {

         if (event.entityLiving instanceof net.minecraft.entity.passive.EntityCow)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.soul), dropped);
         }
         if (event.entityLiving instanceof net.minecraft.entity.passive.EntityPig)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.soul), dropped);
         }
         if (event.entityLiving instanceof net.minecraft.entity.passive.EntitySheep)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.soul), dropped);
         }
         if (event.entityLiving instanceof net.minecraft.entity.monster.EntityCreeper)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.soul), dropped);
         }
         if (event.entityLiving instanceof net.minecraft.entity.monster.EntityCaveSpider)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.soul), dropped);
         }
         if (event.entityLiving instanceof net.minecraft.entity.monster.EntitySpider)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.soul), dropped);
         }
         if (event.entityLiving instanceof net.minecraft.entity.monster.EntityWitch) {

           event.entityLiving.entityDropItem(new ItemStack(Main.ragingSoul), dropped);
         } else {
           return;
         }
       }

       if (stack.getItem() == Main.fourSword)
       {
         if (event.entityLiving instanceof net.minecraft.entity.monster.EntitySlime)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.jellyBlue), dropped);
         }
       }
       if (stack.getItem() == Main.fourSword_2) {

         if (event.entityLiving instanceof net.minecraft.entity.monster.EntitySlime)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.jellyRed), dropped);
         }
         if (event.entityLiving instanceof net.minecraft.entity.passive.EntityChicken)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.goldenFeather), dropped);
         }
       }
       if (stack.getItem() == Main.masterSword)
       {
         if (event.entityLiving instanceof net.minecraft.entity.monster.EntitySlime)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.jellyGreen), dropped);
         }
       }
       if (stack.getItem() == Main.starHammer) {

         if (event.entityLiving instanceof apocalypse.fandomcraft.entity.EntityGoomba)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.coin), dropped);
         }
         if (event.entityLiving instanceof apocalypse.fandomcraft.entity.EntityKoopa)
         {
           event.entityLiving.entityDropItem(new ItemStack(Main.coin), dropped);
         }
       }
       else {

         int c = random.nextInt(3000);
         if (c < 2) {

           event.entityLiving.entityDropItem(new ItemStack(Main.dinsPearl), dropped);
         }
         else {

           event.entityLiving.entityDropItem(new ItemStack(Main.rupeeGreen), dropped);
         }
       }
       if (event.entityLiving instanceof apocalypse.fandomcraft.entity.EntityBeastGannon)
       {

         player.triggerAchievement((StatBase)FandomAchievementList.masterQuest);
       }
     }
   }
 }