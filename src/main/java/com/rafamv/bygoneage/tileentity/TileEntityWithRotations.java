package com.rafamv.bygoneage.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityWithRotations extends TileEntity {

	protected ForgeDirection forgeDirection;
	
	public TileEntityWithRotations() {
		
	}

	/** Sets what direction the fossil is facing based on the int value. */
	public void setForgeDirection(int direction) {
		this.forgeDirection = ForgeDirection.getOrientation(direction);
	}

	/** Returns the ForgeDirection that the fossil is facing. */
	public ForgeDirection getForgeDirection() {
		return forgeDirection;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setByte("Direction", (byte) forgeDirection.ordinal());
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.forgeDirection = ForgeDirection.getOrientation(compound.getByte("Direction"));
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setByte("Direction", (byte) forgeDirection.ordinal());
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, compound);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		this.forgeDirection = ForgeDirection.getOrientation(packet.func_148857_g().getByte("Direction"));
	}
}
