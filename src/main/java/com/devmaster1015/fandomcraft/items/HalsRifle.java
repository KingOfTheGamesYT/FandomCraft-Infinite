package com.devmaster1015.fandomcraft.items;

import com.devmaster1015.fandomcraft.entities.EntityBullet;
import com.devmaster1015.fandomcraft.main.FandomCraft;
import com.devmaster1015.fandomcraft.util.RegistryHandler;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import net.minecraftforge.event.ForgeEventFactory;
import org.apache.logging.log4j.util.TriConsumer;

import java.util.function.Predicate;

public class HalsRifle extends ShootableItem
{
	protected String name;
	protected String[] info;
	protected Ingredient repairitem;
	protected ItemStack ammo;
	protected TriConsumer<EntityBullet, Entity, RayTraceResult> hitaction;
	protected float power;

	public HalsRifle(float power, int durability, Item ammo, Item repairitem)
	{
		super(new Properties()
				.maxStackSize(1)
				.group(FandomCraft.tabFandomCraftMisc)
				.maxDamage(durability));
		this.power = power;
		this.ammo = new ItemStack(ammo);
		this.repairitem = Ingredient.fromItems(repairitem);
	}

	public boolean getIsRepairable(ItemStack stack1, ItemStack stack2)
	{
		return repairitem != null && repairitem.test(stack2);
	}

	public ItemStack getProjectile(PlayerEntity player, ItemStack stack) {
		if (!(stack.getItem() instanceof ShootableItem)) {
			return ItemStack.EMPTY;
		} else {
			Predicate<ItemStack> predicate = ((ShootableItem) stack.getItem()).getAmmoPredicate();
			ItemStack itemstack = ShootableItem.getHeldAmmo(player, predicate);
			if (!itemstack.isEmpty()) {
				return itemstack;
			} else {
				for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
					ItemStack itemstack1 = player.inventory.getStackInSlot(i);
					if (predicate.test(itemstack1)) {
						return itemstack1;
					}
				}
				return player.abilities.isCreativeMode ? new ItemStack(RegistryHandler.BULLET.get()) : ItemStack.EMPTY;
			}
		}
	}

	public void onPlayerStoppedUsing(ItemStack stack, World world, LivingEntity entity, int holdtime)
	{
		if (entity instanceof PlayerEntity)
		{
			PlayerEntity player = (PlayerEntity) entity;
			boolean flag = player.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack itemstack = getProjectile(player, stack);

			int i = this.getUseDuration(stack) - holdtime;
			i = ForgeEventFactory.onArrowLoose(stack, world, player, i, !itemstack.isEmpty() || flag);
			if (i < 0) return;

			if (!itemstack.isEmpty() || flag)
			{
				if (itemstack.isEmpty())
				{
					itemstack = new ItemStack(RegistryHandler.BULLET.get());
				}
					if (!world.isRemote)
					{
						float damage = power;
						{
							damage *= 0.75f;
						}

						EntityBullet ammo = new EntityBullet(world, player, itemstack, damage, hitaction);
						ammo.setItem(itemstack);
						ammo.setDirectionAndMovement(player, player.rotationPitch, player.rotationYaw, 0.0F,  3.0F, 1.0F);
						stack.damageItem(1, player, (p_220009_1_) ->
						{
							p_220009_1_.sendBreakAnimation(player.getActiveHand());
						});

						world.addEntity(ammo);
					}

					world.playSound((PlayerEntity)null, player.getPosX(), player.getPosY(), player.getPosZ(), RegistryHandler.HAL_SHOOT.get(), SoundCategory.PLAYERS, 1.0F, 2.0F / (random.nextFloat() * 0.4F + 1.2F)  * 0.5F);
					if (!player.abilities.isCreativeMode)
					{
						itemstack.shrink(1);
						if (itemstack.isEmpty())
						{
							player.inventory.removeStackFromSlot(1);
						}
					}
					player.addStat(Stats.ITEM_USED.get(this));
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
			world.playSound((PlayerEntity)null, player.getPosX(), player.getPosY(), player.getPosZ(), RegistryHandler.EMPTY_CLIP.get(), SoundCategory.PLAYERS, 1.0F, 3.0F / (random.nextFloat() * 0.4F + 1.2F)  * 0.5F);

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
		return (stack) -> stack.getItem() == ammo.getItem();
	}

	@Override
	public int func_230305_d_() {
		return 15;
	}
}