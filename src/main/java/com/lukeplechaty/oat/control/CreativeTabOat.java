package com.lukeplechaty.oat.control;
import com.lukeplechaty.oat.setItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
public final class CreativeTabOat extends CreativeTabs
{
	public CreativeTabOat()
	{
		super("oat");
	}
	@Override
	public Item getTabIconItem()
	{
		return setItems.chisel_gold;
	}
}
