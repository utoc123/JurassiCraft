package to.uk.ilexiconn.jurassicraft.ai;

import java.util.List;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;

public class JurassiCraftEntityAIEatDroppedFood extends EntityAIBase {

	private EntityJurassiCraftTameable hungryCreature;
	private double searchDistance;
	private double timeTryingToEat;
	private EntityItem droppedFood;

	public JurassiCraftEntityAIEatDroppedFood(EntityJurassiCraftTameable creature, double distance) {
		this.hungryCreature = creature;
		this.searchDistance = distance;
		this.timeTryingToEat = 0;
	}

	@Override
	public boolean isInterruptible() {
		return true;
	}

	@Override
	public boolean shouldExecute() {
		if (this.hungryCreature.getAttackTarget() != null || this.hungryCreature.getRNG().nextInt(100) < 90) {
			return false;
		}
		List nearEntityList = this.hungryCreature.worldObj.getEntitiesWithinAABBExcludingEntity(this.hungryCreature, this.hungryCreature.boundingBox.expand(searchDistance, 8.0D, searchDistance));
		if (!nearEntityList.isEmpty()) {
			for (int i = nearEntityList.size() - 1; i > -1; i--) {
				if (nearEntityList.get(i) instanceof EntityItem && Util.isFavoriteFood(this.hungryCreature.getCreatureID(), ((EntityItem) nearEntityList.get(i)).getEntityItem().getItem())) {
					this.droppedFood = (EntityItem) nearEntityList.get(i);
					this.hungryCreature.getNavigator().tryMoveToXYZ(droppedFood.posX, droppedFood.posY, droppedFood.posZ, this.hungryCreature.getCreatureSpeed());
					return this.droppedFood != (EntityItem) null;
				}
			}
		}
		return false;
	}

	@Override
	public void startExecuting() {
		this.hungryCreature.setSitting(false);
		super.startExecuting();
	}

	@Override
	public void updateTask() {
		if (this.hungryCreature.getNavigator() == null) {
			this.hungryCreature.getNavigator().tryMoveToXYZ(droppedFood.posX, droppedFood.posY, droppedFood.posZ, this.hungryCreature.getCreatureSpeed());
		}
		double distance = Math.sqrt(Math.pow((double) (this.hungryCreature.posX - droppedFood.posX), 2.0D) + Math.pow((double) (this.hungryCreature.posY - droppedFood.posY), 2.0D) + Math.pow((double) (this.hungryCreature.posZ - droppedFood.posZ), 2.0D));
		if (distance < 1.0D) {
			this.droppedFood.setDead();
		} else {
			this.timeTryingToEat++;
		}
	}

	@Override
	public boolean continueExecuting() {
		return (timeTryingToEat < 100 && !this.droppedFood.isDead && !this.hungryCreature.isDead);
	}

	@Override
	public void resetTask() {
		this.hungryCreature.getNavigator().clearPathEntity();
		this.droppedFood = (EntityItem) null;
		this.timeTryingToEat = 0;
	}
}