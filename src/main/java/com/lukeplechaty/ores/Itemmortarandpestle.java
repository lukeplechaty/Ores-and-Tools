package com.lukeplechaty.ores;
import net.minecraft.item.Item;
public class Itemmortarandpestle extends Item
{
	public Itemmortarandpestle()
	{
		super();
		if(Ores.debug)System.out.println("adding mortarandpestle");
		setUnlocalizedName("mortarandpestle");
		setTextureName("ores:mortarandpestle");
		setCreativeTab(Ores.tabOres);
		maxStackSize=1;
		setMaxDamage(180);
	}
}
