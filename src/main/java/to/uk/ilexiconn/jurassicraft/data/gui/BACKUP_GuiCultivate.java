package to.uk.ilexiconn.jurassicraft.data.gui;

import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.data.gui.container.ContainerCultivate;
import to.uk.ilexiconn.jurassicraft.data.tile.TileCultivate;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class BACKUP_GuiCultivate extends GuiContainer
{
	TileCultivate tileCultivate;

    public BACKUP_GuiCultivate(InventoryPlayer inventory, TileCultivate tileEntity)
    {
        super(new ContainerCultivate(inventory, tileEntity));
		tileCultivate = tileEntity;
    }

    public void drawGuiContainerForegroundLayer(int i, int d)
    {
        fontRendererObj.drawString(StatCollector.translateToLocal("Cultivate"), 8, 8, 0x4bc2fc);
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 95, 0x4bc2fc);
    }

    public void drawGuiContainerBackgroundLayer(float i, int d, int k)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(new ResourceLocation(Util.getModId() + "textures/gui/guiCultivate.png"));
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
		//int var7 = this.tileCultivate.getCookProgressScaled(18);
		//this.drawTexturedModalRect(var5 + 79, var6 + 41, 177, 18, var7 + 1, 10);
    }
}
