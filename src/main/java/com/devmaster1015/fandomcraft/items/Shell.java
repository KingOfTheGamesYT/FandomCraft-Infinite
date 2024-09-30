package com.devmaster1015.fandomcraft.items;

import com.devmaster1015.fandomcraft.entities.EntityDekuNut;
import com.devmaster1015.fandomcraft.entities.EntityGreenShell;
import com.devmaster1015.fandomcraft.items.itemtypes.Consumable;
import com.devmaster1015.fandomcraft.main.FandomCraft;

import com.devmaster1015.fandomcraft.util.RegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class Shell extends Consumable
{
	public Shell(int stacksize, Rarity rarity)
	{
		super(stacksize, FandomCraft.tabFandomCraftMisc, rarity);
	}

	protected void use(World world, PlayerEntity player, ItemStack stack)
	{
		if (!world.isRemote)
		{
			EntityGreenShell entity = new EntityGreenShell(world, player);
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
		world.playSound((PlayerEntity)null, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 0.0F / (random.nextFloat() * 0.4F + 1.2F)  * 0.5F);
		world.playSound((PlayerEntity)null, player.getPosX(), player.getPosY(), player.getPosZ(), RegistryHandler.KOOPA_KICK.get(), SoundCategory.PLAYERS, 1.0F, 2.0F / (random.nextFloat() * 0.4F + 1.2F)  * 0.5F);
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
