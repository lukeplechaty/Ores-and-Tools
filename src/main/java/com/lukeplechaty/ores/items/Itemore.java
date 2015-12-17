package com.lukeplechaty.ores.items;
import java.util.List;
import com.lukeplechaty.ores.Ores;
import net.minecraft.block.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.IIcon;
import net.minecraft.world.*;
public class Itemore extends Item
{
    private String[] names=new String[]{
    		"seed",
    		"sodium",
    		"sulfur",
    		"handel"};
	private IIcon[] textures=new IIcon[names.length];
	public Itemore()
	{
		super();
		if(Ores.debug)System.out.println("adding items");
		setUnlocalizedName("ore");
		setCreativeTab(Ores.tabOres);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
	    for (int amount=0;amount<textures.length;amount++)
	    {
	    	list.add(new ItemStack(this,1,amount));
	    }
	}
	public IIcon getIconFromDamage(int meta)
	{
		return textures[meta];
	}
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return names[itemStack.getItemDamage()];
	}
	public boolean onItemUse(ItemStack itemStack,EntityPlayer entityplayer,World world,int x,int y,int z,int meta,float xf,float yf,float zf)
	{
		if(itemStack.getUnlocalizedName()=="seed")
		{
			if(meta!=1)
			{
				return false;
			}
			if(!entityplayer.canPlayerEdit(x,y,z,meta,itemStack)||!entityplayer.canPlayerEdit(x,y+1,z,meta,itemStack))
			{
				return false;
			}
			Block block=world.getBlock(x,y,z);
			if(block==Blocks.farmland && world.isAirBlock(x,y+1,z))
			{
				world.setBlock(x,y+1,z,Ores.crop);
				itemStack.stackSize--;
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}
	public void registerIcons(IIconRegister register)
	{
	    for (int amount=0;amount<textures.length;amount++)
	    {
	    	this.textures[amount] = register.registerIcon("ores:"+names[amount]);
	    }
	}
}