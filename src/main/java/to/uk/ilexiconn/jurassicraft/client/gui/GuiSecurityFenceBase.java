package to.uk.ilexiconn.jurassicraft.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.container.ContainerSecurityFenceBase;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceBase;

public class GuiSecurityFenceBase extends GuiContainer
{

    private TileSecurityFenceBase fence;

    public GuiSecurityFenceBase(InventoryPlayer inventoryPlayer, TileSecurityFenceBase entity)
    {
        super(new ContainerSecurityFenceBase(inventoryPlayer, entity));
        this.fence = entity;
        this.xSize = 176;
        this.ySize = 188;
    }
    
	@Override
	public void initGui() 
	{
        super.initGui();
		this.buttonList.clear();
        this.buttonList.add(new GuiButtonFenceLevelIncrease(0, this.guiLeft + 145, this.guiTop + 21, 10, 15));
        this.buttonList.add(new GuiButtonFenceLevelDecrease(1, this.guiLeft + 73, this.guiTop + 21, 10, 15));
        this.buttonList.add(new GuiButtonFenceCompass(2, this.guiLeft + 14, this.guiTop + 57, 27, 27, this.fence.getDirection()));
        this.buttonList.add(new GuiButton(3, this.guiLeft + this.xSize/2 - 30, this.guiTop + 60, 100, 20, "Build Fence"));
	}
    
	@Override
    public void updateScreen() {
		if (this.fence.hasEnoughRedstone() && this.fence.hasRequiredStructure()) 
		{
			((GuiButton) this.buttonList.get(3)).enabled = true;
		} 
		else 
		{
			((GuiButton) this.buttonList.get(3)).enabled = false;
		}
		
		if (this.fence.getSecurityLevel() >= 3)
		{
			((GuiButtonFenceLevelIncrease) this.buttonList.get(0)).enabled = false;
		} 
		else if (this.fence.getSecurityLevel() <= 1) 
		{
			((GuiButtonFenceLevelDecrease) this.buttonList.get(1)).enabled = false;
		}
		else {
			if (!((GuiButtonFenceLevelIncrease) this.buttonList.get(0)).enabled)
			{
				((GuiButtonFenceLevelIncrease) this.buttonList.get(0)).enabled = true;
			}
			if (!((GuiButtonFenceLevelDecrease) this.buttonList.get(1)).enabled)
			{
				((GuiButtonFenceLevelDecrease) this.buttonList.get(1)).enabled = true;
			}
		}
	}

    @Override
    public void actionPerformed(GuiButton button)
    {
		switch (button.id) 
		{
			case 0:
				if (this.fence.getSecurityLevel() < 3)
					this.fence.setSecurityLevel(this.fence.getSecurityLevel() + 1);
				break;
			case 1:
				if (this.fence.getSecurityLevel() > 1)
					this.fence.setSecurityLevel(this.fence.getSecurityLevel() - 1);
				break;
			case 2:
				switch (this.fence.getDirection()) 
				{
					case 0:
						this.fence.setDirection(1);
						((GuiButtonFenceCompass) this.buttonList.get(2)).setDirection(1);
						break;
					case 1: 
						this.fence.setDirection(0);
						((GuiButtonFenceCompass) this.buttonList.get(2)).setDirection(0);
						break;
					default:
						return;
				}
				break;
			case 3:
				this.fence.tryToBuildFence();
				break;
			default:
				return;
		}
	}

    @Override
    public void onGuiClosed()
    {
        super.onGuiClosed();
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.securityFence"), this.xSize - this.fontRendererObj.getStringWidth("container.securityFence"), 7, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 94, 4210752);
        switch (this.fence.getSecurityLevel()) {
        	case 1:
                this.fontRendererObj.drawString(StatCollector.translateToLocal("container.securityFenceLow"), 114 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.securityFenceLow"))/2, 25, 4210752);
        		break;
        	case 2:
                this.fontRendererObj.drawString(StatCollector.translateToLocal("container.securityFenceMedium"), 114 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.securityFenceMedium"))/2, 25, 4210752);
        		break;
        	case 3:
                this.fontRendererObj.drawString(StatCollector.translateToLocal("container.securityFenceHigh"), 114 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.securityFenceHigh"))/2, 25, 4210752);
        		break;
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        this.mc.renderEngine.bindTexture(new ResourceLocation(Util.getModId() + "textures/gui/guiSecurityFence.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        this.drawTexturedModalRect(guiLeft + 84, guiTop + 40, 0, 188, this.fence.getRedstoneStoredProgressScaled(60), 4);
    }
}
