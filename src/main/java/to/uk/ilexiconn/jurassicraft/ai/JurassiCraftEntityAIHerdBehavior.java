package to.uk.ilexiconn.jurassicraft.ai;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;

public class JurassiCraftEntityAIHerdBehavior extends EntityAIBase {

	private EntityJurassiCraftTameable lostCreature;
	private EntityJurassiCraftTameable herdCreature;
	private double lostCreatureOldFollowRange;
	private double maxTimeTryingToMove;
	private double searchDistance;
	private double distanceToHerd;
	private double maxDistanceToHerd;
	private double movementSpeed;
	private int timeTryingToMove;

	public JurassiCraftEntityAIHerdBehavior(EntityJurassiCraftTameable creature, double distance, int maxNumberOfTicksTrying, double distanceToConsiderHerd, double speed) {
		this.lostCreature = creature;
		this.searchDistance = distance;
		this.maxTimeTryingToMove = maxNumberOfTicksTrying;
		this.maxDistanceToHerd = distanceToConsiderHerd;
		this.movementSpeed = speed;
		this.timeTryingToMove = 0;
        this.setMutexBits(3);
	}

	@Override
	public boolean isInterruptible() {
		return true;
	}

	@Override
	public boolean shouldExecute() {
		if (this.lostCreature.getAttackTarget() != null || this.lostCreature.getRNG().nextInt(350) < 349) {
			return false;
		}
		ArrayList<EntityJurassiCraftTameable> nearCreaturesList = new ArrayList<EntityJurassiCraftTameable>();
		List<Entity> nearEntityList = this.lostCreature.worldObj.getEntitiesWithinAABBExcludingEntity(this.lostCreature, this.lostCreature.boundingBox.expand(this.searchDistance, 8.0D, this.searchDistance));
		if (!nearEntityList.isEmpty()) {
			for (int i = nearEntityList.size() - 1; i > -1; i--) {
				if (nearEntityList.get(i) instanceof EntityJurassiCraftTameable && nearEntityList.get(i).getClass() == lostCreature.getClass() && ((EntityJurassiCraftTameable) nearEntityList.get(i)).getUniqueID() != lostCreature.getUniqueID()) {
					nearCreaturesList.add((EntityJurassiCraftTameable) nearEntityList.get(i));
				}
			}
			if (nearCreaturesList.size() > 1) {
				double minDistance = this.searchDistance + 1;
				for (int j = 0; j < nearCreaturesList.size(); j++) {
					double distance = nearCreaturesList.get(j).getDistanceToEntity(this.lostCreature);
					if (distance < minDistance) {
						if (distance < this.maxDistanceToHerd && this.lostCreature.getRNG().nextInt(50) < 100) {
							this.herdCreature = nearCreaturesList.get(j);
							this.distanceToHerd = this.lostCreature.getDistanceToEntity(herdCreature);
							return this.lostCreature.isEntityAlive() && this.herdCreature.isEntityAlive() && !this.lostCreature.isSitting() && this.distanceToHerd > this.maxDistanceToHerd;
						} else {
							minDistance = distance;
							this.herdCreature = nearCreaturesList.get(j);
						}
					}
				}
			} else {
				this.herdCreature = nearCreaturesList.get(0);
			}
			this.distanceToHerd = this.lostCreature.getDistanceToEntity(herdCreature);
			return this.lostCreature.isEntityAlive() && this.herdCreature.isEntityAlive() && !this.lostCreature.isSitting() && this.distanceToHerd > this.maxDistanceToHerd;
		}
		return false;
	}

	@Override
	public void startExecuting() {
		System.out.println("Herd Behavior Started!");
		this.lostCreatureOldFollowRange = this.lostCreature.getEntityAttribute(SharedMonsterAttributes.followRange).getAttributeValue();
		this.lostCreature.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(this.searchDistance);
		this.lostCreature.getNavigator().tryMoveToEntityLiving(this.herdCreature, this.movementSpeed);
		super.startExecuting();
	}

	@Override
	public void updateTask() {
		if (this.timeTryingToMove == this.maxTimeTryingToMove / 2.0D || this.timeTryingToMove == this.maxTimeTryingToMove / 4.0D || this.timeTryingToMove == 3.0D * this.maxTimeTryingToMove / 4.0D) {
			this.lostCreature.getNavigator().tryMoveToEntityLiving(this.herdCreature, this.movementSpeed);
		}
		this.lostCreature.getDistanceSqToEntity(herdCreature);
		this.timeTryingToMove++;
	}

	@Override
	public boolean continueExecuting() {
		return (!this.lostCreature.getNavigator().noPath() && this.timeTryingToMove < this.maxTimeTryingToMove / 2.0D && this.distanceToHerd > this.maxDistanceToHerd && this.lostCreature.isEntityAlive() && this.herdCreature.isEntityAlive());
	}

	@Override
	public void resetTask() {
		this.lostCreature.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(this.lostCreatureOldFollowRange);
		this.lostCreature.getNavigator().clearPathEntity();
		this.herdCreature = (EntityJurassiCraftTameable) null;
		this.timeTryingToMove = 0;
	}
}