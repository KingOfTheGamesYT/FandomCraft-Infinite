package com.devmaster1015.fandomcraft.items;

import com.devmaster1015.fandomcraft.main.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class Rupee extends Item
{
	protected String name;
	private String[] info = new String[0];

	public Rupee(String name, int stacksize, ItemGroup group, Rarity rarity)
	{
		this(name, get(stacksize, group, rarity));
	}

	public Rupee(String name, ItemGroup group, Rarity rarity)
	{
		this(name, get(64, group, rarity));
	}

	public Rupee(String name, int stacksize, ItemGroup group)
	{
		this(name, get(stacksize, group, Rarity.COMMON));
	}

	public Rupee(String name, ItemGroup group)
	{
		this(name, get(64, group, Rarity.COMMON));
	}

	public Rupee(String name, Properties p)
	{
		super(p);
		this.name = name;
	}

	protected static final Properties get(int stacksize, ItemGroup group, Rarity rarity)
	{
		return new Properties().maxStackSize(stacksize).group(group).rarity(rarity);
	}

	public Rupee addInfo(String... newInfo) {
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
}
