package com.lukeplechaty.oat.control;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ChislParts
{
	public Block blockin, left;
	public ItemStack itemstackOut;
	public String stringIn, stringOut;
	public int meta, stackSize, toollevel;
	
	ChislParts()
	{}
	
	ChislParts addParts(Block in, int meta, ItemStack out, Block left, int toollevel)
	{
		this.blockin = in;
		this.meta = meta;
		this.itemstackOut = out;
		this.left = left;
		this.toollevel = toollevel;
		return this;
	}
	
	ChislParts addParts(Block in, int meta, String out, int stackSize, Block left, int toollevel)
	{
		this.blockin = in;
		this.meta = meta;
		this.stringOut = out;
		this.stackSize = stackSize;
		this.left = left;
		this.toollevel = toollevel;
		return this;
	}
	
	ChislParts addParts(String in, ItemStack out, Block left, int toollevel)
	{
		this.stringIn = in;
		this.itemstackOut = out;
		this.left = left;
		this.toollevel = toollevel;
		return this;
	}
	
	ChislParts addParts(String in, String out, int stackSize, Block left, int toollevel)
	{
		this.stringIn = in;
		this.stringOut = out;
		this.stackSize = stackSize;
		this.left = left;
		this.toollevel = toollevel;
		return this;
	}
}
