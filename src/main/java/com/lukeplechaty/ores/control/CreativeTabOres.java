package com.lukeplechaty.ores.control;
import com.lukeplechaty.ores.Ores;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
public final class CreativeTabOres extends CreativeTabs
{
    public CreativeTabOres()
    {
        super("ores");
    }
	public Item getTabIconItem()
	{
		return Ores.chiselgold;
	}
}
