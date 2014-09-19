package com.rafamv.fossilhunting.handler;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import com.rafamv.fossilhunting.items.FHItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class FHCraftingHandler {
	
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event) {
		
		final IInventory craftMatrix = null;
		for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
			if (event.craftMatrix.getStackInSlot(i) != null) {
				
				ItemStack item0 = event.craftMatrix.getStackInSlot(i);
				if (item0 != null && item0.getItem() == FHItems.itemDEXBrush) {
					ItemStack k = new ItemStack(FHItems.itemDEXBrush, 2, (item0.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);
				}

				ItemStack item1 = event.craftMatrix.getStackInSlot(i);
				if (item1 != null && item1.getItem() == FHItems.itemDEXChisel) {
					ItemStack k = new ItemStack(FHItems.itemDEXChisel, 2, (item1.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);
				}

				ItemStack item2 = event.craftMatrix.getStackInSlot(i);
				if (item2 != null && item2.getItem() == FHItems.itemDEXRockPick) {
					ItemStack k = new ItemStack(FHItems.itemDEXRockPick, 2, (item2.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);
				}

				ItemStack item3 = event.craftMatrix.getStackInSlot(i);
				if (item3 != null && item3.getItem() == FHItems.itemDEXSledgeHammer) {
					ItemStack k = new ItemStack(FHItems.itemDEXSledgeHammer, 2, (item3.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				
				
				
			}
		}
	}
}
