package com.rafamv.bygoneage.animation;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import thehippomaster.AnimationAPI.AIAnimation;

import com.rafamv.bygoneage.entity.EntityBygoneAgeAnimated;
import com.rafamv.bygoneage.enums.BygoneAgeAnimationIDs;

public class AIPeck extends AIAnimation {

	private EntityBygoneAgeAnimated attacker;
	private EntityLivingBase attackTarget;

	public AIPeck(EntityBygoneAgeAnimated mobEntity) {
		super(mobEntity);
		attacker = mobEntity;
		attackTarget = null;
	}

	@Override
	public int getAnimID() {
		return BygoneAgeAnimationIDs.ANIMATION_PECK.getAnimationID();
	}

	@Override
	public boolean isAutomatic() {
		return true;
	}

	@Override
	public int getDuration() {
		return 15;
	}

	@Override
	public void startExecuting() {
		super.startExecuting();
		attackTarget = attacker.getAttackTarget();
	}

	@Override
	public void updateTask() {
		if (attacker.getAnimTick() == 8 && attackTarget != null) {
			attackTarget.attackEntityFrom(DamageSource.causeMobDamage(attacker), (float) ((1.0F + 0.6F * this.attacker.worldObj.rand.nextFloat()) * attacker.getCreatureAttack()));
		}
	}

}