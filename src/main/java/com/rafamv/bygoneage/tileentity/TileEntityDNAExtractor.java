package com.rafamv.bygoneage.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumChatFormatting;

import com.rafamv.bygoneage.enums.BygoneAgeFossilDrops;
import com.rafamv.bygoneage.enums.BygoneAgeGeneticsInformation;
import com.rafamv.bygoneage.handler.BygoneAgeDNAHandler;
import com.rafamv.bygoneage.items.dnaitems.AnyDNASource;
import com.rafamv.bygoneage.items.dnaitems.EmptyVial;
import com.rafamv.bygoneage.registry.BygoneAgeItems;

public class TileEntityDNAExtractor extends TileEntityWithRotations implements ISidedInventory, IInventory {

	private ItemStack[] slots = new ItemStack[9];
	private static final short analyzeSpeed = 100;
	private short analyzeTime;

	public TileEntityDNAExtractor() {
		this.analyzeTime = 0;
	}

	public short getAnalyzeTime() {
		return analyzeTime;
	}

	public void setAnalyzeTime(short time) {
		this.analyzeTime = time;
	}

	public int getAnalyzeTimeProgressScaled(int i) {
		return (analyzeTime * i) / analyzeSpeed;
	}

	public boolean isAnalyzing() {
		return (analyzeTime > 0);
	}

	private boolean canAnalyze() {
		if (slots[8] == null || !(slots[8].getItem() instanceof EmptyVial)) {
			return false;
		} else if (slots[0] == (ItemStack) null && slots[1] == (ItemStack) null && slots[2] == (ItemStack) null && slots[3] == (ItemStack) null) {
			return false;
		} else if (!(slots[4] == (ItemStack) null) && !(slots[5] == (ItemStack) null) && !(slots[6] == (ItemStack) null) && !(slots[7] == (ItemStack) null)) {
			return false;
		} else {
			for (int i = 0; i < 4; i++) {
				if (!(slots[i] == (ItemStack) null)) {
					if (slots[i].getItem() instanceof AnyDNASource) {
						if (slots[i].hasTagCompound()) {
							if (slots[i].getTagCompound().hasKey("CreatureName")) {
								return false;
							}
						}
					} else {
						return false;
					}
				}
			}
			return true;
		}
	}

	private void analyzeItem() {
		for (int i = 0; i < 4; i++) {
			if (!(slots[i] == (ItemStack) null)) {
				NBTTagCompound compound = new NBTTagCompound();
				Byte[] possibleCreaturesID = BygoneAgeFossilDrops.getDropFromFossil(slots[i].getItem());
				String creatureName = BygoneAgeGeneticsInformation.values()[possibleCreaturesID[this.worldObj.rand.nextInt(possibleCreaturesID.length)]].getCreatureName();
				if (creatureName == null) {
					System.out.println("DNA Extractor fail! Null creature name or id.");
					creatureName = BygoneAgeDNAHandler.getRandomAnimalNameForDNA();
				}
				if (!slots[i].hasTagCompound()) {
					compound.setString("CreatureName", creatureName);
					compound.setString("RNAHelix1", BygoneAgeDNAHandler.generateNewRNA(18));
					compound.setString("RNAHelix2", BygoneAgeDNAHandler.createNewRNAFrom(compound.getString("RNAHelix1")));
				} else {
					if (!slots[i].getTagCompound().hasKey("CreatureName")) {
						compound.setString("CreatureName", creatureName);
					}
					if (!slots[i].getTagCompound().hasKey("RNAHelix1") && !slots[i].getTagCompound().hasKey("RNAHelix2")) {
						compound.setString("RNAHelix1", BygoneAgeDNAHandler.generateNewRNA(18));
						compound.setString("RNAHelix2", BygoneAgeDNAHandler.createNewRNAFrom(compound.getString("RNAHelix1")));
					} else {
						if (slots[i].getTagCompound().hasKey("RNAHelix1") && slots[i].getTagCompound().hasKey("RNAHelix2")) {
							compound.setString("RNAHelix1", slots[i].getTagCompound().getString("RNAHelix1"));
							compound.setString("RNAHelix2", slots[i].getTagCompound().getString("RNAHelix2"));
						} else if (slots[i].getTagCompound().hasKey("RNAHelix1") && !slots[i].getTagCompound().hasKey("RNAHelix2")) {
							compound.setString("RNAHelix1", slots[i].getTagCompound().getString("RNAHelix1"));
							compound.setString("RNAHelix2", BygoneAgeDNAHandler.createNewRNAFrom(compound.getString("RNAHelix1")));
						} else if (!slots[i].getTagCompound().hasKey("RNAHelix1") && slots[i].getTagCompound().hasKey("RNAHelix2")) {
							compound.setString("RNAHelix2", slots[i].getTagCompound().getString("RNAHelix2"));
							compound.setString("RNAHelix1", BygoneAgeDNAHandler.createNewRNAFrom(compound.getString("RNAHelix2")));
						}
					}
				}
				ItemStack newItem = new ItemStack(BygoneAgeItems.dnaSample);
				newItem.setTagCompound(compound);
				for (int j = 4; j < 8; j++) {
					if (slots[j] == (ItemStack) null) {
						slots[i].stackSize--;
						if (slots[i].stackSize <= 0) {
							slots[i] = (ItemStack) null;
						}
						slots[8].stackSize--;
						if (slots[8].stackSize <= 0) {
							slots[8] = (ItemStack) null;
						}
						slots[j] = newItem;
						return;
					}
				}
			}
		}
	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
			if (canAnalyze()) {
				analyzeTime++;
				if (analyzeTime >= analyzeSpeed) {
					analyzeTime = 0;
					analyzeItem();
				}
			} else {
				analyzeTime = 0;
			}
		}
	}

	public boolean hasItems() {
		if (slots[0] != null || slots[1] != null || slots[2] != null || slots[3] != null || slots[4] != null || slots[5] != null || slots[6] != null || slots[7] != null || slots[8] != null) {
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
		return "DNA Extractor";
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
		this.analyzeTime = nbt.getShort("AnalyzeTime");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setShort("AnalyzeTime", analyzeTime);
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