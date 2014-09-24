package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.data.entity.EntityJurassiCraftCreature;
import to.uk.ilexiconn.jurassicraft.data.entity.EntityJurassiCraftLandProtective;
import to.uk.ilexiconn.jurassicraft.data.utility.ControlledParam;

public class EntityParasaurolophus extends EntityJurassiCraftLandProtective {

	public ControlledParam walkLean = new ControlledParam(0, 0, (float) Math.PI / 2, 0);

	public EntityParasaurolophus(World world) {
		super(world, (byte) 11, 1);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		// tasks.addTask(2, new EntityAIMate(this, 1.0D));
		tasks.addTask(4, new EntityAITempt(this, 5.0D * this.getCreatureSpeed(), Items.wheat, false));
		// tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
		this.tasks.addTask(5, new EntityAIWander(this, 3.5D * this.getCreatureSpeed()));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	@Override
	public double getMountedYOffset() {
		return (double) this.getYBouningBox() * 0.95D;
	}

	@Override
	public int getTalkInterval() {
		return 350;
	}

	public String getLivingSound() {
		this.playSound("jurassicraft:ParaTrumpet01", 8.0F, 1.0F);
		return null;
	}

	public void onUpdate() {
		super.onUpdate();
		if (this.moveForward != 0)
			walkLean.change = 0.1F;
		if (this.moveForward == 0)
			walkLean.change = -0.1F;
		walkLean.update();
	}
}