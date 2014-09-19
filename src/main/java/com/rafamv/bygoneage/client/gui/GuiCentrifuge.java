package com.rafamv.bygoneage.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.rafamv.bygoneage.container.ContainerCentrifuge;
import com.rafamv.bygoneage.enums.BygoneAgeGuiInformation;
import com.rafamv.bygoneage.tileentity.TileEntityCentrifuge;

public class GuiCentrifuge extends GuiContainer {

	private TileEntityCentrifuge centrifuge;
	private ResourceLocation texture = new ResourceLocation(BygoneAgeGuiInformation.CENTRIFUGEMACHINE.getPrimaryGuiPath());

	public GuiCentrifuge(InventoryPlayer inventoryPlayer, TileEntity entity) {
		super(new ContainerCentrifuge(inventoryPlayer, entity));
		if (entity instanceof TileEntityCentrifuge) {
			TileEntityCentrifuge entityCentrifuge = (TileEntityCentrifuge) entity;
			this.centrifuge = entityCentrifuge;
			this.xSize = 176;
			this.ySize = 188;
		}
	}
	
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Centrifuge"), xSize / 2 - this.fontRendererObj.getStringWidth("Centrifuge") / 2, 5, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
