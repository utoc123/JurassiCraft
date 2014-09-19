package com.rafamv.bygoneage.entity.creatures;

import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

import com.rafamv.bygoneage.ai.BygoneAgeEntityAIFollowFood;
import com.rafamv.bygoneage.animation.AIBite;
import com.rafamv.bygoneage.entity.test.EntityBygoneAgeFlyingCreatureBestResultSoFar;
import com.rafamv.bygoneage.enums.BygoneAgeGeneticsInformation;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;

public class EntityMoeritherium extends EntityBygoneAgeFlyingCreatureBestResultSoFar {

	public EntityMoeritherium(World world) {
		super(world, BygoneAgeGeneticsInformation.MOERITHERIUM.getCreatureID(), 0.4F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		//this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityTitanisWalleri.class, 8.0F, 0.8D, 1.1D));
		this.tasks.addTask(2, new AIBite(this));
		this.tasks.addTask(4, new BygoneAgeEntityAIFollowFood(this, 1.1D, false));
		//this.tasks.addTask(5, new EntityAIWander(this, 0.8F));
		//this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		//this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	@Override
	public double getMountedYOffset() {
		return (double) this.getYBouningBox() * 0.85D;
	}

	@Override
	protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
		float developmentFraction = this.getGrowthStage() / BygoneAgeMobsInformation.values()[this.creatureID].getTimesOfGrowth();
		int count = 1 + (int) (1 * developmentFraction) + this.rand.nextInt(2 + (int) (1 * developmentFraction)) + this.rand.nextInt(1 + enchantBonus);
		for (int i = 0; i < count; i++) {
			if (this.isBurning()) {
				this.dropItem(Items.cooked_beef, 1);
			} else {
				this.dropItem(Items.beef, 1);
			}
		}
	}
}
