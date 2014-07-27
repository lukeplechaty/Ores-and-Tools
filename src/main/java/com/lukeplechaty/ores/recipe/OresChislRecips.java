package com.lukeplechaty.ores.recipe;
import com.lukeplechaty.ores.Ores;
import com.lukeplechaty.ores.control.ChislHandler;
import net.minecraft.block.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
public class OresChislRecips
{
	static Block block;
	static Item item;
	static Block cobble=Blocks.cobblestone;
	public static void recipe()
	{
		if(Ores.debug)System.out.println("adding chisl recipe");
		try
		{
			ChislHandler.addtolist("oreCoal",new ItemStack(Items.coal,1,0),new ItemStack(cobble),1);
			ChislHandler.addtolist("oreDiamond",new ItemStack(Items.diamond,1,0),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreEmerald",new ItemStack(Items.emerald,1,0),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreLapis",new ItemStack(Items.dye,5,4),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreRedstone",new ItemStack(Items.redstone,5,0),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreQuartz",new ItemStack(Items.quartz,1,0),new ItemStack(Blocks.netherrack),1);
			
			ChislHandler.addtolist("oreFossils",new ItemStack(Items.bone,2,0),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreSaltpeter",new ItemStack(Ores.items,3,1),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreSulfur",new ItemStack(Ores.items,3,2),new ItemStack(cobble),2);
			
			ChislHandler.addtolist("oreIron",new ItemStack(Ores.chunks,1,0),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreGold",new ItemStack(Ores.chunks,1,1),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreTin",new ItemStack(Ores.chunks,1,2),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreCopper",new ItemStack(Ores.chunks,1,3),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreSilver",new ItemStack(Ores.chunks,1,4),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreLead",new ItemStack(Ores.chunks,1,5),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreNickel",new ItemStack(Ores.chunks,1,6),new ItemStack(cobble),3);
			ChislHandler.addtolist("orePlatinum",new ItemStack(Ores.chunks,1,7),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreAluminum",new ItemStack(Ores.chunks,1,8),new ItemStack(cobble),3);
			
			ChislHandler.addtolist("oreCertusQuartz","crystalCertusQuartz",new ItemStack(cobble),2);
			ChislHandler.addtolist("oreSapphire","gemSapphire",new ItemStack(cobble),2);
			ChislHandler.addtolist("oreRuby","gemRuby",new ItemStack(cobble),2);
			ChislHandler.addtolist("orePeridot","gemPeridot",new ItemStack(cobble),2);
			
			ChislHandler.addtolist(new ItemStack(Blocks.brick_block),new ItemStack(Items.brick,4),new ItemStack(Blocks.air),3);
			ChislHandler.addtolist(new ItemStack(Blocks.ice),new ItemStack(Blocks.ice),new ItemStack(Blocks.air),3);
			ChislHandler.addtolist(new ItemStack(Blocks.glass),new ItemStack(Blocks.glass),new ItemStack(Blocks.air),1);
			ChislHandler.addtolist(new ItemStack(Blocks.glass_pane),new ItemStack(Blocks.glass_pane),new ItemStack(Blocks.air),1);
			for(int a=-1;a<16;a++)
			{
				ChislHandler.addtolist(new ItemStack(Blocks.stained_glass,1,a),new ItemStack(Blocks.stained_glass,1,a),new ItemStack(Blocks.air,0),1);
				ChislHandler.addtolist(new ItemStack(Blocks.stained_glass_pane,1,a),new ItemStack(Blocks.stained_glass_pane,1,a),new ItemStack(Blocks.air,0),1);
			}
		}
		catch(Exception e){System.out.println("Chisl recipe not working: "+e);}
		if(Ores.debug)System.out.println("chisl recipe added");
	}
}