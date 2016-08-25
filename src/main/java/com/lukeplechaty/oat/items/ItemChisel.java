package com.lukeplechaty.oat.items;
import java.util.List;
import com.lukeplechaty.oat.Oat;
import com.lukeplechaty.oat.control.ChislHandler;
import com.lukeplechaty.oat.control.Control;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public class ItemChisel extends Item
{
	private static List<Object> worklist0;
	private static List<Object> worklist1;
	private static List<Object> worklist2;
	private static List<Object> worklist3;
	public static void loadlist()
	{
		worklist0=ChislHandler.getlist0();
		worklist1=ChislHandler.getlist1();
		worklist2=ChislHandler.getlist2();
		worklist3=ChislHandler.getlist3();
	}
	private int level;
	public ItemChisel(String name,int damage,int level)
	{
		super();
		setCreativeTab(Oat.tabOres);
		setUnlocalizedName("chisel_"+name);
		setRegistryName("chisel_"+name);
		maxStackSize=1;
		setMaxDamage(damage);
		this.level=level;
	}
	public EnumActionResult get(ItemStack itemstack,EntityPlayer entityplayer,World world,BlockPos pos,EnumFacing facing,ItemStack returnitem,Block block,int level)
	{
		double X=pos.getX()+0.5;
		double Y=pos.getY()+0.5;
		double Z=pos.getZ()+0.5;
		if(facing==EnumFacing.DOWN) Y-=0.7D;
		if(facing==EnumFacing.UP) Y+=0.7D;
		if(facing==EnumFacing.NORTH) Z-=0.7D;
		if(facing==EnumFacing.SOUTH) Z+=0.7D;
		if(facing==EnumFacing.WEST) X-=0.7D;
		if(facing==EnumFacing.EAST) X+=0.7D;
		if(this.level<level) return EnumActionResult.FAIL;
		if(returnitem.getItem()!=null)
		{
			ItemStack returncopy=returnitem.copy();
			EntityItem item=new EntityItem(world,X,Y,Z,returncopy);
			item.motionX=0;
			item.motionY=0;
			item.motionZ=0;
			if(facing==EnumFacing.DOWN) item.motionY=-0.25D;
			if(facing==EnumFacing.UP) item.motionY=+0.25D;
			if(facing==EnumFacing.NORTH) item.motionZ=-0.25D;
			if(facing==EnumFacing.SOUTH) item.motionZ=+0.25D;
			if(facing==EnumFacing.WEST) item.motionX=-0.25D;
			if(facing==EnumFacing.EAST) item.motionX=+0.25D;
			item.setDefaultPickupDelay();
			world.spawnEntityInWorld(item);
		}
		itemstack.damageItem(1,entityplayer);
		if(block==Blocks.AIR) world.setBlockToAir(pos);
		else world.setBlockState(pos,block.getDefaultState(),3);
		return EnumActionResult.SUCCESS;
	}
	public EnumActionResult list(ItemStack itemstack,EntityPlayer entityplayer,World world,BlockPos pos,EnumFacing facing)
	{
		try
		{
			for(int id=0;id<worklist0.size();id++)
			{
				Object[] list=(Object[])worklist0.get(id);
				if(Control.getOre((Block)list[0],(Integer)list[1],pos,world))
				{
					return get(itemstack,entityplayer,world,pos,facing,(ItemStack)list[2],(Block)list[3],((Integer)list[4]).intValue());
				}
			}
			for(int id=0;id<worklist1.size();id++)
			{
				Object[] list=(Object[])worklist1.get(id);
				if(Control.getOre((String)list[0],pos,world))
				{
					return get(itemstack,entityplayer,world,pos,facing,Control.getOre((String)list[1],(Integer)list[2]),(Block)list[3],((Integer)list[4]).intValue());
				}
			}
			for(int id=0;id<worklist2.size();id++)
			{
				Object[] list=(Object[])worklist2.get(id);
				if(Control.getOre((Block)list[0],(Integer)list[1],pos,world))
				{
					return get(itemstack,entityplayer,world,pos,facing,Control.getOre((String)list[2],(Integer)list[3]),(Block)list[4],((Integer)list[5]).intValue());
				}
			}
			for(int id=0;id<worklist3.size();id++)
			{
				Object[] list=(Object[])worklist3.get(id);
				if(Control.getOre((String)list[0],pos,world))
				{
					return get(itemstack,entityplayer,world,pos,facing,(ItemStack)list[1],(Block)list[2],((Integer)list[3]).intValue());
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Chisel not working: "+e);
		}
		return EnumActionResult.FAIL;
	}
	@Override
	public EnumActionResult onItemUse(ItemStack itemstack,EntityPlayer EntityPlayer,World world,BlockPos pos,EnumHand hand,EnumFacing facing,float hitX,float hitY,float hitZ)
	{
		if(world.isRemote) return EnumActionResult.SUCCESS;
		return list(itemstack,EntityPlayer,world,pos,facing);
	}
}