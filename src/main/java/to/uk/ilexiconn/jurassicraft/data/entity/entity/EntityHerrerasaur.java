package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import net.minecraft.entity.EntityAgeable;
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
import to.uk.ilexiconn.jurassicraft.data.entity.EntityJurassiCraftCreature;

public class EntityHerrerasaur extends EntityJurassiCraftCreature {

	public EntityHerrerasaur(World par1World) {
		super(par1World, (byte) 10);
		this.setSize(5F, 6F);
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.getCreatureSpeed() + 1.2, false));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityHypsilophodon.class, this.getCreatureSpeed() + 1.0, true));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityLeaellynasaur.class, this.getCreatureSpeed() + 1.0, true));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed() + 1.0));
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 2.0*this.getCreatureSpeed() + 1.5));
		this.tasks.addTask(3, new EntityAITempt(this, 1.25 * this.getCreatureSpeed() + 1.2, Items.beef, false));
		this.tasks.addTask(0, new EntityAIWander(this, this.getCreatureSpeed() + 1.0));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityHypsilophodon.class, 0, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLeaellynasaur.class, 0, false));
		this.experienceValue = 300;
	}

	public void onLivingUpdate() {
		super.onLivingUpdate();
	}

	public EntityHerrerasaur spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
		return new EntityHerrerasaur(this.worldObj);
	}
}
