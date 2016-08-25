package com.lukeplechaty.oat;
import com.lukeplechaty.oat.blocks.BlockFlax;
import com.lukeplechaty.oat.blocks.BlockOres;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
public class setBlocks
{
	public static Block crop;
	public static Block orefossils;
	public static Block oresodium;
	public static Block oresulfur;
	public static void init()
	{
		crop=(new BlockFlax("flax_crop"));
		orefossils=(new BlockOres("ore_fossils").setHardness(6.0f));
		oresodium=(new BlockOres("ore_sodium").setHardness(3.0f));
		oresulfur=(new BlockOres("ore_sulfur").setHardness(5.0f));
	}
	public static void register()
	{
		register(crop);
		register(orefossils);
		register(oresodium);
		register(oresulfur);
	}
	private static void register(Block block)
	{
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
	public static void registerRenders()
	{
		registerRenders(crop);
		registerRenders(orefossils);
		registerRenders(oresodium);
		registerRenders(oresulfur);
	}
	private static void registerRenders(Block block)
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),0,new ModelResourceLocation(block.getRegistryName(),"inventory"));
	}
}