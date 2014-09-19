package com.rafamv.bygoneage.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import com.rafamv.bygoneage.handler.BygoneAgeDNAHandler;
import com.rafamv.bygoneage.items.dnaitems.AnyDNASample;

public class TileEntityCentrifuge extends TileEntityWithRotations implements ISidedInventory, IInventory {

	private ItemStack[] slots = new ItemStack[4];
	private short[] centrifugeTime = new short[4];
	private final short centrifugeSpeed = 100;

	public TileEntityCentrifuge() {
		for (int i = 0; i < centrifugeTime.length; i++) {
			this.centrifugeTime[i] = 0;
		}
	}

	public int getCentrifugeTime(int i) {
		return centrifugeTime[i];
	}

	public int getCentrifugeTimeProgressScaled(int i) {
		return (centrifugeTime[i] * i) / centrifugeSpeed;
	}

	public boolean isCentrifuging(int i) {
		return (centrifugeTime[i] > 0);
	}

	private boolean canCentrifuge(int i) {
		if (slots[i] == (ItemStack) null) {
			return false;
		} else {
			if (slots[i].getItem() instanceof AnyDNASample) {
				if (slots[i].hasTagCompound()) {
					if (!slots[i].getTagCompound().hasKey("Centrifugated")) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}

	private void centrifugeItem(int i) {
		if (!canCentrifuge(i)) {
			return;
		} else {
			NBTTagCompound compound = new NBTTagCompound();
			if (slots[i].hasTagCompound()) {
				if (slots[i].getTagCompound().hasKey("CreatureName")) {
					compound.setString("CreatureName", slots[i].getTagCompound().getString("CreatureName"));
				} else {
					compound.setString("CreatureName", BygoneAgeDNAHandler.getRandomAnimalNameForDNA());
				}
				if (slots[i].getTagCompound().hasKey("RNAHelix1")) {
					compound.setString("RNAHelix1", slots[i].getTagCompound().getString("RNAHelix1"));
				} else {
					compound.setString("RNAHelix1", BygoneAgeDNAHandler.generateNewRNA(18));
				}
				if (slots[i].getTagCompound().hasKey("RNAHelix2")) {
					compound.setString("RNAHelix2", slots[i].getTagCompound().getString("RNAHelix2"));
				} else {
					compound.setString("RNAHelix2", BygoneAgeDNAHandler.createNewRNAFrom(compound.getString("RNAHelix1")));
				}
			}
			compound.setBoolean("Centrifugated", true);
			slots[i].setTagCompound(compound);
		}
	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
			for (int i = 0; i < slots.length; i++) {
				if (canCentrifuge(i)) {
					centrifugeTime[i]++;
					if (centrifugeTime[i] >= centrifugeSpeed && isCentrifuging(i)) {
						centrifugeTime[i] = 0;
						centrifugeItem(i);
					}
				} else {
					centrifugeTime[i] = 0;
				}
			}
		}
	}

	public boolean hasItems() {
		if (slots[0] != null || slots[1] != null || slots[2] != null || slots[3] != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getSizeInventory() {
		return slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return slots[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int stackSize) {
		if (this.slots[i] != null) {
			ItemStack splitedStack;
			if (this.slots[i].stackSize <= stackSize) {
				splitedStack = this.slots[i];
				this.slots[i] = null;
				return splitedStack;
			} else {
				splitedStack = this.slots[i].splitStack(stackSize);
				if (this.slots[i].stackSize == 0) {
					this.slots[i] = null;
				}
				return splitedStack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.slots[i] != null) {
			ItemStack itemStack = this.slots[i];
			this.slots[i] = null;
			return itemStack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemStack) {
		this.slots[i] = itemStack;
		if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
			itemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return "Centrifuge";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemStack) {
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int i) {
		return new int[] { 0 };
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemStack, int j) {
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemStack, int j) {
		return false;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList list = nbt.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];
		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound compound = (NBTTagCompound) list.getCompoundTagAt(i);
			byte k = compound.getByte("Slot");

			if (k >= 0 && k < this.slots.length) {
				this.slots[k] = ItemStack.loadItemStackFromNBT(compound);
			}
		}
		this.centrifugeTime[0] = nbt.getShort("CentrifugeTime[0]");
		this.centrifugeTime[1] = nbt.getShort("CentrifugeTime[1]");
		this.centrifugeTime[2] = nbt.getShort("CentrifugeTime[2]");
		this.centrifugeTime[3] = nbt.getShort("CentrifugeTime[3]");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setShort("CentrifugeTime[0]", centrifugeTime[0]);
		nbt.setShort("CentrifugeTime[1]", centrifugeTime[1]);
		nbt.setShort("CentrifugeTime[2]", centrifugeTime[2]);
		nbt.setShort("CentrifugeTime[3]", centrifugeTime[3]);
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < this.slots.length; i++) {
			if (this.slots[i] != null) {
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("Slot", (byte) i);
				this.slots[i].writeToNBT(compound);
				list.appendTag(compound);
			}
		}
		nbt.setTag("Items", list);
	}
}