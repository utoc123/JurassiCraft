package to.uk.ilexiconn.jurassicraft.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.container.ContainerDNAExtractor;
import to.uk.ilexiconn.jurassicraft.tile.TileDNAExtractor;

public class GuiDNAExtractor extends GuiContainer
{

    private TileDNAExtractor dnaExtractor;

    public GuiDNAExtractor(InventoryPlayer inventoryPlayer, TileEntity tileEntity)
    {
        super(new ContainerDNAExtractor(inventoryPlayer, tileEntity));
        if (tileEntity instanceof TileDNAExtractor)
        {
            TileDNAExtractor tileEntityDNAExtractor = (TileDNAExtractor) tileEntity;
            this.dnaExtractor = tileEntityDNAExtractor;
            this.xSize = 176;
            this.ySize = 188;
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
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.dnaExtractor"), this.xSize - this.fontRendererObj.getStringWidth("container.dnaExtractor"), 7, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 94, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        mc.renderEngine.bindTexture(new ResourceLocation(Util.getModId() + "textures/gui/guiDNAExtractor.png"));
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        int i = this.dnaExtractor.getExtractionProgressScaled(22);
        this.drawTexturedModalRect(guiLeft + 77, guiTop + 38, 176, 0, i, 17);
    }
}
