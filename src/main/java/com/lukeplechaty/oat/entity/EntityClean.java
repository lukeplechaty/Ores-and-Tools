package com.lukeplechaty.oat.entity;
import com.lukeplechaty.oat.setItems;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
public class EntityClean extends EntityItem
{
	private Item returns;
	public EntityClean(World world)
	{
		super(world);
	}
	public EntityClean(World world,Entity entity)
	{
		super(world,entity.posX,entity.posY,entity.posZ);
	}
	public EntityClean(World world,EntityItem entity,ItemStack itemstack,Item returns)
	{
		super(world,entity.posX,entity.posY,entity.posZ,itemstack);
		setDefaultPickupDelay();
		this.motionX=entity.motionX;
		this.motionY=entity.motionY;
		this.motionZ=entity.motionZ;
		this.hoverStart=entity.hoverStart;
		this.lifespan=entity.lifespan;
		this.returns=returns;
	}
	@Override
	public void onUpdate()
	{
		Block block1=this.worldObj.getBlockState(this.getPosition()).getBlock();
		Block block2=this.worldObj.getBlockState(this.getPosition().down()).getBlock();
		if(block1==Blocks.WATER&&block2==Blocks.TRAPDOOR)
		{
			int size=this.getEntityItem().stackSize;
			int meta=this.getEntityItem().getItemDamage();
			this.setDead();
			if(posY<prevPosY) posY-=1;
			else
			{
				if(posX<prevPosX) posX-=.2;
				if(posX>prevPosX) posX+=.2;
				if(posZ<prevPosZ) posZ-=.2;
				if(posZ>prevPosZ) posZ+=.2;
			}
			EntityItem lump=new EntityItem(this.worldObj,this.posX,this.posY-0.6,this.posZ,new ItemStack(this.returns,size,meta));
			lump.motionX=this.motionX;
			lump.motionY=this.motionY;
			lump.motionZ=this.motionZ;
			this.worldObj.spawnEntityInWorld(lump);
			for(int next=0;next<size;next++)
				if(this.worldObj.rand.nextInt(3)==1)
				{
					EntityItem stone=new EntityItem(this.worldObj,this.posX,this.posY,this.posZ,new ItemStack(setItems.rock,1,4));
					stone.motionX=this.motionX;
					stone.motionY=this.motionY;
					stone.motionZ=this.motionZ;
					this.worldObj.spawnEntityInWorld(stone);
				}
		}
		super.onUpdate();
	}
}