package com.lukeplechaty.oat.control;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
/**
 * ChislHandler let you add recipe the the Chisl.
 */
public class ChislHandler
{
	private static List<Object> worklist0=new ArrayList<Object>();
	private static List<Object> worklist1=new ArrayList<Object>();
	private static List<Object> worklist2=new ArrayList<Object>();
	private static List<Object> worklist3=new ArrayList<Object>();
	/**
	 * A block in and itemstack out sensitive version of adding a chisl recipe.
	 * @param
	 */
	public static void addtolist(Block in,int meta,ItemStack out,ItemStack left,int toollevel)
	{
		Object list=new Object[]{in,meta,out,left,toollevel};
		worklist0.add(list);
	}
	/**
	 * A block in and string out sensitive version of adding a chisl recipe.
	 * @param
	 */
	public static void addtolist(Block in,int meta,String out,int stackSize,ItemStack left,int toollevel)
	{
		Object list=new Object[]{in,meta,out,stackSize,left,toollevel};
		worklist2.add(list);
	}
	/**
	 * A string in and itemstack out sensitive version of adding a chisl recipe.
	 * @param
	 */
	public static void addtolist(String in,ItemStack out,ItemStack left,int toollevel)
	{
		Object list=new Object[]{in,out,left,toollevel};
		worklist3.add(list);
	}
	/**
	 * A string in and string out sensitive version of adding a chisl recipe.
	 * @param
	 */
	public static void addtolist(String in,String out,int stackSize,ItemStack left,int toollevel)
	{
		Object list=new Object[]{in,out,stackSize,left,toollevel};
		worklist1.add(list);
	}
	public static List<Object> getlist0()
	{
		return worklist0;
	}
	public static List<Object> getlist1()
	{
		return worklist1;
	}
	public static List<Object> getlist2()
	{
		return worklist2;
	}
	public static List<Object> getlist3()
	{
		return worklist3;
	}
}
