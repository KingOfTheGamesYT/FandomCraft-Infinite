package com.devmaster1015.fandomcraft.items.itemtypes;

import com.devmaster1015.fandomcraft.main.FandomCraft;
import com.devmaster1015.fandomcraft.main.events.ArmourEvents;
import com.devmaster1015.fandomcraft.util.Elements;
import com.devmaster1015.fandomcraft.util.IHasElement;
import com.devmaster1015.fandomcraft.main.events.ArmourEvents.EventType;
import com.devmaster1015.fandomcraft.util.Elements.Element;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.UUID;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.world.World;

import net.minecraftforge.common.ForgeMod;

public class Armour extends ArmorItem implements IHasElement
{
	protected static final UUID[] SLOT_ID = new UUID[]
	{
			UUID.fromString("16978b34-e8de-48bb-9657-c142422c05e7"),
			UUID.fromString("87ed54a8-3dc5-44c9-a958-beb7c5b18ecf"),
			UUID.fromString("5471d8c4-5319-4101-9e56-9db077922ccd"),
			UUID.fromString("3bf6e6a0-f0ac-4879-9fb2-d800ddcbe348")
	};
	protected static final UUID MOVEMENT_SPEED = UUID.fromString("27dcaf71-b083-459a-8eca-6d937b129e0d");
	protected static final UUID SWIM_SPEED = UUID.fromString("8cce4d68-479d-4954-8349-10ac59a6a681");
	protected static final UUID GRAVITY = UUID.fromString("3010c57e-d8ba-40d8-bf18-8ae81cde244f");
	protected static final UUID SWING_SPEED = UUID.fromString("cac0fc03-0541-4c70-8266-1955ee5e0c6e");
	protected ArmourEvents event;
	protected Multimap<Attribute, AttributeModifier> modifiers;
	protected String[] info, setbonus;
	protected float movespeed, swimspeed, gravity;
	protected float swingspeed;
	protected int setid = -1, setpieces = 1;
	protected Elements.Element element;

	public Armour(IArmorMaterial material, EquipmentSlotType slot, Rarity rarity)
	{
		super(material, slot, get(rarity));
		this.element = Elements.None;
		setModifiers(slot);
	}

	public Armour element(Element element)
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
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean currentlyheld)
	{
		if (event != null && event.getEventType() == EventType.Auto && entity instanceof PlayerEntity)
		{
			PlayerEntity player = (PlayerEntity) entity;
			int pieces = getEquippedSetPieces(player);

			if (pieces >= setpieces && event.getCondition().test(player, null, null, stack))
			{
				event.getAction().accept(player, null, null, stack);
			}
		}
	}

	protected int getEquippedSetPieces(PlayerEntity player)
	{
		int pieces = 0;
		for (ItemStack piece : player.getArmorInventoryList())
		{
			if (piece.getItem() instanceof Armour && ((Armour) piece.getItem()).getSetID() == setid)
			{
				++pieces;
			}
		}
		return pieces;
	}

	public Armour addBonusInfo(String... s)
	{
		this.setbonus = s;
		return this;
	}

	public Armour isSet(int id, int requiredpieces)
	{
		this.setid = id;
		this.setpieces = requiredpieces;
		return this;
	}

	public int getSetID()
	{
		return setid;
	}

	public Armour addEffect(ArmourEvents event)
	{
		if (event.getEventType() == EventType.Auto)
		{
			this.event = event;
		}
		else
		{
			ArmourEvents.addEvent(event);
		}
		return this;
	}

	public Armour setModifiers(EquipmentSlotType slot)
	{
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		UUID id = SLOT_ID[slot.getIndex()];
		builder.put(Attributes.ARMOR, new AttributeModifier(id, "Armor modifier", (double) material.getDamageReductionAmount(slot), AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(id, "Armor toughness", (double) material.getToughness(), AttributeModifier.Operation.ADDITION));
		if (material.getKnockbackResistance() != 0)
		{
			builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(id, "Armor knockback resistance", (double) material.getKnockbackResistance(), AttributeModifier.Operation.ADDITION));
		}
		modifiers = builder.build();
		return this;
	}

	public Armour setMoveSpeed(float f)
	{
		movespeed = f;
		return this;
	}

	public Armour setSwimSpeed(float f)
	{
		swimspeed = f;
		return this;
	}

	public Armour setGravity(float f)
	{
		gravity = f;
		return this;
	}

	public Armour setSwingSpeed(float f)
	{
		swingspeed = f;
		return this;
	}

	public Armour rebuildWith(Attribute attribute, UUID id, String modifiername, double value, Operation valuetype)
	{
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.putAll(modifiers);
		builder.put(attribute, new AttributeModifier(id, modifiername, value, valuetype));
		modifiers = builder.build();
		return this;
	}

	public Armour rebuild()
	{
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.putAll(modifiers);
		if (swingspeed != 0)
		{
			builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(SWING_SPEED, "Armour modifier", (double) swingspeed, AttributeModifier.Operation.MULTIPLY_TOTAL));
		}
		if (movespeed != 0)
		{
			builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(MOVEMENT_SPEED, "Armour modifier", (double) movespeed, AttributeModifier.Operation.MULTIPLY_TOTAL));
		}
		if (swimspeed != 0)
		{
			builder.put(ForgeMod.SWIM_SPEED.get(), new AttributeModifier(SWIM_SPEED, "Armour modifier", (double) swimspeed, AttributeModifier.Operation.MULTIPLY_TOTAL));
		}
		if (gravity != 0)
		{
			builder.put(ForgeMod.ENTITY_GRAVITY.get(), new AttributeModifier(GRAVITY, "Armour modifier", (double) gravity, AttributeModifier.Operation.MULTIPLY_TOTAL));
		}
		modifiers = builder.build();

		for (Entry<Attribute, Collection<AttributeModifier>> entry : modifiers.asMap().entrySet())
		{
			FandomCraft.dev(getRegistryName() + " [" + entry.getKey().getRegistryName() + "] modifiers :");
			for (AttributeModifier m : entry.getValue())
			{
				FandomCraft.dev("    > [" + m.getName() + "] " + m.getAmount());
			}
		}
		return this;
	}

	protected static final Properties get(Rarity rarity)
	{
		return new Properties().maxStackSize(1).group(FandomCraft.tabFandomCraftMisc).rarity(rarity);
	}

	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot)
	{
		return slot == this.slot ? modifiers : super.getAttributeModifiers(slot);
	}
}