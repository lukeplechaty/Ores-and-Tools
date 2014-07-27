package com.lukeplechaty.ores.blocks;
import java.util.*;
import com.lukeplechaty.ores.Ores;
import net.minecraft.block.Block;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
public class Itemblockore extends ItemBlock
{
	private String[] names=new String[]{"fossils","sodium","sulfur"};
	public Itemblockore(Block id)
	{
		super(id);
		if(Ores.debug)System.out.println("adding block items");
		setUnlocalizedName("ore0");
		setCreativeTab(Ores.tabOres);
		setHasSubtypes(true);
	}
	public void getSubItems(Item id, CreativeTabs creativetabs, List list)
	{
	    for (int meta=0;meta<names.length;meta++)
	    {
	        list.add(new ItemStack(this,1,meta));
	    }
	}
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return names[itemstack.getItemDamage()];
	}
	public int getMetadata(int meta)
	{
		return meta;
	}
}