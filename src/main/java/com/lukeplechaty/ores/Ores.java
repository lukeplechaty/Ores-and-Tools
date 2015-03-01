package com.lukeplechaty.ores;
import com.lukeplechaty.ores.blocks.*;
import com.lukeplechaty.ores.control.*;
import com.lukeplechaty.ores.items.*;
import com.lukeplechaty.ores.recipe.*;
import com.lukeplechaty.ores.register.OresRegister;
import com.lukeplechaty.ores.render.*;
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
@Mod(modid="OAT",name="Ores and Tools",version="1.7.10-0.4.0")
public class Ores
{
	GenOre genore = new GenOre();
    public static final CreativeTabs tabOres = new CreativeTabOres();
    static String[] MT=new String[]{"wood","stone","iron","gold","diamond","tin","copper","silver","lead","nickel","platinum","aluminum","mithril"};
	static int[] DG=new int[MT.length];
	
	public static boolean genores;
	public static boolean debug;
	
	public static Block ore;
	public static Block crop;
	public static Block smelting;
	
	public static Item items;
	public static Item chunks;
	public static Item ingots;
	public static Item dusts;
	
	public static Item chiselwood;
	public static Item chiselstone;
	public static Item chiseliron;
	public static Item chiselgold;
	public static Item chiseldiamond;
	public static Item chiseltin;
	public static Item chiselcopper;
	public static Item chiselsilver;
	public static Item chisellead;
	public static Item chiselnickel;
	public static Item chiselplatinum;
	public static Item chiselaluminum;
	public static Item chiselmithril;
	
	public static Item sicklewood;
	public static Item sicklestone;
	public static Item sickleiron;
	public static Item sicklegold;
	public static Item sicklediamond;
	public static Item sickletin;
	public static Item sicklecopper;
	public static Item sicklesilver;
	public static Item sicklelead;
	public static Item sicklenickel;
	public static Item sickleplatinum;
	public static Item sicklealuminum;
	public static Item sicklemithril;
	
	public static Item machetewood;
	public static Item machetestone;
	public static Item macheteiron;
	public static Item machetegold;
	public static Item machetediamond;
	public static Item machetetin;
	public static Item machetecopper;
	public static Item machetesilver;
	public static Item machetelead;
	public static Item machetenickel;
	public static Item macheteplatinum;
	public static Item machetealuminum;
	public static Item machetemithril;
	
	public static Item mortarandpestle;
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
		DG[5]=config.get("Tools max Damage",MT[5],30).getInt();
		DG[6]=config.get("Tools max Damage",MT[6],30).getInt();
		DG[7]=config.get("Tools max Damage",MT[7],60).getInt();
		DG[8]=config.get("Tools max Damage",MT[8],30).getInt();
		DG[9]=config.get("Tools max Damage",MT[9],60).getInt();
		DG[10]=config.get("Tools max Damage",MT[10],1000).getInt();
		DG[11]=config.get("Tools max Damage",MT[11],30).getInt();
		DG[12]=config.get("Tools max Damage",MT[12],2000).getInt();
		
		genores=config.get("Generate Ores","ore_gen",false).getBoolean(false);
		debug=config.get("Debug","debug",false).getBoolean(false);
		
