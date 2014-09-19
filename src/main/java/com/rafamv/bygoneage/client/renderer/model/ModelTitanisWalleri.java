package com.rafamv.bygoneage.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import thehippomaster.AnimationAPI.client.Animator;

import com.rafamv.bygoneage.client.renderer.ResettableModelRenderer;
import com.rafamv.bygoneage.entity.creatures.EntityTitanisWalleri;
import com.rafamv.bygoneage.enums.BygoneAgeAnimationIDs;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;

public class ModelTitanisWalleri extends ModelBase {

	private Animator animator;
	public static final float PI = (float) Math.PI;
	ResettableModelRenderer tail1, tail2, body1, body2, body3, body4, neck1, neck2, head, beakupper, beakbottom, leftwing1, leftwing2, rightwing1, rightwing2, leftleg1, leftleg2, leftleg3, leftfoot, lefttoeleft, lefttoemiddle, lefttoeright, rightleg1, rightleg2, rightleg3, rightfoot, righttoeleft,
			righttoemiddle, righttoeright;

	public ModelTitanisWalleri() {
		animator = new Animator(this);
		textureWidth = 128;
		textureHeight = 64;

		tail1 = new ResettableModelRenderer(this, 100, 10);
		tail1.addBox(-4F, -1F, 0F, 8, 12, 0);
		tail1.setRotationPoint(0F, 1F, 6F);
		tail1.setTextureSize(128, 64);
		tail1.mirror = true;
		setRotation(tail1, 0.7853982F, 0F, 0F);
		tail2 = new ResettableModelRenderer(this, 100, 25);
		tail2.addBox(-4F, -1F, 0F, 8, 12, 0);
		tail2.setRotationPoint(0F, 0F, 6F);
		tail2.setTextureSize(128, 64);
		tail2.mirror = true;
		setRotation(tail2, 0.5235988F, 0F, 0F);
		body1 = new ResettableModelRenderer(this, 0, 20);
		body1.addBox(-3.5F, -2F, -3F, 7, 5, 6);
		body1.setRotationPoint(0F, 0F, -7F);
		body1.setTextureSize(128, 64);
		body1.mirror = true;
		setRotation(body1, 0.2617994F, 0F, 0F);
		body2 = new ResettableModelRenderer(this, 0, 0);
		body2.addBox(-5F, -5F, -7F, 10, 10, 10);
		body2.setRotationPoint(0F, 2F, -1F);
		body2.setTextureSize(128, 64);
		body2.mirror = true;
		setRotation(body2, 0F, 0F, 0F);
		body3 = new ResettableModelRenderer(this, 30, 22);
		body3.addBox(-4.5F, -4.5F, 0F, 9, 9, 3);
		body3.setRotationPoint(0F, 2F, 1F);
		body3.setTextureSize(128, 64);
		body3.mirror = true;
		setRotation(body3, -0.0872665F, 0F, 0F);
		body4 = new ResettableModelRenderer(this, 30, 37);
		body4.addBox(-4F, -4F, 0.5F, 8, 8, 2);
		body4.setRotationPoint(0F, 2F, 3F);
		body4.setTextureSize(128, 64);
		body4.mirror = true;
		setRotation(body4, -0.1745329F, 0F, 0F);
		neck1 = new ResettableModelRenderer(this, 0, 31);
		neck1.addBox(-2.5F, -7F, -3F, 5, 7, 6);
		neck1.setRotationPoint(0F, 0F, -7F);
		neck1.setTextureSize(128, 64);
		neck1.mirror = true;
		setRotation(neck1, 0.6981317F, 0F, 0F);
		neck2 = new ResettableModelRenderer(this, 0, 44);
		neck2.addBox(-2F, -12F, -5.5F, 4, 7, 5);
		neck2.setRotationPoint(0F, 0F, -7F);
		neck2.setTextureSize(128, 64);
		neck2.mirror = true;
		setRotation(neck2, 0.2617994F, 0F, 0F);
		head = new ResettableModelRenderer(this, 11, 48);
		head.addBox(-3.5F, -17F, -9.5F, 7, 6, 8);
		head.setRotationPoint(0F, 0F, -7F);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.1745329F, 0F, 0F);
		beakupper = new ResettableModelRenderer(this, 41, 49);
		beakupper.addBox(-3F, -15F, -17F, 6, 5, 8);
		beakupper.setRotationPoint(0F, 0F, -7F);
		beakupper.setTextureSize(128, 64);
		beakupper.mirror = true;
		setRotation(beakupper, 0F, 0F, 0F);
		beakbottom = new ResettableModelRenderer(this, 69, 50);
		beakbottom.addBox(-3F, -10F, -17F, 6, 2, 10);
		beakbottom.setRotationPoint(0F, 0F, -7F);
		beakbottom.setTextureSize(128, 64);
		beakbottom.mirror = true;
		setRotation(beakbottom, 0F, 0F, 0F);
		leftwing1 = new ResettableModelRenderer(this, 60, 35);
		leftwing1.addBox(0F, -2F, -2F, 2, 5, 8);
		leftwing1.setRotationPoint(5F, 1F, -5F);
		leftwing1.setTextureSize(128, 64);
		leftwing1.mirror = true;
		setRotation(leftwing1, 0F, 0F, 0F);
		leftwing2 = new ResettableModelRenderer(this, 81, 35);
		leftwing2.addBox(1F, 0F, 0F, 0, 5, 8);
		leftwing2.setRotationPoint(5F, 1F, -5F);
		leftwing2.setTextureSize(128, 64);
		leftwing2.mirror = true;
		setRotation(leftwing2, -0.5235988F, 0F, -0.5235988F);
		rightwing1 = new ResettableModelRenderer(this, 60, 35);
		rightwing1.addBox(-2F, -2F, -2F, 2, 5, 8);
		rightwing1.setRotationPoint(-5F, 1F, -5F);
		rightwing1.setTextureSize(128, 64);
		rightwing1.mirror = true;
		setRotation(rightwing1, 0F, 0F, 0F);
		rightwing2 = new ResettableModelRenderer(this, 81, 35);
		rightwing2.addBox(-1F, 0F, 0F, 0, 5, 8);
		rightwing2.setRotationPoint(-5F, 1F, -5F);
		rightwing2.setTextureSize(128, 64);
		rightwing2.mirror = true;
		setRotation(rightwing2, -0.5235988F, 0F, 0.5235988F);
		leftleg1 = new ResettableModelRenderer(this, 40, 0);
		leftleg1.addBox(-1F, -3F, -3F, 4, 9, 6);
		leftleg1.setRotationPoint(3F, 4F, -1.5F);
		leftleg1.setTextureSize(128, 64);
		leftleg1.mirror = true;
		setRotation(leftleg1, 0F, 0F, 0F);
		leftleg1.mirror = true;
		leftleg2 = new ResettableModelRenderer(this, 60, 0);
		leftleg2.addBox(-1F, 1.5F, -3F, 5, 9, 5);
		leftleg2.setRotationPoint(3F, 4F, -1.5F);
		leftleg2.setTextureSize(128, 64);
		leftleg2.mirror = true;
		setRotation(leftleg2, 0.2617994F, 0F, 0F);
		leftleg3 = new ResettableModelRenderer(this, 80, 0);
		leftleg3.addBox(0F, 8F, 2.5F, 3, 11, 3);
		leftleg3.setRotationPoint(3F, 4F, -1.5F);
		leftleg3.setTextureSize(128, 64);
		leftleg3.mirror = true;
		setRotation(leftleg3, -0.2617994F, 0F, 0F);
		leftfoot = new ResettableModelRenderer(this, 60, 14);
		leftfoot.addBox(-0.5F, 17F, -3F, 4, 2, 4);
		leftfoot.setRotationPoint(3F, 5F, -1.5F);
		leftfoot.setTextureSize(128, 64);
		leftfoot.mirror = true;
		setRotation(leftfoot, 0F, 0F, 0F);
		lefttoeleft = new ResettableModelRenderer(this, 66, 28);
		lefttoeleft.addBox(2.5F, 17.5F, -10F, 1, 1, 4);
		lefttoeleft.setRotationPoint(3F, 4F, -1.5F);
		lefttoeleft.setTextureSize(128, 64);
		lefttoeleft.mirror = true;
		setRotation(lefttoeleft, 0.1745329F, 0F, 0F);
		lefttoemiddle = new ResettableModelRenderer(this, 66, 28);
		lefttoemiddle.addBox(1F, 17.5F, -10F, 1, 1, 4);
		lefttoemiddle.setRotationPoint(3F, 4F, -1.5F);
		lefttoemiddle.setTextureSize(128, 64);
		lefttoemiddle.mirror = true;
		setRotation(lefttoemiddle, 0.1745329F, 0F, 0F);
		lefttoeright = new ResettableModelRenderer(this, 66, 28);
		lefttoeright.addBox(-0.5F, 17.5F, -10F, 1, 1, 4);
		lefttoeright.setRotationPoint(3F, 4F, -1.5F);
		lefttoeright.setTextureSize(128, 64);
		lefttoeright.mirror = true;
		setRotation(lefttoeright, 0.1745329F, 0F, 0F);
		rightleg1 = new ResettableModelRenderer(this, 40, 0);
		rightleg1.addBox(-3F, -3F, -3F, 4, 9, 6);
		rightleg1.setRotationPoint(-3F, 4F, -1.5F);
		rightleg1.setTextureSize(128, 64);
		rightleg1.mirror = true;
		setRotation(rightleg1, 0F, 0F, 0F);
		rightleg2 = new ResettableModelRenderer(this, 60, 0);
		rightleg2.addBox(-4F, 1.5F, -3F, 5, 9, 5);
		rightleg2.setRotationPoint(-3F, 4F, -1.5F);
		rightleg2.setTextureSize(128, 64);
		rightleg2.mirror = true;
		setRotation(rightleg2, 0.2617994F, 0F, 0F);
		rightleg3 = new ResettableModelRenderer(this, 80, 0);
		rightleg3.addBox(-3F, 8F, 2.5F, 3, 11, 3);
		rightleg3.setRotationPoint(-3F, 4F, -1.5F);
		rightleg3.setTextureSize(128, 64);
		rightleg3.mirror = true;
		setRotation(rightleg3, -0.2617994F, 0F, 0F);
		rightfoot = new ResettableModelRenderer(this, 60, 14);
		rightfoot.addBox(-3.5F, 18.17778F, -3F, 4, 2, 4);
		rightfoot.setRotationPoint(-3F, 4F, -1.5F);
		rightfoot.setTextureSize(128, 64);
		rightfoot.mirror = true;
		setRotation(rightfoot, 0F, 0F, 0F);
		righttoeleft = new ResettableModelRenderer(this, 66, 28);
		righttoeleft.addBox(-0.5F, 17.5F, -10F, 1, 1, 4);
		righttoeleft.setRotationPoint(-3F, 4F, -1.5F);
		righttoeleft.setTextureSize(128, 64);
		righttoeleft.mirror = true;
		setRotation(righttoeleft, 0.1745329F, 0F, 0F);
		righttoemiddle = new ResettableModelRenderer(this, 66, 28);
		righttoemiddle.addBox(-2F, 17.5F, -10F, 1, 1, 4);
		righttoemiddle.setRotationPoint(-3F, 4F, -1.5F);
		righttoemiddle.setTextureSize(128, 64);
		righttoemiddle.mirror = true;
		setRotation(righttoemiddle, 0.1745329F, 0F, 0F);
		righttoeright = new ResettableModelRenderer(this, 66, 28);
		righttoeright.addBox(-3.5F, 17.5F, -10F, 1, 1, 4);
		righttoeright.setRotationPoint(-3F, 4F, -1.5F);
		righttoeright.setTextureSize(128, 64);
		righttoeright.mirror = true;
		setRotation(righttoeright, 0.1745329F, 0F, 0F);

