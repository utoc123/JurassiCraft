package to.uk.ilexiconn.jurassicraft.data.entity;

import to.uk.ilexiconn.jurassicraft.DinoEntry;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public abstract class EntityDinosaurCreature extends EntityAnimal implements IAnimatedEntity
{
	public int animID;
	public int animTick;
	public int dinoID;

	public int frame;

	public EntityDinosaurCreature(World world, int id)
	{
		super(world);
		dinoID = id;
		Dinosaur dinoByID = DinoEntry.getDinoByID(id);
		setSize(dinoByID.xzHitbox, dinoByID.yHitbox);
		getNavigator().setAvoidsWater(true);
        setHealth((float) dinoByID.health);
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		Dinosaur dinoByID = DinoEntry.getDinoByID(dinoID);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(dinoByID.health);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(dinoByID.speed);
	}

	public String getLivingSound()
	{
		int I = rand.nextInt(1)+1;
		Dinosaur dinoByID = DinoEntry.getDinoByID(dinoID);
		if(I == 1)
		{
			return dinoByID.livingSound1;
		}
		else
		{
			return dinoByID.livingSound2;
		}
	}

	public String getHurtSound()
	{
		Dinosaur dinoByID = DinoEntry.getDinoByID(dinoID);
		return dinoByID.hurtSound;
	}

	public String getDeathSound()
	{
		Dinosaur dinoByID = DinoEntry.getDinoByID(dinoID);
		return dinoByID.deathSound;
	}

	public float getSoundVolume()
	{
		return 0.4F;
	}

	public boolean canDespawn()
	{
		return false;
	}

	public int getAnimTick()
	{
		return animTick;
	}

	public int getAnimID()
	{
		return animID;
	}

	public void setAnimID(int id)
	{
		animID = id;
	}

	public void setAnimTick(int tick)
	{
		animTick = tick;
	}

	public Item getDropItem()
	{
		return DinoEntry.getMeat(dinoID);
	}

	public void onUpdate()
	{
		super.onUpdate();
		if(animID != 0) animTick++;
		frame++;
	}
}
