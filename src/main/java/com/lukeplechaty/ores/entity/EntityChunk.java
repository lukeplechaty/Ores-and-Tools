package com.lukeplechaty.ores.entity;
import com.lukeplechaty.ores.Ores;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
public class EntityChunk extends EntityItem
{
	public EntityChunk(World world)
	{
		super(world);
	}
	public EntityChunk(World world,Entity entity)
	{
		super(world,entity.posX,entity.posY,entity.posZ);
	}
	public EntityChunk(World world,EntityItem entity,ItemStack itemstack)
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
		int x=MathHelper.floor_double(this.posX);
		int y=MathHelper.floor_double(this.posY);
		int z=MathHelper.floor_double(this.posZ);
		Block block1=this.worldObj.getBlock(x,y,z);
		Block block2=this.worldObj.getBlock(x,y-1,z);
		if(this.getCollisionBox(this)==null&&block1==Blocks.diamond_block&&block2==Blocks.diamond_block)
		{
			int size=this.getEntityItem().stackSize;
			int meta=this.getEntityItem().getItemDamage();
			this.setDead();
			EntityItem dust=new EntityItem(this.worldObj,this.posX,this.posY,this.posZ,new ItemStack(Ores.dusts,size*2,meta+3));
			this.worldObj.spawnEntityInWorld(dust);
		}
		super.onUpdate();
	}
}