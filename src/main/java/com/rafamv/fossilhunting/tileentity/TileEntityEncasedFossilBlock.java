package com.rafamv.fossilhunting.tileentity;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.rafamv.fossilhunting.enums.FossilInformation;

public class TileEntityEncasedFossilBlock extends TileEntity { 

	public int fossilID;
	
	public TileEntityEncasedFossilBlock() {
		Random randomID = new Random();
		fossilID = randomID.nextInt(FossilInformation.values().length);
	}
	
	public int getFossilID() {
		return fossilID;
	}

	public void setFossilID(int fossilID) {
		this.fossilID = fossilID;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setByte("FossilID", (byte) fossilID);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.fossilID = compound.getByte("FossilID");
	}
	
}
