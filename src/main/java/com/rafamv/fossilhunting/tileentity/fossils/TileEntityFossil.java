package com.rafamv.fossilhunting.tileentity.fossils;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.rafamv.fossilhunting.enums.FossilInformation;

public class TileEntityFossil extends TileEntity {

	public int fossilID;
	public double yearOfExistence;
	public double length;
	public double weight;
	public double height;
	public boolean sign;
	public boolean tilted;
	protected ForgeDirection direction;

	public TileEntityFossil() {
		this.fossilID = -1;
		this.yearOfExistence = -1.0;
		this.sign = false;
		this.tilted = false;
	}

	/** Sets false to the sing, and tilted values of the fossil. Randomizes the year, weight, height, and 
	 * length of the fossil based on a minimum and maximum values between 0.0D and 1.0D. Also sets the
	 * direction of the block (North, south, east, west) */
	public void setFossilDataFirstTime(World world, int x, int y, int z, EntityPlayer player, int id, double min, double max) {
		if (min > max) {
			double temp = max;
			max = min;
			min = temp;
		}
		this.fossilID = id;
		this.yearOfExistence = getRandomBetween(FossilInformation.values()[id].getEndOfExistence(), FossilInformation.values()[id].getBeginOfExistence());
		this.weight = getRandomBetween(FossilInformation.values()[id].getWeight() * min, FossilInformation.values()[id].getWeight() * max);
		this.height = getRandomBetween(FossilInformation.values()[id].getHeight() * min, FossilInformation.values()[id].getHeight() * max);
		this.length = getRandomBetween(FossilInformation.values()[id].getLength() * min, FossilInformation.values()[id].getLength() * max);
		this.sign = false;
		this.tilted = false;
		switch (MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3) {
			case 0:
				this.setForgeDirection(ForgeDirection.SOUTH.ordinal());
				break;
			case 1:
				this.setForgeDirection(ForgeDirection.WEST.ordinal());
				break;
			case 2:
				this.setForgeDirection(ForgeDirection.NORTH.ordinal());
				break;
			case 3:
				this.setForgeDirection(ForgeDirection.EAST.ordinal());
				break;
			default:
				this.setForgeDirection(ForgeDirection.SOUTH.ordinal());
		}
	}

	/** Sets the fossil ID. */
	public void setFossilID(int id) {
		this.fossilID = id;
	}

	/** Sets the year of existence of the fossil. */
	public void setYearOfExistence(double year) {
		this.yearOfExistence = year;
	}

	/** Sets the weight of the dinosaur fossil. */
	public void setWeight(double dinoWeight) {
		this.weight = dinoWeight;
	}

	/** Sets the length of the dinosaur fossil. */
	public void setLength(double dinoLength) {
		this.length = dinoLength;
	}

	/** Sets the height of the dinosaur fossil. */
	public void setHeight(double dinoHeight) {
		this.height = dinoHeight;
	}

	/** Returns the id of the fossil. If it is not a valid id, it will return 0. */
	public int getFossilID() {
		if (fossilID >= 0) {
			return fossilID;
		} else {
			return 0;
		}
	}

	/**
	 * Returns the year of existence of the fossil as a string. If it is not a valid id, 
	 * it will return "Not defined". */
	public String getYearOfExistenceString() {
		if (yearOfExistence > 0) {
			return (yearOfExistence + " million years ago");
		} else {
			return "Not defined";
		}
	}

	/**
	 * Returns the era and period of the fossil. If it is null, it will return "Not defined".
	 */
	public String getGeologicEra(double year) {
		if (year >= 0) {
			return FossilInformation.getEraFromExistence(year);
		} else {
			return "Not defined";
		}
	}

	/** Returns the year of existence of the fossil. */
	public double getYearOfExistence() {
		return this.yearOfExistence;
	}

	/** Returns the weight of the dinosaur fossil. */
	public double getWeight() {
		return this.weight;
	}

	/** Returns the height of the dinosaur fossil. */
	public double getHeight() {
		return this.height;
	}

	/** Returns the length of the dinosaur fossil. */
	public double getLength() {
		return this.length;
	}

	/** Set golden sign, which is necessary to open a information panel. */
	public void setSign(boolean flag) {
		this.sign = flag;
	}

	/** Return if there is a golden sign. */
	public boolean hasSign() {
		return sign;
	}

	/** Set golden sign, which is necessary to open a information panel. */
	public void setTilted(boolean flag) {
		this.tilted = flag;
	}

	/** Return if there is a golden sign. */
	public boolean isTilted() {
		return tilted;
	}

	/** Sets what direction the fossil is facing based on the int value. */
	public void setForgeDirection(int direction) {
		this.direction = ForgeDirection.getOrientation(direction);
	}

	/** Returns the ForgeDirection that the fossil is facing. */
	public ForgeDirection getForgeDirection() {
		return direction;
	}

	/** Returns a random number (,##) between two doubles. */
	protected double getRandomBetween(double min, double max) {
		double random = new Random().nextDouble();
		double randomNumber = (min + (random * (max - min))) * 100;
		randomNumber = (int) randomNumber;
		randomNumber = randomNumber / 100;
		return randomNumber;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.fossilID = compound.getByte("fossilID");
		this.sign = compound.getBoolean("sign");
		this.tilted = compound.getBoolean("tilted");
		this.yearOfExistence = compound.getDouble("yearOfExistence");
		this.length = compound.getDouble("length");
		this.height = compound.getDouble("height");
		this.weight = compound.getDouble("weight");
		this.direction = ForgeDirection.getOrientation(compound.getByte("direction"));
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setByte("fossilID", (byte) fossilID);
		compound.setBoolean("sign", sign);
		compound.setBoolean("tilted", tilted);
		compound.setDouble("yearOfExistence", yearOfExistence);
		compound.setDouble("length", length);
		compound.setDouble("height", height);
		compound.setDouble("weight", weight);
		compound.setByte("direction", (byte) direction.ordinal());
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setBoolean("tilted", tilted);
		compound.setByte("direction", (byte) direction.ordinal());
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, compound);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		this.tilted = packet.func_148857_g().getBoolean("tilted");
		this.direction = ForgeDirection.getOrientation(packet.func_148857_g().getByte("direction"));
	}
}
