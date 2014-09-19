package com.rafamv.bygoneage.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.rafamv.bygoneage.items.dnaitems.AnyDNASource;

public class SlotDNASource extends Slot {

	public SlotDNASource(IInventory inventory, int number, int x, int y) {
		super(inventory, number, x, y);
	}

	@Override
	public int getSlotStackLimit() {
		return 64;
	}

	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return (itemstack.getItem() instanceof AnyDNASource);
	}
}