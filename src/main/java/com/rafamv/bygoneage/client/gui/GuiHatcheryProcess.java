package com.rafamv.bygoneage.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import com.rafamv.bygoneage.enums.BygoneAgeGeneticsInformation;
import com.rafamv.bygoneage.enums.BygoneAgeGuiInformation;
import com.rafamv.bygoneage.tileentity.TileEntityHatchery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiHatcheryProcess extends GuiScreen {

	private TileEntityHatchery hatchery;
	private ResourceLocation texture = new ResourceLocation(BygoneAgeGuiInformation.HATCHERYPROCESS.getPrimaryGuiPath());
	private int xSize;
	private int ySize;
	private int guiLeft;
	private int guiTop;

	public GuiHatcheryProcess(TileEntity entity) {
		super();
		if (entity instanceof TileEntityHatchery) {
			TileEntityHatchery entityHatchery = (TileEntityHatchery) entity;
			this.hatchery = entityHatchery;
			this.xSize = 176;
			this.ySize = 107;
		}
	}

	@Override
	public void initGui() {
		super.initGui();
		this.buttonList.clear();
		this.guiLeft = (int) ((this.width - this.xSize) / 2);
		this.guiTop = (int) ((this.height - this.ySize) / 2);
		this.buttonList.add(new GuiButton(0, this.guiLeft + (this.xSize - 100) / 2, this.guiTop + 70, 100, 20, "Cancel hatching"));
	}

	@Override
	public void actionPerformed(GuiButton button) {
		if (button.id == 0) {
			float progress = (float) this.hatchery.getHatcheryTimeProgressScaled(100) / 100.0F;
			this.hatchery.cancelHatching(progress);
			this.mc.thePlayer.closeScreen();
		}
	}

	@Override
	public void drawScreen(int x, int y, float f) {
		drawDefaultBackground();
		Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		this.drawTexturedModalRect(this.guiLeft + 13, this.guiTop + 49, 0, 107, this.hatchery.getHatcheryTimeProgressScaled(150), 9);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Hatching: " + BygoneAgeGeneticsInformation.values()[this.hatchery.getEmbryoID()].getCreatureName()), this.guiLeft + (this.xSize - this.fontRendererObj.getStringWidth("Hatching: " + BygoneAgeGeneticsInformation.values()[this.hatchery.getEmbryoID()].getCreatureName())) / 2, this.guiTop + 10, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Progress: " + this.hatchery.getHatcheryTimeProgressScaled(100) + "%"), this.guiLeft + (this.xSize - this.fontRendererObj.getStringWidth("Progress: " + this.hatchery.getHatcheryTimeProgressScaled(100) + "%")) / 2, this.guiTop + 30, 4210752);
		super.drawScreen(x, y, f);
	}

	@Override
	protected void keyTyped(char var1, int key) {
		if (key == 1 || key == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
			this.mc.thePlayer.closeScreen();
		}
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}
}
