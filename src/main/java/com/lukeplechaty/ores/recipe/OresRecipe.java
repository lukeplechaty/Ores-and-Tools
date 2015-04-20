package com.lukeplechaty.ores.recipe;
import java.util.List;
import com.lukeplechaty.ores.Ores;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraftforge.oredict.*;
public class OresRecipe
{
	static Object[][] ItemList=(new Object[][]{
			new Object[]{"plankWood","cobblestone","ingotIron","ingotGold","gemDiamond","ingotTin","ingotCopper","ingotSilver","ingotLead","ingotNickel","ingotPlatinum","ingotAluminum","ingotMithril"},
			new Object[]{Ores.chiselwood,Ores.chiselstone,Ores.chiseliron,Ores.chiselgold,Ores.chiseldiamond,Ores.chiseltin,Ores.chiselcopper,Ores.chiselsilver,Ores.chisellead,Ores.chiselnickel,Ores.chiselplatinum,Ores.chiselaluminum,Ores.chiselmithril},
			new Object[]{Ores.sicklewood,Ores.sicklestone,Ores.sickleiron,Ores.sicklegold,Ores.sicklediamond,Ores.sickletin,Ores.sicklecopper,Ores.sicklesilver,Ores.sicklelead,Ores.sicklenickel,Ores.sickleplatinum,Ores.sicklealuminum,Ores.sicklemithril},
			new Object[]{Ores.machetewood,Ores.machetestone,Ores.macheteiron,Ores.machetegold,Ores.machetediamond,Ores.machetetin,Ores.machetecopper,Ores.machetesilver,Ores.machetelead,Ores.machetenickel,Ores.macheteplatinum,Ores.machetealuminum,Ores.machetemithril}});
	static String patterns[][]={
		{" y","x "},
		{" y ","  y","xy "},
		{"  y"," y ","x  "}};
	public static void recipe()
	{
		if(Ores.debug)System.out.println("adding recipe");
		
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.chunks,1,0),new ItemStack(Items.iron_ingot,1,0),0.7f);	//iron
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.dusts,1,3),new ItemStack(Items.iron_ingot,1,0),0.7f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.chunks,1,1),new ItemStack(Items.gold_ingot,1,0),1.0f);	//gold
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.dusts,1,4),new ItemStack(Items.gold_ingot,1,0),1.0f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.chunks,1,2),new ItemStack(Ores.ingots,1,0),0.55f);		//tin
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.dusts,1,5),new ItemStack(Ores.ingots,1,0),0.55f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.chunks,1,3),new ItemStack(Ores.ingots,1,1),0.4f);		//copper
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.dusts,1,6),new ItemStack(Ores.ingots,1,1),0.4f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.chunks,1,4),new ItemStack(Ores.ingots,1,2),0.85f);		//silver
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.dusts,1,7),new ItemStack(Ores.ingots,1,2),0.85f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.chunks,1,5),new ItemStack(Ores.ingots,1,3),0.85f);		//lead
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.dusts,1,8),new ItemStack(Ores.ingots,1,3),0.85f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.chunks,1,6),new ItemStack(Ores.ingots,1,4),0.85f);		//nickel
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.dusts,1,9),new ItemStack(Ores.ingots,1,4),0.85f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.chunks,1,7),new ItemStack(Ores.ingots,1,5),0.85f);		//platinum
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.dusts,1,10),new ItemStack(Ores.ingots,1,5),0.85f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.chunks,1,8),new ItemStack(Ores.ingots,1,6),0.85f);		//aluminum
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.dusts,1,11),new ItemStack(Ores.ingots,1,6),0.85f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.chunks,1,9),new ItemStack(Ores.ingots,1,7),0.85f);		//mithril
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.dusts,1,12),new ItemStack(Ores.ingots,1,7),0.85f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.chunks,1,10),new ItemStack(Ores.ingots,1,8),0.85f);		//cobalt
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.dusts,1,13),new ItemStack(Ores.ingots,1,8),0.85f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.chunks,1,11),new ItemStack(Ores.ingots,1,9),0.85f);		//ardite
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.dusts,1,14),new ItemStack(Ores.ingots,1,9),0.85f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.chunks,1,12),new ItemStack(Ores.ingots,1,10),0.85f);		//yellorium
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.dusts,1,15),new ItemStack(Ores.ingots,1,10),0.85f);
		
		List<IRecipe> crafting=CraftingManager.getInstance().getRecipeList();
		crafting.add(new ShapedOreRecipe(new ItemStack(Blocks.torch,4),new Object[]{"y","x",'x',"stickWood",'y',"chunkSulfur"}));
		crafting.add(new ShapedOreRecipe(new ItemStack(Ores.mortarandpestle),new Object[]{" y ","xzx"," x ",'z',"cobblestone",'y',new ItemStack(Ores.items,1,3),'x',"stone"}));
		crafting.add(new ShapedOreRecipe(new ItemStack(Ores.items,2,3),new Object[]{"s s","lxl","s s",'s',Items.string,'l',Items.leather,'x',Items.stick}));
		for(int MT=0;MT<ItemList[0].length;MT++)
		{
			Object obj=ItemList[0][MT];
			for(int TL=0;TL<ItemList.length-1;TL++)
			{
				Item item=(Item)ItemList[TL+1][MT];
				crafting.add(new ShapedOreRecipe(new ItemStack(item),new Object[]{patterns[TL],'x',new ItemStack(Ores.items,1,3),'y',obj}));
			}
		}
		
		crafting.add(new ShapelessOreRecipe(new ItemStack(Items.gunpowder,2),new Object[]{"dustCharcoal","dustSaltpeter","dustSaltpeter","dustSulfur"}));
		crafting.add(new ShapelessOreRecipe(new ItemStack(Items.string,4),new Object[]{new ItemStack(Blocks.wool)}));
		crafting.add(new ShapelessOreRecipe(new ItemStack(Ores.dusts,1,0),new Object[]{new ItemStack(Ores.mortarandpestle,1,all),"chunkSaltpeter"}));
		crafting.add(new ShapelessOreRecipe(new ItemStack(Ores.dusts,1,1),new Object[]{new ItemStack(Ores.mortarandpestle,1,all),"chunkSulfur"}));
		crafting.add(new ShapelessOreRecipe(new ItemStack(Ores.dusts,1,2),new Object[]{new ItemStack(Ores.mortarandpestle,1,all),new ItemStack(Items.coal,1,1)}));
		crafting.add(new ShapelessOreRecipe(new ItemStack(Items.dye,5,15),new Object[]{new ItemStack(Ores.mortarandpestle,1,all),new ItemStack(Items.bone,1,0)}));
		
		if(Ores.debug)System.out.println("recipe added");
	}
	static ItemStack copyWithSize(ItemStack itemstack,int size)
    {
		ItemStack itemstackcopy=itemstack.copy();
		itemstackcopy.stackSize=size;
        return itemstackcopy;
    }
	public static final int all=Short.MAX_VALUE;
}