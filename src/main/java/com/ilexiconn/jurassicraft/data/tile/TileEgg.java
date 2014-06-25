package com.ilexiconn.jurassicraft.data.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEgg extends TileEntity
{
    private String dinoName;
    private int hatchTime;

    public TileEgg(String dinoName)
    {
        setDinoName(dinoName);
        setHatchTime(100);
    }

    public void setDinoName(String dinoName)
    {
        this.dinoName = dinoName;
    }

    public String getDinoName()
    {
        return dinoName;
    }

    public void setHatchTime(int hatchTime)
    {
        this.hatchTime = hatchTime;
    }

    public int getHatchTime()
    {
        return hatchTime;
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

    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setString("dinoName", dinoName);
        tag.setInteger("hatchTime", hatchTime);
    }

    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        dinoName = tag.getString("dinoName");
        hatchTime = tag.getInteger("hatchTime");
    }

    public void updateEntity()
    {
        hatchTime++;
        System.out.println(hatchTime);
    }
}