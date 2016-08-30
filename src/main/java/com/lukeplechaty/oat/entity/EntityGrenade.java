package com.lukeplechaty.oat.entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
public class EntityGrenade extends EntityThrowable
{
    public EntityGrenade(World worldIn)
    {
        super(worldIn);
        this.amount=0;
        this.tick=20;
        this.progress=5;
    }
    public EntityGrenade(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
        this.amount=0;
        this.tick=20;
        this.progress=5;
    }
    public EntityGrenade(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
        this.amount=0;
        this.tick=20;
        this.progress=5;
    }
    public static void func_189663_a(DataFixer p_189663_0_)
    {
        EntityThrowable.func_189661_a(p_189663_0_, "entity_grenade");
    }
    public void onUpdate()
    {
        this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY+0.2, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        this.tick--;
		if(this.tick<=0)
		{
			this.progress--;
			if(this.progress<=0)
			{
				if (!this.worldObj.isRemote)
				{
					for(int i=0;i<this.amount;i++)
					{
						EntityRock entity = new EntityRock(this.worldObj, this.posX, this.posY, this.posZ);
						this.motionX=0;
						this.motionY=0;
						this.motionZ=0;
						entity.setHeadingFromThrower(this, MathHelper.randomFloatClamp(this.worldObj.rand,-80F,-10F), MathHelper.randomFloatClamp(this.worldObj.rand,-179.9F, 180F), 0.0F, 0.5F, 1.0F);
						this.worldObj.spawnEntityInWorld(entity);
					}
					this.worldObj.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 4.0F, (1.0F + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F) * 0.7F);
					this.setDead();
				}
			}
			this.tick=20;
		}
        super.onUpdate();
    }
    public void writeEntityToNBT(NBTTagCompound compound)
    {
    	compound.setInteger("progress",this.progress);
    }
    public void readEntityFromNBT(NBTTagCompound compound)
    {
    	this.progress=compound.getInteger("progress:");
    }
	protected void onImpact(RayTraceResult result)
	{
    	this.motionX=0;
    	this.motionY=0;
    	this.motionZ=0;
    }
    public int amount;
    protected int tick;
    protected int progress;
}