package com.lukeplechaty.oat.recipe;
import com.lukeplechaty.oat.setItems;
import com.lukeplechaty.oat.control.ChislHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
public class OresChislRecips
{
	static Block cobble=Blocks.COBBLESTONE;
	public static void recipe()
	{
		try
		{
			ChislHandler.addtolist("oreCoal",new ItemStack(Items.COAL),new ItemStack(cobble),1);
			ChislHandler.addtolist("oreDiamond",new ItemStack(Items.DIAMOND),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreEmerald",new ItemStack(Items.EMERALD),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreLapis",new ItemStack(Items.DYE,9,4),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreRedstone",new ItemStack(Items.REDSTONE,6),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreQuartz",new ItemStack(Items.QUARTZ),new ItemStack(Blocks.NETHERRACK),1);
			ChislHandler.addtolist("oreIron",new ItemStack(setItems.chunk_iron),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreGold",new ItemStack(setItems.chunk_gold),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreTin",new ItemStack(setItems.chunk_tin),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreCopper",new ItemStack(setItems.chunk_copper),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreSilver",new ItemStack(setItems.chunk_silver),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreLead",new ItemStack(setItems.chunk_lead),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreNickel",new ItemStack(setItems.chunk_nickel),new ItemStack(cobble),3);
			ChislHandler.addtolist("orePlatinum",new ItemStack(setItems.chunk_platinum),new ItemStack(cobble),4);
			ChislHandler.addtolist("oreAluminum",new ItemStack(setItems.chunk_aluminum),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreMithril",new ItemStack(setItems.chunk_mithril),new ItemStack(cobble),4);
			ChislHandler.addtolist("oreCobalt",new ItemStack(setItems.chunk_cobalt),new ItemStack(Blocks.NETHERRACK),5);
			ChislHandler.addtolist("oreArdite",new ItemStack(setItems.chunk_ardite),new ItemStack(Blocks.NETHERRACK),5);
			ChislHandler.addtolist("oreYellorium",new ItemStack(setItems.chunk_yellorium),new ItemStack(cobble),3);
			ChislHandler.addtolist("denseoreCoal",new ItemStack(Items.COAL,3),new ItemStack(cobble),1);
			ChislHandler.addtolist("denseoreDiamond",new ItemStack(Items.DIAMOND,3),new ItemStack(cobble),3);
			ChislHandler.addtolist("denseoreEmerald",new ItemStack(Items.EMERALD,3),new ItemStack(cobble),3);
			ChislHandler.addtolist("denseoreLapis",new ItemStack(Items.DYE,27,4),new ItemStack(cobble),2);
			ChislHandler.addtolist("denseoreRedstone",new ItemStack(Items.REDSTONE,18),new ItemStack(cobble),3);
			ChislHandler.addtolist("denseoreQuartz",new ItemStack(Items.QUARTZ,3),new ItemStack(Blocks.NETHERRACK),1);
			ChislHandler.addtolist("denseoreIron",new ItemStack(setItems.chunk_iron),new ItemStack(cobble),2);
			ChislHandler.addtolist("denseoreGold",new ItemStack(setItems.chunk_gold),new ItemStack(cobble),3);
			ChislHandler.addtolist("denseoreTin",new ItemStack(setItems.chunk_tin),new ItemStack(cobble),2);
			ChislHandler.addtolist("denseoreCopper",new ItemStack(setItems.chunk_copper),new ItemStack(cobble),2);
			ChislHandler.addtolist("denseoreSilver",new ItemStack(setItems.chunk_silver),new ItemStack(cobble),3);
			ChislHandler.addtolist("denseoreLead",new ItemStack(setItems.chunk_lead),new ItemStack(cobble),3);
			ChislHandler.addtolist("denseoreNickel",new ItemStack(setItems.chunk_nickel),new ItemStack(cobble),3);
			ChislHandler.addtolist("denseorePlatinum",new ItemStack(setItems.chunk_platinum),new ItemStack(cobble),4);
			ChislHandler.addtolist("denseoreAluminum",new ItemStack(setItems.chunk_aluminum),new ItemStack(cobble),2);
			ChislHandler.addtolist("denseoreMithril",new ItemStack(setItems.chunk_mithril),new ItemStack(cobble),4);
			ChislHandler.addtolist("denseoreCobalt",new ItemStack(setItems.chunk_cobalt),new ItemStack(Blocks.NETHERRACK),5);
			ChislHandler.addtolist("denseoreArdite",new ItemStack(setItems.chunk_ardite),new ItemStack(Blocks.NETHERRACK),5);
			ChislHandler.addtolist("denseoreYellorium",new ItemStack(setItems.chunk_yellorium),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreFossils",new ItemStack(Items.BONE,2),new ItemStack(cobble),3);
			ChislHandler.addtolist("oreSaltpeter",new ItemStack(setItems.sodium,3),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreSulfur",new ItemStack(setItems.sulfur,3),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreCertusQuartz",new ItemStack(setItems.gem_certus_quartz,3),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreSapphire",new ItemStack(setItems.gem_sapphire,4),new ItemStack(cobble),2);
			ChislHandler.addtolist("oreRuby",new ItemStack(setItems.gem_ruby,4),new ItemStack(cobble),2);
			ChislHandler.addtolist("orePeridot",new ItemStack(setItems.gem_peridot,4),new ItemStack(cobble),2);
			ChislHandler.addtolist(Blocks.LIT_REDSTONE_ORE,0,new ItemStack(Items.REDSTONE,6),new ItemStack(cobble),3);
			ChislHandler.addtolist(Blocks.BRICK_BLOCK,0,new ItemStack(Items.BRICK,4),new ItemStack(Blocks.AIR),3);
			ChislHandler.addtolist(Blocks.NETHER_BRICK,0,new ItemStack(Items.NETHERBRICK,4),new ItemStack(Blocks.AIR),3);
			ChislHandler.addtolist(Blocks.ICE,0,new ItemStack(Blocks.ICE),new ItemStack(Blocks.AIR),3);
			ChislHandler.addtolist(Blocks.GLASS,0,new ItemStack(Blocks.GLASS),new ItemStack(Blocks.AIR),1);
			ChislHandler.addtolist(Blocks.GLASS_PANE,0,new ItemStack(Blocks.GLASS_PANE),new ItemStack(Blocks.AIR),1);
			for(int a=-1;a<16;a++)
			{
				ChislHandler.addtolist(Blocks.STAINED_GLASS,a,new ItemStack(Blocks.STAINED_GLASS,1,a),new ItemStack(Blocks.AIR,0),1);
				ChislHandler.addtolist(Blocks.STAINED_GLASS_PANE,a,new ItemStack(Blocks.STAINED_GLASS_PANE,1,a),new ItemStack(Blocks.AIR,0),1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Chisl recipe not working: "+e);
		}
	}
}