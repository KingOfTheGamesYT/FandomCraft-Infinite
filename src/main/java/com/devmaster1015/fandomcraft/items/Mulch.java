package com.devmaster1015.fandomcraft.items;

import com.devmaster1015.fandomcraft.main.FandomCraft;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class Mulch extends Item{
    public Mulch(int durability) {
        super(new Item.Properties()
                .maxDamage(durability)
                .group(FandomCraft.tabFandomCraftMisc));
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        PlayerEntity player = context.getPlayer();
        ItemStack itemstack = context.getItem();

        if (player == null || !player.canPlayerEdit(pos, context.getFace(), itemstack)) {
            return ActionResultType.FAIL;
        }

        UseHoeEvent event = new UseHoeEvent(context);
        if (MinecraftForge.EVENT_BUS.post(event)) {
            return ActionResultType.FAIL;
        }

        if (event.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW) {
            itemstack.damageItem(1, player, (p) -> p.sendBreakAnimation(context.getHand()));
            return ActionResultType.SUCCESS;
        }

        BlockState blockState = world.getBlockState(pos);
        if (context.getFace() != Direction.DOWN && world.isAirBlock(pos.up()) && (blockState.getBlock() == Blocks.GRASS_BLOCK || blockState.getBlock() == Blocks.DIRT)) {
            BlockState farmlandState = Blocks.FARMLAND.getDefaultState();
            world.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

            if (!world.isRemote) {
                world.setBlockState(pos, farmlandState, 11);
                itemstack.damageItem(1, player, (p) -> p.sendBreakAnimation(context.getHand()));
            }
            return ActionResultType.SUCCESS;
        }

        return ActionResultType.PASS;
    }

    }