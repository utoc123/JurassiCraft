package com.ilexiconn.jurassicraft.data.tile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEgg extends TileEntity
{
	public Class<? extends EntityLiving> entity;
    public int hatchTime = 10000;

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

    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        hatchTime = nbt.getInteger("time");
    }

    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setInteger("time", hatchTime);
    }

    public void hatchEgg()
    {
        worldObj.setBlockToAir(xCoord, yCoord, zCoord);
        worldObj.removeTileEntity(xCoord, yCoord, zCoord);
        try
        {
            if (!worldObj.isRemote)
            {
                EntityLiving entity = this.entity.getDeclaredConstructor(World.class).newInstance(worldObj);
                entity.setPosition(xCoord, yCoord, zCoord);
                worldObj.spawnEntityInWorld(entity);
            }
        }
        catch (Exception ignored)
        {

        }
    }
    
    public void updateEntity()
    {
    	if (hatchTime == 0)
        {
    		hatchEgg();
    	}
    	else
        {
    		hatchTime = hatchTime - (getFurnacesNearby() * 5 + 1);
    	}
    }

    public Packet getDescriptionPacket()
    {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
    {
        readFromNBT(packet.func_148857_g());
    }
}
