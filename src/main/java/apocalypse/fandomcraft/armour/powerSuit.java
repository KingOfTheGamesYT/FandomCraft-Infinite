 package apocalypse.fandomcraft.armour;

 import apocalypse.fandomcraft.main.Main;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.ItemArmor;
 import net.minecraft.item.ItemStack;
 import net.minecraft.potion.Potion;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.world.World;

 public class powerSuit
   extends ItemArmor
 {
   int ticks;

   public powerSuit(ItemArmor.ArmorMaterial material, int renderIndex, int placement) {
     super(material, renderIndex, placement);
     isRepairable();
   }

   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
     if (stack.getItem() == Main.powerHelmet || stack.getItem() == Main.powerPlate)
     {
       return "fandomcraft:textures/models/armor/powerSuit_1.png";
     }
     if (stack.getItem() == Main.powerSuit || stack.getItem() == Main.powerBoots)
     {
       return "fandomcraft:textures/models/armor/powerSuit_2.png";
     }

     return null;
   }

   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
     if (player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(0) != null) {

       ItemStack crown = player.getCurrentArmor(3);
       ItemStack armour = player.getCurrentArmor(2);
       ItemStack mail = player.getCurrentArmor(1);
       ItemStack boots = player.getCurrentArmor(0);

       if (crown.getItem() == Main.powerHelmet && armour.getItem() == Main.powerPlate && mail.getItem() == Main.powerSuit && boots.getItem() == Main.powerBoots)
       {
         if (player.inventory.hasItem(Main.energyTank)) {

           player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 2, 5, true));
           player.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 1, 5, true));
           player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 2, 5, true));
           player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 1, 5, true));

           if (this.ticks == 240)
           {

             this.ticks = 0;
           }
           else
           {
             this.ticks++;
           }

         } else {

           player.stopUsingItem();
           player.setInWeb();
         }
       }
     }
   }
 }