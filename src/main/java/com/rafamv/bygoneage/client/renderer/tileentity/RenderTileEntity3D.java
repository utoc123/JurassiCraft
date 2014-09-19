package com.rafamv.bygoneage.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.client.renderer.model.ModelCentrifuge;
import com.rafamv.bygoneage.tileentity.TileEntityHatchery;

import cpw.mods.fml.client.FMLClientHandler;

public class RenderTileEntity3D extends TileEntitySpecialRenderer {

	private ModelCentrifuge modelBarrel = new ModelCentrifuge();
	private static final ResourceLocation texture = new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/Barrel.png");

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {

		if (tileEntity instanceof TileEntityHatchery) {
			TileEntityHatchery tileBarrel = (TileEntityHatchery) tileEntity;

			GL11.glPushMatrix();
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) x, (float) y, (float) z + 1.0F);
			GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);
			// modelBarrel.render();
			GL11.glPopMatrix();

		}
	}
}