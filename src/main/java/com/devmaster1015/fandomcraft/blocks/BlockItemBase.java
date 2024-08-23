package com.devmaster1015.fandomcraft.blocks;

import com.devmaster1015.fandomcraft.main.FandomCraft;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(FandomCraft.tabFandomCraftBlocks));
    }
}

