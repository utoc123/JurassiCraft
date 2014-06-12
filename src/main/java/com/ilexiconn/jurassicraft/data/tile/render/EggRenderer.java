package com.ilexiconn.jurassicraft.data.tile.render;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.block.model.ModelEgg;
import com.ilexiconn.jurassicraft.data.tile.TileEgg;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class EggRenderer extends TileEntitySpecialRenderer
{
    public ModelEgg model = new ModelEgg();
    public ResourceLocation texture;

    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float h)
    {
        TileEgg egg = (TileEgg) tileEntity;
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5f, (float) y + 1.8f, (float) z + 0.5f);
        GL11.glScalef(1.2f, 1.2f, 1.2f);
        String[] dino = egg.getDino().split("Entity");
        texture = new ResourceLocation(Util.getModId() + "textures/eggs/egg" + dino[1] + ".png");
        bindTexture(texture);
        GL11.glRotatef(180f, 0f, 0f, 1f);
        model.render();
        GL11.glPopMatrix();
    }
}
