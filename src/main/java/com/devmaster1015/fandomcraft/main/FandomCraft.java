package com.devmaster1015.fandomcraft.main;

import com.devmaster1015.fandomcraft.client.render.RenderDekuNut;
import com.devmaster1015.fandomcraft.client.render.RenderEnergyBall;
import com.devmaster1015.fandomcraft.client.render.RenderWoodenSlingshotAmmo;
import com.devmaster1015.fandomcraft.main.events.LootTableModifier;
import com.devmaster1015.fandomcraft.client.render.RenderBullet;
import com.devmaster1015.fandomcraft.main.events.MobDrops;
import com.devmaster1015.fandomcraft.main.events.PickupEvent;
import com.devmaster1015.fandomcraft.util.RegistryHandler;
import com.devmaster1015.fandomcraft.main.events.VillagerTradeHandler;
import com.devmaster1015.fandomcraft.world.FCOreGen;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("fandomcraft")
public class FandomCraft {
    public static final Logger LOGGER = LogManager.getLogger("FandomCraft");
    public static final String MOD_ID = "fandomcraft";
    public static final ITag.INamedTag<Item> RUPEES = ItemTags.makeWrapperTag(FandomCraft.MOD_ID+":rupees");

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
        MinecraftForge.EVENT_BUS.register(PickupEvent.class);
        MinecraftForge.EVENT_BUS.register(MobDrops.class);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.BULLET_ENTITY.get(), RenderBullet::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.ENERGY_BALL_ENTITY.get(), RenderEnergyBall::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.WOOD_SLINGSHOT_AMMO.get(), RenderWoodenSlingshotAmmo::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.DEKUNUT_ENTITY.get(), RenderDekuNut::new);
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
            return new ItemStack(RegistryHandler.ELVEN_STEEL_INGOT.get());
        }
    };

    public static final ItemGroup tabFandomCraftMisc = new ItemGroup("tabFandomCraftMisc") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.RUPEE_GREEN.get());
        }
    };
    public static final ItemGroup tabFandomCraftfood = new ItemGroup("tabFandomCraftFood") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.RED_VINE.get());
        }
    };

    public static final ItemGroup tabFandomCraftOutfits = new ItemGroup("tabFandomCraftOutfits") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.MAGIC_ARMOR.get());
        }
    };

    @OnlyIn(Dist.CLIENT)
    public static void dev(Object obj)
    {
        LOGGER.debug(obj);
    }
}