package com.lukeplechaty.ores.items;
import com.lukeplechaty.ores.Ores;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.world.World;
public class ItemMachete extends Item
{
	public ItemMachete(String name,int damage,int mobdamage,float power)
	{
		super();
		if(Ores.debug)System.out.println("adding machete "+name);
		setCreativeTab(Ores.tabOres);
		setTextureName("ores:machete_"+name);
		setUnlocalizedName("machete_"+name);
		maxStackSize=1;
		setMaxDamage(damage);
		toolDamage=2+mobdamage;
		toolPower=power;
	}
	public boolean hitEntity(ItemStack itemstack,EntityLivingBase entitylivingbase1,EntityLivingBase entitylivingbase2)
	{
		itemstack.damageItem(1,entitylivingbase2);
		return true;
	}
	public float getDamageVsEntity()
	{
		return toolDamage;
	}
	public float func_150893_a(ItemStack itemstack,Block block)
	{
		if(Blocks.leaves==block)return toolPower;
		return 1.0F;
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
				for(int newy=-size;newy<=size;newy++)
				{
					Block blockID=block.getBlock(x+newX,y+newy,z+newZ);
					int blockMeta=block.getBlockMetadata(x+newX,y+newy,z+newZ);
					if(blockID==Blocks.air)continue;
					Block list=blockID;
					if(!(list instanceof BlockLeaves))continue;
					boolean newBlock=block.setBlock(x+newX,y+newy,z+newZ,Blocks.air);
					if(!newBlock)continue;
					if(list.canHarvestBlock((EntityPlayer)entitylivingbase,blockMeta))
					{
						list.harvestBlock(block,(EntityPlayer)entitylivingbase,x+newX,y+newy,z+newZ,blockMeta);
						itemstack.damageItem(1,entitylivingbase);
					}
					done=true;
				}
			}
		}
		return done;
	}
    private int toolDamage;
    private float toolPower;
}