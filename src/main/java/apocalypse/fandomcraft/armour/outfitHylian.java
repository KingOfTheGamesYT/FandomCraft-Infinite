 package apocalypse.fandomcraft.armour;

 import apocalypse.fandomcraft.main.Main;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.ItemArmor;
 import net.minecraft.item.ItemStack;
 import net.minecraft.potion.Potion;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.world.World;

 public class outfitHylian
   extends ItemArmor
 {
   int t;

   public outfitHylian(ItemArmor.ArmorMaterial material, int renderIndex, int placement) {
     super(material, renderIndex, placement);
     isRepairable();
   }

   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
     if (stack.getItem() == Main.MagicCrown || stack.getItem() == Main.MagicArmour || stack.getItem() == Main.MegatonBoots)
     {
       return "fandomcraft:textures/models/armor/Zelda1_1.png";
     }
     if (stack.getItem() == Main.MagicChainmail)
     {
       return "fandomcraft:textures/models/armor/Zelda1_2.png";
     }

     return null;
   }

   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
     if (player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null) {

       ItemStack crown = player.getCurrentArmor(3);
       ItemStack armour = player.getCurrentArmor(2);
       ItemStack mail = player.getCurrentArmor(1);

       if (crown.getItem() == Main.MagicCrown && armour.getItem() == Main.MagicArmour && mail.getItem() == Main.MagicChainmail)
       {

         if (player.inventory.hasItem(Main.rupeeGreen)) {

           player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 1, 5, true));

           if (this.t == 60)
           {
             player.inventory.consumeInventoryItem(Main.rupeeGreen);
             this.t = 0;
           }
           else
           {
             this.t++;
           }

         }
         else {

           player.stopUsingItem();
           player.setInWeb();
           player.removePotionEffect(11);
         }
       }
     }

     if (player.getCurrentArmor(0) != null) {

       ItemStack boots = player.getCurrentArmor(0);
       if (boots.getItem() == Main.MegatonBoots)
       {
         player.setInWeb();
       }
     }
   }
 }