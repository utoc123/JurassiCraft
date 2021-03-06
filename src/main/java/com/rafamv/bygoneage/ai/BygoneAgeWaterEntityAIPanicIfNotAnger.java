package com.rafamv.bygoneage.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

import com.rafamv.bygoneage.entity.EntityBygoneAgeWaterProtective;

public class BygoneAgeWaterEntityAIPanicIfNotAnger extends EntityAIBase {

	private EntityBygoneAgeWaterProtective runningCreature;
	private double speed;
	private double randPosX;
	private double randPosY;
	private double randPosZ;

	public BygoneAgeWaterEntityAIPanicIfNotAnger(EntityBygoneAgeWaterProtective creature, double newSpeed) {
		this.runningCreature = creature;
		this.speed = newSpeed;
		this.setMutexBits(1);
	}

	@Override
	public boolean shouldExecute() {
		if (!this.runningCreature.isPanicking()) {
			return false;
		} else {
			Vec3 vec3 = RandomPositionGenerator.findRandomTarget(this.runningCreature, 5, 4);
			if (vec3 == null) {
				return false;
			} else {
				this.randPosX = vec3.xCoord;
				this.randPosY = vec3.yCoord;
				this.randPosZ = vec3.zCoord;
				return true;
			}
		}
	}

	@Override
	public void startExecuting() {
		this.runningCreature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
	}

	@Override
	public boolean continueExecuting() {
		this.runningCreature.setFleeingTick(this.runningCreature.getFleeingTick() - 1);
		return !this.runningCreature.getNavigator().noPath();
	}
}