package com.rafamv.bygoneage.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPropalaeotherium extends ModelBase {
	ModelRenderer Neck;
	ModelRenderer BearHead;
	ModelRenderer Body;
	ModelRenderer MainBody;
	ModelRenderer Leg1;
	ModelRenderer Leg2;
	ModelRenderer Leg3;
	ModelRenderer Leg4;
	ModelRenderer Tail;
	ModelRenderer Ear1;
	ModelRenderer Ear2;
	ModelRenderer Nose;

	public ModelPropalaeotherium() {
		textureWidth = 128;
		textureHeight = 64;

		Neck = new ModelRenderer(this, 0, 29);
		Neck.addBox(0F, 0F, 0F, 4, 5, 8);
		Neck.setRotationPoint(-3F, 12F, -10F);
		Neck.setTextureSize(128, 64);
		Neck.mirror = true;
		setRotation(Neck, 0.3839724F, 0F, 0F);
		BearHead = new ModelRenderer(this, 0, 0);
		BearHead.addBox(-3F, -3F, -2F, 6, 6, 4);
		BearHead.setRotationPoint(-1F, 13.5F, -10F);
		BearHead.setTextureSize(128, 64);
		BearHead.mirror = true;
		setRotation(BearHead, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 24, 18);
		Body.addBox(-4F, -2F, -3F, 6, 7, 7);
		Body.setRotationPoint(0F, 14F, 4F);
		Body.setTextureSize(128, 64);
		Body.mirror = true;
		setRotation(Body, 1.308997F, 0F, 0F);
		MainBody = new ModelRenderer(this, 24, 0);
		MainBody.addBox(-4F, -3F, -3F, 8, 10, 8);
		MainBody.setRotationPoint(-1F, 14F, -3F);
		MainBody.setTextureSize(128, 64);
		MainBody.mirror = true;
		setRotation(MainBody, 1.570796F, 0F, 0F);
		Leg1 = new ModelRenderer(this, 0, 18);
		Leg1.addBox(-1F, 0F, -1F, 2, 8, 3);
		Leg1.setRotationPoint(-2.966667F, 16F, 6F);
		Leg1.setTextureSize(128, 64);
		Leg1.mirror = true;
		setRotation(Leg1, 0F, 0F, 0F);
		Leg2 = new ModelRenderer(this, 0, 18);
		Leg2.addBox(-0.4666667F, 0F, -1F, 2, 8, 3);
		Leg2.setRotationPoint(0.5F, 16F, 6F);
		Leg2.setTextureSize(128, 64);
		Leg2.mirror = true;
		setRotation(Leg2, 0F, 0F, 0F);
		Leg3 = new ModelRenderer(this, 0, 18);
		Leg3.addBox(-1F, 0F, -1F, 2, 8, 3);
		Leg3.setRotationPoint(-3.5F, 16F, -4F);
		Leg3.setTextureSize(128, 64);
		Leg3.mirror = true;
		setRotation(Leg3, 0F, 0F, 0F);
		Leg4 = new ModelRenderer(this, 0, 18);
		Leg4.addBox(-1F, 0F, -1F, 2, 8, 3);
		Leg4.setRotationPoint(1.5F, 16F, -4F);
		Leg4.setTextureSize(128, 64);
		Leg4.mirror = true;
		setRotation(Leg4, 0F, 0F, 0F);
		Tail = new ModelRenderer(this, 10, 18);
		Tail.addBox(-1F, 0F, -1F, 2, 2, 2);
		Tail.setRotationPoint(-1F, 13F, 9F);
		Tail.setTextureSize(128, 64);
		Tail.mirror = true;
		setRotation(Tail, 1.130069F, 0F, 0F);
		Ear1 = new ModelRenderer(this, 16, 14);
		Ear1.addBox(-3F, -5F, 0F, 2, 2, 1);
		Ear1.setRotationPoint(-1F, 13.5F, -10F);
		Ear1.setTextureSize(128, 64);
		Ear1.mirror = true;
		setRotation(Ear1, 0F, 0F, 0F);
		Ear2 = new ModelRenderer(this, 16, 14);
		Ear2.addBox(1F, -5F, 0F, 2, 2, 1);
		Ear2.setRotationPoint(-1F, 13.5F, -10F);
		Ear2.setTextureSize(128, 64);
		Ear2.mirror = true;
		setRotation(Ear2, 0F, 0F, 0F);
		Nose = new ModelRenderer(this, 0, 10);
		Nose.addBox(-1.5F, 0F, -4F, 3, 3, 4);
		Nose.setRotationPoint(-1.0F, 13.5F, -10F);
		Nose.setTextureSize(128, 64);
		Nose.mirror = true;
		setRotation(Nose, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Ear1.render(f5);
		Ear2.render(f5);
		Nose.render(f5);
		BearHead.render(f5);
		Body.render(f5);
		MainBody.render(f5);
		Leg1.render(f5);
		Leg2.render(f5);
		Leg3.render(f5);
		Leg4.render(f5);
		Neck.render(f5);
		Tail.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		BearHead.rotateAngleX = f4 / (180F / (float) Math.PI);
		BearHead.rotateAngleY = f3 / (180F / (float) Math.PI);

		Ear1.rotateAngleX = f4 / (180F / (float) Math.PI);
		Ear1.rotateAngleY = f3 / (180F / (float) Math.PI);

		Ear2.rotateAngleX = f4 / (180F / (float) Math.PI);
		Ear2.rotateAngleY = f3 / (180F / (float) Math.PI);

		Nose.rotateAngleX = f4 / (180F / (float) Math.PI);
		Nose.rotateAngleY = f3 / (180F / (float) Math.PI);

		Leg1.rotateAngleX = (float) (Math.cos(f * 0.6662F) * 1.4F * f1);
		Leg2.rotateAngleX = (float) (Math.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1);
		Leg3.rotateAngleX = (float) (Math.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1);
		Leg4.rotateAngleX = (float) (Math.cos(f * 0.6662F) * 1.4F * f1);
	}
}