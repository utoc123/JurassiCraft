package com.rafamv.bygoneage.ai;

import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;

import com.rafamv.bygoneage.entity.EntityBygoneAgeWaterCreature;

public class BygoneAgeWaterEntityAISwim extends EntityAIBase {
	protected EntityBygoneAgeWaterCreature entity;
	protected final float floatSpeed;
	protected final float sinkSpeed;
	protected final float FAST_floatSpeed;
	protected final float fastSinkSpeed;

	public BygoneAgeWaterEntityAISwim(EntityBygoneAgeWaterCreature creature, float floatVelocity, float sinkVelocity) {
		this.entity = creature;
		this.setMutexBits(4);
		this.floatSpeed = floatVelocity > 1.0F ? 1.0F : floatVelocity;
		this.sinkSpeed = -sinkVelocity;
		this.FAST_floatSpeed = this.floatSpeed * 50.0F;
		this.fastSinkSpeed = -this.FAST_floatSpeed;
	}

	public boolean shouldExecute() {
		return this.entity.isInWater() || this.entity.handleLavaMovement();
	}

	public void updateTask() {
		EntityPlayer player = (EntityPlayer) ((EntityPlayer) this.entity.getOwner());

		if (player != null && player.isInWater()) {
			double var10000 = Math.abs(this.entity.posY - player.posY);
			this.getClass();
			if (var10000 > 1.5D) {
				this.entity.motionY = player.posY < this.entity.posY ? (double) this.fastSinkSpeed : (double) this.FAST_floatSpeed;
			} else {
				this.entity.motionY = player.posY < this.entity.posY ? (double) this.sinkSpeed : (double) this.floatSpeed;
			}
		} else {
			if (this.entity.getNavigator().noPath()) {
				this.entity.motionY = (double) this.floatSpeed;
			}
		}
	}

	protected void controlSurfacing() {
		byte var1 = 5;
		double var2 = 0.0D;
		for (int var6 = 0; var6 < var1; ++var6) {
			double var7 = this.entity.boundingBox.minY + (this.entity.boundingBox.maxY - this.entity.boundingBox.minY) * (double) (var6 + 0) / (double) var1 - 0.125D;
			double var9 = this.entity.boundingBox.minY + (this.entity.boundingBox.maxY - this.entity.boundingBox.minY) * (double) (var6 + 1) / (double) var1 - 0.125D;
			/*AxisAlignedBB var11 = AxisAlignedBB.getAABBPool().getAABB(this.entity.boundingBox.minX, var7, this.entity.boundingBox.minZ, this.entity.boundingBox.maxX, var9, this.entity.boundingBox.maxZ);
			if (this.entity.worldObj.isAABBInMaterial(var11, Material.water)) {
				var2 += 1.0D / (double) var1;
			}*/
		}
		if (var2 < 1.0D) {
			double var4 = var2 * 2.0D - 1.0D;
			this.entity.motionY += 0.03999999910593033D * var4;
		} else {
			if (this.entity.motionY < 0.0D) {
				this.entity.motionY = 0.0D;
			}
			this.entity.motionY += (double) this.FAST_floatSpeed;
		}
	}
}