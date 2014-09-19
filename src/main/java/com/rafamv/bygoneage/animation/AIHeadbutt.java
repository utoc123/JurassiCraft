package com.rafamv.bygoneage.animation;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import thehippomaster.AnimationAPI.AIAnimation;

import com.rafamv.bygoneage.entity.EntityBygoneAgeAnimated;
import com.rafamv.bygoneage.enums.BygoneAgeAnimationIDs;

public class AIHeadbutt extends AIAnimation {

	private Random random;
	private EntityBygoneAgeAnimated attacker;
	private EntityLivingBase attackTarget;

	public AIHeadbutt(EntityBygoneAgeAnimated mobEntity) {
		super(mobEntity);
		attacker = mobEntity;
		attackTarget = null;
		random = new Random();
	}

	@Override
	public int getAnimID() {
		return BygoneAgeAnimationIDs.ANIMATION_HEADBUTT.getAnimationID();
	}

	@Override
	public boolean isAutomatic() {
		return true;
	}

	@Override
	public int getDuration() {
		return 50;
	}

	@Override
	public void startExecuting() {
		super.startExecuting();
		attackTarget = attacker.getAttackTarget();
	}

	@Override
	public void updateTask() {
		if (attacker.getAnimTick() == 8 && attackTarget != null) {
			double d0 = (this.attacker.boundingBox.minX + this.attacker.boundingBox.maxX) / 2.0D;
			double d1 = (this.attacker.boundingBox.minZ + this.attacker.boundingBox.maxZ) / 2.0D;
			double d2 = attackTarget.posX - d0;
			double d3 = attackTarget.posZ - d1;
			double d4 = d2 * d2 + d3 * d3;
			attackTarget.addVelocity(d2 / d4 * 4.0D, 0.40000000516046448D, d3 / d4 * 4.0D);
			attackTarget.attackEntityFrom(DamageSource.causeMobDamage(attacker), (float) ((1.0F + this.random.nextFloat()) * attacker.getCreatureAttack()));
		}
	}

}