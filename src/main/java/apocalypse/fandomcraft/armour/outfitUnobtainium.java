 package apocalypse.fandomcraft.armour;

 import apocalypse.fandomcraft.main.Main;
 import net.minecraft.entity.Entity;
 import net.minecraft.item.ItemArmor;
 import net.minecraft.item.ItemStack;

 public class outfitUnobtainium
   extends ItemArmor
 {
   private String[] armourTypes = new String[] { "UnobtainiumHat", "UnobtainiumChest", "UnobtainiumLegs", "UnobtainiumBoots" };

   public outfitUnobtainium(ItemArmor.ArmorMaterial material, int renderIndex, int placement) {
     super(material, renderIndex, placement);
     setCreativeTab(Main.tabFandomCraftOutfits);
     this.canRepair = true;

     if (placement == 0) {

       setTextureName("fandomcraft:UnobtainiumHat");
     }
     else if (placement == 1) {

       setTextureName("fandomcraft:UnobtainiumChest");
     }
     else if (placement == 2) {

       setTextureName("fandomcraft:UnobtainiumLegs");
     }
     else if (placement == 3) {

       setTextureName("fandomcraft:UnobtainiumBoots");
     }
   }

   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
     if (stack.getItem().equals(Main.UnobtainiumHat) || stack.getItem().equals(Main.UnobtainiumChest) || stack.getItem().equals(Main.UnobtainiumBoots))
     {
       return "fandomcraft:textures/models/armor/unobtainium_1.png";
     }
     if (stack.getItem().equals(Main.UnobtainiumLegs))
     {
       return "fandomcraft:textures/models/armor/unobtainium_2.png";
     }

     return null;
   }
 }