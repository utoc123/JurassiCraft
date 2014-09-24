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

public class EntityHypsilophodon extends EntityJurassiCraftLandProtective {

	public EntityHypsilophodon(World world) {
		super(world, (byte) 8, 2);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		// tasks.addTask(2, new EntityAIMate(this, 1.0D));
		tasks.addTask(3, new EntityAITempt(this, 5.5D * this.getCreatureSpeed(), Items.wheat, false));
		this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityVelociraptor.class, 16.0F, 5.0D * this.getCreatureSpeed(), 6.0D * this.getCreatureSpeed()));
		// tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
		this.tasks.addTask(5, new EntityAIWander(this, 3.5D * this.getCreatureSpeed()));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	@Override
	public int getTalkInterval() {
		return 350;
	}
}