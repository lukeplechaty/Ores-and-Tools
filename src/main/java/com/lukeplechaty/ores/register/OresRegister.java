package com.lukeplechaty.ores.register;
import com.lukeplechaty.ores.Ores;
import com.lukeplechaty.ores.control.OresControl;
import net.minecraft.item.ItemStack;
public class OresRegister
{
	public static void register()
	{
		if(Ores.debug)System.out.println("adding to OreDictionary");
		
		OresControl.addOre("oreFossils",new ItemStack(Ores.ore,1,0));
		OresControl.addOre("oreSaltpeter",new ItemStack(Ores.ore,1,1));
		OresControl.addOre("oreSulfur",new ItemStack(Ores.ore,1,2));

		OresControl.addOre("seed",new ItemStack(Ores.items,1,0));
		OresControl.addOre("seedFlax",new ItemStack(Ores.items,1,0));
		OresControl.addOre("chunkSaltpeter",new ItemStack(Ores.items,1,1));
		OresControl.addOre("chunkSulfur",new ItemStack(Ores.items,1,2));
		
		OresControl.addOre("dustSaltpeter",new ItemStack(Ores.dusts,1,0));
		OresControl.addOre("dustSulfur",new ItemStack(Ores.dusts,1,1));
		OresControl.addOre("dustCharcoal",new ItemStack(Ores.dusts,1,2));
		OresControl.addOre("dustIron",new ItemStack(Ores.dusts,1,3));
		OresControl.addOre("dustGold",new ItemStack(Ores.dusts,1,4));
		OresControl.addOre("dustTin",new ItemStack(Ores.dusts,1,5));
		OresControl.addOre("dustCopper",new ItemStack(Ores.dusts,1,6));
		OresControl.addOre("dustSilver",new ItemStack(Ores.dusts,1,7));
		OresControl.addOre("dustLead",new ItemStack(Ores.dusts,1,8));
		OresControl.addOre("dustNickel",new ItemStack(Ores.dusts,1,9));
		OresControl.addOre("dustPlatinum",new ItemStack(Ores.dusts,1,10));
		OresControl.addOre("dustAluminum",new ItemStack(Ores.dusts,1,11));
		
		OresControl.addOre("oreIron",new ItemStack(Ores.chunks,1,0));
		OresControl.addOre("oreGold",new ItemStack(Ores.chunks,1,1));
		OresControl.addOre("oreTin",new ItemStack(Ores.chunks,1,2));
		OresControl.addOre("oreCopper",new ItemStack(Ores.chunks,1,3));
		OresControl.addOre("oreSilver",new ItemStack(Ores.chunks,1,4));
		OresControl.addOre("oreLead",new ItemStack(Ores.chunks,1,5));
		OresControl.addOre("oreNickel",new ItemStack(Ores.chunks,1,6));
		OresControl.addOre("orePlatinum",new ItemStack(Ores.chunks,1,7));
		OresControl.addOre("oreAluminum",new ItemStack(Ores.chunks,1,8));

		OresControl.addOre("ingotTin",new ItemStack(Ores.ingots,1,0));
		OresControl.addOre("ingotCopper",new ItemStack(Ores.ingots,1,1));
		OresControl.addOre("ingotSilver",new ItemStack(Ores.ingots,1,2));
		OresControl.addOre("ingotLead",new ItemStack(Ores.ingots,1,3));
		OresControl.addOre("ingotNickel",new ItemStack(Ores.ingots,1,4));
		OresControl.addOre("ingotPlatinum",new ItemStack(Ores.ingots,1,5));
		OresControl.addOre("ingotAluminum",new ItemStack(Ores.ingots,1,6));
		
		if(Ores.debug)System.out.println("OreDictionary added");
	}
}