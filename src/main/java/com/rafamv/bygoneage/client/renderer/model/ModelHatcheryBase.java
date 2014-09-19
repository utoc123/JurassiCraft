package com.rafamv.bygoneage.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHatcheryBase extends ModelBase {
	ModelRenderer bottom1;
	ModelRenderer bottom2;
	ModelRenderer bottom3;
	ModelRenderer bottom4;
	ModelRenderer bottom5;
	ModelRenderer bottom6;
	ModelRenderer top1;
	ModelRenderer top2;
	ModelRenderer top3;
	ModelRenderer middle1;
	ModelRenderer middle2;
	ModelRenderer middle3;
	ModelRenderer middle4;

	public ModelHatcheryBase() {
		textureWidth = 128;
		textureHeight = 128;

		bottom1 = new ModelRenderer(this, 0, 0);
		bottom1.addBox(-12F, -7F, -12F, 24, 1, 24);
		bottom1.setRotationPoint(0F, 24F, 0F);
		bottom1.setTextureSize(64, 32);
		bottom1.mirror = true;
		setRotation(bottom1, 0F, 0F, 0F);
		bottom2 = new ModelRenderer(this, 0, 62);
		bottom2.addBox(-13F, -6F, -13F, 26, 6, 26);
		bottom2.setRotationPoint(0F, 24F, 0F);
		bottom2.setTextureSize(64, 32);
		bottom2.mirror = true;
		setRotation(bottom2, 0F, 0F, 0F);
		bottom3 = new ModelRenderer(this, 46, 94);
		bottom3.addBox(-10F, -6F, -16F, 20, 6, 3);
		bottom3.setRotationPoint(0F, 24F, 0F);
		bottom3.setTextureSize(64, 32);
		bottom3.mirror = true;
		setRotation(bottom3, 0F, 0F, 0F);
		bottom4 = new ModelRenderer(this, 0, 94);
		bottom4.addBox(13F, -6F, -10F, 3, 6, 20);
		bottom4.setRotationPoint(0F, 24F, 0F);
		bottom4.setTextureSize(64, 32);
		bottom4.mirror = true;
		setRotation(bottom4, 0F, 0F, 0F);
		bottom5 = new ModelRenderer(this, 46, 94);
		bottom5.addBox(-10F, -6F, 13F, 20, 6, 3);
		bottom5.setRotationPoint(0F, 24F, 0F);
		bottom5.setTextureSize(64, 32);
		bottom5.mirror = true;
		setRotation(bottom5, 0F, 0F, 0F);
		bottom6 = new ModelRenderer(this, 0, 94);
		bottom6.addBox(-16F, -6F, -10F, 3, 6, 20);
		bottom6.setRotationPoint(0F, 24F, 0F);
		bottom6.setTextureSize(64, 32);
		bottom6.mirror = true;
		setRotation(bottom6, 0F, 0F, 0F);
		top1 = new ModelRenderer(this, 0, 0);
		top1.addBox(-12F, -44F, -12F, 24, 1, 24);
		top1.setRotationPoint(0F, 24F, 0F);
		top1.setTextureSize(64, 32);
		top1.mirror = true;
		setRotation(top1, 0F, 0F, 0F);
		top2 = new ModelRenderer(this, 46, 103);
		top2.addBox(-10F, -46F, -10F, 20, 2, 20);
		top2.setRotationPoint(0F, 24F, 0F);
		top2.setTextureSize(64, 32);
		top2.mirror = true;
		setRotation(top2, 0F, 0F, 0F);
		top3 = new ModelRenderer(this, 54, 107);
		top3.addBox(-8F, -47F, -8F, 16, 1, 16);
		top3.setRotationPoint(0F, 24F, 0F);
		top3.setTextureSize(64, 32);
		top3.mirror = true;
		setRotation(top3, 0F, 0F, 0F);
		middle1 = new ModelRenderer(this, 96, 0);
		middle1.addBox(11F, -43F, -12F, 1, 36, 1);
		middle1.setRotationPoint(0F, 24F, 0F);
		middle1.setTextureSize(64, 32);
		middle1.mirror = true;
		setRotation(middle1, 0F, 0F, 0F);
		middle2 = new ModelRenderer(this, 96, 0);
		middle2.addBox(11F, -43F, 11F, 1, 36, 1);
		middle2.setRotationPoint(0F, 24F, 0F);
		middle2.setTextureSize(64, 32);
		middle2.mirror = true;
		setRotation(middle2, 0F, 0F, 0F);
		middle3 = new ModelRenderer(this, 96, 0);
		middle3.addBox(-12F, -43F, 11F, 1, 36, 1);
		middle3.setRotationPoint(0F, 24F, 0F);
		middle3.setTextureSize(64, 32);
		middle3.mirror = true;
		setRotation(middle3, 0F, 0F, 0F);
		middle4 = new ModelRenderer(this, 96, 0);
		middle4.addBox(-12F, -43F, -12F, 1, 36, 1);
		middle4.setRotationPoint(0F, 24F, 0F);
		middle4.setTextureSize(64, 32);
		middle4.mirror = true;
		setRotation(middle4, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		bottom1.render(f5);
		bottom2.render(f5);
		bottom3.render(f5);
		bottom4.render(f5);
		bottom5.render(f5);
		bottom6.render(f5);
		top1.render(f5);
		top2.render(f5);
		top3.render(f5);
		middle1.render(f5);
		middle2.render(f5);
		middle3.render(f5);
		middle4.render(f5);
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
