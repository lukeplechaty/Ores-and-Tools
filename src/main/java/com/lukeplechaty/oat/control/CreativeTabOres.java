package com.lukeplechaty.oat.control;
import com.lukeplechaty.oat.setItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
public final class CreativeTabOres extends CreativeTabs
{
	public CreativeTabOres()
	{
		super("Ores and Tools");
	}
	@Override
	public Item getTabIconItem()
	{
		return setItems.chiselgold;
	}
}
