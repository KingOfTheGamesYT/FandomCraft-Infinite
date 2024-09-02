package com.devmaster1015.fandomcraft.main;

import net.minecraft.util.ResourceLocation;

import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = FandomCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {


    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().registerAll(
                new AddChestLootModifier.Serializer().setRegistryName
                        (new ResourceLocation(FandomCraft.MOD_ID,"mineshaft_custom_loot")),
        new AddChestLootModifier.Serializer().setRegistryName
                (new ResourceLocation(FandomCraft.MOD_ID,"bonus_chest_loot")),
        new AddChestLootModifier.Serializer().setRegistryName
                (new ResourceLocation(FandomCraft.MOD_ID,"dungeon_loot")),
        new AddChestLootModifier.Serializer().setRegistryName
                (new ResourceLocation(FandomCraft.MOD_ID,"village_weaponsmith_loot"))
        );
    }
}