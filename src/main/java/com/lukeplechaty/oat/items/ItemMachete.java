package com.lukeplechaty.oat.items;
import com.lukeplechaty.oat.Ores;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public class ItemMachete extends Item
{
	private float toolPower;
	public ItemMachete(String name,int damage,int mobdamage,float power)
	{
		super();
		setCreativeTab(Ores.tabOres);
		setUnlocalizedName("machete_"+name);
		setRegistryName("machete_"+name);
		maxStackSize=1;
		setMaxDamage(damage);
		toolPower=power;
	}
	@Override
	public float getStrVsBlock(ItemStack stack,IBlockState state)
	{
		if(Blocks.LEAVES==state||Blocks.LEAVES2==state) return toolPower;
		return 1.0F;
	}
	@Override
	public boolean hitEntity(ItemStack itemstack,EntityLivingBase target,EntityLivingBase attacker)
	{
		itemstack.damageItem(1,attacker);
		return true;
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
				for(int newy=-size;newy<=size;newy++)
				{
					BlockPos pos2=pos.add(newX,newy,newZ);
					Block blockID=obj.getBlockState(pos2).getBlock();
					if(blockID==Blocks.AIR) continue;
					Block list=blockID;
					if(!(list instanceof BlockLeaves)) continue;
					boolean newBlock=obj.setBlockToAir(pos2);
					if(!newBlock) continue;
					if(list.canHarvestBlock(world,pos,(EntityPlayer)entityLiving))
					{
						list.harvestBlock(world,(EntityPlayer)entityLiving,pos,state,null,itemstack);
						itemstack.damageItem(1,entityLiving);
					}
					done=true;
				}
			}
		}
		return done;
	}
}