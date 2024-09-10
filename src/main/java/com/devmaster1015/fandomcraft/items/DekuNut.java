package com.devmaster1015.fandomcraft.items;

import com.devmaster1015.fandomcraft.entities.EntityDekuNut;
import com.devmaster1015.fandomcraft.items.itemtypes.Consumable;
import com.devmaster1015.fandomcraft.main.FandomCraft;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;


public class DekuNut extends Consumable
{
	public DekuNut(String name, int stacksize, Rarity rarity)
	{
		super(name, stacksize, FandomCraft.tabFandomCraftMisc, rarity);
	}

	protected void use(World world, PlayerEntity player, ItemStack stack)
	{
		if (!world.isRemote)
		{
			EntityDekuNut entity = new EntityDekuNut(world, player);
			entity.setItem(new ItemStack(this));
			entity.setDirectionAndMovement(player, player.rotationPitch, player.rotationYaw, 0.0F,  3.0F, 1.0F);
			world.addEntity(entity);
		}
		damage(stack, player, 1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand)
	{
		ItemStack stack = player.getHeldItem(hand);
		use(world, player, stack);
		return ActionResult.resultConsume(stack);
	}

	@Override
	public int getUseDuration(ItemStack stack)
	{
		return 0;
	}

	@Override
	public UseAction getUseAction(ItemStack stack)
	{
		return UseAction.SPEAR;
	}
}
