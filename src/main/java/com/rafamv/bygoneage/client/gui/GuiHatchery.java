package com.rafamv.bygoneage.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.rafamv.bygoneage.container.ContainerHatchery;
import com.rafamv.bygoneage.enums.BygoneAgeGuiInformation;
import com.rafamv.bygoneage.tileentity.TileEntityHatchery;

public class GuiHatchery extends GuiContainer {

	private TileEntityHatchery hatchery;
	private ResourceLocation textureLeft = new ResourceLocation(BygoneAgeGuiInformation.HATCHERY.getPrimaryGuiPath());
	private ResourceLocation textureRight = new ResourceLocation(BygoneAgeGuiInformation.HATCHERY.getSecondaryGuiPath());

	public GuiHatchery(InventoryPlayer inventoryPlayer, TileEntity entity) {
		super(new ContainerHatchery(inventoryPlayer, entity));
		if (entity instanceof TileEntityHatchery) {
			TileEntityHatchery entityHatchery = (TileEntityHatchery) entity;
			this.hatchery = entityHatchery;
			this.xSize = 352;
			this.ySize = 188;
		}
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Hatchery"), 100, 6, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Proximates"), 200, 48, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Minerals"), 200, 74, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Vitamins"), 200, 100, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Lipids"), 200, 126, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(textureLeft);
		drawTexturedModalRect(this.width/2 - xSize/2, this.height/2 - ySize/2, 0, 0, 176, 188);
		int i0 = this.hatchery.getWaterStoredProgressScaled(67);
		this.drawTexturedModalRect(guiLeft + 48, guiTop + 18, 0, 188, 42, 67 - i0);
		Minecraft.getMinecraft().getTextureManager().bindTexture(textureRight);
		drawTexturedModalRect(this.width / 2 + 1, this.height / 2 - ySize / 2, 0, 0, 176, 166);
		int i1 = this.hatchery.getProximateBarScaled(150);
		this.drawTexturedModalRect(guiLeft + 190, guiTop + 56, 0, 166, i1, 9);
		int i2 = this.hatchery.getMineralBarScaled(150);
		this.drawTexturedModalRect(guiLeft + 190, guiTop + 82, 0, 175, i2, 9);
		int i3 = this.hatchery.getVitaminBarScaled(150);
		this.drawTexturedModalRect(guiLeft + 190, guiTop + 108, 0, 184, i3, 9);
		int i4 = this.hatchery.getLipidBarScaled(150);
		this.drawTexturedModalRect(guiLeft + 190, guiTop + 134, 0, 193, i4, 9);
	}
}
