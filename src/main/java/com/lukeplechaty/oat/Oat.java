package com.lukeplechaty.oat;
import com.lukeplechaty.oat.control.GenOres;
import com.lukeplechaty.oat.proxy.CommonProxy;
import com.lukeplechaty.oat.recipe.ChislRecips;
import com.lukeplechaty.oat.recipe.Recipe;
import com.lukeplechaty.oat.register.RegisterOreDictionary;
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

@Mod(modid = "oat", name = "Ores and Tools", version = "0.7.1")
public class Oat
{
	@Instance
	public static Oat instance;
	@SidedProxy(clientSide = "com.lukeplechaty.oat.proxy.ClientProxy", serverSide = "com.lukeplechaty.oat.proxy.ServerProxy")
	public static CommonProxy proxy;
	GenOres genore = new GenOres();
	
	@EventHandler
	public void PreLoad(FMLPreInitializationEvent event)
	{
		setItems.config(event);
		setItems.init();
		setBlocks.init();
		MinecraftForge.addGrassSeed(new ItemStack(setItems.item_seed), 7);
		Recipe.recipe();
		GameRegistry.registerWorldGenerator(genore, 0);
		ChislRecips.recipe();
	}
	
	@EventHandler
	public void Initload(FMLInitializationEvent event)
	{
		RegisterOreDictionary.register();
		setTabs.init();
	}
	
	@EventHandler
	public void Postload(FMLPostInitializationEvent event)
	{}
}
