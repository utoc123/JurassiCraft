package com.rafamv.fossilhunting.items.fossils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.rafamv.fossilhunting.enums.FossilInformation;

public class AnyFossilItem extends Item {
	
	public AnyFossilItem() {
		this.setMaxDamage(FossilInformation.values().length - 1);
		this.setMaxStackSize(1);
		this.setNoRepair();
	}

	@Override
    public boolean showDurabilityBar(ItemStack stack) {
        return false;
    }
    
}
