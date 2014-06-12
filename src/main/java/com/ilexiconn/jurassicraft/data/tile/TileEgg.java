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
}
