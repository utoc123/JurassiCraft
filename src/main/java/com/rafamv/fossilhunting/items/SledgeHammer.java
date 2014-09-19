package com.rafamv.fossilhunting.items;

import net.minecraft.client.renderer.texture.IIconRegister;

import com.rafamv.fossilhunting.FossilHunting;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SledgeHammer extends FossilBreaker {

	public SledgeHammer(ToolMaterial material) {
		super(material);
		this.setMaxDamage(64);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(FossilHunting.MODID + ":" + this.getUnlocalizedName().substring(5));
	}

}