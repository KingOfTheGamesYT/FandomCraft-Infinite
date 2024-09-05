package com.devmaster1015.fandomcraft.blocks;

import com.devmaster1015.fandomcraft.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;

import net.minecraftforge.common.ToolType;

import java.util.Collections;
import java.util.List;

public class unknownOre extends OreBlock {
    public unknownOre() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(15.0F, 200.0F)
                .sound(SoundType.STONE)
                .harvestLevel(4)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(RegistryHandler.UNKNOWN_MINERAL.get(), 1));
    }
}
