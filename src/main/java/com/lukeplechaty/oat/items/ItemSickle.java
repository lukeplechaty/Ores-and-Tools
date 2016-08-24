package com.lukeplechaty.oat.items;
import com.lukeplechaty.oat.Ores;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public class ItemSickle extends Item
{
	public ItemSickle(String name,int damage)
	{
		super();
		setCreativeTab(Ores.tabOres);
		setUnlocalizedName("sickle_"+name);
		setRegistryName("sickle_"+name);
		maxStackSize=1;
		setMaxDamage(damage);
	}
	@Override
	public boolean onBlockDestroyed(ItemStack itemstack,World world,IBlockState state,BlockPos pos,EntityLivingBase entityLiving)
	{
		boolean done=false;
		World obj=entityLiving.worldObj;
		int size=2;
		for(int newX=-size;newX<=size;newX++)
		{
			for(int newZ=-size;newZ<=size;newZ++)
			{
				BlockPos pos2=pos.add(newX,0,newZ);
				Block blockID=obj.getBlockState(pos2).getBlock();
				if(blockID==Blocks.AIR) continue;
				Block list=blockID;
				if(!(list instanceof BlockBush)) continue;
				boolean newBlock=obj.setBlockToAir(pos2);
				if(!newBlock) continue;
				if(list.canHarvestBlock(world,pos2,(EntityPlayer)entityLiving))
				{
					list.harvestBlock(world,(EntityPlayer)entityLiving,pos2,state,null,itemstack);
					itemstack.damageItem(1,entityLiving);
				}
				done=true;
			}
		}
		return done;
	}
}