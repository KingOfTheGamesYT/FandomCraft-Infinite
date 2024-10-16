package apocalypse.fandomcraft.terraria;

import apocalypse.fandomcraft.main.Main;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.item.Item;

public class TerraReg {
    public static String modid = "fandomcraft";
    public static Item copper_coin;
    public static Item silver_coin;
    public static Item gold_coin;
    public static Item platinum_coin;

    public TerraReg() {
    }

    public static void register() {
        copper_coin = (new ItemCoin()).setUnlocalizedName("copper_coin").setTextureName(modid + ":" + "copper_coin").setCreativeTab(Main.tabFandomCraftMisc);
        GameRegistry.registerItem(copper_coin, "copper_coin");
        silver_coin = (new ItemCoin()).setUnlocalizedName("silver_coin").setTextureName(modid + ":" + "silver_coin").setCreativeTab(Main.tabFandomCraftMisc);
        GameRegistry.registerItem(silver_coin, "silver_coin");
        gold_coin = (new ItemCoin()).setUnlocalizedName("gold_coin").setTextureName(modid + ":" + "gold_coin").setCreativeTab(Main.tabFandomCraftMisc);
        GameRegistry.registerItem(gold_coin, "gold_coin");
        platinum_coin = (new ItemCoin()).setUnlocalizedName("platinum_coin").setTextureName(modid + ":" + "platinum_coin").setCreativeTab(Main.tabFandomCraftMisc);
        GameRegistry.registerItem(platinum_coin, "platinum_coin");
    }
}
