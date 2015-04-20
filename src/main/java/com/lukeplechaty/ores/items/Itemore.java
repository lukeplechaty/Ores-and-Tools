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
	public void getSubItems(Item i, CreativeTabs c, List l)
	{
	    for (int x=0;x<textures.length;x++)
	    {
	        l.add(new ItemStack(this,1,x));
	    }
	}
	public IIcon getIconFromDamage(int i)
	{
		return textures[i];
	}
	public String getUnlocalizedName(ItemStack i)
	{
		return names[i.getItemDamage()];
	}
	public boolean onItemUse(ItemStack a,EntityPlayer b,World c,int i,int j,int k,int l,float m,float n,float o)
	{
		if(a.getItemDamage()==0)
		{
			if(l!=1)
			{
				return false;
			}
			if(!b.canPlayerEdit(i,j,k,l,a)||!b.canPlayerEdit(i,j+1,k,l,a))
			{
				return false;
			}
			Block p=c.getBlock(i,j,k);
			if(p==Blocks.farmland&&c.isAirBlock(i,j+1,k))
			{
				c.setBlock(i,j+1,k,Ores.crop);
				a.stackSize--;
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
	    for (int x=0;x<textures.length;x++)
	    {
	    	this.textures[x] = register.registerIcon("ores:"+names[x]);
	    }
	}
}