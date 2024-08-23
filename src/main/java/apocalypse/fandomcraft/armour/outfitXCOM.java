 package apocalypse.fandomcraft.armour;

 import apocalypse.fandomcraft.main.Main;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.ItemArmor;
 import net.minecraft.item.ItemStack;
 import net.minecraft.potion.Potion;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.world.World;

 public class outfitXCOM
   extends ItemArmor
 {
   private String[] armourTypes = new String[] { "xcomHat", "xcomChest", "xcomLegs", "xcomBoots" };

   public outfitXCOM(ItemArmor.ArmorMaterial material, int renderIndex, int placement) {
     super(material, renderIndex, placement);
     setCreativeTab(Main.tabFandomCraftOutfits);

     if (placement == 0) {

       setTextureName("fandomcraft:xcomHat");
     }
     else if (placement == 1) {

       setTextureName("fandomcraft:xcomChest");
     }
     else if (placement == 2) {

       setTextureName("fandomcraft:xcomLegs");
     }
     else if (placement == 3) {

       setTextureName("fandomcraft:xcomBoots");
     }
   }
   int t;

   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
     if (stack.getItem().equals(Main.xcomHat) || stack.getItem().equals(Main.xcomChest) || stack.getItem().equals(Main.xcomBoots))
     {
       return "fandomcraft:textures/models/armor/cyber_1.png";
     }
     if (stack.getItem().equals(Main.xcomLegs))
     {
       return "fandomcraft:textures/models/armor/cyber_2.png";
     }

     return null;
   }

   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
     if (player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(0) != null) {

       ItemStack hat = player.getCurrentArmor(3);
       ItemStack chest = player.getCurrentArmor(2);
       ItemStack legs = player.getCurrentArmor(1);
       ItemStack boots = player.getCurrentArmor(0);

       if (hat.getItem() == Main.xcomHat && chest.getItem() == Main.xcomChest && legs.getItem() == Main.xcomLegs && boots.getItem() == Main.xcomBoots)
       {

         if (player.inventory.hasItem(Main.ring)) {

           player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 1, 1));
           player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 1, 1));

           if (this.t == 60)
           {
             player.inventory.consumeInventoryItem(Main.energyCrystal);
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
           player.removePotionEffect(1);
           player.removePotionEffect(3);
         }
       }
     }
   }
 }