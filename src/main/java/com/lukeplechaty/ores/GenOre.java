package com.lukeplechaty.ores;
import java.util.Random;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
public class GenOre implements IWorldGenerator
{
	public static boolean generate(World world,Random random,int x,int y,int z,Block ID,int NUM, int META)
	{
		float f=random.nextFloat()*3.141593F;
		double d=(float)(x+8)+(MathHelper.sin(f)*(float)NUM)/8F;
		double d1=(float)(x+8)-(MathHelper.sin(f)*(float)NUM)/8F;
		double d2=(float)(z+8)+(MathHelper.cos(f)*(float)NUM)/8F;
		double d3=(float)(z+8)-(MathHelper.cos(f)*(float)NUM)/8F;
		double d4=(y+random.nextInt(3))-2;
		double d5=(y+random.nextInt(3))-2;
		for(int i=0;i<=NUM;i++)
		{
			double d6=d+((d1-d)*(double)i)/(double)NUM;
			double d7=d4+((d5-d4)*(double)i)/(double)NUM;
			double d8=d2+((d3-d2)*(double)i)/(double)NUM;
			double d9=(random.nextDouble()*(double)NUM)/16D;
			double d10=(double)(MathHelper.sin(((float)i*3.141593F)/(float)NUM)+1.0F)*d9+1.0D;
			double d11=(double)(MathHelper.sin(((float)i*3.141593F)/(float)NUM)+1.0F)*d9+1.0D;
			int i1=MathHelper.floor_double(d6-d10/2D);
			int i2=MathHelper.floor_double(d7-d11/2D);
			int i3=MathHelper.floor_double(d8-d10/2D);
			int i4=MathHelper.floor_double(d6+d10/2D);
			int i5=MathHelper.floor_double(d7+d11/2D);
			int i6=MathHelper.floor_double(d8+d10/2D);
			for(int i7=i1;i7<=i4;i7++)
			{
				double d12=(((double)i7+0.5D)-d6)/(d10/2D);
				if(d12*d12>=1.0D)continue;
				for(int i8=i2;i8<=i5;i8++)
				{
					double d13=(((double)i8+0.5D)-d7)/(d11/2D);
					if(d12*d12+d13*d13>=1.0D)continue;
					for(int i9=i3;i9<=i6;i9++)
					{
						double d14=(((double)i9+0.5D)-d8)/(d10/2D);
						if(d12*d12+d13*d13+d14*d14<1.0D&&world.getBlock(i7,i8,i9)==Blocks.stone)
						{
							world.setBlock(i7,i8,i9,ID,META,3);
						}
					}
				}
			}
		}
		return true;
	}
	public static void generateSurface(World world,Random random,int x,int z)
	{
		if(Ores.genores)
		{
			if(Ores.debug)System.out.println("adding world gen");
			for(int amount=0;amount<20;amount++)
			{
				generate(world,random,x+random.nextInt(16),random.nextInt(64),z+random.nextInt(16),Ores.ore,4,0);
			}
			for(int amount=0;amount<20;amount++)
			{
				generate(world,random,x+random.nextInt(16),random.nextInt(64),z+random.nextInt(16),Ores.ore,4,1);
			}
			for(int amount=0;amount<20;amount++)
			{
				generate(world,random,x+random.nextInt(16),random.nextInt(32),z+random.nextInt(16),Ores.ore,4,2);
			}
			for(int amount=0;amount<20;amount++)
			{
				generate(world,random,x+random.nextInt(16),random.nextInt(32),z+random.nextInt(16),Ores.ore,4,3);
			}
		}
	}
	public void generate(Random random,int x,int z,World world,IChunkProvider ichunkprovider1,IChunkProvider ichunkprovider2)
	{
		if(!(world.provider.dimensionId==-1)||!(world.provider.dimensionId==0))
		{
			generateSurface(world,random,x*16,z*16);
		}
	}
}