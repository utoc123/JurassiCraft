package com.rafamv.bygoneage.entity.creatures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.ai.BygoneAgeEntityAIFollowFood;
import com.rafamv.bygoneage.animation.AIBite;
import com.rafamv.bygoneage.entity.EntityBygoneAgeLandProtective;
import com.rafamv.bygoneage.enums.BygoneAgeAnimationIDs;
import com.rafamv.bygoneage.enums.BygoneAgeGeneticsInformation;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;
import com.rafamv.bygoneage.registry.BygoneAgeItems;

public class EntityLeptictidium extends EntityBygoneAgeLandProtective {

	public EntityLeptictidium(World world) {
		super(world, BygoneAgeGeneticsInformation.LEPTICTIDIUM.getCreatureID(), 3, 0.4F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityTitanisWalleri.class, 8.0F, 0.8D, 1.1D));
		this.tasks.addTask(2, new AIBite(this));
		this.tasks.addTask(4, new BygoneAgeEntityAIFollowFood(this, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	@Override
	public void playLivingSound() {
		if (!this.isPanicking()) {
			this.playSound(BygoneAge.MODID + ":" + "creature.leptictidium.say", this.getSoundVolume(), this.getSoundPitch());
		} else {
			this.playSound(BygoneAge.MODID + ":" + "creature.leptictidium.panic", this.getSoundVolume(), this.getSoundPitch());
		}
	}

	@Override
	public String getHurtSound() {
		if (!this.isPanicking()) {
			this.playSound(BygoneAge.MODID + ":" + "creature.leptictidium.hit", this.getSoundVolume(), this.getSoundPitch());
		}
		return null;
	}

	@Override
	public String getDeathSound() {
		this.playSound(BygoneAge.MODID + ":" + "creature.leptictidium.death", this.getSoundVolume(), this.getSoundPitch());
		return null;
	}

	@Override
	public float getSoundVolume() {
		return 1.0F;
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if (this.rand.nextFloat() <= 0.20F) {
			return super.attackEntityAsMob(entity);
		} else {
			if (animID == 0) {
				AnimationAPI.sendAnimPacket(this, BygoneAgeAnimationIDs.ANIMATION_BITE.getAnimationID());
			}
			return true;
		}
	}

	@Override
	protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
		float developmentFraction = this.getGrowthStage() / BygoneAgeMobsInformation.values()[this.creatureID].getTimesOfGrowth();
		int count = (int) (2 * developmentFraction) + this.rand.nextInt(2 + (int) (1 * developmentFraction)) + this.rand.nextInt(1 + enchantBonus);
		for (int i = 0; i < count; i++) {
			this.dropItemStackWithDNA(createDNACodeForItemStack(new ItemStack(BygoneAgeItems.leptictidiumHide, 1)));
		}
	}

}
