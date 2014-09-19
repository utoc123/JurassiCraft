package com.rafamv.bygoneage.ai;

import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;

import com.rafamv.bygoneage.entity.EntityBygoneAgeWaterCreature;

public class BygoneAgeWaterEntityAIWander extends EntityAIBase {

	public int courseChangeCooldown;
	public double waypointX;
	public double waypointY;
	public double waypointZ;
	private EntityBygoneAgeWaterCreature entity;

	public BygoneAgeWaterEntityAIWander(EntityBygoneAgeWaterCreature creature, double velocity) {
		this.entity = creature;
		this.setMutexBits(1);
	}

	public boolean shouldExecute() {
		return !this.entity.isDead && this.entity.isInsideOfMaterial(Material.water);
	}

	public boolean continueExecuting() {
		return !this.entity.isDead;
	}

	@Override
	public void updateTask() {
		double deltaX = this.waypointX - this.entity.posX;
		double deltaY = this.waypointY - this.entity.posY;
		double deltaZ = this.waypointZ - this.entity.posZ;
		double distance = deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ;
		if (distance < 1.0D || distance > 4900.0D) {
			this.waypointX = this.entity.posX + (double) ((this.entity.worldObj.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.waypointY = this.entity.posY + (double) ((this.entity.worldObj.rand.nextFloat() * 2.0F - 1.0F) * 8.0F);
			this.waypointZ = this.entity.posZ + (double) ((this.entity.worldObj.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
		}

		if (this.courseChangeCooldown-- <= 0) {
			this.courseChangeCooldown += this.entity.worldObj.rand.nextInt(10) + 5;
			distance = (double) MathHelper.sqrt_double(distance);
			if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, distance)) {
				this.entity.motionX = this.entity.motionX + (deltaX / distance) * 0.1D;
				this.entity.motionZ = this.entity.motionZ + (deltaZ / distance) * 0.1D;
				if (this.entity.isInsideOfMaterial(Material.water)) {
					this.entity.motionY = this.entity.motionY + (deltaY / distance) * 0.1D;
				} else {
					this.entity.motionY = this.entity.motionY - 0.08D;
					this.entity.motionY = this.entity.motionY * 0.9800000190734863D;
				}
			} else {
				this.waypointX = this.entity.posX;
				this.waypointY = this.entity.posY;
				this.waypointZ = this.entity.posZ;
			}
		}
		this.entity.renderYawOffset = this.entity.rotationYaw = -((float) Math.atan2(this.entity.motionX, this.entity.motionZ)) * 180.0F / (float) Math.PI;
	}

	private boolean isCourseTraversable(double pointX, double pointY, double pointZ, double distance) {
		double verifyX = (this.waypointX - this.entity.posX) / distance;
		double verifyY = (this.waypointY - this.entity.posY) / distance;
		double verifyZ = (this.waypointZ - this.entity.posZ) / distance;
		AxisAlignedBB axisalignedbb = this.entity.boundingBox.copy();
		axisalignedbb.offset(verifyX, verifyY, verifyZ);
		for (double i = 1.0D; i < distance; i++) {
			axisalignedbb.offset(verifyX, verifyY, verifyZ);
			if (!this.entity.worldObj.getCollidingBoundingBoxes(this.entity, axisalignedbb).isEmpty()) {
				return false;
			}
		}
		return this.entity.worldObj.isAnyLiquid(axisalignedbb);
	}

}