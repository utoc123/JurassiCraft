package to.uk.ilexiconn.jurassicraft.client.gui;

import java.util.HashMap;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.container.ContainerSecurityFence;
import to.uk.ilexiconn.jurassicraft.packet.MessageFenceBuilding;
import to.uk.ilexiconn.jurassicraft.packet.MessageFenceCrafting;
import to.uk.ilexiconn.jurassicraft.packet.MessageFenceFixing;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFence;

public class GuiSecurityFence extends GuiContainer {

	private TileSecurityFence fence;
	private int[] requiredMaterials = new int[3];
	private HashMap<Integer, int[]> fenceMap = new HashMap<Integer, int[]>();

	public GuiSecurityFence(InventoryPlayer inventoryPlayer, TileSecurityFence entity) {
		super(new ContainerSecurityFence(inventoryPlayer, entity));
		this.xSize = 256;
		this.ySize = 256;
		this.fence = entity;
	}

	@Override
	public void initGui() {
		super.initGui();
		this.buttonList.clear();
		this.buttonList.add(new GuiButtonFenceGeneric(0, this.guiLeft + 15, this.guiTop + 142, 15, 0, 10, 15));
		this.buttonList.add(new GuiButtonFenceGeneric(1, this.guiLeft + 87, this.guiTop + 142, 25, 0, 10, 15));
		this.buttonList.add(new GuiButtonFenceGeneric(2, this.guiLeft + 5, this.guiTop + 121, 35, 0, 15, 15));
		this.buttonList.add(new GuiButtonFenceGeneric(3, this.guiLeft + 186, this.guiTop + 11, 0, 0, 15, 15));
		this.buttonList.add(new GuiButtonFenceGeneric(4, this.guiLeft + 233, this.guiTop + 79, 50, 0, 7, 7));
		this.buttonList.add(new GuiButtonFenceGeneric(5, this.guiLeft + 233, this.guiTop + 96, 50, 0, 7, 7));
		this.buttonList.add(new GuiButtonFenceGeneric(6, this.guiLeft + 233, this.guiTop + 113, 50, 0, 7, 7));
		this.buttonList.add(new GuiButton(7, this.guiLeft + 138, this.guiTop + 130, 80, 20, StatCollector.translateToLocal("container.fixFence")));
		this.fenceMap = this.fence.getAllMainBlocks();
		this.refreshFixButton();
	}

	@Override
	public void updateScreen() {
		if (this.fence.canBuildFence(this.fence.getSecurityLevel(this.fence.getDirection()), this.fence.getDirection(), this.fence.calculateDistanceToNextPole(this.fence.getDirection()), this.fence.getHeightPlanned(this.fence.getSecurityLevel(this.fence.getDirection())))) {
			this.requiredMaterials = this.fence.getBlocksToRepair(this.fence.getSecurityLevel(this.fence.getDirection()), this.fence.getDirection(), this.fence.calculateDistanceToNextPole(this.fence.getDirection()));
			if (requiredMaterials[0] == 0 && requiredMaterials[1] == 0 && requiredMaterials[2] == 0) {
				((GuiButton) this.buttonList.get(3)).enabled = true;
			} else {
				((GuiButton) this.buttonList.get(3)).enabled = false;
			}
		} else {
			((GuiButton) this.buttonList.get(3)).enabled = false;
		}
		if (this.fence.canCraftBase()) {
			((GuiButton) this.buttonList.get(4)).enabled = true;
		} else {
			((GuiButton) this.buttonList.get(4)).enabled = false;
		}
		if (this.fence.canCraftGrid()) {
			((GuiButton) this.buttonList.get(5)).enabled = true;
		} else {
			((GuiButton) this.buttonList.get(5)).enabled = false;
		}
		if (this.fence.canCraftPole()) {
			((GuiButton) this.buttonList.get(6)).enabled = true;
		} else {
			((GuiButton) this.buttonList.get(6)).enabled = false;
		}
		if (((GuiButton) this.buttonList.get(7)).visible) {
			if (this.fence.getFenceBasesStored() >= requiredMaterials[0] && this.fence.getFenceGridsStored() >= requiredMaterials[1] && this.fence.getFencePolesStored() >= requiredMaterials[2]) {
				((GuiButton) this.buttonList.get(7)).enabled = true;
			} else {
				((GuiButton) this.buttonList.get(7)).enabled = false;
			}
		}
	}

