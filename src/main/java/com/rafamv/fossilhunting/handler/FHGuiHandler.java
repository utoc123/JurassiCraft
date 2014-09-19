package com.rafamv.fossilhunting.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.rafamv.fossilhunting.blocks.FHBlocks;
import com.rafamv.fossilhunting.client.gui.GuiBarrel;
import com.rafamv.fossilhunting.client.gui.GuiCleaningTable;
import com.rafamv.fossilhunting.client.gui.GuiPaleontologyTable;
import com.rafamv.fossilhunting.container.ContainerBarrel;
import com.rafamv.fossilhunting.container.ContainerCleaningTable;
import com.rafamv.fossilhunting.container.ContainerPaleontologyTable;

import cpw.mods.fml.common.network.IGuiHandler;

public class FHGuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null){
			if(ID == FHBlocks.guiIDFHCleaningTableBlock) {
				return ID == FHBlocks.guiIDFHCleaningTableBlock && world.getBlock(x, y, z) == FHBlocks.blockFHCleaningTableBlock ? new ContainerCleaningTable(player.inventory, world, x, y, z) : null;
			} else if (ID == FHBlocks.guiIDFHBarrelBlock) {
				return ID == FHBlocks.guiIDFHBarrelBlock && world.getBlock(x, y, z) == FHBlocks.blockFHBarrelBlock ? new ContainerBarrel(player.inventory, entity) : null;
			} else if (ID == FHBlocks.guiIDFHPaleontologyTableBlock) {
				return ID == FHBlocks.guiIDFHPaleontologyTableBlock && world.getBlock(x, y, z) == FHBlocks.blockFHPaleontologyTableBlock ? new ContainerPaleontologyTable(player.inventory, world, x, y, z) : null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null){
			if(ID == FHBlocks.guiIDFHCleaningTableBlock) {
				return ID == FHBlocks.guiIDFHCleaningTableBlock && world.getBlock(x, y, z) == FHBlocks.blockFHCleaningTableBlock ? new GuiCleaningTable(player.inventory, world, x, y, z) : null;
			} else if(ID == FHBlocks.guiIDFHBarrelBlock) {
				return ID == FHBlocks.guiIDFHBarrelBlock && world.getBlock(x, y, z) == FHBlocks.blockFHBarrelBlock ? new GuiBarrel(player.inventory, entity) : null;
			} else if(ID == FHBlocks.guiIDFHPaleontologyTableBlock) {
				return ID == FHBlocks.guiIDFHPaleontologyTableBlock && world.getBlock(x, y, z) == FHBlocks.blockFHPaleontologyTableBlock ? new GuiPaleontologyTable(player.inventory, world, x, y, z) : null;
			}
		}
		return null;
	}
	
}
