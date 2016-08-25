package com.lukeplechaty.oat.recipe;
import java.util.List;
import com.lukeplechaty.oat.setItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
public class Recipe
{
	static Object[][] ItemList=(new Object[][]{new Object[]{"plankWood","cobblestone","ingotIron","ingotGold","gemDiamond","ingotTin","ingotCopper","ingotSilver","ingotLead","ingotNickel","ingotPlatinum","ingotAluminum","ingotMithril"},new Object[]{setItems.chisel_wood,setItems.chisel_stone,setItems.chisel_iron,setItems.chisel_gold,setItems.chisel_diamond,setItems.chisel_tin,setItems.chisel_copper,setItems.chisel_silver,setItems.chisel_lead,setItems.chisel_nickel,setItems.chisel_platinum,setItems.chisel_aluminum,setItems.chisel_mithril},new Object[]{setItems.sickle_wood,setItems.sickle_stone,setItems.sickle_iron,setItems.sickle_gold,setItems.sickle_diamond,setItems.sickle_tin,setItems.sickle_copper,setItems.sickle_silver,setItems.sickle_lead,setItems.sickle_nickel,setItems.sickle_platinum,setItems.sickle_aluminum,setItems.sickle_mithril},new Object[]{setItems.machete_wood,setItems.machete_stone,setItems.machete_iron,setItems.machete_gold,setItems.machete_diamond,setItems.machete_tin,setItems.machete_copper,setItems.machete_silver,setItems.machete_lead,setItems.machete_nickel,setItems.machete_platinum,setItems.machete_aluminum,setItems.machete_mithril}});
	static String patterns[][]={{" y","x "},{" y ","  y","xy "},{"  y"," y ","x  "}};
	public static final int all=Short.MAX_VALUE;
	static ItemStack copyWithSize(ItemStack itemstack,int size)
	{
		ItemStack itemstackcopy=itemstack.copy();
		itemstackcopy.stackSize=size;
		return itemstackcopy;
	}
	public static void recipe()
	{
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.chunk_iron),new ItemStack(Items.IRON_INGOT),0.7f); // iron
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_iron),new ItemStack(Items.IRON_INGOT),0.7f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_clean_iron),new ItemStack(Items.IRON_INGOT),0.7f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.dust_iron),new ItemStack(Items.IRON_INGOT),0.7f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.chunk_gold),new ItemStack(Items.GOLD_INGOT),1.0f); // gold
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_gold),new ItemStack(Items.GOLD_INGOT),1.0f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_clean_gold),new ItemStack(Items.GOLD_INGOT),1.0f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.dust_gold),new ItemStack(Items.GOLD_INGOT),1.0f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.chunk_tin),new ItemStack(setItems.ingot_tin),0.55f); // tin
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_tin),new ItemStack(setItems.ingot_tin),0.55f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_clean_tin),new ItemStack(setItems.ingot_tin),0.55f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.dust_tin),new ItemStack(setItems.ingot_tin),0.55f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.chunk_copper),new ItemStack(setItems.ingot_copper),0.4f); // copper
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_copper),new ItemStack(setItems.ingot_copper),0.4f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_clean_copper),new ItemStack(setItems.ingot_copper),0.4f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.dust_copper),new ItemStack(setItems.ingot_copper),0.4f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.chunk_silver),new ItemStack(setItems.ingot_silver),0.85f); // silver
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_silver),new ItemStack(setItems.ingot_silver),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_clean_silver),new ItemStack(setItems.ingot_silver),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.dust_silver),new ItemStack(setItems.ingot_silver),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.chunk_lead),new ItemStack(setItems.ingot_lead),0.85f); // lead
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_lead),new ItemStack(setItems.ingot_lead),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_clean_lead),new ItemStack(setItems.ingot_lead),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.dust_lead),new ItemStack(setItems.ingot_lead),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.chunk_nickel),new ItemStack(setItems.ingot_nickel),0.85f); // nickel
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_nickel),new ItemStack(setItems.ingot_nickel),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_clean_nickel),new ItemStack(setItems.ingot_nickel),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.dust_nickel),new ItemStack(setItems.ingot_nickel),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.chunk_platinum),new ItemStack(setItems.ingot_platinum),0.85f); // platinum
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_platinum),new ItemStack(setItems.ingot_platinum),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_clean_platinum),new ItemStack(setItems.ingot_platinum),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.dust_platinum),new ItemStack(setItems.ingot_platinum),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.chunk_aluminum),new ItemStack(setItems.ingot_aluminum),0.85f); // aluminum
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_aluminum),new ItemStack(setItems.ingot_aluminum),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_clean_aluminum),new ItemStack(setItems.ingot_aluminum),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.dust_aluminum),new ItemStack(setItems.ingot_aluminum),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.chunk_mithril),new ItemStack(setItems.ingot_mithril),0.85f); // mithril
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_mithril),new ItemStack(setItems.ingot_mithril),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_clean_mithril),new ItemStack(setItems.ingot_mithril),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.dust_mithril),new ItemStack(setItems.ingot_mithril),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.chunk_cobalt),new ItemStack(setItems.ingot_cobalt),0.85f); // cobalt
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_cobalt),new ItemStack(setItems.ingot_cobalt),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_clean_cobalt),new ItemStack(setItems.ingot_cobalt),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.dust_cobalt),new ItemStack(setItems.ingot_cobalt),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.chunk_ardite),new ItemStack(setItems.ingot_ardite),0.85f); // ardite
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_ardite),new ItemStack(setItems.ingot_ardite),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_clean_ardite),new ItemStack(setItems.ingot_ardite),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.dust_ardite),new ItemStack(setItems.ingot_ardite),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.chunk_yellorium),new ItemStack(setItems.ingot_yellorium),0.85f); // yellorium
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_yellorium),new ItemStack(setItems.ingot_yellorium),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.lump_clean_yellorium),new ItemStack(setItems.ingot_yellorium),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.dust_yellorium),new ItemStack(setItems.ingot_yellorium),0.85f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(setItems.dust_flour),new ItemStack(Items.BREAD),0.85f); // bread
		List<IRecipe> crafting=CraftingManager.getInstance().getRecipeList();
		crafting.add(new ShapedOreRecipe(new ItemStack(Blocks.COBBLESTONE),new Object[]{"xx","xx",'x',"rock"}));
		crafting.add(new ShapedOreRecipe(new ItemStack(Blocks.TORCH,4),new Object[]{"y","x",'x',"stickWood",'y',"chunkSulfur"}));
		crafting.add(new ShapedOreRecipe(new ItemStack(setItems.mortar_and_pestle),new Object[]{" y ","xzx"," x ",'z',"cobblestone",'y',new ItemStack(setItems.item_handel),'x',"stone"}));
		crafting.add(new ShapedOreRecipe(new ItemStack(setItems.item_handel,2),new Object[]{"s s","lxl","s s",'s',Items.STRING,'l',Items.LEATHER,'x',Items.STICK}));
		for(int MT=0;MT<ItemList[0].length;MT++)
		{
			Object obj=ItemList[0][MT];
			for(int TL=0;TL<ItemList.length-1;TL++)
			{
				Item item=(Item)ItemList[TL+1][MT];
				crafting.add(new ShapedOreRecipe(new ItemStack(item),new Object[]{patterns[TL],'x',new ItemStack(setItems.item_handel),'y',obj}));
			}
		}
		crafting.add(new ShapelessOreRecipe(new ItemStack(Items.GUNPOWDER,2),new Object[]{"dustCharcoal","dustSaltpeter","dustSaltpeter","dustSulfur"}));
		crafting.add(new ShapelessOreRecipe(new ItemStack(Items.STRING,4),new Object[]{new ItemStack(Blocks.WOOL)}));
		crafting.add(new ShapelessOreRecipe(new ItemStack(setItems.dust_flour),new Object[]{new ItemStack(setItems.mortar_and_pestle,1,all),new ItemStack(Items.WHEAT)}));
		crafting.add(new ShapelessOreRecipe(new ItemStack(setItems.dust_sodium),new Object[]{new ItemStack(setItems.mortar_and_pestle,1,all),"chunkSaltpeter"}));
		crafting.add(new ShapelessOreRecipe(new ItemStack(setItems.dust_sulfur),new Object[]{new ItemStack(setItems.mortar_and_pestle,1,all),"chunkSulfur"}));
		crafting.add(new ShapelessOreRecipe(new ItemStack(setItems.dust_charcoal),new Object[]{new ItemStack(setItems.mortar_and_pestle,1,all),new ItemStack(Items.COAL,1,1)}));
		crafting.add(new ShapelessOreRecipe(new ItemStack(Items.DYE,5,15),new Object[]{new ItemStack(setItems.mortar_and_pestle,1,all),new ItemStack(Items.BONE)}));
	}
}