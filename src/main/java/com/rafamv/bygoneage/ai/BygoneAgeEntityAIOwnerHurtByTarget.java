package com.rafamv.bygoneage.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

import com.rafamv.bygoneage.entity.EntityBygoneAgeTameable;

public class BygoneAgeEntityAIOwnerHurtByTarget extends EntityAITarget {
	EntityBygoneAgeTameable defendingTameable;
	EntityLivingBase howTheOwnerIsAttacking;
	private int revengeTime;

	public BygoneAgeEntityAIOwnerHurtByTarget(EntityBygoneAgeTameable entityTameable) {
		super(entityTameable, false);
		this.defendingTameable = entityTameable;
		this.setMutexBits(1);
	}

	@Override
	public boolean shouldExecute() {
		if (!this.defendingTameable.isTamed()) {
			return false;
		} else {
			EntityLivingBase entitylivingbase = this.defendingTameable.getOwner();
			if (entitylivingbase == null) {
				return false;
			} else {
				this.howTheOwnerIsAttacking = entitylivingbase.getAITarget();
				int i = entitylivingbase.func_142015_aE();
				if (this.howTheOwnerIsAttacking instanceof EntityBygoneAgeTameable) {
					return i != this.revengeTime && this.isSuitableTarget(this.howTheOwnerIsAttacking, false) && (this.howTheOwnerIsAttacking.getClass() != this.defendingTameable.getClass() || ((EntityBygoneAgeTameable) this.howTheOwnerIsAttacking).getOwner() != this.defendingTameable.getOwner());
				} else {
					return i != this.revengeTime && this.isSuitableTarget(this.howTheOwnerIsAttacking, false);
				}
			}
		}
	}

	@Override
	public void startExecuting() {
		this.taskOwner.setAttackTarget(this.howTheOwnerIsAttacking);
		EntityLivingBase defenderCreature = this.defendingTameable.getOwner();
		if (defenderCreature != null) {
			this.revengeTime = defenderCreature.func_142015_aE();
		}
		super.startExecuting();
	}
}