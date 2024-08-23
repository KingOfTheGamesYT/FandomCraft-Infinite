 package apocalypse.fandomcraft.armour;

 import apocalypse.fandomcraft.main.Main;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.ItemArmor;
 import net.minecraft.item.ItemStack;
 import net.minecraft.potion.Potion;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.world.World;

 public class sprintShoes
   extends ItemArmor
 {
   private String[] armourTypes = new String[] { "placeholder9", "placeholder10", "placeholder11", "sprintShoes" };

   public sprintShoes(ItemArmor.ArmorMaterial material, int renderIndex, int placement) {
     super(material, renderIndex, placement);
     this.canRepair = true;

     if (placement == 0) {

       setTextureName("fandomcraft:placeholder");
     }
     else if (placement == 1) {

       setTextureName("fandomcraft:placeholder");
     }
     else if (placement == 2) {

       setTextureName("fandomcraft:placeholder");
     }
     else if (placement == 3) {

       setTextureName("fandomcraft:sprintShoes");
     }
   }

   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
     if (stack.getItem().equals(Main.sonicSneakers))
     {
       return "fandomcraft:textures/models/armor/sonicSneakers_2.png";
     }

     return null;
   }

   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
     if (player.getCurrentArmor(0) != null) {

       ItemStack shoes = player.getCurrentArmor(0);

       if (shoes.getItem() == Main.sonicSneakers) {

         player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 1, 3, true));

       }
       else {

         player.removePotionEffect(1);
       }
     }
   }
 }