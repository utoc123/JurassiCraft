package com.rafamv.fossilhunting.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.rafamv.fossilhunting.blocks.FHBlocks;
import com.rafamv.fossilhunting.crafting.CleaningTableCraftingManager;
import com.rafamv.fossilhunting.items.FHItems;

public class ContainerCleaningTable extends Container {
	
	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	
	public ContainerCleaningTable(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		craftMatrix = new InventoryCrafting(this, 1, 2);
		craftResult = new InventoryCraftResult();
		worldObj = world;
		posX = x;
		posY = y;
		posZ = z;
		
		this.addSlotToContainer(new SlotCleaningTableTool(craftMatrix, 0, 41, 23));
		this.addSlotToContainer(new SlotCleaningTableFossil(craftMatrix, 1, 41, 62));
		this.addSlotToContainer(new SlotCrafting(invPlayer.player, craftMatrix, craftResult, 2, 113, 43));
		
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 106 + i * 18));
			}
		}
		
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 164));
		}
		
		onCraftMatrixChanged(craftMatrix);
	}

	@Override
	public void onCraftMatrixChanged(IInventory iiventory) {
		craftResult.setInventorySlotContents(0, CleaningTableCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if (worldObj.getBlock(posX, posY, posZ) != FHBlocks.blockFHCleaningTableBlock) {
			return false;
		} else {
			return player.getDistanceSq((double) posX + 0.5D, (double) posY + 0.5D, (double) posZ + 0.5D) <= 64.0D;
		}
	}

	@Override
	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
		super.onContainerClosed(par1EntityPlayer);
		if (!this.worldObj.isRemote) {
			for (int i = 0; i < 2; ++i) {
				ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

				if (itemstack != null) {
					par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
				}
			}
		}
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int i) {
		if (!entityPlayer.worldObj.isRemote) {
			Slot slot = (Slot) inventorySlots.get(i);
			ItemStack stackFinal = null;
			if (slot != null && slot.getHasStack()) {
				ItemStack stackInSlot = slot.getStack();
				stackFinal = stackInSlot.copy();
				if (i <= 1) {
					if (!mergeItemStack(stackInSlot, 2, inventorySlots.size(), true)) {
						return null;
					}
				slot.onSlotChange(stackInSlot, stackFinal);
				}
				else if (i >= 3) {
					if (stackInSlot.getItem() == FHItems.itemDEXRockPick ||
						stackInSlot.getItem() == FHItems.itemDEXChisel ||
						stackInSlot.getItem() == FHItems.itemDEXBrush) {
						if (!mergeItemStack(stackInSlot, 0, 1, false)) {
							return null;
						}
					} else if (stackInSlot.getUnlocalizedName().equals(FHBlocks.blockFHEncasedFossilBlock.getUnlocalizedName()) ||
							   stackInSlot.getUnlocalizedName().equals(FHItems.itemDEXEncasedFossil.getUnlocalizedName()) ||
							   stackInSlot.getUnlocalizedName().equals(FHItems.itemDEXCoveredFossil.getUnlocalizedName()) ||
							   stackInSlot.getUnlocalizedName().equals(FHItems.itemFHFossil.getUnlocalizedName())) {
						if (!mergeItemStack(stackInSlot, 1, 2, false)) {
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
