package com.ilexiconn.jurassicraft.data.gui;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.gui.container.ContainerCultivate;
import com.ilexiconn.jurassicraft.data.tile.TileCultivate;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiCultivate extends GuiContainer
{
    public GuiCultivate(InventoryPlayer inventory, TileCultivate tileEntity)
    {
        super(new ContainerCultivate(inventory, tileEntity));
    }

    public void drawGuiContainerForegroundLayer(int i, int d)
    {
        fontRendererObj.drawString(StatCollector.translateToLocal("container.cultivate"), 8, 6, 4210752);
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96, 4210752);
    }

    public void drawGuiContainerBackgroundLayer(float i, int d, int k)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(new ResourceLocation(Util.getModId() + "textures/gui/guiCultivate.png"));
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
    }
}
