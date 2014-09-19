package com.rafamv.fossilhunting.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.rafamv.fossilhunting.items.FHItems;
import com.rafamv.fossilhunting.tileentity.TileEntityBarrel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerBarrel extends Container {

	private TileEntityBarrel barrel;
	private int lastWaterStored;
	private int lastSoakTime;

	public ContainerBarrel(InventoryPlayer playerInventory, TileEntity tileentity) {
		this.barrel = (TileEntityBarrel) tileentity;
	    this.addSlotToContainer(new SlotBarrelPaper(barrel, 0, 41, 42));
	    this.addSlotToContainer(new SlotBarrelPowder(barrel, 1, 41, 18));
		this.addSlotToContainer(new SlotFurnace(playerInventory.player, barrel, 2, 114, 30));
		this.addSlotToContainer(new SlotBarrelWater(barrel, 3, 8, 71));
		this.addSlotToContainer(new SlotBarrelWater(barrel, 4, 152, 71));

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
			barrel.closeInventory();
		}
	}

	@Override
	public void addCraftingToCrafters(ICrafting iCrafting) {
		super.addCraftingToCrafters(iCrafting);
		iCrafting.sendProgressBarUpdate(this, 0, this.barrel.getSoakTime());
		iCrafting.sendProgressBarUpdate(this, 1, this.barrel.getWaterStored());
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for (int i = 0; i < this.crafters.size(); i++) {
			
			ICrafting iCrafting = (ICrafting) this.crafters.get(i);
			
			if (this.lastSoakTime != this.barrel.getSoakTime()) {
				iCrafting.sendProgressBarUpdate(this, 0, this.barrel.getSoakTime());
			}
			
			if (this.lastWaterStored != this.barrel.getWaterStored()) {
				iCrafting.sendProgressBarUpdate(this, 1, this.barrel.getWaterStored());
			}
		}
		lastSoakTime = barrel.getSoakTime();
		lastWaterStored = barrel.getWaterStored();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int i, int unknown) {
		if (i == 0) {
			this.barrel.setSoakTime(unknown);
		}
		if (i == 1) {
			this.barrel.setWaterStored(unknown);
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return barrel.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int i) {
		if (!entityPlayer.worldObj.isRemote) {
			Slot slot = (Slot) inventorySlots.get(i);
			ItemStack stackFinal = null;
			if (slot != null && slot.getHasStack()) {
				ItemStack stackInSlot = slot.getStack();
				stackFinal = stackInSlot.copy();
				if (i <= 4) {
					if (!mergeItemStack(stackInSlot, 5, inventorySlots.size(), true)) {
						return null;
					}
				slot.onSlotChange(stackInSlot, stackFinal);
				}
				else if (i >= 5) {
					if (stackInSlot.getItem() == Items.paper) {
						if (!mergeItemStack(stackInSlot, 0, 1, false)) {
							return null;
						}
					} else if (stackInSlot.getItem() == FHItems.itemDEXPlasterPowder) {
						if (!mergeItemStack(stackInSlot, 1, 2, false)) {
							return null;
						}
					} else if (stackInSlot.getItem() == Items.water_bucket || stackInSlot.getItem() == Items.bucket) {
						if (!mergeItemStack(stackInSlot, 3, 4, false)) {
							return null;
						}
					} else {
							return null;
					}					
				} else {
					return null;
				}

				if (stackInSlot.stackSize == 0) {
					slot.putStack((ItemStack)null);
				}
				else {
					slot.onSlotChanged();
				}
				return stackFinal;
			}
			return null;
		}
		return null;
	}
	
}