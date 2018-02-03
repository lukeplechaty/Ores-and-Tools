package com.lukeplechaty.oat.control;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/**
 * ChislHandler let you add recipe the the Chisl.
 */
public class ChislHandler
{
	private static List<ChislParts> worklist0 = new LinkedList<>();
	private static List<ChislParts> worklist1 = new LinkedList<>();
	private static List<ChislParts> worklist2 = new LinkedList<>();
	private static List<ChislParts> worklist3 = new LinkedList<>();
	
	/**
	 * A block in and itemstack out sensitive version of adding a chisl recipe.
	 * @param
	 */
	public static void addtolist(Block in, int meta, ItemStack out, Block left, int toollevel)
	{
		worklist0.add(new ChislParts().addParts(in, meta, out, left, toollevel));
	}
	
	/**
	 * A block in and string out sensitive version of adding a chisl recipe.
	 * @param
	 */
	public static void addtolist(Block in, int meta, String out, int stackSize, Block left, int toollevel)
	{
		worklist2.add(new ChislParts().addParts(in, meta, out, stackSize, left, toollevel));
	}
	
	/**
	 * A string in and itemstack out sensitive version of adding a chisl recipe.
	 * @param
	 */
	public static void addtolist(String in, ItemStack out, Block left, int toollevel)
	{
		worklist3.add(new ChislParts().addParts(in, out, left, toollevel));
	}
	
	/**
	 * A string in and string out sensitive version of adding a chisl recipe.
	 * @param
	 */
	public static void addtolist(String in, String out, int stackSize, Block left, int toollevel)
	{
		worklist1.add(new ChislParts().addParts(in, out, stackSize, left, toollevel));
	}
	
	public static List<ChislParts> getlist0()
	{
		return worklist0;
	}
	
	public static List<ChislParts> getlist1()
	{
		return worklist1;
	}
	
	public static List<ChislParts> getlist2()
	{
		return worklist2;
	}
	
	public static List<ChislParts> getlist3()
	{
		return worklist3;
	}
}
