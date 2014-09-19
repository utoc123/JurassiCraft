package com.rafamv.bygoneage.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.rafamv.bygoneage.client.renderer.model.ModelMoeritherium;
import com.rafamv.bygoneage.entity.creatures.EntityMoeritherium;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;

public class RenderMoeritherium extends RenderLiving {

	protected ModelMoeritherium model;
	private static final ResourceLocation texture = new ResourceLocation(BygoneAgeMobsInformation.MOERITHERIUM.getTexture() + ".png");
	private static final ResourceLocation textureOverlayer = new ResourceLocation(BygoneAgeMobsInformation.MOERITHERIUM.getTexture() + "Overlayer.png");

	public RenderMoeritherium(ModelBase model, float shadow) {
		super(model, shadow);
		this.model = ((ModelMoeritherium) mainModel);
		this.setRenderPassModel(mainModel);
	}

	public void renderModel(EntityMoeritherium entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}

	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderModel((EntityMoeritherium) entityLiving, x, y, z, u, v);
	}

	protected void preRenderScale(EntityMoeritherium entityModel, float f) {
		float scale = (float) entityModel.getCreatureScale();
		this.shadowSize = 0.4F * scale;
		GL11.glScalef(scale, scale, scale);
	}

	protected int shouldRenderPass(EntityMoeritherium entityCreature, int par2, float par3) {
		if (par2 == 0) {
			this.bindTexture(textureOverlayer);
			float color = entityCreature.getCreatureColor();
			if (color <= 0.485F) {
				GL11.glColor3f(0.3F + 0.7F * color, 0.3F + 0.7F * color, 0.3F + 0.7F * color);
			} else if (color <= 1.0F) {
				GL11.glColor3f(color / 2.5F, color / 2.5F, color / 2.5F);
			}
			return 1;
		} else {
			return -1;
		}
	}

	protected ResourceLocation getEntityTexture(EntityMoeritherium entityCreature) {
		return this.texture;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderModel((EntityMoeritherium) entity, x, y, z, u, v);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
		this.preRenderScale((EntityMoeritherium) entityLivingBase, f);
	}

	@Override
	protected int shouldRenderPass(EntityLivingBase entityLivingBase, int par2, float par3) {
		return this.shouldRenderPass((EntityMoeritherium) entityLivingBase, par2, par3);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityMoeritherium) entity);
	}
}
