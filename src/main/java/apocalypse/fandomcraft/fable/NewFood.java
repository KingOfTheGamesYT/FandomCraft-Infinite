 package apocalypse.fandomcraft.fable;

 import net.minecraft.item.EnumAction;
 import net.minecraft.item.ItemFood;
 import net.minecraft.item.ItemStack;

 public class NewFood
   extends ItemFood {
   public static boolean canDrink;

   public NewFood(int amount, float saturation, boolean wolfFood, boolean drinkable) {
     super(amount, saturation, wolfFood);
     canDrink = drinkable;
   }

   public EnumAction getItemUseAction(ItemStack p_77661_1_) {
     if (canDrink)
     {
       return EnumAction.drink;
     }

     return EnumAction.eat;
   }
 }