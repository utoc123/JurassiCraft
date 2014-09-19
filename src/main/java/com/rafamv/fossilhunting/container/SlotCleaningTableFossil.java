package com.rafamv.fossilhunting.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.rafamv.fossilhunting.blocks.FHBlocks;
import com.rafamv.fossilhunting.items.FHItems;

public class SlotCleaningTableFossil extends Slot {
	
	public SlotCleaningTableFossil(IInventory inventory, int number, int x, int y) {
		super(inventory, number, x, y);
	}

	@Override
	public int getSlotStackLimit() {
		return 64;
	}

	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return  itemstack.getUnlocalizedName().equals(FHBlocks.blockFHEncasedFossilBlock.getUnlocalizedName()) ||
				itemstack.getUnlocalizedName().equals(FHItems.itemDEXEncasedFossil.getUnlocalizedName()) ||
				itemstack.getUnlocalizedName().equals(FHItems.itemDEXCoveredFossil.getUnlocalizedName()) ||
				itemstack.getUnlocalizedName().equals(FHItems.itemFHFossil.getUnlocalizedName());
	}
}