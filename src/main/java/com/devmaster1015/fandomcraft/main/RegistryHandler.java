package com.devmaster1015.fandomcraft.main;

import com.devmaster1015.fandomcraft.blocks.*;

import com.devmaster1015.fandomcraft.items.AppraisingOre;
import com.devmaster1015.fandomcraft.items.Rupee;
import com.devmaster1015.fandomcraft.items.itemtypes.Consumable;
import com.devmaster1015.fandomcraft.items.itemtypes.FItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;

import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler{
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FandomCraft.MOD_ID);
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FandomCraft.MOD_ID);
        public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, FandomCraft.MOD_ID);
        public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FandomCraft.MOD_ID);

        public static void init() {
            ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
            BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
            ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
            SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());

        }

        //Entities

        //Items

        public static final RegistryObject<AppraisingOre> UNKNOWN_MINERAL = ITEMS.register("unknown_mineral", AppraisingOre::new);
        public static final RegistryObject<Item> APPRAISAL_KIT_BASIC = ITEMS.register("appraisal_kit_basic", () -> new FItem("Appraisal Kit Basic", FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> APPRAISAL_KIT_ADVANCED = ITEMS.register("appraisal_kit_advanced", () -> new FItem("Appraisal Kit Advanced", FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> APPRAISAL_KIT_MASTER = ITEMS.register("appraisal_kit_master", () -> new FItem("Appraisal Kit Master", FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> ELVEN_STEEL_INGOT = ITEMS.register("elven_steel_ingot", () -> new FItem("Elven Steel Ingot", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> RUPEE_GREEN = ITEMS.register("rupee_green", () -> new Rupee("Green Rupee", FandomCraft.tabFandomCraftMisc, Rarity.UNCOMMON).addInfo("A gem of 1 value.", "Can be smelted into ingots."));
        public static final RegistryObject<Item> RUPEE_RED = ITEMS.register("rupee_red", () -> new Rupee("Red Rupee", FandomCraft.tabFandomCraftMisc, Rarity.UNCOMMON).addInfo("A gem of 20 value.", "Can be smelted into ingots."));
        public static final RegistryObject<Item> RUPEE_BLUE = ITEMS.register("rupee_blue", () -> new Rupee("Blue Rupee", FandomCraft.tabFandomCraftMisc, Rarity.UNCOMMON).addInfo("A gem of 5 value.", "Can be smelted into ingots."));
        public static final RegistryObject<Item> RUPEE_ORANGE= ITEMS.register("rupee_orange", () -> new Rupee("Orange Rupee", FandomCraft.tabFandomCraftMisc).addInfo("A gem of 10 value."));
        public static final RegistryObject<Item> RUPEE_PURPLE = ITEMS.register("rupee_purple", () -> new Rupee("Purple Rupee", FandomCraft.tabFandomCraftMisc).addInfo("A gem of 50 value."));
        public static final RegistryObject<Item> RUPEE_SILVER = ITEMS.register("rupee_silver", () -> new Rupee("Silver Rupee", FandomCraft.tabFandomCraftMisc).addInfo("A gem of 200 value."));
        public static final RegistryObject<Item> RUPEE_YELLOW = ITEMS.register("rupee_yellow", () -> new Rupee("Yellow Rupee", FandomCraft.tabFandomCraftMisc).addInfo("A gem of 100 value."));
        public static final RegistryObject<Item> DWARVEN_STEEL_INGOT = ITEMS.register("dwarven_steel_ingot", () -> new FItem("Dwarven Steel Ingot", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> HELLSTONE_INGOT = ITEMS.register("hellstone_ingot", () -> new FItem("Hellstone Ingot", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> DARKSTEEL_INGOT = ITEMS.register("darksteel_ingot", () -> new FItem("Darksteel Ingot", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> ENERGY_CRYSTAL = ITEMS.register("energy_crystal", () -> new FItem("Energy Crystal", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> FOOLS_GOLD = ITEMS.register("fools_gold", () -> new FItem("Fools Gold", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> ADAMANTIUM_INGOT = ITEMS.register("adamantium_ingot", () -> new FItem("Adamantium Ingot", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> ERIDIUM_INGOT = ITEMS.register("eridium_ingot", () -> new FItem("Adamantium Ingot", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new FItem("Salt", FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> MYTHRIL_INGOT = ITEMS.register("mythril_ingot", () -> new FItem("Mythril Ingot", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> ORICHULUM_INGOT = ITEMS.register("orichulum_ingot", () -> new FItem("Orichulum Ingot", FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> ESSENCE_OF_NATURE = ITEMS.register("nature_essence", () -> new FItem("Nature Essence", FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> PEARL = ITEMS.register("pearl", () -> new FItem("Pearl", FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> WORM = ITEMS.register("worm", () -> new FItem("Worm", FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> BLUE_BERRY = ITEMS.register("blueberry", () -> new Consumable("Blueberry", 64, Rarity.COMMON).hunger(2,1).meat().action(UseAction.EAT));
        public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes", () -> new Consumable("Grapes", 64, Rarity.COMMON).hunger(4,1).meat().action(UseAction.EAT));
        public static final RegistryObject<Item> LETTUCE = ITEMS.register("lettuce", () -> new Consumable("Lettuce", 64, Rarity.COMMON).hunger(3,0.8F).meat().action(UseAction.EAT));
        public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new Consumable("Strawberry", 64, Rarity.COMMON).hunger(3,1).meat().action(UseAction.EAT));



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
        public static final RegistryObject<Block> MYTHRIL_ORE = BLOCKS.register("mythril_ore", () -> new FBlock("Halite Ore", AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(14.0F, 5.0F).harvestLevel(4).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> ORICHULUM_ORE = BLOCKS.register("orichulum_ore", () -> new FBlock("Orichulum Ore", AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(10.0F, 5.0F).harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> PEARL_STONE_BLOCK = BLOCKS.register("pearlstone", PearlStone::new);

        //Block Items

        public static final RegistryObject<Item> ADAMANTIUM_ORE_BLOCK_ITEM = ITEMS.register("adamantium_ore", () -> new BlockItemBase(ADAMANTIUM_ORE_BLOCK.get()));
        public static final RegistryObject<Item> ROCK_STONE_BLOCK_ITEM = ITEMS.register("rock", () -> new BlockItemBase(ROCK_STONE_BLOCK.get()));
        public static final RegistryObject<Item> GODDESS_ORE_BLOCK_ITEM = ITEMS.register("goddessoreblock", () -> new BlockItemBase(GODDESS_ORE_BLOCK.get()));
        public static final RegistryObject<Item> UNKNOWN_ORE_BLOCK_ITEM = ITEMS.register("unknown_ore", () -> new BlockItemBase(UNKNOWN_ORE_BLOCK.get()));
        public static final RegistryObject<Item> HELLSTONE_ORE_BLOCK_ITEM = ITEMS.register("hellstone_ore", () -> new BlockItemBase(HELLSTONE_ORE_BLOCK.get()));
        public static final RegistryObject<Item> FOOLS_GOLD_ORE_BLOCK_ITEM = ITEMS.register("fools_gold_ore", () -> new BlockItemBase(FOOLS_GOLD_ORE_BLOCK.get()));
        public static final RegistryObject<Item> ERIDIUM_ORE_BLOCK_ITEM = ITEMS.register("eridium_ore", () -> new BlockItemBase(ERIDIUM_ORE_BLOCK.get()));
        public static final RegistryObject<Item> HALITE_BLOCK_ITEM = ITEMS.register("halite", () -> new BlockItemBase(HALITE.get()));
        public static final RegistryObject<Item> MYTHRIL_ORE_ITEM = ITEMS.register("mythril_ore", () -> new BlockItemBase(MYTHRIL_ORE.get()));
        public static final RegistryObject<Item> ORICHULUM_ORE_ITEM = ITEMS.register("orichulum_ore", () -> new BlockItemBase(ORICHULUM_ORE.get()));
        public static final RegistryObject<Item> PEARL_STONE_ITEM = ITEMS.register("pearlstone", () -> new BlockItemBase(PEARL_STONE_BLOCK.get()));

        //Dimensions

        //Sounds
        public static final RegistryObject<SoundEvent> RUPEE_PICKUP = SOUNDS.register("rupee", () -> new SoundEvent(new ResourceLocation(FandomCraft.MOD_ID , "rupee")));

}