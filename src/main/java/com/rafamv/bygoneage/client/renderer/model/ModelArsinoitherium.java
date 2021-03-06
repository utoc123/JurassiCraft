package com.rafamv.bygoneage.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import thehippomaster.AnimationAPI.client.Animator;

import com.rafamv.bygoneage.client.renderer.ResettableModelRenderer;
import com.rafamv.bygoneage.entity.creatures.EntityArsinoitherium;
import com.rafamv.bygoneage.enums.BygoneAgeAnimationIDs;

public class ModelArsinoitherium extends ModelBase {

	private Animator animator;
	public static final float PI = (float) Math.PI;
	ResettableModelRenderer leftbackleg1, leftbackleg2, leftbackleg3, leftbackleg4, rightbackleg1, rightbackleg2, rightbackleg3, rightbackleg4, leftfrontleg1, leftfrontleg2, leftfrontleg3, leftfrontleg4, rightfrontleg1, rightfrontleg2, rightfrontleg3, rightfrontleg4, upperfrontbody,
			bottomfrontbody, middleboby, upperbackbody, bottombackbody, neck, head, snout, mouth, rightupperhorn, leftupperhorn, rightbottomhorn1, leftbottomhorn1, tail1, tail2, leftear, rightear, leftbottomhorn2, leftbottomhorn3, rightbottomhorn2, rightbottomhorn3;

