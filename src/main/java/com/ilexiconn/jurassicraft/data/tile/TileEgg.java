package com.ilexiconn.jurassicraft.data.tile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.tileentity.TileEntity;

public class TileEgg extends TileEntity
{
    public Class<? extends EntityLiving> entity;

    public TileEgg(Class<? extends EntityLiving> entity)
    {
        this.entity = entity;
    }

    public String getDino()
    {
        TileEgg egg = (TileEgg) worldObj.getTileEntity(xCoord, yCoord, zCoord);
        return egg.entity.getSimpleName();
    }

    public void updateEntity()
    {
        
    }
}
