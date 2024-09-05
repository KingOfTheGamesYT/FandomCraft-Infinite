package com.devmaster1015.fandomcraft.util;

import java.util.Arrays;
import java.util.List;

public class Elements
{
	public static Element None = new Element("None");
	public static Element Fire = new Element("Fire");
	public static Element Water = new Element("Water");
	public static Element Wind = new Element("Wind");
	public static Element Earth = new Element("Earth");
	public static Element Dark = new Element("Dark");
	public static Element Light = new Element("Light");
	public static Element Lightning = new Element("Lightning");
	public static Element Ice = new Element("Ice");
	public static Element Poison = new Element("Poison");
	public static Element Life = new Element("Life");
	public static Element Dragon = new Element("Dragon");

	public static void pre()
	{
		None.weakVS().strongVS();
		Fire.weakVS(Water, Dragon).strongVS(Earth, Ice, Poison);
		Water.weakVS(Dragon).strongVS(Fire, Earth);
		Wind.weakVS(Dragon).strongVS(Water, Fire);
		Earth.weakVS(Wind, Dragon).strongVS(Water, Fire, Poison);
		Dark.weakVS(Dark).strongVS(Light, Life);
		Light.weakVS(Light).strongVS(Dark, Dragon);
		Lightning.weakVS(Earth).strongVS(Water, Wind, Dragon);
		Ice.weakVS(Water, Fire).strongVS(Earth, Dragon);
		Poison.weakVS(Fire, Dragon).strongVS(Water, Wind, Earth, Life);
		Life.weakVS(Dragon).strongVS(Poison);
		Dragon.weakVS(Lightning).strongVS(Dragon, None);
	}

	private static String getTooltipText(List<Element> list)
	{
		StringBuilder sb = new StringBuilder();
		for (Element e : list)
		{
			sb.append(e.getName() + ", ");
		}
		sb.substring(0, sb.length() - 2);
		return sb.toString();
	}

	public static class Element
	{
		private List<Element> weakvs, strongvs;
		private String weakvstag, strongvstag;
		private String name;

		public Element(String name)
		{
			this.name = name;
		}

		public Element weakVS(Element... elements)
		{
			this.weakvs = Arrays.asList(elements);
			this.weakvstag = elements.length > 0 ? getTooltipText(weakvs) : "";
			return this;
		}

		public Element strongVS(Element... elements)
		{
			this.strongvs = Arrays.asList(elements);
			this.strongvstag = elements.length > 0 ? getTooltipText(strongvs) : "";
			return this;
		}

		public String getName()
		{
			return name;
		}

		public String getWeakVSText()
		{
			return weakvstag;
		}

		public String getStrongVSText()
		{
			return strongvstag;
		}

		public List<Element> getElementsWeakVS()
		{
			return weakvs;
		}

		public List<Element> getElementsStrongVS()
		{
			return strongvs;
		}
	}
}