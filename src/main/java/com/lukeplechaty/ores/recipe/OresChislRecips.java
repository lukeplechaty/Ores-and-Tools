package com.lukeplechaty.ores.recipe;
import com.lukeplechaty.ores.Ores;
import com.lukeplechaty.ores.control.ChislHandler;
import net.minecraft.block.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
public class OresChislRecips
{
	static Block cobble=Blocks.cobblestone;
	public static void recipe()
	{
		if(Ores.debug)System.out.println("adding chisl recipe");
		try
		{
			ChislHandler.addtolist("oreCoal",new ItemStack(Items.coal,1,0),new ItemStack(cobble),1);
			ChislHandler.addtolist("oreDiamond",new ItemStack(Items.diamond,1,0),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreEmerald",new ItemStack(Items.emerald,1,0),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreLapis",new ItemStack(Items.dye,9,4),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreRedstone",new ItemStack(Items.redstone,6,0),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreQuartz",new ItemStack(Items.quartz,1,0),new ItemStack(Blocks.netherrack),1);
			
			ChislHandler.addtolist("oreIron",new ItemStack(Ores.chunks,1,0),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreGold",new ItemStack(Ores.chunks,1,1),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreTin",new ItemStack(Ores.chunks,1,2),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreCopper",new ItemStack(Ores.chunks,1,3),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreSilver",new ItemStack(Ores.chunks,1,4),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreLead",new ItemStack(Ores.chunks,1,5),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreNickel",new ItemStack(Ores.chunks,1,6),new ItemStack(cobble),3);
			ChislHandler.addtolist("orePlatinum",new ItemStack(Ores.chunks,1,7),new ItemStack(cobble),4);
			ChislHandler.addtolist("oreAluminum",new ItemStack(Ores.chunks,1,8),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreMithril",new ItemStack(Ores.chunks,1,9),new ItemStack(cobble),4);
			ChislHandler.addtolist("oreCobalt",new ItemStack(Ores.chunks,1,10),new ItemStack(Blocks.netherrack),5);
			ChislHandler.addtolist("oreArdite",new ItemStack(Ores.chunks,1,11),new ItemStack(Blocks.netherrack),5);
			ChislHandler.addtolist("oreYellorium",new ItemStack(Ores.chunks,1,12),new ItemStack(cobble),3);
			
			ChislHandler.addtolist("denseoreCoal",new ItemStack(Items.coal,3,0),new ItemStack(cobble),1);
			ChislHandler.addtolist("denseoreDiamond",new ItemStack(Items.diamond,3,0),new ItemStack(cobble),3);
			ChislHandler.addtolist("denseoreEmerald",new ItemStack(Items.emerald,3,0),new ItemStack(cobble),3);
			ChislHandler.addtolist("denseoreLapis",new ItemStack(Items.dye,27,4),new ItemStack(cobble),2);
			ChislHandler.addtolist("denseoreRedstone",new ItemStack(Items.redstone,18,0),new ItemStack(cobble),3);
			ChislHandler.addtolist("denseoreQuartz",new ItemStack(Items.quartz,3,0),new ItemStack(Blocks.netherrack),1);
			
			ChislHandler.addtolist("denseoreIron",new ItemStack(Ores.chunks,3,0),new ItemStack(cobble),2);
			ChislHandler.addtolist("denseoreGold",new ItemStack(Ores.chunks,3,1),new ItemStack(cobble),3);
			ChislHandler.addtolist("denseoreTin",new ItemStack(Ores.chunks,3,2),new ItemStack(cobble),2);
			ChislHandler.addtolist("denseoreCopper",new ItemStack(Ores.chunks,3,3),new ItemStack(cobble),2);
			ChislHandler.addtolist("denseoreSilver",new ItemStack(Ores.chunks,3,4),new ItemStack(cobble),3);
			ChislHandler.addtolist("denseoreLead",new ItemStack(Ores.chunks,3,5),new ItemStack(cobble),3);
			ChislHandler.addtolist("denseoreNickel",new ItemStack(Ores.chunks,3,6),new ItemStack(cobble),3);
			ChislHandler.addtolist("denseorePlatinum",new ItemStack(Ores.chunks,3,7),new ItemStack(cobble),4);
			ChislHandler.addtolist("denseoreAluminum",new ItemStack(Ores.chunks,3,8),new ItemStack(cobble),2);
			ChislHandler.addtolist("denseoreMithril",new ItemStack(Ores.chunks,3,9),new ItemStack(cobble),4);
			ChislHandler.addtolist("denseoreCobalt",new ItemStack(Ores.chunks,3,10),new ItemStack(Blocks.netherrack),5);
			ChislHandler.addtolist("denseoreArdite",new ItemStack(Ores.chunks,3,11),new ItemStack(Blocks.netherrack),5);
			ChislHandler.addtolist("denseoreYellorium",new ItemStack(Ores.chunks,3,12),new ItemStack(cobble),3);
			
			ChislHandler.addtolist("oreFossils",new ItemStack(Items.bone,2,0),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreSaltpeter",new ItemStack(Ores.items,3,1),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreSulfur",new ItemStack(Ores.items,3,2),new ItemStack(cobble),2);
			
			ChislHandler.addtolist("oreCertusQuartz",new ItemStack(Ores.gem,3,0),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreSapphire",new ItemStack(Ores.gem,4,1),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreRuby",new ItemStack(Ores.gem,4,2),new ItemStack(cobble),2);
			ChislHandler.addtolist("orePeridot",new ItemStack(Ores.gem,4,3),new ItemStack(cobble),2);
			
			ChislHandler.addtolist(Blocks.lit_redstone_ore,0,new ItemStack(Items.redstone,6,0),new ItemStack(cobble),3);
			ChislHandler.addtolist(Blocks.brick_block,0,new ItemStack(Items.brick,4),new ItemStack(Blocks.air),3);
			ChislHandler.addtolist(Blocks.nether_brick,0,new ItemStack(Items.netherbrick,4),new ItemStack(Blocks.air),3);
			ChislHandler.addtolist(Blocks.ice,0,new ItemStack(Blocks.ice),new ItemStack(Blocks.air),3);
			ChislHandler.addtolist(Blocks.glass,0,new ItemStack(Blocks.glass),new ItemStack(Blocks.air),1);
			ChislHandler.addtolist(Blocks.glass_pane,0,new ItemStack(Blocks.glass_pane),new ItemStack(Blocks.air),1);
			for(int a=-1;a<16;a++)
			{
				ChislHandler.addtolist(Blocks.stained_glass,a,new ItemStack(Blocks.stained_glass,1,a),new ItemStack(Blocks.air,0),1);
				ChislHandler.addtolist(Blocks.stained_glass_pane,a,new ItemStack(Blocks.stained_glass_pane,1,a),new ItemStack(Blocks.air,0),1);
			}
		}catch(Exception e){System.out.println("Chisl recipe not working: "+e);}
		if(Ores.debug)System.out.println("chisl recipe added");
	}
}