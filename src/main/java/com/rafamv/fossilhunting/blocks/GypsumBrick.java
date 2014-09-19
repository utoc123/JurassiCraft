package com.rafamv.fossilhunting.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.rafamv.fossilhunting.FossilHunting;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GypsumBrick extends Block {
	
	public GypsumBrick() {
		super(Material.rock);
		this.setHardness(2.0f);
		this.setResistance(5.0f);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(FossilHunting.fossilHuntingTab);
		this.setHarvestLevel("pickaxe", 1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(FossilHunting.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
}
