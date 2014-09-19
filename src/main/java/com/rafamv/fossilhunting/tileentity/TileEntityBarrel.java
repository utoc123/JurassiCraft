package com.rafamv.fossilhunting.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.rafamv.fossilhunting.items.FHItems;

public class TileEntityBarrel extends TileEntity implements ISidedInventory, IInventory {

	private ItemStack[] slots = new ItemStack[5];
	private byte waterStored;
	private byte maxWaterStored;
	private byte waterUsed;
	private byte soakTime;
	private byte soakSpeed;
	public int direction;

	public TileEntityBarrel() {
		byte numberOfBuckets = 3;
		this.waterStored = 0;
		this.waterUsed = 8;
		this.maxWaterStored = (byte) (waterUsed*numberOfBuckets);
		this.soakTime = 0;
		this.soakSpeed = 30;
	}

	public void setSoakTime(int time) {
		soakTime = (byte) time;
	}

	public void setWaterStored(int water) {
		waterStored = (byte) water;
	}

	public int getSoakTime() {
		return soakTime;
	}

	public int getWaterStored() {
		return waterStored;
	}
	
	public int getMaxWaterStored() {
		return maxWaterStored;
	}

	public int getWaterUsed() {
		return waterUsed;
	}

	public boolean validWaterValue(int water) {
		return (water >= 0 && water <= maxWaterStored);
	}

	public void increaseWaterStored(int i) {
		if (validWaterValue(waterStored + i)) {
			waterStored += i;
		}
	}

	public void decreaseWaterStored(int i) {
		if (validWaterValue(waterStored - i)) {
			waterStored -= i;
		}
	}

	public int getWaterStoredProgressScaled(int i) {
		if (maxWaterStored == 0) {
			maxWaterStored = (byte) (waterUsed*3);
		}
		return (waterStored * i) / maxWaterStored;
	}

	public int getSoakRemainingScaled(int i) {
		if (soakSpeed == 0) {
			soakSpeed = 30;
		}
		return (soakTime * i) / soakSpeed;
	}

	public boolean hasWater() {
		return waterStored > 0;
	}

	public boolean isSoaking() {
		return soakTime > 0;
	}

	private boolean canSoak() {
		if (slots[0] == (ItemStack) null || slots[1] == (ItemStack) null) {
			return false;
		} else if (slots[0].getItem() == Items.paper && slots[1].getItem() == FHItems.itemDEXPlasterPowder) {
			if (slots[2] == (ItemStack) null) {
				return true;
			}
			if (!(slots[2].getItem() == FHItems.itemDEXPlasterAndBandage)) {
				return false;
			}
			if (slots[2].stackSize < getInventoryStackLimit() && slots[2].stackSize < slots[2].getMaxStackSize()) {
				return true;
			} else {
				return slots[2].stackSize < 64;
			}
		} else {
			return false;
		}
	}

	private void soakItem() {
		if (!canSoak()) {
			return;
		} else {
			if (slots[2] == (ItemStack) null) {
				slots[2] = new ItemStack(FHItems.itemDEXPlasterAndBandage);
			} else if (slots[2].getItem() == FHItems.itemDEXPlasterAndBandage) {
				slots[2].stackSize++;
			}
			slots[0].stackSize--;
			if (slots[0].stackSize <= 0) {
				slots[0] = (ItemStack) null;
			}
			slots[1].stackSize--;
			if (slots[1].stackSize <= 0) {
				slots[1] = (ItemStack) null;
			}
		}
	}

	private boolean canGetWaterFromBucket() {
		if (slots[3] == null) {
			return false;
		} else {
			if (slots[3].getItem() == Items.water_bucket) {
				if (slots[4] == (ItemStack) null) {
					return true;
				}
				if (!(slots[4].getItem() == Items.bucket)) {
					return false;
				}
				if (slots[4].stackSize < getInventoryStackLimit() && slots[4].stackSize < slots[4].getMaxStackSize()) {
					return true;
				} else {
					return slots[4].stackSize < 16;
				}
			} else {
				return false;
			}
		}
	}

	private void getWaterFromBucket() {
		if (canGetWaterFromBucket()) {
			if (!worldObj.isRemote) {
				if (waterStored + waterUsed <= maxWaterStored) {
					if (slots[4] == (ItemStack) null) {
						slots[4] = new ItemStack(Items.bucket);
					} else if (slots[4].getItem() == Items.bucket) {
						slots[4].stackSize++;
					}
					slots[3].stackSize--;
					increaseWaterStored(waterUsed);
					if (slots[3].stackSize <= 0) {
						slots[3] = (ItemStack) null;
					}
				}
			}
		} else {
			return;
		}
		
	}
	
	private boolean canGetWaterToBucket() {
		if (slots[3] == null) {
			return false;
		} else {
			if (slots[3].getItem() == Items.bucket) {
				if (slots[4] == (ItemStack) null) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}

	private void getWaterToBucket() {
		if (canGetWaterToBucket()) {
			if (!worldObj.isRemote) {
				if (waterStored - waterUsed >= 0) {
					if (slots[4] == (ItemStack) null) {
						slots[4] = new ItemStack(Items.water_bucket);
					}
					slots[3].stackSize--;
					decreaseWaterStored(waterUsed);
					if (slots[3].stackSize <= 0) {
						slots[3] = (ItemStack) null;
					}
				}
			}
		} else {
			return;
		}
	}

	@Override
	public void updateEntity() {
		if (hasWater()) {
			if (canSoak()) {
				soakTime++;
				if (soakTime >= soakSpeed && isSoaking()) {
					decreaseWaterStored(1);
					soakTime = 0;
					soakItem();
				}
			} else {
				soakTime = 0;
			}
			
			
		}
		
		if (canGetWaterToBucket()) {
			getWaterToBucket();
		}
		
		if (canGetWaterFromBucket()) {
			getWaterFromBucket();
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
			ItemStack var2 = this.slots[i];
			this.slots[i] = null;
			return var2;
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
		return "barrel";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
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
		return null;
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
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		NBTTagList tagList = compound.getTagList("Items", 5);
		this.slots = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tabCompound = tagList.getCompoundTagAt(i);
			byte byte0 = tabCompound.getByte("Slot");

			if (byte0 >= 0 && byte0 < this.slots.length) {
				this.slots[byte0] = ItemStack.loadItemStackFromNBT(tabCompound);
			}
		}
		this.soakTime = compound.getByte("SoakTime");
		this.waterStored = compound.getByte("waterStored");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setByte("SoakTime", (byte) soakTime);
		compound.setByte("waterStored", (byte) waterStored);
		NBTTagList tagList = new NBTTagList();

		for (int i = 0; i < this.slots.length; i++) {
			if (this.slots[i] != null) {
				NBTTagCompound tagCompound = new NBTTagCompound();
				tagCompound.setByte("Slot", (byte) i);
				this.slots[i].writeToNBT(tagCompound);
				tagList.appendTag(tagCompound);
			}
		}
		compound.setTag("Items", tagList);
	}
}
