package com.devmaster1015.fandomcraft.items.itemtypes;

import com.devmaster1015.fandomcraft.main.FandomCraft;
import com.devmaster1015.fandomcraft.util.Elements.Element;
import com.devmaster1015.fandomcraft.util.IHasElement;
import com.devmaster1015.fandomcraft.util.ModdedTier;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
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
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeMod;

import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.function.Consumer;


public class Pickaxe extends PickaxeItem implements IHasElement
{
	public static final Consumer<LivingEntity> breakbroadcast = (p) -> p.sendBreakAnimation(EquipmentSlotType.MAINHAND);
	protected static final UUID MOVESPEED = UUID.fromString("35f5b798-7778-4017-98f9-ff557dc28f03");
	protected static final UUID REACH = UUID.fromString("168fad76-3979-4638-91c9-a366c0933551");

	protected String name;
	private String[] info = new String[0];
	protected float reach = 0, movespeed = 0, attackspeed = 0;
	protected Multimap<Attribute, AttributeModifier> modifiers;
	protected ActionResultType breakevent;
	protected ItemStack repairitem;
	protected Element element;

	public Pickaxe(String name, ModdedTier tier, Rarity rarity)
	{
		super(tier, -1, -2.4F, new Properties().group(FandomCraft.tabFandomCraftMisc).rarity(rarity));
		this.repairitem = tier.getRepairItem();
		this.name = name;
	}

	public Pickaxe build(float reach, float movespeed)
	{
		this.reach = reach;
		this.movespeed = movespeed;

		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Pickaxe modifier", (double) getAttackDamage(), Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Pickaxe modifier", (double) (-2.4f), Operation.ADDITION));
		modifiers = builder.build();
		return this;
	}

	public Pickaxe rebuild()
	{
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.putAll(modifiers);
		if (movespeed != 0)
		{
			builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(MOVESPEED, "Sword modifier", (double) movespeed, Operation.MULTIPLY_TOTAL));
		}
		if (reach != 0)
		{
			builder.put(ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(REACH, "Sword modifier", (double) reach, Operation.MULTIPLY_TOTAL));
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

	public Pickaxe rebuildWith(Attribute attribute, UUID id, String modifiername, double value, Operation valuetype)
	{
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.putAll(modifiers);
		builder.put(attribute, new AttributeModifier(id, modifiername, value, valuetype));
		modifiers = builder.build();
		return this;
	}

	public Pickaxe element(Element element)
	{
		this.element = element;
		return this;
	}

	@Override
	public Element getElement()
	{
		return element != null ? element : IHasElement.super.getElement();
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
		return state.getMaterial()== Material.IRON && state.getMaterial()== Material.ANVIL && state.getMaterial()== Material.ROCK ? super.getDestroySpeed(stack, state) : this.efficiency;

	}

	@Override
	public boolean canHarvestBlock(BlockState state)
	{
		int i = this.getTier().getHarvestLevel();
		if (state.getHarvestTool() == net.minecraftforge.common.ToolType.PICKAXE) {
			return i >= state.getHarvestLevel();
		}
		return state.getMaterial() == Material.ROCK || state.getMaterial() == Material.IRON || state.getMaterial() == Material.ANVIL;
	}

	public Pickaxe addInfo(String... newInfo) {
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