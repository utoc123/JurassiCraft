package com.rafamv.bygoneage.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.registry.BygoneAgeBlocks;
import com.rafamv.bygoneage.registry.BygoneAgeItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FossilBlock extends Block {

	public FossilBlock(Material blockMaterial) {
		super(blockMaterial);
		this.setHardness(0.5f);
		this.setResistance(1.0f);
		this.setCreativeTab(BygoneAge.bygoneAgeTab);
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> list = new ArrayList<ItemStack>();
		float randomNumber = world.rand.nextFloat();
		if (randomNumber < 0.25F) {
			list.add(new ItemStack(Blocks.cobblestone));
		} else if (randomNumber < 1.0F) {
			list.add(new ItemStack(BygoneAgeItems.prehistoricSkin));
		} else {
			list.add(new ItemStack(BygoneAgeItems.prehistoricSkin));
		}
		return list;
	}

	@Override
	public int quantityDropped(Random random) {
		if (random.nextFloat() >= 0.8F) {
			return 1 + random.nextInt(2);
		} else {
			return 1;
		}
	}

	@Override
	protected boolean canSilkHarvest() {
		return true;
	}

	@Override
	public boolean canDropFromExplosion(Explosion explosion) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(BygoneAge.MODID + ":" + BygoneAgeBlocks.fossilBlock.getUnlocalizedName().substring(5));
	}

}
