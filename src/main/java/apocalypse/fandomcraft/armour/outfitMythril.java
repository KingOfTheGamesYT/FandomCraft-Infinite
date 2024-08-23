 package apocalypse.fandomcraft.armour;

 import apocalypse.fandomcraft.main.Main;
 import net.minecraft.entity.Entity;
 import net.minecraft.item.ItemArmor;
 import net.minecraft.item.ItemStack;

 public class outfitMythril
   extends ItemArmor
 {
   private String[] armourTypes = new String[] { "MythrilHat", "MythrilChest", "MythrilLegs", "MythrilBoots" };

   public outfitMythril(ItemArmor.ArmorMaterial material, int renderIndex, int placement) {
     super(material, renderIndex, placement);
     setCreativeTab(Main.tabFandomCraftOutfits);

     if (placement == 0) {

       setTextureName("fandomcraft:MythrilHat");
     }
     else if (placement == 1) {

       setTextureName("fandomcraft:MythrilChest");
     }
     else if (placement == 2) {

       setTextureName("fandomcraft:MythrilLegs");
     }
     else if (placement == 3) {
       setTextureName("fandomcraft:MythrilBoots");
     }
   }

   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
     if (stack.getItem().equals(Main.MythrilHat) || stack.getItem().equals(Main.MythrilChest) || stack.getItem().equals(Main.MythrilBoots))
     {
       return "fandomcraft:textures/models/armor/mythril_1.png";
     }
     if (stack.getItem().equals(Main.MythrilLegs))
     {
       return "fandomcraft:textures/models/armor/mythril_2.png";
     }

     return null;
   }
 }