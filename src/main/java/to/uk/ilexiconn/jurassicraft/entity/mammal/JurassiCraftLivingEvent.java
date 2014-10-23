package to.uk.ilexiconn.jurassicraft.entity.mammal;

import java.lang.reflect.InvocationTargetException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;

public class JurassiCraftLivingEvent
{

	public void onEntityConstructing(EntityConstructing event) 
	{
    	System.out.println("Hello? onEntityConstructing");
		if (event.entity instanceof EntityCow && EntityPregnantCow.get((EntityCow) event.entity) == null) 
		{
			EntityPregnantCow.register((EntityCow) event.entity);
		} else if (event.entity instanceof EntityPig && EntityPregnantPig.get((EntityPig) event.entity) == null) 
		{
			EntityPregnantPig.register((EntityPig) event.entity);
		} else if (event.entity instanceof EntityHorse && EntityPregnantHorse.get((EntityHorse) event.entity) == null) 
		{
			EntityPregnantHorse.register((EntityHorse) event.entity);
		} else if (event.entity instanceof EntitySheep && EntityPregnantSheep.get((EntitySheep) event.entity) == null) 
		{
			EntityPregnantSheep.register((EntitySheep) event.entity);
		}
	}

	public void onEntityLiving(LivingUpdateEvent event) 
	{
    	System.out.println("Hello? onEntityLiving");
		if (event.entityLiving instanceof EntityCow) 
		{
			EntityPregnantCow cow = EntityPregnantCow.get((EntityCow) event.entityLiving);
			if (cow.getMammalName() != "None" || cow.getMammalName() != "" || cow.getMammalName() != null) {
				if (cow.getPregnancyProgress() < cow.getPregnancySpeed())
				{
					cow.increasePregnancyProgress();
					event.entityLiving.onLivingUpdate();
				} 
				else 
				{
					spawnMammalBaby(cow.getMammalName(), cow.getDnaQuality(), cow.getDnaSequence(), event);
					cow.setMammalName("None");
					cow.setDnaQuality(0);
					cow.setDnaSequence("");
					cow.setPregnancyProgress(0);
					cow.setPregnancySpeed(-1);
				}
			}
		} 
		else if (event.entityLiving instanceof EntityPig) 
		{
			EntityPregnantPig pig = EntityPregnantPig.get((EntityPig) event.entityLiving);
			if (pig.getMammalName() != "None" || pig.getMammalName() != "" || pig.getMammalName() != null) {
				if (pig.getPregnancyProgress() < pig.getPregnancySpeed())
				{
					pig.increasePregnancyProgress();
					event.entityLiving.onLivingUpdate();
				} 
				else 
				{
					spawnMammalBaby(pig.getMammalName(), pig.getDnaQuality(), pig.getDnaSequence(), event);
					pig.setMammalName("None");
					pig.setDnaQuality(0);
					pig.setDnaSequence("");
					pig.setPregnancyProgress(0);
					pig.setPregnancySpeed(-1);
				}
			}
		} 
		else if (event.entityLiving instanceof EntityHorse) 
		{
			EntityPregnantHorse horse = EntityPregnantHorse.get((EntityHorse) event.entityLiving);
			if (horse.getMammalName() != "None" || horse.getMammalName() != "" || horse.getMammalName() != null) {
				if (horse.getPregnancyProgress() < horse.getPregnancySpeed())
				{
					horse.increasePregnancyProgress();
					event.entityLiving.onLivingUpdate();
				} 
				else 
				{
					spawnMammalBaby(horse.getMammalName(), horse.getDnaQuality(), horse.getDnaSequence(), event);
					horse.setMammalName("None");
					horse.setDnaQuality(0);
					horse.setDnaSequence("");
					horse.setPregnancyProgress(0);
					horse.setPregnancySpeed(-1);
				}
			}
		} 
		else if (event.entityLiving instanceof EntitySheep) 
		{
			EntityPregnantSheep sheep = EntityPregnantSheep.get((EntitySheep) event.entityLiving);
			if (sheep.getMammalName() != "None" || sheep.getMammalName() != "" || sheep.getMammalName() != null) {
				if (sheep.getPregnancyProgress() < sheep.getPregnancySpeed())
				{
					sheep.increasePregnancyProgress();
					event.entityLiving.onLivingUpdate();
				} 
				else 
				{
					spawnMammalBaby(sheep.getMammalName(), sheep.getDnaQuality(), sheep.getDnaSequence(), event);
					sheep.setMammalName("None");
					sheep.setDnaQuality(0);
					sheep.setDnaSequence("");
					sheep.setPregnancyProgress(0);
					sheep.setPregnancySpeed(-1);
				}
			}
		}
	}

	public void spawnMammalBaby(String mammalName, int quality, String dnaSequence, LivingUpdateEvent event) 
	{
		Class mammalToSpawnClass = Util.getDinoClass(mammalName);
		try 
		{
			Entity mammalToSpawn = (Entity) mammalToSpawnClass.getConstructor(World.class).newInstance(event.entityLiving.worldObj);
			if (mammalToSpawn instanceof EntityJurassiCraftCreature) 
			{
				EntityJurassiCraftCreature baby = (EntityJurassiCraftCreature) mammalToSpawn;
				baby.setGenetics(quality, dnaSequence);
				if (mammalToSpawn instanceof EntityJurassiCraftTameable && ((EntityJurassiCraftTameable) baby).canBeTamedUponSpawning()) 
				{
					EntityPlayer owner = event.entityLiving.worldObj.getClosestPlayerToEntity(event.entityLiving, 6.0F);
					if (owner != null) 
					{
						((EntityJurassiCraftTameable) baby).setTamed(true);
						((EntityJurassiCraftTameable) baby).setOwner(owner.getCommandSenderName());
						event.entityLiving.worldObj.setEntityState((EntityJurassiCraftTameable) baby, (byte) 7);
					}
				}
				baby.setPosition(event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ);
				if (!event.entityLiving.worldObj.isRemote) 
				{
					event.entityLiving.worldObj.spawnEntityInWorld(baby);
				}
			}
		} 
		catch (InstantiationException e) 
		{
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) 
		{
			e.printStackTrace();
		} 
		catch (IllegalArgumentException e) 
		{
			e.printStackTrace();
		} 
		catch (InvocationTargetException e) 
		{
			e.printStackTrace();
		} 
		catch (NoSuchMethodException e) 
		{
			e.printStackTrace();
		} 
		catch (SecurityException e) 
		{
			e.printStackTrace();
		}
	}

}