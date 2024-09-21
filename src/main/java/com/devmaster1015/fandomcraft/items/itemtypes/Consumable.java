package com.devmaster1015.fandomcraft.items.itemtypes;

import com.devmaster1015.fandomcraft.main.FandomCraft;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import org.apache.logging.log4j.util.TriConsumer;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Consumable extends FItem
{
	private Supplier<SoundEvent> useSoundSupplier;
	protected boolean alwaysEdible = false;

	protected UseAction useaction = UseAction.BOW;
	protected List<EffectInstance> effects;
	protected TriConsumer<World, PlayerEntity, ItemStack> action;
	protected int usetime = 32, foodamount, repairamount;
	protected float healamount, saturationamount, repairpercentage;
	protected boolean repaireverything, useinstantly;
	protected boolean isMeat = false;

	public Consumable(String name, int stacksize, Rarity rarity, ItemGroup tab) {
		super(name, new Properties().maxStackSize(stacksize).group(tab).rarity(rarity));
	}
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

	public Consumable setUseSound(Supplier<SoundEvent> soundSupplier) {
		this.useSoundSupplier = soundSupplier;
		return this;
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

	public Consumable setAlwaysEdible(boolean alwaysEdible) {
		this.alwaysEdible = alwaysEdible;
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

	public void doEffect(World world, PlayerEntity player, ItemStack stack) {
		if (healamount > 0) {
			player.heal(healamount);
		}
		if (foodamount > 0) {
			if (alwaysEdible || (healamount > 0 && player.getHealth() < player.getMaxHealth()) || player.getFoodStats().needFood()) {
				player.getFoodStats().addStats(foodamount, saturationamount);
			}
		}
		// Apply effects (add positive effects)
		if (effects != null) {
			for (EffectInstance i : effects) {
				// Check if duration is 0; if so, remove the effect
				if (i.getDuration() == 0) {
					player.removePotionEffect(i.getPotion());
				} else {
					player.addPotionEffect(i);
				}
			}
		}
		if (action != null) {
			action.accept(world, player, stack);
		}

		int repairtype = repairamount > 0 ? 1 : repairpercentage > 0 ? 2 : 0;
		if (repairtype > 0) {
			player.inventory.mainInventory.forEach((is) -> {
				if (is.isDamageable()) {
					is.setDamage((int) (Math.min(0, is.getDamage() - (repairtype == 1 ? repairamount : is.getMaxDamage() * repairpercentage))));
				}
			});
		}
	}

	public Consumable removeEffect(Effect effect) {
		if (effects == null) {
			effects = new ArrayList<>();
		}
		effects.add(new EffectInstance(effect, 0, 0, false, false));  // We don't need duration or amplifier for removal
		return this;
	}

	protected void use(World world, PlayerEntity player, ItemStack stack) {
		if (useSoundSupplier != null && !world.isRemote) {
			SoundEvent sound = useSoundSupplier.get();
			if (sound != null) {
				world.playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(), sound, SoundCategory.PLAYERS, 1.0F, 1.0F);
			}
		}
		doEffect(world, player, stack);
		damage(stack, player, 1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		ItemStack stack = player.getHeldItem(hand);

		// Check if the player is hungry or the item is always edible
		boolean canEat = player.getFoodStats().needFood() || alwaysEdible;

		// Only allow consumption if the player is hungry or the item is marked as always edible
		if (canEat) {
			if (useinstantly) {
				// Play sound and consume item instantly
				if (useSoundSupplier != null && !world.isRemote) {
					SoundEvent sound = useSoundSupplier.get();
					if (sound != null) {
						world.playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(), sound, SoundCategory.PLAYERS, 1.0F, 1.0F);
					}
				}
				use(world, player, stack);
				return ActionResult.resultConsume(stack);
			}

			// Start normal consumption (holding the item to eat)
			player.setActiveHand(hand);
			return ActionResult.resultConsume(stack);
		}

		// If the player can't eat, return fail
		return ActionResult.resultFail(stack);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity) {
		// Ensure we only apply the effect if the entity is a player and they can eat
		if (entity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) entity;

			// Check if the player can eat (either because they need food or it's always edible)
			boolean canEat = player.getFoodStats().needFood() || alwaysEdible;

			// Only consume the item if the player can eat
			if (canEat) {
				use(world, player, stack);
			}
		}

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
