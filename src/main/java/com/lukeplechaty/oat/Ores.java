package com.lukeplechaty.oat;
import com.lukeplechaty.oat.control.CreativeTabOres;
import com.lukeplechaty.oat.control.GenOre;
import com.lukeplechaty.oat.control.OresEvent;
import com.lukeplechaty.oat.items.ItemChisel;
import com.lukeplechaty.oat.proxy.CommonProxy;
import com.lukeplechaty.oat.recipe.OresChislRecips;
import com.lukeplechaty.oat.recipe.OresRecipe;
import com.lukeplechaty.oat.register.OresRegister;
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
@Mod(modid="OAT",name="Ores and Tools",version="1.7.10-0.5.1")
public class Ores
{
	@Instance
	public static Ores instance;
	@SidedProxy(clientSide = "com.lukeplechaty.oat.proxy.ClientProxy",serverSide = "com.lukeplechaty.oat.proxy.ServerProxy")
	public static CommonProxy proxy;
	public static final CreativeTabs tabOres=new CreativeTabOres();
	GenOre genore=new GenOre();
	@EventHandler
	public void PreLoad(FMLPreInitializationEvent event)
	{
		setItems.config(event);
		setItems.init();
		setItems.register();
		setBlocks.init();
		setBlocks.register();
		OresRegister.register();
		MinecraftForge.addGrassSeed(new ItemStack(setItems.seed),7);
		OresRecipe.recipe();
		MinecraftForge.EVENT_BUS.register(new OresEvent());
		GameRegistry.registerWorldGenerator(genore,0);
		OresChislRecips.recipe();
	}
	@EventHandler
	public void Initload(FMLInitializationEvent event)
	{
		proxy.init();
	}
	@EventHandler
	public void Postload(FMLPostInitializationEvent event)
	{
		ItemChisel.loadlist();
	}
}