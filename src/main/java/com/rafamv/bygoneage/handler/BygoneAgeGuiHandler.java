package com.rafamv.bygoneage.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.rafamv.bygoneage.client.gui.GuiAnalyzer;
import com.rafamv.bygoneage.client.gui.GuiCentrifuge;
import com.rafamv.bygoneage.client.gui.GuiDNAExtractor;
import com.rafamv.bygoneage.client.gui.GuiHatchery;
import com.rafamv.bygoneage.client.gui.GuiHatcheryProcess;
import com.rafamv.bygoneage.container.ContainerCentrifuge;
import com.rafamv.bygoneage.container.ContainerDNAExtractor;
import com.rafamv.bygoneage.container.ContainerHatchery;
import com.rafamv.bygoneage.enums.BygoneAgeGuiInformation;
import com.rafamv.bygoneage.registry.BygoneAgeBlocks;

import cpw.mods.fml.common.network.IGuiHandler;

public class BygoneAgeGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity != null) {
			if (ID == BygoneAgeGuiInformation.CENTRIFUGEMACHINE.getGuiId()) {
				return ID == BygoneAgeGuiInformation.CENTRIFUGEMACHINE.getGuiId() && world.getBlock(x, y, z) == BygoneAgeBlocks.centrifuge ? new ContainerCentrifuge(player.inventory, tileEntity) : null;
			} else if (ID == BygoneAgeGuiInformation.HATCHERY.getGuiId()) {
				return ID == BygoneAgeGuiInformation.HATCHERY.getGuiId() && world.getBlock(x, y, z) == BygoneAgeBlocks.hatchery ? new ContainerHatchery(player.inventory, tileEntity) : null;
			} else if (ID == BygoneAgeGuiInformation.DNAEXTRACTOR.getGuiId()) {
				return ID == BygoneAgeGuiInformation.DNAEXTRACTOR.getGuiId() && world.getBlock(x, y, z) == BygoneAgeBlocks.dnaExtractor ? new ContainerDNAExtractor(player.inventory, tileEntity) : null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity != null) {
			if (ID == BygoneAgeGuiInformation.CENTRIFUGEMACHINE.getGuiId()) {
				return ID == BygoneAgeGuiInformation.CENTRIFUGEMACHINE.getGuiId() && world.getBlock(x, y, z) == BygoneAgeBlocks.centrifuge ? new GuiCentrifuge(player.inventory, tileEntity) : null;
			} else if (ID == BygoneAgeGuiInformation.HATCHERY.getGuiId()) {
				return ID == BygoneAgeGuiInformation.HATCHERY.getGuiId() && world.getBlock(x, y, z) == BygoneAgeBlocks.hatchery ? new GuiHatchery(player.inventory, tileEntity) : null;
			} else if (ID == BygoneAgeGuiInformation.HATCHERYPROCESS.getGuiId()) {
				return ID == BygoneAgeGuiInformation.HATCHERYPROCESS.getGuiId() && world.getBlock(x, y, z) == BygoneAgeBlocks.hatchery ? new GuiHatcheryProcess(tileEntity) : null;
			} else if (ID == BygoneAgeGuiInformation.DNAEXTRACTOR.getGuiId()) {
				return ID == BygoneAgeGuiInformation.DNAEXTRACTOR.getGuiId() && world.getBlock(x, y, z) == BygoneAgeBlocks.dnaExtractor ? new GuiDNAExtractor(player.inventory, tileEntity) : null;
			}
		}
		if (ID == BygoneAgeGuiInformation.ANALYZER.getGuiId()) {
			return new GuiAnalyzer();
		}
		return null;
	}

}
