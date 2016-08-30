package com.lukeplechaty.oat;
import com.lukeplechaty.oat.control.CreativeTabOat;
import com.lukeplechaty.oat.control.GenOres;
import com.lukeplechaty.oat.control.Events;
import com.lukeplechaty.oat.items.ItemChisel;
import com.lukeplechaty.oat.proxy.CommonProxy;
import com.lukeplechaty.oat.recipe.ChislRecips;
import com.lukeplechaty.oat.recipe.Recipe;
import com.lukeplechaty.oat.register.RegisterOreDictionary;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
@Mod(modid="oat",name="Ores and Tools",version="1.10.2-0.6.0")
public class Oat
{
	@Instance
	public static Oat instance;
	@SidedProxy(clientSide = "com.lukeplechaty.oat.proxy.ClientProxy",serverSide = "com.lukeplechaty.oat.proxy.ServerProxy")
	public static CommonProxy proxy;
	public static final CreativeTabs tabOres=new CreativeTabOat();
	GenOres genore=new GenOres();
	@EventHandler
	public void PreLoad(FMLPreInitializationEvent event)
	{
		setItems.config(event);
		setItems.init();
		setItems.register();
		setBlocks.init();
		setBlocks.register();
		setEntites.init();
		setEntites.register();
		proxy.init();
		RegisterOreDictionary.register();
		MinecraftForge.addGrassSeed(new ItemStack(setItems.item_seed),7);
		Recipe.recipe();
		MinecraftForge.EVENT_BUS.register(new Events());
		GameRegistry.registerWorldGenerator(genore,0);
		ChislRecips.recipe();
		ItemChisel.loadlist();
	}
	@EventHandler
	public void Initload(FMLInitializationEvent event){}
	@EventHandler
	public void Postload(FMLPostInitializationEvent event){}
}