	public ModelArsinoitherium() {
		textureWidth = 128;
		textureHeight = 128;
		animator = new Animator(this);

		leftbackleg1 = new ResettableModelRenderer(this, 28, 65);
		leftbackleg1.addBox(-5F, -5.5F, -4F, 8, 11, 10);
		leftbackleg1.setRotationPoint(7F, 7F, 11F);
		leftbackleg1.setTextureSize(128, 128);
		leftbackleg1.mirror = true;
		setRotation(leftbackleg1, -0.2617994F, 0F, 0F);
		leftbackleg2 = new ResettableModelRenderer(this, 32, 86);
		leftbackleg2.addBox(-2.5F, 4F, -4F, 5, 5, 7);
		leftbackleg2.setRotationPoint(7F, 8F, 11F);
		leftbackleg2.setTextureSize(128, 128);
		leftbackleg2.mirror = true;
		setRotation(leftbackleg2, -0.2617994F, 0F, 0F);
		leftbackleg3 = new ResettableModelRenderer(this, 64, 65);
		leftbackleg3.addBox(-2F, 5.5F, -8.5F, 4, 7, 4);
		leftbackleg3.setRotationPoint(7F, 7F, 11F);
		leftbackleg3.setTextureSize(128, 128);
		leftbackleg3.mirror = true;
		setRotation(leftbackleg3, 0.4363323F, 0F, 0F);
		leftbackleg4 = new ResettableModelRenderer(this, 88, 38);
		leftbackleg4.addBox(-2F, 13F, 0F, 4, 4, 4);
		leftbackleg4.setRotationPoint(7F, 7F, 8F);
		leftbackleg4.setTextureSize(128, 128);
		leftbackleg4.mirror = true;
		setRotation(leftbackleg4, 0F, 0F, 0F);
		rightbackleg1 = new ResettableModelRenderer(this, 28, 65);
		rightbackleg1.addBox(-3F, -5.5F, -4F, 8, 11, 10);
		rightbackleg1.setRotationPoint(-7F, 7F, 11F);
		rightbackleg1.setTextureSize(128, 128);
		rightbackleg1.mirror = true;
		setRotation(rightbackleg1, -0.2617994F, 0F, 0F);
		rightbackleg2 = new ResettableModelRenderer(this, 32, 86);
		rightbackleg2.addBox(-2.5F, 4F, -4F, 5, 5, 7);
		rightbackleg2.setRotationPoint(-7.044445F, 8F, 11F);
		rightbackleg2.setTextureSize(128, 128);
		rightbackleg2.mirror = true;
		setRotation(rightbackleg2, -0.2617994F, 0F, 0F);
		rightbackleg3 = new ResettableModelRenderer(this, 64, 65);
		rightbackleg3.addBox(-2.033333F, 5.5F, -8.5F, 4, 7, 4);
		rightbackleg3.setRotationPoint(-7F, 7F, 11F);
		rightbackleg3.setTextureSize(128, 128);
		rightbackleg3.mirror = true;
		setRotation(rightbackleg3, 0.4363323F, 0F, 0F);
		rightbackleg4 = new ResettableModelRenderer(this, 88, 38);
		rightbackleg4.addBox(-2F, 13F, 0F, 4, 4, 4);
		rightbackleg4.setRotationPoint(-7F, 7F, 8F);
		rightbackleg4.setTextureSize(128, 128);
		rightbackleg4.mirror = true;
		setRotation(rightbackleg4, 0F, 0F, 0F);
		leftfrontleg1 = new ResettableModelRenderer(this, 0, 68);
		leftfrontleg1.addBox(-4F, -5F, -2F, 6, 10, 8);
		leftfrontleg1.setRotationPoint(7F, 7F, -10F);
		leftfrontleg1.setTextureSize(128, 128);
		leftfrontleg1.mirror = true;
		setRotation(leftfrontleg1, 0.1745329F, 0F, 0F);
		leftfrontleg2 = new ResettableModelRenderer(this, 0, 86);
		leftfrontleg2.addBox(-2.5F, 4F, -1.5F, 4, 7, 4);
		leftfrontleg2.setRotationPoint(7F, 7F, -10F);
		leftfrontleg2.setTextureSize(128, 128);
		leftfrontleg2.mirror = true;
		setRotation(leftfrontleg2, 0.4363323F, 0F, 0F);
		leftfrontleg3 = new ResettableModelRenderer(this, 16, 86);
		leftfrontleg3.addBox(-2.5F, 6.5F, 4F, 4, 6, 4);
		leftfrontleg3.setRotationPoint(7F, 7F, -10F);
		leftfrontleg3.setTextureSize(128, 128);
		leftfrontleg3.mirror = true;
		setRotation(leftfrontleg3, -0.2617994F, 0F, 0F);
		leftfrontleg4 = new ResettableModelRenderer(this, 88, 38);
		leftfrontleg4.addBox(-2.5F, 13F, 0.5F, 4, 4, 4);
		leftfrontleg4.setRotationPoint(7F, 7F, -10F);
		leftfrontleg4.setTextureSize(128, 128);
		leftfrontleg4.mirror = true;
		setRotation(leftfrontleg4, 0F, 0F, 0F);
		rightfrontleg1 = new ResettableModelRenderer(this, 0, 68);
		rightfrontleg1.addBox(-2F, -5F, -2F, 6, 10, 8);
		rightfrontleg1.setRotationPoint(-7F, 7F, -10F);
		rightfrontleg1.setTextureSize(128, 128);
		rightfrontleg1.mirror = true;
		setRotation(rightfrontleg1, 0.1745329F, 0F, 0F);
		rightfrontleg2 = new ResettableModelRenderer(this, 0, 86);
		rightfrontleg2.addBox(-1.5F, 4F, -1.5F, 4, 7, 4);
		rightfrontleg2.setRotationPoint(-7F, 7F, -10F);
		rightfrontleg2.setTextureSize(128, 128);
		rightfrontleg2.mirror = true;
		setRotation(rightfrontleg2, 0.4363323F, 0F, 0F);
		rightfrontleg3 = new ResettableModelRenderer(this, 16, 86);
		rightfrontleg3.addBox(-1.5F, 6.5F, 4F, 4, 6, 4);
		rightfrontleg3.setRotationPoint(-7F, 7F, -10F);
		rightfrontleg3.setTextureSize(128, 128);
		rightfrontleg3.mirror = true;
		setRotation(rightfrontleg3, -0.2617994F, 0F, 0F);
		rightfrontleg4 = new ResettableModelRenderer(this, 88, 38);
		rightfrontleg4.addBox(-1.5F, 13F, 0.5F, 4, 4, 4);
		rightfrontleg4.setRotationPoint(-7F, 7F, -10F);
		rightfrontleg4.setTextureSize(128, 128);
		rightfrontleg4.mirror = true;
		setRotation(rightfrontleg4, 0F, 0F, 0F);
		upperfrontbody = new ResettableModelRenderer(this, 66, 0);
		upperfrontbody.addBox(-7.5F, -6F, -14F, 15, 14, 8);
		upperfrontbody.setRotationPoint(0F, 5F, 0F);
		upperfrontbody.setTextureSize(128, 128);
		upperfrontbody.mirror = true;
		setRotation(upperfrontbody, 0F, 0F, 0F);
		bottomfrontbody = new ResettableModelRenderer(this, 66, 22);
		bottomfrontbody.addBox(-7F, 4.2F, -11.5F, 14, 6, 10);
		bottomfrontbody.setRotationPoint(0F, 5F, 0F);
		bottomfrontbody.setTextureSize(128, 128);
		bottomfrontbody.mirror = true;
		setRotation(bottomfrontbody, -0.1745329F, 0F, 0F);
		middleboby = new ResettableModelRenderer(this, 0, 0);
		middleboby.addBox(-7.5F, -5F, -6F, 15, 15, 18);
		middleboby.setRotationPoint(0F, 5F, 0F);
		middleboby.setTextureSize(128, 128);
		middleboby.mirror = true;
		setRotation(middleboby, 0F, 0F, 0F);
		upperbackbody = new ResettableModelRenderer(this, 0, 33);
		upperbackbody.addBox(-7F, -4F, 9.5F, 14, 12, 9);
		upperbackbody.setRotationPoint(0F, 5F, 0F);
		upperbackbody.setTextureSize(128, 128);
		upperbackbody.mirror = true;
		setRotation(upperbackbody, 0F, 0F, 0F);
		bottombackbody = new ResettableModelRenderer(this, 44, 38);
		bottombackbody.addBox(-7F, 7F, 10F, 14, 2, 6);
		bottombackbody.setRotationPoint(0F, 5F, 0F);
		bottombackbody.setTextureSize(128, 128);
		bottombackbody.mirror = true;
		setRotation(bottombackbody, 0F, 0F, 0F);
		neck = new ResettableModelRenderer(this, 86, 46);
		neck.addBox(-4F, -2F, -3F, 8, 6, 6);
		neck.setRotationPoint(0F, 4F, -15F);
		neck.setTextureSize(128, 128);
		neck.mirror = true;
		setRotation(neck, 0F, 0F, 0F);
		head = new ResettableModelRenderer(this, 0, 54);
		head.addBox(-4.5F, -3F, -8F, 9, 8, 8);
		head.setRotationPoint(0F, 3.5F, -16F);
		head.setTextureSize(128, 128);
		head.mirror = true;
		setRotation(head, 0.3141593F, 0F, 0F);
		snout = new ResettableModelRenderer(this, 34, 52);
		snout.addBox(-3.988889F, -3F, -13.5F, 8, 5, 6);
		snout.setRotationPoint(0F, 4F, -16F);
		snout.setTextureSize(128, 128);
		snout.mirror = true;
		setRotation(snout, 0.3141593F, 0F, 0F);
		mouth = new ResettableModelRenderer(this, 56, 76);
		mouth.addBox(-3F, 1.2F, -12.5F, 6, 3, 12);
		mouth.setRotationPoint(0F, 5F, -16F);
		mouth.setTextureSize(128, 128);
		mouth.mirror = true;
		setRotation(mouth, 0.2617994F, 0F, 0F);
		rightupperhorn = new ResettableModelRenderer(this, 116, 0);
		rightupperhorn.addBox(-3.5F, -1.5F, -7.5F, 1, 3, 1);
		rightupperhorn.setRotationPoint(0F, 4F, -16F);
		rightupperhorn.setTextureSize(128, 128);
		rightupperhorn.mirror = true;
		setRotation(rightupperhorn, -0.2617994F, 0F, 0F);
		leftupperhorn = new ResettableModelRenderer(this, 116, 0);
		leftupperhorn.addBox(2.5F, -1.5F, -7.5F, 1, 3, 1);
		leftupperhorn.setRotationPoint(0F, 4F, -16F);
		leftupperhorn.setTextureSize(128, 128);
		leftupperhorn.mirror = true;
		setRotation(leftupperhorn, -0.2617994F, 0F, 0F);
		tail1 = new ResettableModelRenderer(this, 85, 60);
		tail1.addBox(-0.5F, -0.5F, 0F, 1, 1, 4);
		tail1.setRotationPoint(0F, 4F, 17.97778F);
		tail1.setTextureSize(128, 128);
		tail1.mirror = true;
		setRotation(tail1, -0.7853982F, 0F, 0F);
		tail2 = new ResettableModelRenderer(this, 85, 70);
		tail2.addBox(-1F, 0F, 3F, 2, 0, 3);
		tail2.setRotationPoint(0F, 4F, 18F);
		tail2.setTextureSize(128, 128);
		tail2.mirror = true;
		setRotation(tail2, -0.7853982F, 0F, 0F);
		leftear = new ResettableModelRenderer(this, 100, 60);
		leftear.addBox(3F, -4F, -3.5F, 2, 3, 1);
		leftear.setRotationPoint(0F, 4F, -16F);
		leftear.setTextureSize(128, 128);
		leftear.mirror = true;
		setRotation(leftear, -0.3490659F, -0.1745329F, 0.1745329F);
		rightear = new ResettableModelRenderer(this, 106, 60);
		rightear.addBox(-5F, -4F, -3.5F, 2, 3, 1);
		rightear.setRotationPoint(0F, 4F, -16F);
		rightear.setTextureSize(128, 128);
		rightear.mirror = true;
		setRotation(rightear, -0.3490659F, 0.1745329F, -0.1745329F);
		leftbottomhorn1 = new ResettableModelRenderer(this, 116, 0);
		leftbottomhorn1.addBox(0.2F, -5F, -13.7F, 4, 2, 4);
		leftbottomhorn1.setRotationPoint(0F, 4F, -16F);
		leftbottomhorn1.setTextureSize(128, 128);
		leftbottomhorn1.mirror = true;
		setRotation(leftbottomhorn1, 0.3490659F, 0F, 0F);
		leftbottomhorn2 = new ResettableModelRenderer(this, 116, 6);
		leftbottomhorn2.addBox(0.2F, -8F, -13.7F, 3, 3, 3);
		leftbottomhorn2.setRotationPoint(1F, 4F, -16F);
		leftbottomhorn2.setTextureSize(128, 128);
		leftbottomhorn2.mirror = true;
		setRotation(leftbottomhorn2, 0.3490659F, 0F, 0F);
		leftbottomhorn3 = new ResettableModelRenderer(this, 116, 12);
		leftbottomhorn3.addBox(2.177778F, -11F, -13.7F, 2, 3, 2);
		leftbottomhorn3.setRotationPoint(0F, 4F, -16F);
		leftbottomhorn3.setTextureSize(128, 128);
		leftbottomhorn3.mirror = true;
		setRotation(leftbottomhorn3, 0.3490659F, 0F, 0F);
		rightbottomhorn1 = new ResettableModelRenderer(this, 116, 0);
		rightbottomhorn1.addBox(-4.2F, -5F, -13.7F, 4, 2, 4);
		rightbottomhorn1.setRotationPoint(0F, 4F, -16F);
		rightbottomhorn1.setTextureSize(128, 128);
		rightbottomhorn1.mirror = true;
		setRotation(rightbottomhorn1, 0.3490659F, 0F, 0F);
		rightbottomhorn2 = new ResettableModelRenderer(this, 116, 6);
		rightbottomhorn2.addBox(-4.2F, -8F, -13.7F, 3, 3, 3);
		rightbottomhorn2.setRotationPoint(0F, 4F, -16F);
		rightbottomhorn2.setTextureSize(128, 128);
		rightbottomhorn2.mirror = true;
		setRotation(rightbottomhorn2, 0.3490659F, 0F, 0F);
		rightbottomhorn3 = new ResettableModelRenderer(this, 116, 12);
		rightbottomhorn3.addBox(-4.2F, -11F, -13.7F, 2, 3, 2);
		rightbottomhorn3.setRotationPoint(0F, 4F, -16F);
		rightbottomhorn3.setTextureSize(128, 128);
		rightbottomhorn3.mirror = true;
		setRotation(rightbottomhorn3, 0.3490659F, 0F, 0F);

		leftbackleg1.savefirstParameters();
		leftbackleg2.savefirstParameters();
		leftbackleg3.savefirstParameters();
		leftbackleg4.savefirstParameters();
		rightbackleg1.savefirstParameters();
		rightbackleg2.savefirstParameters();
		rightbackleg3.savefirstParameters();
		rightbackleg4.savefirstParameters();
		leftfrontleg1.savefirstParameters();
		leftfrontleg2.savefirstParameters();
		leftfrontleg3.savefirstParameters();
		leftfrontleg4.savefirstParameters();
		rightfrontleg1.savefirstParameters();
		rightfrontleg2.savefirstParameters();
		rightfrontleg3.savefirstParameters();
		rightfrontleg4.savefirstParameters();
		upperfrontbody.savefirstParameters();
		bottomfrontbody.savefirstParameters();
		middleboby.savefirstParameters();
		upperbackbody.savefirstParameters();
		bottombackbody.savefirstParameters();
		neck.savefirstParameters();
		head.savefirstParameters();
		snout.savefirstParameters();
		mouth.savefirstParameters();
		rightupperhorn.savefirstParameters();
		leftupperhorn.savefirstParameters();
		tail1.savefirstParameters();
		tail2.savefirstParameters();
		leftear.savefirstParameters();
		rightear.savefirstParameters();
		rightbottomhorn1.savefirstParameters();
		rightbottomhorn2.savefirstParameters();
		rightbottomhorn3.savefirstParameters();
		leftbottomhorn1.savefirstParameters();
		leftbottomhorn2.savefirstParameters();
		leftbottomhorn3.savefirstParameters();

	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		animate(entity, f, f1, f2, f3, f4, f5);

		leftbackleg1.render(f5);
		leftbackleg2.render(f5);
		leftbackleg3.render(f5);
		leftbackleg4.render(f5);
		rightbackleg1.render(f5);
		rightbackleg2.render(f5);
		rightbackleg3.render(f5);
		rightbackleg4.render(f5);
		leftfrontleg1.render(f5);
		leftfrontleg2.render(f5);
		leftfrontleg3.render(f5);
		leftfrontleg4.render(f5);
		rightfrontleg1.render(f5);
		rightfrontleg2.render(f5);
		rightfrontleg3.render(f5);
		rightfrontleg4.render(f5);
		upperfrontbody.render(f5);
		bottomfrontbody.render(f5);
		middleboby.render(f5);
		upperbackbody.render(f5);
		bottombackbody.render(f5);
		neck.render(f5);
		head.render(f5);
		snout.render(f5);
		mouth.render(f5);
		tail1.render(f5);
		tail2.render(f5);
		leftear.render(f5);
		rightear.render(f5);
		rightupperhorn.render(f5);
		leftupperhorn.render(f5);
		if (((EntityArsinoitherium) entity).getTotalTicksLived() >= 0.8 * ((EntityArsinoitherium) entity).getAdultPercentage()) {
			leftbottomhorn1.render(f5);
			leftbottomhorn2.render(f5);
			leftbottomhorn3.render(f5);
			rightbottomhorn1.render(f5);
			rightbottomhorn2.render(f5);
			rightbottomhorn3.render(f5);
		}
	}

