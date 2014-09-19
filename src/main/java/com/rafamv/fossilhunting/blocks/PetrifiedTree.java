package com.rafamv.fossilhunting.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import com.rafamv.fossilhunting.FossilHunting;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PetrifiedTree extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon blockTop;

	public PetrifiedTree() {
		super(Material.rock);
		this.setHardness(1.5f);
		this.setResistance(6.0f);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(FossilHunting.fossilHuntingTab);
	}

	@Override
	public int quantityDropped(Random a) {
		return 0;
	}

	@Override
	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean isWood(IBlockAccess world, int x, int y, int z) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(FossilHunting.MODID + ":" + this.getUnlocalizedName().substring(5) + "Side");
		this.blockTop = iconRegister.registerIcon(FossilHunting.MODID + ":" + this.getUnlocalizedName().substring(5) + "Top");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return (side == 0 || side == 1) ? this.blockTop : this.blockIcon;
	}

}