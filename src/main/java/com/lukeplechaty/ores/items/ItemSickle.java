package com.lukeplechaty.ores.items;
import com.lukeplechaty.ores.Ores;
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
	public boolean onBlockDestroyed(ItemStack itemstack,World world,Block block,int x,int y,int z,EntityLivingBase entitylivingbase)
	{
		boolean done=false;
		World obj=entitylivingbase.worldObj;
		int size=2;
		for(int newX=-size;newX<=size;newX++)
		{
			for(int newZ=-size;newZ<=size;newZ++)
			{
				Block blockID=obj.getBlock(x+newX,y,z+newZ);
				int blockMeta=obj.getBlockMetadata(x+newX,y,z+newZ);
				if(blockID==Blocks.air)continue;
				Block list=blockID;
				if(!(list instanceof BlockBush))continue;
				boolean newBlock=obj.setBlock(x+newX,y,z+newZ,Blocks.air);
				if(!newBlock)continue;
				if(list.canHarvestBlock((EntityPlayer)entitylivingbase,blockMeta))
				{
					list.harvestBlock(obj,(EntityPlayer)entitylivingbase,x+newX,y,z+newZ,blockMeta);
					itemstack.damageItem(1,entitylivingbase);
				}
				done=true;
			}
		}
		return done;
	}
}