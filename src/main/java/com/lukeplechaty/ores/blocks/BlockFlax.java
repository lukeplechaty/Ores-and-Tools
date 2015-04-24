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
	public IIcon getIcon(int i,int j)
	{
		return textures[j];
	}
	protected boolean canPlaceBlockOn(Block i)
	{
		return i==Blocks.farmland;
	}
	public void updateTick(World a,int i,int j,int k,Random b)
	{
		super.updateTick(a,i,j,k,b);
		if(a.getBlockLightValue(i,j+1,k)>=9)
		{
			int l=a.getBlockMetadata(i,j,k);
			if(l<7)
			{
				float f=grow(a,i,j,k);
				if(b.nextInt((int)(25F/f))==0)
				{
					l++;
					a.setBlockMetadataWithNotify(i,j,k,l,2);
				}
			}
		}
	}
	public void fertilize(World a,int i,int j,int k)
	{
		int l=a.getBlockMetadata(i,j,k)+MathHelper.getRandomIntegerInRange(a.rand,2,5);
		if(l>7)
		{
			l=7;
		}
		a.setBlockMetadataWithNotify(i,j,k,l,2);
	}
	private float grow(World a,int i,int j,int k)
	{
		float f=1.0F;
		Block l=a.getBlock(i,j,k-1);
		Block i1=a.getBlock(i,j,k+1);
		Block j1=a.getBlock(i-1,j,k);
		Block k1=a.getBlock(i+1,j,k);
		Block l1=a.getBlock(i-1,j,k-1);
		Block i2=a.getBlock(i+1,j,k-1);
		Block j2=a.getBlock(i+1,j,k+1);
		Block k2=a.getBlock(i-1,j,k+1);
		boolean flag=j1==this||k1==this;
		boolean flag1=l==this||i1==this;
		boolean flag2=l1==this||i2==this||j2==this||k2==this;
		for(int l2=i-1;l2<=i+1;l2++)
		{
			for(int i3=k-1;i3<=k+1;i3++)
			{
				Block j3=a.getBlock(l2,j-1,i3);
				float f1=0.0F;
				if(j3==Blocks.farmland)
				{
					f1=1.0F;
					if(a.getBlockMetadata(l2,j-1,i3)>0)
					{
						f1=3.0F;
					}
				}
				if(l2!=i||i3!=k)
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
	public ArrayList getDrops(World a,int i,int j,int k,int l,int m)
	{
		ArrayList<ItemStack> b=new ArrayList<ItemStack>();
		for(int n=0;n<2+m;n++)
		{
			if(l==7)
			{
				b.add(new ItemStack(Items.string,1));
			}
		}
		for(int n=0;n<3+m;n++)
		{
			if(a.rand.nextInt(15)<=l)
			{
				b.add(new ItemStack(Ores.items,1,0));
			}
		}
		return b;
	}
	public void registerBlockIcons(IIconRegister register)
	{
		for(int i=0;i<textures.length;++i)
        {
            this.textures[i]=register.registerIcon("ores:crop_"+i);
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