package com.rafamv.bygoneage.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.registry.BygoneAgeItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Microchip extends Item {

	public Microchip() {
		this.setCreativeTab(BygoneAge.bygoneAgeTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(BygoneAge.MODID + ":" + BygoneAgeItems.microship.getUnlocalizedName().substring(5));
	}
}
