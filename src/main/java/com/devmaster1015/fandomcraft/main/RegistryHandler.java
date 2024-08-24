package com.devmaster1015.fandomcraft.main;

import com.devmaster1015.fandomcraft.blocks.*;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;

import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler{
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FandomCraft.MOD_ID);
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FandomCraft.MOD_ID);
        public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, FandomCraft.MOD_ID);

        public static void init() {
            ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
            BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
            ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());

        }

        //Entities

        //Items

        //Spawn Eggs


        //Tools

        //Blocks

        public static final RegistryObject<Block> ADAMANTIUM_ORE_BLOCK = BLOCKS.register("adamantium_ore", () -> new FBlock("Adamantium Ore", AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(20.0F, 5.0F).harvestLevel(6).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> ROCK_STONE_BLOCK = BLOCKS.register("rock", () -> new FBlock("Adamantium Ore", AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 12.0F).harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> GODDESS_ORE_BLOCK = BLOCKS.register("goddessoreblock", () -> new FBlock("Goddess Ore", AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(65,1).harvestTool(ToolType.PICKAXE).harvestLevel(8), 6));

    //Block Items

        public static final RegistryObject<Item> ADAMANTIUM_ORE_BLOCK_ITEM = ITEMS.register("adamantium_ore", () -> new BlockItemBase(ADAMANTIUM_ORE_BLOCK.get()));
        public static final RegistryObject<Item> ROCK_STONE_BLOCK_ITEM = ITEMS.register("rock", () -> new BlockItemBase(ROCK_STONE_BLOCK.get()));
    public static final RegistryObject<Item> GODDESS_ORE_BLOCK_ITEM = ITEMS.register("goddessoreblock", () -> new BlockItemBase(GODDESS_ORE_BLOCK.get()));

        //Dimensions
}