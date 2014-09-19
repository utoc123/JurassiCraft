package com.rafamv.bygoneage.client.renderer.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import com.rafamv.bygoneage.client.renderer.model.ModelDNAExtractorBase;
import com.rafamv.bygoneage.client.renderer.model.ModelDNAExtractorGlass;
import com.rafamv.bygoneage.enums.BygoneAgeBlockInformation;
import com.rafamv.bygoneage.tileentity.TileEntityDNAExtractor;

public class RenderTileEntityDNAExtractor extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(BygoneAgeBlockInformation.DNAEXTRACTOR.getModelTexture());
	private ModelDNAExtractorBase modelBase;
	private ModelDNAExtractorGlass modelGlass;

	public RenderTileEntityDNAExtractor() {
		this.modelBase = new ModelDNAExtractorBase();
		this.modelGlass = new ModelDNAExtractorGlass();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
		if (tileEntity instanceof TileEntityDNAExtractor) {
			TileEntityDNAExtractor tileEntityModel = (TileEntityDNAExtractor) tileEntity;
			ForgeDirection direction = null;
			short angle = 180;
			if (tileEntityModel.getWorldObj() != null) {
				direction = tileEntityModel.getForgeDirection();
				if (direction != null) {
					if (direction == ForgeDirection.NORTH) {
						angle = 180;
					} else if (direction == ForgeDirection.SOUTH) {
						angle = 0;
					} else if (direction == ForgeDirection.WEST) {
						angle = 90;
					} else if (direction == ForgeDirection.EAST) {
						angle = -90;
					}
				}
			}
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(angle, 0.0F, 1.0F, 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			this.modelBase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.55F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			this.modelGlass.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}
	}
}