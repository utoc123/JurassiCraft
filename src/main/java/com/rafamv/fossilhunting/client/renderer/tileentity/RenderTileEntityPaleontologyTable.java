package com.rafamv.fossilhunting.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.client.renderer.model.ModelPaleontologyTable;
import com.rafamv.fossilhunting.tileentity.TileEntityPaleontologyTable;

import cpw.mods.fml.client.FMLClientHandler;

public class RenderTileEntityPaleontologyTable extends TileEntitySpecialRenderer {

	private ModelPaleontologyTable modelPaleontologyTable = new ModelPaleontologyTable();
	private static final ResourceLocation texture = new ResourceLocation(FossilHunting.MODID + ":" + "textures/models/PaleontologyTable.png");

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {

		if (tileEntity instanceof TileEntityPaleontologyTable) {
			TileEntityPaleontologyTable tileCleaningTable = (TileEntityPaleontologyTable) tileEntity;
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
			GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);
			modelPaleontologyTable.render();
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
		}
	}
}