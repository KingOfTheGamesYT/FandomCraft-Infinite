package com.devmaster1015.fandomcraft.main;

import com.devmaster1015.fandomcraft.blocks.LootTableModifier;
import com.devmaster1015.fandomcraft.world.FCOreGen;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

@Mod("fandomcraft")
public class FandomCraft{
        public static final Logger LOGGER = LogManager.getLogger("FandomCraft");
        public static final String MOD_ID = "fandomcraft";

        public FandomCraft() {

            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

            final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
            modEventBus.addListener(this::setup);

            RegistryHandler.init();

            MinecraftForge.EVENT_BUS.register(this);

            MinecraftForge.EVENT_BUS.addListener(FCOreGen::handleWorldGen);
            MinecraftForge.EVENT_BUS.register(VillagerTradeHandler.class);
            MinecraftForge.EVENT_BUS.register(LootTableModifier.class);
        }

        private void setup(final FMLCommonSetupEvent event) {
            DeferredWorkQueue.runLater(() -> {
                });
        }
        private void doClientStuff(final FMLClientSetupEvent event) {
        }

        public static final ItemGroup tabFandomCraftBlocks = new ItemGroup("tabFandomCraftBlocks") {

            @Override
            public ItemStack createIcon() {
                return new ItemStack(RegistryHandler.ROCK_STONE_BLOCK.get());
            }
        };

        public static final ItemGroup tabFandomCraftMaterials = new ItemGroup("tabFandomCraftMaterials") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.RUPEE_GREEN.get());
        }
    };
    }

