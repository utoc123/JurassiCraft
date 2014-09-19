package com.rafamv.fossilhunting.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.tileentity.TileEntityCleaningTable;
import com.rafamv.fossilhunting.tileentity.TileEntityEncasedFossilBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EncasedFossilBlock extends AnyFossilBlock implements ITileEntityProvider {

	public EncasedFossilBlock() {
		this.setHardness(5.0f);
		this.setResistance(6.0f);
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
		this.setCreativeTab(FossilHunting.fossilHuntingTab);
		this.setHarvestLevel("FOSSILBREAKER", 0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(FossilHunting.MODID + ":" + this.getUnlocalizedName().substring(5));
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		try {
			return new TileEntityEncasedFossilBlock();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
