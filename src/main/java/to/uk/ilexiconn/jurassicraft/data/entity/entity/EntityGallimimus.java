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
import to.uk.ilexiconn.jurassicraft.data.entity.EntityJurassiCraftLandProtective;

public class EntityGallimimus extends EntityJurassiCraftLandProtective {

	public EntityGallimimus(World world) {
		super(world, (byte) 7, 2);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		// tasks.addTask(2, new EntityAIMate(this, 1.0D));
		tasks.addTask(4, new EntityAITempt(this, 6.0D * this.getCreatureSpeed(), Items.wheat, false));
		// tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
		this.tasks.addTask(5, new EntityAIAvoidEntity(this, EntityTyrannosaurus.class, 16.0F, 5.5D * this.getCreatureSpeed(), 6.5D * this.getCreatureSpeed()));
		this.tasks.addTask(6, new EntityAIWander(this, 3.5D * this.getCreatureSpeed()));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
	}

	@Override
	public double getMountedYOffset() {
		return (double) this.getYBouningBox() * 0.95D;
	}

	@Override
	public int getTalkInterval() {
		return 350;
	}
}