package com.devmaster1015.fandomcraft.util;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public class WeaponTier implements IItemTier
{
	private int uses, harvestlevel = 2, enchantability = 0;
	private float swingspeed = 1, damage;
	private ItemStack repairitem;

	public WeaponTier(int uses, float damage)
	{
		this.uses = uses;
		this.damage = damage;
	}

	public WeaponTier level(int i)
	{
		this.harvestlevel = i;
		return this;
	}

	public WeaponTier enchanting(int i)
	{
		this.enchantability = i;
		return this;
	}

	public WeaponTier speed(float f)
	{
		this.swingspeed = f;
		return this;
	}

	public WeaponTier material(Item item)
	{
		repairitem = new ItemStack(item);
		return this;
	}

	public ItemStack getRepairItem()
	{
		return repairitem;
	}

	@Override
	public int getMaxUses() {
		return uses;
	}

	@Override
	public float getEfficiency() {
		return 0;
	}

	@Override
	public float getAttackDamage() {
		return damage;
	}

	@Override
	public int getHarvestLevel() {
		return harvestlevel;
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromStacks(repairitem);
	}
}