		config.save();
	}
	@EventHandler
	public void Initload(FMLInitializationEvent event)
	{
		if(Ores.debug)System.out.println("loading blocks and items");
		ore=(new Blockore());
		crop=(new BlockFlax());
		items=(new Itemore());
		chunks=(new ItemChunk());
		ingots=(new ItemIngot());
		dusts=(new ItemDust());
		
		chiselwood=(new ItemChisel(MT[0],DG[0],1));
		chiselstone=(new ItemChisel(MT[1],DG[1],2));
		chiseliron=(new ItemChisel(MT[2],DG[2],3));
		chiselgold=(new ItemChisel(MT[3],DG[3],1));
		chiseldiamond=(new ItemChisel(MT[4],DG[4],4));
		chiseltin=(new ItemChisel(MT[5],DG[5],1));
		chiselcopper=(new ItemChisel(MT[6],DG[6],1));
		chiselsilver=(new ItemChisel(MT[7],DG[7],2));
		chisellead=(new ItemChisel(MT[8],DG[8],1));
		chiselnickel=(new ItemChisel(MT[9],DG[9],2));
		chiselplatinum=(new ItemChisel(MT[10],DG[10],4));
		chiselaluminum=(new ItemChisel(MT[11],DG[11],1));
		chiselmithril=(new ItemChisel(MT[12],DG[12],5));
		
		sicklewood=(new ItemSickle(MT[0],DG[0]));
		sicklestone=(new ItemSickle(MT[1],DG[1]));
		sickleiron=(new ItemSickle(MT[2],DG[2]));
		sicklegold=(new ItemSickle(MT[3],DG[3]));
		sicklediamond=(new ItemSickle(MT[4],DG[4]));
		sickletin=(new ItemSickle(MT[5],DG[5]));
		sicklecopper=(new ItemSickle(MT[6],DG[6]));
		sicklesilver=(new ItemSickle(MT[7],DG[7]));
		sicklelead=(new ItemSickle(MT[8],DG[8]));
		sicklenickel=(new ItemSickle(MT[9],DG[9]));
		sickleplatinum=(new ItemSickle(MT[10],DG[10]));
		sicklealuminum=(new ItemSickle(MT[11],DG[11]));
		sicklemithril=(new ItemSickle(MT[12],DG[12]));
		
		machetewood=(new ItemMachete(MT[0],DG[0],0,2.0F));
		machetestone=(new ItemMachete(MT[1],DG[1],1,4.0F));
		macheteiron=(new ItemMachete(MT[2],DG[2],2,6.0F));
		machetegold=(new ItemMachete(MT[3],DG[3],0,12.0F));
		machetediamond=(new ItemMachete(MT[4],DG[4],3,8.0F));
		machetetin=(new ItemMachete(MT[5],DG[5],0,2.0F));
		machetecopper=(new ItemMachete(MT[6],DG[6],0,2.0F));
		machetesilver=(new ItemMachete(MT[7],DG[7],1,4.0F));
		machetelead=(new ItemMachete(MT[8],DG[8],0,2.0F));
		machetenickel=(new ItemMachete(MT[9],DG[9],1,4.0F));
		macheteplatinum=(new ItemMachete(MT[10],DG[10],3,8.0F));
		machetealuminum=(new ItemMachete(MT[11],DG[11],0,2.0F));
		machetemithril=(new ItemMachete(MT[12],DG[12],4,12.0F));
		
		mortarandpestle=(new Itemmortarandpestle());
		
		if(Ores.debug)System.out.println("blocks and items loaded");
		
		GameRegistry.registerBlock(ore,Itemblockore.class,"ores_block");
		GameRegistry.registerBlock(crop,"flax_crop");
		
		GameRegistry.registerItem(items,"ores_items");
		GameRegistry.registerItem(chunks,"ores_chunks");
		GameRegistry.registerItem(ingots,"ores_ingots");
		GameRegistry.registerItem(dusts,"ores_dusts");
		
		GameRegistry.registerItem(chiselwood,"chisel_wood");
		GameRegistry.registerItem(chiselstone,"chisel_stone");
		GameRegistry.registerItem(chiseliron,"chisel_iron");
		GameRegistry.registerItem(chiselgold,"chisel_gold");
		GameRegistry.registerItem(chiseldiamond,"chisel_diamond");
		GameRegistry.registerItem(chiseltin,"chisel_tin");
		GameRegistry.registerItem(chiselcopper,"chisel_copper");
		GameRegistry.registerItem(chiselsilver,"chisel_silver");
		GameRegistry.registerItem(chisellead,"chisel_lead");
		GameRegistry.registerItem(chiselnickel,"chisel_nickel");
		GameRegistry.registerItem(chiselplatinum,"chisel_platinum");
		GameRegistry.registerItem(chiselaluminum,"chisel_aluminum");
		GameRegistry.registerItem(chiselmithril,"chisel_mithril");
		
		GameRegistry.registerItem(sicklewood,"sickle_wood");
		GameRegistry.registerItem(sicklestone,"sickle_stone");
		GameRegistry.registerItem(sickleiron,"sickle_iron");
		GameRegistry.registerItem(sicklegold,"sickle_gold");
		GameRegistry.registerItem(sicklediamond,"sickle_diamond");
		GameRegistry.registerItem(sickletin,"sickle_tin");
		GameRegistry.registerItem(sicklecopper,"sickle_copper");
		GameRegistry.registerItem(sicklesilver,"sickle_silver");
		GameRegistry.registerItem(sicklelead,"sickle_lead");
		GameRegistry.registerItem(sicklenickel,"sickle_nickel");
		GameRegistry.registerItem(sickleplatinum,"sickle_platinum");
		GameRegistry.registerItem(sicklealuminum,"sickle_aluminum");
		GameRegistry.registerItem(sicklemithril,"sickle_mithril");
		
		GameRegistry.registerItem(machetewood,"machete_wood");
		GameRegistry.registerItem(machetestone,"machete_stone");
		GameRegistry.registerItem(macheteiron,"machete_iron");
		GameRegistry.registerItem(machetegold,"machete_gold");
		GameRegistry.registerItem(machetediamond,"machete_diamond");
		GameRegistry.registerItem(machetetin,"machete_tin");
		GameRegistry.registerItem(machetecopper,"machete_copper");
		GameRegistry.registerItem(machetesilver,"machete_silver");
		GameRegistry.registerItem(machetelead,"machete_lead");
		GameRegistry.registerItem(machetenickel,"machete_nickel");
		GameRegistry.registerItem(macheteplatinum,"machete_platinum");
		GameRegistry.registerItem(machetealuminum,"machete_aluminum");
		GameRegistry.registerItem(machetemithril,"machete_mithril");
		
		GameRegistry.registerItem(mortarandpestle,"mortar_and_pestle");
		
		OresRegister.register();
		MinecraftForge.addGrassSeed(new ItemStack(items,1,0),7);
		OresRecipe.recipe();
		FMLCommonHandler.instance().bus().register(new OresEvent());
		GameRegistry.registerWorldGenerator(genore,0);
		OresChislRecips.recipe();
		OresBlockRender.setCustomRenderers();
		ItemChisel.loadlist();
	}
	@EventHandler
	public void Postload(FMLPostInitializationEvent event){}
}