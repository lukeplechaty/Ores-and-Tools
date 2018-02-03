package com.lukeplechaty.oat;

import com.lukeplechaty.oat.control.CreativeTabOat;
import net.minecraft.creativetab.CreativeTabs;

public class setTabs
{
	public static final CreativeTabs tabOres = new CreativeTabOat("ores");
	public static final CreativeTabs tabItems = new CreativeTabOat("items");
	public static final CreativeTabs tabTools = new CreativeTabOat("tools");
	
	public static void init()
	{
		((CreativeTabOat)tabOres).setItem(setItems.item_rock);
		((CreativeTabOat)tabItems).setItem(setItems.mortar_and_pestle);
		((CreativeTabOat)tabTools).setItem(setItems.chisel_gold);
	}
}
