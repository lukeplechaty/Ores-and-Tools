package com.lukeplechaty.ores.blocks;
import java.util.Random;
import com.lukeplechaty.ores.Ores;
import com.lukeplechaty.ores.render.Render;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
public class Blockore extends Block
{
    private IIcon[] textures=new IIcon[3];
	public Blockore()
	{
		super(Material.rock);
		if(Ores.debug)System.out.println("adding block ores");
		setBlockName("blockore");
		setCreativeTab(Ores.tabOres);
		setStepSound(Block.soundTypeStone);
	}
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	public boolean isOpaqueCube()
	{
		return true;
	}
	public int getRenderType()
	{
		return Render.BlockOverlayRenderID;
	}
	public IIcon getIcon(int side,int meta)
	{
		return textures[meta];
	}
	public int getExpDrop(World world, int data, int enchantmentLevel)
    {
        return MathHelper.getRandomIntegerInRange(world.rand, 2, 5);
    }
	public float getBlockHardness(World world,int x,int y,int z) 
    {
		int meta=world.getBlockMetadata(x,y,z);
		switch(meta)
		{
			default:return 6.0f;
			case 1:return 3.0f;
			case 2:return 5.0f;
		}
    }
	public int quantityDropped(int meta,int fortune,Random random)
	{
		switch(meta)
		{
			default:return 1+random.nextInt(3);
			case 1:return 2+random.nextInt(5);
			case 2:return 1+random.nextInt(3);
		}
	}
	public Item getItemDropped(int meta,Random random,int amount)
	{
		switch(meta)
		{
			default:return Items.bone;
			case 1:return Ores.items;
			case 2:return Ores.items;
		}
	}
	public int damageDropped(int meta)
	{
		switch(meta)
		{
			default:return 0;
			case 1:return 1;
			case 2:return 2;
		}
	}
	public void registerBlockIcons(IIconRegister register)
	{
		this.textures[0] = register.registerIcon("ores:fossils_ore");
		this.textures[1] = register.registerIcon("ores:saltpeter_ore");
		this.textures[2] = register.registerIcon("ores:sulfur_ore");
	}
}