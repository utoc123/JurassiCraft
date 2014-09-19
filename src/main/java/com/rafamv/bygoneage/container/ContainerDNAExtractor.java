package com.rafamv.bygoneage.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.rafamv.bygoneage.enums.BygoneAgeFoodInformation;
import com.rafamv.bygoneage.items.dnaitems.AnyDNASample;
import com.rafamv.bygoneage.items.dnaitems.AnyDNASource;
import com.rafamv.bygoneage.items.dnaitems.EmptyVial;
import com.rafamv.bygoneage.tileentity.TileEntityDNAExtractor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerDNAExtractor extends Container {

	private TileEntityDNAExtractor dnaExtractor;
	private short lastAnalyzeTime;

	public ContainerDNAExtractor(InventoryPlayer playerInventory, TileEntity tileEntity) {
		this.dnaExtractor = (TileEntityDNAExtractor) tileEntity;
		this.addSlotToContainer(new SlotDNASource(dnaExtractor, 0, 29, 29));
		this.addSlotToContainer(new SlotDNASource(dnaExtractor, 1, 47, 29));
		this.addSlotToContainer(new SlotDNASource(dnaExtractor, 2, 29, 47));
		this.addSlotToContainer(new SlotDNASource(dnaExtractor, 3, 47, 47));
		this.addSlotToContainer(new SlotFurnace(playerInventory.player, dnaExtractor, 4, 113, 29));
		this.addSlotToContainer(new SlotFurnace(playerInventory.player, dnaExtractor, 5, 131, 29));
		this.addSlotToContainer(new SlotFurnace(playerInventory.player, dnaExtractor, 6, 113, 47));
		this.addSlotToContainer(new SlotFurnace(playerInventory.player, dnaExtractor, 7, 131, 47));
		this.addSlotToContainer(new SlotEmptyVial(dnaExtractor, 8, 80, 69));

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(playerInventory, k + i * 9 + 9, 8 + k * 18, 106 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 164));
		}
	}

	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		if (!player.worldObj.isRemote) {
			dnaExtractor.closeInventory();
		}
	}

	@Override
	public void addCraftingToCrafters(ICrafting iCrafting) {
		super.addCraftingToCrafters(iCrafting);
		iCrafting.sendProgressBarUpdate(this, 0, this.dnaExtractor.getAnalyzeTime());
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for (int i = 0; i < this.crafters.size(); i++) {
			ICrafting iCrafting = (ICrafting) this.crafters.get(i);
			if (this.lastAnalyzeTime != this.dnaExtractor.getAnalyzeTime()) {
				iCrafting.sendProgressBarUpdate(this, 0, this.dnaExtractor.getAnalyzeTime());
			}
		}
		lastAnalyzeTime = dnaExtractor.getAnalyzeTime();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int i, int unknown) {
		if (i == 0) {
			this.dnaExtractor.setAnalyzeTime((short) unknown);
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return dnaExtractor.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int i) {
		if (!entityPlayer.worldObj.isRemote) {
			Slot slot = (Slot) inventorySlots.get(i);
			ItemStack stackFinal = null;
			if (slot != null && slot.getHasStack()) {
				ItemStack stackInSlot = slot.getStack();
				stackFinal = stackInSlot.copy();
				if (i < 9) {
					if (!mergeItemStack(stackInSlot, 9, inventorySlots.size(), true)) {
						return null;
					}
					slot.onSlotChange(stackInSlot, stackFinal);
				} else if (i >= 9) {
					if (stackInSlot.getItem() instanceof AnyDNASource) {
						if (!mergeItemStack(stackInSlot, 0, 4, false)) {
							return null;
						}
					} else if (stackInSlot.getItem() instanceof EmptyVial) {
						if (!mergeItemStack(stackInSlot, 8, 9, false)) {
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