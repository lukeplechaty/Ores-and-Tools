package com.lukeplechaty.ores;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
public class OresRegister
{
	public static void register()
	{
		if(Ores.debug)System.out.println("adding to OreDictionary");
		
		OresControl.addOre("oreFossils",new ItemStack(Ores.ore,1,0));
		OresControl.addOre("oreSaltpeter",new ItemStack(Ores.ore,1,1));
		OresControl.addOre("oreSulfur",new ItemStack(Ores.ore,1,2));
		OresControl.addOre("oreSlime",new ItemStack(Ores.ore,1,3));
		
		OresControl.addOre("seedFlax",new ItemStack(Ores.ore,1,0));
		OresControl.addOre("chunkSaltpeter",new ItemStack(Ores.items,1,1));
		OresControl.addOre("chunkSulfur",new ItemStack(Ores.items,1,2));
		OresControl.addOre("dustSaltpeter",new ItemStack(Ores.items,1,3));
		OresControl.addOre("dustSulfur",new ItemStack(Ores.items,1,4));
		OresControl.addOre("dustCharcoal",new ItemStack(Ores.items,1,5));
		
		OresControl.addOre("oreIron",new ItemStack(Ores.items,1,6));
		OresControl.addOre("oreGold",new ItemStack(Ores.items,1,7));
		OresControl.addOre("oreTin",new ItemStack(Ores.items,1,8));
		OresControl.addOre("oreCopper",new ItemStack(Ores.items,1,9));
		OresControl.addOre("oreSilver",new ItemStack(Ores.items,1,10));
		OresControl.addOre("oreLead",new ItemStack(Ores.items,1,11));
		OresControl.addOre("oreNickel",new ItemStack(Ores.items,1,12));
		OresControl.addOre("orePlatinum",new ItemStack(Ores.items,1,13));
		OresControl.addOre("oreAluminum",new ItemStack(Ores.items,1,14));

		OresControl.addOre("ingotTin",new ItemStack(Ores.items,1,15));
		OresControl.addOre("ingotCopper",new ItemStack(Ores.items,1,16));
		OresControl.addOre("ingotSilver",new ItemStack(Ores.items,1,17));
		OresControl.addOre("ingotLead",new ItemStack(Ores.items,1,18));
		OresControl.addOre("ingotNickel",new ItemStack(Ores.items,1,19));
		OresControl.addOre("ingotPlatinum",new ItemStack(Ores.items,1,20));
		OresControl.addOre("ingotAluminum",new ItemStack(Ores.items,1,21));
		
		if(Ores.debug)System.out.println("OreDictionary added");
	}
}