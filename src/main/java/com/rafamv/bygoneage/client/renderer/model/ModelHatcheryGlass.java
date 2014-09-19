package com.rafamv.bygoneage.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHatcheryGlass extends ModelBase {
	ModelRenderer glass1;
	ModelRenderer glass2;
	ModelRenderer glass3;
	ModelRenderer glass4;

	public ModelHatcheryGlass() {
		textureWidth = 128;
		textureHeight = 128;

		glass1 = new ModelRenderer(this, 0, 25);
		glass1.addBox(-11F, -43F, -12F, 22, 36, 1);
		glass1.setRotationPoint(0F, 24F, 0F);
		glass1.setTextureSize(64, 32);
		glass1.mirror = true;
		setRotation(glass1, 0F, 0F, 0F);
		glass2 = new ModelRenderer(this, 0, 25);
		glass2.addBox(-11F, -43F, -12F, 22, 36, 1);
		glass2.setRotationPoint(0F, 24F, 0F);
		glass2.setTextureSize(64, 32);
		glass2.mirror = true;
		setRotation(glass2, 0F, -1.570796F, 0F);
		glass3 = new ModelRenderer(this, 0, 25);
		glass3.addBox(-11F, -43F, 11F, 22, 36, 1);
		glass3.setRotationPoint(0F, 24F, 0F);
		glass3.setTextureSize(64, 32);
		glass3.mirror = true;
		setRotation(glass3, 0F, 0F, 0F);
		glass4 = new ModelRenderer(this, 0, 25);
		glass4.addBox(-11F, -43F, -12F, 22, 36, 1);
		glass4.setRotationPoint(0F, 24F, 0F);
		glass4.setTextureSize(64, 32);
		glass4.mirror = true;
		setRotation(glass4, 0F, 1.570796F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		glass1.render(f5);
		glass2.render(f5);
		glass3.render(f5);
		glass4.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
