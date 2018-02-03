package com.lukeplechaty.oat.control;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class CreativeTabOat extends CreativeTabs
{
	Item item;
	public CreativeTabOat(String name)
	{
		super(name);
	}
	
	public void setItem(Item item)
	{
		this.item = item;
	}
	
	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(item);
	}
}
