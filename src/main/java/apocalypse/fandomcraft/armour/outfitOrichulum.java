 package apocalypse.fandomcraft.armour;

 import apocalypse.fandomcraft.main.Main;
 import net.minecraft.entity.Entity;
 import net.minecraft.item.ItemArmor;
 import net.minecraft.item.ItemStack;

 public class outfitOrichulum
   extends ItemArmor
 {
   private String[] armourTypes = new String[] { "OrichulumHat", "OrichulumChest", "OrichulumLegs", "OrichulumBoots" };

   public outfitOrichulum(ItemArmor.ArmorMaterial material, int renderIndex, int placement) {
     super(material, renderIndex, placement);
     setCreativeTab(Main.tabFandomCraftOutfits);
     this.canRepair = true;

     if (placement == 0) {

       setTextureName("fandomcraft:OrichulumHat");
     }
     else if (placement == 1) {

       setTextureName("fandomcraft:OrichulumChest");
     }
     else if (placement == 2) {

       setTextureName("fandomcraft:OrichulumLegs");
     }
     else if (placement == 3) {

       setTextureName("fandomcraft:OrichulumBoots");
     }
   }

   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
     if (stack.getItem().equals(Main.OrichulumHat) || stack.getItem().equals(Main.OrichulumChest) || stack.getItem().equals(Main.OrichulumBoots))
     {
       return "fandomcraft:textures/models/armor/orichulum_1.png";
     }
     if (stack.getItem().equals(Main.OrichulumLegs))
     {
       return "fandomcraft:textures/models/armor/orichulum_2.png";
     }

     return null;
   }
 }