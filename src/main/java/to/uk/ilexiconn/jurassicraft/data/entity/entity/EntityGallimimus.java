package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.data.entity.EntityJurassiCraftLandProtective;
import to.uk.ilexiconn.jurassicraft.data.entity.IDinosaur;

public class EntityGallimimus extends EntityJurassiCraftLandProtective implements IDinosaur {

	public EntityGallimimus(World world) {
		super(world, (byte) 7, 2);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		// tasks.addTask(2, new EntityAIMate(this, 1.0D));
		tasks.addTask(4, new EntityAITempt(this, 1.1D * this.getCreatureSpeed(), Items.wheat, false));
		// tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
		this.tasks.addTask(5, new EntityAIAvoidEntity(this, EntityTyrannosaurus.class, 12.0F, this.getCreatureSpeed(), 1.2D * this.getCreatureSpeed()));
		this.tasks.addTask(6, new EntityAIWander(this, 0.6D * this.getCreatureSpeed()));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
	}

	@Override
	public double getMountedYOffset() {
		return (double) this.getYBouningBox() * 0.7D;
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