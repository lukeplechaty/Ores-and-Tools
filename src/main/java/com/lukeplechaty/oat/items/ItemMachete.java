package com.lukeplechaty.oat.items;
import com.lukeplechaty.oat.Oat;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public class ItemMachete extends Item
{
	private float attackDamage;
	private float toolPower;
	public ItemMachete(String name,int damage,int mobdamage,float power)
	{
		super();
		setCreativeTab(Oat.tabOres);
		setUnlocalizedName("machete_"+name);
		setRegistryName("machete_"+name);
		maxStackSize=1;
		setMaxDamage(damage);
		toolPower=power;
		attackDamage=mobdamage;
		
	}
    public float getDamageVsEntity()
    {
        return attackDamage;
    }
	@Override
	public float getStrVsBlock(ItemStack stack,IBlockState state)
	{
		if(state.getBlock() instanceof BlockLeaves) return toolPower;
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
					IBlockState sta=obj.getBlockState(pos2);
					Block block=sta.getBlock();
					if(block instanceof BlockLeaves)
					{
						block.dropBlockAsItem(world,pos2,sta,0);
						world.setBlockToAir(pos2);
						itemstack.damageItem(1,entityLiving);
						done=true;
					}
				}
			}
		}
		return done;
	}
}