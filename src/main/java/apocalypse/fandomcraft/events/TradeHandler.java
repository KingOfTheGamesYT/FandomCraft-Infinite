 package apocalypse.fandomcraft.events;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.VillagerRegistry;
 import java.util.Random;
 import net.minecraft.entity.passive.EntityVillager;
 import net.minecraft.init.Blocks;
 import net.minecraft.init.Items;
 import net.minecraft.item.ItemStack;
 import net.minecraft.village.MerchantRecipe;
 import net.minecraft.village.MerchantRecipeList;

 public class TradeHandler
   implements VillagerRegistry.IVillageTradeHandler
 {
   public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
     switch (villager.getProfession()) {

       case 0:
         recipeList.add(new MerchantRecipe(new ItemStack(Main.rupeeBlue, 1), new ItemStack(Main.peanut, 2)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.rupeeYellow, 1), new ItemStack(Main.dampMulch, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.rupeeRed, 1), new ItemStack(Main.stableMulch, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.rupeePurple, 1), new ItemStack(Main.growthMulch, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.rupeeSilver, 10), new ItemStack(Main.appraisalKit, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.bonusCoin, 32), new ItemStack(Main.superShroom, 1)));

         recipeList.add(new MerchantRecipe(new ItemStack(Items.wheat, 9), new ItemStack(Main.rupeeGreen, 2)));
         recipeList.add(new MerchantRecipe(new ItemStack(Items.carrot, 7), new ItemStack(Main.rupeeGreen, 2)));
         recipeList.add(new MerchantRecipe(new ItemStack(Items.baked_potato, 5), new ItemStack(Main.rupeeBlue, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Items.gunpowder, 3), new ItemStack(Main.rupeeBlue, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Items.blaze_powder, 7), new ItemStack(Main.rupeeYellow, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Items.feather, 9), new ItemStack(Main.rupeeGreen, 3)));
         recipeList.add(new MerchantRecipe(new ItemStack(Items.leather, 5), new ItemStack(Main.rupeeBlue, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Items.egg, 16), new ItemStack(Main.rupeeBlue, 3)));
         recipeList.add(new MerchantRecipe(new ItemStack(Items.nether_star, 1), new ItemStack(Main.rupeeSilver, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Items.skull, 1, 1), new ItemStack(Main.rupeeRed, 2)));
         recipeList.add(new MerchantRecipe(new ItemStack(Items.bone, 5), new ItemStack(Main.rupeeGreen, 2)));
         recipeList.add(new MerchantRecipe(new ItemStack(Items.rotten_flesh, 8), new ItemStack(Main.rupeeGreen, 2)));
         recipeList.add(new MerchantRecipe(new ItemStack(Items.diamond, 1), new ItemStack(Main.rupeePurple, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.goldenFeather, 1), new ItemStack(Main.rupeeYellow, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.chocolate, 3), new ItemStack(Items.emerald)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.cider), new ItemStack(Items.emerald)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.beer, 2), new ItemStack(Items.emerald)));
         recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald), new ItemStack(Main.cider)));
         break;

       case 2:
         recipeList.add(new MerchantRecipe(new ItemStack(Items.golden_sword, 1), new ItemStack(Main.dreamSword, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.dreamSword, 1), new ItemStack(Main.darkHeart, 64), new ItemStack(Main.keyKingdom, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.rupeeSilver, 16), new ItemStack(Main.fourSword, 1), new ItemStack(Main.fourSword_2, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.darkHeart, 1), new ItemStack(Main.rupeeGreen, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.soul, 1), new ItemStack(Main.rupeeGreen, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.ring, 1), new ItemStack(Main.rupeeGreen, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.coin, 1), new ItemStack(Main.rupeeGreen, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Blocks.dragon_egg, 1), new ItemStack(Main.orichulumPlus, 1)));
         break;

       case 3:
         recipeList.add(new MerchantRecipe(new ItemStack(Main.energyCrystal, 64), new ItemStack(Main.lightsaber_red, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.energyCrystal, 64), new ItemStack(Main.lightsaber_blue, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.energyCrystal, 64), new ItemStack(Main.lightsaber_green, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.energyCrystal, 64), new ItemStack(Main.lightsaber_purple, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.rupeeSilver, 38), new ItemStack(Main.chaosSword, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.rupeeSilver, 64), new ItemStack(Main.kikuichimonji, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.rupeeSilver, 32), new ItemStack(Main.icebrand, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.rupeeSilver, 32), new ItemStack(Main.flametounge, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.rupeeSilver, 32), new ItemStack(Main.tenshiBlade, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.rupeeSilver, 48), new ItemStack(Main.DesfangSword, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.rupeeSilver, 32), new ItemStack(Main.quincy, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.bonusCoin, 64), new ItemStack(Main.starHammer, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Items.snowball, 64), new ItemStack(Main.rupeeSilver, 16), new ItemStack(Main.iceRod, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.jet, 3), new ItemStack(Items.emerald)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.ruby, 6), new ItemStack(Items.emerald)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.amethyst, 5), new ItemStack(Items.emerald)));
         break;

       case 4:
         recipeList.add(new MerchantRecipe(new ItemStack(Main.grapplingHook, 1), new ItemStack(Main.rupeeSilver, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.ocarina, 1), new ItemStack(Main.rupeeSilver, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.fourSword, 1), new ItemStack(Main.rupeeOrange, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.practiceSword, 1), new ItemStack(Main.rupeePurple, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.fairySlingshot, 1), new ItemStack(Main.rupeeOrange, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.bomb, 1), new ItemStack(Main.rupeeYellow, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.dekuNut, 1), new ItemStack(Main.rupeeBlue, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.skullNecklace, 1), new ItemStack(Main.rupeeRed, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.knightsCrest, 1), new ItemStack(Main.rupeePurple, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.mysteryDust, 1), new ItemStack(Main.rupeeGreen, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.energyTank, 1), new ItemStack(Main.rupeeBlue, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.song1, 1), new ItemStack(Main.rupeePurple, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.song2, 1), new ItemStack(Main.rupeePurple, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.song3, 1), new ItemStack(Main.rupeePurple, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.song4, 1), new ItemStack(Main.rupeePurple, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.song5, 1), new ItemStack(Main.rupeePurple, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.song6, 1), new ItemStack(Main.rupeePurple, 1)));
         recipeList.add(new MerchantRecipe(new ItemStack(Main.song7, 1), new ItemStack(Main.rupeePurple, 1)));
         break;
     }
   }
 }