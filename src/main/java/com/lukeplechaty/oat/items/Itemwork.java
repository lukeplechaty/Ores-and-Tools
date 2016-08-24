package com.lukeplechaty.oat.items;
import com.lukeplechaty.oat.Ores;
import com.lukeplechaty.oat.entity.EntityClean;
import com.lukeplechaty.oat.entity.EntityCrush;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
public class Itemwork extends Item
{
	private int work;
	private Item item;
	public Itemwork(String name,int work,Item item)
	{
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Ores.tabOres);
		this.work=work;
		this.item=item;
	}
	@Override
	public Entity createEntity(World world,Entity entity,ItemStack itemstack)
	{
		if(work==0)
		{
			return new EntityCrush(world,(EntityItem)entity,itemstack,item,1);
		}
		if(work==1)
		{
			return new EntityClean(world,(EntityItem)entity,itemstack,item);
		}
		if(work==2)
		{
			return new EntityCrush(world,(EntityItem)entity,itemstack,item,3);
		}
		return null;
	}
	@Override
	public boolean hasCustomEntity(ItemStack itemstack)
	{
		return true;
	}
}
