package com.lukeplechaty.ores;
import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
public class OresControl
{
	public static void name()
	{
		if(Ores.debug)
		{
			System.out.println("ores names");
			String[] run=OreDictionary.getOreNames();
			for(int number=0;number<run.length;number++)System.out.println(run[number]);
		}
		if(Ores.debug)System.out.println("that all the ores names");
	}
	/*public static int list(String s,int x,int y,int z,World w)
	{
		ArrayList<ItemStack> c=OreDictionary.getOres(s);
		for(int d=0;d<c.size();d++)
		{
			if(c.get(d).itemID==w.getBlockId(x,y,z))
			return d;
		}
		return -1;
	}
	public static int ID(String s,int x,int y,int z,World w)
	{
		String[] run=OreDictionary.getOreNames();
		for(int b=0;b<run.length;b++)
		{
			if(s==run[b])
			{
				ArrayList<ItemStack> c=OreDictionary.getOres(s);
				int a=list(s,x,y,z,w);
				return c.get(a).itemID;
			}
		}
		return -1;
	}
	public static int Meta(String s,int x,int y,int z,World w)
	{
		String[] run=OreDictionary.getOreNames();
		for(int b=0;b<run.length;b++)
		{
			if(s==run[b])
			{
				ArrayList<ItemStack> c=OreDictionary.getOres(s);
				int a=list(s,x,y,z,w);
				return c.get(a).getItemDamage();
			}
		}
		return -1;
	}*/
	public static Block ID(String string)
	{
		if(Ores.debug)System.out.println("ID string: "+string);
		String[] run=OreDictionary.getOreNames();
		for(int number=0;number<run.length;number++)
		{
			if(string==run[number])
			{
				ArrayList<ItemStack> ID=OreDictionary.getOres(string);
				return Block.getBlockFromItem(ID.get(0).getItem());
			}
		}
		return null;
	}
	public static int Meta(String string)
	{
		if(Ores.debug)System.out.println("Meta string: "+string);
		String[] run=OreDictionary.getOreNames();
		for(int number=0;number<run.length;number++)
		{
			if(string==run[number])
			{
				ArrayList<ItemStack> Meta=OreDictionary.getOres(string);
				return Meta.get(0).getItemDamage();
			}
		}
		return -1;
	}
	public static void addOre(String string, ItemStack itemstack)
	{
		if(Ores.debug)System.out.println("addOre string,itemstack: "+string+" "+itemstack);
		OreDictionary.registerOre(string,itemstack);
	}
	public static boolean getOre(String string,int x,int y,int z,World world)
	{
		if(Ores.debug)System.out.println("getOre string,x,y,z,world: "+string+" "+x+" "+y+" "+z+" "+world);
		ArrayList<ItemStack> list=OreDictionary.getOres(string);
		for(int num=0;num<list.size();num++)
		{
			ItemStack ore=list.get(num);
			if(world.getBlock(x,y,z)==Block.getBlockFromItem(ore.getItem())&&world.getBlockMetadata(x,y,z)==ore.getItemDamage())return true;
		}
		return false;
	}
	public static boolean getOre(ItemStack item,int x,int y,int z,World world)
	{
		if(Ores.debug)System.out.println("getOre itemstack,x,y,z,world: "+item+" "+x+" "+y+" "+z+" "+world);
		if(world.getBlock(x,y,z)==Block.getBlockFromItem(item.getItem())&&world.getBlockMetadata(x,y,z)==item.getItemDamage())return true;
		return false;
	}
	public static ItemStack getOre(String string)
	{
		return new ItemStack(ID(string),1,Meta(string));
	}
}