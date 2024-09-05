package com.devmaster1015.fandomcraft.main.events;

import com.devmaster1015.fandomcraft.util.RegistryHandler;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;

import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class VillagerTradeHandler {

    @SubscribeEvent
    public static void onVillagerTradesEvent(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();

            //Novice
            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(RegistryHandler.RUPEE_SILVER.get(), 10),
                    new ItemStack(RegistryHandler.APPRAISAL_KIT_BASIC.get(), 1),
                    12, 2, 0.05F
            ));

            // Add the Wheat for Rupees trade
            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.WHEAT, 9),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.CARROT, 7),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BAKED_POTATO, 5),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.GUNPOWDER, 3),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BLAZE_POWDER, 7),
                    new ItemStack(RegistryHandler.RUPEE_YELLOW.get(), 1),
                    12, 2, 0.05F
            ));

            // Add the Feather for Rupees trade
            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.FEATHER, 9),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 3),
                    16, 1, 0.05F
            ));
            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.LEATHER, 5),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EGG, 16),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 3),
                    16, 1, 0.05F
            ));
            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.NETHER_STAR, 1),
                    new ItemStack(RegistryHandler.RUPEE_SILVER.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BONE, 5),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.WITHER_SKELETON_SKULL, 1),
                    new ItemStack(RegistryHandler.RUPEE_RED.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.ROTTEN_FLESH, 8),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND, 1),
                    new ItemStack(RegistryHandler.RUPEE_YELLOW.get(), 2),
                    16, 1, 0.05F
            ));

            //Apprentice
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(RegistryHandler.RUPEE_SILVER.get(), 10),
                    new ItemStack(RegistryHandler.APPRAISAL_KIT_BASIC.get(), 1),
                    12, 2, 0.05F
            ));

            // Add the Wheat for Rupees trade
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.WHEAT, 9),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.CARROT, 7),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BAKED_POTATO, 5),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.GUNPOWDER, 3),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BLAZE_POWDER, 7),
                    new ItemStack(RegistryHandler.RUPEE_YELLOW.get(), 1),
                    12, 2, 0.05F
            ));

            // Add the Feather for Rupees trade
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.FEATHER, 9),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 3),
                    16, 1, 0.05F
            ));
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.LEATHER, 5),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EGG, 16),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 3),
                    16, 1, 0.05F
            ));
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.NETHER_STAR, 1),
                    new ItemStack(RegistryHandler.RUPEE_SILVER.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BONE, 5),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.WITHER_SKELETON_SKULL, 1),
                    new ItemStack(RegistryHandler.RUPEE_RED.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.ROTTEN_FLESH, 8),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND, 1),
                    new ItemStack(RegistryHandler.RUPEE_YELLOW.get(), 2),
                    16, 1, 0.05F
            ));

            //Journeyman
            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(RegistryHandler.RUPEE_SILVER.get(), 10),
                    new ItemStack(RegistryHandler.APPRAISAL_KIT_BASIC.get(), 1),
                    12, 2, 0.05F
            ));

            // Add the Wheat for Rupees trade
            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.WHEAT, 9),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.CARROT, 7),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BAKED_POTATO, 5),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.GUNPOWDER, 3),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BLAZE_POWDER, 7),
                    new ItemStack(RegistryHandler.RUPEE_YELLOW.get(), 1),
                    12, 2, 0.05F
            ));

            // Add the Feather for Rupees trade
            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.FEATHER, 9),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 3),
                    16, 1, 0.05F
            ));
            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.LEATHER, 5),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EGG, 16),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 3),
                    16, 1, 0.05F
            ));
            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.NETHER_STAR, 1),
                    new ItemStack(RegistryHandler.RUPEE_SILVER.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BONE, 5),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.WITHER_SKELETON_SKULL, 1),
                    new ItemStack(RegistryHandler.RUPEE_RED.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.ROTTEN_FLESH, 8),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND, 1),
                    new ItemStack(RegistryHandler.RUPEE_YELLOW.get(), 2),
                    16, 1, 0.05F
            ));

            //Expert
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(RegistryHandler.RUPEE_SILVER.get(), 10),
                    new ItemStack(RegistryHandler.APPRAISAL_KIT_BASIC.get(), 1),
                    12, 2, 0.05F
            ));

            // Add the Wheat for Rupees trade
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.WHEAT, 9),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.CARROT, 7),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BAKED_POTATO, 5),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.GUNPOWDER, 3),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BLAZE_POWDER, 7),
                    new ItemStack(RegistryHandler.RUPEE_YELLOW.get(), 1),
                    12, 2, 0.05F
            ));

            // Add the Feather for Rupees trade
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.FEATHER, 9),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 3),
                    16, 1, 0.05F
            ));
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.LEATHER, 5),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EGG, 16),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 3),
                    16, 1, 0.05F
            ));
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.NETHER_STAR, 1),
                    new ItemStack(RegistryHandler.RUPEE_SILVER.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BONE, 5),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.WITHER_SKELETON_SKULL, 1),
                    new ItemStack(RegistryHandler.RUPEE_RED.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.ROTTEN_FLESH, 8),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND, 1),
                    new ItemStack(RegistryHandler.RUPEE_YELLOW.get(), 2),
                    16, 1, 0.05F
            ));

            //Master
            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(RegistryHandler.RUPEE_SILVER.get(), 10),
                    new ItemStack(RegistryHandler.APPRAISAL_KIT_BASIC.get(), 1),
                    12, 2, 0.05F
            ));

            // Add the Wheat for Rupees trade
            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.WHEAT, 9),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.CARROT, 7),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BAKED_POTATO, 5),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.GUNPOWDER, 3),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BLAZE_POWDER, 7),
                    new ItemStack(RegistryHandler.RUPEE_YELLOW.get(), 1),
                    12, 2, 0.05F
            ));

            // Add the Feather for Rupees trade
            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.FEATHER, 9),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 3),
                    16, 1, 0.05F
            ));
            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.LEATHER, 5),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EGG, 16),
                    new ItemStack(RegistryHandler.RUPEE_BLUE.get(), 3),
                    16, 1, 0.05F
            ));
            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.NETHER_STAR, 1),
                    new ItemStack(RegistryHandler.RUPEE_SILVER.get(), 1),
                    16, 1, 0.05F
            ));
            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BONE, 5),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.WITHER_SKELETON_SKULL, 1),
                    new ItemStack(RegistryHandler.RUPEE_RED.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.ROTTEN_FLESH, 8),
                    new ItemStack(RegistryHandler.RUPEE_GREEN.get(), 2),
                    16, 1, 0.05F
            ));
            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND, 1),
                    new ItemStack(RegistryHandler.RUPEE_YELLOW.get(), 2),
                    16, 1, 0.05F
            ));
        }
    }
}