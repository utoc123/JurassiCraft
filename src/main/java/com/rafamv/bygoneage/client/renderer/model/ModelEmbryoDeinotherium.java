package com.rafamv.bygoneage.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEmbryoDeinotherium extends ModelBase {

	ModelRenderer head;
	ModelRenderer body1;
	ModelRenderer body2;
	ModelRenderer hand1;
	ModelRenderer hand2;
	ModelRenderer leg1;
	ModelRenderer leg2;

	public ModelEmbryoDeinotherium() {
		textureWidth = 32;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-2F, -4F, -6F, 4, 4, 6);
		head.setRotationPoint(0F, 13.5F, 1F);
		head.setTextureSize(32, 32);
		head.mirror = true;
		setRotation(head, 0.3222146F, 0F, 0F);
		body1 = new ModelRenderer(this, 0, 12);
		body1.addBox(-2F, -2F, 0F, 4, 4, 4);
		body1.setRotationPoint(0F, 12.5F, -2F);
		body1.setTextureSize(32, 32);
		body1.mirror = true;
		setRotation(body1, -0.7853982F, 0F, 0F);
		body2 = new ModelRenderer(this, 0, 22);
		body2.addBox(-2F, 0F, -2F, 4, 6, 4);
		body2.setRotationPoint(0F, 13.8F, 0.2F);
		body2.setTextureSize(32, 32);
		body2.mirror = true;
		setRotation(body2, 0F, 0F, 0F);
		hand1 = new ModelRenderer(this, 10, 45);
		hand1.addBox(1.3F, -1.5F, 0.5F, 2, 4, 2);
		hand1.setRotationPoint(0F, 14.5F, -1F);
		hand1.setTextureSize(32, 32);
		hand1.mirror = true;
		setRotation(hand1, -1.134464F, 0.3490659F, 0F);
		hand2 = new ModelRenderer(this, 0, 45);
		hand2.addBox(-3.2F, -1.5F, 0.5F, 2, 4, 2);
		hand2.setRotationPoint(0F, 14.5F, -1F);
		hand2.setTextureSize(32, 32);
		hand2.mirror = true;
		setRotation(hand2, -1.134464F, -0.3490659F, 0F);
		leg1 = new ModelRenderer(this, 0, 55);
		leg1.addBox(-2.5F, 0F, -1F, 2, 4, 2);
		leg1.setRotationPoint(0F, 20F, 0.5F);
		leg1.setTextureSize(32, 32);
		leg1.mirror = true;
		setRotation(leg1, -1.745329F, 0F, 0F);
		leg2 = new ModelRenderer(this, 10, 55);
		leg2.addBox(0.5F, 0F, -1F, 2, 4, 2);
		leg2.setRotationPoint(0F, 20F, 0.5F);
		leg2.setTextureSize(32, 32);
		leg2.mirror = true;
		setRotation(leg2, -1.745329F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body1.render(f5);
		body2.render(f5);
		hand1.render(f5);
		hand2.render(f5);
		leg1.render(f5);
		leg2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}
