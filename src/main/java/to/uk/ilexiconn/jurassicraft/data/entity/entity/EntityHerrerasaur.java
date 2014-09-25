package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.data.ai.JurassiCraftEntityAITargetIfNonTamed;
import to.uk.ilexiconn.jurassicraft.data.entity.EntityJurassiCraftLandAggressive;
import to.uk.ilexiconn.jurassicraft.data.entity.IDinosaur;

public class EntityHerrerasaur extends EntityJurassiCraftLandAggressive implements IDinosaur {

	public EntityHerrerasaur(World par1World) {
		super(par1World, (byte) 10);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 0.7D * this.getCreatureSpeed()));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
		this.tasks.addTask(5, new EntityAITempt(this, 1.1D * this.getCreatureSpeed(), Items.beef, false));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(5, new JurassiCraftEntityAITargetIfNonTamed(this, EntityHypsilophodon.class, 0));
		this.targetTasks.addTask(5, new JurassiCraftEntityAITargetIfNonTamed(this, EntityLeaellynasaur.class, 0));
	}

	@Override
	public int getTalkInterval() {
		return 350;
	}

	@Override
	public String getLivingSound() {
		if (this.rand.nextInt(2) == 0) {
			return Util.getDinoByID(this.getCreatureID()).livingSound1;
		} else {
			return Util.getDinoByID(this.getCreatureID()).livingSound2;
		}
	}

	@Override
	public String getHurtSound() {
		return Util.getDinoByID(this.getCreatureID()).hurtSound;
	}

	@Override
	public String getDeathSound() {
		return Util.getDinoByID(this.getCreatureID()).deathSound;
	}
}
