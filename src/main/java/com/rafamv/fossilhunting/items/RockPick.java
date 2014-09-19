package com.rafamv.fossilhunting.items;

import net.minecraft.client.renderer.texture.IIconRegister;

import com.rafamv.fossilhunting.FossilHunting;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RockPick extends FossilBreaker {

	public RockPick(ToolMaterial material) {
		super(material);
		this.setMaxDamage(48);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(FossilHunting.MODID + ":" + this.getUnlocalizedName().substring(5));
	}

}
