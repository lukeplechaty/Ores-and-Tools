package com.lukeplechaty.ores;
import net.minecraft.block.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraftforge.common.*;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.GameRegistry;
@Mod(modid="ores",name="Ores",version="1.7.10-0.2.0")
public class Ores
{
	GenOre genore = new GenOre();
    static final CreativeTabs tabOres = new CreativeTabOres();
    static String[] MT=new String[]{"wood","stone","iron","gold","diamond"};
	static int[] DG=new int[5];
	static boolean genores;
	static boolean debug;
	static Block ore;
	static Block crop;
	static Item items;
	static Item chiselwood;
	static Item chiselstone;
	static Item chiseliron;
	static Item chiselgold;
	static Item chiseldiamond;
	static Item sicklewood;
	static Item sicklestone;
	static Item sickleiron;
	static Item sicklegold;
	static Item sicklediamond;
	static Item machetewood;
	static Item machetestone;
	static Item macheteiron;
	static Item machetegold;
	static Item machetediamond;
	static Item mortarandpestle;
	@EventHandler
	public void PreLoad(FMLPreInitializationEvent event)
	{
		if(Ores.debug)System.out.println("loading config");
		Configuration config=new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		DG[0]=config.get("Tools max Damage",MT[0],60).getInt();
		DG[1]=config.get("Tools max Damage",MT[1],120).getInt();
		DG[2]=config.get("Tools max Damage",MT[2],240).getInt();
		DG[3]=config.get("Tools max Damage",MT[3],30).getInt();
		DG[4]=config.get("Tools max Damage",MT[4],1500).getInt();
		
		genores=config.get("Generate Ores","ore_gen",false).getBoolean(false);
		debug=config.get("Debug","debug",false).getBoolean(false);
		
		config.save();
	}
	@EventHandler
	public void Initload(FMLInitializationEvent event)
	{
		if(Ores.debug)System.out.println("loading blocks and items");
		ore=(new Blockore());
		crop=(new Blockcrop());
		items=(new Itemore());
		
		chiselwood=(new ItemChisl(MT[0],DG[0],1));
		chiselstone=(new ItemChisl(MT[1],DG[1],2));
		chiseliron=(new ItemChisl(MT[2],DG[2],3));
		chiselgold=(new ItemChisl(MT[3],DG[3],1));
		chiseldiamond=(new ItemChisl(MT[4],DG[4],4));
		
		sicklewood=(new ItemSickle(MT[0],DG[0]));
		sicklestone=(new ItemSickle(MT[1],DG[1]));
		sickleiron=(new ItemSickle(MT[2],DG[2]));
		sicklegold=(new ItemSickle(MT[3],DG[3]));
		sicklediamond=(new ItemSickle(MT[4],DG[4]));
		
		machetewood=(new ItemMachete(MT[0],DG[0],0,2.0F));
		machetestone=(new ItemMachete(MT[1],DG[1],1,4.0F));
		macheteiron=(new ItemMachete(MT[2],DG[2],2,6.0F));
		machetegold=(new ItemMachete(MT[3],DG[3],0,12.0F));
		machetediamond=(new ItemMachete(MT[4],DG[4],3,8.0F));
		mortarandpestle=(new Itemmortarandpestle());
		
		if(Ores.debug)System.out.println("blocks and items loaded");
		
		GameRegistry.registerBlock(ore,Itemblockore.class,"ores_block");
		GameRegistry.registerBlock(crop,"flax_crop");
		GameRegistry.registerItem(items,"ores_items");
		
		GameRegistry.registerItem(chiselwood,"chisel_wood");
		GameRegistry.registerItem(chiselstone,"chisel_stone");
		GameRegistry.registerItem(chiseliron,"chisel_iron");
		GameRegistry.registerItem(chiselgold,"chisel_gold");
		GameRegistry.registerItem(chiseldiamond,"chisel_diamond");
		
		GameRegistry.registerItem(sicklewood,"sickle_wood");
		GameRegistry.registerItem(sicklestone,"sickle_stone");
		GameRegistry.registerItem(sickleiron,"sickle_iron");
		GameRegistry.registerItem(sicklegold,"sickle_gold");
		GameRegistry.registerItem(sicklediamond,"sickle_diamond");
		
		GameRegistry.registerItem(machetewood,"machete_wood");
		GameRegistry.registerItem(machetestone,"machete_stone");
		GameRegistry.registerItem(macheteiron,"machete_iron");
		GameRegistry.registerItem(machetegold,"machete_gold");
		GameRegistry.registerItem(machetediamond,"machete_diamond");
		GameRegistry.registerItem(mortarandpestle,"mortar_and_pestle");
		
		OresRegister.register();
		MinecraftForge.addGrassSeed(new ItemStack(items,1,0),7);
		OresRecipe.recipe();
		FMLCommonHandler.instance().bus().register(new OresEvent());
		GameRegistry.registerWorldGenerator(genore,0);
		OresChislRecips.recipe();
		OresBlockRender.setCustomRenderers();
		ItemChisl.loadlist();
	}
	@EventHandler
	public void Postload(FMLPostInitializationEvent event){}
}