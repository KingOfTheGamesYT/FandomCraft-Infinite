package com.devmaster1015.fandomcraft.util;
import com.devmaster1015.fandomcraft.util.Elements.Element;


public interface IHasElement
{
	public default Element getElement()
	{
		return Elements.None;
	}
}
