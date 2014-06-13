package com.ilexiconn.jurassicraft.data.tile;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.logger.LogType;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEgg extends TileEntity
{
    public final Class<? extends EntityLiving> entity;

    public int hatchTime;

    public TileEgg(Class<? extends EntityLiving> entity)
    {
        this.entity = entity;
        hatchTime = 2000; //2000 ticks == 100 sec
    }

    public String getDino()
    {
        TileEgg egg = (TileEgg) worldObj.getTileEntity(xCoord, yCoord, zCoord);
        return egg.entity.getSimpleName();
    }

    public void updateEntity()
    {
        hatchTime = (hatchTime - (getFurnacesNearby() + 1));
        if (!worldObj.isRemote) Util.getLogger().print(LogType.INFO, hatchTime + "");
        if (hatchTime <= 0)
        {
            worldObj.setBlockToAir(xCoord, yCoord, zCoord);
            try
            {
                EntityLiving entity = this.entity.getDeclaredConstructor(World.class).newInstance(worldObj);
                entity.setPosition(xCoord, yCoord, zCoord);
                worldObj.spawnEntityInWorld(entity);
            }
            catch (Exception e)
            {
                Util.getLogger().print(LogType.ERROR, "Can't spawn the " + entity.getSimpleName() + ", " + e);
            }
        }
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
