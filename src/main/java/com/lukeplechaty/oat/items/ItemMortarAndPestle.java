package com.lukeplechaty.oat.items;
import com.lukeplechaty.oat.setTabs;
import net.minecraft.item.Item;

public class ItemMortarAndPestle extends Item
{
	public ItemMortarAndPestle(String name)
	{
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(setTabs.tabItems);
		maxStackSize = 1;
		setMaxDamage(180);
	}
}
