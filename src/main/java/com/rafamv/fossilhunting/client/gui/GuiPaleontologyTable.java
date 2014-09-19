package com.rafamv.fossilhunting.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.container.ContainerPaleontologyTable;

public class GuiPaleontologyTable extends GuiContainer {
	
	private ResourceLocation texture = new ResourceLocation(FossilHunting.MODID + ":" + "textures/gui/GuiPaleontologyTable.png");

	public GuiPaleontologyTable(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		super(new ContainerPaleontologyTable(invPlayer, world, x, y, z));
		this.xSize = 176;
		this.ySize = 188;
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Paleontology Table"), xSize/2 - this.fontRendererObj.getStringWidth("Paleontology Table")/2, 5, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
