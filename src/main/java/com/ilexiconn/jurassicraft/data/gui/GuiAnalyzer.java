package com.ilexiconn.jurassicraft.data.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.gui.container.ContainerAnalyzer;
import com.ilexiconn.jurassicraft.data.tile.TileAnalyzer;

public class GuiAnalyzer extends GuiContainer
{
    public TileAnalyzer tileEntityAnalyzer;
    
    public GuiAnalyzer(InventoryPlayer inventory, TileAnalyzer tileEntity)
    {
        super(new ContainerAnalyzer(inventory, tileEntity));
        tileEntityAnalyzer = tileEntity;
    }
    
    public void drawGuiContainerForegroundLayer(int i, int d)
    {
        fontRendererObj.drawString(StatCollector.translateToLocal("Analyzer"), 8, 6, 4210752);
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96, 4210752);
    }
    
    public void drawGuiContainerBackgroundLayer(float i, int d, int k)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(new ResourceLocation(Util.getModId() + "textures/gui/guiAnalyzer.png"));
        int var5 = (width - xSize) / 2;
        int var6 = (height - ySize) / 2;
        drawTexturedModalRect(var5, var6, 0, 0, xSize, ySize);
        int var7 = tileEntityAnalyzer.getCookPrograssScaled(21);
        drawTexturedModalRect(var5 + 80, var6 + 22, 177, 18, var7 + 1, 9);
    }
}
