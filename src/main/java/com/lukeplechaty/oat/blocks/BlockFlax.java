package com.lukeplechaty.oat.blocks;
import java.util.List;
import java.util.Random;
import com.lukeplechaty.oat.setItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
public class BlockFlax extends BlockBush implements IGrowable
{
	private static final AxisAlignedBB[] Flax_AABB=new AxisAlignedBB[]{new AxisAlignedBB(0.0D,0.0D,0.0D,1.0D,0.0625D,1.0D),new AxisAlignedBB(0.0D,0.0D,0.0D,1.0D,0.1875D,1.0D),new AxisAlignedBB(0.0D,0.0D,0.0D,1.0D,0.3125D,1.0D),new AxisAlignedBB(0.0D,0.0D,0.0D,1.0D,0.4375D,1.0D),new AxisAlignedBB(0.0D,0.0D,0.0D,1.0D,0.5625D,1.0D),new AxisAlignedBB(0.0D,0.0D,0.0D,1.0D,0.6875D,1.0D),new AxisAlignedBB(0.0D,0.0D,0.0D,1.0D,0.8125D,1.0D),new AxisAlignedBB(0.0D,0.0D,0.0D,1.0D,0.9375D,1.0D)};
	public static final PropertyInteger AGE=PropertyInteger.create("age",0,7);
	protected static float getGrowthChance(Block blockIn,World worldIn,BlockPos pos)
	{
		float f=1.0F;
		BlockPos blockpos=pos.down();
		for(int i=-1;i<=1;++i)
		{
			for(int j=-1;j<=1;++j)
			{
				float f1=0.0F;
				IBlockState iblockstate=worldIn.getBlockState(blockpos.add(i,0,j));
				if(iblockstate.getBlock().canSustainPlant(iblockstate,worldIn,blockpos.add(i,0,j),net.minecraft.util.EnumFacing.UP,(net.minecraftforge.common.IPlantable)blockIn))
				{
					f1=1.0F;
					if(iblockstate.getBlock().isFertile(worldIn,blockpos.add(i,0,j)))
					{
						f1=3.0F;
					}
				}
				if(i!=0||j!=0)
				{
					f1/=4.0F;
				}
				f+=f1;
			}
		}
		BlockPos blockpos1=pos.north();
		BlockPos blockpos2=pos.south();
		BlockPos blockpos3=pos.west();
		BlockPos blockpos4=pos.east();
		boolean flag=blockIn==worldIn.getBlockState(blockpos3).getBlock()||blockIn==worldIn.getBlockState(blockpos4).getBlock();
		boolean flag1=blockIn==worldIn.getBlockState(blockpos1).getBlock()||blockIn==worldIn.getBlockState(blockpos2).getBlock();
		if(flag&&flag1)
		{
			f/=2.0F;
		}
		else
		{
			boolean flag2=blockIn==worldIn.getBlockState(blockpos3.north()).getBlock()||blockIn==worldIn.getBlockState(blockpos4.north()).getBlock()||blockIn==worldIn.getBlockState(blockpos4.south()).getBlock()||blockIn==worldIn.getBlockState(blockpos3.south()).getBlock();
			if(flag2)
			{
				f/=2.0F;
			}
		}
		return f;
	}
	public BlockFlax(String name)
	{
		super();
		setDefaultState(blockState.getBaseState().withProperty(getAgeProperty(),Integer.valueOf(0)));
		setTickRandomly(true);
		setCreativeTab((CreativeTabs)null);
		setHardness(0.0F);
		disableStats();
		setSoundType(SoundType.PLANT);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	@Override
	public boolean canBlockStay(World worldIn,BlockPos pos,IBlockState state)
	{
		IBlockState soil=worldIn.getBlockState(pos.down());
		return (worldIn.getLight(pos)>=8||worldIn.canSeeSky(pos))&&soil.getBlock().canSustainPlant(soil,worldIn,pos.down(),net.minecraft.util.EnumFacing.UP,this);
	}
	@Override
	public boolean canGrow(World worldIn,BlockPos pos,IBlockState state,boolean isClient)
	{
		return !isMaxAge(state);
	}
	@Override
	protected boolean canSustainBush(IBlockState state)
	{
		return state.getBlock()==Blocks.FARMLAND;
	}
	@Override
	public boolean canUseBonemeal(World worldIn,Random rand,BlockPos pos,IBlockState state)
	{
		return true;
	}
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this,new IProperty[]{AGE});
	}
	protected int getAge(IBlockState state)
	{
		return state.getValue(this.getAgeProperty()).intValue();
	}
	protected PropertyInteger getAgeProperty()
	{
		return AGE;
	}
	protected int getBonemealAgeIncrease(World worldIn)
	{
		return MathHelper.getRandomIntegerInRange(worldIn.rand,2,5);
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state,IBlockAccess source,BlockPos pos)
	{
		return Flax_AABB[state.getValue(this.getAgeProperty()).intValue()];
	}
	protected Item getCrop()
	{
		return Items.STRING;
	}
	@Override
	public List<ItemStack> getDrops(IBlockAccess world,BlockPos pos,IBlockState state,int fortune)
	{
		List<ItemStack> list=new java.util.ArrayList<ItemStack>();
		int meta=getAge(state);
		Random rand=world instanceof World? ((World)world).rand:new Random();
		for(int amount=0;amount<2+fortune;amount++)
		{
			if(meta>=getMaxAge())
			{
				list.add(new ItemStack(getCrop(),1));
			}
		}
		for(int amount=0;amount<1+fortune;amount++)
		{
			if(rand.nextInt(2*getMaxAge())<=meta)
			{
				list.add(new ItemStack(getSeed(),1,0));
			}
		}
		return list;
	}
	@Override
	public ItemStack getItem(World worldIn,BlockPos pos,IBlockState state)
	{
		return new ItemStack(this.getSeed());
	}
	public int getMaxAge()
	{
		return 7;
	}
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return getAge(state);
	}
	protected Item getSeed()
	{
		return setItems.item_seed;
	}
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.withAge(meta);
	}
	public void grow(World worldIn,BlockPos pos,IBlockState state)
	{
		int meta=getAge(state)+getBonemealAgeIncrease(worldIn);
		int max_meta=getMaxAge();
		if(meta>max_meta)
		{
			meta=max_meta;
		}
		worldIn.setBlockState(pos,withAge(meta),2);
	}
	@Override
	public void grow(World worldIn,Random rand,BlockPos pos,IBlockState state)
	{
		grow(worldIn,pos,state);
	}
	public boolean isMaxAge(IBlockState state)
	{
		return state.getValue(this.getAgeProperty()).intValue()>=this.getMaxAge();
	}
	@Override
	public void updateTick(World worldIn,BlockPos pos,IBlockState state,Random rand)
	{
		super.updateTick(worldIn,pos,state,rand);
		if(worldIn.getLightFromNeighbors(pos.up())>=9)
		{
			int meta=getAge(state);
			if(meta<getMaxAge())
			{
				float f=getGrowthChance(this,worldIn,pos);
				if(rand.nextInt((int)(25.0F/f)+1)==0)
				{
					worldIn.setBlockState(pos,withAge(meta+1),2);
				}
			}
		}
	}
	public IBlockState withAge(int age)
	{
		return this.getDefaultState().withProperty(this.getAgeProperty(),Integer.valueOf(age));
	}
}