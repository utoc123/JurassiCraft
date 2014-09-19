package com.rafamv.fossilhunting.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.rafamv.fossilhunting.items.FHItems;

public class SlotBarrelPowder extends Slot {
	
	public SlotBarrelPowder(IInventory inventory, int number, int x, int y) {
		super(inventory, number, x, y);
	}

	@Override
	public int getSlotStackLimit() {
		return 64;
	}

	@Override
	public boolean isItemValid(ItemStack itemStack) {
		return itemStack.getUnlocalizedName().equals(FHItems.itemDEXPlasterPowder.getUnlocalizedName());
	}
	
}