package com.rafamv.fossilhunting.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;

public class SlotBarrelWater extends Slot {
	
	public SlotBarrelWater(IInventory inventory, int number, int x, int y) {
		super(inventory, number, x, y);
	}

	@Override
	public int getSlotStackLimit() {
		return 16;
	}

	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return	itemstack.getItem() instanceof ItemBucket;
	}

	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack) {
		this.onCrafting(itemStack);
		super.onPickupFromSlot(player, itemStack);
	}
}