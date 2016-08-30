package com.lukeplechaty.oat.entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
public class EntityRock extends EntityThrowable
{
    public EntityRock(World worldIn)
    {
        super(worldIn);
    }
    public EntityRock(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }
    public EntityRock(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    public static void func_189663_a(DataFixer p_189663_0_)
    {
        EntityThrowable.func_189661_a(p_189663_0_, "entity_rock");
    }
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 3F);
        }
        if (!this.worldObj.isRemote)
        {
        	this.setDead();
        }
    }
}