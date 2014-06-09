package com.ilexiconn.jurassicraft.data.egg;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityHerrerasaurEgg extends EntityLiving
{
    public EntityHerrerasaurEgg(World par1World)
    {
        super(par1World);
        setSize(0.4f, 0.5f);
        preventEntitySpawning = true;
    }

    public void entityInit()
    {
        dataWatcher.addObject(17, 0);
        dataWatcher.addObject(18, 1);
        dataWatcher.addObject(19, 0.0F);
    }

    public boolean canTriggerWalking()
    {
        return false;
    }

    public AxisAlignedBB getCollisionBox(Entity par1Entity)
    {
        return par1Entity.boundingBox;
    }

    public AxisAlignedBB getBoundingBox()
    {
        return boundingBox;
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
    {
        if (isEntityInvulnerable())
        {
            return false;
        }
        else if (!worldObj.isRemote && !isDead)
        {
            setForwardDirection(-getForwardDirection());
            setTimeSinceHit(10);
            setDamageTaken(getDamageTaken() + par2 * 10.0F);
            setBeenAttacked();
            boolean flag = par1DamageSource.getEntity() instanceof EntityPlayer && ((EntityPlayer)par1DamageSource.getEntity()).capabilities.isCreativeMode;

            if (flag || getDamageTaken() > 40.0F)
            {
                if (riddenByEntity != null)
                {
                    riddenByEntity.mountEntity(this);
                }

                if (!flag)
                {
                    func_145778_a(Items.boat, 1, 0.0F);
                }

                setDead();
            }

            return true;
        }
        else
        {
            return true;
        }
    }

    public void setDamageTaken(float par1)
    {
        dataWatcher.updateObject(19, par1);
    }

    public float getDamageTaken()
    {
        return dataWatcher.getWatchableObjectFloat(19);
    }

    public void setTimeSinceHit(int par1)
    {
        dataWatcher.updateObject(17, par1);
    }

    public void setForwardDirection(int par1)
    {
        dataWatcher.updateObject(18, par1);
    }

    public int getForwardDirection()
    {
        return dataWatcher.getWatchableObjectInt(18);
    }

    public boolean canBePushed()
    {
        return true;
    }

    public void onUpdate()
    {

    }

    public void readEntityFromNBT(NBTTagCompound var1)
    {

    }

    public void writeEntityToNBT(NBTTagCompound var1)
    {

    }
}
