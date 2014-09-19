package com.rafamv.bygoneage.entity.creatures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.ai.BygoneAgeEntityAIFollowFood;
import com.rafamv.bygoneage.animation.AIHeadbutt;
import com.rafamv.bygoneage.entity.EntityBygoneAgeLandProtective;
import com.rafamv.bygoneage.enums.BygoneAgeAnimationIDs;
import com.rafamv.bygoneage.enums.BygoneAgeGeneticsInformation;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;

public class EntityParaceratherium extends EntityBygoneAgeLandProtective {

	public EntityParaceratherium(World world) {
		///////////////////////////////////////////    \/
		super(world, BygoneAgeGeneticsInformation.DEINOTHERIUM.getCreatureID(), 1, 0.35F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(2, new AIHeadbutt(this));
		this.tasks.addTask(4, new BygoneAgeEntityAIFollowFood(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.7F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityParaceratherium.class, 12.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	@Override
	public double getMountedYOffset() {
		return (double) this.getYBouningBox() * 0.95D;
	}

	@Override
	protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
		float developmentFraction = this.getGrowthStage() / BygoneAgeMobsInformation.values()[this.creatureID].getTimesOfGrowth();
		int count = (int) (2 * developmentFraction) + this.rand.nextInt(2 + (int) (2 * developmentFraction)) + this.rand.nextInt(1 + enchantBonus);
		for (int k = 0; k < count; ++k) {
			this.dropItem(Items.leather, 1);
		}
		count = 1 + (int) (3 * developmentFraction) + this.rand.nextInt(2 + (int) (3 * developmentFraction)) + this.rand.nextInt(1 + enchantBonus);
		for (int i = 0; i < count; i++) {
			if (this.isBurning()) {
				this.dropItem(Items.cooked_beef, 1);
			} else {
				this.dropItem(Items.beef, 1);
			}
		}
	}
}
