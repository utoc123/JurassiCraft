package to.uk.ilexiconn.jurassicraft.data.entity;

import to.uk.ilexiconn.jurassicraft.Util;
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
		Dinosaur dinoByID = Util.getDinoByID(id);
		setSize(dinoByID.hitboxSizeXZ, dinoByID.hitboxSizeY);
		getNavigator().setAvoidsWater(true);
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		Dinosaur dinoByID = Util.getDinoByID(dinoID);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(dinoByID.dinoHealth * 2);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(dinoByID.dinoSpeed);
	}

	public String getLivingSound()
	{
		int I = rand.nextInt(1)+1;
		Dinosaur dinoByID = Util.getDinoByID(dinoID);
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
		Dinosaur dinoByID = Util.getDinoByID(dinoID);
		return dinoByID.hurtSound;
	}

	public String getDeathSound()
	{
		Dinosaur dinoByID = Util.getDinoByID(dinoID);
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
		return Util.getMeat(dinoID);
	}

	public void onUpdate()
	{
		super.onUpdate();
		if(animID != 0) animTick++;
		frame++;
	}
}
