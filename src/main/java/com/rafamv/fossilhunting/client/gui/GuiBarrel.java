package com.rafamv.fossilhunting.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.container.ContainerBarrel;
import com.rafamv.fossilhunting.tileentity.TileEntityBarrel;

public class GuiBarrel extends GuiContainer {
	
	private TileEntityBarrel barrel;
	private ResourceLocation texture = new ResourceLocation(FossilHunting.MODID + ":" + "textures/gui/GuiBarrel.png");

	public GuiBarrel(InventoryPlayer inventoryPlayer, TileEntity entity) {
		super(new ContainerBarrel(inventoryPlayer, entity));
		if (entity instanceof TileEntityBarrel) {
			TileEntityBarrel entityBarrel = (TileEntityBarrel) entity;
			this.barrel = entityBarrel;
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
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Barrel"), xSize/2 - this.fontRendererObj.getStringWidth("Barrel")/2, 5, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if (barrel.hasWater()) {
			int i = this.barrel.getWaterStoredProgressScaled(110);
			this.drawTexturedModalRect(guiLeft + 33, guiTop + 73, 0, 188, 1 + i, 12);
		}
		
		if (barrel.isSoaking()) {
			int i = this.barrel.getSoakRemainingScaled(22);
			this.drawTexturedModalRect(guiLeft + 73, guiTop + 29, 176, 0, 1 + i, 17);
		}
		
	}
}
