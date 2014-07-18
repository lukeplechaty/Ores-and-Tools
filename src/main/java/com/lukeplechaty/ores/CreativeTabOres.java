package com.lukeplechaty.ores;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
final class CreativeTabOres extends CreativeTabs
{
    CreativeTabOres()
    {
        super("ores");
    }
	public Item getTabIconItem()
	{
		return Ores.chiselgold;
	}
}
