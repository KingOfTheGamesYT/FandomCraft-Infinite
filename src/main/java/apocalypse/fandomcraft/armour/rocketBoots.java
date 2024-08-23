 package apocalypse.fandomcraft.armour;

 import apocalypse.fandomcraft.main.Main;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.ItemArmor;
 import net.minecraft.item.ItemStack;
 import net.minecraft.potion.Potion;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.world.World;

 public class rocketBoots
   extends ItemArmor
 {
   private String[] armourTypes = new String[] { "placeholder6", "placeholder7", "placeholder8", "rocketBoots" };

   public rocketBoots(ItemArmor.ArmorMaterial material, int renderIndex, int placement) {
     super(material, renderIndex, placement);
     this.canRepair = true;

     if (placement == 0) {

       setTextureName("fandomcraft:placeholder");
     }
     else if (placement == 1) {

       setTextureName("fandomcraft:sprintShoes");
     }
     else if (placement == 2) {

       setTextureName("fandomcraft:placeholder");
     }
     else if (placement == 3) {

       setTextureName("fandomcraft:rocketBoots");
     }
   }

   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
     if (stack.getItem().equals(Main.rocketBoots))
     {
       return "fandomcraft:textures/models/armor/rocketBoots_2.png";
     }

     return null;
   }

   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
     if (player.getCurrentArmor(0) != null) {

       ItemStack cloak = player.getCurrentArmor(0);

       if (cloak.getItem() == Main.rocketBoots) {

         player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 1, 5, true));

       }
       else {

         player.removePotionEffect(8);
       }
     }
   }
 }