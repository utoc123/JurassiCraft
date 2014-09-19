package com.rafamv.bygoneage.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.rafamv.bygoneage.enums.BygoneAgeFoodInformation;
import com.rafamv.bygoneage.items.dnaitems.AnyDNASample;
import com.rafamv.bygoneage.tileentity.TileEntityHatchery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerHatchery extends Container {

	private TileEntityHatchery hatchery;
	private int lastWaterStored;
	private int lastProximateValue;
	private int lastMineralsValue;
	private int lastVitaminsValue;
	private int lastLipidsValue;

	public ContainerHatchery(InventoryPlayer playerInventory, TileEntity tileEntity) {
		this.hatchery = (TileEntityHatchery) tileEntity;
		this.addSlotToContainer(new SlotBucket(hatchery, 0, 12, 20));
		this.addSlotToContainer(new SlotBucket(hatchery, 1, 12, 68));
		this.addSlotToContainer(new SlotDNASample(hatchery, 2, 122, 20));
		this.addSlotToContainer(new SlotDNASample(hatchery, 3, 110, 44));
		this.addSlotToContainer(new SlotDNASample(hatchery, 4, 134, 44));
		this.addSlotToContainer(new SlotDNASample(hatchery, 5, 110, 68));
		this.addSlotToContainer(new SlotDNASample(hatchery, 6, 134, 68));
		this.addSlotToContainer(new Slot(hatchery, 7, 208, 20));

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(playerInventory, k + i * 9 + 9, k * 18 + 8, i * 18 + 106));
			}
		}

		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(playerInventory, i, i * 18 + 8, 164));
		}

	}

	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		if (!player.worldObj.isRemote) {
			hatchery.closeInventory();
		}
	}

	@Override
	public void addCraftingToCrafters(ICrafting iCrafting) {
		super.addCraftingToCrafters(iCrafting);
		iCrafting.sendProgressBarUpdate(this, 0, this.hatchery.getWaterStored());
		iCrafting.sendProgressBarUpdate(this, 1, this.hatchery.getProximateValue());
		iCrafting.sendProgressBarUpdate(this, 2, this.hatchery.getMineralValue());
		iCrafting.sendProgressBarUpdate(this, 3, this.hatchery.getVitaminValue());
		iCrafting.sendProgressBarUpdate(this, 4, this.hatchery.getLipidValue());
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for (int i = 0; i < this.crafters.size(); i++) {
			ICrafting iCrafting = (ICrafting) this.crafters.get(i);
			if (this.lastWaterStored != this.hatchery.getWaterStored()) {
				iCrafting.sendProgressBarUpdate(this, 0, this.hatchery.getWaterStored());
			}
			if (this.lastProximateValue != this.hatchery.getProximateValue()) {
				iCrafting.sendProgressBarUpdate(this, 1, this.hatchery.getProximateValue());
			}
			if (this.lastMineralsValue != this.hatchery.getMineralValue()) {
				iCrafting.sendProgressBarUpdate(this, 2, this.hatchery.getMineralValue());
			}
			if (this.lastVitaminsValue != this.hatchery.getVitaminValue()) {
				iCrafting.sendProgressBarUpdate(this, 3, this.hatchery.getVitaminValue());
			}
			if (this.lastLipidsValue != this.hatchery.getLipidValue()) {
				iCrafting.sendProgressBarUpdate(this, 4, this.hatchery.getLipidValue());
			}
		}
		lastWaterStored = hatchery.getWaterStored();
		lastProximateValue = hatchery.getProximateValue();
		lastMineralsValue = hatchery.getMineralValue();
		lastVitaminsValue = hatchery.getVitaminValue();
		lastLipidsValue = hatchery.getLipidValue();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int i, int unknown) {
		if (i == 0) {
			this.hatchery.setWaterStored((byte) unknown);
		}
		if (i == 1) {
			this.hatchery.setProximateValue((short) unknown);
		}
		if (i == 2) {
			this.hatchery.setMineralValue((short) unknown);
		}
		if (i == 3) {
			this.hatchery.setVitaminValue((short) unknown);
		}
		if (i == 4) {
			this.hatchery.setLipidValue((short) unknown);
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return hatchery.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int i) {
		if (!entityPlayer.worldObj.isRemote) {
			Slot slot = (Slot) inventorySlots.get(i);
			ItemStack stackFinal = null;
			if (slot != null && slot.getHasStack()) {
				ItemStack stackInSlot = slot.getStack();
				stackFinal = stackInSlot.copy();
				if (i < 8) {
					if (!mergeItemStack(stackInSlot, 8, inventorySlots.size(), true)) {
						return null;
					}
					slot.onSlotChange(stackInSlot, stackFinal);
				} else if (i >= 8) {
					if (stackInSlot.getItem() instanceof ItemBucket) {
						if (!mergeItemStack(stackInSlot, 0, 2, false)) {
							return null;
						}
					} else if (stackInSlot.getItem() instanceof AnyDNASample) {
						if (!mergeItemStack(stackInSlot, 2, 7, false)) {
							return null;
						}
					} else if (BygoneAgeFoodInformation.FOODLIST.containsKey(stackInSlot.getItem())) {
						if (!mergeItemStack(stackInSlot, 7, 8, false)) {
							return null;
						}
					} else {
						return null;
					}
				} else {
					return null;
				}

				if (stackInSlot.stackSize == 0) {
					slot.putStack((ItemStack) null);
				} else {
					slot.onSlotChanged();
				}
				return stackFinal;
			}
			return null;
		}
		return null;
	}
}