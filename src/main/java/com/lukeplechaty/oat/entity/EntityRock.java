package com.lukeplechaty.oat.entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityRock extends EntityThrowable
{
	float damage;
	
	public EntityRock(World world)
	{
		super(world);
		this.damage = 3F;
	}
	
	public EntityRock(World world, EntityLivingBase thrower)
	{
		super(world, thrower);
		this.damage = 3F;
	}
	
	public EntityRock(World world, double x, double y, double z)
	{
		super(world, x, y, z);
		this.damage = 3F;
	}
	
	public EntityRock(World world, double x, double y, double z, float damage)
	{
		super(world, x, y, z);
		this.damage = damage;
	}
	
	public static String GetRegistryName()
	{
		return "oat:entity_rock";
	}
	
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id)
	{
		if(id == 3)
		{
			for(int i = 0; i < 8; ++i)
			{
				this.world.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
			}
		}
	}
	
	protected void onImpact(RayTraceResult result)
	{
		if(result.entityHit != null)
		{
			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.damage);
		}
		if(!this.world.isRemote)
		{
			this.world.setEntityState(this, (byte)3);
			this.setDead();
		}
	}
}
