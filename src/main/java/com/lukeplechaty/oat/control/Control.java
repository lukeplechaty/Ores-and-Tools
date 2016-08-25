package com.lukeplechaty.oat.control;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
public class Control
{
	public static void addOre(String string,ItemStack itemstack)
	{
		OreDictionary.registerOre(string,itemstack);
	}
	public static boolean getOre(Block block,int meta,BlockPos pos,World world)
	{
		if(world.getBlockState(pos).getBlock()==block&&world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos))==meta) return true;
		return false;
	}
	public static boolean getOre(String string,BlockPos pos,World world)
	{
		List<ItemStack> list=OreDictionary.getOres(string);
		for(int num=0;num<list.size();num++)
		{
			ItemStack ore=list.get(num);
			if(world.getBlockState(pos).getBlock()==Block.getBlockFromItem(ore.getItem())&&world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos))==ore.getItemDamage()) return true;
		}
		return false;
	}
	public static ItemStack getOre(String string,int stackSize)
	{
		return new ItemStack(ID(string),stackSize,Meta(string));
	}
	public static Block ID(String string)
	{
		String[] run=OreDictionary.getOreNames();
		for(int number=0;number<run.length;number++)
		{
			if(string==run[number])
			{
				List<ItemStack> ID=OreDictionary.getOres(string);
				return Block.getBlockFromItem(ID.get(0).getItem());
			}
		}
		return null;
	}
	public static int Meta(String string)
	{
		String[] run=OreDictionary.getOreNames();
		for(int number=0;number<run.length;number++)
		{
			if(string==run[number])
			{
				List<ItemStack> Meta=OreDictionary.getOres(string);
				return Meta.get(0).getItemDamage();
			}
		}
		return -1;
	}
}