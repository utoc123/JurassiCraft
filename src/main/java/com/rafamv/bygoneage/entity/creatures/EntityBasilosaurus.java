package com.rafamv.bygoneage.entity.creatures;

import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.rafamv.bygoneage.ai.BygoneAgeEntityAIFollowFood;
import com.rafamv.bygoneage.ai.BygoneAgeEntityAITargetIfNonTamed;
import com.rafamv.bygoneage.animation.AIPeck;
import com.rafamv.bygoneage.entity.EntityBygoneAgeWaterAggressive;
import com.rafamv.bygoneage.enums.BygoneAgeGeneticsInformation;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;
import com.rafamv.bygoneage.registry.BygoneAgeItems;

public class EntityBasilosaurus extends EntityBygoneAgeWaterAggressive {

	public EntityBasilosaurus(World world) {
		super(world, BygoneAgeGeneticsInformation.BASILOSAURUS.getCreatureID(), 0.25F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(2, new AIPeck(this));
		this.tasks.addTask(4, new BygoneAgeEntityAIFollowFood(this, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.3F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(4, new BygoneAgeEntityAITargetIfNonTamed(this, EntitySquid.class, 0));
	}

	@Override
	protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
		float developmentFraction = this.getGrowthStage() / BygoneAgeMobsInformation.values()[this.creatureID].getTimesOfGrowth();
		int count = 1 + (int) (3 * developmentFraction) + this.rand.nextInt(2 + (int) (5 * developmentFraction)) + this.rand.nextInt(1 + enchantBonus);
		for (int i = 0; i < count; i++) {
			if (this.isBurning()) {
				this.dropItem(BygoneAgeItems.basilosaurusMeatCooked, 1);
			} else {
				this.dropItemStackWithDNA(createDNACodeForItemStack(new ItemStack(BygoneAgeItems.basilosaurusMeatRaw, 1)));
			}
		}
	}
}
