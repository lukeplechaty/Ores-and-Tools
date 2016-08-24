package com.lukeplechaty.oat.blocks;
import java.util.Random;
import com.lukeplechaty.oat.Ores;
import com.lukeplechaty.oat.setBlocks;
import com.lukeplechaty.oat.setItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
public class Blockore extends Block
{
	public Blockore(String name)
	{
		super(Material.ROCK);
		setCreativeTab(Ores.tabOres);
		setSoundType(SoundType.STONE);
		setRegistryName(name);
		setUnlocalizedName(name);
	}
	@Override
	public int getExpDrop(IBlockState state,net.minecraft.world.IBlockAccess world,BlockPos pos,int fortune)
	{
		Random rand=world instanceof World? ((World)world).rand:new Random();
		return MathHelper.getRandomIntegerInRange(rand,2,5);
	}
	@Override
	public Item getItemDropped(IBlockState state,Random rand,int fortune)
	{
		if(this==setBlocks.orefossils) return Items.BONE;
		if(this==setBlocks.oresodium) return setItems.sodium;
		if(this==setBlocks.oresulfur) return setItems.sulfur;
		return null;
	}
	@Override
	public int quantityDropped(Random random)
	{
		if(this==setBlocks.orefossils) return 1+random.nextInt(3);
		if(this==setBlocks.oresodium) return 2+random.nextInt(5);
		if(this==setBlocks.oresulfur) return 1+random.nextInt(3);
		return 0;
	}
}