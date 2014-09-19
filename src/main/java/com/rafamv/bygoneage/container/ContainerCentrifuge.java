package com.rafamv.bygoneage.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.rafamv.bygoneage.items.dnaitems.AnyDNASample;
import com.rafamv.bygoneage.tileentity.TileEntityCentrifuge;

public class ContainerCentrifuge extends Container {

	private TileEntityCentrifuge centrifuge;

	public ContainerCentrifuge(InventoryPlayer playerInventory, TileEntity tileEntity) {
		this.centrifuge = (TileEntityCentrifuge) tileEntity;
		this.addSlotToContainer(new SlotDNASample(centrifuge, 0, 56, 22));
		this.addSlotToContainer(new SlotDNASample(centrifuge, 1, 104, 22));
		this.addSlotToContainer(new SlotDNASample(centrifuge, 2, 56, 70));
		this.addSlotToContainer(new SlotDNASample(centrifuge, 3, 104, 70));

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
			centrifuge.closeInventory();
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return centrifuge.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int i) {
		if (!entityPlayer.worldObj.isRemote) {
			Slot slot = (Slot) inventorySlots.get(i);
			ItemStack stackFinal = null;
			if (slot != null && slot.getHasStack()) {
				ItemStack stackInSlot = slot.getStack();
				stackFinal = stackInSlot.copy();
				if (i < 4) {
					if (!mergeItemStack(stackInSlot, 4, inventorySlots.size(), true)) {
						return null;
					}
					slot.onSlotChange(stackInSlot, stackFinal);
				} else if (i >= 4) {
					if (stackInSlot.getItem() instanceof AnyDNASample) {
						if (!mergeItemStack(stackInSlot, 0, 4, false)) {
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