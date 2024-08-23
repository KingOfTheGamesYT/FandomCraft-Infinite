package com.devmaster1015.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import net.minecraftforge.common.ToolType;

public class RockStone extends Block {

    public RockStone() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(2.0F, 12.0F)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());

    }
}
