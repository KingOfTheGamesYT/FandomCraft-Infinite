 package apocalypse.fandomcraft.armour;

 import apocalypse.fandomcraft.main.Main;
 import net.minecraft.entity.Entity;
 import net.minecraft.item.ItemArmor;
 import net.minecraft.item.ItemStack;

 public class outfitEridium
   extends ItemArmor
 {
   private String[] armourTypes = new String[] { "EridiumHat", "EridiumChest", "EridiumLegs", "EridiumBoots" };

   public outfitEridium(ItemArmor.ArmorMaterial material, int renderIndex, int placement) {
     super(material, renderIndex, placement);
     setCreativeTab(Main.tabFandomCraftOutfits);
     this.canRepair = true;

     if (placement == 0) {

       setTextureName("fandomcraft:EridiumHat");
     }
     else if (placement == 1) {

       setTextureName("fandomcraft:EridiumChest");
     }
     else if (placement == 2) {

       setTextureName("fandomcraft:EridiumLegs");
     }
     else if (placement == 3) {

       setTextureName("fandomcraft:EridiumBoots");
     }
   }

   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
     if (stack.getItem().equals(Main.EridiumHat) || stack.getItem().equals(Main.EridiumChest) || stack.getItem().equals(Main.EridiumBoots))
     {
       return "fandomcraft:textures/models/armor/Eridium_1.png";
     }
     if (stack.getItem().equals(Main.EridiumLegs))
     {
       return "fandomcraft:textures/models/armor/Eridium_2.png";
     }

     return null;
   }
 }