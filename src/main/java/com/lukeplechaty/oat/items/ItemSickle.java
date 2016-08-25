package com.lukeplechaty.oat.items;
import com.lukeplechaty.oat.Oat;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public class ItemSickle extends Item
{
	public ItemSickle(String name,int damage)
	{
		super();
		setCreativeTab(Oat.tabOres);
		setUnlocalizedName("sickle_"+name);
		setRegistryName("sickle_"+name);
		maxStackSize=1;
		setMaxDamage(damage);
	}
    public boolean canHarvestBlock(IBlockState block)
    {
        return block instanceof BlockBush;
    }
	@Override
	public boolean onBlockDestroyed(ItemStack itemstack,World world,IBlockState state,BlockPos pos,EntityLivingBase entityLiving)
	{
		boolean done=false;
		int size=2;
		for(int newX=-size;newX<=size;newX++)
		{
			for(int newZ=-size;newZ<=size;newZ++)
			{
				BlockPos pos2=pos.add(newX,0,newZ);
				IBlockState sta=world.getBlockState(pos2);
				Block block=sta.getBlock();
				if((block instanceof BlockBush) || (block instanceof BlockFlower) || (block instanceof BlockDoublePlant))
				{
					block.dropBlockAsItem(world,pos2,sta,0);
					world.setBlockToAir(pos2);
					itemstack.damageItem(1,entityLiving);
					done=true;
				}
			}
		}
		return done;
	}
}