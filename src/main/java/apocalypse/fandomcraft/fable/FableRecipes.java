 package apocalypse.fandomcraft.fable;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.GameRegistry;
 import net.minecraft.init.Items;
 import net.minecraft.item.ItemStack;

 public class FableRecipes
 {
   public static void init() {
     GameRegistry.addShapedRecipe(new ItemStack(Main.cleaver), new Object[] { "AB ", "AB ", " B ", Character.valueOf('A'), Items.iron_ingot, Character.valueOf('B'), Items.stick });
     GameRegistry.addShapedRecipe(new ItemStack(Main.cutlass), new Object[] { " A ", " A ", "AB ", Character.valueOf('A'), Items.iron_ingot, Character.valueOf('B'), Items.stick });
     GameRegistry.addShapedRecipe(new ItemStack(Main.fryingPan), new Object[] { "AA ", "AA ", "  A", Character.valueOf('A'), Items.iron_ingot, Character.valueOf('B'), Items.stick });
     GameRegistry.addShapedRecipe(new ItemStack(Main.scmitar), new Object[] { "A  ", "AA ", " B ", Character.valueOf('A'), Items.iron_ingot, Character.valueOf('B'), Main.jet });
     GameRegistry.addShapedRecipe(new ItemStack(Main.katana), new Object[] { " A ", " A ", " B ", Character.valueOf('A'), Items.iron_ingot, Character.valueOf('B'), Main.jet });
     GameRegistry.addShapedRecipe(new ItemStack(Main.mace), new Object[] { "A  ", " B ", "  C", Character.valueOf('A'), Main.jet, Character.valueOf('B'), Items.stick, Character.valueOf('C'), Items.iron_ingot });
   }
 }