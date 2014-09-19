package com.rafamv.bygoneage.entity.creatures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;

import com.rafamv.bygoneage.ai.BygoneAgeEntityAIFollowFood;
import com.rafamv.bygoneage.ai.BygoneAgeEntityAITargetIfNonTamed;
import com.rafamv.bygoneage.animation.AIPeck;
import com.rafamv.bygoneage.entity.EntityBygoneAgeLandAggressive;
import com.rafamv.bygoneage.enums.BygoneAgeAnimationIDs;
import com.rafamv.bygoneage.enums.BygoneAgeGeneticsInformation;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;
import com.rafamv.bygoneage.registry.BygoneAgeItems;

public class EntityTitanisWalleri extends EntityBygoneAgeLandAggressive {

	public EntityTitanisWalleri(World world) {
		super(world, BygoneAgeGeneticsInformation.TITANISWALLERI.getCreatureID(), 0.4F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(2, new AIPeck(this));
		this.tasks.addTask(4, new BygoneAgeEntityAIFollowFood(this, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.85F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 12.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(4, new BygoneAgeEntityAITargetIfNonTamed(this, EntityPig.class, 100));
		this.targetTasks.addTask(4, new BygoneAgeEntityAITargetIfNonTamed(this, EntityCow.class, 100));
		this.targetTasks.addTask(4, new BygoneAgeEntityAITargetIfNonTamed(this, EntityLeptictidium.class, 100));
		this.targetTasks.addTask(4, new BygoneAgeEntityAITargetIfNonTamed(this, EntityMoeritherium.class, 100));
	}

	@Override
	public boolean isAIEnabled() {
		return true;
	}

	@Override
	public double getMountedYOffset() {
		return (double) this.getYBouningBox() * 0.9D;
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if (this.rand.nextFloat() <= 0.60F) {
			return super.attackEntityAsMob(entity);
		} else {
			if (animID == 0) {
				AnimationAPI.sendAnimPacket(this, BygoneAgeAnimationIDs.ANIMATION_PECK.getAnimationID());
			}
			return true;
		}
	}

	@Override
	protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
		float developmentFraction = this.getGrowthStage() / BygoneAgeMobsInformation.values()[this.creatureID].getTimesOfGrowth();
		int count = 1 + (int) (4 * developmentFraction) + this.rand.nextInt(2 + (int) (3 * developmentFraction)) + this.rand.nextInt(1 + enchantBonus);
		for (int i = 0; i < count; i++) {
			this.dropItem(Items.feather, 1);
		}
		if (this.isCreatureAdult()) {
			count = 2;
		} else {
			count = this.rand.nextInt(3);
		}
		for (int i = 0; i < count; i++) {
			if (this.isBurning()) {
				this.dropItem(BygoneAgeItems.titanisThighCooked, 1);
			} else {
				this.dropItemStackWithDNA(createDNACodeForItemStack(new ItemStack(BygoneAgeItems.titanisThighRaw, 1)));
			}
		}
	}
}
