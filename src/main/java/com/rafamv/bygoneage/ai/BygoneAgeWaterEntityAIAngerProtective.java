package com.rafamv.bygoneage.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

import com.rafamv.bygoneage.entity.EntityBygoneAgeWaterProtective;

public class BygoneAgeWaterEntityAIAngerProtective extends EntityAIBase {

	private EntityBygoneAgeWaterProtective entity;

	public BygoneAgeWaterEntityAIAngerProtective(EntityLiving entityLiving) {
		this.entity = (EntityBygoneAgeWaterProtective) entityLiving;
	}

	@Override
	public boolean shouldExecute() {
		return (entity.isAngry());
	}

	@Override
	public void updateTask() {
		this.entity.setAngerLevel((short) (entity.getAngerLevel() - 1));
		if (!entity.isAngry()) {
			this.entity.setAngerLevel((short) 0);
			this.entity.setAttackTarget(null);
		}
	}
}