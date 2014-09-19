package com.rafamv.fossilhunting.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.client.renderer.model.ModelCleaningTable;
import com.rafamv.fossilhunting.tileentity.TileEntityCleaningTable;

import cpw.mods.fml.client.FMLClientHandler;

public class RenderTileEntityCleaningTable extends TileEntitySpecialRenderer {

	private ModelCleaningTable modelCleaningTable = new ModelCleaningTable();
	private static final ResourceLocation texture = new ResourceLocation(FossilHunting.MODID + ":" + "textures/models/CleaningTable.png");

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {

		if (tileEntity instanceof TileEntityCleaningTable) {
			TileEntityCleaningTable tileCleaningTable = (TileEntityCleaningTable) tileEntity;

			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
			GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);

			FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);

			modelCleaningTable.render();

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
		}
	}
}