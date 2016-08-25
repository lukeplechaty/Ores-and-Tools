package com.lukeplechaty.oat.control;
import java.util.Random;
import com.lukeplechaty.oat.setBlocks;
import com.lukeplechaty.oat.setItems;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
public class GenOres implements IWorldGenerator
{
	public static boolean generate(World world,Random random,int x,int y,int z,Block ID,int NUM)
	{
		float f=random.nextFloat()*3.141593F;
		double d=x+8+(MathHelper.sin(f)*NUM)/8F;
		double d1=x+8-(MathHelper.sin(f)*NUM)/8F;
		double d2=z+8+(MathHelper.cos(f)*NUM)/8F;
		double d3=z+8-(MathHelper.cos(f)*NUM)/8F;
		double d4=(y+random.nextInt(3))-2;
		double d5=(y+random.nextInt(3))-2;
		for(int i=0;i<=NUM;i++)
		{
			double d6=d+((d1-d)*i)/NUM;
			double d7=d4+((d5-d4)*i)/NUM;
			double d8=d2+((d3-d2)*i)/NUM;
			double d9=(random.nextDouble()*NUM)/16D;
			double d10=(MathHelper.sin((i*3.141593F)/NUM)+1.0F)*d9+1.0D;
			double d11=(MathHelper.sin((i*3.141593F)/NUM)+1.0F)*d9+1.0D;
			int i1=MathHelper.floor_double(d6-d10/2D);
			int i2=MathHelper.floor_double(d7-d11/2D);
			int i3=MathHelper.floor_double(d8-d10/2D);
			int i4=MathHelper.floor_double(d6+d10/2D);
			int i5=MathHelper.floor_double(d7+d11/2D);
			int i6=MathHelper.floor_double(d8+d10/2D);
			for(int i7=i1;i7<=i4;i7++)
			{
				double d12=((i7+0.5D)-d6)/(d10/2D);
				if(d12*d12>=1.0D) continue;
				for(int i8=i2;i8<=i5;i8++)
				{
					double d13=((i8+0.5D)-d7)/(d11/2D);
					if(d12*d12+d13*d13>=1.0D) continue;
					for(int i9=i3;i9<=i6;i9++)
					{
						BlockPos pos=new BlockPos(i7,i8,i9);
						double d14=((i9+0.5D)-d8)/(d10/2D);
						if(d12*d12+d13*d13+d14*d14<1.0D&&world.getBlockState(pos).getBlock()==Blocks.STONE)
						{
							IBlockState state=ID.getDefaultState();
							world.setBlockState(pos,state);
						}
					}
				}
			}
		}
		return true;
	}
	public static void generateSurface(World world,Random random,int x,int z)
	{
		if(setItems.genores)
		{
			for(int amount=0;amount<20;amount++)
			{
				generate(world,random,x+random.nextInt(16),random.nextInt(64),z+random.nextInt(16),setBlocks.orefossils,4);
			}
			for(int amount=0;amount<20;amount++)
			{
				generate(world,random,x+random.nextInt(16),random.nextInt(64),z+random.nextInt(16),setBlocks.oresodium,4);
			}
			for(int amount=0;amount<20;amount++)
			{
				generate(world,random,x+random.nextInt(16),random.nextInt(32),z+random.nextInt(16),setBlocks.oresulfur,4);
			}
		}
	}
	@Override
	public void generate(Random random,int x,int z,World world,IChunkGenerator chunkGenerator,IChunkProvider chunkProvider)
	{
		if(!(world.provider.getDimension()==-1)||!(world.provider.getDimension()==1))
		{
			generateSurface(world,random,x*16,z*16);
		}
	}
}