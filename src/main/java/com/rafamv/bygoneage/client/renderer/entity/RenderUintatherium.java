package com.rafamv.bygoneage.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.rafamv.bygoneage.client.renderer.model.ModelUintatherium;
import com.rafamv.bygoneage.entity.creatures.EntityUintatherium;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;

public class RenderUintatherium extends RenderLiving {

	protected ModelUintatherium model;
	private static final ResourceLocation texture = new ResourceLocation(BygoneAgeMobsInformation.UINTATHERIUM.getTexture() + ".png");
	private static final ResourceLocation textureOverlayer = new ResourceLocation(BygoneAgeMobsInformation.UINTATHERIUM.getTexture() + "Overlayer.png");

	public RenderUintatherium(ModelBase model, float shadow) {
		super(model, shadow);
		this.model = ((ModelUintatherium) mainModel);
		this.setRenderPassModel(mainModel);
	}

	public void renderModel(EntityUintatherium entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}

	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderModel((EntityUintatherium) entityLiving, x, y, z, u, v);
	}

	protected void preRenderScale(EntityUintatherium entityModel, float f) {
		float scale = (float) entityModel.getCreatureScale();
		this.shadowSize = 0.85F * scale;
		GL11.glScalef(scale, scale, scale);
	}

	protected int shouldRenderPass(EntityUintatherium entityCreature, int par2, float par3) {
		if (par2 == 0) {
			this.bindTexture(textureOverlayer);
			float color = entityCreature.getCreatureColor();
			if (color <= 0.485F) {
				GL11.glColor3f(0.25F + 0.2F * color, 0.25F + 0.20F * color, 0.25F + 0.2F * color);
			} else if (color <= 1.0F) {
				GL11.glColor3f(color / 3.5F, color / 3.5F, color / 3.5F);
			}
			return 1;
		} else {
			return -1;
		}
	}

	protected ResourceLocation getEntityTexture(EntityUintatherium entityCreature) {
		return this.texture;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderModel((EntityUintatherium) entity, x, y, z, u, v);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
		this.preRenderScale((EntityUintatherium) entityLivingBase, f);
	}

	@Override
	protected int shouldRenderPass(EntityLivingBase entityLivingBase, int par2, float par3) {
		return this.shouldRenderPass((EntityUintatherium) entityLivingBase, par2, par3);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityUintatherium) entity);
	}
}
