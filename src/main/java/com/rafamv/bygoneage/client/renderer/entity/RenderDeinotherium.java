package com.rafamv.bygoneage.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.rafamv.bygoneage.client.renderer.model.ModelDeinotherium;
import com.rafamv.bygoneage.entity.creatures.EntityDeinotherium;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;

public class RenderDeinotherium extends RenderLiving {

	protected ModelDeinotherium model;
	private static final ResourceLocation texture = new ResourceLocation(BygoneAgeMobsInformation.DEINOTHERIUM.getTexture() + ".png");
	private static final ResourceLocation textureOverlayer = new ResourceLocation(BygoneAgeMobsInformation.DEINOTHERIUM.getTexture() + "Overlayer.png");

	public RenderDeinotherium(ModelBase model, float shadow) {
		super(model, shadow);
		this.model = ((ModelDeinotherium) mainModel);
		this.setRenderPassModel(mainModel);
	}

	public void renderModel(EntityDeinotherium entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}

	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderModel((EntityDeinotherium) entityLiving, x, y, z, u, v);
	}

	protected void preRenderScale(EntityDeinotherium entityModel, float f) {
		float scale = 0.8F * (float) entityModel.getCreatureScale();
		this.shadowSize = 2.5F * scale;
		GL11.glScalef(scale, scale, scale);
	}

	protected int shouldRenderPass(EntityDeinotherium entityCreature, int par2, float par3) {
		if (par2 == 0) {
			this.bindTexture(textureOverlayer);
			float color = entityCreature.getCreatureColor();
			if (color <= 0.485F) {
				GL11.glColor3f(color, color, color);
			} else if (color <= 1.0F) {
				GL11.glColor3f(color / 3.0F, color / 3.0F, color / 3.0F);
			}
			return 1;
		} else {
			return -1;
		}
	}

	protected ResourceLocation getEntityTexture(EntityDeinotherium entityCreature) {
		return this.texture;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderModel((EntityDeinotherium) entity, x, y, z, u, v);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
		this.preRenderScale((EntityDeinotherium) entityLivingBase, f);
	}

	@Override
	protected int shouldRenderPass(EntityLivingBase entityLivingBase, int par2, float par3) {
		return this.shouldRenderPass((EntityDeinotherium) entityLivingBase, par2, par3);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityDeinotherium) entity);
	}
}
