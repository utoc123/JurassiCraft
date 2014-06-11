package com.ilexiconn.jurassicraft.data.egg;

import net.minecraft.entity.EntityLiving;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityEgg extends EntityLiving
{
    public EntityEgg(World par1World)
    {
        super(par1World);
    }

    public boolean canBePushed()
    {
        return true;
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
    {
        return false;
    }
}