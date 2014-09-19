package com.rafamv.fossilhunting.blocks.fossils;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.rafamv.fossilhunting.enums.FossilInformation;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilCompsognathus;

public class FossilModelCompsognathus extends AnyFossilModel implements ITileEntityProvider {

	public FossilModelCompsognathus() {

	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		try {
			return new TileEntityFossilCompsognathus();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
