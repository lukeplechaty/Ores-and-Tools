package com.lukeplechaty.ores;
import java.util.List;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraftforge.oredict.*;
public class OresRecipe
{
	static Object[][] ItemList=(new Object[][]{
			new Object[]{"plankWood","cobblestone","ingotIron","ingotGold","gemDiamond"},
			new Object[]{Ores.chiselwood,Ores.chiselstone,Ores.chiseliron,Ores.chiselgold,Ores.chiseldiamond},
			new Object[]{Ores.sicklewood,Ores.sicklestone,Ores.sickleiron,Ores.sicklegold,Ores.sicklediamond},
			new Object[]{Ores.machetewood,Ores.machetestone,Ores.macheteiron,Ores.machetegold,Ores.machetediamond}});
	static String patterns[][]={
		{" y","x "},
		{" y ","  y","xy "},
		{"  y"," y ","x  "}};
	static void recipe()
	{
		if(Ores.debug)System.out.println("adding recipe");
		try
		{
			FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.items,1,6),new ItemStack(Items.iron_ingot,1,0),0.7f);	//iron
			FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.items,1,7),new ItemStack(Items.gold_ingot,1,0),1.0f);	//gold
			FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.items,1,8),new ItemStack(Ores.items,1,15),0.55f);		//tin
			FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.items,1,9),new ItemStack(Ores.items,1,16),0.4f);			//copper
			FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.items,1,10),new ItemStack(Ores.items,1,17),0.85f);		//silver
			FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.items,1,11),new ItemStack(Ores.items,1,18),0.85f);		//lead
			FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.items,1,12),new ItemStack(Ores.items,1,19),0.85f);		//nickel
			FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.items,1,13),new ItemStack(Ores.items,1,20),0.85f);		//platinum
			FurnaceRecipes.smelting().func_151394_a(new ItemStack(Ores.items,1,14),new ItemStack(Ores.items,1,21),0.85f);		//aluminum
		}
		catch(Exception e)
		{
			System.out.println("ERROR Ores Recipe: "+e);
		}
		List<IRecipe> crafting=CraftingManager.getInstance().getRecipeList();
		crafting.add(new ShapedOreRecipe(new ItemStack(Blocks.torch,4),new Object[]{"y","x",'x',"stickWood",'y',"chunkSulfur"}));
		crafting.add(new ShapedOreRecipe(new ItemStack(Ores.mortarandpestle),new Object[]{" y ","xzx"," x ",'z',"cobblestone",'y',new ItemStack(Ores.items,1,22),'x',"stone"}));
		crafting.add(new ShapedOreRecipe(new ItemStack(Ores.items,2,22),new Object[]{"s s","lxl","s s",'s',Items.string,'l',Items.leather,'x',Items.stick}));
		for(int MT=0;MT<ItemList[0].length;MT++)
		{
			Object obj=ItemList[0][MT];
			for(int TL=0;TL<ItemList.length-1;TL++)
			{
				Item item=(Item)ItemList[TL+1][MT];
				crafting.add(new ShapedOreRecipe(new ItemStack(item),new Object[]{patterns[TL],'x',new ItemStack(Ores.items,1,22),'y',obj}));
			}
		}
		
		crafting.add(new ShapelessOreRecipe(new ItemStack(Items.gunpowder,2),new Object[]{"dustCharcoal","dustSaltpeter","dustSaltpeter","dustSulfur"}));
		crafting.add(new ShapelessOreRecipe(new ItemStack(Items.string,4),new Object[]{new ItemStack(Blocks.wool)}));
		crafting.add(new ShapelessOreRecipe(new ItemStack(Ores.items,1,3),new Object[]{new ItemStack(Ores.mortarandpestle,1,all),"chunkSaltpeter"}));
		crafting.add(new ShapelessOreRecipe(new ItemStack(Ores.items,1,4),new Object[]{new ItemStack(Ores.mortarandpestle,1,all),"chunkSulfur"}));
		crafting.add(new ShapelessOreRecipe(new ItemStack(Ores.items,1,5),new Object[]{new ItemStack(Ores.mortarandpestle,1,all),new ItemStack(Items.coal,1,1)}));
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