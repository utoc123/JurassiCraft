package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import to.uk.ilexiconn.jurassicraft.data.animation.AITyrannosaurusRoar;
import to.uk.ilexiconn.jurassicraft.data.entity.EntityDinosaurCreature;
import to.uk.ilexiconn.jurassicraft.data.entity.EntityJurassiCraftCreature;
import to.uk.ilexiconn.jurassicraft.data.utility.ControlledParam;

public class EntityTyrannosaurus extends EntityJurassiCraftCreature {

	private int stepCount = 0;
	private float shakeCount = 0;
	public ControlledParam roarCount = new ControlledParam(0F, 0F, 0.5F, 0F);
	public ControlledParam roarTiltDegree = new ControlledParam(0F, 0F, 1F, 0F);

	public EntityTyrannosaurus(World world) {
		super(world, (byte) 6);
		tasks.addTask(2, new AITyrannosaurusRoar(this));		
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.getCreatureSpeed() + 1.2D, false));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityDinosaurCreature.class, this.getCreatureSpeed() + 1.0D, true));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed() + 1.0D));
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAITempt(this, 1.5D * this.getCreatureSpeed() + 1.0D, Items.beef, false));
		this.tasks.addTask(0, new EntityAIWander(this, this.getCreatureSpeed() + 0.6D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityDinosaurCreature.class, 0, false));
	}

	public String getLivingSound() {
		// if(isRoaring == false){
		// isRoaring = true;
		int I = rand.nextInt(3) + 1;
		if (I == 1) {
			this.playSound("jurassicraft:trex1", 5.0F, 1.0F);
			if (animID == 0 && this.getAttackTarget() == null) {
				AnimationAPI.sendAnimPacket(this, 1);
			}
			/*
			 * else if(this.getAttackTarget() != null) {
			 * roarCount.thereAndBack(0F, 0.1F, 1, 40);
			 * System.out.println(roarCount.change); }
			 */
			return null;
		} else if (I == 2) {
			this.playSound("jurassicraft:trex2", 5.0F, 1.0F);
			return null;
		} else {
			return null;
		}
		// }
		// return null;
	}

	public String getHurtSound() {
		this.playSound("jurassicraft:trex3", 5.0F, 1.0F);
		return null;
	}

	public String getDeathSound() {
		this.playSound("jurassicraft:trex3", 5.0F, 1.0F);
		return null;
	}

	public void onUpdate() {
		super.onUpdate();
		roarCount.update();
		roarTiltDegree.update();
		if (animID == 1 && animTick == 22)
			this.roarTiltDegree.thereAndBack(0F, 0.1F, 1F, 20);
	}
}
