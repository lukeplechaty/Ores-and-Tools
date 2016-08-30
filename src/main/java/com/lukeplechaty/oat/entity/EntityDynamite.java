package com.lukeplechaty.oat.entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
public class EntityDynamite extends EntityThrowable
{
    public EntityDynamite(World worldIn)
    {
        super(worldIn);
        this.tick=20;
        this.progress=5;
    }
    public EntityDynamite(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
        this.tick=20;
        this.progress=5;
    }
    public EntityDynamite(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
        this.tick=20;
        this.progress=5;
    }
    public static void func_189663_a(DataFixer p_189663_0_)
    {
        EntityThrowable.func_189661_a(p_189663_0_, "entity_dynamite");
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
					this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 2, false, true);
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
    protected int tick;
    protected int progress;
}