	@Override
	public void actionPerformed(GuiButton button) {
		switch (button.id) {
			case 0:
				if (this.fence.getDirection() - 1 > -1) {
					this.fence.setDirection((byte) (this.fence.getDirection() - 1));
				} else {
					this.fence.setDirection((byte) (3));
				}
				this.refreshFixButton();
				break;
			case 1:
				if (this.fence.getDirection() + 1 < 4) {
					this.fence.setDirection((byte) (this.fence.getDirection() + 1));
				} else {
					this.fence.setDirection((byte) (0));
				}
				this.refreshFixButton();
				break;
			case 2:
				this.fenceMap = this.fence.getAllMainBlocks();
				this.refreshFixButton();
				break;
			case 3:
				JurassiCraft.network.sendToServer(new MessageFenceBuilding(this.fence.xCoord, this.fence.yCoord, this.fence.zCoord, this.fence.getSecurityLevel(this.fence.getDirection()), this.fence.getDirection(), this.fence.calculateDistanceToNextPole(this.fence.getDirection()), this.fence.getHeightPlanned(this.fence.getSecurityLevel(this.fence.getDirection()))));
				break;
			case 4:
				if (this.fence.canCraftBase()) {
					this.fence.tryToIncreaseFenceBases();
					JurassiCraft.network.sendToServer(new MessageFenceCrafting(0, this.fence.xCoord, this.fence.yCoord, this.fence.zCoord));
				}
				break;
			case 5:
				if (this.fence.canCraftGrid()) {
					this.fence.tryToIncreaseFenceGrids();
					JurassiCraft.network.sendToServer(new MessageFenceCrafting(1, this.fence.xCoord, this.fence.yCoord, this.fence.zCoord));
				}
				break;
			case 6:
				if (this.fence.canCraftPole()) {
					this.fence.tryToIncreaseFencePoles();
					JurassiCraft.network.sendToServer(new MessageFenceCrafting(2, this.fence.xCoord, this.fence.yCoord, this.fence.zCoord));
				}
				break;
			case 7:
				JurassiCraft.network.sendToServer(new MessageFenceFixing(this.fence.xCoord, this.fence.yCoord, this.fence.zCoord, this.fence.getSecurityLevel(this.fence.getDirection()) - 1, this.fence.getDirection(), this.fence.calculateDistanceToNextPole(this.fence.getDirection()), this.fence.getHeightPlanned(this.fence.getSecurityLevel(this.fence.getDirection())) - 1, this.requiredMaterials[0], this.requiredMaterials[1], this.requiredMaterials[2]));
				((GuiButton) this.buttonList.get(7)).visible = false;
				this.refreshFixButton();
				break;
		}
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 48, 163, 4210752);
		int distance = this.fence.calculateDistanceToNextPole(this.fence.getDirection());
		String text = "";
		if ((requiredMaterials[0] == 0 && requiredMaterials[1] == 0 && requiredMaterials[2] == 0) || !this.fence.isFenceBuilt(this.fence.getDirection())) {
			text = StatCollector.translateToLocal("container.fencebasesblocks") + ": " + this.fence.getFenceBasesStored() + "/" + ((distance - 1) > -1 ? (distance - 1) : 0);
			this.fontRendererObj.drawString(text, 178 - this.fontRendererObj.getStringWidth(text)/2, 79, 4210752);
			text = StatCollector.translateToLocal("container.fencegridsblocks") + ": " + this.fence.getFenceGridsStored() + "/" + ((this.fence.getHeightPlanned(this.fence.getSecurityLevel(this.fence.getDirection())) * (distance - 1)) > -1 ? (this.fence.getHeightPlanned(this.fence.getSecurityLevel(this.fence.getDirection())) * (distance - 1)) : 0);
			this.fontRendererObj.drawString(text, 178 - this.fontRendererObj.getStringWidth(text)/2, 96, 4210752);
			text = StatCollector.translateToLocal("container.fencepolesblocks") + ": " + this.fence.getFencePolesStored() + "/" + ((distance - 1) > -1 ? ((this.fence.getSecurityLevel(this.fence.getDirection()) == 0 || this.fence.getSecurityLevel(this.fence.getDirection()) == 2) ? 4 : 2) : 0);
			this.fontRendererObj.drawString(text, 178 - this.fontRendererObj.getStringWidth(text)/2, 113, 4210752);
		} else {
			text = StatCollector.translateToLocal("container.fencebasesblocks") + ": " + this.fence.getFenceBasesStored() + "/" + requiredMaterials[0];
			this.fontRendererObj.drawString(text, 178 - this.fontRendererObj.getStringWidth(text)/2, 79, 4210752);
			text = StatCollector.translateToLocal("container.fencegridsblocks") + ": " + this.fence.getFenceGridsStored() + "/" + requiredMaterials[1];
			this.fontRendererObj.drawString(text, 178 - this.fontRendererObj.getStringWidth(text)/2, 96, 4210752);
			text = StatCollector.translateToLocal("container.fencepolesblocks") + ": " + this.fence.getFencePolesStored() + "/" + requiredMaterials[2];
			this.fontRendererObj.drawString(text, 178 - this.fontRendererObj.getStringWidth(text)/2, 113, 4210752);
		}
		switch (this.fence.getSecurityLevel(this.fence.getDirection())) {
			case 0:
				text = StatCollector.translateToLocal("container.securityFenceInexistent");
				break;
			case 1:
				text = StatCollector.translateToLocal("container.securityFenceLow");
				break;
			case 2:
				text = StatCollector.translateToLocal("container.securityFenceMedium");
				break;
			case 3:
				text = StatCollector.translateToLocal("container.securityFenceHigh");
				break;
		}
		this.fontRendererObj.drawString(text, 116 - this.fontRendererObj.getStringWidth(text) / 2, 15, 4210752);
		switch (this.fence.getDirection()) {
			case 0:
				text = StatCollector.translateToLocal("container.directionSouth");
				break;
			case 1:
				text = StatCollector.translateToLocal("container.directionWest");
				break;
			case 2:
				text = StatCollector.translateToLocal("container.directionNorth");
				break;
			case 3:
				text = StatCollector.translateToLocal("container.directionEast");
				break;
			default:
				text = StatCollector.translateToLocal("container.directionInexistent");
				break;
		}
		this.fontRendererObj.drawString(text, 56 - this.fontRendererObj.getStringWidth(text) / 2, 146, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		this.mc.renderEngine.bindTexture(new ResourceLocation(Util.getModId() + "textures/gui/guiSecurityFenceMain.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		this.mc.renderEngine.bindTexture(new ResourceLocation(Util.getModId() + "textures/gui/guiSecurityFenceWidgets.png"));
		switch (this.fence.getDirection()) {
			case 0:
				this.drawTexturedModalRect(this.guiLeft + 54, this.guiTop + 83, 59, 0, 4, 37);
				break;
			case 1:
				this.drawTexturedModalRect(this.guiLeft + 21, this.guiTop + 83, 59, 0, 37, 4);
				break;
			case 2:
				this.drawTexturedModalRect(this.guiLeft + 54, this.guiTop + 50, 59, 0, 4, 37);
				break;
			case 3:
				this.drawTexturedModalRect(this.guiLeft + 54, this.guiTop + 83, 59, 0, 37, 4);
				break;
		}
		if (!this.fenceMap.isEmpty()) {
			for (int i = 0; i < this.fenceMap.size(); i++) {
				this.drawTexturedModalRect(this.guiLeft + 55 + 3 * this.fenceMap.get(i)[0], this.guiTop + 84 + 3 * this.fenceMap.get(i)[1], 57, 0, 2, 2);
			}
		}
	}
	
	private void refreshFixButton() {
		if (this.fence.isFenceBuilt(this.fence.getDirection())) {
			this.requiredMaterials = this.fence.getBlocksToRepair(this.fence.getSecurityLevel(this.fence.getDirection()), this.fence.getDirection(), this.fence.calculateDistanceToNextPole(this.fence.getDirection()));
			if (requiredMaterials[0] == 0 && requiredMaterials[1] == 0 && requiredMaterials[2] == 0) {
				((GuiButton) this.buttonList.get(7)).visible = false;
			} else {
				((GuiButton) this.buttonList.get(7)).visible = true;
			}
		} else {
			((GuiButton) this.buttonList.get(7)).visible = false;
		}
	}
}