	private void setRotation(ResettableModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		float headMovementX = f4 / (225F / (float) Math.PI);
		float headMovementY = f3 / (225F / (float) Math.PI);
		float legMovement1 = f1 * MathHelper.cos(f * 0.6662F + (float) Math.PI);
		float legMovement2 = f1 * MathHelper.cos(f * 0.6662F);
		float tailNaturalMovementX = 0.05F * MathHelper.sin(0.10F * f2);
		float tailNaturalMovementY = 0.05F * MathHelper.sin(0.10F * f2 + (float) Math.PI);

		head.rotateAngleX = headMovementX + head.firstRotateAngleX;
		snout.rotateAngleX = headMovementX + snout.firstRotateAngleX;
		mouth.rotateAngleX = headMovementX + mouth.firstRotateAngleX;
		leftear.rotateAngleX = headMovementX + leftear.firstRotateAngleX;
		rightear.rotateAngleX = headMovementX + rightear.firstRotateAngleX;
		rightupperhorn.rotateAngleX = headMovementX + rightupperhorn.firstRotateAngleX;
		leftupperhorn.rotateAngleX = headMovementX + leftupperhorn.firstRotateAngleX;
		rightbottomhorn1.rotateAngleX = headMovementX + rightbottomhorn1.firstRotateAngleX;
		rightbottomhorn2.rotateAngleX = headMovementX + rightbottomhorn2.firstRotateAngleX;
		rightbottomhorn3.rotateAngleX = headMovementX + rightbottomhorn3.firstRotateAngleX;
		leftbottomhorn1.rotateAngleX = headMovementX + leftbottomhorn1.firstRotateAngleX;
		leftbottomhorn2.rotateAngleX = headMovementX + leftbottomhorn2.firstRotateAngleX;
		leftbottomhorn3.rotateAngleX = headMovementX + leftbottomhorn3.firstRotateAngleX;

		head.rotateAngleY = headMovementY + head.firstRotateAngleY;
		snout.rotateAngleY = headMovementY + snout.firstRotateAngleY;
		mouth.rotateAngleY = headMovementY + mouth.firstRotateAngleY;
		leftear.rotateAngleY = headMovementY + leftear.firstRotateAngleY;
		rightear.rotateAngleY = headMovementY + rightear.firstRotateAngleY;
		rightupperhorn.rotateAngleY = headMovementY + rightupperhorn.firstRotateAngleY;
		leftupperhorn.rotateAngleY = headMovementY + leftupperhorn.firstRotateAngleY;
		rightbottomhorn1.rotateAngleY = headMovementY + rightbottomhorn1.firstRotateAngleY;
		rightbottomhorn2.rotateAngleY = headMovementY + rightbottomhorn2.firstRotateAngleY;
		rightbottomhorn3.rotateAngleY = headMovementY + rightbottomhorn3.firstRotateAngleY;
		leftbottomhorn1.rotateAngleY = headMovementY + leftbottomhorn1.firstRotateAngleY;
		leftbottomhorn2.rotateAngleY = headMovementY + leftbottomhorn2.firstRotateAngleY;
		leftbottomhorn3.rotateAngleY = headMovementY + leftbottomhorn3.firstRotateAngleY;

		rightfrontleg1.rotateAngleX = legMovement1 + rightfrontleg1.firstRotateAngleX;
		rightfrontleg2.rotateAngleX = legMovement1 + rightfrontleg2.firstRotateAngleX;
		rightfrontleg3.rotateAngleX = legMovement1 + rightfrontleg3.firstRotateAngleX;
		rightfrontleg4.rotateAngleX = legMovement1 + rightfrontleg4.firstRotateAngleX;

		leftfrontleg1.rotateAngleX = legMovement2 + leftfrontleg1.firstRotateAngleX;
		leftfrontleg2.rotateAngleX = legMovement2 + leftfrontleg2.firstRotateAngleX;
		leftfrontleg3.rotateAngleX = legMovement2 + leftfrontleg3.firstRotateAngleX;
		leftfrontleg4.rotateAngleX = legMovement2 + leftfrontleg4.firstRotateAngleX;

		rightbackleg1.rotateAngleX = legMovement2 + rightbackleg1.firstRotateAngleX;
		rightbackleg2.rotateAngleX = legMovement2 + rightbackleg2.firstRotateAngleX;
		rightbackleg3.rotateAngleX = legMovement2 + rightbackleg3.firstRotateAngleX;
		rightbackleg4.rotateAngleX = legMovement2 + rightbackleg4.firstRotateAngleX;

		leftbackleg1.rotateAngleX = legMovement1 + leftbackleg1.firstRotateAngleX;
		leftbackleg2.rotateAngleX = legMovement1 + leftbackleg2.firstRotateAngleX;
		leftbackleg3.rotateAngleX = legMovement1 + leftbackleg3.firstRotateAngleX;
		leftbackleg4.rotateAngleX = legMovement1 + leftbackleg4.firstRotateAngleX;

		tail1.rotateAngleX = tailNaturalMovementX + tail1.firstRotateAngleX;
		tail2.rotateAngleX = tailNaturalMovementX + tail2.firstRotateAngleX;
		tail1.rotateAngleY = tailNaturalMovementX + tail1.firstRotateAngleY;
		tail2.rotateAngleY = tailNaturalMovementX + tail2.firstRotateAngleY;
		tail1.rotateAngleZ = tailNaturalMovementY + tail1.firstRotateAngleZ;
		tail2.rotateAngleZ = tailNaturalMovementY + tail2.firstRotateAngleZ;
	}

