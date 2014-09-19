package com.rafamv.bygoneage.animation;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import thehippomaster.AnimationAPI.AIAnimation;

import com.rafamv.bygoneage.entity.EntityBygoneAgeAnimated;
import com.rafamv.bygoneage.enums.BygoneAgeAnimationIDs;

public class AIBite extends AIAnimation {

	private Random random;
	private EntityBygoneAgeAnimated attacker;
	private EntityLivingBase attackTarget;

	public AIBite(EntityBygoneAgeAnimated mobEntity) {
		super(mobEntity);
		attacker = mobEntity;
		attackTarget = null;
		random = new Random();
	}

	@Override
	public int getAnimID() {
		return BygoneAgeAnimationIDs.ANIMATION_BITE.getAnimationID();
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
		if (attacker.getAnimTick() == 11 && attackTarget != null) {
			attackTarget.attackEntityFrom(DamageSource.causeMobDamage(attacker), (float) ((1.0F + this.random.nextFloat()) * attacker.getCreatureAttack()));
		}
	}

}