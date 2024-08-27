package com.devmaster1015.fandomcraft.main;

import com.devmaster1015.fandomcraft.blocks.*;

import com.devmaster1015.fandomcraft.items.AppraisingOre;
import com.devmaster1015.fandomcraft.items.itemtypes.FItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;

import net.minecraft.item.Rarity;
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

        public static final RegistryObject<AppraisingOre> UNKNOWN_MINERAL = ITEMS.register("unknown_mineral", AppraisingOre::new);
        public static final RegistryObject<Item> APPRAISAL_KIT_BASIC = ITEMS.register("appraisal_kit_basic", () -> new FItem("Appraisal Kit Basic", FandomCraft.tabFandomCraftBlocks));
        public static final RegistryObject<Item> APPRAISAL_KIT_ADVANCED = ITEMS.register("appraisal_kit_advanced", () -> new FItem("Appraisal Kit Advanced", FandomCraft.tabFandomCraftBlocks));
        public static final RegistryObject<Item> APPRAISAL_KIT_MASTER = ITEMS.register("appraisal_kit_master", () -> new FItem("Appraisal Kit Master", FandomCraft.tabFandomCraftBlocks));
        public static final RegistryObject<Item> ELVEN_STEEL_INGOT = ITEMS.register("elven_steel_ingot", () -> new FItem("Elven Steel Ingot", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> RUPEE_GREEN = ITEMS.register("rupee_green", () -> new FItem("Green Rupee", FandomCraft.tabFandomCraftMaterials, Rarity.UNCOMMON).addInfo("A gem of 1 value.", "Can be smelted into ingots."));
        public static final RegistryObject<Item> RUPEE_RED = ITEMS.register("rupee_red", () -> new FItem("Red Rupee", FandomCraft.tabFandomCraftMaterials, Rarity.UNCOMMON).addInfo("A gem of 20 value.", "Can be smelted into ingots."));
        public static final RegistryObject<Item> RUPEE_BLUE = ITEMS.register("rupee_blue", () -> new FItem("Blue Rupee", FandomCraft.tabFandomCraftMaterials, Rarity.UNCOMMON).addInfo("A gem of 5 value.", "Can be smelted into ingots."));
        public static final RegistryObject<Item> RUPEE_ORANGE= ITEMS.register("rupee_orange", () -> new FItem("Orange Rupee", FandomCraft.tabFandomCraftMaterials).addInfo("A gem of 10 value."));
        public static final RegistryObject<Item> RUPEE_PURPLE = ITEMS.register("rupee_purple", () -> new FItem("Purple Rupee", FandomCraft.tabFandomCraftMaterials).addInfo("A gem of 50 value."));
        public static final RegistryObject<Item> RUPEE_SILVER = ITEMS.register("rupee_silver", () -> new FItem("Silver Rupee", FandomCraft.tabFandomCraftMaterials).addInfo("A gem of 200 value."));
        public static final RegistryObject<Item> RUPEE_YELLOW = ITEMS.register("rupee_yellow", () -> new FItem("Yellow Rupee", FandomCraft.tabFandomCraftMaterials).addInfo("A gem of 100 value."));
        public static final RegistryObject<Item> DWARVEN_STEEL_INGOT = ITEMS.register("dwarven_steel_ingot", () -> new FItem("Dwarven Steel Ingot", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> HELLSTONE_INGOT = ITEMS.register("hellstone_ingot", () -> new FItem("Hellstone Ingot", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> DARKSTEEL_INGOT = ITEMS.register("darksteel_ingot", () -> new FItem("Darksteel Ingot", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> ENERGY_CRYSTAL = ITEMS.register("energy_crystal", () -> new FItem("Energy Crystal", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> FOOLS_GOLD = ITEMS.register("fools_gold", () -> new FItem("Fools Gold", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> ADAMANTIUM_INGOT = ITEMS.register("adamantium_ingot", () -> new FItem("Adamantium Ingot", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> ERIDIUM_INGOT = ITEMS.register("eridium_ingot", () -> new FItem("Adamantium Ingot", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new FItem("Salt", FandomCraft.tabFandomCraftMaterials));

        //Spawn Eggs


        //Tools

        //Blocks

        public static final RegistryObject<Block> ADAMANTIUM_ORE_BLOCK = BLOCKS.register("adamantium_ore", () -> new FBlock("Adamantium Ore", AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(20.0F, 5.0F).harvestLevel(6).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> ROCK_STONE_BLOCK = BLOCKS.register("rock", () -> new FBlock("Adamantium Ore", AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 12.0F).harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> GODDESS_ORE_BLOCK = BLOCKS.register("goddessoreblock", () -> new FBlock("Goddess Ore", AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(65,1).harvestTool(ToolType.PICKAXE).harvestLevel(8).setRequiresTool(), 6));
        public static final RegistryObject<Block> UNKNOWN_ORE_BLOCK = BLOCKS.register("unknown_ore", unknownOre::new);
        public static final RegistryObject<Block> HELLSTONE_ORE_BLOCK = BLOCKS.register("hellstone_ore", () -> new FBlock("Hellstone Ore", AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(25.0F, 5.0F).harvestLevel(6).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> FOOLS_GOLD_ORE_BLOCK = BLOCKS.register("fools_gold_ore", () -> new FBlock("Fools Gold Ore", AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> ERIDIUM_ORE_BLOCK = BLOCKS.register("eridium_ore", () -> new FBlock("Eridium Ore", AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(17.0F, 5.0F).harvestLevel(5).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> HALITE = BLOCKS.register("halite", () -> new FBlock("Halite", AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(4.0F, 1.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));

        //Block Items

        public static final RegistryObject<Item> ADAMANTIUM_ORE_BLOCK_ITEM = ITEMS.register("adamantium_ore", () -> new BlockItemBase(ADAMANTIUM_ORE_BLOCK.get()));
        public static final RegistryObject<Item> ROCK_STONE_BLOCK_ITEM = ITEMS.register("rock", () -> new BlockItemBase(ROCK_STONE_BLOCK.get()));
        public static final RegistryObject<Item> GODDESS_ORE_BLOCK_ITEM = ITEMS.register("goddessoreblock", () -> new BlockItemBase(GODDESS_ORE_BLOCK.get()));
        public static final RegistryObject<Item> UNKNOWN_ORE_BLOCK_ITEM = ITEMS.register("unknown_ore", () -> new BlockItemBase(UNKNOWN_ORE_BLOCK.get()));
        public static final RegistryObject<Item> HELLSTONE_ORE_BLOCK_ITEM = ITEMS.register("hellstone_ore", () -> new BlockItemBase(HELLSTONE_ORE_BLOCK.get()));
        public static final RegistryObject<Item> FOOLS_GOLD_ORE_BLOCK_ITEM = ITEMS.register("fools_gold_ore", () -> new BlockItemBase(FOOLS_GOLD_ORE_BLOCK.get()));
        public static final RegistryObject<Item> ERIDIUM_ORE_BLOCK_ITEM = ITEMS.register("eridium_ore", () -> new BlockItemBase(ERIDIUM_ORE_BLOCK.get()));
        public static final RegistryObject<Item> HALITE_BLOCK_ITEM = ITEMS.register("halite", () -> new BlockItemBase(HALITE.get()));

        //Dimensions
}