package com.lukeplechaty.oat.items;
import com.lukeplechaty.oat.setTabs;
import com.lukeplechaty.oat.control.ChislHandler;
import com.lukeplechaty.oat.control.ChislParts;
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
	private int level;
	
	public ItemChisel(String name, int damage, int level)
	{
		super();
		setCreativeTab(setTabs.tabTools);
		setUnlocalizedName("chisel_" + name);
		setRegistryName("chisel_" + name);
		maxStackSize = 1;
		setMaxDamage(damage);
		this.level = level;
	}
	
	public EnumActionResult get(EntityPlayer entityplayer, World world, BlockPos pos, EnumHand hand, EnumFacing facing, ItemStack returnitem, Block block, int level)
	{
		double X = pos.getX() + 0.5;
		double Y = pos.getY() + 0.5;
		double Z = pos.getZ() + 0.5;
		if(facing == EnumFacing.DOWN) Y -= 0.7D;
		if(facing == EnumFacing.UP) Y += 0.7D;
		if(facing == EnumFacing.NORTH) Z -= 0.7D;
		if(facing == EnumFacing.SOUTH) Z += 0.7D;
		if(facing == EnumFacing.WEST) X -= 0.7D;
		if(facing == EnumFacing.EAST) X += 0.7D;
		if(this.level < level) return EnumActionResult.FAIL;
		if(returnitem.getItem() != null)
		{
			ItemStack returncopy = returnitem.copy();
			EntityItem item = new EntityItem(world, X, Y, Z, returncopy);
			item.motionX = 0;
			item.motionY = 0;
			item.motionZ = 0;
			if(facing == EnumFacing.DOWN) item.motionY = -0.25D;
			if(facing == EnumFacing.UP) item.motionY = +0.25D;
			if(facing == EnumFacing.NORTH) item.motionZ = -0.25D;
			if(facing == EnumFacing.SOUTH) item.motionZ = +0.25D;
			if(facing == EnumFacing.WEST) item.motionX = -0.25D;
			if(facing == EnumFacing.EAST) item.motionX = +0.25D;
			item.setDefaultPickupDelay();
			world.spawnEntity(item);
		}
		entityplayer.getHeldItem(hand).damageItem(1, entityplayer);
		if(block == Blocks.AIR) world.setBlockToAir(pos);
		else world.setBlockState(pos, block.getDefaultState(), 3);
		return EnumActionResult.SUCCESS;
	}
	
	public EnumActionResult list(EntityPlayer entityplayer, World world, BlockPos pos, EnumHand hand, EnumFacing facing)
	{
		try
		{
			for(ChislParts part : ChislHandler.getlist0())
			{
				if(Control.getOre(part.blockin, part.meta, pos, world))
				{
					return get(entityplayer, world, pos, hand, facing, part.itemstackOut, part.left, part.toollevel);
				}
			}
			for(ChislParts part : ChislHandler.getlist1())
			{
				if(Control.getOre(part.stringIn, pos, world))
				{
					return get(entityplayer, world, pos, hand, facing, Control.getOre(part.stringOut, part.stackSize), part.left, part.toollevel);
				}
			}
			for(ChislParts part : ChislHandler.getlist2())
			{
				if(Control.getOre(part.blockin, part.meta, pos, world))
				{
					return get(entityplayer, world, pos, hand, facing, Control.getOre(part.stringOut, part.stackSize), part.left, part.toollevel);
				}
			}
			for(ChislParts part : ChislHandler.getlist3())
			{
				if(Control.getOre(part.stringIn, pos, world))
				{
					return get(entityplayer, world, pos, hand, facing, part.itemstackOut, part.left, part.toollevel);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Chisel not working: " + e);
		}
		return EnumActionResult.FAIL;
	}
	
	public EnumActionResult onItemUse(EntityPlayer EntityPlayer, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(world.isRemote) return EnumActionResult.SUCCESS;
		return list(EntityPlayer, world, pos, hand, facing);
	}
}
