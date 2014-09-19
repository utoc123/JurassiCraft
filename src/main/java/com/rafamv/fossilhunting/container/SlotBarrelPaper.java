package com.rafamv.fossilhunting.container;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBarrelPaper extends Slot {
	
	public SlotBarrelPaper(IInventory inventory, int number, int x, int y) {
		super(inventory, number, x, y);
	}

	@Override
	public int getSlotStackLimit() {
		return 64;
	}

	@Override
	public boolean isItemValid(ItemStack itemStack) {
		return itemStack.getUnlocalizedName().equals(Items.paper.getUnlocalizedName());
	}
	
}