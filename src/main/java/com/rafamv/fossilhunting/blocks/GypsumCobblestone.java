package com.rafamv.fossilhunting.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.rafamv.fossilhunting.FossilHunting;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GypsumCobblestone extends Block {

	public GypsumCobblestone() {
		super(Material.rock);
		this.setHardness(1.2f);
		this.setResistance(2.5f);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(FossilHunting.fossilHuntingTab);
		this.setHarvestLevel("pickaxe", 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(FossilHunting.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
}
