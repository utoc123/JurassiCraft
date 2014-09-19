package com.rafamv.bygoneage.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

import com.rafamv.bygoneage.entity.EntityBygoneAgeTameable;

public class BygoneAgeEntityAIOwnerHurtTarget extends EntityAITarget {
	EntityBygoneAgeTameable tameableCreature;
	EntityLivingBase target;
	private int revengeTime;

	public BygoneAgeEntityAIOwnerHurtTarget(EntityBygoneAgeTameable entityTameable) {
		super(entityTameable, false);
		this.tameableCreature = entityTameable;
		this.setMutexBits(1);
	}

	@Override
	public boolean shouldExecute() {
		if (!this.tameableCreature.isTamed()) {
			return false;
		} else {
			EntityLivingBase entitylivingbase = this.tameableCreature.getOwner();
			if (entitylivingbase == null) {
				return false;
			} else {
				this.target = entitylivingbase.getLastAttacker();
				if (this.tameableCreature.checkTarget(this.target)) {
					int i = entitylivingbase.getLastAttackerTime();
					return i != this.revengeTime && this.isSuitableTarget(this.target, false);
				} else {
					return false;
				}
			}
		}
	}

	@Override
	public void startExecuting() {
		this.taskOwner.setAttackTarget(this.target);
		EntityLivingBase entitylivingbase = this.tameableCreature.getOwner();
		if (entitylivingbase != null) {
			this.revengeTime = entitylivingbase.getLastAttackerTime();
		}
		super.startExecuting();
	}
}