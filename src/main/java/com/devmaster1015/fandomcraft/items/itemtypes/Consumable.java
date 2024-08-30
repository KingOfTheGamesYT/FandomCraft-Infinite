package com.devmaster1015.fandomcraft.items.itemtypes;

import com.devmaster1015.fandomcraft.main.FandomCraft;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import org.apache.logging.log4j.util.TriConsumer;


import java.util.ArrayList;
import java.util.List;

public class Consumable extends FItem
{
	protected UseAction useaction = UseAction.BOW;
	protected List<EffectInstance> effects;
	protected TriConsumer<World, PlayerEntity, ItemStack> action;
	protected int usetime = 32, foodamount, repairamount;
	protected float healamount, saturationamount, repairpercentage;
	protected boolean repaireverything, useinstantly;
	protected boolean isMeat = false;

	public Consumable(String name, int stacksize, Rarity rarity)
	{
		super(name, stacksize, FandomCraft.tabFandomCraftMisc, rarity);
	}

	public Consumable(String name, int durability, ItemGroup tab, Rarity rarity)
	{
		super(name, new Properties().maxDamage(durability).group(tab).rarity(rarity));
	}

	public Consumable(String name, Properties p)
	{
		super(name, p);
	}

	public Consumable useInstantly()
	{
		this.useinstantly = true;
		this.usetime = 0;
		return this;
	}

	public Consumable meat()
	{
		this.isMeat = true;
		return this;
	}

	@Override
	public boolean isFood()
	{
		return foodamount > 0 || isMeat;
	}

	@Override
	public Food getFood()
	{
		if (isFood()) {
			Food.Builder builder = new Food.Builder();
			if (isMeat) {
				builder.meat();
			}
			return builder.build();
		}
		return null;
	}
	public Consumable health(float f)
	{
		this.healamount = f;
		return this;
	}

	public Consumable hunger(int amount, float saturation)
	{
		this.foodamount = amount;
		this.saturationamount = saturation;
		return this;
	}

	public Consumable action(UseAction action)
	{
		this.useaction = action;
		return this;
	}

	public Consumable repair(float amount, boolean percentage)
	{
		if (percentage)
		{
			repairpercentage = amount;
		}
		else
		{
			repairamount = (int) amount;
		}
		return this;
	}

	public Consumable effect(TriConsumer<World, PlayerEntity, ItemStack> action)
	{
		this.action = action;
		return this;
	}

	public Consumable effect(Effect effect, int amp, int seconds, boolean visible)
	{
		if (effects == null)
		{
			effects = new ArrayList<EffectInstance>();
		}
		effects.add(new EffectInstance(effect, seconds * 20, amp, !visible, visible));
		return this;
	}

	public void damage(ItemStack stack, LivingEntity e, int i)
	{
		stack.shrink(i);
	}

	public void doEffect(World world, PlayerEntity player, ItemStack stack)
	{
		if (healamount > 0)
		{
			player.heal(healamount);
		}
		if (foodamount > 0)
		{
			if ((healamount > 0 && player.getHealth() < player.getMaxHealth()) || player.getFoodStats().needFood())
			{
				player.getFoodStats().addStats(foodamount, saturationamount);
			}
		}
		if (effects != null)
		{
			for (EffectInstance i : effects)
			{
				player.addPotionEffect(i);
			}
		}
		if (action != null)
		{
			action.accept(world, player, stack);
		}

		int repairtype = repairamount > 0 ? 1 : repairpercentage > 0 ? 2 : 0;
		if (repairtype > 0)
		{
			player.inventory.mainInventory.forEach((is) ->
			{
				if (is.isDamageable())
				{
					is.setDamage((int) (Math.min(0, is.getDamage() - (repairtype == 1 ? repairamount : is.getMaxDamage() * repairpercentage))));
				}
			});
		}
	}

	protected void use(World world, PlayerEntity player, ItemStack stack)
	{
		doEffect(world, player, stack);
		damage(stack, player, 1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand)
	{
		ItemStack stack = player.getHeldItem(hand);
		if (useinstantly)
		{
			use(world, player, stack);
			return ActionResult.resultConsume(stack);
		}
		player.setActiveHand(hand);
		return ActionResult.resultConsume(player.getHeldItem(hand));
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity)
	{
		use(world, (PlayerEntity) entity, stack);
		return stack;
	}

	@Override
	public int getUseDuration(ItemStack stack)
	{
		return usetime;
	}

	@Override
	public UseAction getUseAction(ItemStack stack)
	{
		return useaction;
	}
}
