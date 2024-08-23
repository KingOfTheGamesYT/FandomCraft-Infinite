 package apocalypse.fandomcraft.events;

 import java.util.Iterator;
 import java.util.List;
 import net.minecraft.item.ItemStack;
 import net.minecraft.item.crafting.CraftingManager;
 import net.minecraft.item.crafting.IRecipe;

 public class AntiRecipe
 {
   public static void removeRecipe() {
     List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

     Iterator<IRecipe> remover = recipes.iterator();

     while (remover.hasNext())
     {
       ItemStack itemStack = ((IRecipe)remover.next()).getRecipeOutput();
     }
   }
 }