package com.rafamv.fossilhunting.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.tileentity.TileEntityBarrel;
import com.rafamv.fossilhunting.tileentity.TileEntityCleaningTable;

public class CleaningTable extends BlockContainer {

	public CleaningTable() {
		super(Material.wood);
		this.setHardness(2.0f);
		this.setResistance(5.0f);
		this.setLightOpacity(2);
		this.setStepSound(soundTypeWood);
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.9f, 1.0f);
		this.setCreativeTab(FossilHunting.fossilHuntingTab);
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!player.isSneaking()) {
			player.openGui(FossilHunting.instance,
					FHBlocks.guiIDFHCleaningTableBlock, world, x, y, z);
			return true;
		} else {
			return false;
		}
	}

	public TileEntity createNewTileEntity(World var1, int var2) {
		try {
			return new TileEntityCleaningTable();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
