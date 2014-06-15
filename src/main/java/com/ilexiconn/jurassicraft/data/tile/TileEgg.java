package com.ilexiconn.jurassicraft.data.tile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

public class TileEgg extends TileEntity
{
	public final Class<? extends EntityLiving> entity;

    public int hatchTime;

    public TileEgg(Class<? extends EntityLiving> entity)
    {
        this.entity = entity;
    }

    public String getDino()
    {
        TileEgg egg = (TileEgg) worldObj.getTileEntity(xCoord, yCoord, zCoord);
        return egg.entity.getSimpleName();
    }

    public int getFurnacesNearby()
    {
        int amount = 0;
        for (int i = -1; i < 2; i++)
        {
            for (int j = -1; j < 2; j++)
            {
                if (worldObj.getBlock(xCoord + i, yCoord, zCoord + j) == Blocks.lit_furnace) amount++;
            }
        }
        return amount;
    }
}
