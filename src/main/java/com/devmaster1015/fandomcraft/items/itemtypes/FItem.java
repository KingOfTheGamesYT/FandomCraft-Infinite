package com.devmaster1015.fandomcraft.items.itemtypes;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class FItem extends Item
{
	protected String name;
	protected String[] info;

	public FItem(String name, int stacksize, ItemGroup group, Rarity rarity)
	{
		this(name, get(stacksize, group, rarity));
	}

	public FItem(String name, ItemGroup group, Rarity rarity)
	{
		this(name, get(64, group, rarity));
	}

	public FItem(String name, int stacksize, ItemGroup group)
	{
		this(name, get(stacksize, group, Rarity.COMMON));
	}

	public FItem(String name, ItemGroup group)
	{
		this(name, get(64, group, Rarity.COMMON));
	}

	public FItem(String name, Properties p)
	{
		super(p);
		this.name = name;
	}

	public FItem addInfo(String... info)
	{
		if (this.info == null)
		{
			this.info = info;
		}
		else
		{
			String[] newinfo = new String[this.info.length + info.length];
			int i = 0;
			for (String s : this.info)
			{
				newinfo[i] = s;
				++i;
			}
			for (String s : info)
			{
				newinfo[i] = s;
				++i;
			}
		}
		return this;
	}

	protected static final Properties get(int stacksize, ItemGroup group, Rarity rarity)
	{
		return new Properties().maxStackSize(stacksize).group(group).rarity(rarity);
	}


	public ITextComponent getName(ItemStack stack)
	{
		return new StringTextComponent(name);
	}


	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag advanced)
	{
		if (info != null)
		{
			for (String s : info)
			{
				list.add(new StringTextComponent(s));
			}
		}
	}
}
