package com.lukeplechaty.ores.blocks;
import java.util.ArrayList;
import java.util.Random;
import com.lukeplechaty.ores.Ores;
import net.minecraft.block.*;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
public class BlockFlax extends BlockBush implements IGrowable
{
	private IIcon[] textures=new IIcon[8];
	public BlockFlax()
	{
		super();
		if(Ores.debug)System.out.println("adding crop");
        this.setStepSound(soundTypeGrass);
        setCreativeTab((CreativeTabs)null);
        setBlockName("flax");
		setTickRandomly(true);
		setBlockBounds(0.0F,0.0F,0.0F,1.0F,0.25F,1.0F);
	}
	public IIcon getIcon(int side,int meta)
	{
		return textures[meta];
	}
	protected boolean canPlaceBlockOn(Block block)
	{
		return block==Blocks.farmland;
	}
	public void updateTick(World world,int x,int y,int z,Random random)
	{
		super.updateTick(world,x,y,z,random);
		if(world.getBlockLightValue(x,y+1,z)>=9)
		{
			int meta=world.getBlockMetadata(x,y,z);
			if(meta<7)
			{
				float grow=grow(world,x,y,z);
				if(random.nextInt((int)(25F/grow))==0)
				{
					meta++;
					world.setBlockMetadataWithNotify(x,y,z,meta,2);
				}
			}
		}
	}
	public void fertilize(World world,int x,int y,int z)
	{
		int meta=world.getBlockMetadata(x,y,z)+MathHelper.getRandomIntegerInRange(world.rand,2,5);
		if(meta>7)
		{
			meta=7;
		}
		world.setBlockMetadataWithNotify(x,y,z,meta,2);
	}
	private float grow(World world,int x,int y,int z)
	{
		float f=1.0F;
		Block l=world.getBlock(x,y,z-1);
		Block i1=world.getBlock(x,y,z+1);
		Block j1=world.getBlock(x-1,y,z);
		Block k1=world.getBlock(x+1,y,z);
		Block l1=world.getBlock(x-1,y,z-1);
		Block i2=world.getBlock(x+1,y,z-1);
		Block j2=world.getBlock(x+1,y,z+1);
		Block k2=world.getBlock(x-1,y,z+1);
		boolean flag=j1==this||k1==this;
		boolean flag1=l==this||i1==this;
		boolean flag2=l1==this||i2==this||j2==this||k2==this;
		for(int l2=x-1;l2<=x+1;l2++)
		{
			for(int i3=z-1;i3<=z+1;i3++)
			{
				Block block=world.getBlock(l2,y-1,i3);
				float f1=0.0F;
				if(block==Blocks.farmland)
				{
					f1=1.0F;
					if(world.getBlockMetadata(l2,y-1,i3)>0)
					{
						f1=3.0F;
					}
				}
				if(l2!=x||i3!=z)
				{
					f1/=4.0F;
				}
				f+=f1;
			}
		}
		if(flag2||flag&&flag1)
		{
			f/=2.0F;
		}
		return f;
	}
	public int getRenderType()
	{
		return 6;
	}
	public ArrayList getDrops(World world,int x,int y,int z,int meta,int fortune)
	{
		ArrayList<ItemStack> list=new ArrayList<ItemStack>();
		for(int amount=0;amount<2+fortune;amount++)
		{
			if(meta==7)
			{
				list.add(new ItemStack(Items.string,1));
			}
		}
		for(int amount=0;amount<3+fortune;amount++)
		{
			if(world.rand.nextInt(15)<=meta)
			{
				list.add(new ItemStack(Ores.items,1,0));
			}
		}
		return list;
	}
	public void registerBlockIcons(IIconRegister register)
	{
		for(int id=0;id<textures.length;++id)
        {
            this.textures[id]=register.registerIcon("ores:crop_"+id);
        }
	}
	public boolean func_149851_a(World world,int x,int y,int z,boolean var0)
	{
		return world.getBlockMetadata(x,y,z)!=7;
	}
	public boolean func_149852_a(World world,Random random,int x,int y,int z)
	{
		return true;
	}
	public void func_149853_b(World world,Random random,int x,int y,int z)
	{
		fertilize(world,x,y,z);
	}
}