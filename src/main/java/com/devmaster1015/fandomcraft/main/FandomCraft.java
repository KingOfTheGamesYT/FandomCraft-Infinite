package com.devmaster1015.fandomcraft.main;

import com.devmaster1015.fandomcraft.client.render.*;
import com.devmaster1015.fandomcraft.entities.EntityGoomba;
import com.devmaster1015.fandomcraft.entities.EntityKoopa;
import com.devmaster1015.fandomcraft.main.events.*;
import com.devmaster1015.fandomcraft.util.BaseConfig;
import com.devmaster1015.fandomcraft.util.RegistryHandler;
import com.devmaster1015.fandomcraft.world.EntitySpawns;
import com.devmaster1015.fandomcraft.world.FCOreGen;

import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
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
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("fandomcraft")
public class FandomCraft {
    public static final Logger LOGGER = LogManager.getLogger("FandomCraft");
    public static final String MOD_ID = "fandomcraft";
    public static final ITag.INamedTag<Item> RUPEES = ItemTags.makeWrapperTag(FandomCraft.MOD_ID+":rupees");

    public FandomCraft() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BaseConfig.COMMON, "fandomcraft-common.toml");
        BaseConfig.loadConfig(BaseConfig.COMMON, FMLPaths.CONFIGDIR.get().resolve("fandomcraft-common.toml").toString());
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
        MinecraftForge.EVENT_BUS.register(ModEventBusEvents.class);
        MinecraftForge.EVENT_BUS.addListener(EntitySpawns::onBiomeLoad);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(RegistryHandler.GOOMBA.get(), EntityGoomba.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.KOOPA.get(), EntityKoopa.setCustomAttributes().create());

        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.BULLET_ENTITY.get(), RenderBullet::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.ENERGY_BALL_ENTITY.get(), RenderEnergyBall::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.WOOD_SLINGSHOT_AMMO.get(), RenderWoodenSlingshotAmmo::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.DEKUNUT_ENTITY.get(), RenderDekuNut::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.GOOMBA.get(), RenderGoomba::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.KOOPA.get(), RenderKoopa::new);

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