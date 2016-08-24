package com.lukeplechaty.oat.items;
import com.lukeplechaty.oat.Ores;
import com.lukeplechaty.oat.setBlocks;
import com.lukeplechaty.oat.setItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public class Itemore extends Item
{
	public Itemore(String name)
	{
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Ores.tabOres);
		setMaxDamage(0);
	}
	@Override
	public EnumActionResult onItemUse(ItemStack itemstack,EntityPlayer EntityPlayer,World world,BlockPos pos,EnumHand hand,EnumFacing facing,float hitX,float hitY,float hitZ)
	{
		if(itemstack.getItem()==setItems.seed)
		{
			if(!EntityPlayer.canPlayerEdit(pos,facing,itemstack)||!EntityPlayer.canPlayerEdit(pos.down(),facing,itemstack))
			{
				return EnumActionResult.FAIL;
			}
			Block block=world.getBlockState(pos).getBlock();
			if(block==Blocks.FARMLAND&&world.isAirBlock(pos.up()))
			{
				world.setBlockState(pos.up(),setBlocks.crop.getDefaultState());
				itemstack.stackSize--;
				return EnumActionResult.SUCCESS;
			}
			else
			{
				return EnumActionResult.FAIL;
			}
		}
		return EnumActionResult.FAIL;
	}
}