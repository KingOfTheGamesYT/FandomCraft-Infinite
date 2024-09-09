package com.devmaster1015.fandomcraft.items;

import com.devmaster1015.fandomcraft.entities.EntityBullet;
import com.devmaster1015.fandomcraft.entities.EntityEnergyBall;
import com.devmaster1015.fandomcraft.items.itemtypes.Axe;
import com.devmaster1015.fandomcraft.main.FandomCraft;
import com.devmaster1015.fandomcraft.util.RegistryHandler;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import net.minecraftforge.event.ForgeEventFactory;

import org.apache.logging.log4j.util.TriConsumer;

import java.util.List;
import java.util.function.Predicate;

public class HandCannon extends ShootableItem
{
	protected String name;
	private String[] info = new String[0];
	protected Ingredient repairitem;
	protected ItemStack[] ammo;
	protected TriConsumer<EntityEnergyBall, Entity, RayTraceResult> hitaction;

	protected float power;

	public HandCannon(String name, float power, int durability, Item energyCrystal, Item energyTank, Item repairitem)
	{
		super(new Properties()
				.maxStackSize(1)
				.group(FandomCraft.tabFandomCraftMisc)
				.maxDamage(durability));
		this.name = name;
		this.power = power;
		this.ammo = new ItemStack[]{new ItemStack(energyCrystal), new ItemStack(energyTank)};
		this.repairitem = Ingredient.fromItems(repairitem);
	}

	public boolean getIsRepairable(ItemStack stack1, ItemStack stack2)
	{
		return repairitem != null && repairitem.test(stack2);
	}

	public ItemStack[] getProjectiles(PlayerEntity player, ItemStack stack) {
		ItemStack[] ammoStacks = new ItemStack[]{ItemStack.EMPTY, ItemStack.EMPTY};

		Predicate<ItemStack> ammoPredicate = this.getInventoryAmmoPredicate();
		for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
			ItemStack itemstack = player.inventory.getStackInSlot(i);
			if (ammoPredicate.test(itemstack)) {
				if (itemstack.getItem() == ammo[0].getItem() && ammoStacks[0].isEmpty()) {
					ammoStacks[0] = itemstack;
				} else if (itemstack.getItem() == ammo[1].getItem() && ammoStacks[1].isEmpty()) {
					ammoStacks[1] = itemstack;
				}
				if (!ammoStacks[0].isEmpty() && !ammoStacks[1].isEmpty()) {
					break;
				}
			}
		}

		if (player.abilities.isCreativeMode) {
			if (ammoStacks[0].isEmpty()) ammoStacks[0] = new ItemStack(this.ammo[0].getItem());
			if (ammoStacks[1].isEmpty()) ammoStacks[1] = new ItemStack(this.ammo[1].getItem());
		}

		return ammoStacks;
	}

	public void onPlayerStoppedUsing(ItemStack stack, World world, LivingEntity entity, int holdtime) {
		if (entity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) entity;
			boolean flag = player.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack[] projectiles = getProjectiles(player, stack);

			int i = this.getUseDuration(stack) - holdtime;
			i = ForgeEventFactory.onArrowLoose(stack, world, player, i, (!projectiles[0].isEmpty() && !projectiles[1].isEmpty()) || flag);
			if (i < 0) return;

			if ((!projectiles[0].isEmpty() && !projectiles[1].isEmpty()) || flag) {
				if (projectiles[0].isEmpty()) {
					projectiles[0] = new ItemStack(this.ammo[0].getItem());
				}
				if (projectiles[1].isEmpty()) {
					projectiles[1] = new ItemStack(this.ammo[1].getItem());
				}

				float f = getPowerForTime(i);
				if (!((double) f < 0.1D)) {
					if (!world.isRemote) {
						float damage = power;
						if (f < 1.0F) {
							damage *= 0.75f;
						}

						EntityEnergyBall ammo = new EntityEnergyBall(world, player, projectiles[0], damage, hitaction);
						ammo.setItem(projectiles[0]);
						ammo.setDirectionAndMovement(player, player.rotationPitch, player.rotationYaw, 0.0F, 3.0F, 1.0F);

						stack.damageItem(1, player, (p_220009_1_) ->
						{
							p_220009_1_.sendBreakAnimation(player.getActiveHand());
						});

						world.addEntity(ammo);
					}

					world.playSound((PlayerEntity) null, player.getPosX(), player.getPosY(), player.getPosZ(), RegistryHandler.HAL_SHOOT.get(), SoundCategory.PLAYERS, 1.0F, 2.0F / (random.nextFloat() * 0.4F + 1.2F) * 0.5F);
					if (!player.abilities.isCreativeMode) {
						projectiles[0].shrink(1);
						projectiles[1].shrink(1);
						if (projectiles[0].isEmpty()) {
							player.inventory.deleteStack(projectiles[0]);
						}
						if (projectiles[1].isEmpty()) {
							player.inventory.deleteStack(projectiles[1]);
						}
					}
					player.addStat(Stats.ITEM_USED.get(this));
				}
			}
		}
	}


	public int getUseDuration(ItemStack stack)
	{
		return 72000;
	}

	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand)
	{
		ItemStack itemstack = player.getHeldItem(hand);
		boolean flag = !player.findAmmo(itemstack).isEmpty();

		ActionResult<ItemStack> ret = ForgeEventFactory.onArrowNock(itemstack, world, player, hand, flag);
		if (ret != null) return ret;

		if (!player.abilities.isCreativeMode && !flag)
		{
			return ActionResult.resultFail(itemstack);
		}
		else
		{
			player.setActiveHand(hand);
			return ActionResult.resultConsume(itemstack);
		}
	}

	@Override
	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return (stack) -> stack.getItem() == ammo[0].getItem() || stack.getItem() == ammo[1].getItem();
	}
	public static float getPowerForTime(int time)
	{
		float f = (float) time / 20F;
		f = (f * f + f * 2F) / 3F;
		return f > 1f ? 1f : f;
	}

	public HandCannon addInfo(String... newInfo) {
		if (newInfo != null && newInfo.length > 0) {
			String[] combinedInfo = new String[this.info.length + newInfo.length];
			System.arraycopy(this.info, 0, combinedInfo, 0, this.info.length);
			System.arraycopy(newInfo, 0, combinedInfo, this.info.length, newInfo.length);
			this.info = combinedInfo;
		}
		return this;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> list, ITooltipFlag flagIn){
		for (String s : info) {
			list.add(new StringTextComponent(s));
		}
	}
	public UseAction getUseAction(ItemStack stack)
	{
		return UseAction.BOW;
	}
	@Override
	public int func_230305_d_() {
		return 14;
	}

}
