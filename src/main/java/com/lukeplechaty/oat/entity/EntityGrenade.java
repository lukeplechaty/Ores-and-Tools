package com.lukeplechaty.oat.entity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityGrenade extends Entity implements IProjectile
{
	public EntityGrenade(World worldIn)
	{
		this(worldIn, 0.0D, 0.0D, 0.0D);
		this.amount = 0;
		this.progress = 100;
	}
	
	public EntityGrenade(World worldIn, EntityLivingBase throwerIn)
	{
		super(worldIn);
		setSize(0.5F, 0.5F);
		this.setLocationAndAngles(throwerIn.posX, throwerIn.posY, throwerIn.posZ, throwerIn.rotationYaw, throwerIn.rotationPitch);
		posX -= Math.cos(Math.toRadians(throwerIn.rotationYaw)) * 0.16D;
		posY += (double)throwerIn.getEyeHeight() - 0.1D;
		posZ -= Math.sin(Math.toRadians(throwerIn.rotationYaw)) * 0.16D;
		setPosition(posX, posY, posZ);
		motionX = (-Math.sin(Math.toRadians(throwerIn.rotationYaw)) * Math.cos(Math.toRadians(throwerIn.rotationPitch)));
		motionZ = (Math.cos(Math.toRadians(throwerIn.rotationYaw)) * Math.cos(Math.toRadians(throwerIn.rotationPitch)));
		motionY = (-Math.sin(Math.toRadians(rotationPitch)));
		shoot(motionX, motionY, motionZ, 1.2F, 1.0F);
		this.amount = 0;
		this.progress = 100;
	}
	
	public EntityGrenade(World worldIn, double x, double y, double z)
	{
		super(worldIn);
		setSize(0.5F, 0.5F);
		setPosition(x, y, z);
		this.amount = 0;
		this.progress = 100;
	}
	
	public static String GetRegistryName()
	{
		return "oat:entity_grenade";
	}
	
	public void onUpdate()
	{
		this.lastTickPosX = this.posX;
		this.lastTickPosY = this.posY;
		this.lastTickPosZ = this.posZ;
		super.onUpdate();
		if((prevRotationPitch == 0.0F) && (prevRotationYaw == 0.0F))
		{
			double hLen = Math.sqrt(motionX * motionX + motionZ * motionZ);
			prevRotationYaw = (this.rotationYaw = (float)Math.toDegrees(Math.atan2(motionX, motionZ)));
			prevRotationPitch = (this.rotationPitch = (float)Math.toDegrees(Math.atan2(motionY, hLen)));
		}
		World world = getEntityWorld();
		if(progress-- <= 0)
		{
			setDead();
			if(!this.inWater)
			{
				for(int i = 0; i < this.amount; i++)
				{
					EntityRock entity = new EntityRock(this.world, this.posX, this.posY, this.posZ, 6F);
					float yaw = (rand.nextInt(360) - 180);
					float pitch = (rand.nextInt(70) - 80);
					entity.shoot(this, pitch, yaw, 0.0F, 0.5F, 1.0F);
					this.world.spawnEntity(entity);
				}
				this.world.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 4.0F, (1.0F + (this.world.rand.nextFloat() - this.world.rand.nextFloat()) * 0.2F) * 0.7F);
			}
		}
		else if((progress < 100) && (progress % 2 == 0))
		{
			world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, posX, posY + 0.5D, posZ, 0.0D, 0.0D, 0.0D, new int[0]);
		}
		if(inGround)
		{
			ticksInGround += 1;
			if(ticksInGround >= 200)
			{
				setDead();
			}
		}
		Vec3d start = new Vec3d(posX, posY, posZ);
		Vec3d end = new Vec3d(posX + motionX, posY + motionY, posZ + motionZ);
		RayTraceResult result = world.rayTraceBlocks(start, end, false, true, false);
		if(result != null)
		{
			float remainX = (float)(lastTickPosX - posX);
			float remainY = (float)(lastTickPosY - posY);
			float remainZ = (float)(lastTickPosZ - posZ);
			double remDist = Math.sqrt(remainX * remainX + remainY * remainY + remainZ * remainZ);
			stickPos = result.getBlockPos();
			posX -= remainX / remDist * 0.05D;
			posY -= remainY / remDist * 0.05D;
			posZ -= remainZ / remDist * 0.05D;
			posX += remainX;
			posY += remainY;
			posZ += remainZ;
			motionX *= 0.3F;
			motionY *= -0.30000001192092896D;
			motionZ *= 0.3F;
			inGround = true;
		}
		else
		{
			posX += motionX;
			posY += motionY;
			posZ += motionZ;
			inGround = false;
		}
		double hMotion = Math.sqrt(motionX * motionX + motionZ * motionZ);
		rotationYaw = ((float)Math.toDegrees(Math.atan2(motionX, motionZ)));
		rotationPitch = ((float)Math.toDegrees(Math.atan2(motionY, hMotion)));
		while(rotationPitch - prevRotationPitch < -180.0F)
			prevRotationPitch -= 360.0F;
		while(rotationPitch - prevRotationPitch >= 180.0F)
			prevRotationPitch += 360.0F;
		while(rotationYaw - prevRotationYaw < -180.0F)
			prevRotationYaw -= 360.0F;
		while(rotationYaw - prevRotationYaw >= 180.0F)
			prevRotationYaw += 360.0F;
		rotationPitch = (prevRotationPitch + (rotationPitch - prevRotationPitch) * 0.2F);
		rotationYaw = (prevRotationYaw + (rotationYaw - prevRotationYaw) * 0.2F);
		float f3 = 0.98F;
		float f5 = 0.04F;
		if(isInWater())
		{
			for(int i1 = 0; i1 < 4; i1++)
			{
				float f6 = 0.25F;
				world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, posX - motionX * f6, posY - motionY * f6, posZ - motionZ * f6, motionX, motionY, motionZ, new int[0]);
			}
			f3 = 0.75F;
		}
		motionX *= f3;
		motionY *= f3;
		motionZ *= f3;
		motionY -= f5;
		setPosition(posX, posY, posZ);
	}
	
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	
	public void writeEntityToNBT(NBTTagCompound compound)
	{
		compound.setInteger("progress", this.progress);
		compound.setInteger("amount", this.amount);
	}
	
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		this.progress = compound.getInteger("progress:");
		this.amount = compound.getInteger("amount:");
	}
	
	protected int amount;
	protected int progress;
	private int ticksInGround;
	private boolean inGround;
	public BlockPos stickPos;
	
	@Override
	protected void entityInit()
	{}
	
	public void setVelocity(double x, double y, double z)
	{
		motionX = x;
		motionY = y;
		motionZ = z;
		if(prevRotationPitch == 0.0F && prevRotationYaw == 0.0F)
		{
			double f = MathHelper.sqrt(x * x + z * z);
			this.rotationYaw = (float)(MathHelper.atan2(x, z) * (180D / Math.PI));
			this.rotationPitch = (float)(MathHelper.atan2(y, f) * (180D / Math.PI));
			this.prevRotationYaw = this.rotationYaw;
			this.prevRotationPitch = this.rotationPitch;
		}
	}
	
	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy)
	{
		float f = MathHelper.sqrt(x * x + y * y + z * z);
		x = x / (double)f;
		y = y / (double)f;
		z = z / (double)f;
		x = x + this.rand.nextGaussian() * 0.007499999832361937D * (double)inaccuracy;
		y = y + this.rand.nextGaussian() * 0.007499999832361937D * (double)inaccuracy;
		z = z + this.rand.nextGaussian() * 0.007499999832361937D * (double)inaccuracy;
		x = x * (double)velocity;
		y = y * (double)velocity;
		z = z * (double)velocity;
		this.motionX = x;
		this.motionY = y;
		this.motionZ = z;
		float f1 = MathHelper.sqrt(x * x + z * z);
		this.rotationYaw = (float)(MathHelper.atan2(x, z) * (180D / Math.PI));
		this.rotationPitch = (float)(MathHelper.atan2(y, (double)f1) * (180D / Math.PI));
		this.prevRotationYaw = this.rotationYaw;
		this.prevRotationPitch = this.rotationPitch;
		this.ticksInGround = 0;
	}
}
