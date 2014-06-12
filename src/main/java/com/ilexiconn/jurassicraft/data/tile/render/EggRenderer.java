package com.ilexiconn.jurassicraft.data.tile.render;

import com.ilexiconn.jurassicraft.data.block.model.ModelEgg;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class EggRenderer extends TileEntitySpecialRenderer
{
    public ModelEgg model = new ModelEgg();
    public ResourceLocation texture = new ResourceLocation("");

    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float h)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5f, (float) y + 1.5f, (float) z + 0.5f);
        bindTexture(texture);
        GL11.glRotatef(180f, 0f, 0f, 1f);
        model.render();
        GL11.glPopMatrix();
    }
}
