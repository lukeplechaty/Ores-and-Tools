package com.lukeplechaty.oat.entity;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
public class EntityCrush extends EntityItem
{
	private Item returns;
	private int more;
	private int odds;
	public EntityCrush(World world)
	{
		super(world);
	}
	public EntityCrush(World world,Entity entity)
	{
		super(world,entity.posX,entity.posY,entity.posZ);
	}
	public EntityCrush(World world,EntityItem entity,ItemStack itemstack,Item returns,int odds)
	{
		super(world,entity.posX,entity.posY,entity.posZ,itemstack);
		setPickupDelay(20);
		this.motionX=entity.motionX;
		this.motionY=entity.motionY;
		this.motionZ=entity.motionZ;
		this.hoverStart=entity.hoverStart;
		this.lifespan=entity.lifespan;
		this.returns=returns;
		this.odds=odds;
	}
	@Override
	public void onUpdate()
	{
		Block block1=this.worldObj.getBlockState(this.getPosition()).getBlock();
		Block block2=this.worldObj.getBlockState(this.getPosition().down()).getBlock();
		if(block1==Blocks.DIAMOND_BLOCK&&block2==Blocks.DIAMOND_BLOCK)
		{
			int size=this.getEntityItem().stackSize;
			this.setDead();
			for(int next=0;next<size;next++)
			{
				if(this.odds==1) more=1;
				else if(this.rand.nextInt(this.odds)==1) more=1;
				else more=0;
				if(more==1&&this.rand.nextInt((this.odds+1)*2)==1) more=2;
				EntityItem lump=new EntityItem(this.worldObj,this.posX,this.posY,this.posZ,new ItemStack(this.returns,1+more));
				lump.motionX=this.motionX;
				lump.motionY=this.motionY;
				lump.motionZ=this.motionZ;
				this.worldObj.spawnEntityInWorld(lump);
			}
		}
		super.onUpdate();
	}
}