		tail1.savefirstParameters();
		tail2.savefirstParameters();
		body1.savefirstParameters();
		body2.savefirstParameters();
		body3.savefirstParameters();
		body4.savefirstParameters();
		neck1.savefirstParameters();
		neck2.savefirstParameters();
		head.savefirstParameters();
		beakupper.savefirstParameters();
		beakbottom.savefirstParameters();
		leftwing1.savefirstParameters();
		leftwing2.savefirstParameters();
		rightwing1.savefirstParameters();
		rightwing2.savefirstParameters();
		leftleg1.savefirstParameters();
		leftleg2.savefirstParameters();
		leftleg3.savefirstParameters();
		leftfoot.savefirstParameters();
		lefttoeleft.savefirstParameters();
		lefttoemiddle.savefirstParameters();
		lefttoeright.savefirstParameters();
		rightleg1.savefirstParameters();
		rightleg2.savefirstParameters();
		rightleg3.savefirstParameters();
		rightfoot.savefirstParameters();
		righttoeleft.savefirstParameters();
		righttoemiddle.savefirstParameters();
		righttoeright.savefirstParameters();
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		animate(entity, f, f1, f2, f3, f4, f5);

		tail1.render(f5);
		tail2.render(f5);
		body1.render(f5);
		body2.render(f5);
		body3.render(f5);
		body4.render(f5);
		neck1.render(f5);
		neck2.render(f5);
		head.render(f5);
		beakupper.render(f5);
		beakbottom.render(f5);
		leftwing1.render(f5);
		leftwing2.render(f5);
		rightwing1.render(f5);
		rightwing2.render(f5);
		leftleg1.render(f5);
		leftleg2.render(f5);
		leftleg3.render(f5);
		leftfoot.render(f5);
		lefttoeleft.render(f5);
		lefttoemiddle.render(f5);
		lefttoeright.render(f5);
		rightleg1.render(f5);
		rightleg2.render(f5);
		rightleg3.render(f5);
		rightfoot.render(f5);
		righttoeleft.render(f5);
		righttoemiddle.render(f5);
		righttoeright.render(f5);
	}

	private void setRotation(ResettableModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		neck1.rotateAngleX = f4 / (180F / PI) + 0.05F * MathHelper.sin(0.02F * f2) + neck1.firstRotateAngleX;
		neck2.rotateAngleX = f4 / (180F / PI) + 0.05F * MathHelper.sin(0.02F * f2) + neck2.firstRotateAngleX;
		head.rotateAngleX = f4 / (180F / PI) + 0.05F * MathHelper.sin(0.02F * f2) + head.firstRotateAngleX;
		beakupper.rotateAngleX = f4 / (180F / PI) + 0.05F * MathHelper.sin(0.02F * f2) + beakupper.firstRotateAngleX;
		beakbottom.rotateAngleX = f4 / (180F / PI) + 0.08F * MathHelper.sin(0.02F * f2) + beakbottom.firstRotateAngleX;

		neck1.rotateAngleY = f3 / (180F / PI) + neck1.firstRotateAngleY;
		neck2.rotateAngleY = f3 / (180F / PI) + neck2.firstRotateAngleY;
		head.rotateAngleY = f3 / (180F / PI) + head.firstRotateAngleY;
		beakupper.rotateAngleY = f3 / (180F / PI) + beakupper.firstRotateAngleY;
		beakbottom.rotateAngleY = f3 / (180F / PI) + beakbottom.firstRotateAngleY;

		tail1.rotateAngleX = 0.05F * MathHelper.cos(0.10F * f2 + f1) + tail1.firstRotateAngleX;
		tail2.rotateAngleX = 0.05F * MathHelper.cos(0.10F * f2 + f1) + tail2.firstRotateAngleX;

		rightwing2.rotateAngleX = rightwing2.firstRotateAngleX;
		leftwing2.rotateAngleX = leftwing2.firstRotateAngleX;
		rightwing2.rotateAngleY = rightwing2.firstRotateAngleY;
		leftwing2.rotateAngleY = leftwing2.firstRotateAngleY;
		rightwing2.rotateAngleZ = MathHelper.cos(f * 0.6662F) * 1.0F * f1 + rightwing2.firstRotateAngleZ;
		leftwing2.rotateAngleZ = MathHelper.cos(f * 0.6662F + PI) * 1.0F * f1 + leftwing2.firstRotateAngleZ;

		leftleg1.rotateAngleX = MathHelper.cos(f * 0.6662F + PI) * 1.0F * f1 + leftleg1.firstRotateAngleX;
		leftleg2.rotateAngleX = MathHelper.cos(f * 0.6662F + PI) * 1.0F * f1 + leftleg2.firstRotateAngleX;
		leftleg3.rotateAngleX = MathHelper.cos(f * 0.6662F + PI) * 1.0F * f1 + leftleg3.firstRotateAngleX;
		leftfoot.rotateAngleX = MathHelper.cos(f * 0.6662F + PI) * 1.0F * f1 + leftfoot.firstRotateAngleX;
		lefttoeleft.rotateAngleX = MathHelper.cos(f * 0.6662F + PI) * 1.0F * f1 + lefttoeleft.firstRotateAngleX;
		lefttoemiddle.rotateAngleX = MathHelper.cos(f * 0.6662F + PI) * 1.0F * f1 + lefttoemiddle.firstRotateAngleX;
		lefttoeright.rotateAngleX = MathHelper.cos(f * 0.6662F + PI) * 1.0F * f1 + lefttoeright.firstRotateAngleX;

		rightleg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1 + rightleg1.firstRotateAngleX;
		rightleg2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1 + rightleg2.firstRotateAngleX;
		rightleg3.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1 + rightleg3.firstRotateAngleX;
		rightfoot.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1 + rightfoot.firstRotateAngleX;
		righttoeleft.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1 + righttoeleft.firstRotateAngleX;
		righttoemiddle.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1 + righttoemiddle.firstRotateAngleX;
		righttoeright.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1 + righttoeright.firstRotateAngleX;

	}

	public void animate(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		animator.update((IAnimatedEntity) entity);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		EntityTitanisWalleri bird = (EntityTitanisWalleri) entity;
		if (bird.getGrowthStage() >= 0.5F * BygoneAgeMobsInformation.TITANISWALLERI.getTimesOfGrowth()) {
			animator.setAnim(BygoneAgeAnimationIDs.ANIMATION_PECK.getAnimationID());
			animator.startPhase(6);
			animator.rotate(neck1, PI / 2.8F, 0F, 0F);
			animator.rotate(neck2, PI / 2.8F, 0F, 0F);
			animator.rotate(head, PI / 2.7F, 0F, 0F);
			animator.rotate(beakupper, PI / 2.7F, 0F, 0F);
			animator.rotate(beakbottom, PI / 2.7F, 0F, 0F);
			animator.endPhase();
			animator.startPhase(6);
			animator.rotate(neck1, PI / 3.0F, 0F, 0F);
			animator.rotate(neck2, PI / 3.0F, 0F, 0F);
			animator.rotate(head, PI / 3.0F, 0F, 0F);
			animator.rotate(beakupper, PI / 2.8F, 0F, 0F);
			animator.rotate(beakbottom, PI / 2.5F, 0F, 0F);
			animator.endPhase();
			animator.resetPhase(3);
		}

	}
}
