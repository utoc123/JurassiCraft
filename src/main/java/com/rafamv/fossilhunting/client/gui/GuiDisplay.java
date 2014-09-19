package com.rafamv.fossilhunting.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.rafamv.fossilhunting.FossilHunting;

public class GuiDisplay extends GuiContainer {

	private ResourceLocation texture = new ResourceLocation(FossilHunting.MODID + ":" + "textures/gui/GuiDisplay.png");

	public GuiDisplay(InventoryPlayer inventoryPlayer, TileEntity entity) {
		super(null);
		this.xSize = 512;
		this.ySize = 256;
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Display"), xSize / 2 - this.fontRendererObj.getStringWidth("Display") / 2, 5, 464000);
	}

	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
