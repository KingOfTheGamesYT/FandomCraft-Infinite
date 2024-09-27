package com.devmaster1015.fandomcraft.blocks;

import com.devmaster1015.fandomcraft.util.RegistryHandler;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;
import java.util.List;

public class PearlStone extends OreBlock {
    public PearlStone() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(8.0F, 22.0F)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;

        List<ItemStack> drops = new ArrayList<>();

        // Build the LootContext
        LootContext lootContext = builder.withParameter(LootParameters.BLOCK_STATE, state).build(LootParameterSets.BLOCK);
        ServerWorld world = lootContext.getWorld();
        BlockPos pos = new BlockPos(lootContext.get(LootParameters.ORIGIN));

        // Get the Fortune level
        int fortuneLevel = 0;
        ItemStack tool = lootContext.get(LootParameters.TOOL);
        if (tool != null) {
            fortuneLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, tool);
        }

        // Calculate the base amount (2-5)
        int baseAmount = world.rand.nextInt(5) + 2;

        // Apply Fortune bonus
        int fortuneBonus = 0;
        if (fortuneLevel > 0) {
            fortuneBonus = world.rand.nextInt(fortuneLevel + 2) - 1;
            if (fortuneBonus < 0) fortuneBonus = 0;
        }

        // Calculate total amount
        int totalAmount = baseAmount + fortuneBonus;

        // Create and add the ItemStack to the drops list
        ItemStack drop = new ItemStack(RegistryHandler.PEARL.get(), totalAmount);
        drops.add(drop);

        return drops;
    }
}
