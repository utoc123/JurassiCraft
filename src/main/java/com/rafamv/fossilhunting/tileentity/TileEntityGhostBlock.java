package com.rafamv.fossilhunting.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGhostBlock extends TileEntity {

	public int position[];

	public TileEntityGhostBlock() {
		this.position = new int[3];
	}

	/** Sets the main position of the original block. */
	public void setMainPosition(int x, int y, int z) {
		this.position[0] = x;
		this.position[1] = y;
		this.position[2] = z;
	}
	
	/** Returns the x position of the original block. */
	public int getMainPositionX() {
		return position[0];
	}
	
	/** Returns the y position of the original block. */
	public int getMainPositionY() {
		return position[1];
	}
	
	/** Returns the z position of the original block. */
	public int getMainPositionZ() {
		return position[2];
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.position = compound.getIntArray("position");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setIntArray("position", position);
	}
}
