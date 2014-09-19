package com.rafamv.fossilhunting.items;

import net.minecraft.client.renderer.texture.IIconRegister;

import com.rafamv.fossilhunting.FossilHunting;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Brush extends FossilBreaker {

	public Brush(ToolMaterial material) {
		super(material);
		this.setMaxDamage(16);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(FossilHunting.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
}
