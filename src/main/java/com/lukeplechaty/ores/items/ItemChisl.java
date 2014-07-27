package com.lukeplechaty.ores.items;
import java.util.List;
import com.lukeplechaty.ores.Ores;
import com.lukeplechaty.ores.control.ChislHandler;
import com.lukeplechaty.ores.control.OresControl;
import net.minecraft.block.Block;
import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;
public class ItemChisl extends Item
{
	public ItemChisl(String name,int damage,int level)
	{
		super();
		if(Ores.debug)System.out.println("adding chisel "+name);
		setCreativeTab(Ores.tabOres);
		setTextureName("ores:chisel_"+name);
		setUnlocalizedName("chisel_"+name);
		maxStackSize=1;
		setMaxDamage(damage);
		this.level=level;
	}
	private int level;
	private static List<Object> worklist0;
	private static List<Object> worklist1;
	private static List<Object> worklist2;
	private static List<Object> worklist3;
	public static void loadlist()
	{
		if(Ores.debug)System.out.println("loading chisl list");
		worklist0=ChislHandler.getlist0();
		worklist1=ChislHandler.getlist1();
		worklist2=ChislHandler.getlist2();
		worklist3=ChislHandler.getlist3();
	}
	public boolean get(ItemStack itemstack,EntityPlayer entityplayer,World world,int x,int y,int z,int side,ItemStack returnitem,ItemStack block,int level)
	{
		double X=x+0.5;
		double Y=y+0.5;
		double Z=z+0.5;
		if(side==0)Y-=0.7D;
		if(side==1)Y+=0.7D;
		if(side==2)Z-=0.7D;
		if(side==3)Z+=0.7D;
		if(side==4)X-=0.7D;
		if(side==5)X+=0.7D;
		if(this.level<level)return false;
		if(returnitem.getItem()!=null)
		{
			ItemStack returncopy = returnitem.copy();
			EntityItem item=new EntityItem(world,X,Y,Z,returncopy);
			item.motionX=0;
			item.motionY=0;
			item.motionZ=0;
			if(side==0)item.motionY=-0.25D;
			if(side==1)item.motionY=+0.25D;
			if(side==2)item.motionZ=-0.25D;
			if(side==3)item.motionZ=+0.25D;
			if(side==4)item.motionX=-0.25D;
			if(side==5)item.motionX=+0.25D;
			item.delayBeforeCanPickup=10;
			world.spawnEntityInWorld(item);
		}
		itemstack.damageItem(1,entityplayer);
		if(Block.getBlockFromItem(block.getItem())==Blocks.air) world.setBlockToAir(x,y,z);
		else world.setBlock(x,y,z,Block.getBlockFromItem(block.getItem()),block.getItemDamage(),3);
		return true;
	}
	public boolean list(ItemStack itemstack,EntityPlayer entityplayer,World world,int x,int y,int z,int side)
	{
		try
		{
			for(int id=0;id<worklist0.size();id++)
			{
				Object[] list=(Object[])worklist0.get(id);
				if(OresControl.getOre((ItemStack)list[0],x,y,z,world))
				{
					get(itemstack,entityplayer,world,x,y,z,side,(ItemStack)list[1],(ItemStack)list[2],((Integer)list[3]).intValue());
				}
			}
			for(int id=0;id<worklist1.size();id++)
			{
				Object[] list=(Object[])worklist1.get(id);
				if(OresControl.getOre((String)list[0],x,y,z,world))
				{
					get(itemstack,entityplayer,world,x,y,z,side,OresControl.getOre((String)list[1]),(ItemStack)list[2],((Integer)list[3]).intValue());
				}
			}
			for(int id=0;id<worklist2.size();id++)
			{
				Object[] list=(Object[])worklist2.get(id);
				if(OresControl.getOre((ItemStack)list[0],x,y,z,world))
				{
					get(itemstack,entityplayer,world,x,y,z,side,OresControl.getOre((String)list[1]),(ItemStack)list[2],((Integer)list[3]).intValue());
				}
			}
			for(int id=0;id<worklist3.size();id++)
			{
				Object[] list=(Object[])worklist3.get(id);
				if(OresControl.getOre((String)list[0],x,y,z,world))
				{
					get(itemstack,entityplayer,world,x,y,z,side,(ItemStack)list[1],(ItemStack)list[2],((Integer)list[3]).intValue());
				}
			}
		}
		catch(Exception e){System.out.println("Chisl not working: "+e);}
		return false;
	}
	public boolean onItemUse(ItemStack itemstack,EntityPlayer EntityPlayer,World world,int x,int y,int z,int side,float i,float j,float k)
	{
		if(world.isRemote)return true;
		return list(itemstack,EntityPlayer,world,x,y,z,side);
	}
}