package com.devmaster1015.fandomcraft.items.itemtypes;

import com.devmaster1015.fandomcraft.main.FandomCraft;
import com.devmaster1015.fandomcraft.util.Elements;
import com.devmaster1015.fandomcraft.util.Elements.Element;
import com.devmaster1015.fandomcraft.util.IHasElement;
import com.devmaster1015.fandomcraft.util.WeaponTier;


import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.function.Consumer;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeMod;


public class Weapon extends SwordItem implements IHasElement
{
	public static final Consumer<LivingEntity> breakbroadcast = (p) -> p.sendBreakAnimation(EquipmentSlotType.MAINHAND);
	protected static final UUID MOVESPEED = UUID.fromString("35f5b798-7778-4017-98f9-ff557dc28f03");
	protected static final UUID REACH = UUID.fromString("168fad76-3979-4638-91c9-a366c0933551");

	protected String name;
	protected String[] info;
	protected boolean isblunt = false, isranged = true, ismagic = false;
	protected float reach = 0, movespeed = 0;
	protected Multimap<Attribute, AttributeModifier> modifiers;
	protected ActionResultType breakevent;
	protected ItemStack repairitem;
	protected Element element;

	public Weapon(String name, WeaponTier tier, Rarity rarity)
	{
		super(tier, -1, -2.4f, new Properties().group(FandomCraft.tabFandomCraftMisc).rarity(rarity));
		this.repairitem = tier.getRepairItem();
		this.name = name;
	}

