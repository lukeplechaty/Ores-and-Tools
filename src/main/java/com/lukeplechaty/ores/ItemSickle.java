package com.lukeplechaty.ores;
import net.minecraft.block.*;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.world.World;
public class ItemSickle extends Item
{
	public ItemSickle(String name,int damage)
	{
		super();
		if(Ores.debug)System.out.println("adding sickle "+name);
		setCreativeTab(Ores.tabOres);
		setTextureName("ores:sickle_"+name);
		setUnlocalizedName("sickle_"+name);
		maxStackSize=1;
		setMaxDamage(damage);
	}
	public boolean onBlockDestroyed(ItemStack itemstack,World world,Block i,int x,int y,int z,EntityLivingBase entitylivingbase)
	{
		boolean done=false;
		World block=entitylivingbase.worldObj;
		int size=2;
		for(int newX=-size;newX<=size;newX++)
		{
			for(int newZ=-size;newZ<=size;newZ++)
			{
				Block blockID=block.getBlock(x+newX,y,z+newZ);
				int blockMeta=block.getBlockMetadata(x+newX,y,z+newZ);
				if(blockID==Blocks.air)continue;
				Block list=blockID;
				if(!(list instanceof BlockBush))continue;
				boolean newBlock=block.setBlock(x+newX,y,z+newZ,Blocks.air);
				if(!newBlock)continue;
				if(list.canHarvestBlock((EntityPlayer)entitylivingbase,blockMeta))
				{
					list.harvestBlock(block,(EntityPlayer)entitylivingbase,x+newX,y,z+newZ,blockMeta);
					itemstack.damageItem(1,entitylivingbase);
				}
				done=true;
			}
		}
		return done;
	}
}