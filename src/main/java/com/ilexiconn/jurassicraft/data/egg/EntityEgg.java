package com.ilexiconn.jurassicraft.data.egg;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class EntityEgg extends EntityLiving
{
    public EntityEgg(World par1World)
    {
        super(par1World);
        setSize(0.4f, 0.5f);
    }
}