	public Weapon build(float reach, float movespeed)
	{
		this.reach = reach;
		this.movespeed = movespeed;

		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double) getAttackDamage(), AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double) (-2.4f * getTier().getEfficiency()), AttributeModifier.Operation.ADDITION));
		modifiers = builder.build();
		return this;
	}

	public Weapon rebuild()
	{
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.putAll(modifiers);
		if (movespeed != 0)
		{
			builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(MOVESPEED, "Weapon modifier", (double) movespeed, AttributeModifier.Operation.MULTIPLY_TOTAL));
		}
		if (reach != 0)
		{
			builder.put(ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(REACH, "Weapon modifier", (double) reach, AttributeModifier.Operation.MULTIPLY_TOTAL));
		}
		modifiers = builder.build();

		for (Entry<Attribute, Collection<AttributeModifier>> entry : modifiers.asMap().entrySet())
		{
			FandomCraft.dev(getRegistryName() + " [" + entry.getKey().getRegistryName() + "] modifiers : ");
			for (AttributeModifier m : entry.getValue())
			{
				FandomCraft.dev("    > [" + m.getName() + "] " + m.getAmount());
			}
		}
		return this;
	}

	public Weapon rebuildWith(Attribute attribute, UUID id, String modifiername, double value, Operation valuetype)
	{
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.putAll(modifiers);
		builder.put(attribute, new AttributeModifier(id, modifiername, value, valuetype));
		modifiers = builder.build();
		return this;
	}

	public Weapon element(Element element)
	{
		this.element = element;
		return this;
	}

	@Override
	public Element getElement()
	{
		return element != null ? element : IHasElement.super.getElement();
	}

	public Weapon addInfo(String... s)
	{
		if (info == null)
		{
			info = s;
		}
		else
		{
			String[] newinfo = new String[info.length + s.length];
			int i = 0;
			for (String si : this.info)
			{
				newinfo[i] = si;
				++i;
			}
			for (String si : info)
			{
				newinfo[i] = si;
				++i;
			}
		}
		return this;
	}

	public Weapon setBlunt()
	{
		isblunt = true;
		return this;
	}

	public Weapon setRanged()
	{
		isranged = true;
		return this;
	}

	public Weapon setMagic()
	{
		ismagic = true;
		return this;
	}
	public boolean isBlunt()
	{
		return isblunt;
	}

	public boolean isMelee()
	{
		return !isranged;
	}

	public boolean isRanged()
	{
		return isranged;
	}

	public boolean isMagic()
	{
		return ismagic;
	}

	public Weapon onBreak(ActionResultType event)
	{
		this.breakevent = event;
		return this;
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity player)
	{
		damageStack(1, player, target, stack);
		return true;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, BlockState block, BlockPos pos, LivingEntity player)
	{
		if (block.getBlockHardness(world, pos) != 0.0F)
		{
			damageStack(1, player, null, stack);
		}
		return true;
	}

	public <T extends LivingEntity> void damageStack(int amount, T player, T target, ItemStack stack)
	{
		if (!player.world.isRemote && (!(player instanceof PlayerEntity) || !((PlayerEntity) player).abilities.isCreativeMode))
		{
			if (stack.isDamageable())
			{
				amount = this.getItem().damageItem(stack, amount, player, breakbroadcast);
				if (stack.attemptDamageItem(amount, player.getRNG(), player instanceof ServerPlayerEntity ? (ServerPlayerEntity) player : null))
				{
					if (breakevent != null && breakevent.isSuccess())
					{
						breakevent.isSuccess();
					}
					else
					{
						breakItem(player, stack);
					}
				}
			}
		}
	}

	public <T extends LivingEntity> void breakItem(T player, ItemStack stack)
	{
		breakbroadcast.accept(player);
		stack.shrink(1);
		if (player instanceof PlayerEntity)
		{
			((PlayerEntity) player).addStat(Stats.ITEM_BROKEN.get(this));
		}

		stack.setDamage(0);
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state)
	{
		if (isblunt)
		{
			if (state.getMaterial() == Material.ROCK || state.getMaterial() == Material.GLASS || state.getMaterial() == Material.REDSTONE_LIGHT || state.getMaterial() == Material.ICE
					|| state.getMaterial() == Material.PACKED_ICE || state.getMaterial() == Material.GOURD)
			{
				return 15;
			}
		}
		else
		{
			if (state.equals(Blocks.COBWEB))
			{
				return 15.0F;
			}
			else
			{
				Material material = state.getMaterial();
				return material != Material.PLANTS && material != Material.TALL_PLANTS && material != Material.CORAL && !state.equals(BlockTags.LEAVES) && material != Material.GOURD ? 1.0F : 1.5F;
			}
		}
		return 1f;
	}

	@Override
	public boolean canHarvestBlock(BlockState state)
	{
		return isblunt ? state.getMaterial() == Material.ROCK : state.equals(Blocks.COBWEB);
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag advanced)
	{
		if (info != null)
		{
			for (String s : info)
			{
				list.add(new StringTextComponent(s));
			}
		}
		boolean needsspacing = true;
		if (repairitem != null && !repairitem.isEmpty())
		{
			if (needsspacing)
			{
				list.add(new StringTextComponent(""));
				needsspacing = false;
			}
			list.add(new StringTextComponent(TextFormatting.BLUE + "Material: " + getTier().getRepairMaterial().getMatchingStacks()[0].getDisplayName().getString()));
		}
		if (element != Elements.None)
		{
			if (needsspacing)
			{
				list.add(new StringTextComponent(""));
				needsspacing = false;
			}
			list.add(new StringTextComponent(TextFormatting.BLUE + "Element: " + TextFormatting.WHITE + getElement().getName()));
			if (getElement().getElementsWeakVS().size() > 0)
			{

				list.add(new StringTextComponent(TextFormatting.BLUE + "> Weak VS: " + TextFormatting.WHITE + getElement().getWeakVSText()));
			}
			if (getElement().getElementsStrongVS().size() > 0)
			{
				list.add(new StringTextComponent(TextFormatting.BLUE + "> Strong VS: " + TextFormatting.WHITE + getElement().getWeakVSText()));
			}
		}
	}


	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot)
	{
		if (slot == EquipmentSlotType.MAINHAND)
		{
			return modifiers;
		}

		return super.getAttributeModifiers(slot);
	}
}