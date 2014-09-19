package com.rafamv.bygoneage.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

import com.rafamv.bygoneage.entity.EntityBygoneAgeLandProtective;

public class BygoneAgeEntityAIAngerProtective extends EntityAIBase {

	private EntityBygoneAgeLandProtective entity;

	public BygoneAgeEntityAIAngerProtective(EntityLiving entityLiving) {
		this.entity = (EntityBygoneAgeLandProtective) entityLiving;
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