	public void animate(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		animator.update((IAnimatedEntity) entity);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		animator.setAnim(BygoneAgeAnimationIDs.ANIMATION_HEADBUTT.getAnimationID());
		animator.startPhase(7);
		animator.rotate(head, PI / 3F, 0F, 0F);
		animator.rotate(snout, PI / 3F, 0F, 0F);
		animator.rotate(mouth, PI / 3F, 0F, 0F);
		animator.rotate(rightupperhorn, PI / 3F, 0F, 0F);
		animator.rotate(leftupperhorn, PI / 3F, 0F, 0F);
		animator.rotate(leftbottomhorn1, PI / 3F, 0F, 0F);
		animator.rotate(leftbottomhorn2, PI / 3F, 0F, 0F);
		animator.rotate(leftbottomhorn3, PI / 3F, 0F, 0F);
		animator.rotate(rightbottomhorn1, PI / 3F, 0F, 0F);
		animator.rotate(rightbottomhorn2, PI / 3F, 0F, 0F);
		animator.rotate(rightbottomhorn3, PI / 3F, 0F, 0F);
		animator.rotate(leftear, PI / 3F, 0F, 0F);
		animator.rotate(rightear, PI / 3F, 0F, 0F);
		animator.endPhase();
		animator.setStationaryPhase(3);
		animator.startPhase(3);
		animator.rotate(head, -PI / 2F, 0F, 0F);
		animator.rotate(snout, -PI / 2F, 0F, 0F);
		animator.rotate(mouth, -PI / 2F, 0F, 0F);
		animator.rotate(rightupperhorn, -PI / 2F, 0F, 0F);
		animator.rotate(leftupperhorn, -PI / 2F, 0F, 0F);
		animator.rotate(leftbottomhorn1, -PI / 2F, 0F, 0F);
		animator.rotate(leftbottomhorn2, -PI / 2F, 0F, 0F);
		animator.rotate(leftbottomhorn3, -PI / 2F, 0F, 0F);
		animator.rotate(rightbottomhorn1, -PI / 2F, 0F, 0F);
		animator.rotate(rightbottomhorn2, -PI / 2F, 0F, 0F);
		animator.rotate(rightbottomhorn3, -PI / 2F, 0F, 0F);
		animator.rotate(leftear, -PI / 2F, 0F, 0F);
		animator.rotate(rightear, -PI / 2F, 0F, 0F);
		animator.endPhase();
		animator.resetPhase(2);
	}

}
