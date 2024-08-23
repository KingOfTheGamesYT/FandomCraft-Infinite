package com.devmaster1015.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import net.minecraftforge.common.ToolType;

public class adamantiumOre extends Block {

    public adamantiumOre() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(20.0F, 5.0F)
                .harvestLevel(6)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());

    }
}
