package com.rafamv.bygoneage.ai;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

import com.rafamv.bygoneage.entity.EntityBygoneAgeTameable;

public class BygoneAgeEntityAITargetIfNonTamed extends EntityAINearestAttackableTarget {

	private EntityBygoneAgeTameable creature;

	public BygoneAgeEntityAITargetIfNonTamed(EntityBygoneAgeTameable entityTameable, Class targetClass, int chance) {
		super(entityTameable, targetClass, chance, false);
		this.creature = entityTameable;
	}

	public boolean shouldExecute() {
		return this.creature.isCreatureAdult() && !this.creature.isTamed() && super.shouldExecute();
	}
}