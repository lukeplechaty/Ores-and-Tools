package com.lukeplechaty.oat.items;
import com.lukeplechaty.oat.Ores;
import net.minecraft.item.Item;
public class Itemmortarandpestle extends Item
{
	public Itemmortarandpestle(String name)
	{
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Ores.tabOres);
		maxStackSize=1;
		setMaxDamage(180);
	}
}
