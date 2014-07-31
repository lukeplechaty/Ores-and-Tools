package com.lukeplechaty.ores;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
public class EntityOres extends EntityItem
{
	public EntityOres(World world)
	{
		super(world);
	}
	public EntityOres(World world,Entity entity)
	{
		super(world,entity.posX,entity.posY,entity.posZ);
	}
	public EntityOres(World world,EntityItem entity,ItemStack itemstack)
	{
		super(world,entity.posX,entity.posY,entity.posZ,itemstack);
		this.motionX=entity.motionX;
		this.motionY=entity.motionY;
		this.motionZ=entity.motionZ;
		this.age=entity.age;
		this.delayBeforeCanPickup=entity.delayBeforeCanPickup;
		this.hoverStart=entity.hoverStart;
		this.lifespan=entity.lifespan;
	}
	
	public void onUpdate()
	{
		super.onUpdate();
	}
}