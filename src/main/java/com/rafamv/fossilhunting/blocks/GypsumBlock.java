package com.rafamv.fossilhunting.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import com.rafamv.fossilhunting.FossilHunting;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GypsumBlock extends Block {

	public GypsumBlock() {
		super(Material.rock);
		this.setHardness(1.5f);
		this.setResistance(3.0f);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(FossilHunting.fossilHuntingTab);
		this.setHarvestLevel("pickaxe", 1);
	}

	@Override
	public Item getItemDropped(int id, Random random, int metadata) {
		return Item.getItemFromBlock(FHBlocks.blockFHGypsumCobblestoneBlock);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(FossilHunting.MODID
				+ ":" + this.getUnlocalizedName().substring(5));
	}

}
