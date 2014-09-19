package com.rafamv.bygoneage.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.rafamv.bygoneage.container.ContainerDNAExtractor;
import com.rafamv.bygoneage.enums.BygoneAgeGuiInformation;
import com.rafamv.bygoneage.tileentity.TileEntityDNAExtractor;

public class GuiDNAExtractor extends GuiContainer {

	private TileEntityDNAExtractor dnaExtractor;
	private ResourceLocation texture = new ResourceLocation(BygoneAgeGuiInformation.DNAEXTRACTOR.getPrimaryGuiPath());

	public GuiDNAExtractor(InventoryPlayer inventoryPlayer, TileEntity tileEntity) {
		super(new ContainerDNAExtractor(inventoryPlayer, tileEntity));
		if (tileEntity instanceof TileEntityDNAExtractor) {
			TileEntityDNAExtractor tileEntityDNAExtractor = (TileEntityDNAExtractor) tileEntity;
			this.dnaExtractor = tileEntityDNAExtractor;
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
		this.fontRendererObj.drawString(StatCollector.translateToLocal("DNA Extractor"), xSize / 2 - this.fontRendererObj.getStringWidth("DNA Extractor") / 2, 5, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		int i = this.dnaExtractor.getAnalyzeTimeProgressScaled(22);
		this.drawTexturedModalRect(guiLeft + 77, guiTop + 38, 176, 0, i, 17);
	}
}
