package com.devmaster1015.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class FBlock extends Block {
	protected int xpdropped;

	protected String name;
	private String[] info = new String[0];


	public FBlock(String name, Material material, int harvestlevel, ToolType harvesttool, int xpdropped) {
		this(name, material, harvestlevel, harvesttool, 1 + harvestlevel, 1 + harvestlevel, xpdropped);

	}

	@Override
	public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
		if (xpdropped == 0) {
			return 0;
		}

		int min = (int) (xpdropped * 0.667);
		int max = (int) (xpdropped * 1.5);
		return silktouch == 0 ? new Random().nextInt(max - min) + min : 0;
	}

	public FBlock(String name, Material material, int harvestlevel, ToolType harvesttool, float hardness, float resistance, int xpdroped) {
		this(name, Properties.create(material).harvestLevel(harvestlevel).harvestTool(harvesttool).hardnessAndResistance(hardness, resistance), xpdroped);
	}

	public FBlock(String name, Properties properties, int xpdropped) {
		super(properties);
		this.name = name;
		this.xpdropped = xpdropped;

	}

	public FBlock addInfo(String... newInfo) {
		if (newInfo != null && newInfo.length > 0) {
			String[] combinedInfo = new String[this.info.length + newInfo.length];
			System.arraycopy(this.info, 0, combinedInfo, 0, this.info.length);
			System.arraycopy(newInfo, 0, combinedInfo, this.info.length, newInfo.length);
			this.info = combinedInfo;
		}
		return this;
	}

	@Override
	public void addInformation(ItemStack stack, IBlockReader world, List<ITextComponent> list, ITooltipFlag advanced) {
        for (String s : info) {
            list.add(new StringTextComponent(s));
        }
    }
}
