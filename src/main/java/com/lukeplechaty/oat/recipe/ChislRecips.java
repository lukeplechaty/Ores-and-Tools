package com.lukeplechaty.oat.recipe;
import com.lukeplechaty.oat.setItems;
import com.lukeplechaty.oat.control.ChislHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ChislRecips
{
	static Block cobble = Blocks.COBBLESTONE;
	
	public static void recipe()
	{
		try
		{
			ChislHandler.addtolist("oreCoal", new ItemStack(Items.COAL), cobble, 1);
			ChislHandler.addtolist("oreDiamond", new ItemStack(Items.DIAMOND), cobble, 3);
			ChislHandler.addtolist("oreEmerald", new ItemStack(Items.EMERALD), cobble, 3);
			ChislHandler.addtolist("oreLapis", new ItemStack(Items.DYE, 9, 4), cobble, 2);
			ChislHandler.addtolist("oreRedstone", new ItemStack(Items.REDSTONE, 6), cobble, 3);
			ChislHandler.addtolist("oreQuartz", new ItemStack(Items.QUARTZ), Blocks.NETHERRACK, 1);
			ChislHandler.addtolist("oreIron", new ItemStack(setItems.chunk_iron), cobble, 2);
			ChislHandler.addtolist("oreGold", new ItemStack(setItems.chunk_gold), cobble, 3);
			ChislHandler.addtolist("oreTin", new ItemStack(setItems.chunk_tin), cobble, 2);
			ChislHandler.addtolist("oreCopper", new ItemStack(setItems.chunk_copper), cobble, 2);
			ChislHandler.addtolist("oreSilver", new ItemStack(setItems.chunk_silver), cobble, 3);
			ChislHandler.addtolist("oreLead", new ItemStack(setItems.chunk_lead), cobble, 3);
			ChislHandler.addtolist("oreNickel", new ItemStack(setItems.chunk_nickel), cobble, 3);
			ChislHandler.addtolist("orePlatinum", new ItemStack(setItems.chunk_platinum), cobble, 4);
			ChislHandler.addtolist("oreAluminum", new ItemStack(setItems.chunk_aluminum), cobble, 2);
			ChislHandler.addtolist("oreMithril", new ItemStack(setItems.chunk_mithril), cobble, 4);
			ChislHandler.addtolist("oreCobalt", new ItemStack(setItems.chunk_cobalt), Blocks.NETHERRACK, 5);
			ChislHandler.addtolist("oreArdite", new ItemStack(setItems.chunk_ardite), Blocks.NETHERRACK, 5);
			ChislHandler.addtolist("oreYellorium", new ItemStack(setItems.chunk_yellorium), cobble, 3);
			ChislHandler.addtolist("denseoreCoal", new ItemStack(Items.COAL, 3), cobble, 1);
			ChislHandler.addtolist("denseoreDiamond", new ItemStack(Items.DIAMOND, 3), cobble, 3);
			ChislHandler.addtolist("denseoreEmerald", new ItemStack(Items.EMERALD, 3), cobble, 3);
			ChislHandler.addtolist("denseoreLapis", new ItemStack(Items.DYE, 27, 4), cobble, 2);
			ChislHandler.addtolist("denseoreRedstone", new ItemStack(Items.REDSTONE, 18), cobble, 3);
			ChislHandler.addtolist("denseoreQuartz", new ItemStack(Items.QUARTZ, 3), Blocks.NETHERRACK, 1);
			ChislHandler.addtolist("denseoreIron", new ItemStack(setItems.chunk_iron), cobble, 2);
			ChislHandler.addtolist("denseoreGold", new ItemStack(setItems.chunk_gold), cobble, 3);
			ChislHandler.addtolist("denseoreTin", new ItemStack(setItems.chunk_tin), cobble, 2);
			ChislHandler.addtolist("denseoreCopper", new ItemStack(setItems.chunk_copper), cobble, 2);
			ChislHandler.addtolist("denseoreSilver", new ItemStack(setItems.chunk_silver), cobble, 3);
			ChislHandler.addtolist("denseoreLead", new ItemStack(setItems.chunk_lead), cobble, 3);
			ChislHandler.addtolist("denseoreNickel", new ItemStack(setItems.chunk_nickel), cobble, 3);
			ChislHandler.addtolist("denseorePlatinum", new ItemStack(setItems.chunk_platinum), cobble, 4);
			ChislHandler.addtolist("denseoreAluminum", new ItemStack(setItems.chunk_aluminum), cobble, 2);
			ChislHandler.addtolist("denseoreMithril", new ItemStack(setItems.chunk_mithril), cobble, 4);
			ChislHandler.addtolist("denseoreCobalt", new ItemStack(setItems.chunk_cobalt), Blocks.NETHERRACK, 5);
			ChislHandler.addtolist("denseoreArdite", new ItemStack(setItems.chunk_ardite), Blocks.NETHERRACK, 5);
			ChislHandler.addtolist("denseoreYellorium", new ItemStack(setItems.chunk_yellorium), cobble, 3);
			ChislHandler.addtolist("oreFossils", new ItemStack(Items.BONE, 2), cobble, 3);
			ChislHandler.addtolist("oreSaltpeter", new ItemStack(setItems.item_sodium, 3), cobble, 2);
			ChislHandler.addtolist("oreSulfur", new ItemStack(setItems.item_sulfur, 3), cobble, 2);
			ChislHandler.addtolist("oreCertusQuartz", new ItemStack(setItems.gem_certus_quartz, 3), cobble, 2);
			ChislHandler.addtolist("oreSapphire", new ItemStack(setItems.gem_sapphire, 4), cobble, 2);
			ChislHandler.addtolist("oreRuby", new ItemStack(setItems.gem_ruby, 4), cobble, 2);
			ChislHandler.addtolist("orePeridot", new ItemStack(setItems.gem_peridot, 4), cobble, 2);
			ChislHandler.addtolist(Blocks.LIT_REDSTONE_ORE, 0, new ItemStack(Items.REDSTONE, 6), cobble, 3);
			ChislHandler.addtolist(Blocks.BRICK_BLOCK, 0, new ItemStack(Items.BRICK, 4), Blocks.AIR, 3);
			ChislHandler.addtolist(Blocks.NETHER_BRICK, 0, new ItemStack(Items.NETHERBRICK, 4), Blocks.AIR, 3);
			ChislHandler.addtolist(Blocks.ICE, 0, new ItemStack(Blocks.ICE), Blocks.AIR, 3);
			ChislHandler.addtolist(Blocks.GLASS, 0, new ItemStack(Blocks.GLASS), Blocks.AIR, 1);
			ChislHandler.addtolist(Blocks.GLASS_PANE, 0, new ItemStack(Blocks.GLASS_PANE), Blocks.AIR, 1);
			for(int i = -1; i < 16; i++)
			{
				ChislHandler.addtolist(Blocks.STAINED_GLASS, i, new ItemStack(Blocks.STAINED_GLASS, 1, i), Blocks.AIR, 1);
				ChislHandler.addtolist(Blocks.STAINED_GLASS_PANE, i, new ItemStack(Blocks.STAINED_GLASS_PANE, 1, i), Blocks.AIR, 1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Chisl recipe not working: " + e);
		}
	}
}
