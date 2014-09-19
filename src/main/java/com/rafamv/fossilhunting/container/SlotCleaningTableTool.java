package com.rafamv.fossilhunting.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.rafamv.fossilhunting.items.FossilBreaker;

public class SlotCleaningTableTool extends Slot {
	
	public SlotCleaningTableTool(IInventory inventory, int number, int x, int y) {
		super(inventory, number, x, y);
	}

	@Override
	public int getSlotStackLimit() {
		return 1;
	}

	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return  itemstack.getItem() instanceof FossilBreaker;
	}
}