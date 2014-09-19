package com.rafamv.fossilhunting.blocks.fossils;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.rafamv.fossilhunting.enums.FossilInformation;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilVelociraptor;

public class FossilModelVelociraptor extends AnyFossilModel implements ITileEntityProvider {

	public FossilModelVelociraptor() {

	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		try {
			return new TileEntityFossilVelociraptor();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
